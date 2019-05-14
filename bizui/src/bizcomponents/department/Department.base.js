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


const menuData = {menuName:"部门", menuFor: "department",
  		subItems: [
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  hospital: '医院',
  updateTime: '更新时间',

}

const displayColumns = [
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'department') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true   },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({department,targetComponent})=>{

	
	
	const {DepartmentService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{department.id}</Description> 
<Description term="名称">{department.name}</Description> 
<Description term="更新时间">{ moment(department.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(department,targetComponent)}
      </DescriptionList>
	)

}
	



const DepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default DepartmentBase



