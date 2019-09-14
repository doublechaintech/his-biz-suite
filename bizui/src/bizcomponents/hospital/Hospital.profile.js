

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Hospital.profile.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSettingList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSettingList = defaultRenderSettingList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.HospitalBase.renderItemOfList(item, targetComponents)

}



class HospitalProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  hospital = this.props.hospital;
    const { id,displayName, expenseTypeCount, periodCount, expenseItemCount, doctorCount, departmentCount, doctorScheduleCount } = hospital
    const  returnURL = `/hospital/${id}/dashboard`
    const cardsData = {cardsName:"医院",cardsFor: "hospital",cardsSource: hospital,returnURL,displayName,
  		subItems: [
{name: 'expenseTypeList', displayName:'费用类型',type:'expenseType',count:expenseTypeCount,addFunction: true, role: 'expenseType',  renderItem: GlobalComponents.ExpenseTypeBase.renderItemOfList},
{name: 'periodList', displayName:'期',type:'period',count:periodCount,addFunction: false, role: 'period',  renderItem: GlobalComponents.PeriodBase.renderItemOfList},
{name: 'expenseItemList', displayName:'费用项目',type:'expenseItem',count:expenseItemCount,addFunction: true, role: 'expenseItem',  renderItem: GlobalComponents.ExpenseItemBase.renderItemOfList},
{name: 'departmentList', displayName:'部门',type:'department',count:departmentCount,addFunction: true, role: 'department',  renderItem: GlobalComponents.DepartmentBase.renderItemOfList},
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSettingList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  hospital: state._hospital,
}))(Form.create()(HospitalProfile))

