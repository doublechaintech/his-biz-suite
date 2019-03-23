<<<<<<< HEAD
import ImagePreview from '../../components/ImagePreview';
import { Link } from 'dva/router';
import moment from 'moment';
import appLocaleName from '../../common/Locale.tool';

const menuData = {
  menuName: '医院',
  menuFor: 'hospital',
  subItems: [
    {
      name: 'doctorList',
      displayName: '医生',
      icon: '500px',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
    },
    {
      name: 'doctorScheduleList',
      displayName: '医生安排',
      icon: '500px',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
    },
  ],
};

const renderTextCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return '';
  }
  if (value == null) {
    return '';
  }
  if (value.length > 15) {
    return (
      value.substring(0, 15) + '...(' + value.length + appLocaleName(userContext, 'Chars') + ')'
    );
  }
  return value;
};

const renderIdentifier = (value, record, targtObjectType) => {
  return <Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>;
};

const renderDateCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD');
};
const renderDateTimeCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD HH:mm');
};

const renderImageCell = (value, record, title) => {
  return <ImagePreview imageTitle={title} imageLocation={value} />;
};

const formatMoney = amount => {
  const options = { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 };
  const moneyFormat = new Intl.NumberFormat('en-US', options);
  return moneyFormat.format(amount);
};

const renderMoneyCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return appLocaleName(userContext, 'Empty');
  }
  if (value == null) {
    return appLocaleName(userContext, 'Empty');
  }
  return `${appLocaleName(userContext, 'Currency')}${formatMoney(value)}`;
};

const renderBooleanCell = (value, record) => {
  const userContext = null;

  return value ? appLocaleName(userContext, 'Yes') : appLocaleName(userContext, 'No');
};

const renderReferenceCell = (value, record) => {
  const userContext = null;
  return value ? value.displayName : appLocaleName(userContext, 'NotAssigned');
};

const displayColumns = [
  {
    title: 'ID',
    debugtype: 'string',
    dataIndex: 'id',
    width: '20',
    render: (text, record) => renderTextCell(text, record, 'hospital'),
  },
  {
    title: '名称',
    debugtype: 'string',
    dataIndex: 'name',
    width: '8',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: '地址',
    debugtype: 'string',
    dataIndex: 'address',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: '电话',
    debugtype: 'string',
    dataIndex: 'telephone',
    width: '15',
    render: (text, record) => renderTextCell(text, record),
  },
];
=======

import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"医院", menuFor: "hospital",
  		subItems: [
  {name: 'expenseTypeList', displayName:'费用类型', icon:'pen',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'expenseItemList', displayName:'费用项目', icon:'pen',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'doctorList', displayName:'医生', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'departmentList', displayName:'部门', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'hospital') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '地址', debugtype: 'string', dataIndex: 'address', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '电话', debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record) },

]
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

const fieldLabels = {
  id: 'ID',
  name: '名称',
  address: '地址',
  telephone: '电话',
<<<<<<< HEAD
};

const HospitalBase = { menuData, displayColumns, fieldLabels };
export default HospitalBase;
=======

}


const HospitalBase={menuData,displayColumns,fieldLabels}
export default HospitalBase



>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
