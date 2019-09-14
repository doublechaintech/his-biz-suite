

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
import styles from './DoctorAssignment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (doctorAssignment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{doctorAssignment.id}</Description> 
<Description term="名称">{doctorAssignment.name}</Description> 
<Description term="更新时间">{ moment(doctorAssignment.updateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = doctorAssignment => {
  const {DoctorAssignmentBase} = GlobalComponents
  return <PermissionSetting targetObject={doctorAssignment}  targetObjectMeta={DoctorAssignmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class DoctorAssignmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  doctorAssignment = this.props.doctorAssignment;
    const { id,displayName,  } = doctorAssignment
    const cardsData = {cardsName:"医生的任务",cardsFor: "doctorAssignment",cardsSource: doctorAssignment,
  		subItems: [
    
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
  doctorAssignment: state._doctorAssignment,
}))(Form.create()(DoctorAssignmentPermission))

