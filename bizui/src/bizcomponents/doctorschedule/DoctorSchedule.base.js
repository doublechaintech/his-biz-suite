import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './DoctorSchedule.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('doctor_schedule'), menuFor: "doctorSchedule",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('doctor_schedule'), menuFor: "doctorSchedule",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('doctor_schedule.id'),
  name: window.trans('doctor_schedule.name'),
  doctor: window.trans('doctor_schedule.doctor'),
  scheduleDate: window.trans('doctor_schedule.schedule_date'),
  period: window.trans('doctor_schedule.period'),
  department: window.trans('doctor_schedule.department'),
  available: window.trans('doctor_schedule.available'),
  price: window.trans('doctor_schedule.price'),
  expenseType: window.trans('doctor_schedule.expense_type'),
  createTime: window.trans('doctor_schedule.create_time'),
  updateTime: window.trans('doctor_schedule.update_time'),
  hospital: window.trans('doctor_schedule.hospital'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'doctorSchedule') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '33',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.doctor, dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scheduleDate, dataIndex: 'scheduleDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.period, dataIndex: 'period', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.available, dataIndex: 'available', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.expenseType, dataIndex: 'expenseType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(doctorSchedule, targetComponent, columCount)=>{
  
  if(!doctorSchedule){
  	return null
  }
  if(!doctorSchedule.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`doctorSchedule-${doctorSchedule.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(doctorSchedule.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
		<span className={styles.stamp} style={{color:followColor(),borderColor:followColor()}} >{doctorSchedule.period.displayName}</span>	  
	  
	  
	 
	
      <DescriptionList  key={doctorSchedule.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{doctorSchedule.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{doctorSchedule.name}</Description> 
        <Description term={fieldLabels.doctor}>{renderReferenceItem(doctorSchedule.doctor)}</Description>

        <Description term={fieldLabels.scheduleDate}><div>{ moment(doctorSchedule.scheduleDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.period}>{renderReferenceItem(doctorSchedule.period)}</Description>

        <Description term={fieldLabels.department}>{renderReferenceItem(doctorSchedule.department)}</Description>

        <Description term={fieldLabels.available}><div style={{"color":"red"}}>{doctorSchedule.available}</div></Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{doctorSchedule.price}</div></Description> 
        <Description term={fieldLabels.expenseType}>{renderReferenceItem(doctorSchedule.expenseType)}</Description>

        <Description term={fieldLabels.createTime}><div>{ moment(doctorSchedule.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.updateTime}><div>{ moment(doctorSchedule.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, scheduleDate, available, price, doctorId, periodId, departmentId, expenseTypeId, hospitalId} = formValuesToPack
	const doctor = {id: doctorId, version: 2^31}
	const period = {id: periodId, version: 2^31}
	const department = {id: departmentId, version: 2^31}
	const expenseType = {id: expenseTypeId, version: 2^31}
	const hospital = {id: hospitalId, version: 2^31}
	const data = {name, scheduleDate:moment(scheduleDate).valueOf(), available, price, doctor, period, department, expenseType, hospital}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, scheduleDate, available, price, doctor, period, department, expenseType, hospital} = objectToUnpack
	const doctorId = doctor ? doctor.id : null
	const periodId = period ? period.id : null
	const departmentId = department ? department.id : null
	const expenseTypeId = expenseType ? expenseType.id : null
	const hospitalId = hospital ? hospital.id : null
	const data = {name, scheduleDate:moment(scheduleDate), available, price, doctorId, periodId, departmentId, expenseTypeId, hospitalId}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const DoctorScheduleBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default DoctorScheduleBase

