

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Hospital.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (hospital,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{hospital.id}</Description> 
<Description term="名称">{hospital.name}</Description> 
<Description term="地址">{hospital.address}</Description> 
<Description term="电话">{hospital.telephone}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = hospital => {
  const {HospitalBase} = GlobalComponents
  return <PermissionSetting targetObject={hospital}  targetObjectMeta={HospitalBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class HospitalPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  hospital = this.props.hospital
    const { id,displayName, expenseTypeCount, periodCount, expenseItemCount, doctorCount, departmentCount, doctorScheduleCount } = hospital
    const  returnURL = `/hospital/${id}/dashboard`
    const cardsData = {cardsName:"医院",cardsFor: "hospital",cardsSource: hospital,displayName,returnURL,
  		subItems: [
{name: 'expenseTypeList', displayName:'费用类型',type:'expenseType',count:expenseTypeCount,addFunction: true, role: 'expenseType', data: hospital.expenseTypeList},
{name: 'periodList', displayName:'期',type:'period',count:periodCount,addFunction: false, role: 'period', data: hospital.periodList},
{name: 'expenseItemList', displayName:'费用项目',type:'expenseItem',count:expenseItemCount,addFunction: true, role: 'expenseItem', data: hospital.expenseItemList},
{name: 'departmentList', displayName:'部门',type:'department',count:departmentCount,addFunction: true, role: 'department', data: hospital.departmentList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  hospital: state._hospital,
}))(Form.create()(HospitalPermission))

