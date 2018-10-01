package com.hpu.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hpu.admin.entity.Menu;
import com.hpu.admin.entity.vo.ShowMenuVo;

import java.util.List;

/**
 * Created by zhangyuguang on 2018/10/1.
 */
public interface MenuService extends IService<Menu> {

    List<ShowMenuVo> getShowMenuByUser(String userId);

}
