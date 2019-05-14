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


const menuData = {menuName:"医生", menuFor: "doctor",
  		subItems: [
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  shotImage: '拍摄的图像',
  hospital: '医院',
  updateTime: '更新时间',

}

const displayColumns = [
<<<<<<< HEAD
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'doctor'), sorter:true,sortOrder:"ascend" },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.shotImage, dataIndex: 'shotImage', render: (text, record) => renderImageCell(text,record,'拍摄的图像'), sorter:true },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter:true  },
=======
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'doctor')
	,sorter: true,

},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.shotImage, dataIndex: 'shotImage', render: (text, record) => renderImageCell(text,record,'拍摄的图像') },
  { title: fieldLabels.hospital, dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
>>>>>>> 4a59d874a8a184fc3702f98aafd0a6c97f7cdd09

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({doctor,targetComponent})=>{

	
	
	const {DoctorService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{doctor.id}</Description> 
<Description term="名称">{doctor.name}</Description> 
<Description term="更新时间">{ moment(doctor.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(doctor,targetComponent)}
      </DescriptionList>
	)

}
	



const DoctorBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default DoctorBase



