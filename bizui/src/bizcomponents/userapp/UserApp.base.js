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


const menuData = {menuName:"用户应用程序", menuFor: "userApp",
  		subItems: [
  {name: 'listAccessList', displayName:'访问列表', icon:'list',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'objectAccessList', displayName:'对象访问', icon:'accessible-icon',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userApp') },
  { title: '标题', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '安全用户', dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record)},
  { title: '应用程序图标', debugtype: 'string', dataIndex: 'appIcon', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '完全访问', dataIndex: 'fullAccess', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '许可', debugtype: 'string', dataIndex: 'permission', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '访问对象类型', debugtype: 'string', dataIndex: 'objectType', width: '31',render: (text, record)=>renderTextCell(text,record) },
  { title: '对象ID', debugtype: 'string', dataIndex: 'objectId', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '位置', debugtype: 'string', dataIndex: 'location', width: '16',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'ID',
  title: '标题',
  secUser: '安全用户',
  appIcon: '应用程序图标',
  fullAccess: '完全访问',
  permission: '许可',
  objectType: '访问对象类型',
  objectId: '对象ID',
  location: '位置',

}


const UserAppBase={menuData,displayColumns,fieldLabels}
export default UserAppBase



