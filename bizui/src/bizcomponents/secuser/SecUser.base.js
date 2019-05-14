import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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

const displayColumns = [
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUser'), sorter:true,sortOrder:"ascend" },
  { title: fieldLabels.login, debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.email, debugtype: 'string', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.pwd, debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.verificationCode, debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.verificationCodeExpire, dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record), sorter:true  },
  { title: fieldLabels.lastLoginTime, dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter:true  },
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.blocking, dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '11',render: (text, record)=>renderTextCell(text,record), sorter:true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({secUser,targetComponent})=>{

	
	
	const {SecUserService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{secUser.id}</Description> 
<Description term="登录">{secUser.login}</Description> 
<Description term="手机号码">{secUser.mobile}</Description> 
<Description term="电子邮件">{secUser.email}</Description> 
<Description term="密码">{secUser.pwd}</Description> 
<Description term="验证码">{secUser.verificationCode}</Description> 
<Description term="验证码过期">{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(secUser.lastLoginTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{secUser.currentStatus}</Description> 
	
        {buildTransferModal(secUser,targetComponent)}
      </DescriptionList>
	)

}
	



const SecUserBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SecUserBase



