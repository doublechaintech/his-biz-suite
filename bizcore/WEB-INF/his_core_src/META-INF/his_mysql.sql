-- BUILD WITH MODEL TIME 190307T1430
drop database  if exists his;
create database his;
alter  database his  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use his;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(12)                              comment 'Name',
	introduction        	varchar(288)                             comment 'Introduction',
	current_version     	varchar(16)                              comment 'Current Version',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists doctor_data;
create table doctor_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(12)                              comment 'Name',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists profile_data;
create table profile_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(12)                              comment 'Name',
	gender              	varchar(4)                               comment 'Gender',
	age                 	int                                      comment 'Age',
	identification_number	varchar(52)                              comment 'Identification Number',
	mobile              	varchar(44)                              comment 'Mobile',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists registration_data;
create table registration_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	patient             	varchar(48)                              comment 'Patient',
	register            	varchar(48)                              comment 'Register',
	content             	longtext                                 comment 'Content',
	update_time         	datetime                                 comment 'Update Time',
	status              	varchar(24)                              comment 'Status',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(16)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'Id',
	user_identity       	varchar(40)                              comment 'User Identity',
	user_special_functions	varchar(200)                             comment 'User Special Functions',
	domain              	varchar(48)                              comment 'Domain',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'Id',
	login               	varchar(20)                              comment 'Login',
	mobile              	varchar(11)                              comment 'Mobile',
	email               	varchar(76)                              comment 'Email',
	pwd                 	varchar(64)                              comment 'Pwd',
	verification_code   	int                                      comment 'Verification Code',
	verification_code_expire	datetime                                 comment 'Verification Code Expire',
	last_login_time     	datetime                                 comment 'Last Login Time',
	domain              	varchar(48)                              comment 'Domain',
	blocking            	varchar(48)                              comment 'Blocking',
	current_status      	varchar(28)                              comment 'Current Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'Id',
	who                 	varchar(52)                              comment 'Who',
	block_time          	datetime                                 comment 'Block Time',
	comments            	varchar(96)                              comment 'Comments',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(300)                             comment 'Title',
	sec_user            	varchar(48)                              comment 'Sec User',
	app_icon            	varchar(36)                              comment 'App Icon',
	full_access         	tinyint                                  comment 'Full Access',
	permission          	varchar(16)                              comment 'Permission',
	object_type         	varchar(108)                             comment 'Object Type',
	object_id           	varchar(40)                              comment 'Object Id',
	location            	varchar(48)                              comment 'Location',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(200)                             comment 'Name',
	internal_name       	varchar(200)                             comment 'Internal Name',
	read_permission     	tinyint                                  comment 'Read Permission',
	create_permission   	tinyint                                  comment 'Create Permission',
	delete_permission   	tinyint                                  comment 'Delete Permission',
	update_permission   	tinyint                                  comment 'Update Permission',
	execution_permission	tinyint                                  comment 'Execution Permission',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(28)                              comment 'Name',
	object_type         	varchar(112)                             comment 'Object Type',
	list1               	varchar(80)                              comment 'List1',
	list2               	varchar(80)                              comment 'List2',
	list3               	varchar(80)                              comment 'List3',
	list4               	varchar(80)                              comment 'List4',
	list5               	varchar(80)                              comment 'List5',
	list6               	varchar(80)                              comment 'List6',
	list7               	varchar(80)                              comment 'List7',
	list8               	varchar(80)                              comment 'List8',
	list9               	varchar(80)                              comment 'List9',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'Id',
	login_time          	datetime                                 comment 'Login Time',
	from_ip             	varchar(44)                              comment 'From Ip',
	description         	varchar(16)                              comment 'Description',
	sec_user            	varchar(48)                              comment 'Sec User',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(20)                              comment 'Title',
	description         	varchar(48)                              comment 'Description',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(24)                              comment 'Title',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(12)                              comment 'Label',
	locale_key          	varchar(44)                              comment 'Locale Key',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	type                	varchar(36)                              comment 'Type',
	form                	varchar(48)                              comment 'Form',
	placeholder         	varchar(48)                              comment 'Placeholder',
	default_value       	varchar(12)                              comment 'Default Value',
	description         	varchar(48)                              comment 'Description',
	field_group         	varchar(16)                              comment 'Field Group',
	minimum_value       	varchar(60)                              comment 'Minimum Value',
	maximum_value       	varchar(72)                              comment 'Maximum Value',
	required            	tinyint                                  comment 'Required',
	disabled            	tinyint                                  comment 'Disabled',
	custom_rendering    	tinyint                                  comment 'Custom Rendering',
	candidate_values    	varchar(12)                              comment 'Candidate Values',
	suggest_values      	varchar(12)                              comment 'Suggest Values',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(8)                               comment 'Label',
	locale_key          	varchar(16)                              comment 'Locale Key',
	action_key          	varchar(24)                              comment 'Action Key',
	level               	varchar(28)                              comment 'Level',
	url                 	varchar(168)                             comment 'Url',
	form                	varchar(48)                              comment 'Form',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','HIS','new generation of eCommerce platform based on opensource and modern tech','V1.0','1');

	
insert into doctor_data values ('D000001','张医生','P000001','1');
insert into doctor_data values ('D000002','刘医生','P000001','1');
insert into doctor_data values ('D000003','张医生','P000001','1');
insert into doctor_data values ('D000004','刘医生','P000001','1');
insert into doctor_data values ('D000005','张医生','P000001','1');

	
insert into profile_data values ('P000001','张喜来','男','91','6501988098876','13899998888','P000001','1');
insert into profile_data values ('P000002','刘利','女','84','65019880988760002','13900000002','P000001','1');
insert into profile_data values ('P000003','张喜来','男','73','65019880988760003','13900000003','P000001','1');
insert into profile_data values ('P000004','刘利','女','99','65019880988760004','13900000004','P000001','1');
insert into profile_data values ('P000005','张喜来','男','100','65019880988760005','13900000005','P000001','1');

	
insert into registration_data values ('R000001','挂一个号','P000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-02-15 23:24:51','UNREAD','P000001','1');
insert into registration_data values ('R000002','挂一个号0002','P000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-02-26 22:45:56','READ','P000001','1');
insert into registration_data values ('R000003','挂一个号0003','P000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-02-17 10:28:03','UNREAD','P000001','1');
insert into registration_data values ('R000004','挂一个号0004','P000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-03-03 14:25:43','READ','P000001','1');
insert into registration_data values ('R000005','挂一个号0005','P000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-03-01 16:07:54','UNREAD','P000001','1');
insert into registration_data values ('R000006','挂一个号0006','P000002','P000002','    一段样例文字。
可以分段。

可以空行。

','2019-02-26 09:10:32','READ','P000001','1');
insert into registration_data values ('R000007','挂一个号0007','P000002','P000002','    一段样例文字。
可以分段。

可以空行。

','2019-02-25 03:51:42','UNREAD','P000001','1');
insert into registration_data values ('R000008','挂一个号0008','P000002','P000002','    一段样例文字。
可以分段。

可以空行。

','2019-02-18 20:13:33','READ','P000001','1');
insert into registration_data values ('R000009','挂一个号0009','P000002','P000002','    一段样例文字。
可以分段。

可以空行。

','2019-02-20 10:33:56','UNREAD','P000001','1');
insert into registration_data values ('R000010','挂一个号0010','P000002','P000002','    一段样例文字。
可以分段。

可以空行。

','2019-02-23 23:30:39','READ','P000001','1');
insert into registration_data values ('R000011','挂一个号0011','P000003','P000003','    一段样例文字。
可以分段。

可以空行。

','2019-02-18 05:43:05','UNREAD','P000001','1');
insert into registration_data values ('R000012','挂一个号0012','P000003','P000003','    一段样例文字。
可以分段。

可以空行。

','2019-02-23 08:39:47','READ','P000001','1');
insert into registration_data values ('R000013','挂一个号0013','P000003','P000003','    一段样例文字。
可以分段。

可以空行。

','2019-02-28 09:21:33','UNREAD','P000001','1');
insert into registration_data values ('R000014','挂一个号0014','P000003','P000003','    一段样例文字。
可以分段。

可以空行。

','2019-02-19 23:49:55','READ','P000001','1');
insert into registration_data values ('R000015','挂一个号0015','P000003','P000003','    一段样例文字。
可以分段。

可以空行。

','2019-03-05 15:56:14','UNREAD','P000001','1');
insert into registration_data values ('R000016','挂一个号0016','P000004','P000004','    一段样例文字。
可以分段。

可以空行。

','2019-02-16 13:40:36','READ','P000001','1');
insert into registration_data values ('R000017','挂一个号0017','P000004','P000004','    一段样例文字。
可以分段。

可以空行。

','2019-03-04 23:11:37','UNREAD','P000001','1');
insert into registration_data values ('R000018','挂一个号0018','P000004','P000004','    一段样例文字。
可以分段。

可以空行。

','2019-03-04 10:42:29','READ','P000001','1');
insert into registration_data values ('R000019','挂一个号0019','P000004','P000004','    一段样例文字。
可以分段。

可以空行。

','2019-03-07 12:07:22','UNREAD','P000001','1');
insert into registration_data values ('R000020','挂一个号0020','P000004','P000004','    一段样例文字。
可以分段。

可以空行。

','2019-03-02 08:37:14','READ','P000001','1');
insert into registration_data values ('R000021','挂一个号0021','P000005','P000005','    一段样例文字。
可以分段。

可以空行。

','2019-02-23 14:25:34','UNREAD','P000001','1');
insert into registration_data values ('R000022','挂一个号0022','P000005','P000005','    一段样例文字。
可以分段。

可以空行。

','2019-02-25 18:31:30','READ','P000001','1');
insert into registration_data values ('R000023','挂一个号0023','P000005','P000005','    一段样例文字。
可以分段。

可以空行。

','2019-02-16 22:01:21','UNREAD','P000001','1');
insert into registration_data values ('R000024','挂一个号0024','P000005','P000005','    一段样例文字。
可以分段。

可以空行。

','2019-02-20 06:37:10','READ','P000001','1');
insert into registration_data values ('R000025','挂一个号0025','P000005','P000005','    一段样例文字。
可以分段。

可以空行。

','2019-02-28 01:13:43','UNREAD','P000001','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');
insert into user_white_list_data values ('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');
insert into user_white_list_data values ('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');
insert into user_white_list_data values ('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-15 02:48:21','2019-03-05 05:15:08','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-03-05 15:51:13','2019-02-28 20:47:50','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-02-24 21:19:32','2019-03-03 18:57:42','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-02-15 19:14:56','2019-02-20 22:59:48','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-02-15 17:50:02','2019-02-26 01:49:12','UD000001',NULL,'BLOCKED0005','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-03-02 12:52:27','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
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

	
insert into login_history_data values ('LH000001','2019-02-19 23:01:07','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-03-01 09:38:41','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-14 11:12:47','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-02-22 09:37:11','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-02-23 13:41:14','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-02-22 05:25:30','192.168.1.2','登陆成功0006','SU000002','1');
insert into login_history_data values ('LH000007','2019-03-06 07:31:15','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-03-03 15:12:48','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-03-05 16:06:09','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-03-07 06:49:35','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-03-06 04:42:30','192.168.1.1','登陆成功0011','SU000003','1');
insert into login_history_data values ('LH000012','2019-02-26 19:32:38','192.168.1.2','登陆成功0012','SU000003','1');
insert into login_history_data values ('LH000013','2019-02-24 17:49:02','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-03-07 00:19:01','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-02-19 10:17:03','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-03-03 17:36:34','192.168.1.2','登陆成功0016','SU000004','1');
insert into login_history_data values ('LH000017','2019-02-26 07:27:29','192.168.1.1','登陆成功0017','SU000004','1');
insert into login_history_data values ('LH000018','2019-03-07 06:55:46','192.168.1.2','登陆成功0018','SU000004','1');
insert into login_history_data values ('LH000019','2019-02-22 21:30:07','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-02-14 12:21:10','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-02-25 08:26:33','192.168.1.1','登陆成功0021','SU000005','1');
insert into login_history_data values ('LH000022','2019-03-01 10:00:48','192.168.1.2','登陆成功0022','SU000005','1');
insert into login_history_data values ('LH000023','2019-03-01 10:56:45','192.168.1.1','登陆成功0023','SU000005','1');
insert into login_history_data values ('LH000024','2019-02-27 09:51:19','192.168.1.2','登陆成功0024','SU000005','1');
insert into login_history_data values ('LH000025','2019-02-28 12:37:23','192.168.1.1','登陆成功0025','SU000005','1');

	
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

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_doctor_version on doctor_data(id, version);

alter table doctor_data add constraint doctor4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_profile_version on profile_data(id, version);

alter table profile_data add constraint profile4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_registration_version on registration_data(id, version);

alter table registration_data add constraint registration4patient_fk
	foreign key(patient) references profile_data(id) on delete cascade on update cascade;
alter table registration_data add constraint registration4register_fk
	foreign key(register) references profile_data(id) on delete cascade on update cascade;
alter table registration_data add constraint registration4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
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

create index platform4version_idx on platform_data(version);
create index doctor4version_idx on doctor_data(version);
create index profile4age_idx on profile_data(age);
create index profile4mobile_idx on profile_data(mobile);
create index profile4version_idx on profile_data(version);
create index registration4update_time_idx on registration_data(update_time);
create index registration4version_idx on registration_data(version);
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
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 3
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 3
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','User Domain','SU000002','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Sec User Blocking','SU000003','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|User Domain|13900000002|DoubleChain!y1|
|Sec User Blocking|13900000003|DoubleChain!y1|


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

