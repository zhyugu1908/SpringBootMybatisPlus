package com.hpu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hpu.admin.entity.Menu;
import com.hpu.admin.mapper.MenuMapper;
import com.hpu.admin.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyuguang on 2018/10/1.
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService {
}
