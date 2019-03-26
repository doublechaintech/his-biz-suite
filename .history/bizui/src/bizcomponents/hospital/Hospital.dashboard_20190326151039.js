

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Statistic, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal ,Button} from 'antd'
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
const ButtonGroup = Button.Group;
const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
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

/*

<ButtonGroup>
            <Button onClick={this.decline}>
              <Icon type="minus" />
            </Button>
            <Button onClick={this.increase}>
              <Icon type="plus" />
            </Button>
          </ButtonGroup>


          title={
                <span>
                  <Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}>
                  {item.displayName}({numeral(item.count).format('0,0')})
                
                </Link>
                  { (
                  <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}>
                    <span className={styles.splitLine} />
                    <FontAwesome name="plus" />
                    {appLocaleName(userContext, 'Add')}
                  </Link>)}
                </span>}
*/

const quickFunctions = cardsData => {
  const userContext = null;
  const { id } = cardsData.cardsSource;
  return (
    <Row gutter={16}>
      
      {cardsData.subItems
        .sort((x, y) => x.displayName.localeCompare(y.displayName, 'zh-CN'))
       
        .map(item => (
          <Col span={6}><Card span={6} style={{"font-size":"25px"}}>
          <FontAwesome name="plus" />{item.displayName} ({item.count})
     
    </Card></Col>
         
        ))}
    </Row>
    
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
    defaultType: 'hospital',


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
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
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
  hospital: state._hospital,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(HospitalDashboard))

