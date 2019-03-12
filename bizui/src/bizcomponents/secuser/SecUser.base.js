
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"安全用户", menuFor: "secUser",
  		subItems: [
  {name: 'userAppList', displayName:'用户应用程序', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'loginHistoryList', displayName:'登录历史', icon:'history',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUser') },
  { title: '登录', debugtype: 'string', dataIndex: 'login', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '手机号码', debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '电子邮件', debugtype: 'string', dataIndex: 'email', width: '23',render: (text, record)=>renderTextCell(text,record) },
  { title: '密码', debugtype: 'string_password', dataIndex: 'pwd', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '验证码', debugtype: 'int', dataIndex: 'verificationCode', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '验证码过期', dataIndex: 'verificationCodeExpire', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '最后登录时间', dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '域', dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record)},
  { title: '屏蔽', dataIndex: 'blocking', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '11',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'ID',
  login: '登录',
  mobile: '手机号码',
  email: '电子邮件',
  pwd: '密码',
  verificationCode: '验证码',
  verificationCodeExpire: '验证码过期',
  lastLoginTime: '最后登录时间',
  domain: '域',
  blocking: '屏蔽',
  currentStatus: '当前状态',

}


const SecUserBase={menuData,displayColumns,fieldLabels}
export default SecUserBase



