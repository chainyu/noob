package com.chainyu.noob.dao.auth;

import com.chainyu.noob.model.auth.domain.Menu;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    Menu selectById(@Param("id")Long id);
    
    int deleteById(@Param("id")Long id);
    
    int save(Menu menu);

    int updateByIdSelective(Menu menu);

}