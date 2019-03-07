
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Registration", menuFor: "registration",
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
  { title: 'Title', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Patient', dataIndex: 'patient', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Register', dataIndex: 'register', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Content', debugtype: 'string_longtext', dataIndex: 'content', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Update Time', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Status', debugtype: 'string', dataIndex: 'status', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  patient: 'Patient',
  register: 'Register',
  content: 'Content',
  updateTime: 'Update Time',
  status: 'Status',
  platform: 'Platform',

}


const RegistrationBase={menuData,displayColumns,fieldLabels}
export default RegistrationBase



