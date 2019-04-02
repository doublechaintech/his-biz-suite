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


const menuData = {menuName:"医生安排", menuFor: "doctorSchedule",
  		subItems: [
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '33',render: (text, record)=>renderTextCell(text,record) },
  { title: '医生', dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record)},
  { title: '安排日期', dataIndex: 'scheduleDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '期', dataIndex: 'period', render: (text, record) => renderReferenceCell(text, record)},
  { title: '部门', dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record)},
  { title: '可用', debugtype: 'int', dataIndex: 'available', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '价格', dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '费用类型', dataIndex: 'expenseType', render: (text, record) => renderReferenceCell(text, record)},
  { title: '创建时间', dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '更新时间', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '医院', dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  doctor: '医生',
  scheduleDate: '安排日期',
  period: '期',
  department: '部门',
  available: '可用',
  price: '价格',
  expenseType: '费用类型',
  createTime: '创建时间',
  updateTime: '更新时间',
  hospital: '医院',

}


const DoctorScheduleBase={menuData,displayColumns,fieldLabels}
export default DoctorScheduleBase



