

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './DoctorSchedule.preference.less'
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


const internalSummaryOf = (doctorSchedule,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{doctorSchedule.id}</Description> 
<Description term="名称">{doctorSchedule.name}</Description> 
<Description term="安排日期">{ moment(doctorSchedule.scheduleDate).format('YYYY-MM-DD')}</Description> 
<Description term="可用">{doctorSchedule.available}</Description> 
<Description term="价格">{doctorSchedule.price}</Description> 
<Description term="创建时间">{ moment(doctorSchedule.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="更新时间">{ moment(doctorSchedule.updateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}



class DoctorScheduleProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  doctorSchedule = this.props.doctorSchedule;
    const { id,displayName,  } = doctorSchedule

    const cardsData = {cardsName:"医生安排",cardsFor: "doctorSchedule",cardsSource: doctorSchedule,
  		subItems: [
    
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
  doctorSchedule: state._doctorSchedule,
}))(Form.create()(DoctorScheduleProfile))

