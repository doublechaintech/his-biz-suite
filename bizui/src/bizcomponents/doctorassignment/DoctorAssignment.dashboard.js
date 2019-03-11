

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
import styles from './DoctorAssignment.dashboard.less'
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


const imageList =(doctorAssignment)=>{return [
	 ]}

const internalImageListOf = (doctorAssignment) =>defaultImageListOf(doctorAssignment,imageList)

const optionList =(doctorAssignment)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (doctorAssignment) =>defaultSettingListOf(doctorAssignment, optionList)
const internalLargeTextOf = (doctorAssignment) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (doctorAssignment,targetComponent) =>{
	
	
	const {DoctorAssignmentService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{doctorAssignment.id}</Description> 
<Description term="Name">{doctorAssignment.name}</Description> 
<Description term="Doctor">{doctorAssignment.doctor==null?appLocaleName(userContext,"NotAssigned"):doctorAssignment.doctor.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Doctor","doctor",DoctorAssignmentService.requestCandidateDoctor,
	      DoctorAssignmentService.transferToAnotherDoctor,"anotherDoctorId",doctorAssignment.doctor?doctorAssignment.doctor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Department">{doctorAssignment.department==null?appLocaleName(userContext,"NotAssigned"):doctorAssignment.department.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Department","department",DoctorAssignmentService.requestCandidateDepartment,
	      DoctorAssignmentService.transferToAnotherDepartment,"anotherDepartmentId",doctorAssignment.department?doctorAssignment.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(doctorAssignment,targetComponent)}
      </DescriptionList>
	)

}


class DoctorAssignmentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'doctorAssignment'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.doctorAssignment
    if(!this.props.doctorAssignment.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Doctor Assignment",cardsFor: "doctorAssignment",
    	cardsSource: this.props.doctorAssignment,returnURL,displayName,
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
  doctorAssignment: state._doctorAssignment,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(DoctorAssignmentDashboard))

