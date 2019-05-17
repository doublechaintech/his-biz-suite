import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"费用类型", menuFor: "expenseType",
  		subItems: [
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  helperChars: '辅助识字课',
  status: '状态',
  hospital: '医院',
  description: '描述',
  updateTime: '更新时间',

}

const displayColumns = [
<<<<<<< HEAD
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'expenseType') },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.helperChars, debugtype: 'string', dataIndex: 'helperChars', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.status, debugtype: 'string', dataIndex: 'status', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},
  { title: fieldLabels.description, debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
=======
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'expenseType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.helperChars, debugtype: 'string', dataIndex: 'helperChars', width: '7',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.status, debugtype: 'string', dataIndex: 'status', width: '6',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true   },
>>>>>>> 68f7f5fca875ad2f29dc14a6138b833352f3ae1a

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({expenseType,targetComponent})=>{

	
	
	const {ExpenseTypeService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{expenseType.id}</Description> 
<Description term="名称">{expenseType.name}</Description> 
<Description term="辅助识字课">{expenseType.helperChars}</Description> 
<Description term="状态">{expenseType.status}</Description> 
<Description term="更新时间">{ moment(expenseType.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(expenseType,targetComponent)}
      </DescriptionList>
	)

}
	



const ExpenseTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ExpenseTypeBase



