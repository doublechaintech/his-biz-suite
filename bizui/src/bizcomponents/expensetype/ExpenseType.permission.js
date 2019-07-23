import React, { Component } from 'react';
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva';
import moment from 'moment';
import BooleanOption from '../../components/BooleanOption';
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

import DashboardTool from '../../common/Dashboard.tool';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './ExpenseType.profile.less';
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting';
import appLocaleName from '../../common/Locale.tool';
const { Description } = DescriptionList;
const { defaultRenderExtraHeader } = DashboardTool;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalSummaryOf = (expenseType, targetComponent) => {
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID">{expenseType.id}</Description>
      <Description term="名称">{expenseType.name}</Description>
      <Description term="辅助识字课">{expenseType.helperChars}</Description>
      <Description term="状态">{expenseType.status}</Description>
      <Description term="更新时间">
        {moment(expenseType.updateTime).format('YYYY-MM-DD')}
      </Description>
    </DescriptionList>
  );
};

const renderPermissionSetting = expenseType => {
  const { ExpenseTypeBase } = GlobalComponents;
  return <PermissionSetting targetObject={expenseType} targetObjectMeta={ExpenseTypeBase} />;
};

const internalRenderExtraHeader = defaultRenderExtraHeader;

class ExpenseTypePermission extends Component {
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const expenseType = this.props.expenseType;
    const { id, displayName, expenseItemCount, doctorScheduleCount } = expenseType;
    const cardsData = {
      cardsName: '费用类型',
      cardsFor: 'expenseType',
      cardsSource: expenseType,
      subItems: [
        {
          name: 'expenseItemList',
          displayName: '费用项目',
          type: 'expenseItem',
          count: expenseItemCount,
          addFunction: true,
          role: 'expenseItem',
          data: expenseType.expenseItemList,
        },
      ],
    };
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader;
    const summaryOf = this.props.summaryOf || internalSummaryOf;

    return (
      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource, this)}
        wrapperClassName={styles.advancedForm}
      >
        {renderExtraHeader(cardsData.cardsSource)}
        {renderPermissionSetting(cardsData.cardsSource)}
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  expenseType: state._expenseType,
}))(Form.create()(ExpenseTypePermission));
