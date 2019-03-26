

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
import styles from './Hospital.dashboard.less'
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


const imageList =(hospital)=>{return [
	 ]}

const internalImageListOf = (hospital) =>defaultImageListOf(hospital,imageList)

const optionList =(hospital)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (hospital) =>defaultSettingListOf(hospital, optionList)
const internalLargeTextOf = (hospital) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (hospital,targetComponent) =>{
	
	
	const {HospitalService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{hospital.id}</Description> 
<Description term="名称">{hospital.name}</Description> 
<Description term="地址">{hospital.address}</Description> 
<Description term="电话">{hospital.telephone}</Description> 
	
        {buildTransferModal(hospital,targetComponent)}
      </DescriptionList>
	)

}


const defaultSubTabs = (cardsData,targetComponent) => {
  const userContext = null;
  const { id } = cardsData.cardsSource;

  const renderExtraHeader = targetComponent.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = targetComponent.props.settingListOf || internalSettingListOf
    const imageListOf = targetComponent.props.imageListOf || internalImageListOf
    const subListsOf = targetComponent.props.subListsOf || internalSubListsOf
    const largeTextOf = targetComponent.props.largeTextOf ||internalLargeTextOf
    


  return (
    <Tabs defaultActiveKey="1" type="card" >

<TabPane tab="主页" key="1"> {renderExtraHeader(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
       
        {largeTextOf(cardsData.cardsSource)}</TabPane>

      {cardsData.subItems
        .sort((x, y) => x.displayName.localeCompare(y.displayName, 'zh-CN'))
       
        .map(item => (

          <TabPane tab={`${item.displayName}(${numeral(item.count).format('0,0')})`} key={item.displayName}> 
          <Card
          title={`${item.displayName}(${numeral(item.count).format('0,0')})`}
          style={{ width: 180 }}
        >
          <p>
            <Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}>
              <FontAwesome name="eye" />
              {appLocaleName(userContext, 'Manage')}
            </Link>

            {(
              <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}>
                <span className={styles.splitLine} />
                <FontAwesome name="plus" />
                {appLocaleName(userContext, 'Add')}
              </Link>
            )}
          </p>
        </Card></TabPane>
          
        ))}
    </Tabs>
  );
};


class HospitalDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'hospital'


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
{name: 'doctorList', displayName:'医生',type:'doctor',count:doctorCount,addFunction: true, role: 'doctor', metaInfo: doctorListMetaInfo},
{name: 'doctorScheduleList', displayName:'医生安排',type:'doctorSchedule',count:doctorScheduleCount,addFunction: true, role: 'doctorSchedule', metaInfo: doctorScheduleListMetaInfo},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    // const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
     
        
       
   
    {defaultSubTabs(cardsData,this)}
 

       
          
        
      </PageHeaderLayout>
    )
  }
}
/*
 <TabPane tab="主页" key="1"> {renderExtraHeader(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}</TabPane>

 */
export default connect(state => ({
  hospital: state._hospital,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(HospitalDashboard))

