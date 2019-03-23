<<<<<<< HEAD
-- BUILD WITH MODEL TIME 190321T1712
=======
-- BUILD WITH MODEL TIME 190312T1224
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
drop database  if exists his;
create database his;
alter  database his  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use his;

drop table  if exists hospital_data;
create table hospital_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(200)                             comment '名称',
	address             	varchar(24)                              comment '地址',
	telephone           	varchar(44)                              comment '电话',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医院";

drop table  if exists expense_type_data;
create table expense_type_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	helper_chars        	varchar(12)                              comment '辅助识字课',
	status              	varchar(8)                               comment '状态',
	hospital            	varchar(48)                              comment '医院',
	description         	longtext                                 comment '描述',
<<<<<<< HEAD
	update_time         	datetime                                 comment '更新时间',
=======
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用类型";

drop table  if exists period_data;
create table period_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	hospital            	varchar(48)                              comment '医院',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "期";

drop table  if exists expense_item_data;
create table expense_item_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(20)                              comment '名称',
<<<<<<< HEAD
	price               	numeric(15,2)                            comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
=======
	price               	numeric(6,2)                             comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	hospital            	varchar(48)                              comment '医院',
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "费用项目";

drop table  if exists doctor_data;
create table doctor_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
<<<<<<< HEAD
	shot_image          	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '拍摄的图像',
	hospital            	varchar(48)                              comment '医院',
	update_time         	datetime                                 comment '更新时间',
=======
	hospital            	varchar(48)                              comment '医院',
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生";

drop table  if exists department_data;
create table department_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	hospital            	varchar(48)                              comment '医院',
<<<<<<< HEAD
	update_time         	datetime                                 comment '更新时间',
=======
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "部门";

drop table  if exists doctor_assignment_data;
create table doctor_assignment_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(40)                              comment '名称',
	doctor              	varchar(48)                              comment '医生',
	department          	varchar(48)                              comment '部门',
<<<<<<< HEAD
	update_time         	datetime                                 comment '更新时间',
=======
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生的任务";

drop table  if exists doctor_schedule_data;
create table doctor_schedule_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(116)                             comment '名称',
<<<<<<< HEAD
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
=======
	schedule_date       	date                                     comment '安排日期',
	period              	varchar(8)                               comment '期',
	doctor              	varchar(48)                              comment '医生',
	available           	int                                      comment '可用',
	price               	numeric(7,2)                             comment '价格',
	expense_type        	varchar(48)                              comment '费用类型',
	department          	varchar(48)                              comment '部门',
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "医生安排";

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'ID',
	user_identity       	varchar(40)                              comment '用户身份',
	user_special_functions	varchar(200)                             comment '用户特殊功能',
	domain              	varchar(48)                              comment '域',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'ID',
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
	id                  	varchar(64)          not null            comment 'ID',
	who                 	varchar(52)                              comment '谁',
	block_time          	datetime                                 comment '块时间',
	comments            	varchar(96)                              comment '评论',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户屏蔽";

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(300)                             comment '标题',
	sec_user            	varchar(48)                              comment '安全用户',
	app_icon            	varchar(36)                              comment '应用程序图标',
	full_access         	tinyint                                  comment '完全访问',
	permission          	varchar(16)                              comment '许可',
	object_type         	varchar(108)                             comment '访问对象类型',
	object_id           	varchar(40)                              comment '对象ID',
	location            	varchar(48)                              comment '位置',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'ID',
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
	id                  	varchar(64)          not null            comment 'ID',
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
	id                  	varchar(64)          not null            comment 'ID',
	login_time          	datetime                                 comment '登录时间',
	from_ip             	varchar(44)                              comment '来自IP',
	description         	varchar(16)                              comment '描述',
	sec_user            	varchar(48)                              comment '安全用户',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(20)                              comment '标题',
	description         	varchar(48)                              comment '描述',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(24)                              comment '标题',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(16)                              comment '标题',
	parameter_name      	varchar(16)                              comment '参数名称',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'ID',
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
	id                  	varchar(64)          not null            comment 'ID',
	label               	varchar(8)                               comment '标签',
	locale_key          	varchar(16)                              comment '语言环境的关键',
	action_key          	varchar(24)                              comment '行动的关键',
	level               	varchar(28)                              comment '水平',
	url                 	varchar(168)                             comment 'url',
	form                	varchar(48)                              comment '形式',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";






	
insert into hospital_data values ('H000001','上和医院','毕升路22号','028-9123123','1');

	
insert into expense_type_data values ('ET000001','诊疗费','zlf','正常','H000001','    ���������������������
���������������

���������������

','2019-03-18 04:21:32','1');
insert into expense_type_data values ('ET000002','治疗费','zlf','停用','H000001','    ���������������������
���������������

���������������

','2019-03-19 20:03:47','1');
insert into expense_type_data values ('ET000003','检查费','jcf','正常','H000001','    ���������������������
���������������

���������������

','2019-03-13 16:47:02','1');
insert into expense_type_data values ('ET000004','诊疗费','zlf','停用','H000001','    ���������������������
���������������

���������������

','2019-03-03 02:24:40','1');
insert into expense_type_data values ('ET000005','治疗费','zlf','正常','H000001','    ���������������������
���������������

���������������

','2019-03-10 16:34:33','1');

	
insert into period_data values ('P000001','上午','H000001','1');
insert into period_data values ('P000002','下午','H000001','1');
insert into period_data values ('P000003','夜班','H000001','1');

	
<<<<<<< HEAD
insert into expense_item_data values ('EI000001','专家诊疗费','76940247040.00','ET000001','H000001','2019-03-02 12:41:16','1');
insert into expense_item_data values ('EI000002','血常规','78313455616.00','ET000001','H000001','2019-03-02 19:19:41','1');
insert into expense_item_data values ('EI000003','煎药费','96566648832.00','ET000001','H000001','2019-03-21 02:24:45','1');
insert into expense_item_data values ('EI000004','专家诊疗费','79088369664.00','ET000001','H000001','2019-03-07 06:26:29','1');
insert into expense_item_data values ('EI000005','血常规','93138272256.00','ET000001','H000001','2019-03-03 02:03:09','1');
insert into expense_item_data values ('EI000006','煎药费','94807949312.00','ET000002','H000001','2019-03-12 02:43:54','1');
insert into expense_item_data values ('EI000007','专家诊疗费','93973094400.00','ET000002','H000001','2019-03-14 16:53:25','1');
insert into expense_item_data values ('EI000008','血常规','89950314496.00','ET000002','H000001','2019-03-13 15:09:48','1');
insert into expense_item_data values ('EI000009','煎药费','98153816064.00','ET000002','H000001','2019-03-14 19:58:40','1');
insert into expense_item_data values ('EI000010','专家诊疗费','78816378880.00','ET000002','H000001','2019-03-14 09:23:26','1');
insert into expense_item_data values ('EI000011','血常规','74534379520.00','ET000003','H000001','2019-03-14 09:00:15','1');
insert into expense_item_data values ('EI000012','煎药费','87033511936.00','ET000003','H000001','2019-03-21 22:26:54','1');
insert into expense_item_data values ('EI000013','专家诊疗费','83930587136.00','ET000003','H000001','2019-03-01 10:58:33','1');
insert into expense_item_data values ('EI000014','血常规','70466887680.00','ET000003','H000001','2019-03-17 09:37:53','1');
insert into expense_item_data values ('EI000015','煎药费','97071185920.00','ET000003','H000001','2019-03-11 13:31:52','1');
insert into expense_item_data values ('EI000016','专家诊疗费','72318672896.00','ET000004','H000001','2019-03-11 03:55:21','1');
insert into expense_item_data values ('EI000017','血常规','89309331456.00','ET000004','H000001','2019-03-10 08:26:35','1');
insert into expense_item_data values ('EI000018','煎药费','96900554752.00','ET000004','H000001','2019-03-07 15:40:13','1');
insert into expense_item_data values ('EI000019','专家诊疗费','81580990464.00','ET000004','H000001','2019-03-18 22:36:27','1');
insert into expense_item_data values ('EI000020','血常规','70332628992.00','ET000004','H000001','2019-03-14 23:22:28','1');
insert into expense_item_data values ('EI000021','煎药费','84645281792.00','ET000005','H000001','2019-03-15 07:47:41','1');
insert into expense_item_data values ('EI000022','专家诊疗费','84251615232.00','ET000005','H000001','2019-03-18 00:13:36','1');
insert into expense_item_data values ('EI000023','血常规','70253551616.00','ET000005','H000001','2019-03-07 12:14:43','1');
insert into expense_item_data values ('EI000024','煎药费','88504147968.00','ET000005','H000001','2019-03-06 04:40:27','1');
insert into expense_item_data values ('EI000025','专家诊疗费','78567317504.00','ET000005','H000001','2019-03-09 04:48:26','1');
=======
insert into expense_item_data values ('EI000001','专家诊疗费','84.06','ET000001','H000001','1');
insert into expense_item_data values ('EI000002','血常规','71.73','ET000001','H000001','1');
insert into expense_item_data values ('EI000003','煎药费','94.26','ET000001','H000001','1');
insert into expense_item_data values ('EI000004','专家诊疗费','90.14','ET000001','H000001','1');
insert into expense_item_data values ('EI000005','血常规','88.66','ET000001','H000001','1');
insert into expense_item_data values ('EI000006','煎药费','81.40','ET000002','H000001','1');
insert into expense_item_data values ('EI000007','专家诊疗费','70.01','ET000002','H000001','1');
insert into expense_item_data values ('EI000008','血常规','90.21','ET000002','H000001','1');
insert into expense_item_data values ('EI000009','煎药费','74.37','ET000002','H000001','1');
insert into expense_item_data values ('EI000010','专家诊疗费','75.63','ET000002','H000001','1');
insert into expense_item_data values ('EI000011','血常规','87.47','ET000003','H000001','1');
insert into expense_item_data values ('EI000012','煎药费','87.01','ET000003','H000001','1');
insert into expense_item_data values ('EI000013','专家诊疗费','75.93','ET000003','H000001','1');
insert into expense_item_data values ('EI000014','血常规','71.70','ET000003','H000001','1');
insert into expense_item_data values ('EI000015','煎药费','92.61','ET000003','H000001','1');
insert into expense_item_data values ('EI000016','专家诊疗费','86.13','ET000004','H000001','1');
insert into expense_item_data values ('EI000017','血常规','75.99','ET000004','H000001','1');
insert into expense_item_data values ('EI000018','煎药费','73.05','ET000004','H000001','1');
insert into expense_item_data values ('EI000019','专家诊疗费','89.01','ET000004','H000001','1');
insert into expense_item_data values ('EI000020','血常规','79.14','ET000004','H000001','1');
insert into expense_item_data values ('EI000021','煎药费','76.35','ET000005','H000001','1');
insert into expense_item_data values ('EI000022','专家诊疗费','92.15','ET000005','H000001','1');
insert into expense_item_data values ('EI000023','血常规','80.15','ET000005','H000001','1');
insert into expense_item_data values ('EI000024','煎药费','76.22','ET000005','H000001','1');
insert into expense_item_data values ('EI000025','专家诊疗费','97.55','ET000005','H000001','1');
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

	
insert into doctor_data values ('D000001','魏松全','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-03-05 21:39:18','1');
insert into doctor_data values ('D000002','魏松全0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-03-08 05:29:58','1');
insert into doctor_data values ('D000003','魏松全0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-03-18 05:17:04','1');
insert into doctor_data values ('D000004','魏松全0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-03-19 08:58:28','1');
insert into doctor_data values ('D000005','魏松全0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/snap.shot00/400/300/red/','H000001','2019-03-04 06:57:51','1');

	
insert into department_data values ('D000001','放射科','H000001','2019-03-07 23:59:19','1');
insert into department_data values ('D000002','放射科0002','H000001','2019-03-07 12:58:20','1');
insert into department_data values ('D000003','放射科0003','H000001','2019-03-02 03:27:07','1');
insert into department_data values ('D000004','放射科0004','H000001','2019-03-02 23:46:23','1');
insert into department_data values ('D000005','放射科0005','H000001','2019-03-15 00:01:54','1');

	
insert into doctor_assignment_data values ('DA000001','魏松全在内分泌科室上','D000001','D000001','2019-03-09 16:49:18','1');
insert into doctor_assignment_data values ('DA000002','魏松全在内分泌科室上0002','D000001','D000001','2019-03-05 06:35:01','1');
insert into doctor_assignment_data values ('DA000003','魏松全在内分泌科室上0003','D000001','D000001','2019-03-21 04:49:41','1');
insert into doctor_assignment_data values ('DA000004','魏松全在内分泌科室上0004','D000001','D000001','2019-03-15 01:31:39','1');
insert into doctor_assignment_data values ('DA000005','魏松全在内分泌科室上0005','D000001','D000001','2019-03-18 17:52:57','1');
insert into doctor_assignment_data values ('DA000006','魏松全在内分泌科室上0006','D000002','D000002','2019-03-03 03:17:33','1');
insert into doctor_assignment_data values ('DA000007','魏松全在内分泌科室上0007','D000002','D000002','2019-03-12 10:51:56','1');
insert into doctor_assignment_data values ('DA000008','魏松全在内分泌科室上0008','D000002','D000002','2019-03-04 05:11:35','1');
insert into doctor_assignment_data values ('DA000009','魏松全在内分泌科室上0009','D000002','D000002','2019-03-18 03:19:26','1');
insert into doctor_assignment_data values ('DA000010','魏松全在内分泌科室上0010','D000002','D000002','2019-03-14 12:44:48','1');
insert into doctor_assignment_data values ('DA000011','魏松全在内分泌科室上0011','D000003','D000003','2019-03-19 09:42:10','1');
insert into doctor_assignment_data values ('DA000012','魏松全在内分泌科室上0012','D000003','D000003','2019-03-14 06:38:40','1');
insert into doctor_assignment_data values ('DA000013','魏松全在内分泌科室上0013','D000003','D000003','2019-03-09 18:52:15','1');
insert into doctor_assignment_data values ('DA000014','魏松全在内分泌科室上0014','D000003','D000003','2019-03-01 19:07:47','1');
insert into doctor_assignment_data values ('DA000015','魏松全在内分泌科室上0015','D000003','D000003','2019-02-28 19:51:19','1');
insert into doctor_assignment_data values ('DA000016','魏松全在内分泌科室上0016','D000004','D000004','2019-03-02 11:36:26','1');
insert into doctor_assignment_data values ('DA000017','魏松全在内分泌科室上0017','D000004','D000004','2019-03-19 23:27:16','1');
insert into doctor_assignment_data values ('DA000018','魏松全在内分泌科室上0018','D000004','D000004','2019-03-12 17:30:10','1');
insert into doctor_assignment_data values ('DA000019','魏松全在内分泌科室上0019','D000004','D000004','2019-03-01 09:08:27','1');
insert into doctor_assignment_data values ('DA000020','魏松全在内分泌科室上0020','D000004','D000004','2019-03-05 20:43:20','1');
insert into doctor_assignment_data values ('DA000021','魏松全在内分泌科室上0021','D000005','D000005','2019-03-01 06:02:17','1');
insert into doctor_assignment_data values ('DA000022','魏松全在内分泌科室上0022','D000005','D000005','2019-03-17 00:09:56','1');
insert into doctor_assignment_data values ('DA000023','魏松全在内分泌科室上0023','D000005','D000005','2019-03-01 11:14:40','1');
insert into doctor_assignment_data values ('DA000024','魏松全在内分泌科室上0024','D000005','D000005','2019-03-17 06:51:12','1');
insert into doctor_assignment_data values ('DA000025','魏松全在内分泌科室上0025','D000005','D000005','2019-03-03 19:24:24','1');

	
<<<<<<< HEAD
insert into doctor_schedule_data values ('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','D000001','2017-06-12','P000001','D000001','20','93.04','ET000001','2019-03-21 20:56:30','2019-03-21 12:10:19','H000001','1');
insert into doctor_schedule_data values ('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','D000001','2018-02-12','P000001','D000001','19','105.47','ET000001','2019-03-02 01:54:47','2019-03-03 02:42:36','H000001','1');
insert into doctor_schedule_data values ('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','D000001','2017-08-08','P000001','D000001','20','96.22','ET000001','2019-03-07 19:44:10','2019-03-21 22:52:41','H000001','1');
insert into doctor_schedule_data values ('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','D000001','2018-04-19','P000001','D000001','18','94.59','ET000001','2019-03-06 13:58:21','2019-03-06 14:10:21','H000001','1');
insert into doctor_schedule_data values ('DS000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','D000001','2018-01-16','P000001','D000001','18','101.69','ET000001','2019-03-17 05:17:01','2019-03-08 17:58:41','H000001','1');
insert into doctor_schedule_data values ('DS000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','D000002','2016-10-26','P000001','D000002','19','97.42','ET000002','2019-03-04 22:24:11','2019-03-09 10:34:17','H000001','1');
insert into doctor_schedule_data values ('DS000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','D000002','2017-04-28','P000001','D000002','19','104.65','ET000002','2019-03-04 01:23:56','2019-03-05 13:01:17','H000001','1');
insert into doctor_schedule_data values ('DS000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','D000002','2018-09-30','P000001','D000002','20','108.21','ET000002','2019-03-02 21:07:40','2019-03-03 02:23:45','H000001','1');
insert into doctor_schedule_data values ('DS000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','D000002','2017-04-26','P000001','D000002','16','100.33','ET000002','2019-02-28 22:19:16','2019-03-03 15:46:06','H000001','1');
insert into doctor_schedule_data values ('DS000010','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100010','D000002','2018-12-12','P000002','D000002','19','122.85','ET000002','2019-03-06 17:19:01','2019-03-03 07:03:19','H000001','1');
insert into doctor_schedule_data values ('DS000011','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100011','D000003','2016-07-15','P000002','D000003','17','93.13','ET000003','2019-03-18 02:31:14','2019-03-01 05:07:19','H000001','1');
insert into doctor_schedule_data values ('DS000012','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100012','D000003','2018-05-25','P000002','D000003','20','113.78','ET000003','2019-03-10 06:48:31','2019-03-11 06:52:32','H000001','1');
insert into doctor_schedule_data values ('DS000013','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100013','D000003','2017-05-14','P000002','D000003','19','93.25','ET000003','2019-02-28 19:14:59','2019-03-12 12:18:31','H000001','1');
insert into doctor_schedule_data values ('DS000014','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100014','D000003','2017-07-12','P000002','D000003','19','105.19','ET000003','2019-03-04 00:10:37','2019-03-17 05:43:23','H000001','1');
insert into doctor_schedule_data values ('DS000015','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100015','D000003','2016-07-24','P000002','D000003','15','89.07','ET000003','2019-03-07 15:07:43','2019-03-09 23:07:12','H000001','1');
insert into doctor_schedule_data values ('DS000016','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100016','D000004','2019-02-21','P000002','D000004','19','105.82','ET000004','2019-03-11 16:23:34','2019-03-15 03:52:07','H000001','1');
insert into doctor_schedule_data values ('DS000017','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100017','D000004','2017-10-05','P000002','D000004','18','112.01','ET000004','2019-03-15 07:49:06','2019-03-12 00:14:29','H000001','1');
insert into doctor_schedule_data values ('DS000018','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100018','D000004','2017-08-27','P000003','D000004','15','120.97','ET000004','2019-03-13 04:24:19','2019-03-03 06:36:21','H000001','1');
insert into doctor_schedule_data values ('DS000019','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100019','D000004','2017-09-18','P000003','D000004','19','111.99','ET000004','2019-03-04 14:11:44','2019-03-07 12:15:45','H000001','1');
insert into doctor_schedule_data values ('DS000020','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100020','D000004','2018-02-21','P000003','D000004','16','90.35','ET000004','2019-03-08 03:11:34','2019-03-12 23:53:42','H000001','1');
insert into doctor_schedule_data values ('DS000021','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100021','D000005','2016-09-24','P000003','D000005','17','104.10','ET000005','2019-03-16 11:39:17','2019-03-21 10:34:47','H000001','1');
insert into doctor_schedule_data values ('DS000022','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100022','D000005','2018-02-07','P000003','D000005','20','95.14','ET000005','2019-03-21 06:22:50','2019-03-20 21:33:49','H000001','1');
insert into doctor_schedule_data values ('DS000023','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100023','D000005','2017-08-29','P000003','D000005','19','90.18','ET000005','2019-03-06 14:20:18','2019-03-07 21:13:32','H000001','1');
insert into doctor_schedule_data values ('DS000024','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100024','D000005','2018-04-15','P000003','D000005','19','99.21','ET000005','2019-03-18 13:48:46','2019-03-11 20:32:34','H000001','1');
insert into doctor_schedule_data values ('DS000025','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100025','D000005','2016-05-16','P000003','D000005','19','107.30','ET000005','2019-03-19 19:03:25','2019-03-19 20:42:14','H000001','1');
=======
insert into doctor_schedule_data values ('DS000001','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10','2018-03-21','上午','D000001','15','104.78','ET000001','D000001','1');
insert into doctor_schedule_data values ('DS000002','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100002','2017-10-14','下午','D000001','15','115.28','ET000001','D000001','1');
insert into doctor_schedule_data values ('DS000003','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100003','2018-03-08','夜班','D000001','19','99.60','ET000001','D000001','1');
insert into doctor_schedule_data values ('DS000004','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100004','2018-05-30','上午','D000001','17','111.44','ET000001','D000001','1');
insert into doctor_schedule_data values ('DS000005','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100005','2017-06-10','下午','D000001','19','104.39','ET000001','D000001','1');
insert into doctor_schedule_data values ('DS000006','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100006','2017-01-29','夜班','D000002','17','112.71','ET000002','D000002','1');
insert into doctor_schedule_data values ('DS000007','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100007','2018-01-16','上午','D000002','15','107.62','ET000002','D000002','1');
insert into doctor_schedule_data values ('DS000008','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100008','2017-08-25','下午','D000002','17','108.43','ET000002','D000002','1');
insert into doctor_schedule_data values ('DS000009','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100009','2018-11-17','夜班','D000002','16','117.13','ET000002','D000002','1');
insert into doctor_schedule_data values ('DS000010','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100010','2017-04-23','上午','D000002','18','105.12','ET000002','D000002','1');
insert into doctor_schedule_data values ('DS000011','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100011','2017-10-19','下午','D000003','16','118.88','ET000003','D000003','1');
insert into doctor_schedule_data values ('DS000012','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100012','2018-05-01','夜班','D000003','19','89.21','ET000003','D000003','1');
insert into doctor_schedule_data values ('DS000013','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100013','2017-05-10','上午','D000003','19','96.91','ET000003','D000003','1');
insert into doctor_schedule_data values ('DS000014','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100014','2018-01-30','下午','D000003','19','114.05','ET000003','D000003','1');
insert into doctor_schedule_data values ('DS000015','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100015','2016-11-28','夜班','D000003','15','91.40','ET000003','D000003','1');
insert into doctor_schedule_data values ('DS000016','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100016','2017-06-06','上午','D000004','16','123.86','ET000004','D000004','1');
insert into doctor_schedule_data values ('DS000017','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100017','2019-01-01','下午','D000004','19','117.34','ET000004','D000004','1');
insert into doctor_schedule_data values ('DS000018','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100018','2018-09-30','夜班','D000004','19','106.43','ET000004','D000004','1');
insert into doctor_schedule_data values ('DS000019','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100019','2019-03-04','上午','D000004','16','96.41','ET000004','D000004','1');
insert into doctor_schedule_data values ('DS000020','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100020','2017-05-03','下午','D000004','17','98.08','ET000004','D000004','1');
insert into doctor_schedule_data values ('DS000021','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100021','2016-09-12','夜班','D000005','16','110.44','ET000005','D000005','1');
insert into doctor_schedule_data values ('DS000022','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100022','2017-12-19','上午','D000005','17','92.47','ET000005','D000005','1');
insert into doctor_schedule_data values ('DS000023','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100023','2018-05-16','下午','D000005','17','94.97','ET000005','D000005','1');
insert into doctor_schedule_data values ('DS000024','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100024','2017-06-07','夜班','D000005','19','112.90','ET000005','D000005','1');
insert into doctor_schedule_data values ('DS000025','2019年3月11日魏松全在内分泌科坐班收诊疗费,每个100025','2018-06-23','上午','D000005','17','110.17','ET000005','D000005','1');
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');
insert into user_white_list_data values ('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');
insert into user_white_list_data values ('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');
insert into user_white_list_data values ('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1');

	
<<<<<<< HEAD
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-03-19 01:07:58','2019-03-03 09:39:09','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-03-04 05:28:57','2019-02-28 23:42:46','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-03-02 21:39:56','2019-03-13 04:23:42','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-03-16 01:11:05','2019-03-05 16:15:40','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-03-07 02:37:26','2019-03-19 04:16:17','UD000001',NULL,'BLOCKED0005','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-03-10 15:03:10','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');
=======
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-03-01 04:52:49','2019-03-01 19:34:47','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-28 18:28:46','2019-02-24 18:02:08','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-03-08 03:38:30','2019-02-20 15:25:36','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-02-21 04:46:48','2019-03-04 21:09:19','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-03-03 13:16:29','2019-03-11 19:48:54','UD000001',NULL,'BLOCKED0005','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-02-20 02:59:52','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000001','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000001','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');
insert into user_app_data values ('UA000007','审车平台','SU000002','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1');
insert into user_app_data values ('UA000008','账户管理','SU000002','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0008','1');
insert into user_app_data values ('UA000009','接车公司','SU000002','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1');
insert into user_app_data values ('UA000010','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1');
insert into user_app_data values ('UA000011','维修公司','SU000003','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1');
insert into user_app_data values ('UA000012','顾客','SU000003','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0012','1');
insert into user_app_data values ('UA000013','审车平台','SU000003','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1');
insert into user_app_data values ('UA000014','账户管理','SU000003','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0014','1');
insert into user_app_data values ('UA000015','接车公司','SU000003','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1');
insert into user_app_data values ('UA000016','审车公司','SU000004','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1');
insert into user_app_data values ('UA000017','维修公司','SU000004','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0017','1');
insert into user_app_data values ('UA000018','顾客','SU000004','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0018','1');
insert into user_app_data values ('UA000019','审车平台','SU000004','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0019','1');
insert into user_app_data values ('UA000020','账户管理','SU000004','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0020','1');
insert into user_app_data values ('UA000021','接车公司','SU000005','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0021','1');
insert into user_app_data values ('UA000022','审车公司','SU000005','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0022','1');
insert into user_app_data values ('UA000023','维修公司','SU000005','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0023','1');
insert into user_app_data values ('UA000024','顾客','SU000005','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0024','1');
insert into user_app_data values ('UA000025','审车平台','SU000005','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0025','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000009','列表0009','levelOneCategoryList0009',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000010','列表0010','levelOneCategoryList0010',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000011','列表0011','levelOneCategoryList0011',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000012','列表0012','levelOneCategoryList0012',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000013','列表0013','levelOneCategoryList0013',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000014','列表0014','levelOneCategoryList0014',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000015','列表0015','levelOneCategoryList0015',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000016','列表0016','levelOneCategoryList0016',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000017','列表0017','levelOneCategoryList0017',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000018','列表0018','levelOneCategoryList0018',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000019','列表0019','levelOneCategoryList0019',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000020','列表0020','levelOneCategoryList0020',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000021','列表0021','levelOneCategoryList0021',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000022','列表0022','levelOneCategoryList0022',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000023','列表0023','levelOneCategoryList0023',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000024','列表0024','levelOneCategoryList0024',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000025','列表0025','levelOneCategoryList0025',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000026','列表0026','levelOneCategoryList0026',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000027','列表0027','levelOneCategoryList0027',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000028','列表0028','levelOneCategoryList0028',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000029','列表0029','levelOneCategoryList0029',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000030','列表0030','levelOneCategoryList0030',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000031','列表0031','levelOneCategoryList0031',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000032','列表0032','levelOneCategoryList0032',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000033','列表0033','levelOneCategoryList0033',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000034','列表0034','levelOneCategoryList0034',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000035','列表0035','levelOneCategoryList0035',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000036','列表0036','levelOneCategoryList0036',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000037','列表0037','levelOneCategoryList0037',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000038','列表0038','levelOneCategoryList0038',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000039','列表0039','levelOneCategoryList0039',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000040','列表0040','levelOneCategoryList0040',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000041','列表0041','levelOneCategoryList0041',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000042','列表0042','levelOneCategoryList0042',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000043','列表0043','levelOneCategoryList0043',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000044','列表0044','levelOneCategoryList0044',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000045','列表0045','levelOneCategoryList0045',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000046','列表0046','levelOneCategoryList0046',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000047','列表0047','levelOneCategoryList0047',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000048','列表0048','levelOneCategoryList0048',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000049','列表0049','levelOneCategoryList0049',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000050','列表0050','levelOneCategoryList0050',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000051','列表0051','levelOneCategoryList0051',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000052','列表0052','levelOneCategoryList0052',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000053','列表0053','levelOneCategoryList0053',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000054','列表0054','levelOneCategoryList0054',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000055','列表0055','levelOneCategoryList0055',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000056','列表0056','levelOneCategoryList0056',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000057','列表0057','levelOneCategoryList0057',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000058','列表0058','levelOneCategoryList0058',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000059','列表0059','levelOneCategoryList0059',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000060','列表0060','levelOneCategoryList0060',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000061','列表0061','levelOneCategoryList0061',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000062','列表0062','levelOneCategoryList0062',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000063','列表0063','levelOneCategoryList0063',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000064','列表0064','levelOneCategoryList0064',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000065','列表0065','levelOneCategoryList0065',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000066','列表0066','levelOneCategoryList0066',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000067','列表0067','levelOneCategoryList0067',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000068','列表0068','levelOneCategoryList0068',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000069','列表0069','levelOneCategoryList0069',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000070','列表0070','levelOneCategoryList0070',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000071','列表0071','levelOneCategoryList0071',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000072','列表0072','levelOneCategoryList0072',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000073','列表0073','levelOneCategoryList0073',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000074','列表0074','levelOneCategoryList0074',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000075','列表0075','levelOneCategoryList0075',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000076','列表0076','levelOneCategoryList0076',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000077','列表0077','levelOneCategoryList0077',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000078','列表0078','levelOneCategoryList0078',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000079','列表0079','levelOneCategoryList0079',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000080','列表0080','levelOneCategoryList0080',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000081','列表0081','levelOneCategoryList0081',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000082','列表0082','levelOneCategoryList0082',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000083','列表0083','levelOneCategoryList0083',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000084','列表0084','levelOneCategoryList0084',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000085','列表0085','levelOneCategoryList0085',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000086','列表0086','levelOneCategoryList0086',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000087','列表0087','levelOneCategoryList0087',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000088','列表0088','levelOneCategoryList0088',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000089','列表0089','levelOneCategoryList0089',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000090','列表0090','levelOneCategoryList0090',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000091','列表0091','levelOneCategoryList0091',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000092','列表0092','levelOneCategoryList0092',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000093','列表0093','levelOneCategoryList0093',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000094','列表0094','levelOneCategoryList0094',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000095','列表0095','levelOneCategoryList0095',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000096','列表0096','levelOneCategoryList0096',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000097','列表0097','levelOneCategoryList0097',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000098','列表0098','levelOneCategoryList0098',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000099','列表0099','levelOneCategoryList0099',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000100','列表0100','levelOneCategoryList0100',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000101','列表0101','levelOneCategoryList0101',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000102','列表0102','levelOneCategoryList0102',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000103','列表0103','levelOneCategoryList0103',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000104','列表0104','levelOneCategoryList0104',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000105','列表0105','levelOneCategoryList0105',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000106','列表0106','levelOneCategoryList0106',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000107','列表0107','levelOneCategoryList0107',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000108','列表0108','levelOneCategoryList0108',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000109','列表0109','levelOneCategoryList0109',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000110','列表0110','levelOneCategoryList0110',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000111','列表0111','levelOneCategoryList0111',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000112','列表0112','levelOneCategoryList0112',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000113','列表0113','levelOneCategoryList0113',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000114','列表0114','levelOneCategoryList0114',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000115','列表0115','levelOneCategoryList0115',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000116','列表0116','levelOneCategoryList0116',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000117','列表0117','levelOneCategoryList0117',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000118','列表0118','levelOneCategoryList0118',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000119','列表0119','levelOneCategoryList0119',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000120','列表0120','levelOneCategoryList0120',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000121','列表0121','levelOneCategoryList0121',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000122','列表0122','levelOneCategoryList0122',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000123','列表0123','levelOneCategoryList0123',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000124','列表0124','levelOneCategoryList0124',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000125','列表0125','levelOneCategoryList0125',1,1,1,1,1,'UA000025','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000028','控制访问列表10028','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000029','控制访问列表10029','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000030','控制访问列表10030','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000031','控制访问列表10031','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000032','控制访问列表10032','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000033','控制访问列表10033','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000034','控制访问列表10034','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000035','控制访问列表10035','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000036','控制访问列表10036','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000037','控制访问列表10037','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000038','控制访问列表10038','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000039','控制访问列表10039','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000040','控制访问列表10040','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000041','控制访问列表10041','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000042','控制访问列表10042','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000043','控制访问列表10043','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000044','控制访问列表10044','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000045','控制访问列表10045','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000046','控制访问列表10046','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000047','控制访问列表10047','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000048','控制访问列表10048','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000049','控制访问列表10049','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000050','控制访问列表10050','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000051','控制访问列表10051','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000052','控制访问列表10052','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000053','控制访问列表10053','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000054','控制访问列表10054','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000055','控制访问列表10055','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000056','控制访问列表10056','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000057','控制访问列表10057','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000058','控制访问列表10058','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000059','控制访问列表10059','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000060','控制访问列表10060','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000061','控制访问列表10061','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000062','控制访问列表10062','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000063','控制访问列表10063','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000064','控制访问列表10064','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000065','控制访问列表10065','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000066','控制访问列表10066','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000067','控制访问列表10067','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000068','控制访问列表10068','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000069','控制访问列表10069','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000070','控制访问列表10070','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000071','控制访问列表10071','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000072','控制访问列表10072','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000073','控制访问列表10073','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000074','控制访问列表10074','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000075','控制访问列表10075','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000076','控制访问列表10076','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000077','控制访问列表10077','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000078','控制访问列表10078','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000079','控制访问列表10079','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000080','控制访问列表10080','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000081','控制访问列表10081','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000082','控制访问列表10082','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000083','控制访问列表10083','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000084','控制访问列表10084','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000085','控制访问列表10085','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000086','控制访问列表10086','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000087','控制访问列表10087','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000088','控制访问列表10088','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000089','控制访问列表10089','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000090','控制访问列表10090','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000091','控制访问列表10091','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000092','控制访问列表10092','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000093','控制访问列表10093','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000094','控制访问列表10094','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000095','控制访问列表10095','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000096','控制访问列表10096','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000097','控制访问列表10097','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000098','控制访问列表10098','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000099','控制访问列表10099','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000100','控制访问列表10100','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000101','控制访问列表10101','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000102','控制访问列表10102','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000103','控制访问列表10103','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000104','控制访问列表10104','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000105','控制访问列表10105','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000106','控制访问列表10106','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000107','控制访问列表10107','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000108','控制访问列表10108','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000109','控制访问列表10109','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000110','控制访问列表10110','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000111','控制访问列表10111','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000112','控制访问列表10112','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000113','控制访问列表10113','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000114','控制访问列表10114','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000115','控制访问列表10115','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000116','控制访问列表10116','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000117','控制访问列表10117','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000118','控制访问列表10118','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000119','控制访问列表10119','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000120','控制访问列表10120','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000121','控制访问列表10121','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000122','控制访问列表10122','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000123','控制访问列表10123','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000124','控制访问列表10124','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000125','控制访问列表10125','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');

	
<<<<<<< HEAD
insert into login_history_data values ('LH000001','2019-03-21 12:43:59','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-03-02 09:34:47','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-03-04 02:24:16','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-03-22 05:37:07','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-03-17 01:35:07','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-03-19 06:24:09','192.168.1.2','登陆成功0006','SU000002','1');
insert into login_history_data values ('LH000007','2019-03-03 12:19:20','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-03-19 19:25:23','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-03-14 22:54:18','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-03-20 23:28:20','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-03-11 17:36:44','192.168.1.1','登陆成功0011','SU000003','1');
insert into login_history_data values ('LH000012','2019-03-15 17:54:58','192.168.1.2','登陆成功0012','SU000003','1');
insert into login_history_data values ('LH000013','2019-03-14 21:08:15','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-03-12 23:25:12','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-03-19 16:42:04','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-03-12 16:56:12','192.168.1.2','登陆成功0016','SU000004','1');
insert into login_history_data values ('LH000017','2019-03-09 09:29:35','192.168.1.1','登陆成功0017','SU000004','1');
insert into login_history_data values ('LH000018','2019-03-10 07:26:17','192.168.1.2','登陆成功0018','SU000004','1');
insert into login_history_data values ('LH000019','2019-03-08 17:04:05','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-03-08 01:24:57','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-03-10 16:58:56','192.168.1.1','登陆成功0021','SU000005','1');
insert into login_history_data values ('LH000022','2019-03-18 09:06:48','192.168.1.2','登陆成功0022','SU000005','1');
insert into login_history_data values ('LH000023','2019-03-12 04:37:30','192.168.1.1','登陆成功0023','SU000005','1');
insert into login_history_data values ('LH000024','2019-03-12 23:22:24','192.168.1.2','登陆成功0024','SU000005','1');
insert into login_history_data values ('LH000025','2019-03-15 15:15:47','192.168.1.1','登陆成功0025','SU000005','1');
=======
insert into login_history_data values ('LH000001','2019-03-03 03:30:54','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-03-02 16:12:17','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-22 11:32:59','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-03-08 11:18:23','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-03-05 21:13:48','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-03-02 06:30:42','192.168.1.2','登陆成功0006','SU000002','1');
insert into login_history_data values ('LH000007','2019-03-09 05:02:19','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-03-09 05:03:39','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-03-02 03:56:29','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-03-04 06:03:33','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-03-02 10:05:46','192.168.1.1','登陆成功0011','SU000003','1');
insert into login_history_data values ('LH000012','2019-03-10 08:32:29','192.168.1.2','登陆成功0012','SU000003','1');
insert into login_history_data values ('LH000013','2019-03-10 18:52:46','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-03-03 08:56:56','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-02-26 16:48:07','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-03-11 05:26:11','192.168.1.2','登陆成功0016','SU000004','1');
insert into login_history_data values ('LH000017','2019-02-21 21:24:54','192.168.1.1','登陆成功0017','SU000004','1');
insert into login_history_data values ('LH000018','2019-03-08 14:58:06','192.168.1.2','登陆成功0018','SU000004','1');
insert into login_history_data values ('LH000019','2019-02-21 00:51:41','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-02-20 09:49:27','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-02-19 07:14:44','192.168.1.1','登陆成功0021','SU000005','1');
insert into login_history_data values ('LH000022','2019-03-01 09:44:04','192.168.1.2','登陆成功0022','SU000005','1');
insert into login_history_data values ('LH000023','2019-03-10 15:25:43','192.168.1.1','登陆成功0023','SU000005','1');
insert into login_history_data values ('LH000024','2019-03-11 15:02:23','192.168.1.2','登陆成功0024','SU000005','1');
insert into login_history_data values ('LH000025','2019-03-11 04:35:20','192.168.1.1','登陆成功0025','SU000005','1');
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');
insert into form_message_data values ('FM000003','字段组合错误0003','GF000001','warning','1');
insert into form_message_data values ('FM000004','字段组合错误0004','GF000001','danger','1');
insert into form_message_data values ('FM000005','字段组合错误0005','GF000001','success','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');
insert into form_field_message_data values ('FFM000003','输入错误0003','name0003','GF000001','warning','1');
insert into form_field_message_data values ('FFM000004','输入错误0004','name0004','GF000001','danger','1');
insert into form_field_message_data values ('FFM000005','输入错误0005','name0005','GF000001','success','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');
insert into form_field_data values ('FF000005','姓名','name','name0005','money','GF000001','姓名就是你身份证上的名字0005','李一一0005','姓名就是你身份证上的名字0005','基础信息','maybe any value0005','a value expression0005',true,true,0,'高,矮','高,矮','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');
insert into form_action_data values ('FA000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF000001','1');
insert into form_action_data values ('FA000004','功能0004','name0004','save','primary','genericFormManager/name/name0002/name0003/0004','GF000001','1');
insert into form_action_data values ('FA000005','功能0005','name0005','update','default','genericFormManager/name/name0002/name0003/0005','GF000001','1');

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
<<<<<<< HEAD
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
=======
insert into user_app_data values('UA000001','医院','SU000001','hospital',1,'MXWR','Hospital','H000001','/link/to/app','1'); -- REFER COUNT: 4
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 4
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','用户域','SU000002','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','用户屏蔽','SU000003','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 1
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|医院|13900000001|DoubleChain!y1|
<<<<<<< HEAD
|费用类型|13900000002|DoubleChain!y1|
|医生|13900000003|DoubleChain!y1|
|部门|13900000004|DoubleChain!y1|
|用户域|13900000005|DoubleChain!y1|
|安全用户|13900000006|DoubleChain!y1|
|用户应用程序|13900000007|DoubleChain!y1|
=======
|用户域|13900000002|DoubleChain!y1|
|用户屏蔽|13900000003|DoubleChain!y1|
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89


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

