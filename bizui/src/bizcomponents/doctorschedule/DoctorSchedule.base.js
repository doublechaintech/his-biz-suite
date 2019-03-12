
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"医生安排", menuFor: "doctorSchedule",
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '33',render: (text, record)=>renderTextCell(text,record) },
  { title: '安排日期', dataIndex: 'scheduleDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '期', debugtype: 'string', dataIndex: 'period', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '医生', dataIndex: 'doctor', render: (text, record) => renderReferenceCell(text, record)},
  { title: '可用', debugtype: 'int', dataIndex: 'available', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '价格', dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '费用类型', dataIndex: 'expenseType', render: (text, record) => renderReferenceCell(text, record)},
  { title: '部门', dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  scheduleDate: '安排日期',
  period: '期',
  doctor: '医生',
  available: '可用',
  price: '价格',
  expenseType: '费用类型',
  department: '部门',

}


const DoctorScheduleBase={menuData,displayColumns,fieldLabels}
export default DoctorScheduleBase



