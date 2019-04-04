

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ExpenseItem.preference.less'
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


const internalSummaryOf = (expenseItem,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{expenseItem.id}</Description> 
<Description term="名称">{expenseItem.name}</Description> 
<Description term="价格">{expenseItem.price}</Description> 
<Description term="更新时间">{ moment(expenseItem.updateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}



class ExpenseItemProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  expenseItem = this.props.expenseItem;
    const { id,displayName,  } = expenseItem

    const cardsData = {cardsName:"费用项目",cardsFor: "expenseItem",cardsSource: expenseItem,
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
  expenseItem: state._expenseItem,
}))(Form.create()(ExpenseItemProfile))

