import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool';

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"安全用户", menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName:'用户应用程序', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'loginHistoryList', displayName:'登录历史', icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUser') },
  { title: '登录', debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '手机号码', debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '电子邮件', debugtype: 'string', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record) },
  { title: '密码', debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '验证码', debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '验证码过期', dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '最后登录时间', dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '域', dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record)},
  { title: '屏蔽', dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '11',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'ID',
  login: '登录',
  mobile: '手机号码',
  email: '电子邮件',
  pwd: '密码',
  verificationCode: '验证码',
  verificationCodeExpire: '验证码过期',
  lastLoginTime: '最后登录时间',
  domain: '域',
  blocking: '屏蔽',
  currentStatus: '当前状态',

}


const SecUserBase={menuData,displayColumns,fieldLabels}
export default SecUserBase



