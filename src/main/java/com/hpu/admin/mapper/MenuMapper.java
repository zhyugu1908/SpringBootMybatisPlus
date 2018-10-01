package com.hpu.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hpu.admin.entity.Menu;
import com.hpu.admin.entity.vo.ShowMenuVo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuguang on 2018/10/1.
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<ShowMenuVo>  selectShowMenuByUser(Map<String,Object> map);
}
