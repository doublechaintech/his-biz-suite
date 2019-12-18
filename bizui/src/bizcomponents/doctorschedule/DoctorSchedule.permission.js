

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
import styles from './DoctorSchedule.profile.less'
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


const renderPermissionSetting = doctorSchedule => {
  const {DoctorScheduleBase} = GlobalComponents
  return <PermissionSetting targetObject={doctorSchedule}  targetObjectMeta={DoctorScheduleBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class DoctorSchedulePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  doctorSchedule = this.props.doctorSchedule
    const { id,displayName,  } = doctorSchedule
    const  returnURL = `/doctorSchedule/${id}/dashboard`
    const cardsData = {cardsName:"医生安排",cardsFor: "doctorSchedule",cardsSource: doctorSchedule,displayName,returnURL,
  		subItems: [
    
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
  doctorSchedule: state._doctorSchedule,
}))(Form.create()(DoctorSchedulePermission))

