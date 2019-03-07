
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Object Access", menuFor: "objectAccess",
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
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Object Type', debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List1', debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List2', debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List3', debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List4', debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List5', debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List6', debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List7', debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List8', debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'List9', debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'App', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  objectType: 'Object Type',
  list1: 'List1',
  list2: 'List2',
  list3: 'List3',
  list4: 'List4',
  list5: 'List5',
  list6: 'List6',
  list7: 'List7',
  list8: 'List8',
  list9: 'List9',
  app: 'App',

}


const ObjectAccessBase={menuData,displayColumns,fieldLabels}
export default ObjectAccessBase



