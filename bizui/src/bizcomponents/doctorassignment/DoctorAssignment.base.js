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


const menuData = {menuName:"医生的任务", menuFor: "doctorAssignment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  doctor: '医生',
  department: '部门',
  updateTime: '更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.doctor, dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.updateTime, dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true   },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({doctorAssignment,targetComponent})=>{

	
	
	const {DoctorAssignmentService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{doctorAssignment.id}</Description> 
<Description term="名称">{doctorAssignment.name}</Description> 
<Description term="医生">{doctorAssignment.doctor==null?appLocaleName(userContext,"NotAssigned"):`${doctorAssignment.doctor.displayName}(${doctorAssignment.doctor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"医生","doctor",DoctorAssignmentService.requestCandidateDoctor,
	      DoctorAssignmentService.transferToAnotherDoctor,"anotherDoctorId",doctorAssignment.doctor?doctorAssignment.doctor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="部门">{doctorAssignment.department==null?appLocaleName(userContext,"NotAssigned"):`${doctorAssignment.department.displayName}(${doctorAssignment.department.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"部门","department",DoctorAssignmentService.requestCandidateDepartment,
	      DoctorAssignmentService.transferToAnotherDepartment,"anotherDepartmentId",doctorAssignment.department?doctorAssignment.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="更新时间">{ moment(doctorAssignment.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(doctorAssignment,targetComponent)}
      </DescriptionList>
	)

}
	



const DoctorAssignmentBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default DoctorAssignmentBase



