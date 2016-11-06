
delete from t_au_menu;
-- 菜单定制规则: 一级菜单编号为个位数， 二级菜单编号为三位数, 依此类推
-- <顺序:资源管理-用户权限>

insert into t_au_menu (id,status,sort_no,url,icon,parent,create_time,label) values(1, 1, 1, '', 'fa fa-gear', null, now(), '用户权限');

-- 用户权限
insert into t_au_menu (id,status,sort_no,url,icon,parent,create_time,label) values(101, 1, 1, '/role/roleManage.htm', '', 1, now(), '角色管理');
insert into t_au_menu (id,status,sort_no,url,icon,parent,create_time,label) values(102, 1, 2, '/rolePrivilege/rolePrivilegeManage.htm', '', 1, now(), '角色权限设置');
insert into t_au_menu (id,status,sort_no,url,icon,parent,create_time,label) values(103, 1, 3, '/user/userManage.htm', '', 1, now(), '用户管理');
insert into t_au_menu (id,status,sort_no,url,icon,parent,create_time,label) values(104, 1, 4, '/userRole/userRoleManage.htm', '', 1, now(), '分配用户角色');

select * from t_au_menu order by parent;







