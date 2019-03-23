
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"医生", menuFor: "doctor",
  		subItems: [
<<<<<<< HEAD
=======
  {name: 'doctorAssignmentList', displayName:'医生的任务', icon:'sign',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
  {name: 'doctorScheduleList', displayName:'医生安排', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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


const formatMoney=(amount)=>{
	const options={style: 'decimal',minimumFractionDigits: 2,maximumFractionDigits:2}
    const moneyFormat = new Intl.NumberFormat('en-US',options);
	return moneyFormat.format(amount)
	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${formatMoney(value)}`)
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'doctor') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
<<<<<<< HEAD
  { title: '拍摄的图像', dataIndex: 'shotImage', render: (text, record) => renderImageCell(text,record,'拍摄的图像') },
  { title: '医院', dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},
  { title: '更新时间', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
=======
  { title: '医院', dataIndex: 'hospital', render: (text, record) => renderReferenceCell(text, record)},
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
<<<<<<< HEAD
  shotImage: '拍摄的图像',
  hospital: '医院',
  updateTime: '更新时间',
=======
  hospital: '医院',
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

}


const DoctorBase={menuData,displayColumns,fieldLabels}
export default DoctorBase



