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


const menuData = {menuName:"用户屏蔽", menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName:'安全用户', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  who: '谁',
  blockTime: '块时间',
  comments: '评论',

}

const displayColumns = [
<<<<<<< HEAD
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '17',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.blockTime, dataIndex: 'blockTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '28',render: (text, record)=>renderTextCell(text,record) },
=======
  { title: fieldLabels.ID, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '17',render: (text, record)=>renderTextCell(text,record), sorter:true },
  { title: fieldLabels.blockTime, dataIndex: 'blockTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true   },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '28',render: (text, record)=>renderTextCell(text,record), sorter:true },
>>>>>>> 68f7f5fca875ad2f29dc14a6138b833352f3ae1a

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({secUserBlocking,targetComponent})=>{

	
	
	const {SecUserBlockingService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{secUserBlocking.id}</Description> 
<Description term="谁">{secUserBlocking.who}</Description> 
<Description term="块时间">{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{secUserBlocking.comments}</Description> 
	
        {buildTransferModal(secUserBlocking,targetComponent)}
      </DescriptionList>
	)

}
	



const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SecUserBlockingBase



