
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"List Access", menuFor: "listAccess",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? value.displayName : appLocaleName(userContext,"NotAssigned")) 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Internal Name', debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Read Permission', dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Create Permission', dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Delete Permission', dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Update Permission', dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Execution Permission', dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'App', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  internalName: 'Internal Name',
  readPermission: 'Read Permission',
  createPermission: 'Create Permission',
  deletePermission: 'Delete Permission',
  updatePermission: 'Update Permission',
  executionPermission: 'Execution Permission',
  app: 'App',

}


const ListAccessBase={menuData,displayColumns,fieldLabels}
export default ListAccessBase



