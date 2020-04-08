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
import styles from './DoctorAssignment.base.less'
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



const menuData = {menuName: window.trans('doctor_assignment'), menuFor: "doctorAssignment",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('doctor_assignment'), menuFor: "doctorAssignment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('doctor_assignment.id'),
  name: window.trans('doctor_assignment.name'),
  doctor: window.trans('doctor_assignment.doctor'),
  department: window.trans('doctor_assignment.department'),
  updateTime: window.trans('doctor_assignment.update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'doctorAssignment') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.doctor, dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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
const renderItemOfList=(doctorAssignment, targetComponent, columCount)=>{
  
  if(!doctorAssignment){
  	return null
  }
  if(!doctorAssignment.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`doctorAssignment-${doctorAssignment.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(doctorAssignment.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={doctorAssignment.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{doctorAssignment.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{doctorAssignment.name}</Description> 
        <Description term={fieldLabels.doctor}>{renderReferenceItem(doctorAssignment.doctor)}</Description>

        <Description term={fieldLabels.department}>{renderReferenceItem(doctorAssignment.department)}</Description>

        <Description term={fieldLabels.updateTime}><div>{ moment(doctorAssignment.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, doctorId, departmentId} = formValuesToPack
	const doctor = {id: doctorId, version: 2^31}
	const department = {id: departmentId, version: 2^31}
	const data = {name, doctor, department}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, doctor, department} = objectToUnpack
	const doctorId = doctor ? doctor.id : null
	const departmentId = department ? department.id : null
	const data = {name, doctorId, departmentId}
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
const DoctorAssignmentBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default DoctorAssignmentBase

