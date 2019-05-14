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


const menuData = {menuName:"对象访问", menuFor: "objectAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  objectType: '访问对象类型',
  list1: '列表1',
  list2: '列表2',
  list3: '列表3',
  list4: '列表4',
  list5: '列表5',
  list6: '列表6',
  list7: '列表7',
  list8: '列表8',
  list9: '列表9',
  app: '应用程序',

}

const displayColumns = [
<<<<<<< HEAD
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list1, debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list2, debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list3, debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list4, debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list5, debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list6, debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list7, debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list8, debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.list9, debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},
=======
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list1, debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list2, debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list3, debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list4, debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list5, debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list6, debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list7, debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list8, debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.list9, debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},
>>>>>>> 4a59d874a8a184fc3702f98aafd0a6c97f7cdd09

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({objectAccess,targetComponent})=>{

	
	
	const {ObjectAccessService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{objectAccess.id}</Description> 
<Description term="名称">{objectAccess.name}</Description> 
<Description term="访问对象类型">{objectAccess.objectType}</Description> 
<Description term="列表1">{objectAccess.list1}</Description> 
<Description term="列表2">{objectAccess.list2}</Description> 
<Description term="列表3">{objectAccess.list3}</Description> 
<Description term="列表4">{objectAccess.list4}</Description> 
<Description term="列表5">{objectAccess.list5}</Description> 
<Description term="列表6">{objectAccess.list6}</Description> 
<Description term="列表7">{objectAccess.list7}</Description> 
<Description term="列表8">{objectAccess.list8}</Description> 
<Description term="列表9">{objectAccess.list9}</Description> 
<Description term="应用程序">{objectAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${objectAccess.app.displayName}(${objectAccess.app.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"应用程序","userApp",ObjectAccessService.requestCandidateApp,
	      ObjectAccessService.transferToAnotherApp,"anotherAppId",objectAccess.app?objectAccess.app.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(objectAccess,targetComponent)}
      </DescriptionList>
	)

}
	



const ObjectAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ObjectAccessBase



