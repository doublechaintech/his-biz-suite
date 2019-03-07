
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"User App", menuFor: "userApp",
  		subItems: [
  {name: 'listAccessList', displayName:'List Access', icon:'list',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'objectAccessList', displayName:'Object Access', icon:'accessible-icon',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userApp') },
  { title: 'Title', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Sec User', dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'App Icon', debugtype: 'string', dataIndex: 'appIcon', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Full Access', dataIndex: 'fullAccess', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Permission', debugtype: 'string', dataIndex: 'permission', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Object Type', debugtype: 'string', dataIndex: 'objectType', width: '31',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Object Id', debugtype: 'string', dataIndex: 'objectId', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Location', debugtype: 'string', dataIndex: 'location', width: '16',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  secUser: 'Sec User',
  appIcon: 'App Icon',
  fullAccess: 'Full Access',
  permission: 'Permission',
  objectType: 'Object Type',
  objectId: 'Object Id',
  location: 'Location',

}


const UserAppBase={menuData,displayColumns,fieldLabels}
export default UserAppBase



