

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
import styles from './DoctorSchedule.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(doctorSchedule)=>{return [
	 ]}

const internalImageListOf = (doctorSchedule) =>defaultImageListOf(doctorSchedule,imageList)

const optionList =(doctorSchedule)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (doctorSchedule) =>defaultSettingListOf(doctorSchedule, optionList)
const internalLargeTextOf = (doctorSchedule) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (doctorSchedule,targetComponent) =>{
	
	
	const {DoctorScheduleService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{doctorSchedule.id}</Description> 
<Description term="Name">{doctorSchedule.name}</Description> 
<Description term="Schedule Date">{ moment(doctorSchedule.scheduleDate).format('YYYY-MM-DD')}</Description> 
<Description term="Period">{doctorSchedule.period}</Description> 
<Description term="Doctor">{doctorSchedule.doctor==null?appLocaleName(userContext,"NotAssigned"):doctorSchedule.doctor.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Doctor","doctor",DoctorScheduleService.requestCandidateDoctor,
	      DoctorScheduleService.transferToAnotherDoctor,"anotherDoctorId",doctorSchedule.doctor?doctorSchedule.doctor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Available">{doctorSchedule.available}</Description> 
<Description term="Price">{doctorSchedule.price}</Description> 
<Description term="Expense Type">{doctorSchedule.expenseType==null?appLocaleName(userContext,"NotAssigned"):doctorSchedule.expenseType.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Expense Type","expenseType",DoctorScheduleService.requestCandidateExpenseType,
	      DoctorScheduleService.transferToAnotherExpenseType,"anotherExpenseTypeId",doctorSchedule.expenseType?doctorSchedule.expenseType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Department">{doctorSchedule.department==null?appLocaleName(userContext,"NotAssigned"):doctorSchedule.department.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Department","department",DoctorScheduleService.requestCandidateDepartment,
	      DoctorScheduleService.transferToAnotherDepartment,"anotherDepartmentId",doctorSchedule.department?doctorSchedule.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(doctorSchedule,targetComponent)}
      </DescriptionList>
	)

}


class DoctorScheduleDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'doctorSchedule'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.doctorSchedule
    if(!this.props.doctorSchedule.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Doctor Schedule",cardsFor: "doctorSchedule",
    	cardsSource: this.props.doctorSchedule,returnURL,displayName,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  doctorSchedule: state._doctorSchedule,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(DoctorScheduleDashboard))

