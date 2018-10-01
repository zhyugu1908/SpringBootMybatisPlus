package com.hpu.admin.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.hpu.admin.common.realm.AuthRealm;
import com.hpu.admin.common.util.Constants;
import com.hpu.admin.service.MenuService;
import com.hpu.admin.service.SysUserService;
import freemarker.ext.beans.MapModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by zhangyuguang on 2018/10/1.
 */
@Controller
public class LoginController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private final static  String LOGIN_TYPE = "loginType" ;

    @Autowired
    @Qualifier("captchaProducer")
    DefaultKaptcha captchaProducer;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    MenuService menuService;

    public enum LoginTpyeEnum{
        PAGE, ADMIN;
    }
    /* 访问127.0.0.1:8088 跳转到这里
    * */
   @GetMapping(value = "")
    public String welcome(){
        return "redirect:admin";
   }

   @GetMapping(value ={"admin","admin/index"})
    public String adminIndex(RedirectAttributes attributes , MapModel model){
      Subject subject = SecurityUtils.getSubject();
      attributes.addFlashAttribute(LOGIN_TYPE,LoginTpyeEnum.ADMIN);
      if (subject.isAuthenticated()){
          return "redirect:index";
      }else {
          return  "redirect:toLogin";
      }
   }

   @GetMapping(value = "toLogin")
    public String adminLogin(HttpSession session , @ModelAttribute(LOGIN_TYPE) String loginType){
        if(StringUtils.isBlank(loginType)){
            LoginTpyeEnum attribute = (LoginTpyeEnum)session.getAttribute(LOGIN_TYPE);
            loginType= attribute == null?loginType:attribute.name();
        }
        if (LoginTpyeEnum.ADMIN.name().equals(loginType)){
            session.setAttribute(LOGIN_TYPE,LoginTpyeEnum.ADMIN);
            return "admin/login";
        }else {
            session.setAttribute(LOGIN_TYPE,LoginTpyeEnum.PAGE);
            return "login";

            /*  使用thymeleaf 默认文件templates
            * */
        }
   }
//Error resolving template "admin/login", template might not exist or might not be accessible by any of the configured Template Resolvers

    @GetMapping(value = "index")
    public String index(HttpSession session , @ModelAttribute(LOGIN_TYPE) String loginType){
        if(StringUtils.isBlank(loginType)){
            LoginTpyeEnum attribute = (LoginTpyeEnum) session.getAttribute(LOGIN_TYPE);
            loginType =attribute == null?loginType:attribute.name();
        }
        if (LoginTpyeEnum.ADMIN.name().equals(loginType)){
            AuthRealm.ShiroUser principal = (AuthRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
            session.setAttribute("icon",StringUtils.isBlank(principal.getIcon())?"/static/admin/img/face.jpg":principal.getIcon());
           return "admin/index";
        }else {
            return "index";
        }
    }

    @GetMapping("/getCaptcha")
    public void getCatcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //设置页面缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        String verifyCode = captchaProducer.createText();
        //将验证码放到HTTPSession里面
        request.getSession().setAttribute(Constants.VALIDATE_CODE,verifyCode);
        LOGGER.info("本次生成的验证码["+verifyCode+"],以存放到HttpSession中");
        //设置输出内容类型为JPEG图像
        response.setContentType("image/JPEG");
        BufferedImage bufferedImage = captchaProducer.createImage(verifyCode);
        //输出到浏览器
        ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());

    }

}
