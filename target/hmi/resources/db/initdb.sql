CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '员工姓名',
  `gender` tinyint(1) DEFAULT '1' COMMENT '性别, 1男 2女',
  `job_number` varchar(20) DEFAULT NULL COMMENT '工号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `position` tinyint(3) NOT NULL COMMENT '职级',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `org` varchar(100) DEFAULT NULL COMMENT '所属组织',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '员工状态 1有效 2 无效',
  `password` varchar(32) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工信息表'

CREATE TABLE `menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `resource_id` int(10) NOT NULL COMMENT '资源id',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `modify_time` datetime NOT NULL COMMENT '最后修改时间',
  `status` tinyint(3) NOT NULL COMMENT '状态 1有效 2无效',
  `mome` varchar(100) DEFAULT NULL COMMENT '备注',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8

create table resource(
   id int(10) unsigned not null auto_increment,
   name varchar(20) not null comment '资源名称',
   url varchar(100) comment '资源URL',
   add_time datetime not null comment '添加时间',
   modify_time datetime not null comment '最后修改时间',
   status tinyint(3) not null comment '状态 1有效 2无效',
   display tinyint(1) not null default '1' comment '是否显示  1显示 2不显示',
   mome varchar(100) comment '备注',
   primary key(id)
);

create table role(
   id int(10) unsigned not null auto_increment,
   name varchar(20) not null comment '角色名称',
   add_time datetime not null comment '添加时间',
   modify_time datetime not null comment '最后修改时间',
   status tinyint(3) not null comment '状态 1有效 2无效',
   mome varchar(100) comment '备注',
   primary key(id)
);

create table employee_role(
   id int(10) unsigned not null auto_increment,
   employee_id int(10) not null comment '员工id',
   role_id int(10) not null comment '角色id',
   add_time datetime not null comment '添加时间',
   modify_time datetime not null comment '最后修改时间',
   mome varchar(100) comment '备注',
   primary key(id)
);

CREATE TABLE `role_resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL COMMENT '角色id',
  `resource_id` int(10) NOT NULL COMMENT '资源id',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `modify_time` datetime NOT NULL COMMENT '最后修改时间',
  `mome` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

insert into resource(name, url, add_time, modify_time, status, display) value('添加员工', 'employee/add', now(),now(), 1, 1);

insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('员工列表','',1,NOW(),NOW(),1,1);
insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('设备列表','',2,NOW(),NOW(),1,2);
insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('事件列表','',3,NOW(),NOW(),1,3);
insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('角色列表','',4,NOW(),NOW(),1,4);
insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('出勤信息','',5,NOW(),NOW(),1,5);
insert into menu(name, url, resource_id, add_time, modify_time, status,parent_id) value('添加员工','',6,NOW(),NOW(),1,1);
