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


const menuData = {menuName:"医生", menuFor: "doctor",
  		subItems: [
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'doctor') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '拍摄的图像', dataIndex: 'shotImage', render: (text, record) => renderImageCell(text,record,'拍摄的图像') },
  { title: '医院', dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},
  { title: '更新时间', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  shotImage: '拍摄的图像',
  hospital: '医院',
  updateTime: '更新时间',

}


const DoctorBase={menuData,displayColumns,fieldLabels}
export default DoctorBase



