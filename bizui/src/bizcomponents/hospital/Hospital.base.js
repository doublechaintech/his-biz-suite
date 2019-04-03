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


const menuData = {menuName:"医院", menuFor: "hospital",
  		subItems: [
  {name: 'doctorList', displayName:'医生', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'hospital') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '地址', debugtype: 'string', dataIndex: 'address', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '电话', debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  address: '地址',
  telephone: '电话',

}


const HospitalBase={menuData,displayColumns,fieldLabels}
export default HospitalBase



