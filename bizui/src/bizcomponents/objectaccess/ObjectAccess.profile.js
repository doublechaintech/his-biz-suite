

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ObjectAccess.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (objectAccess,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{objectAccess.id}</Description> 
<Description term="名称">{objectAccess.name}</Description> 
<Description term="访问对象类型">{objectAccess.objectType}</Description> 
<Description term="列表1">{objectAccess.list1}</Description> 
<Description term="列表2">{objectAccess.list2}</Description> 
<Description term="列表3">{objectAccess.list3}</Description> 
<Description term="列表4">{objectAccess.list4}</Description> 
<Description term="列表5">{objectAccess.list5}</Description> 
<Description term="列表6">{objectAccess.list6}</Description> 
<Description term="列表7">{objectAccess.list7}</Description> 
<Description term="列表8">{objectAccess.list8}</Description> 
<Description term="列表9">{objectAccess.list9}</Description> 
	
      </DescriptionList>
	)
}



class ObjectAccessProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  objectAccess = this.props.objectAccess;
    const { id,displayName,  } = objectAccess

    const cardsData = {cardsName:"对象访问",cardsFor: "objectAccess",cardsSource: objectAccess,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  objectAccess: state._objectAccess,
}))(Form.create()(ObjectAccessProfile))

