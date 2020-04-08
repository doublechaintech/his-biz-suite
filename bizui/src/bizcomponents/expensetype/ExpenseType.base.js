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
import styles from './ExpenseType.base.less'
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



const menuData = {menuName: window.trans('expense_type'), menuFor: "expenseType",
  		subItems: [
  {name: 'doctorScheduleList', displayName: window.mtrans('doctor_schedule','expense_type.doctor_schedule_list',false), type:'doctorSchedule',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('expense_type'), menuFor: "expenseType",
  		subItems: [
  {name: 'expenseItemList', displayName: window.mtrans('expense_item','expense_type.expense_item_list',false), type:'expenseItem', icon:'pen',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: window.trans('expense_type.id'),
  name: window.trans('expense_type.name'),
  helperChars: window.trans('expense_type.helper_chars'),
  status: window.trans('expense_type.status'),
  hospital: window.trans('expense_type.hospital'),
  description: window.trans('expense_type.description'),
  updateTime: window.trans('expense_type.update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'expenseType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.helperChars, debugtype: 'string', dataIndex: 'helperChars', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.status, debugtype: 'string', dataIndex: 'status', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record)},
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
const renderItemOfList=(expenseType, targetComponent, columCount)=>{
  
  if(!expenseType){
  	return null
  }
  if(!expenseType.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`expenseType-${expenseType.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(expenseType.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={expenseType.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{expenseType.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{expenseType.name}</Description> 
        <Description term={fieldLabels.helperChars} style={{wordBreak: 'break-all'}}>{expenseType.helperChars}</Description> 
        <Description term={fieldLabels.status} style={{wordBreak: 'break-all'}}>{expenseType.status}</Description> 
        <Description term={fieldLabels.updateTime}><div>{ moment(expenseType.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, helperChars, status, hospitalId, description} = formValuesToPack
	const hospital = {id: hospitalId, version: 2^31}
	const data = {name, helperChars, status, hospital, description}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, helperChars, status, hospital, description} = objectToUnpack
	const hospitalId = hospital ? hospital.id : null
	const data = {name, helperChars, status, hospitalId, description}
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
const ExpenseTypeBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ExpenseTypeBase

