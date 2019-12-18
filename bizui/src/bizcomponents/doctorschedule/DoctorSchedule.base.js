import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
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


const settingMenuData = {menuName:"医生安排", menuFor: "doctorSchedule",
  		subItems: [
  
  		],
}

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

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'doctorSchedule') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '33',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.doctor, dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scheduleDate, dataIndex: 'scheduleDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.period, dataIndex: 'period', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.available, debugtype: 'int', dataIndex: 'available', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.expenseType, dataIndex: 'expenseType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(doctorSchedule,targetComponent)=>{

  const userContext = null
  return (
    <div key={doctorSchedule.id}>
	
      <DescriptionList  key={doctorSchedule.id} size="small" col="4">
        <Description term="ID">{doctorSchedule.id}</Description> 
        <Description term="名称">{doctorSchedule.name}</Description> 
        <Description term="医生"><div>{doctorSchedule.doctor==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.doctor.displayName}(${doctorSchedule.doctor.id})`}
        </div></Description>
        <Description term="安排日期"><div>{ moment(doctorSchedule.scheduleDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="期"><div>{doctorSchedule.period==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.period.displayName}(${doctorSchedule.period.id})`}
        </div></Description>
        <Description term="部门"><div>{doctorSchedule.department==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.department.displayName}(${doctorSchedule.department.id})`}
        </div></Description>
        <Description term="可用"><div style={{"color":"red"}}>{doctorSchedule.available}</div></Description> 
        <Description term="价格"><div style={{"color":"red"}}>{doctorSchedule.price}</div></Description> 
        <Description term="费用类型"><div>{doctorSchedule.expenseType==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.expenseType.displayName}(${doctorSchedule.expenseType.id})`}
        </div></Description>
        <Description term="创建时间"><div>{ moment(doctorSchedule.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="更新时间"><div>{ moment(doctorSchedule.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const DoctorScheduleBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default DoctorScheduleBase



