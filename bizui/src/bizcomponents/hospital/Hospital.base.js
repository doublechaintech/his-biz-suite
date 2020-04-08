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
import styles from './Hospital.base.less'
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



const menuData = {menuName: window.trans('hospital'), menuFor: "hospital",
  		subItems: [
  {name: 'doctorList', displayName: window.mtrans('doctor','hospital.doctor_list',false), type:'doctor',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'doctorScheduleList', displayName: window.mtrans('doctor_schedule','hospital.doctor_schedule_list',false), type:'doctorSchedule',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('hospital'), menuFor: "hospital",
  		subItems: [
  {name: 'expenseTypeList', displayName: window.mtrans('expense_type','hospital.expense_type_list',false), type:'expenseType', icon:'pen',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'periodList', displayName: window.mtrans('period','hospital.period_list',false), type:'period', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'expenseItemList', displayName: window.mtrans('expense_item','hospital.expense_item_list',false), type:'expenseItem', icon:'pen',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'departmentList', displayName: window.mtrans('department','hospital.department_list',false), type:'department', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: window.trans('hospital.id'),
  name: window.trans('hospital.name'),
  address: window.trans('hospital.address'),
  telephone: window.trans('hospital.telephone'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'hospital') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.telephone, debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record)},

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
const renderItemOfList=(hospital, targetComponent, columCount)=>{
  
  if(!hospital){
  	return null
  }
  if(!hospital.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`hospital-${hospital.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(hospital.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={hospital.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{hospital.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{hospital.name}</Description> 
        <Description term={fieldLabels.address} style={{wordBreak: 'break-all'}}>{hospital.address}</Description> 
        <Description term={fieldLabels.telephone} style={{wordBreak: 'break-all'}}>{hospital.telephone}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, address, telephone} = formValuesToPack

	const data = {name, address, telephone}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, address, telephone} = objectToUnpack

	const data = {name, address, telephone}
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
const HospitalBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default HospitalBase

