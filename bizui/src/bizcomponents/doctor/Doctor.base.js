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
import styles from './Doctor.base.less'
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



const menuData = {menuName: window.trans('doctor'), menuFor: "doctor",
  		subItems: [
  {name: 'doctorScheduleList', displayName: window.mtrans('doctor_schedule','doctor.doctor_schedule_list',false), type:'doctorSchedule',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('doctor'), menuFor: "doctor",
  		subItems: [
  {name: 'doctorAssignmentList', displayName: window.mtrans('doctor_assignment','doctor.doctor_assignment_list',false), type:'doctorAssignment', icon:'sign',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: window.trans('doctor.id'),
  name: window.trans('doctor.name'),
  shotImage: window.trans('doctor.shot_image'),
  hospital: window.trans('doctor.hospital'),
  updateTime: window.trans('doctor.update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'doctor') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shotImage, dataIndex: 'shotImage', render: (text, record) => renderImageCell(text,record,'doctor.shot_image') },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},
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
const renderItemOfList=(doctor, targetComponent, columCount)=>{
  
  if(!doctor){
  	return null
  }
  if(!doctor.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`doctor-${doctor.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(doctor.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={doctor.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{doctor.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{doctor.name}</Description> 
        <Description term={fieldLabels.updateTime}><div>{ moment(doctor.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, hospitalId} = formValuesToPack
	const hospital = {id: hospitalId, version: 2^31}
	const data = {name, hospital}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, hospital} = objectToUnpack
	const hospitalId = hospital ? hospital.id : null
	const data = {name, hospitalId}
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
const DoctorBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default DoctorBase

