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
import styles from './ListAccess.dashboard.less';
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

const imageList = listAccess => {
  return [];
};

const internalImageListOf = listAccess => defaultImageListOf(listAccess, imageList);

const optionList = listAccess => {
  return [
    { title: '读权限', value: listAccess.readPermission, parameterName: 'readPermission' },
    { title: '创建权限', value: listAccess.createPermission, parameterName: 'createPermission' },
    { title: '删除权限', value: listAccess.deletePermission, parameterName: 'deletePermission' },
    { title: '更新许可', value: listAccess.updatePermission, parameterName: 'updatePermission' },
    {
      title: '执行权限',
      value: listAccess.executionPermission,
      parameterName: 'executionPermission',
    },
  ];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalSettingListOf = listAccess => defaultSettingListOf(listAccess, optionList);
const internalLargeTextOf = listAccess => {
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

const internalSummaryOf = (listAccess, targetComponent) => {
  const { ListAccessService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID">{listAccess.id}</Description>
      <Description term="名称">{listAccess.name}</Description>
      <Description term="内部名称">{listAccess.internalName}</Description>
      <Description term="应用程序">
        {listAccess.app == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${listAccess.app.displayName}(${listAccess.app.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '应用程序',
              'userApp',
              ListAccessService.requestCandidateApp,
              ListAccessService.transferToAnotherApp,
              'anotherAppId',
              listAccess.app ? listAccess.app.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>

      {buildTransferModal(listAccess, targetComponent)}
    </DescriptionList>
  );
};
=======
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(listAccess)=>{return [
	 ]}

const internalImageListOf = (listAccess) =>defaultImageListOf(listAccess,imageList)

const optionList =(listAccess)=>{return [ 
	  {"title":'读权限',"value":listAccess.readPermission,"parameterName":"readPermission"},
  {"title":'创建权限',"value":listAccess.createPermission,"parameterName":"createPermission"},
  {"title":'删除权限',"value":listAccess.deletePermission,"parameterName":"deletePermission"},
  {"title":'更新许可',"value":listAccess.updatePermission,"parameterName":"updatePermission"},
  {"title":'执行权限',"value":listAccess.executionPermission,"parameterName":"executionPermission"},
]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (listAccess) =>defaultSettingListOf(listAccess, optionList)
const internalLargeTextOf = (listAccess) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (listAccess,targetComponent) =>{
	
	
	const {ListAccessService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{listAccess.id}</Description> 
<Description term="名称">{listAccess.name}</Description> 
<Description term="内部名称">{listAccess.internalName}</Description> 
<Description term="应用程序">{listAccess.app==null?appLocaleName(userContext,"NotAssigned"):listAccess.app.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"应用程序","userApp",ListAccessService.requestCandidateApp,
	      ListAccessService.transferToAnotherApp,"anotherAppId",listAccess.app?listAccess.app.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(listAccess,targetComponent)}
      </DescriptionList>
	)

}

>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89

class ListAccessDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'listAccess',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const { id, displayName } = this.props.listAccess;
    if (!this.props.listAccess.class) {
      return null;
    }
<<<<<<< HEAD
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '访问列表',
      cardsFor: 'listAccess',
      cardsSource: this.props.listAccess,
      returnURL,
      displayName,
      subItems: [],
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
    
    const cardsData = {cardsName:"访问列表",cardsFor: "listAccess",
    	cardsSource: this.props.listAccess,returnURL,displayName,
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
  listAccess: state._listAccess,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(ListAccessDashboard));
