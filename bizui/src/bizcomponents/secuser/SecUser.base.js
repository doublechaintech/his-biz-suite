
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Sec User", menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName:'User App', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'loginHistoryList', displayName:'Login History', icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUser') },
  { title: 'Login', debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Mobile', debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Email', debugtype: 'string', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Pwd', debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Verification Code', debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Verification Code Expire', dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Last Login Time', dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Domain', dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Blocking', dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Current Status', debugtype: 'string', dataIndex: 'currentStatus', width: '11',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  login: 'Login',
  mobile: 'Mobile',
  email: 'Email',
  pwd: 'Pwd',
  verificationCode: 'Verification Code',
  verificationCodeExpire: 'Verification Code Expire',
  lastLoginTime: 'Last Login Time',
  domain: 'Domain',
  blocking: 'Blocking',
  currentStatus: 'Current Status',

}


const SecUserBase={menuData,displayColumns,fieldLabels}
export default SecUserBase



