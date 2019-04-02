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


const menuData = {menuName:"医生的任务", menuFor: "doctorAssignment",
  		subItems: [
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '医生', dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record)},
  { title: '部门', dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record)},
  { title: '更新时间', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  doctor: '医生',
  department: '部门',
  updateTime: '更新时间',

}


const DoctorAssignmentBase={menuData,displayColumns,fieldLabels}
export default DoctorAssignmentBase



