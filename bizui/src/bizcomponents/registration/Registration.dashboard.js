

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
import styles from './Registration.dashboard.less'
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


const imageList =(registration)=>{return [
	 ]}

const internalImageListOf = (registration) =>defaultImageListOf(registration,imageList)

const optionList =(registration)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (registration) =>defaultSettingListOf(registration, optionList)
const internalLargeTextOf = (registration) =>{

	return(<div> 
   <Card title={`Content`} ><pre>{registration.content}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (registration,targetComponent) =>{
	
	
	const {RegistrationService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{registration.id}</Description> 
<Description term="Title">{registration.title}</Description> 
<Description term="Patient">{registration.patient==null?appLocaleName(userContext,"NotAssigned"):registration.patient.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Patient","profile",RegistrationService.requestCandidatePatient,
	      RegistrationService.transferToAnotherPatient,"anotherPatientId",registration.patient?registration.patient.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Register">{registration.register==null?appLocaleName(userContext,"NotAssigned"):registration.register.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Register","profile",RegistrationService.requestCandidateRegister,
	      RegistrationService.transferToAnotherRegister,"anotherRegisterId",registration.register?registration.register.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Update Time">{ moment(registration.updateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Status">{registration.status}</Description> 
	
        {buildTransferModal(registration,targetComponent)}
      </DescriptionList>
	)

}


class RegistrationDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'registration'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.registration
    if(!this.props.registration.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Registration",cardsFor: "registration",
    	cardsSource: this.props.registration,returnURL,displayName,
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
  registration: state._registration,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RegistrationDashboard))

