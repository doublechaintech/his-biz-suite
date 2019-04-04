

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Doctor.preference.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (doctor,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{doctor.id}</Description> 
<Description term="名称">{doctor.name}</Description> 
<Description term="更新时间">{ moment(doctor.updateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = doctor => {
  const {DoctorBase} = GlobalComponents
  return <PermissionSetting targetObject={doctor}  targetObjectMeta={DoctorBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class DoctorPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  doctor = this.props.doctor;
    const { id,displayName, doctorAssignmentCount, doctorScheduleCount } = doctor
    const cardsData = {cardsName:"医生",cardsFor: "doctor",cardsSource: doctor,
  		subItems: [
{name: 'doctorAssignmentList', displayName:'医生的任务',type:'doctorAssignment',count:doctorAssignmentCount,addFunction: true, role: 'doctorAssignment', data: doctor.doctorAssignmentList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  doctor: state._doctor,
}))(Form.create()(DoctorPermission))

