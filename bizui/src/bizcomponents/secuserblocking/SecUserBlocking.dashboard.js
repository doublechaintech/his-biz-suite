import React, { Component } from 'react';
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva';
import moment from 'moment';
import BooleanOption from 'components/BooleanOption';
import {
  Row,
  Col,
  Icon,
  Card,
  Tabs,
  Table,
  Radio,
  DatePicker,
  Tooltip,
  Menu,
  Dropdown,
  Badge,
  Switch,
  Select,
  Form,
  AutoComplete,
  Modal,
} from 'antd';
import { Link, Route, Redirect } from 'dva/router';
import numeral from 'numeral';
import {
  ChartCard,
  yuan,
  MiniArea,
  MiniBar,
  MiniProgress,
  Field,
  Bar,
  Pie,
  TimelineChart,
} from '../../components/Charts';
import Trend from '../../components/Trend';
import NumberInfo from '../../components/NumberInfo';
import { getTimeDistance } from '../../utils/utils';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './SecUserBlocking.dashboard.less';
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool';
import appLocaleName from '../../common/Locale.tool';

const {
  aggregateDataset,
  calcKey,
  defaultHideCloseTrans,
  defaultImageListOf,
  defaultSettingListOf,
  defaultBuildTransferModal,
  defaultExecuteTrans,
  defaultHandleTransferSearch,
  defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,
  renderForTimeLine,
  renderForNumbers,
} = DashboardTool;

const { Description } = DescriptionList;
<<<<<<< HEAD
const { TabPane } = Tabs;
const { RangePicker } = DatePicker;
const { Option } = Select;

const imageList = secUserBlocking => {
  return [];
};

const internalImageListOf = secUserBlocking => defaultImageListOf(secUserBlocking, imageList);

const optionList = secUserBlocking => {
  return [];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalSettingListOf = secUserBlocking => defaultSettingListOf(secUserBlocking, optionList);
const internalLargeTextOf = secUserBlocking => {
  return null;
};

const internalRenderExtraHeader = defaultRenderExtraHeader;

const internalRenderExtraFooter = defaultRenderExtraFooter;
const internalSubListsOf = defaultSubListsOf;

const internalRenderTitle = (cardsData, targetComponent) => {
  const linkComp = cardsData.returnURL ? (
    <Link to={cardsData.returnURL}>
      {' '}
      <FontAwesome name="arrow-left" />{' '}
    </Link>
  ) : null;
  return (
    <div>
      {linkComp}
      {cardsData.cardsName}: {cardsData.displayName}
    </div>
  );
};

const internalSummaryOf = (secUserBlocking, targetComponent) => {
  const { SecUserBlockingService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID">{secUserBlocking.id}</Description>
      <Description term="谁">{secUserBlocking.who}</Description>
      <Description term="块时间">
        {moment(secUserBlocking.blockTime).format('YYYY-MM-DD')}
      </Description>
      <Description term="评论">{secUserBlocking.comments}</Description>

      {buildTransferModal(secUserBlocking, targetComponent)}
    </DescriptionList>
  );
};
=======
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(secUserBlocking)=>{return [
	 ]}

const internalImageListOf = (secUserBlocking) =>defaultImageListOf(secUserBlocking,imageList)

const optionList =(secUserBlocking)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (secUserBlocking) =>defaultSettingListOf(secUserBlocking, optionList)
const internalLargeTextOf = (secUserBlocking) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (secUserBlocking,targetComponent) =>{
	
	
	const {SecUserBlockingService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{secUserBlocking.id}</Description> 
<Description term="谁">{secUserBlocking.who}</Description> 
<Description term="块时间">{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{secUserBlocking.comments}</Description> 
	
        {buildTransferModal(secUserBlocking,targetComponent)}
      </DescriptionList>
	)

}

>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

class SecUserBlockingDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'secUserBlocking',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const { id, displayName, secUserListMetaInfo, secUserCount } = this.props.secUserBlocking;
    if (!this.props.secUserBlocking.class) {
      return null;
    }
<<<<<<< HEAD
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '用户屏蔽',
      cardsFor: 'secUserBlocking',
      cardsSource: this.props.secUserBlocking,
      returnURL,
      displayName,
      subItems: [
        {
          name: 'secUserList',
          displayName: '安全用户',
          type: 'secUser',
          count: secUserCount,
          addFunction: true,
          role: 'secUser',
          metaInfo: secUserListMetaInfo,
        },
      ],
    };

    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader;
    const settingListOf = this.props.settingListOf || internalSettingListOf;
    const imageListOf = this.props.imageListOf || internalImageListOf;
    const subListsOf = this.props.subListsOf || internalSubListsOf;
    const largeTextOf = this.props.largeTextOf || internalLargeTextOf;
    const summaryOf = this.props.summaryOf || internalSummaryOf;
    const renderTitle = this.props.renderTitle || internalRenderTitle;
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter;
=======
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"用户屏蔽",cardsFor: "secUserBlocking",
    	cardsSource: this.props.secUserBlocking,returnURL,displayName,
  		subItems: [
{name: 'secUserList', displayName:'安全用户',type:'secUser',count:secUserCount,addFunction: true, role: 'secUser', metaInfo: secUserListMetaInfo},
    
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
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    return (
      <PageHeaderLayout
        title={renderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
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
    );
  }
}

export default connect(state => ({
  secUserBlocking: state._secUserBlocking,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(SecUserBlockingDashboard));
