

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
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,defaultQuickFunctions
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
<Description term="ID">{doctorSchedule.id}</Description> 
<Description term="名称">{doctorSchedule.name}</Description> 
<Description term="医生">{doctorSchedule.doctor==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.doctor.displayName}(${doctorSchedule.doctor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"医生","doctor",DoctorScheduleService.requestCandidateDoctor,
	      DoctorScheduleService.transferToAnotherDoctor,"anotherDoctorId",doctorSchedule.doctor?doctorSchedule.doctor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="安排日期">{ moment(doctorSchedule.scheduleDate).format('YYYY-MM-DD')}</Description> 
<Description term="期">{doctorSchedule.period==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.period.displayName}(${doctorSchedule.period.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"期","period",DoctorScheduleService.requestCandidatePeriod,
	      DoctorScheduleService.transferToAnotherPeriod,"anotherPeriodId",doctorSchedule.period?doctorSchedule.period.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="部门">{doctorSchedule.department==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.department.displayName}(${doctorSchedule.department.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"部门","department",DoctorScheduleService.requestCandidateDepartment,
	      DoctorScheduleService.transferToAnotherDepartment,"anotherDepartmentId",doctorSchedule.department?doctorSchedule.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="可用">{doctorSchedule.available}</Description> 
<Description term="价格">{doctorSchedule.price}</Description> 
<Description term="费用类型">{doctorSchedule.expenseType==null?appLocaleName(userContext,"NotAssigned"):`${doctorSchedule.expenseType.displayName}(${doctorSchedule.expenseType.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"费用类型","expenseType",DoctorScheduleService.requestCandidateExpenseType,
	      DoctorScheduleService.transferToAnotherExpenseType,"anotherExpenseTypeId",doctorSchedule.expenseType?doctorSchedule.expenseType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="创建时间">{ moment(doctorSchedule.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="更新时间">{ moment(doctorSchedule.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(doctorSchedule,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

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
    
    const cardsData = {cardsName:"医生安排",cardsFor: "doctorSchedule",
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
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
        {quickFunctions(cardsData)} 
        {renderExtraHeader(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}        
        {largeTextOf(cardsData.cardsSource)}
  
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  doctorSchedule: state._doctorSchedule,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(DoctorScheduleDashboard))

