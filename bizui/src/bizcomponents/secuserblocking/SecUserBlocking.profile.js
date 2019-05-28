

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SecUserBlocking.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSubjectList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSubjectList = defaultRenderSubjectList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.SecUserBlockingBase.renderItemOfList(item, targetComponents)

}



class SecUserBlockingProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  secUserBlocking = this.props.secUserBlocking;
    const { id,displayName, secUserCount } = secUserBlocking

    const cardsData = {cardsName:"用户屏蔽",cardsFor: "secUserBlocking",cardsSource: secUserBlocking,
  		subItems: [
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSubjectList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  secUserBlocking: state._secUserBlocking,
}))(Form.create()(SecUserBlockingProfile))

