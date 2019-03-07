

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
import styles from './LoginHistory.dashboard.less'
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


const imageList =(loginHistory)=>{return [
	 ]}

const internalImageListOf = (loginHistory) =>defaultImageListOf(loginHistory,imageList)

const optionList =(loginHistory)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (loginHistory) =>defaultSettingListOf(loginHistory, optionList)
const internalLargeTextOf = (loginHistory) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (loginHistory,targetComponent) =>{
	
	
	const {LoginHistoryService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{loginHistory.id}</Description> 
<Description term="Login Time">{ moment(loginHistory.loginTime).format('YYYY-MM-DD')}</Description> 
<Description term="From Ip">{loginHistory.fromIp}</Description> 
<Description term="Description">{loginHistory.description}</Description> 
<Description term="Sec User">{loginHistory.secUser==null?appLocaleName(userContext,"NotAssigned"):loginHistory.secUser.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Sec User","secUser",LoginHistoryService.requestCandidateSecUser,
	      LoginHistoryService.transferToAnotherSecUser,"anotherSecUserId",loginHistory.secUser?loginHistory.secUser.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(loginHistory,targetComponent)}
      </DescriptionList>
	)

}


class LoginHistoryDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'loginHistory'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.loginHistory
    if(!this.props.loginHistory.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Login History",cardsFor: "loginHistory",
    	cardsSource: this.props.loginHistory,returnURL,displayName,
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
  loginHistory: state._loginHistory,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(LoginHistoryDashboard))

