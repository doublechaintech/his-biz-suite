

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
import styles from './Period.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (period,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{period.id}</Description> 
<Description term="名称">{period.name}</Description> 
<Description term="代码">{period.code}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = period => {
  const {PeriodBase} = GlobalComponents
  return <PermissionSetting targetObject={period}  targetObjectMeta={PeriodBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PeriodPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  period = this.props.period;
    const { id,displayName, doctorScheduleCount } = period
    const cardsData = {cardsName:"期",cardsFor: "period",cardsSource: period,
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
  period: state._period,
}))(Form.create()(PeriodPermission))

