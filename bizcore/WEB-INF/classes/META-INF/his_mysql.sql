-- BUILD WITH MODEL TIME 190417T0011
drop database  if exists his;
create database his;
-- alter  database his  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use his;

drop table  if exists hospital_data;
create table hospital_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	address                       	varchar(24)                              comment '地址',
	telephone                     	varchar(44)                              comment '电话',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(200)                             comment '名称',
	address             	varchar(24)                              comment '地址',
	telephone           	varchar(44)                              comment '电话',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医院";

drop table  if exists expense_type_data;
create table expense_type_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	helper_chars                  	varchar(12)                              comment '辅助识字课',
	status                        	varchar(8)                               comment '状态',
	hospital                      	varchar(48)                              comment '医院',
	description                   	longtext                                 comment '描述',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	helper_chars        	varchar(12)                              comment '辅助识字课',
	status              	varchar(8)                               comment '状态',
	hospital            	varchar(48)                              comment '医院',
	description         	longtext                                 comment '描述',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用类型";

drop table  if exists period_data;
create table period_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(8)                               comment '名称',
	hospital                      	varchar(48)                              comment '医院',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	hospital            	varchar(48)                              comment '医院',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "期";

drop table  if exists expense_item_data;
create table expense_item_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	price                         	numeric(15,2)                            comment '价格',
	expense_type                  	varchar(48)                              comment '费用类型',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(20)                              comment '名称',
	price               	numeric(15,2)                            comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用项目";

drop table  if exists doctor_data;
create table doctor_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	shot_image                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '拍摄的图像',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	shot_image          	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '拍摄的图像',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生";

drop table  if exists department_data;
create table department_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "部门";

drop table  if exists doctor_assignment_data;
create table doctor_assignment_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	doctor                        	varchar(48)                              comment '医生',
	department                    	varchar(48)                              comment '部门',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(40)                              comment '名称',
	doctor              	varchar(48)                              comment '医生',
	department          	varchar(48)                              comment '部门',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生的任务";

drop table  if exists doctor_schedule_data;
create table doctor_schedule_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(116)                             comment '名称',
	doctor                        	varchar(48)                              comment '医生',
	schedule_date                 	date                                     comment '安排日期',
	period                        	varchar(48)                              comment '期',
	department                    	varchar(48)                              comment '部门',
	available                     	int                                      comment '可用',
	price                         	numeric(7,2)                             comment '价格',
	expense_type                  	varchar(48)                              comment '费用类型',
	create_time                   	datetime                                 comment '创建时间',
	update_time                   	datetime                                 comment '更新时间',
	hospital                      	varchar(48)                              comment '医院',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(116)                             comment '名称',
	doctor              	varchar(48)                              comment '医生',
	schedule_date       	date                                     comment '安排日期',
	period              	varchar(48)                              comment '期',
	department          	varchar(48)                              comment '部门',
	available           	int                                      comment '可用',
	price               	numeric(7,2)                             comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	hospital            	varchar(48)                              comment '医院',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生安排";

drop table  if exists user_domain_data;
create table user_domain_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";

drop table  if exists user_white_list_data;
create table user_white_list_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	user_identity       	varchar(40)                              comment '用户身份',
	user_special_functions	varchar(200)                             comment '用户特殊功能',
	domain              	varchar(48)                              comment '域',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";

drop table  if exists sec_user_data;
create table sec_user_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(20)                              comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(76)                              comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	blocking                      	varchar(48)                              comment '屏蔽',
	current_status                	varchar(28)                              comment '当前状态',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	login               	varchar(20)                              comment '登录',
	mobile              	varchar(11)                              comment '手机号码',
	email               	varchar(76)                              comment '电子邮件',
	pwd                 	varchar(64)                              comment '密码',
	weixin_openid       	varchar(128)                             comment 'Weixin Openid',
	weixin_appid        	varchar(128)                             comment 'Weixin Appid',
	access_token        	varchar(128)                             comment '访问令牌',
	verification_code   	int                                      comment '验证码',
	verification_code_expire	datetime                                 comment '验证码过期',
	last_login_time     	datetime                                 comment '最后登录时间',
	domain              	varchar(48)                              comment '域',
	blocking            	varchar(48)                              comment '屏蔽',
	current_status      	varchar(28)                              comment '当前状态',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(52)                              comment '谁',
	block_time                    	datetime                                 comment '块时间',
	comments                      	varchar(96)                              comment '评论',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	who                 	varchar(52)                              comment '谁',
	block_time          	datetime                                 comment '块时间',
	comments            	varchar(96)                              comment '评论',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户屏蔽";

drop table  if exists user_app_data;
create table user_app_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(300)                             comment '标题',
	sec_user            	varchar(48)                              comment '安全用户',
	app_icon            	varchar(36)                              comment '应用程序图标',
	full_access         	tinyint                                  comment '完全访问',
	permission          	varchar(16)                              comment '许可',
	object_type         	varchar(100)                             comment '访问对象类型',
	object_id           	varchar(40)                              comment '对象ID',
	location            	varchar(48)                              comment '位置',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";

drop table  if exists list_access_data;
create table list_access_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新权限',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(200)                             comment '名称',
	internal_name       	varchar(200)                             comment '内部名称',
	read_permission     	tinyint                                  comment '读权限',
	create_permission   	tinyint                                  comment '创建权限',
	delete_permission   	tinyint                                  comment '删除权限',
	update_permission   	tinyint                                  comment '更新许可',
	execution_permission	tinyint                                  comment '执行权限',
	app                 	varchar(48)                              comment '应用程序',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";

drop table  if exists object_access_data;
create table object_access_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	object_type                   	varchar(112)                             comment '访问对象类型',
	list1                         	varchar(80)                              comment '列表1',
	list2                         	varchar(80)                              comment '列表2',
	list3                         	varchar(80)                              comment '列表3',
	list4                         	varchar(80)                              comment '列表4',
	list5                         	varchar(80)                              comment '列表5',
	list6                         	varchar(80)                              comment '列表6',
	list7                         	varchar(80)                              comment '列表7',
	list8                         	varchar(80)                              comment '列表8',
	list9                         	varchar(80)                              comment '列表9',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(28)                              comment '名称',
	object_type         	varchar(112)                             comment '访问对象类型',
	list1               	varchar(80)                              comment '列表1',
	list2               	varchar(80)                              comment '列表2',
	list3               	varchar(80)                              comment '列表3',
	list4               	varchar(80)                              comment '列表4',
	list5               	varchar(80)                              comment '列表5',
	list6               	varchar(80)                              comment '列表6',
	list7               	varchar(80)                              comment '列表7',
	list8               	varchar(80)                              comment '列表8',
	list9               	varchar(80)                              comment '列表9',
	app                 	varchar(48)                              comment '应用程序',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";

drop table  if exists login_history_data;
create table login_history_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	login_time          	datetime                                 comment '登录时间',
	from_ip             	varchar(44)                              comment '来自IP',
	description         	varchar(16)                              comment '描述',
	sec_user            	varchar(48)                              comment '安全用户',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";

drop table  if exists generic_form_data;
create table generic_form_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(20)                              comment '标题',
	description         	varchar(48)                              comment '描述',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";

drop table  if exists form_message_data;
create table form_message_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(24)                              comment '标题',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";

drop table  if exists form_field_message_data;
create table form_field_message_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(16)                              comment '标题',
	parameter_name      	varchar(16)                              comment '参数名称',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";

drop table  if exists form_field_data;
create table form_field_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(12)                              comment '标签',
	locale_key                    	varchar(44)                              comment '语言环境的关键',
	parameter_name                	varchar(16)                              comment '参数名称',
	type                          	varchar(36)                              comment '类型',
	form                          	varchar(48)                              comment '形式',
	placeholder                   	varchar(48)                              comment '占位符',
	default_value                 	varchar(12)                              comment '默认值',
	description                   	varchar(48)                              comment '描述',
	field_group                   	varchar(16)                              comment '字段组',
	minimum_value                 	varchar(60)                              comment '最小值',
	maximum_value                 	varchar(72)                              comment '最大值',
	required                      	tinyint                                  comment '要求',
	disabled                      	tinyint                                  comment '禁用',
	custom_rendering              	tinyint                                  comment '自定义渲染',
	candidate_values              	varchar(12)                              comment '候选人的价值观',
	suggest_values                	varchar(12)                              comment '建议值',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	label               	varchar(12)                              comment '标签',
	locale_key          	varchar(44)                              comment '语言环境的关键',
	parameter_name      	varchar(16)                              comment '参数名称',
	type                	varchar(36)                              comment '类型',
	form                	varchar(48)                              comment '形式',
	placeholder         	varchar(48)                              comment '占位符',
	default_value       	varchar(12)                              comment '默认值',
	description         	varchar(48)                              comment '描述',
	field_group         	varchar(16)                              comment '字段组',
	minimum_value       	varchar(60)                              comment '最小值',
	maximum_value       	varchar(72)                              comment '最大值',
	required            	tinyint                                  comment '要求',
	disabled            	tinyint                                  comment '禁用',
	custom_rendering    	tinyint                                  comment '自定义渲染',
	candidate_values    	varchar(12)                              comment '候选人的价值观',
	suggest_values      	varchar(12)                              comment '建议值',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";

drop table  if exists form_action_data;
create table form_action_data (
<<<<<<< HEAD
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(8)                               comment '标签',
	locale_key                    	varchar(16)                              comment '语言环境的关键',
	action_key                    	varchar(24)                              comment '行动的关键',
	level                         	varchar(28)                              comment '水平',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '形式',
	version                       	int                                      comment '版本',
=======
	id                  	varchar(48)          not null            comment 'ID',
	label               	varchar(8)                               comment '标签',
	locale_key          	varchar(16)                              comment '语言环境的关键',
	action_key          	varchar(24)                              comment '行动的关键',
	level               	varchar(28)                              comment '水平',
	url                 	varchar(168)                             comment 'url',
	form                	varchar(48)                              comment '形式',
	version             	int                                      comment '版本',
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";




insert into hospital_data values
<<<<<<< HEAD
	('H000001','上和医院','毕升路22号','028-9123123','1');

insert into expense_type_data values
	('ET000001','诊疗费','zlf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-07-14 13:25:16','1'),
	('ET000002','治疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-07-05 11:10:05','1'),
	('ET000003','检查费','jcf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-24 20:43:41','1');

insert into period_data values
	('P000001','上午','H000001','1'),
	('P000002','下午','H000001','1'),
	('P000003','夜班','H000001','1');

insert into expense_item_data values
	('EI000001','专家诊疗费','86452412416.00','ET000001','H000001','2019-07-01 14:57:28','1'),
	('EI000002','血常规','77952892928.00','ET000001','H000001','2019-07-05 15:26:27','1'),
	('EI000003','煎药费','78495727616.00','ET000002','H000001','2019-07-01 08:19:43','1'),
	('EI000004','专家诊疗费','88465825792.00','ET000003','H000001','2019-07-12 12:51:15','1');

insert into doctor_data values
	('D000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-07-13 21:47:06','1'),
	('D000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-06-24 16:14:13','1');

insert into department_data values
	('D000001','放射科','H000001','2019-07-03 02:35:32','1'),
	('D000002','放射科0002','H000001','2019-06-28 12:50:35','1');

insert into doctor_assignment_data values
	('DA000001','魏松全在内分泌科室上','D000001','D000001','2019-06-25 22:38:45','1'),
	('DA000002','魏松全在内分泌科室上0002','D000001','D000001','2019-07-11 14:15:01','1'),
	('DA000003','魏松全在内分泌科室上0003','D000002','D000002','2019-07-06 22:36:49','1'),
	('DA000004','魏松全在内分泌科室上0004','D000002','D000002','2019-06-28 01:40:25','1');

insert into doctor_schedule_data values
	('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D000001','2018-08-04','P000001','D000001','19','116.99','ET000001','2019-06-25 23:32:42','2019-06-27 07:37:39','H000001','1'),
	('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D000001','2018-08-14','P000001','D000001','20','117.44','ET000001','2019-06-24 22:02:08','2019-07-04 13:24:45','H000001','1'),
	('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D000002','2017-11-02','P000002','D000002','20','117.13','ET000002','2019-06-23 14:25:53','2019-07-08 07:11:37','H000001','1'),
	('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D000002','2019-04-22','P000003','D000002','18','102.60','ET000003','2019-06-22 21:34:00','2019-06-30 12:41:09','H000001','1');

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-06-28 06:59:15','2019-06-26 02:03:53','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-06-24 01:24:29','2019-06-25 15:34:50','UD000001',NULL,'BLOCKED0002','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-07-10 07:00:14','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000001','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA000005','维修公司','SU000002','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA000006','顾客','SU000002','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000002','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000003','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000004','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000004','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000005','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000006','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

insert into login_history_data values
	('LH000001','2019-07-07 05:54:46','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-07-01 22:58:47','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-07-09 18:15:31','192.168.1.1','登陆成功0003','SU000002','1'),
	('LH000004','2019-07-04 18:09:53','192.168.1.2','登陆成功0004','SU000002','1');

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1'),
	('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003','1','1','1','','','1'),
	('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004','1','1','1','男,女','男,女','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');
=======
	('H00000001','上和医院','毕升路22号','028-9123123','1');

insert into expense_type_data values
	('ET00000001','诊疗费','zlf','正常','H00000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-07 20:30:53','1'),
	('ET00000002','治疗费','zlf','停用','H00000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-22 06:10:57','1'),
	('ET00000003','检查费','jcf','正常','H00000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-14 10:45:05','1'),
	('ET00000004','诊疗费','zlf','停用','H00000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-12 09:16:20','1'),
	('ET00000005','治疗费','zlf','正常','H00000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-06-19 19:06:07','1');

insert into period_data values
	('P00000001','上午','H00000001','1'),
	('P00000002','下午','H00000001','1'),
	('P00000003','夜班','H00000001','1');

insert into expense_item_data values
	('EI00000001','专家诊疗费','84365475840.00','ET00000001','H00000001','2019-06-12 06:27:43','1'),
	('EI00000002','血常规','77064937472.00','ET00000001','H00000001','2019-06-01 18:35:51','1'),
	('EI00000003','煎药费','88398471168.00','ET00000001','H00000001','2019-06-16 03:53:24','1'),
	('EI00000004','专家诊疗费','84902862848.00','ET00000001','H00000001','2019-06-07 15:42:37','1'),
	('EI00000005','血常规','71961829376.00','ET00000001','H00000001','2019-06-10 05:41:46','1'),
	('EI00000006','煎药费','73087762432.00','ET00000002','H00000001','2019-06-06 12:53:50','1'),
	('EI00000007','专家诊疗费','93984358400.00','ET00000002','H00000001','2019-06-06 20:59:42','1'),
	('EI00000008','血常规','77851254784.00','ET00000002','H00000001','2019-06-01 14:40:08','1'),
	('EI00000009','煎药费','81033945088.00','ET00000002','H00000001','2019-06-16 18:04:22','1'),
	('EI00000010','专家诊疗费','75134869504.00','ET00000002','H00000001','2019-06-14 13:29:19','1'),
	('EI00000011','血常规','79110184960.00','ET00000003','H00000001','2019-06-12 19:04:07','1'),
	('EI00000012','煎药费','72613560320.00','ET00000003','H00000001','2019-06-02 00:30:06','1'),
	('EI00000013','专家诊疗费','76250324992.00','ET00000003','H00000001','2019-06-05 14:51:02','1'),
	('EI00000014','血常规','70717349888.00','ET00000003','H00000001','2019-06-20 01:47:53','1'),
	('EI00000015','煎药费','71676248064.00','ET00000003','H00000001','2019-06-08 01:39:31','1'),
	('EI00000016','专家诊疗费','71196434432.00','ET00000004','H00000001','2019-06-06 19:55:27','1'),
	('EI00000017','血常规','86673260544.00','ET00000004','H00000001','2019-06-03 04:44:52','1'),
	('EI00000018','煎药费','90144088064.00','ET00000004','H00000001','2019-06-02 23:17:05','1'),
	('EI00000019','专家诊疗费','72166834176.00','ET00000004','H00000001','2019-06-14 11:03:39','1'),
	('EI00000020','血常规','86073335808.00','ET00000004','H00000001','2019-06-01 04:55:52','1'),
	('EI00000021','煎药费','88051245056.00','ET00000005','H00000001','2019-06-08 18:52:34','1'),
	('EI00000022','专家诊疗费','82637561856.00','ET00000005','H00000001','2019-06-17 13:24:36','1'),
	('EI00000023','血常规','89724624896.00','ET00000005','H00000001','2019-06-22 08:12:55','1'),
	('EI00000024','煎药费','79891906560.00','ET00000005','H00000001','2019-06-01 06:38:57','1'),
	('EI00000025','专家诊疗费','87997612032.00','ET00000005','H00000001','2019-06-22 22:21:47','1');

insert into doctor_data values
	('D00000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H00000001','2019-06-02 20:14:10','1'),
	('D00000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H00000001','2019-06-06 19:17:32','1'),
	('D00000003','魏松全0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H00000001','2019-06-01 09:56:49','1'),
	('D00000004','魏松全0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H00000001','2019-06-06 12:08:31','1'),
	('D00000005','魏松全0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H00000001','2019-06-09 01:08:01','1');

insert into department_data values
	('D00000001','放射科','H00000001','2019-06-05 06:50:20','1'),
	('D00000002','放射科0002','H00000001','2019-06-03 14:02:49','1'),
	('D00000003','放射科0003','H00000001','2019-06-10 23:24:20','1'),
	('D00000004','放射科0004','H00000001','2019-06-12 13:55:23','1'),
	('D00000005','放射科0005','H00000001','2019-06-19 07:38:00','1');

insert into doctor_assignment_data values
	('DA00000001','魏松全在内分泌科室上','D00000001','D00000001','2019-06-04 08:27:58','1'),
	('DA00000002','魏松全在内分泌科室上0002','D00000001','D00000001','2019-06-09 03:44:54','1'),
	('DA00000003','魏松全在内分泌科室上0003','D00000001','D00000001','2019-06-04 00:35:53','1'),
	('DA00000004','魏松全在内分泌科室上0004','D00000001','D00000001','2019-06-17 11:44:38','1'),
	('DA00000005','魏松全在内分泌科室上0005','D00000001','D00000001','2019-06-17 13:14:48','1'),
	('DA00000006','魏松全在内分泌科室上0006','D00000002','D00000002','2019-06-06 21:05:54','1'),
	('DA00000007','魏松全在内分泌科室上0007','D00000002','D00000002','2019-06-11 21:22:01','1'),
	('DA00000008','魏松全在内分泌科室上0008','D00000002','D00000002','2019-06-22 16:06:30','1'),
	('DA00000009','魏松全在内分泌科室上0009','D00000002','D00000002','2019-06-20 00:16:56','1'),
	('DA00000010','魏松全在内分泌科室上0010','D00000002','D00000002','2019-06-05 03:03:36','1'),
	('DA00000011','魏松全在内分泌科室上0011','D00000003','D00000003','2019-06-18 17:51:54','1'),
	('DA00000012','魏松全在内分泌科室上0012','D00000003','D00000003','2019-06-09 01:58:10','1'),
	('DA00000013','魏松全在内分泌科室上0013','D00000003','D00000003','2019-06-10 17:07:32','1'),
	('DA00000014','魏松全在内分泌科室上0014','D00000003','D00000003','2019-06-20 08:46:18','1'),
	('DA00000015','魏松全在内分泌科室上0015','D00000003','D00000003','2019-06-06 19:27:43','1'),
	('DA00000016','魏松全在内分泌科室上0016','D00000004','D00000004','2019-06-01 05:36:33','1'),
	('DA00000017','魏松全在内分泌科室上0017','D00000004','D00000004','2019-06-16 20:07:07','1'),
	('DA00000018','魏松全在内分泌科室上0018','D00000004','D00000004','2019-06-14 10:42:18','1'),
	('DA00000019','魏松全在内分泌科室上0019','D00000004','D00000004','2019-06-01 22:04:52','1'),
	('DA00000020','魏松全在内分泌科室上0020','D00000004','D00000004','2019-06-14 07:29:20','1'),
	('DA00000021','魏松全在内分泌科室上0021','D00000005','D00000005','2019-06-15 05:22:16','1'),
	('DA00000022','魏松全在内分泌科室上0022','D00000005','D00000005','2019-06-07 04:11:03','1'),
	('DA00000023','魏松全在内分泌科室上0023','D00000005','D00000005','2019-06-12 08:36:17','1'),
	('DA00000024','魏松全在内分泌科室上0024','D00000005','D00000005','2019-06-02 22:56:06','1'),
	('DA00000025','魏松全在内分泌科室上0025','D00000005','D00000005','2019-06-05 06:45:30','1');

insert into doctor_schedule_data values
	('DS00000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D00000001','2018-02-09','P00000001','D00000001','18','95.27','ET00000001','2019-06-06 17:15:30','2019-06-14 10:06:39','H00000001','1'),
	('DS00000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D00000001','2019-01-24','P00000001','D00000001','20','112.46','ET00000001','2019-06-08 02:10:12','2019-06-06 14:59:54','H00000001','1'),
	('DS00000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D00000001','2018-11-29','P00000001','D00000001','20','116.84','ET00000001','2019-06-07 18:41:59','2019-06-19 11:09:37','H00000001','1'),
	('DS00000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D00000001','2019-03-11','P00000001','D00000001','17','95.09','ET00000001','2019-06-01 09:19:13','2019-06-06 09:20:37','H00000001','1'),
	('DS00000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','D00000001','2017-12-06','P00000001','D00000001','20','114.53','ET00000001','2019-06-04 23:39:29','2019-06-07 21:03:00','H00000001','1'),
	('DS00000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','D00000002','2017-02-02','P00000001','D00000002','17','100.56','ET00000002','2019-06-20 11:22:03','2019-06-04 14:06:39','H00000001','1'),
	('DS00000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','D00000002','2017-11-20','P00000001','D00000002','17','119.35','ET00000002','2019-06-11 21:01:11','2019-06-13 03:48:57','H00000001','1'),
	('DS00000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','D00000002','2019-04-30','P00000001','D00000002','18','105.19','ET00000002','2019-06-10 11:15:19','2019-06-22 10:14:25','H00000001','1'),
	('DS00000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','D00000002','2018-12-10','P00000001','D00000002','18','123.97','ET00000002','2019-06-06 07:51:58','2019-06-03 09:42:58','H00000001','1'),
	('DS00000010','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100010','D00000002','2016-12-14','P00000002','D00000002','20','114.30','ET00000002','2019-06-21 12:59:49','2019-06-16 22:48:15','H00000001','1'),
	('DS00000011','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100011','D00000003','2017-08-01','P00000002','D00000003','20','110.71','ET00000003','2019-06-15 04:52:48','2019-06-12 23:43:23','H00000001','1'),
	('DS00000012','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100012','D00000003','2019-04-26','P00000002','D00000003','15','110.92','ET00000003','2019-06-21 07:46:03','2019-06-13 18:55:31','H00000001','1'),
	('DS00000013','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100013','D00000003','2017-06-30','P00000002','D00000003','20','120.94','ET00000003','2019-06-19 22:11:40','2019-06-14 15:46:35','H00000001','1'),
	('DS00000014','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100014','D00000003','2017-04-02','P00000002','D00000003','19','107.13','ET00000003','2019-06-09 01:39:55','2019-06-06 19:25:00','H00000001','1'),
	('DS00000015','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100015','D00000003','2018-09-16','P00000002','D00000003','18','121.44','ET00000003','2019-06-03 23:16:15','2019-06-07 23:57:43','H00000001','1'),
	('DS00000016','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100016','D00000004','2017-12-07','P00000002','D00000004','15','87.81','ET00000004','2019-06-21 15:27:58','2019-06-09 14:10:07','H00000001','1'),
	('DS00000017','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100017','D00000004','2017-11-20','P00000002','D00000004','16','110.95','ET00000004','2019-06-01 20:39:37','2019-06-07 19:22:19','H00000001','1'),
	('DS00000018','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100018','D00000004','2018-05-02','P00000003','D00000004','20','116.33','ET00000004','2019-06-17 22:25:23','2019-06-19 23:32:54','H00000001','1'),
	('DS00000019','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100019','D00000004','2018-03-02','P00000003','D00000004','20','102.00','ET00000004','2019-06-04 00:06:32','2019-06-13 02:02:41','H00000001','1'),
	('DS00000020','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100020','D00000004','2018-10-14','P00000003','D00000004','15','109.23','ET00000004','2019-06-01 16:51:55','2019-06-19 05:50:35','H00000001','1'),
	('DS00000021','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100021','D00000005','2018-05-13','P00000003','D00000005','15','102.13','ET00000005','2019-06-22 10:42:57','2019-06-11 18:12:55','H00000001','1'),
	('DS00000022','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100022','D00000005','2018-12-13','P00000003','D00000005','15','116.62','ET00000005','2019-06-20 20:30:41','2019-06-14 11:49:06','H00000001','1'),
	('DS00000023','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100023','D00000005','2019-04-01','P00000003','D00000005','20','118.15','ET00000005','2019-06-04 14:28:52','2019-06-08 13:08:18','H00000001','1'),
	('DS00000024','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100024','D00000005','2018-11-07','P00000003','D00000005','15','110.06','ET00000005','2019-06-21 13:43:31','2019-06-20 16:14:49','H00000001','1'),
	('DS00000025','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100025','D00000005','2018-05-09','P00000003','D00000005','15','88.52','ET00000005','2019-06-04 17:18:00','2019-06-11 19:31:17','H00000001','1');

insert into user_domain_data values
	('UD00000001','用户区域','1');

insert into user_white_list_data values
	('UWL00000001','clariones','tester;ios-spokesperson','UD00000001','1'),
	('UWL00000002','13808188512','tester;ios-spokesperson0002','UD00000001','1'),
	('UWL00000003','clariones','tester;ios-spokesperson0003','UD00000001','1'),
	('UWL00000004','13808188512','tester;ios-spokesperson0004','UD00000001','1'),
	('UWL00000005','clariones','tester;ios-spokesperson0005','UD00000001','1');

insert into sec_user_data values
	('SU00000001','login','13900000001','','1B0837F50CCED8BAC0DE12C3834F69EA018EF13A11DB9EE48C74FA07E606A32B','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-06-03 13:49:05','2019-06-09 17:55:14','UD00000001',NULL,'BLOCKED','1'),
	('SU00000002','login0002','13900000002','suddy_chang@163.com','E60B73EA81103C70F5708857A5E8423F8EB9A882B0840F5C94D5AFDFB1B46C0A','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-06-09 13:32:40','2019-06-03 23:19:20','UD00000001',NULL,'BLOCKED0002','1'),
	('SU00000003','login0003','13900000003','','56E58AC1E636BBE620D78189598260827D1F9988B3F89C006F52CE7C1FD7759B','wx123456789abcdefghijklmn0003','wxapp120984102398400003','jwt_token_123456780003','0','2019-06-07 04:55:47','2019-06-18 12:39:17','UD00000001',NULL,'BLOCKED0003','1'),
	('SU00000004','login0004','13900000004','suddy_chang@163.com','3E26CA214237C611FDC35AAE3ADA4BCF7E9A275598A2818960A4F764CB1FF24C','wx123456789abcdefghijklmn0004','wxapp120984102398400004','jwt_token_123456780004','9999999','2019-06-11 19:58:29','2019-06-11 15:25:35','UD00000001',NULL,'BLOCKED0004','1'),
	('SU00000005','login0005','13900000005','','DFC16295E69738474AD009A17E2563CE466EB9E6778A3CE8B988CE1391EB0C15','wx123456789abcdefghijklmn0005','wxapp120984102398400005','jwt_token_123456780005','0','2019-06-18 06:36:02','2019-06-14 19:33:07','UD00000001',NULL,'BLOCKED0005','1');

insert into sec_user_blocking_data values
	('SUB00000001','currentUser()','2019-06-05 17:45:11','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

insert into user_app_data values
	('UA00000001','审车平台','SU00000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA00000002','账户管理','SU00000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA00000003','接车公司','SU00000001','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA00000004','审车公司','SU00000001','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA00000005','维修公司','SU00000001','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA00000006','顾客','SU00000002','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0006','1'),
	('UA00000007','审车平台','SU00000002','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1'),
	('UA00000008','账户管理','SU00000002','bank','1','MXWR','UserDomain','UD000001','/link/to/app0008','1'),
	('UA00000009','接车公司','SU00000002','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1'),
	('UA00000010','审车公司','SU00000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1'),
	('UA00000011','维修公司','SU00000003','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1'),
	('UA00000012','顾客','SU00000003','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0012','1'),
	('UA00000013','审车平台','SU00000003','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1'),
	('UA00000014','账户管理','SU00000003','bank','1','MXWR','UserDomain','UD000001','/link/to/app0014','1'),
	('UA00000015','接车公司','SU00000003','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1'),
	('UA00000016','审车公司','SU00000004','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1'),
	('UA00000017','维修公司','SU00000004','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0017','1'),
	('UA00000018','顾客','SU00000004','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0018','1'),
	('UA00000019','审车平台','SU00000004','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0019','1'),
	('UA00000020','账户管理','SU00000004','bank','1','MXWR','UserDomain','UD000001','/link/to/app0020','1'),
	('UA00000021','接车公司','SU00000005','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0021','1'),
	('UA00000022','审车公司','SU00000005','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0022','1'),
	('UA00000023','维修公司','SU00000005','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0023','1'),
	('UA00000024','顾客','SU00000005','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0024','1'),
	('UA00000025','审车平台','SU00000005','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0025','1');

insert into list_access_data values
	('LA00000001','列表','levelOneCategoryList','1','1','1','1','1','UA00000001','1'),
	('LA00000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA00000001','1'),
	('LA00000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA00000001','1'),
	('LA00000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA00000001','1'),
	('LA00000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA00000001','1'),
	('LA00000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA00000002','1'),
	('LA00000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA00000002','1'),
	('LA00000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA00000002','1'),
	('LA00000009','列表0009','levelOneCategoryList0009','1','1','1','1','1','UA00000002','1'),
	('LA00000010','列表0010','levelOneCategoryList0010','1','1','1','1','1','UA00000002','1'),
	('LA00000011','列表0011','levelOneCategoryList0011','1','1','1','1','1','UA00000003','1'),
	('LA00000012','列表0012','levelOneCategoryList0012','1','1','1','1','1','UA00000003','1'),
	('LA00000013','列表0013','levelOneCategoryList0013','1','1','1','1','1','UA00000003','1'),
	('LA00000014','列表0014','levelOneCategoryList0014','1','1','1','1','1','UA00000003','1'),
	('LA00000015','列表0015','levelOneCategoryList0015','1','1','1','1','1','UA00000003','1'),
	('LA00000016','列表0016','levelOneCategoryList0016','1','1','1','1','1','UA00000004','1'),
	('LA00000017','列表0017','levelOneCategoryList0017','1','1','1','1','1','UA00000004','1'),
	('LA00000018','列表0018','levelOneCategoryList0018','1','1','1','1','1','UA00000004','1'),
	('LA00000019','列表0019','levelOneCategoryList0019','1','1','1','1','1','UA00000004','1'),
	('LA00000020','列表0020','levelOneCategoryList0020','1','1','1','1','1','UA00000004','1'),
	('LA00000021','列表0021','levelOneCategoryList0021','1','1','1','1','1','UA00000005','1'),
	('LA00000022','列表0022','levelOneCategoryList0022','1','1','1','1','1','UA00000005','1'),
	('LA00000023','列表0023','levelOneCategoryList0023','1','1','1','1','1','UA00000005','1'),
	('LA00000024','列表0024','levelOneCategoryList0024','1','1','1','1','1','UA00000005','1'),
	('LA00000025','列表0025','levelOneCategoryList0025','1','1','1','1','1','UA00000005','1'),
	('LA00000026','列表0026','levelOneCategoryList0026','1','1','1','1','1','UA00000006','1'),
	('LA00000027','列表0027','levelOneCategoryList0027','1','1','1','1','1','UA00000006','1'),
	('LA00000028','列表0028','levelOneCategoryList0028','1','1','1','1','1','UA00000006','1'),
	('LA00000029','列表0029','levelOneCategoryList0029','1','1','1','1','1','UA00000006','1'),
	('LA00000030','列表0030','levelOneCategoryList0030','1','1','1','1','1','UA00000006','1'),
	('LA00000031','列表0031','levelOneCategoryList0031','1','1','1','1','1','UA00000007','1'),
	('LA00000032','列表0032','levelOneCategoryList0032','1','1','1','1','1','UA00000007','1'),
	('LA00000033','列表0033','levelOneCategoryList0033','1','1','1','1','1','UA00000007','1'),
	('LA00000034','列表0034','levelOneCategoryList0034','1','1','1','1','1','UA00000007','1'),
	('LA00000035','列表0035','levelOneCategoryList0035','1','1','1','1','1','UA00000007','1'),
	('LA00000036','列表0036','levelOneCategoryList0036','1','1','1','1','1','UA00000008','1'),
	('LA00000037','列表0037','levelOneCategoryList0037','1','1','1','1','1','UA00000008','1'),
	('LA00000038','列表0038','levelOneCategoryList0038','1','1','1','1','1','UA00000008','1'),
	('LA00000039','列表0039','levelOneCategoryList0039','1','1','1','1','1','UA00000008','1'),
	('LA00000040','列表0040','levelOneCategoryList0040','1','1','1','1','1','UA00000008','1'),
	('LA00000041','列表0041','levelOneCategoryList0041','1','1','1','1','1','UA00000009','1'),
	('LA00000042','列表0042','levelOneCategoryList0042','1','1','1','1','1','UA00000009','1'),
	('LA00000043','列表0043','levelOneCategoryList0043','1','1','1','1','1','UA00000009','1'),
	('LA00000044','列表0044','levelOneCategoryList0044','1','1','1','1','1','UA00000009','1'),
	('LA00000045','列表0045','levelOneCategoryList0045','1','1','1','1','1','UA00000009','1'),
	('LA00000046','列表0046','levelOneCategoryList0046','1','1','1','1','1','UA00000010','1'),
	('LA00000047','列表0047','levelOneCategoryList0047','1','1','1','1','1','UA00000010','1'),
	('LA00000048','列表0048','levelOneCategoryList0048','1','1','1','1','1','UA00000010','1'),
	('LA00000049','列表0049','levelOneCategoryList0049','1','1','1','1','1','UA00000010','1'),
	('LA00000050','列表0050','levelOneCategoryList0050','1','1','1','1','1','UA00000010','1'),
	('LA00000051','列表0051','levelOneCategoryList0051','1','1','1','1','1','UA00000011','1'),
	('LA00000052','列表0052','levelOneCategoryList0052','1','1','1','1','1','UA00000011','1'),
	('LA00000053','列表0053','levelOneCategoryList0053','1','1','1','1','1','UA00000011','1'),
	('LA00000054','列表0054','levelOneCategoryList0054','1','1','1','1','1','UA00000011','1'),
	('LA00000055','列表0055','levelOneCategoryList0055','1','1','1','1','1','UA00000011','1'),
	('LA00000056','列表0056','levelOneCategoryList0056','1','1','1','1','1','UA00000012','1'),
	('LA00000057','列表0057','levelOneCategoryList0057','1','1','1','1','1','UA00000012','1'),
	('LA00000058','列表0058','levelOneCategoryList0058','1','1','1','1','1','UA00000012','1'),
	('LA00000059','列表0059','levelOneCategoryList0059','1','1','1','1','1','UA00000012','1'),
	('LA00000060','列表0060','levelOneCategoryList0060','1','1','1','1','1','UA00000012','1'),
	('LA00000061','列表0061','levelOneCategoryList0061','1','1','1','1','1','UA00000013','1'),
	('LA00000062','列表0062','levelOneCategoryList0062','1','1','1','1','1','UA00000013','1'),
	('LA00000063','列表0063','levelOneCategoryList0063','1','1','1','1','1','UA00000013','1'),
	('LA00000064','列表0064','levelOneCategoryList0064','1','1','1','1','1','UA00000013','1'),
	('LA00000065','列表0065','levelOneCategoryList0065','1','1','1','1','1','UA00000013','1'),
	('LA00000066','列表0066','levelOneCategoryList0066','1','1','1','1','1','UA00000014','1'),
	('LA00000067','列表0067','levelOneCategoryList0067','1','1','1','1','1','UA00000014','1'),
	('LA00000068','列表0068','levelOneCategoryList0068','1','1','1','1','1','UA00000014','1'),
	('LA00000069','列表0069','levelOneCategoryList0069','1','1','1','1','1','UA00000014','1'),
	('LA00000070','列表0070','levelOneCategoryList0070','1','1','1','1','1','UA00000014','1'),
	('LA00000071','列表0071','levelOneCategoryList0071','1','1','1','1','1','UA00000015','1'),
	('LA00000072','列表0072','levelOneCategoryList0072','1','1','1','1','1','UA00000015','1'),
	('LA00000073','列表0073','levelOneCategoryList0073','1','1','1','1','1','UA00000015','1'),
	('LA00000074','列表0074','levelOneCategoryList0074','1','1','1','1','1','UA00000015','1'),
	('LA00000075','列表0075','levelOneCategoryList0075','1','1','1','1','1','UA00000015','1'),
	('LA00000076','列表0076','levelOneCategoryList0076','1','1','1','1','1','UA00000016','1'),
	('LA00000077','列表0077','levelOneCategoryList0077','1','1','1','1','1','UA00000016','1'),
	('LA00000078','列表0078','levelOneCategoryList0078','1','1','1','1','1','UA00000016','1'),
	('LA00000079','列表0079','levelOneCategoryList0079','1','1','1','1','1','UA00000016','1'),
	('LA00000080','列表0080','levelOneCategoryList0080','1','1','1','1','1','UA00000016','1'),
	('LA00000081','列表0081','levelOneCategoryList0081','1','1','1','1','1','UA00000017','1'),
	('LA00000082','列表0082','levelOneCategoryList0082','1','1','1','1','1','UA00000017','1'),
	('LA00000083','列表0083','levelOneCategoryList0083','1','1','1','1','1','UA00000017','1'),
	('LA00000084','列表0084','levelOneCategoryList0084','1','1','1','1','1','UA00000017','1'),
	('LA00000085','列表0085','levelOneCategoryList0085','1','1','1','1','1','UA00000017','1'),
	('LA00000086','列表0086','levelOneCategoryList0086','1','1','1','1','1','UA00000018','1'),
	('LA00000087','列表0087','levelOneCategoryList0087','1','1','1','1','1','UA00000018','1'),
	('LA00000088','列表0088','levelOneCategoryList0088','1','1','1','1','1','UA00000018','1'),
	('LA00000089','列表0089','levelOneCategoryList0089','1','1','1','1','1','UA00000018','1'),
	('LA00000090','列表0090','levelOneCategoryList0090','1','1','1','1','1','UA00000018','1'),
	('LA00000091','列表0091','levelOneCategoryList0091','1','1','1','1','1','UA00000019','1'),
	('LA00000092','列表0092','levelOneCategoryList0092','1','1','1','1','1','UA00000019','1'),
	('LA00000093','列表0093','levelOneCategoryList0093','1','1','1','1','1','UA00000019','1'),
	('LA00000094','列表0094','levelOneCategoryList0094','1','1','1','1','1','UA00000019','1'),
	('LA00000095','列表0095','levelOneCategoryList0095','1','1','1','1','1','UA00000019','1'),
	('LA00000096','列表0096','levelOneCategoryList0096','1','1','1','1','1','UA00000020','1'),
	('LA00000097','列表0097','levelOneCategoryList0097','1','1','1','1','1','UA00000020','1'),
	('LA00000098','列表0098','levelOneCategoryList0098','1','1','1','1','1','UA00000020','1'),
	('LA00000099','列表0099','levelOneCategoryList0099','1','1','1','1','1','UA00000020','1'),
	('LA00000100','列表0100','levelOneCategoryList0100','1','1','1','1','1','UA00000020','1'),
	('LA00000101','列表0101','levelOneCategoryList0101','1','1','1','1','1','UA00000021','1'),
	('LA00000102','列表0102','levelOneCategoryList0102','1','1','1','1','1','UA00000021','1'),
	('LA00000103','列表0103','levelOneCategoryList0103','1','1','1','1','1','UA00000021','1'),
	('LA00000104','列表0104','levelOneCategoryList0104','1','1','1','1','1','UA00000021','1'),
	('LA00000105','列表0105','levelOneCategoryList0105','1','1','1','1','1','UA00000021','1'),
	('LA00000106','列表0106','levelOneCategoryList0106','1','1','1','1','1','UA00000022','1'),
	('LA00000107','列表0107','levelOneCategoryList0107','1','1','1','1','1','UA00000022','1'),
	('LA00000108','列表0108','levelOneCategoryList0108','1','1','1','1','1','UA00000022','1'),
	('LA00000109','列表0109','levelOneCategoryList0109','1','1','1','1','1','UA00000022','1'),
	('LA00000110','列表0110','levelOneCategoryList0110','1','1','1','1','1','UA00000022','1'),
	('LA00000111','列表0111','levelOneCategoryList0111','1','1','1','1','1','UA00000023','1'),
	('LA00000112','列表0112','levelOneCategoryList0112','1','1','1','1','1','UA00000023','1'),
	('LA00000113','列表0113','levelOneCategoryList0113','1','1','1','1','1','UA00000023','1'),
	('LA00000114','列表0114','levelOneCategoryList0114','1','1','1','1','1','UA00000023','1'),
	('LA00000115','列表0115','levelOneCategoryList0115','1','1','1','1','1','UA00000023','1'),
	('LA00000116','列表0116','levelOneCategoryList0116','1','1','1','1','1','UA00000024','1'),
	('LA00000117','列表0117','levelOneCategoryList0117','1','1','1','1','1','UA00000024','1'),
	('LA00000118','列表0118','levelOneCategoryList0118','1','1','1','1','1','UA00000024','1'),
	('LA00000119','列表0119','levelOneCategoryList0119','1','1','1','1','1','UA00000024','1'),
	('LA00000120','列表0120','levelOneCategoryList0120','1','1','1','1','1','UA00000024','1'),
	('LA00000121','列表0121','levelOneCategoryList0121','1','1','1','1','1','UA00000025','1'),
	('LA00000122','列表0122','levelOneCategoryList0122','1','1','1','1','1','UA00000025','1'),
	('LA00000123','列表0123','levelOneCategoryList0123','1','1','1','1','1','UA00000025','1'),
	('LA00000124','列表0124','levelOneCategoryList0124','1','1','1','1','1','UA00000025','1'),
	('LA00000125','列表0125','levelOneCategoryList0125','1','1','1','1','1','UA00000025','1');

insert into object_access_data values
	('OA00000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000001','1'),
	('OA00000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000001','1'),
	('OA00000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000001','1'),
	('OA00000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000001','1'),
	('OA00000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000001','1'),
	('OA00000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000002','1'),
	('OA00000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000002','1'),
	('OA00000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000002','1'),
	('OA00000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000002','1'),
	('OA00000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000002','1'),
	('OA00000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000003','1'),
	('OA00000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000003','1'),
	('OA00000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000003','1'),
	('OA00000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000003','1'),
	('OA00000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000003','1'),
	('OA00000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000004','1'),
	('OA00000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000004','1'),
	('OA00000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000004','1'),
	('OA00000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000004','1'),
	('OA00000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000004','1'),
	('OA00000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000005','1'),
	('OA00000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000005','1'),
	('OA00000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000005','1'),
	('OA00000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000005','1'),
	('OA00000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000005','1'),
	('OA00000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000006','1'),
	('OA00000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000006','1'),
	('OA00000028','控制访问列表10028','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000006','1'),
	('OA00000029','控制访问列表10029','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000006','1'),
	('OA00000030','控制访问列表10030','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000006','1'),
	('OA00000031','控制访问列表10031','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000007','1'),
	('OA00000032','控制访问列表10032','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000007','1'),
	('OA00000033','控制访问列表10033','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000007','1'),
	('OA00000034','控制访问列表10034','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000007','1'),
	('OA00000035','控制访问列表10035','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000007','1'),
	('OA00000036','控制访问列表10036','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000008','1'),
	('OA00000037','控制访问列表10037','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000008','1'),
	('OA00000038','控制访问列表10038','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000008','1'),
	('OA00000039','控制访问列表10039','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000008','1'),
	('OA00000040','控制访问列表10040','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000008','1'),
	('OA00000041','控制访问列表10041','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000009','1'),
	('OA00000042','控制访问列表10042','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000009','1'),
	('OA00000043','控制访问列表10043','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000009','1'),
	('OA00000044','控制访问列表10044','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000009','1'),
	('OA00000045','控制访问列表10045','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000009','1'),
	('OA00000046','控制访问列表10046','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000010','1'),
	('OA00000047','控制访问列表10047','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000010','1'),
	('OA00000048','控制访问列表10048','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000010','1'),
	('OA00000049','控制访问列表10049','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000010','1'),
	('OA00000050','控制访问列表10050','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000010','1'),
	('OA00000051','控制访问列表10051','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000011','1'),
	('OA00000052','控制访问列表10052','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000011','1'),
	('OA00000053','控制访问列表10053','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000011','1'),
	('OA00000054','控制访问列表10054','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000011','1'),
	('OA00000055','控制访问列表10055','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000011','1'),
	('OA00000056','控制访问列表10056','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000012','1'),
	('OA00000057','控制访问列表10057','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000012','1'),
	('OA00000058','控制访问列表10058','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000012','1'),
	('OA00000059','控制访问列表10059','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000012','1'),
	('OA00000060','控制访问列表10060','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000012','1'),
	('OA00000061','控制访问列表10061','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000013','1'),
	('OA00000062','控制访问列表10062','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000013','1'),
	('OA00000063','控制访问列表10063','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000013','1'),
	('OA00000064','控制访问列表10064','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000013','1'),
	('OA00000065','控制访问列表10065','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000013','1'),
	('OA00000066','控制访问列表10066','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000014','1'),
	('OA00000067','控制访问列表10067','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000014','1'),
	('OA00000068','控制访问列表10068','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000014','1'),
	('OA00000069','控制访问列表10069','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000014','1'),
	('OA00000070','控制访问列表10070','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000014','1'),
	('OA00000071','控制访问列表10071','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000015','1'),
	('OA00000072','控制访问列表10072','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000015','1'),
	('OA00000073','控制访问列表10073','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000015','1'),
	('OA00000074','控制访问列表10074','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000015','1'),
	('OA00000075','控制访问列表10075','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000015','1'),
	('OA00000076','控制访问列表10076','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000016','1'),
	('OA00000077','控制访问列表10077','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000016','1'),
	('OA00000078','控制访问列表10078','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000016','1'),
	('OA00000079','控制访问列表10079','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000016','1'),
	('OA00000080','控制访问列表10080','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000016','1'),
	('OA00000081','控制访问列表10081','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000017','1'),
	('OA00000082','控制访问列表10082','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000017','1'),
	('OA00000083','控制访问列表10083','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000017','1'),
	('OA00000084','控制访问列表10084','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000017','1'),
	('OA00000085','控制访问列表10085','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000017','1'),
	('OA00000086','控制访问列表10086','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000018','1'),
	('OA00000087','控制访问列表10087','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000018','1'),
	('OA00000088','控制访问列表10088','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000018','1'),
	('OA00000089','控制访问列表10089','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000018','1'),
	('OA00000090','控制访问列表10090','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000018','1'),
	('OA00000091','控制访问列表10091','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000019','1'),
	('OA00000092','控制访问列表10092','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000019','1'),
	('OA00000093','控制访问列表10093','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000019','1'),
	('OA00000094','控制访问列表10094','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000019','1'),
	('OA00000095','控制访问列表10095','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000019','1'),
	('OA00000096','控制访问列表10096','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000020','1'),
	('OA00000097','控制访问列表10097','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000020','1'),
	('OA00000098','控制访问列表10098','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000020','1'),
	('OA00000099','控制访问列表10099','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000020','1'),
	('OA00000100','控制访问列表10100','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000020','1'),
	('OA00000101','控制访问列表10101','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000021','1'),
	('OA00000102','控制访问列表10102','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000021','1'),
	('OA00000103','控制访问列表10103','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000021','1'),
	('OA00000104','控制访问列表10104','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000021','1'),
	('OA00000105','控制访问列表10105','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000021','1'),
	('OA00000106','控制访问列表10106','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000022','1'),
	('OA00000107','控制访问列表10107','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000022','1'),
	('OA00000108','控制访问列表10108','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000022','1'),
	('OA00000109','控制访问列表10109','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000022','1'),
	('OA00000110','控制访问列表10110','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000022','1'),
	('OA00000111','控制访问列表10111','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000023','1'),
	('OA00000112','控制访问列表10112','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000023','1'),
	('OA00000113','控制访问列表10113','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000023','1'),
	('OA00000114','控制访问列表10114','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000023','1'),
	('OA00000115','控制访问列表10115','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000023','1'),
	('OA00000116','控制访问列表10116','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000024','1'),
	('OA00000117','控制访问列表10117','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000024','1'),
	('OA00000118','控制访问列表10118','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000024','1'),
	('OA00000119','控制访问列表10119','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000024','1'),
	('OA00000120','控制访问列表10120','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000024','1'),
	('OA00000121','控制访问列表10121','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000025','1'),
	('OA00000122','控制访问列表10122','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000025','1'),
	('OA00000123','控制访问列表10123','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000025','1'),
	('OA00000124','控制访问列表10124','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA00000025','1'),
	('OA00000125','控制访问列表10125','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA00000025','1');

insert into login_history_data values
	('LH00000001','2019-06-16 09:16:27','192.168.1.1','登陆成功','SU00000001','1'),
	('LH00000002','2019-06-14 18:05:19','192.168.1.2','登陆成功0002','SU00000001','1'),
	('LH00000003','2019-06-17 19:29:37','192.168.1.1','登陆成功0003','SU00000001','1'),
	('LH00000004','2019-06-21 13:11:12','192.168.1.2','登陆成功0004','SU00000001','1'),
	('LH00000005','2019-06-04 21:46:00','192.168.1.1','登陆成功0005','SU00000001','1'),
	('LH00000006','2019-06-13 13:21:15','192.168.1.2','登陆成功0006','SU00000002','1'),
	('LH00000007','2019-06-05 20:28:42','192.168.1.1','登陆成功0007','SU00000002','1'),
	('LH00000008','2019-06-08 07:11:18','192.168.1.2','登陆成功0008','SU00000002','1'),
	('LH00000009','2019-06-15 04:37:07','192.168.1.1','登陆成功0009','SU00000002','1'),
	('LH00000010','2019-06-08 03:36:29','192.168.1.2','登陆成功0010','SU00000002','1'),
	('LH00000011','2019-06-09 21:27:23','192.168.1.1','登陆成功0011','SU00000003','1'),
	('LH00000012','2019-06-21 03:45:35','192.168.1.2','登陆成功0012','SU00000003','1'),
	('LH00000013','2019-06-02 18:30:48','192.168.1.1','登陆成功0013','SU00000003','1'),
	('LH00000014','2019-06-17 19:00:41','192.168.1.2','登陆成功0014','SU00000003','1'),
	('LH00000015','2019-06-17 14:35:34','192.168.1.1','登陆成功0015','SU00000003','1'),
	('LH00000016','2019-06-18 07:25:41','192.168.1.2','登陆成功0016','SU00000004','1'),
	('LH00000017','2019-06-15 02:49:49','192.168.1.1','登陆成功0017','SU00000004','1'),
	('LH00000018','2019-06-16 04:08:26','192.168.1.2','登陆成功0018','SU00000004','1'),
	('LH00000019','2019-06-10 19:19:46','192.168.1.1','登陆成功0019','SU00000004','1'),
	('LH00000020','2019-06-13 13:03:57','192.168.1.2','登陆成功0020','SU00000004','1'),
	('LH00000021','2019-06-12 14:17:27','192.168.1.1','登陆成功0021','SU00000005','1'),
	('LH00000022','2019-06-22 04:06:26','192.168.1.2','登陆成功0022','SU00000005','1'),
	('LH00000023','2019-06-06 07:02:23','192.168.1.1','登陆成功0023','SU00000005','1'),
	('LH00000024','2019-06-04 22:46:26','192.168.1.2','登陆成功0024','SU00000005','1'),
	('LH00000025','2019-06-19 05:32:55','192.168.1.1','登陆成功0025','SU00000005','1');

insert into generic_form_data values
	('GF00000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM00000001','字段组合错误','GF00000001','success','1'),
	('FM00000002','字段组合错误0002','GF00000001','info','1'),
	('FM00000003','字段组合错误0003','GF00000001','warning','1'),
	('FM00000004','字段组合错误0004','GF00000001','danger','1'),
	('FM00000005','字段组合错误0005','GF00000001','success','1');

insert into form_field_message_data values
	('FFM00000001','输入错误','name','GF00000001','success','1'),
	('FFM00000002','输入错误0002','name0002','GF00000001','info','1'),
	('FFM00000003','输入错误0003','name0003','GF00000001','warning','1'),
	('FFM00000004','输入错误0004','name0004','GF00000001','danger','1'),
	('FFM00000005','输入错误0005','name0005','GF00000001','success','1');

insert into form_field_data values
	('FF00000001','姓名','name','name','text','GF00000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF00000002','年龄','age','name0002','longtext','GF00000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1'),
	('FF00000003','出生地','birth_place','name0003','date','GF00000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003','1','1','1','','','1'),
	('FF00000004','国籍','country','name0004','date_time','GF00000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004','1','1','1','男,女','男,女','1'),
	('FF00000005','姓名','name','name0005','money','GF00000001','姓名就是你身份证上的名字0005','李一一0005','姓名就是你身份证上的名字0005','基础信息','maybe any value0005','a value expression0005','1','1','1','高,矮','高,矮','1');

insert into form_action_data values
	('FA00000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF00000001','1'),
	('FA00000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF00000001','1'),
	('FA00000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF00000001','1'),
	('FA00000004','功能0004','name0004','save','primary','genericFormManager/name/name0002/name0003/0004','GF00000001','1'),
	('FA00000005','功能0005','name0005','update','default','genericFormManager/name/name0002/name0003/0005','GF00000001','1');
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547



/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_hospital_version on hospital_data(id, version);

create unique index idx_expense_type_version on expense_type_data(id, version);

alter table expense_type_data add constraint expense_type4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_period_version on period_data(id, version);

alter table period_data add constraint period4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_expense_item_version on expense_item_data(id, version);

alter table expense_item_data add constraint expense_item4expense_type_fk
	foreign key(expense_type) references expense_type_data(id) on delete cascade on update cascade;
alter table expense_item_data add constraint expense_item4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_doctor_version on doctor_data(id, version);

alter table doctor_data add constraint doctor4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_department_version on department_data(id, version);

alter table department_data add constraint department4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_doctor_assignment_version on doctor_assignment_data(id, version);

alter table doctor_assignment_data add constraint doctor_assignment4doctor_fk
	foreign key(doctor) references doctor_data(id) on delete cascade on update cascade;
alter table doctor_assignment_data add constraint doctor_assignment4department_fk
	foreign key(department) references department_data(id) on delete cascade on update cascade;
create unique index idx_doctor_schedule_version on doctor_schedule_data(id, version);

alter table doctor_schedule_data add constraint doctor_schedule4doctor_fk
	foreign key(doctor) references doctor_data(id) on delete cascade on update cascade;
alter table doctor_schedule_data add constraint doctor_schedule4period_fk
	foreign key(period) references period_data(id) on delete cascade on update cascade;
alter table doctor_schedule_data add constraint doctor_schedule4department_fk
	foreign key(department) references department_data(id) on delete cascade on update cascade;
alter table doctor_schedule_data add constraint doctor_schedule4expense_type_fk
	foreign key(expense_type) references expense_type_data(id) on delete cascade on update cascade;
alter table doctor_schedule_data add constraint doctor_schedule4hospital_fk
	foreign key(hospital) references hospital_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index hospital4version_idx on hospital_data(version);
create index expense_type4update_time_idx on expense_type_data(update_time);
create index expense_type4version_idx on expense_type_data(version);
create index period4version_idx on period_data(version);
create index expense_item4price_idx on expense_item_data(price);
create index expense_item4update_time_idx on expense_item_data(update_time);
create index expense_item4version_idx on expense_item_data(version);
create index doctor4update_time_idx on doctor_data(update_time);
create index doctor4version_idx on doctor_data(version);
create index department4update_time_idx on department_data(update_time);
create index department4version_idx on department_data(version);
create index doctor_assignment4update_time_idx on doctor_assignment_data(update_time);
create index doctor_assignment4version_idx on doctor_assignment_data(version);
create index doctor_schedule4schedule_date_idx on doctor_schedule_data(schedule_date);
create index doctor_schedule4available_idx on doctor_schedule_data(available);
create index doctor_schedule4price_idx on doctor_schedule_data(price);
create index doctor_schedule4create_time_idx on doctor_schedule_data(create_time);
create index doctor_schedule4update_time_idx on doctor_schedule_data(update_time);
create index doctor_schedule4version_idx on doctor_schedule_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);











delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
<<<<<<< HEAD
insert into user_app_data values('UA000001','医院','SU000001','hospital',1,'MXWR','Hospital','H000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','费用类型','SU000002','pen',1,'MXWR','ExpenseType','ET000001','/link/to/app','1');
insert into user_app_data values('UA000004','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','医生','SU000003','address-book',1,'MXWR','Doctor','D000001','/link/to/app','1');
insert into user_app_data values('UA000006','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','部门','SU000004','address-book',1,'MXWR','Department','D000001','/link/to/app','1');
insert into user_app_data values('UA000008','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','用户域','SU000005','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1');
insert into user_app_data values('UA000010','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','安全用户','SU000006','user',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000012','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','用户应用程序','SU000007','user',1,'MXWR','UserApp','UA000001','/link/to/app','1');
=======
insert into user_app_data values('UA000001','医院','SU000001','hospital',1,'MXWR','Hospital','H00000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','费用类型','SU000002','pen',1,'MXWR','ExpenseType','ET00000001','/link/to/app','1');
insert into user_app_data values('UA000004','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','医生','SU000003','address-book',1,'MXWR','Doctor','D00000001','/link/to/app','1');
insert into user_app_data values('UA000006','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','部门','SU000004','address-book',1,'MXWR','Department','D00000001','/link/to/app','1');
insert into user_app_data values('UA000008','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','用户域','SU000005','user',1,'MXWR','UserDomain','UD00000001','/link/to/app','1');
insert into user_app_data values('UA000010','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','安全用户','SU000006','user',1,'MXWR','SecUser','SU00000001','/link/to/app','1');
insert into user_app_data values('UA000012','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','用户应用程序','SU000007','user',1,'MXWR','UserApp','UA00000001','/link/to/app','1');
>>>>>>> 5a174cc2dc8f941e7db426d0719b65c3a9ec0547
insert into user_app_data values('UA000014','我的账户','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1');

/* ------------------------------------------------------------------------ */




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|医院|13900000001|DoubleChain!y1|
|费用类型|13900000002|DoubleChain!y1|
|医生|13900000003|DoubleChain!y1|
|部门|13900000004|DoubleChain!y1|
|用户域|13900000005|DoubleChain!y1|
|安全用户|13900000006|DoubleChain!y1|
|用户应用程序|13900000007|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/his.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

