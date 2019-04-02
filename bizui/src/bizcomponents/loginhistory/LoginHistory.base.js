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


const menuData = {menuName:"登录历史", menuFor: "loginHistory",
  		subItems: [
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '登录时间', dataIndex: 'loginTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '来自IP', debugtype: 'string', dataIndex: 'fromIp', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '描述', debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '安全用户', dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'ID',
  loginTime: '登录时间',
  fromIp: '来自IP',
  description: '描述',
  secUser: '安全用户',

}


const LoginHistoryBase={menuData,displayColumns,fieldLabels}
export default LoginHistoryBase










