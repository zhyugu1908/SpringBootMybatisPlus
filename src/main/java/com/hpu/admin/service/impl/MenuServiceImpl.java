package com.hpu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hpu.admin.entity.Menu;
import com.hpu.admin.entity.vo.ShowMenuVo;
import com.hpu.admin.mapper.MenuMapper;
import com.hpu.admin.service.MenuService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuguang on 2018/10/1.
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService {
    @Override
    public List<ShowMenuVo> getShowMenuByUser(String userId) {
        Map<String,Object> map = new HashedMap();
        map.put("userId",userId);
        map.put("parentId",null);

        return baseMapper.selectShowMenuByUser(map);
    }
}
