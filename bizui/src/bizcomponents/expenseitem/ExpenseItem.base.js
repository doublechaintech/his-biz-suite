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
import styles from './ExpenseItem.base.less'
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



const menuData = {menuName: window.trans('expense_item'), menuFor: "expenseItem",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('expense_item'), menuFor: "expenseItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('expense_item.id'),
  name: window.trans('expense_item.name'),
  price: window.trans('expense_item.price'),
  expenseType: window.trans('expense_item.expense_type'),
  hospital: window.trans('expense_item.hospital'),
  updateTime: window.trans('expense_item.update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'expenseItem') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.expenseType, dataIndex: 'expenseType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
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
const renderItemOfList=(expenseItem, targetComponent, columCount)=>{
  
  if(!expenseItem){
  	return null
  }
  if(!expenseItem.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`expenseItem-${expenseItem.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(expenseItem.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={expenseItem.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{expenseItem.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{expenseItem.name}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{expenseItem.price}</div></Description> 
        <Description term={fieldLabels.expenseType}>{renderReferenceItem(expenseItem.expenseType)}</Description>

        <Description term={fieldLabels.updateTime}><div>{ moment(expenseItem.updateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, price, expenseTypeId, hospitalId} = formValuesToPack
	const expenseType = {id: expenseTypeId, version: 2^31}
	const hospital = {id: hospitalId, version: 2^31}
	const data = {name, price, expenseType, hospital}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, price, expenseType, hospital} = objectToUnpack
	const expenseTypeId = expenseType ? expenseType.id : null
	const hospitalId = hospital ? hospital.id : null
	const data = {name, price, expenseTypeId, hospitalId}
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
const ExpenseItemBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ExpenseItemBase

