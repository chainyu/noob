delete from t_au_privilege; 
delete from t_au_privilege_url;
 truncate t_au_privilege;
 truncate t_au_privilege_url;

--               用户权限             --
-- 用户管理
insert into t_au_privilege (code,name,status,create_time)
		values('user_manage','用户管理',1,now());
insert into t_au_privilege_url(privilege_id,url,status,create_time)
		values(last_insert_id(),'/user/userManage.htm',1,now()),
					(last_insert_id(),'/user/**',1,now());

-- 角色管理
insert into t_au_privilege (code,name,status,create_time)
		values('role_manage','角色管理',1,now());
insert into t_au_privilege_url(privilege_id,url,status,create_time)
		values(last_insert_id(),'/role/roleManage.htm',1,now()),
					(last_insert_id(),'/role/**',1,now());

-- 角色权限设置
insert into t_au_privilege (code,name,status,create_time)
		values('role_privilege_manage','角色权限设置',1,now());
insert into t_au_privilege_url(privilege_id,url,status,create_time)
		values(last_insert_id(),'/rolePrivilege/rolePrivilegeManage.htm',1,now()),
					(last_insert_id(),'/rolePrivilege/**',1,now());

-- 分配用户角色
insert into t_au_privilege (code,name,status,create_time)
		values('user_role_manage','分配用户角色',1,now());
insert into t_au_privilege_url(privilege_id,url,status,create_time)
		values(last_insert_id(),'/userRole/userRoleManage.htm',1,now()),
					(last_insert_id(),'/userRole/**',1,now());


					
-- 以下，不受菜单制约的访问资源
-- 主页
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/index.htm',1,now());

-- 无访问权限页
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/access-denied.htm',1,now());

-- 校验现有密码(ajax)
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/checkCurrentPassword.json',1,now());

-- 修改密码(ajax)
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/modifyPwd.json',1,now());

-- 个人资料修改(ajax)
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/self/toUpdate.htm',1,now());

-- 个人资料保存(ajax)
insert into t_au_privilege_url(privilege_id,url,status,create_time) values(null,'/self/createOrUpdate.htm',1,now());


select * from t_au_privilege;
select * from t_au_privilege_url;
