

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Hospital.preference.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select




const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}




const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.HospitalBase.renderItem(item, targetComponents)

}

const internalQuickFunctions = defaultQuickFunctions

class HospitalPreference extends Component {

 state = {
   


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, expenseTypeListMetaInfo, periodListMetaInfo, expenseItemListMetaInfo, doctorListMetaInfo, departmentListMetaInfo, doctorScheduleListMetaInfo, expenseTypeCount, periodCount, expenseItemCount, doctorCount, departmentCount, doctorScheduleCount } = this.props.hospital
    if(!this.props.hospital.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"医院",cardsFor: "hospital",
    	cardsSource: this.props.hospital,returnURL,displayName,
  		subItems: [
{name: 'expenseTypeList', displayName:'费用类型',type:'expenseType',count:expenseTypeCount,addFunction: true, role: 'expenseType', metaInfo: expenseTypeListMetaInfo, renderItem: GlobalComponents.ExpenseTypeBase.renderItemOfList},
{name: 'periodList', displayName:'期',type:'period',count:periodCount,addFunction: false, role: 'period', metaInfo: periodListMetaInfo, renderItem: GlobalComponents.PeriodBase.renderItemOfList},
{name: 'expenseItemList', displayName:'费用项目',type:'expenseItem',count:expenseItemCount,addFunction: true, role: 'expenseItem', metaInfo: expenseItemListMetaInfo, renderItem: GlobalComponents.ExpenseItemBase.renderItemOfList},
{name: 'departmentList', displayName:'部门22',type:'department',count:departmentCount,addFunction: true, role: 'department', metaInfo: departmentListMetaInfo, renderItem: GlobalComponents.DepartmentBase.renderItemOfList},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
     
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
       
        
       
        
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  hospital: state._hospital,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(HospitalPreference))

