package com.chainyu.noob.dao.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chainyu.noob.dao.BaseMapper;
import com.chainyu.noob.model.auth.domain.RolePrivilege;


public interface RolePrivilegeMapper extends BaseMapper<RolePrivilege, Long>{

	List<RolePrivilege> findByPrivilegeId(@Param("privilegeId")Long privilegeId);

}