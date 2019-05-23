-- BUILD WITH MODEL TIME 190326T1029
drop database  if exists his;
create database his;
-- alter  database his  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use his;

drop table  if exists hospital_data;
create table hospital_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(200)                             comment '名称',
	address             	varchar(24)                              comment '地址',
	telephone           	varchar(44)                              comment '电话',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医院";

drop table  if exists expense_type_data;
create table expense_type_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	helper_chars        	varchar(12)                              comment '辅助识字课',
	status              	varchar(8)                               comment '状态',
	hospital            	varchar(48)                              comment '医院',
	description         	longtext                                 comment '描述',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用类型";

drop table  if exists period_data;
create table period_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	hospital            	varchar(48)                              comment '医院',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "期";

drop table  if exists expense_item_data;
create table expense_item_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(20)                              comment '名称',
	price               	numeric(15,2)                            comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用项目";

drop table  if exists doctor_data;
create table doctor_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	shot_image          	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '拍摄的图像',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生";

drop table  if exists department_data;
create table department_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "部门";

drop table  if exists doctor_assignment_data;
create table doctor_assignment_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(40)                              comment '名称',
	doctor              	varchar(48)                              comment '医生',
	department          	varchar(48)                              comment '部门',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生的任务";

drop table  if exists doctor_schedule_data;
create table doctor_schedule_data (
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
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生安排";

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(48)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(48)          not null            comment 'ID',
	user_identity       	varchar(40)                              comment '用户身份',
	user_special_functions	varchar(200)                             comment '用户特殊功能',
	domain              	varchar(48)                              comment '域',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(48)          not null            comment 'ID',
	login               	varchar(20)                              comment '登录',
	mobile              	varchar(11)                              comment '手机号码',
	email               	varchar(76)                              comment '电子邮件',
	pwd                 	varchar(64)                              comment '密码',
	verification_code   	int                                      comment '验证码',
	verification_code_expire	datetime                                 comment '验证码过期',
	last_login_time     	datetime                                 comment '最后登录时间',
	domain              	varchar(48)                              comment '域',
	blocking            	varchar(48)                              comment '屏蔽',
	current_status      	varchar(28)                              comment '当前状态',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(48)          not null            comment 'ID',
	who                 	varchar(52)                              comment '谁',
	block_time          	datetime                                 comment '块时间',
	comments            	varchar(96)                              comment '评论',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户屏蔽";

drop table  if exists user_app_data;
create table user_app_data (
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
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";

drop table  if exists list_access_data;
create table list_access_data (
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
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";

drop table  if exists object_access_data;
create table object_access_data (
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
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(48)          not null            comment 'ID',
	login_time          	datetime                                 comment '登录时间',
	from_ip             	varchar(44)                              comment '来自IP',
	description         	varchar(16)                              comment '描述',
	sec_user            	varchar(48)                              comment '安全用户',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(20)                              comment '标题',
	description         	varchar(48)                              comment '描述',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(24)                              comment '标题',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(48)          not null            comment 'ID',
	title               	varchar(16)                              comment '标题',
	parameter_name      	varchar(16)                              comment '参数名称',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";

drop table  if exists form_field_data;
create table form_field_data (
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
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(48)          not null            comment 'ID',
	label               	varchar(8)                               comment '标签',
	locale_key          	varchar(16)                              comment '语言环境的关键',
	action_key          	varchar(24)                              comment '行动的关键',
	level               	varchar(28)                              comment '水平',
	url                 	varchar(168)                             comment 'url',
	form                	varchar(48)                              comment '形式',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";




insert into hospital_data values
	('H000001','上和医院','毕升路22号','028-9123123','1');

insert into expense_type_data values
	('ET000001','诊疗费','zlf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-05-12 11:25:40','1'),
	('ET000002','治疗费','zlf','停用','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-05-14 12:03:28','1'),
	('ET000003','检查费','jcf','正常','H000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','2019-05-05 00:41:00','1');

insert into period_data values
	('P000001','上午','H000001','1'),
	('P000002','下午','H000001','1'),
	('P000003','夜班','H000001','1');

insert into expense_item_data values
	('EI000001','专家诊疗费','80300859392.00','ET000001','H000001','2019-05-08 11:13:17','1'),
	('EI000002','血常规','92524765184.00','ET000001','H000001','2019-05-07 21:59:12','1'),
	('EI000003','煎药费','91322286080.00','ET000001','H000001','2019-05-20 18:15:36','1'),
	('EI000004','专家诊疗费','75394981888.00','ET000002','H000001','2019-05-19 17:58:47','1'),
	('EI000005','血常规','75753529344.00','ET000002','H000001','2019-05-11 21:02:43','1'),
	('EI000006','煎药费','98208243712.00','ET000002','H000001','2019-05-05 14:29:21','1'),
	('EI000007','专家诊疗费','87409254400.00','ET000003','H000001','2019-04-30 04:55:16','1'),
	('EI000008','血常规','75308408832.00','ET000003','H000001','2019-05-19 22:28:40','1'),
	('EI000009','煎药费','94797864960.00','ET000003','H000001','2019-05-05 12:52:49','1');

insert into doctor_data values
	('D000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-05-18 07:59:07','1'),
	('D000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-04-30 06:32:45','1'),
	('D000003','魏松全0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-05-13 08:22:37','1');

insert into department_data values
	('D000001','放射科','H000001','2019-05-01 05:50:00','1'),
	('D000002','放射科0002','H000001','2019-05-20 08:57:14','1'),
	('D000003','放射科0003','H000001','2019-05-07 09:18:26','1');

insert into doctor_assignment_data values
	('DA000001','魏松全在内分泌科室上','D000001','D000001','2019-05-02 00:26:23','1'),
	('DA000002','魏松全在内分泌科室上0002','D000001','D000001','2019-05-10 08:12:44','1'),
	('DA000003','魏松全在内分泌科室上0003','D000001','D000001','2019-05-01 02:01:19','1'),
	('DA000004','魏松全在内分泌科室上0004','D000002','D000002','2019-05-13 08:28:00','1'),
	('DA000005','魏松全在内分泌科室上0005','D000002','D000002','2019-05-17 17:30:25','1'),
	('DA000006','魏松全在内分泌科室上0006','D000002','D000002','2019-05-11 04:27:44','1'),
	('DA000007','魏松全在内分泌科室上0007','D000003','D000003','2019-05-01 09:11:00','1'),
	('DA000008','魏松全在内分泌科室上0008','D000003','D000003','2019-05-19 07:32:34','1'),
	('DA000009','魏松全在内分泌科室上0009','D000003','D000003','2019-05-01 02:10:02','1');

insert into doctor_schedule_data values
	('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D000001','2016-10-11','P000001','D000001','19','98.52','ET000001','2019-05-15 00:55:56','2019-05-11 23:32:00','H000001','1'),
	('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D000001','2017-10-31','P000001','D000001','15','104.13','ET000001','2019-05-14 14:03:21','2019-05-02 01:12:17','H000001','1'),
	('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D000001','2017-10-31','P000001','D000001','17','119.42','ET000001','2019-05-05 04:44:40','2019-05-18 06:35:52','H000001','1'),
	('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D000002','2018-09-03','P000002','D000002','16','115.67','ET000002','2019-05-04 20:45:55','2019-05-19 09:51:31','H000001','1'),
	('DS000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','D000002','2016-05-28','P000002','D000002','20','107.22','ET000002','2019-05-02 05:41:09','2019-05-12 16:02:07','H000001','1'),
	('DS000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','D000002','2016-09-21','P000002','D000002','19','119.37','ET000002','2019-05-13 11:22:14','2019-05-05 17:21:05','H000001','1'),
	('DS000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','D000003','2017-01-05','P000003','D000003','19','91.92','ET000003','2019-05-16 08:21:05','2019-05-04 20:04:41','H000001','1'),
	('DS000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','D000003','2017-06-03','P000003','D000003','16','111.90','ET000003','2019-05-10 15:31:33','2019-05-12 20:14:10','H000001','1'),
	('DS000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','D000003','2018-08-24','P000003','D000003','19','90.82','ET000003','2019-05-18 07:43:59','2019-05-21 19:01:35','H000001','1');

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1'),
	('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-05-05 06:27:53','2019-05-07 18:22:03','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-05-21 01:32:23','2019-05-03 18:47:59','UD000001',NULL,'BLOCKED0002','1'),
	('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-05-03 10:51:18','2019-05-05 10:23:48','UD000001',NULL,'BLOCKED0003','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-05-11 12:08:34','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA000005','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1'),
	('UA000007','审车平台','SU000003','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1'),
	('UA000008','账户管理','SU000003','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0008','1'),
	('UA000009','接车公司','SU000003','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000001','1'),
	('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000002','1'),
	('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000002','1'),
	('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000002','1'),
	('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000003','1'),
	('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000003','1'),
	('LA000009','列表0009','levelOneCategoryList0009',1,1,1,1,1,'UA000003','1'),
	('LA000010','列表0010','levelOneCategoryList0010',1,1,1,1,1,'UA000004','1'),
	('LA000011','列表0011','levelOneCategoryList0011',1,1,1,1,1,'UA000004','1'),
	('LA000012','列表0012','levelOneCategoryList0012',1,1,1,1,1,'UA000004','1'),
	('LA000013','列表0013','levelOneCategoryList0013',1,1,1,1,1,'UA000005','1'),
	('LA000014','列表0014','levelOneCategoryList0014',1,1,1,1,1,'UA000005','1'),
	('LA000015','列表0015','levelOneCategoryList0015',1,1,1,1,1,'UA000005','1'),
	('LA000016','列表0016','levelOneCategoryList0016',1,1,1,1,1,'UA000006','1'),
	('LA000017','列表0017','levelOneCategoryList0017',1,1,1,1,1,'UA000006','1'),
	('LA000018','列表0018','levelOneCategoryList0018',1,1,1,1,1,'UA000006','1'),
	('LA000019','列表0019','levelOneCategoryList0019',1,1,1,1,1,'UA000007','1'),
	('LA000020','列表0020','levelOneCategoryList0020',1,1,1,1,1,'UA000007','1'),
	('LA000021','列表0021','levelOneCategoryList0021',1,1,1,1,1,'UA000007','1'),
	('LA000022','列表0022','levelOneCategoryList0022',1,1,1,1,1,'UA000008','1'),
	('LA000023','列表0023','levelOneCategoryList0023',1,1,1,1,1,'UA000008','1'),
	('LA000024','列表0024','levelOneCategoryList0024',1,1,1,1,1,'UA000008','1'),
	('LA000025','列表0025','levelOneCategoryList0025',1,1,1,1,1,'UA000009','1'),
	('LA000026','列表0026','levelOneCategoryList0026',1,1,1,1,1,'UA000009','1'),
	('LA000027','列表0027','levelOneCategoryList0027',1,1,1,1,1,'UA000009','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1'),
	('OA000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1'),
	('OA000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1'),
	('OA000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1'),
	('OA000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1'),
	('OA000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1'),
	('OA000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1'),
	('OA000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1'),
	('OA000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1'),
	('OA000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1'),
	('OA000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1'),
	('OA000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1'),
	('OA000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');

insert into login_history_data values
	('LH000001','2019-04-30 08:35:53','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-05-17 04:55:07','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-05-10 05:46:21','192.168.1.1','登陆成功0003','SU000001','1'),
	('LH000004','2019-05-04 19:33:23','192.168.1.2','登陆成功0004','SU000002','1'),
	('LH000005','2019-05-01 12:07:37','192.168.1.1','登陆成功0005','SU000002','1'),
	('LH000006','2019-05-05 00:12:59','192.168.1.2','登陆成功0006','SU000002','1'),
	('LH000007','2019-05-11 19:25:42','192.168.1.1','登陆成功0007','SU000003','1'),
	('LH000008','2019-05-02 15:03:12','192.168.1.2','登陆成功0008','SU000003','1'),
	('LH000009','2019-05-19 12:26:24','192.168.1.1','登陆成功0009','SU000003','1');

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1'),
	('FM000003','字段组合错误0003','GF000001','warning','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1'),
	('FFM000003','输入错误0003','name0003','GF000001','warning','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',1,1,1,'','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',1,1,1,'','','1'),
	('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',1,1,1,'','','1'),
	('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',1,1,1,'男,女','男,女','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1'),
	('FA000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF000001','1');



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










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','医院','SU000001','hospital',1,'MXWR','Hospital','H000001','/link/to/app','1'); -- REFER COUNT: 6
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 6
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','费用类型','SU000002','pen',1,'MXWR','ExpenseType','ET000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','医生','SU000003','address-book',1,'MXWR','Doctor','D000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','部门','SU000004','address-book',1,'MXWR','Department','D000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','F8D472FBE8716BFB66C0A9BC73208FE4C5971051D240D9AC3B5EBCEF05CD5FFA','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','用户域','SU000005','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000010','My Account','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','FEE10F101DD4B9D2C98FAA1A672821DF22B9FA662528ED5B885B60C0979E6530','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','安全用户','SU000006','user',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000012','My Account','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','016B4A47737559D64FC1369AA4D8CFD0B47E11F4C6219E80946C0E47A4C1C74B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','用户应用程序','SU000007','user',1,'MXWR','UserApp','UA000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000014','My Account','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1'); -- REFER COUNT: 2




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
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/his.sql */


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

