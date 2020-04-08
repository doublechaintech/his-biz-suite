
-- BUILD WITH MODEL TIME 191029T1628
-- Turn off safe mode
SET SQL_SAFE_UPDATES = 0;


drop database  if exists his;
create database his;
-- alter  database his  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use his;
set SESSION sql_mode='';

drop table  if exists hospital_data;
create table hospital_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	address                       	varchar(24)                              comment '地址',
	telephone                     	varchar(44)                              comment '电话',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医院";
-- primary key will be created later for better import performance

drop table  if exists expense_type_data;
create table expense_type_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	helper_chars                  	varchar(12)                              comment '辅助识字课',
	status                        	varchar(8)                               comment '状态',
	hospital                      	varchar(48)                              comment '医院',
	description                   	longtext                                 comment '描述',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用类型";
-- primary key will be created later for better import performance

drop table  if exists period_data;
create table period_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(8)                               comment '名称',
	code                          	varchar(36)                              comment '代码',
	hospital                      	varchar(48)                              comment '医院',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "期";
-- primary key will be created later for better import performance

drop table  if exists expense_item_data;
create table expense_item_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(20)                              comment '名称',
	price                         	numeric(15,2)                            comment '价格',
	expense_type                  	varchar(48)                              comment '费用类型',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用项目";
-- primary key will be created later for better import performance

drop table  if exists doctor_data;
create table doctor_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	shot_image                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '拍摄的图像',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生";
-- primary key will be created later for better import performance

drop table  if exists department_data;
create table department_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(12)                              comment '名称',
	hospital                      	varchar(48)                              comment '医院',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "部门";
-- primary key will be created later for better import performance

drop table  if exists doctor_assignment_data;
create table doctor_assignment_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(40)                              comment '名称',
	doctor                        	varchar(48)                              comment '医生',
	department                    	varchar(48)                              comment '部门',
	update_time                   	datetime                                 comment '更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生的任务";
-- primary key will be created later for better import performance

drop table  if exists doctor_schedule_data;
create table doctor_schedule_data (
	id                            	varchar(48)          not null            comment '序号',
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
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生安排";
-- primary key will be created later for better import performance

drop table  if exists mobile_app_data;
create table mobile_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "手机应用程序";
-- primary key will be created later for better import performance

drop table  if exists page_data;
create table page_data (
	id                            	varchar(48)          not null            comment 'ID',
	page_title                    	varchar(8)                               comment '页面标题',
	link_to_url                   	varchar(200)                             comment '链接网址',
	page_type                     	varchar(48)                              comment '页面类型',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "页面";
-- primary key will be created later for better import performance

drop table  if exists page_type_data;
create table page_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(48)                              comment '名称',
	code                          	varchar(56)                              comment '编码',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	footer_tab                    	tinyint                                  comment '页脚选项卡',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "页面类型";
-- primary key will be created later for better import performance

drop table  if exists slide_data;
create table slide_data (
	id                            	varchar(48)          not null            comment 'ID',
	display_order                 	int                                      comment '顺序',
	name                          	varchar(20)                              comment '名称',
	image_url                     	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片链接',
	video_url                     	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '视频网址',
	link_to_url                   	varchar(68)                              comment '链接网址',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "轮播内容";
-- primary key will be created later for better import performance

drop table  if exists ui_action_data;
create table ui_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(24)                              comment '编码',
	icon                          	varchar(40)                              comment '图标',
	title                         	varchar(8)                               comment '标题',
	brief                         	varchar(36)                              comment '短暂的',
	image_url                     	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片链接',
	link_to_url                   	varchar(68)                              comment '链接网址',
	extra_data                    	longtext                                 comment '额外的数据',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户界面操作";
-- primary key will be created later for better import performance

drop table  if exists section_data;
create table section_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(8)                               comment '标题',
	brief                         	varchar(28)                              comment '短暂的',
	icon                          	varchar(40)                              comment '图标',
	view_group                    	varchar(40)                              comment '视图组',
	link_to_url                   	varchar(68)                              comment '链接网址',
	page                          	varchar(28)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "板块";
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment '序号',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment '序号',
	login                         	varchar(256)                             comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(256)                             comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment '序号',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "快速链接";
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新许可',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";
-- primary key will be created later for better import performance

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment '序号',
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
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment '序号',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";
-- primary key will be created later for better import performance

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment '序号',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";
-- primary key will be created later for better import performance

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment '序号',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment '序号',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment '序号',
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
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";
-- primary key will be created later for better import performance

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment '序号',
	label                         	varchar(8)                               comment '标签',
	locale_key                    	varchar(16)                              comment '语言环境的关键',
	action_key                    	varchar(24)                              comment '行动的关键',
	level                         	varchar(28)                              comment '水平',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '形式',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人容器";
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment '序号',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人元素";
-- primary key will be created later for better import performance

drop table  if exists wechat_workapp_identify_data;
create table wechat_workapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	corp_id                       	varchar(100)                             comment '公司标识',
	user_id                       	varchar(100)                             comment '用户Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信Workapp识别";
-- primary key will be created later for better import performance

drop table  if exists wechat_miniapp_identify_data;
create table wechat_miniapp_identify_data (
	id                            	varchar(48)          not null            comment 'ID',
	open_id                       	varchar(128)                             comment '开放Id',
	app_id                        	varchar(128)                             comment '应用程序Id',
	sec_user                      	varchar(48)                              comment '安全用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信Miniapp识别";
-- primary key will be created later for better import performance

drop table  if exists tree_node_data;
create table tree_node_data (
	id                            	varchar(48)          not null            comment 'ID',
	node_id                       	varchar(40)                              comment '节点Id',
	node_type                     	varchar(32)                              comment '节点类型',
	left_value                    	int                                      comment '左值',
	right_value                   	int                                      comment '正确的价值',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "树节点";
-- primary key will be created later for better import performance




insert into hospital_data values
	('H000001','上和医院','毕升路22号','028-9123123','1');

insert into expense_type_data values
	('ET000001','诊疗费','zlf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-04-02 12:39:38','1'),
	('ET000002','治疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-03-20 13:43:50','1'),
	('ET000003','检查费','jcf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-03-24 02:39:43','1'),
	('ET000004','诊疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2020-03-25 10:25:18','1');

insert into period_data values
	('MORNING','上午','MORNING','H000001','1'),
	('AFTERNOON','下午','AFTERNOON','H000001','1'),
	('NIGHT','夜班','NIGHT','H000001','1');

insert into expense_item_data values
	('EI000001','专家诊疗费','80194895872.00','ET000001','H000001','2020-03-22 06:04:29','1'),
	('EI000002','血常规','98412142592.00','ET000001','H000001','2020-03-19 20:46:28','1'),
	('EI000003','煎药费','82010071040.00','ET000001','H000001','2020-03-25 03:16:18','1'),
	('EI000004','专家诊疗费','95791095808.00','ET000001','H000001','2020-03-24 17:15:15','1'),
	('EI000005','血常规','86464987136.00','ET000002','H000001','2020-04-04 10:03:26','1'),
	('EI000006','煎药费','94747369472.00','ET000002','H000001','2020-04-01 11:24:13','1'),
	('EI000007','专家诊疗费','78061248512.00','ET000002','H000001','2020-04-06 09:05:51','1'),
	('EI000008','血常规','95996321792.00','ET000002','H000001','2020-04-07 04:40:54','1'),
	('EI000009','煎药费','78468259840.00','ET000003','H000001','2020-03-19 09:47:18','1'),
	('EI000010','专家诊疗费','70101032960.00','ET000003','H000001','2020-04-01 12:48:37','1'),
	('EI000011','血常规','98154504192.00','ET000003','H000001','2020-04-07 10:16:41','1'),
	('EI000012','煎药费','88041349120.00','ET000003','H000001','2020-03-30 07:43:46','1'),
	('EI000013','专家诊疗费','83608944640.00','ET000004','H000001','2020-04-06 20:13:07','1'),
	('EI000014','血常规','85669658624.00','ET000004','H000001','2020-04-03 17:43:17','1'),
	('EI000015','煎药费','74297147392.00','ET000004','H000001','2020-03-28 07:30:14','1'),
	('EI000016','专家诊疗费','78995914752.00','ET000004','H000001','2020-03-30 19:02:23','1');

insert into doctor_data values
	('D000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0001/400/300/red/','H000001','2020-03-26 21:56:38','1'),
	('D000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0002/400/300/red/','H000001','2020-04-07 14:16:43','1'),
	('D000003','魏松全0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0003/400/300/red/','H000001','2020-03-29 01:59:47','1'),
	('D000004','魏松全0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot0004/400/300/red/','H000001','2020-03-27 23:00:25','1');

insert into department_data values
	('D000001','放射科','H000001','2020-03-30 02:48:43','1'),
	('D000002','放射科0002','H000001','2020-03-18 17:18:17','1'),
	('D000003','放射科0003','H000001','2020-03-24 06:39:56','1'),
	('D000004','放射科0004','H000001','2020-03-27 09:22:06','1');

insert into doctor_assignment_data values
	('DA000001','魏松全在内分泌科室上','D000001','D000001','2020-04-01 01:27:41','1'),
	('DA000002','魏松全在内分泌科室上0002','D000001','D000001','2020-03-23 23:02:21','1'),
	('DA000003','魏松全在内分泌科室上0003','D000001','D000001','2020-03-22 22:38:34','1'),
	('DA000004','魏松全在内分泌科室上0004','D000001','D000001','2020-04-03 05:21:47','1'),
	('DA000005','魏松全在内分泌科室上0005','D000002','D000002','2020-04-05 15:14:31','1'),
	('DA000006','魏松全在内分泌科室上0006','D000002','D000002','2020-03-21 11:38:40','1'),
	('DA000007','魏松全在内分泌科室上0007','D000002','D000002','2020-03-27 10:05:24','1'),
	('DA000008','魏松全在内分泌科室上0008','D000002','D000002','2020-04-06 15:39:35','1'),
	('DA000009','魏松全在内分泌科室上0009','D000003','D000003','2020-04-06 09:55:31','1'),
	('DA000010','魏松全在内分泌科室上0010','D000003','D000003','2020-03-24 15:03:31','1'),
	('DA000011','魏松全在内分泌科室上0011','D000003','D000003','2020-04-03 22:45:39','1'),
	('DA000012','魏松全在内分泌科室上0012','D000003','D000003','2020-03-29 08:36:35','1'),
	('DA000013','魏松全在内分泌科室上0013','D000004','D000004','2020-03-19 20:05:19','1'),
	('DA000014','魏松全在内分泌科室上0014','D000004','D000004','2020-03-22 14:34:11','1'),
	('DA000015','魏松全在内分泌科室上0015','D000004','D000004','2020-04-03 10:43:14','1'),
	('DA000016','魏松全在内分泌科室上0016','D000004','D000004','2020-04-02 00:01:31','1');

insert into doctor_schedule_data values
	('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D000001','2019-09-03','MORNING','D000001','19','91.61','ET000001','2020-04-05 18:01:56','2020-03-26 01:38:41','H000001','1'),
	('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D000001','2018-03-18','MORNING','D000001','15','104.18','ET000001','2020-03-28 15:07:22','2020-03-23 04:12:18','H000001','1'),
	('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D000001','2019-05-15','MORNING','D000001','17','121.33','ET000001','2020-03-27 09:16:01','2020-03-20 22:38:20','H000001','1'),
	('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D000001','2018-12-10','MORNING','D000001','17','114.19','ET000001','2020-03-18 09:59:24','2020-03-26 17:15:22','H000001','1'),
	('DS000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','D000002','2018-09-16','MORNING','D000002','15','88.13','ET000002','2020-04-02 02:29:29','2020-03-23 14:42:35','H000001','1'),
	('DS000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','D000002','2017-11-05','MORNING','D000002','18','123.47','ET000002','2020-04-06 03:26:42','2020-03-22 12:45:30','H000001','1'),
	('DS000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','D000002','2019-05-12','AFTERNOON','D000002','19','113.05','ET000002','2020-04-02 22:41:17','2020-03-27 14:25:42','H000001','1'),
	('DS000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','D000002','2020-02-22','AFTERNOON','D000002','19','97.47','ET000002','2020-04-02 20:30:18','2020-04-07 11:11:03','H000001','1'),
	('DS000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','D000003','2019-06-12','AFTERNOON','D000003','20','123.28','ET000003','2020-03-21 06:42:15','2020-04-02 22:52:28','H000001','1'),
	('DS000010','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100010','D000003','2018-03-11','AFTERNOON','D000003','15','120.41','ET000003','2020-04-04 01:44:12','2020-03-29 23:55:42','H000001','1'),
	('DS000011','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100011','D000003','2020-02-17','AFTERNOON','D000003','18','110.80','ET000003','2020-03-25 00:45:38','2020-03-29 15:59:13','H000001','1'),
	('DS000012','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100012','D000003','2019-06-26','NIGHT','D000003','18','109.63','ET000003','2020-03-30 01:18:36','2020-03-19 05:29:38','H000001','1'),
	('DS000013','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100013','D000004','2018-07-21','NIGHT','D000004','18','98.95','ET000004','2020-04-03 03:28:57','2020-04-02 04:51:09','H000001','1'),
	('DS000014','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100014','D000004','2019-06-23','NIGHT','D000004','15','89.81','ET000004','2020-04-02 16:39:13','2020-03-31 10:03:46','H000001','1'),
	('DS000015','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100015','D000004','2019-05-06','NIGHT','D000004','18','116.32','ET000004','2020-03-26 16:19:20','2020-03-20 16:39:37','H000001','1'),
	('DS000016','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100016','D000004','2018-12-21','NIGHT','D000004','18','114.44','ET000004','2020-03-23 22:56:30','2020-04-06 08:51:58','H000001','1');

insert into page_data values
	('P000001','首页','首页','home','MA000001','1'),
	('P000002','首页0002','首页0002','home','MA000001','1'),
	('P000003','首页0003','首页0003','home','MA000001','1'),
	('P000004','首页0004','首页0004','me','MA000001','1'),
	('P000005','首页0005','首页0005','me','MA000001','1'),
	('P000006','首页0006','首页0006','me','MA000001','1'),
	('P000007','首页0007','首页0007','generic-page','MA000001','1'),
	('P000008','首页0008','首页0008','generic-page','MA000001','1'),
	('P000009','首页0009','首页0009','listof-page','MA000001','1'),
	('P000010','首页0010','首页0010','listof-page','MA000001','1'),
	('P000011','首页0011','首页0011','listof-page','MA000001','1'),
	('P000012','首页0012','首页0012','service-center','MA000001','1'),
	('P000013','首页0013','首页0013','service-center','MA000001','1'),
	('P000014','首页0014','首页0014','service-center','MA000001','1'),
	('P000015','首页0015','首页0015','simple','MA000001','1'),
	('P000016','首页0016','首页0016','simple','MA000001','1');

insert into page_type_data values
	('home','首页','home','MA000001','1','1'),
	('me','我的','me','MA000001','1','1'),
	('generic-page','Generic Page','generic-page','MA000001','1','1'),
	('listof-page','Listof Page','listof-page','MA000001','1','1'),
	('service-center','功能大厅','service-center','MA000001','1','1'),
	('simple','普通','simple','MA000001','1','1');

insert into slide_data values
	('S000001','1','首页Focus的内容','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000001','1'),
	('S000002','2','首页Focus的内容0002','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000001','1'),
	('S000003','3','首页Focus的内容0003','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000001','1'),
	('S000004','1','首页Focus的内容0004','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000001','1'),
	('S000005','2','首页Focus的内容0005','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000002','1'),
	('S000006','3','首页Focus的内容0006','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000002','1'),
	('S000007','1','首页Focus的内容0007','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000002','1'),
	('S000008','2','首页Focus的内容0008','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000002','1'),
	('S000009','3','首页Focus的内容0009','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000003','1'),
	('S000010','1','首页Focus的内容0010','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000003','1'),
	('S000011','2','首页Focus的内容0011','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000003','1'),
	('S000012','3','首页Focus的内容0012','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000003','1'),
	('S000013','1','首页Focus的内容0013','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000004','1'),
	('S000014','2','首页Focus的内容0014','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000004','1'),
	('S000015','3','首页Focus的内容0015','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000004','1'),
	('S000016','1','首页Focus的内容0016','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000004','1'),
	('S000017','2','首页Focus的内容0017','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000005','1'),
	('S000018','3','首页Focus的内容0018','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000005','1'),
	('S000019','1','首页Focus的内容0019','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000005','1'),
	('S000020','2','首页Focus的内容0020','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000005','1'),
	('S000021','3','首页Focus的内容0021','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000006','1'),
	('S000022','1','首页Focus的内容0022','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000006','1'),
	('S000023','2','首页Focus的内容0023','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000006','1'),
	('S000024','3','首页Focus的内容0024','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000006','1'),
	('S000025','1','首页Focus的内容0025','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000007','1'),
	('S000026','2','首页Focus的内容0026','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000007','1'),
	('S000027','3','首页Focus的内容0027','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000007','1'),
	('S000028','1','首页Focus的内容0028','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000007','1'),
	('S000029','2','首页Focus的内容0029','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000008','1'),
	('S000030','3','首页Focus的内容0030','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000008','1'),
	('S000031','1','首页Focus的内容0031','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000008','1'),
	('S000032','2','首页Focus的内容0032','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000008','1'),
	('S000033','3','首页Focus的内容0033','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000009','1'),
	('S000034','1','首页Focus的内容0034','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000009','1'),
	('S000035','2','首页Focus的内容0035','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000009','1'),
	('S000036','3','首页Focus的内容0036','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000009','1'),
	('S000037','1','首页Focus的内容0037','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000010','1'),
	('S000038','2','首页Focus的内容0038','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000010','1'),
	('S000039','3','首页Focus的内容0039','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000010','1'),
	('S000040','1','首页Focus的内容0040','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000010','1'),
	('S000041','2','首页Focus的内容0041','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000011','1'),
	('S000042','3','首页Focus的内容0042','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000011','1'),
	('S000043','1','首页Focus的内容0043','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000011','1'),
	('S000044','2','首页Focus的内容0044','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000011','1'),
	('S000045','3','首页Focus的内容0045','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000012','1'),
	('S000046','1','首页Focus的内容0046','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000012','1'),
	('S000047','2','首页Focus的内容0047','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000012','1'),
	('S000048','3','首页Focus的内容0048','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000012','1'),
	('S000049','1','首页Focus的内容0049','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000013','1'),
	('S000050','2','首页Focus的内容0050','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000013','1'),
	('S000051','3','首页Focus的内容0051','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000013','1'),
	('S000052','1','首页Focus的内容0052','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000013','1'),
	('S000053','2','首页Focus的内容0053','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000014','1'),
	('S000054','3','首页Focus的内容0054','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000014','1'),
	('S000055','1','首页Focus的内容0055','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000014','1'),
	('S000056','2','首页Focus的内容0056','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000014','1'),
	('S000057','3','首页Focus的内容0057','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000015','1'),
	('S000058','1','首页Focus的内容0058','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000015','1'),
	('S000059','2','首页Focus的内容0059','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000015','1'),
	('S000060','3','首页Focus的内容0060','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000015','1'),
	('S000061','1','首页Focus的内容0061','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000016','1'),
	('S000062','2','首页Focus的内容0062','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000016','1'),
	('S000063','3','首页Focus的内容0063','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','','P000016','1'),
	('S000064','1','首页Focus的内容0064','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','P000016','1');

insert into ui_action_data values
	('UA000001','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000002','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0002','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000003','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0003','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000004','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0004','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000001','1'),
	('UA000005','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0005','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000006','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0006','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000007','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0007','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000008','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0008','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000002','1'),
	('UA000009','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0009','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000010','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0010','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000011','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0011','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000012','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0012','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000003','1'),
	('UA000013','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0013','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000014','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0014','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000015','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0015','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000016','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0016','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000004','1'),
	('UA000017','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0017','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000018','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0018','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000019','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0019','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000020','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0020','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000005','1'),
	('UA000021','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0021','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000022','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0022','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000023','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0023','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000024','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0024','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000006','1'),
	('UA000025','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0025','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000026','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0026','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000027','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0027','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000028','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0028','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000007','1'),
	('UA000029','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0029','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000030','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0030','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000031','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0031','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000032','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0032','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000008','1'),
	('UA000033','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0033','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000034','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0034','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000035','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0035','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000036','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0036','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000009','1'),
	('UA000037','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0037','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000038','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0038','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000039','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0039','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000040','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0040','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000010','1'),
	('UA000041','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0041','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000042','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0042','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000043','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0043','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000044','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0044','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000011','1'),
	('UA000045','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0045','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000046','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0046','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000047','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0047','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000048','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0048','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000012','1'),
	('UA000049','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0049','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000050','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0050','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000051','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0051','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000052','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0052','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000013','1'),
	('UA000053','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0053','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000054','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0054','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000055','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0055','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000056','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0056','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000014','1'),
	('UA000057','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0057','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000058','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0058','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000059','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0059','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000060','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0060','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000015','1'),
	('UA000061','submit','icon_edit','提交','Submit','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0061','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000062','share','icon_share','分享','Share','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0062','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000063','view','icon_eye','查看','View','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0063','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1'),
	('UA000064','more','icon_more','更多','View More','https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg','/section/article/0064','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','P000016','1');

insert into section_data values
	('S000001','文章','Article','icon_edit','icon_edit','/section/article/','${page}','1');

insert into wechat_workapp_identify_data values
	('WWI000001','corporation123','user123','SU000001','2020-03-25 17:04:13','2020-04-01 17:08:46','1'),
	('WWI000002','corporation1230002','user1230002','SU000001','2020-04-06 07:09:29','2020-03-21 00:49:29','1'),
	('WWI000003','corporation1230003','user1230003','SU000001','2020-03-21 07:34:30','2020-03-19 11:37:45','1'),
	('WWI000004','corporation1230004','user1230004','SU000001','2020-03-24 13:24:44','2020-04-03 12:00:45','1'),
	('WWI000005','corporation1230005','user1230005','SU000002','2020-03-28 05:58:44','2020-03-31 20:14:30','1'),
	('WWI000006','corporation1230006','user1230006','SU000002','2020-03-24 09:11:29','2020-04-03 02:27:26','1'),
	('WWI000007','corporation1230007','user1230007','SU000002','2020-04-02 02:17:25','2020-04-08 10:08:48','1'),
	('WWI000008','corporation1230008','user1230008','SU000002','2020-03-23 20:54:45','2020-03-20 13:44:03','1'),
	('WWI000009','corporation1230009','user1230009','SU000003','2020-03-21 01:41:13','2020-03-30 05:53:30','1'),
	('WWI000010','corporation1230010','user1230010','SU000003','2020-03-27 07:27:02','2020-04-06 18:03:09','1'),
	('WWI000011','corporation1230011','user1230011','SU000003','2020-03-18 17:27:40','2020-04-02 22:03:16','1'),
	('WWI000012','corporation1230012','user1230012','SU000003','2020-04-05 09:02:13','2020-03-24 14:02:07','1'),
	('WWI000013','corporation1230013','user1230013','SU000004','2020-04-08 14:28:47','2020-03-26 15:02:48','1'),
	('WWI000014','corporation1230014','user1230014','SU000004','2020-04-01 09:48:33','2020-04-02 15:34:04','1'),
	('WWI000015','corporation1230015','user1230015','SU000004','2020-03-21 20:44:24','2020-04-01 07:11:52','1'),
	('WWI000016','corporation1230016','user1230016','SU000004','2020-03-21 01:59:20','2020-03-24 10:08:22','1');

insert into wechat_miniapp_identify_data values
	('WMI000001','wechat_open_id_1234567890','wechat_miniapp_id_1234567890','SU000001','2020-03-27 21:24:49','2020-03-26 09:05:46','1'),
	('WMI000002','wechat_open_id_12345678900002','wechat_miniapp_id_12345678900002','SU000001','2020-03-27 21:24:25','2020-03-20 09:21:32','1'),
	('WMI000003','wechat_open_id_12345678900003','wechat_miniapp_id_12345678900003','SU000001','2020-03-18 11:49:08','2020-04-04 23:37:49','1'),
	('WMI000004','wechat_open_id_12345678900004','wechat_miniapp_id_12345678900004','SU000001','2020-04-04 08:14:40','2020-04-07 17:36:48','1'),
	('WMI000005','wechat_open_id_12345678900005','wechat_miniapp_id_12345678900005','SU000002','2020-04-01 13:01:54','2020-03-25 03:40:58','1'),
	('WMI000006','wechat_open_id_12345678900006','wechat_miniapp_id_12345678900006','SU000002','2020-04-01 15:02:42','2020-03-28 02:45:23','1'),
	('WMI000007','wechat_open_id_12345678900007','wechat_miniapp_id_12345678900007','SU000002','2020-04-02 19:56:16','2020-03-19 05:21:10','1'),
	('WMI000008','wechat_open_id_12345678900008','wechat_miniapp_id_12345678900008','SU000002','2020-04-05 06:39:25','2020-03-17 21:14:52','1'),
	('WMI000009','wechat_open_id_12345678900009','wechat_miniapp_id_12345678900009','SU000003','2020-03-31 02:51:06','2020-03-20 02:43:51','1'),
	('WMI000010','wechat_open_id_12345678900010','wechat_miniapp_id_12345678900010','SU000003','2020-04-02 23:23:59','2020-03-31 22:55:49','1'),
	('WMI000011','wechat_open_id_12345678900011','wechat_miniapp_id_12345678900011','SU000003','2020-04-04 09:10:00','2020-04-01 11:49:49','1'),
	('WMI000012','wechat_open_id_12345678900012','wechat_miniapp_id_12345678900012','SU000003','2020-03-18 08:36:14','2020-03-23 09:37:05','1'),
	('WMI000013','wechat_open_id_12345678900013','wechat_miniapp_id_12345678900013','SU000004','2020-03-19 05:16:45','2020-03-24 23:52:29','1'),
	('WMI000014','wechat_open_id_12345678900014','wechat_miniapp_id_12345678900014','SU000004','2020-03-22 07:33:15','2020-04-08 09:16:55','1'),
	('WMI000015','wechat_open_id_12345678900015','wechat_miniapp_id_12345678900015','SU000004','2020-04-01 00:24:45','2020-04-06 00:34:23','1'),
	('WMI000016','wechat_open_id_12345678900016','wechat_miniapp_id_12345678900016','SU000004','2020-03-20 12:22:47','2020-03-30 01:51:36','1');

insert into tree_node_data values
	('TN000001','node000001','nodetype','1','9','1');







delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
delete from wechat_miniapp_identify_data;
delete from wechat_workapp_identify_data;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000001','上和医院','SU000001','university',1,'MXWR','Hospital','H000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','users',1,'MXWR','UserDomain','UD000001','/link/to/app','1');

/* ------------------------------ generate users for all target od marked as user4all ------------------------------------------ */


-- no change request type found

select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/




-- Mysql innodb's foreign key has index automatically 
create unique index idx4id_ver_of_hospital on hospital_data (id, version);

create unique index idx4id_ver_of_expense_type on expense_type_data (id, version);
create  index idx4update_time_of_expense_type on expense_type_data (update_time);

create unique index idx4id_ver_of_period on period_data (id, version);
create unique index idx4code_of_period on period_data (code);

create unique index idx4id_ver_of_expense_item on expense_item_data (id, version);
create  index idx4price_of_expense_item on expense_item_data (price);
create  index idx4update_time_of_expense_item on expense_item_data (update_time);

create unique index idx4id_ver_of_doctor on doctor_data (id, version);
create  index idx4update_time_of_doctor on doctor_data (update_time);

create unique index idx4id_ver_of_department on department_data (id, version);
create  index idx4update_time_of_department on department_data (update_time);

create unique index idx4id_ver_of_doctor_assignment on doctor_assignment_data (id, version);
create  index idx4update_time_of_doctor_assignment on doctor_assignment_data (update_time);

create unique index idx4id_ver_of_doctor_schedule on doctor_schedule_data (id, version);
create  index idx4schedule_date_of_doctor_schedule on doctor_schedule_data (schedule_date);
create  index idx4available_of_doctor_schedule on doctor_schedule_data (available);
create  index idx4price_of_doctor_schedule on doctor_schedule_data (price);
create  index idx4create_time_of_doctor_schedule on doctor_schedule_data (create_time);
create  index idx4update_time_of_doctor_schedule on doctor_schedule_data (update_time);

create unique index idx4id_ver_of_mobile_app on mobile_app_data (id, version);

create unique index idx4id_ver_of_page on page_data (id, version);

create unique index idx4id_ver_of_page_type on page_type_data (id, version);
create unique index idx4code_of_page_type on page_type_data (code);

create unique index idx4id_ver_of_slide on slide_data (id, version);
create  index idx4display_order_of_slide on slide_data (display_order);

create unique index idx4id_ver_of_ui_action on ui_action_data (id, version);

create unique index idx4id_ver_of_section on section_data (id, version);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_white_list on user_white_list_data (id, version);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4object_id_of_user_app on user_app_data (object_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_object_access on object_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_generic_form on generic_form_data (id, version);

create unique index idx4id_ver_of_form_message on form_message_data (id, version);

create unique index idx4id_ver_of_form_field_message on form_field_message_data (id, version);

create unique index idx4id_ver_of_form_field on form_field_data (id, version);

create unique index idx4id_ver_of_form_action on form_action_data (id, version);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);

create unique index idx4id_ver_of_wechat_workapp_identify on wechat_workapp_identify_data (id, version);
create  index idx4corp_id_of_wechat_workapp_identify on wechat_workapp_identify_data (corp_id);
create  index idx4user_id_of_wechat_workapp_identify on wechat_workapp_identify_data (user_id);
create  index idx4create_time_of_wechat_workapp_identify on wechat_workapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_workapp_identify on wechat_workapp_identify_data (last_login_time);

create unique index idx4id_ver_of_wechat_miniapp_identify on wechat_miniapp_identify_data (id, version);
create  index idx4open_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (open_id);
create  index idx4app_id_of_wechat_miniapp_identify on wechat_miniapp_identify_data (app_id);
create  index idx4create_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (create_time);
create  index idx4last_login_time_of_wechat_miniapp_identify on wechat_miniapp_identify_data (last_login_time);

create unique index idx4id_ver_of_tree_node on tree_node_data (id, version);
create  index idx4node_id_of_tree_node on tree_node_data (node_id);
create  index idx4left_value_of_tree_node on tree_node_data (left_value);
create  index idx4right_value_of_tree_node on tree_node_data (right_value);
alter table hospital_data add constraint pk4id_of_hospital_data primary key (id);

alter table expense_type_data add constraint pk4id_of_expense_type_data primary key (id);
alter table expense_type_data add constraint 
	fk4hospital_of_expense_type_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table period_data add constraint pk4id_of_period_data primary key (id);
alter table period_data add constraint 
	fk4hospital_of_period_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table expense_item_data add constraint pk4id_of_expense_item_data primary key (id);
alter table expense_item_data add constraint 
	fk4expense_type_of_expense_item_data foreign key (expense_type) references expense_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table expense_item_data add constraint 
	fk4hospital_of_expense_item_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_data add constraint pk4id_of_doctor_data primary key (id);
alter table doctor_data add constraint 
	fk4hospital_of_doctor_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table department_data add constraint pk4id_of_department_data primary key (id);
alter table department_data add constraint 
	fk4hospital_of_department_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_assignment_data add constraint pk4id_of_doctor_assignment_data primary key (id);
alter table doctor_assignment_data add constraint 
	fk4doctor_of_doctor_assignment_data foreign key (doctor) references doctor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_assignment_data add constraint 
	fk4department_of_doctor_assignment_data foreign key (department) references department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table doctor_schedule_data add constraint pk4id_of_doctor_schedule_data primary key (id);
alter table doctor_schedule_data add constraint 
	fk4doctor_of_doctor_schedule_data foreign key (doctor) references doctor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4period_of_doctor_schedule_data foreign key (period) references period_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4department_of_doctor_schedule_data foreign key (department) references department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4expense_type_of_doctor_schedule_data foreign key (expense_type) references expense_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table doctor_schedule_data add constraint 
	fk4hospital_of_doctor_schedule_data foreign key (hospital) references hospital_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table mobile_app_data add constraint pk4id_of_mobile_app_data primary key (id);

alter table page_data add constraint pk4id_of_page_data primary key (id);
alter table page_data add constraint 
	fk4page_type_of_page_data foreign key (page_type) references page_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table page_data add constraint 
	fk4mobile_app_of_page_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table page_type_data add constraint pk4id_of_page_type_data primary key (id);
alter table page_type_data add constraint 
	fk4mobile_app_of_page_type_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table slide_data add constraint pk4id_of_slide_data primary key (id);
alter table slide_data add constraint 
	fk4page_of_slide_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ui_action_data add constraint pk4id_of_ui_action_data primary key (id);
alter table ui_action_data add constraint 
	fk4page_of_ui_action_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table section_data add constraint pk4id_of_section_data primary key (id);

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_white_list_data add constraint pk4id_of_user_white_list_data primary key (id);
alter table user_white_list_data add constraint 
	fk4domain_of_user_white_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table object_access_data add constraint pk4id_of_object_access_data primary key (id);
alter table object_access_data add constraint 
	fk4app_of_object_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table generic_form_data add constraint pk4id_of_generic_form_data primary key (id);

alter table form_message_data add constraint pk4id_of_form_message_data primary key (id);
alter table form_message_data add constraint 
	fk4form_of_form_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_message_data add constraint pk4id_of_form_field_message_data primary key (id);
alter table form_field_message_data add constraint 
	fk4form_of_form_field_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_data add constraint pk4id_of_form_field_data primary key (id);
alter table form_field_data add constraint 
	fk4form_of_form_field_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_action_data add constraint pk4id_of_form_action_data primary key (id);
alter table form_action_data add constraint 
	fk4form_of_form_action_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_workapp_identify_data add constraint pk4id_of_wechat_workapp_identify_data primary key (id);
alter table wechat_workapp_identify_data add constraint 
	fk4sec_user_of_wechat_workapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_miniapp_identify_data add constraint pk4id_of_wechat_miniapp_identify_data primary key (id);
alter table wechat_miniapp_identify_data add constraint 
	fk4sec_user_of_wechat_miniapp_identify_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table tree_node_data add constraint pk4id_of_tree_node_data primary key (id);
-- create extra index for time, number and mobile phone




create table info_lines(line varchar(400));

insert into info_lines values( '   SSSSSSSSSSSSSSS                                                                                                                  !!! ');
insert into info_lines values( ' SS:::::::::::::::S                                                                                                                !!:!!');
insert into info_lines values( 'S:::::SSSSSS::::::S                                                                                                                !:::!');
insert into info_lines values( 'S:::::S     SSSSSSS                                                                                                                !:::!');
insert into info_lines values( 'S:::::S            uuuuuu    uuuuuu      cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeee        ssssssssss       ssssssssss   !:::!');
insert into info_lines values( 'S:::::S            u::::u    u::::u    cc:::::::::::::::c  cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s    ss::::::::::s  !:::!');
insert into info_lines values( ' S::::SSSS         u::::u    u::::u   c:::::::::::::::::c c:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s !:::!');
insert into info_lines values( '  SS::::::SSSSS    u::::u    u::::u  c:::::::cccccc:::::cc:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s!:::!');
insert into info_lines values( '    SSS::::::::SS  u::::u    u::::u  c::::::c     cccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss !:::!');
insert into info_lines values( '       SSSSSS::::S u::::u    u::::u  c:::::c             c:::::c             e:::::::::::::::::e    s::::::s         s::::::s      !:::!');
insert into info_lines values( '            S:::::Su::::u    u::::u  c:::::c             c:::::c             e::::::eeeeeeeeeee        s::::::s         s::::::s   !!:!!');
insert into info_lines values( '            S:::::Su:::::uuuu:::::u  c::::::c     cccccccc::::::c     ccccccce:::::::e           ssssss   s:::::s ssssss   s:::::s  !!! ');
insert into info_lines values( 'SSSSSSS     S:::::Su:::::::::::::::uuc:::::::cccccc:::::cc:::::::cccccc:::::ce::::::::e          s:::::ssss::::::ss:::::ssss::::::s     ');
insert into info_lines values( 'S::::::SSSSSS:::::S u:::::::::::::::u c:::::::::::::::::c c:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s  !!! ');
insert into info_lines values( 'S:::::::::::::::SS   uu::::::::uu:::u  cc:::::::::::::::c  cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss  !!:!!');
insert into info_lines values( ' SSSSSSSSSSSSSSS       uuuuuuuu  uuuu    cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss      sssssssssss     !!! ');

select * from info_lines;
/* start with data patch */
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/his.sql */
-- no change request defined .
-- turn on safe mode
SET SQL_SAFE_UPDATES = 1;
-- change request type

/*
http://patorjk.com/software/taag/#p=testall&h=0&v=0&f=Graceful&t=Success!
   _____                                            _ 
  / ____|                                          | |
 | (___    _   _    ___    ___    ___   ___   ___  | |
  \\___   | | | |  / __|  / __|  / _  / __| / __| | |
  ____) | | |_| | | (__  | (__  |  __/ \\__  \\__  |_|
 |_____/   \\__,_|  \\___|  \\___|  \\___| |___/ |___/ (_)  
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

