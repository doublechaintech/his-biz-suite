

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Department.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (department,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{department.id}</Description> 
<Description term="名称">{department.name}</Description> 
<Description term="更新时间">{ moment(department.updateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}



class DepartmentProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  department = this.props.department;
    const { id,displayName, doctorAssignmentCount, doctorScheduleCount } = department

    const cardsData = {cardsName:"部门",cardsFor: "department",cardsSource: department,
  		subItems: [
{name: 'doctorAssignmentList', displayName:'医生的任务',type:'doctorAssignment',count:doctorAssignmentCount,addFunction: true, role: 'doctorAssignment', data: department.doctorAssignmentList},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  department: state._department,
}))(Form.create()(DepartmentProfile))

