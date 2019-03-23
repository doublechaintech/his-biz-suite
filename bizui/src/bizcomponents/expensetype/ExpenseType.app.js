import React from 'react';
import PropTypes from 'prop-types';
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,
  Button,
} from 'antd';
import DocumentTitle from 'react-document-title';
import { connect } from 'dva';
import { Link, Route, Redirect, Switch } from 'dva/router';
import moment from 'moment';
import groupBy from 'lodash/groupBy';
import { ContainerQuery } from 'react-container-query';
import classNames from 'classnames';
import styles from './ExpenseType.app.less';
import { sessionObject } from '../../utils/utils';

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';

import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service';
import appLocaleName from '../../common/Locale.tool';

const { filterForMenuPermission } = PermissionSettingService;

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true;
};

const filteredMenuItems = (targetObject, targetComponent) => {
  const menuData = sessionObject('menuData');
  const isMenuItemForDisplayFunc =
    targetComponent.props.isMenuItemForDisplayFunc || isMenuItemForDisplay;
  return menuData.subItems
    .filter(item => filterForMenuPermission(item, targetObject, targetComponent))
    .filter(item => isMenuItemForDisplayFunc(item, targetObject, targetComponent));
};

const { Header, Sider, Content } = Layout;
const { SubMenu } = Menu;

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
};

class ExpenseTypeBizApp extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    };
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout);
  }
  onCollapse = collapsed => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    });
  };

  getDefaultCollapsedSubMenus = props => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)];
    currentMenuSelectedKeys.splice(-1, 1);
    if (currentMenuSelectedKeys.length === 0) {
      return ['/expenseType/'];
    }
    return currentMenuSelectedKeys;
  };
  getCurrentMenuSelectedKeys = props => {
    const { location: { pathname } } = props || this.props;
    const keys = pathname.split('/').slice(1);
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key];
    }
    return keys;
  };

  getNavMenuItems = targetObject => {
    const menuData = sessionObject('menuData');
    const targetApp = sessionObject('targetApp');
    const { objectId } = targetApp;
    const userContext = null;
    return (
      <Menu
        theme="dark"
        mode="inline"
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ margin: '16px 0', width: '100%' }}
      >
        <Menu.Item key="dashboard">
          <Link to={`/expenseType/${this.props.expenseType.id}/dashboard`}>
            <Icon type="dashboard" />
            <span>{appLocaleName(userContext, 'Dashboard')}</span>
          </Link>
        </Menu.Item>

        {filteredMenuItems(targetObject, this).map(item => (
          <Menu.Item key={item.name}>
            <Link
              to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${
                item.displayName
              }${appLocaleName(userContext, 'List')}`}
            >
              <Icon type="bars" />
              <span>{item.displayName}</span>
            </Link>
          </Menu.Item>
        ))}

        <Menu.Item key="preference">
          <Link to={`/expenseType/${this.props.expenseType.id}/preference`}>
            <Icon type="setting" />
            <span>{appLocaleName(userContext, 'Preference')}</span>
          </Link>
        </Menu.Item>
      </Menu>
    );
  };

  getExpenseItemSearch = () => {
    const { ExpenseItemSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
<<<<<<< HEAD
      name: '费用项目',
      role: 'expenseItem',
=======
      name: "费用项目",
      role: "expenseItem",
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
      data: state._expenseType.expenseItemList,
      metaInfo: state._expenseType.expenseItemListMetaInfo,
      count: state._expenseType.expenseItemCount,
      currentPage: state._expenseType.expenseItemCurrentPageNumber,
      searchFormParameters: state._expenseType.expenseItemSearchFormParameters,
      searchParameters: { ...state._expenseType.searchParameters },
      expandForm: state._expenseType.expandForm,
      loading: state._expenseType.loading,
      partialList: state._expenseType.partialList,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        referenceName: 'expenseType',
        listName: 'expenseItemList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ExpenseItemSearch);
  };
  getExpenseItemCreateForm = () => {
    const { ExpenseItemCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'expenseItem',
      data: state._expenseType.expenseItemList,
      metaInfo: state._expenseType.expenseItemListMetaInfo,
      count: state._expenseType.expenseItemCount,
      currentPage: state._expenseType.expenseItemCurrentPageNumber,
      searchFormParameters: state._expenseType.expenseItemSearchFormParameters,
      loading: state._expenseType.loading,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        referenceName: 'expenseType',
        listName: 'expenseItemList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ExpenseItemCreateForm);
  };

  getExpenseItemUpdateForm = () => {
    const userContext = null;
    const { ExpenseItemUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._expenseType.selectedRows,
      role: 'expenseItem',
      currentUpdateIndex: state._expenseType.currentUpdateIndex,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        listName: 'expenseItemList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ExpenseItemUpdateForm);
  };

  getDoctorScheduleSearch = () => {
    const { DoctorScheduleSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
<<<<<<< HEAD
      name: '医生安排',
      role: 'doctorSchedule',
=======
      name: "医生安排",
      role: "doctorSchedule",
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
      data: state._expenseType.doctorScheduleList,
      metaInfo: state._expenseType.doctorScheduleListMetaInfo,
      count: state._expenseType.doctorScheduleCount,
      currentPage: state._expenseType.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._expenseType.doctorScheduleSearchFormParameters,
      searchParameters: { ...state._expenseType.searchParameters },
      expandForm: state._expenseType.expandForm,
      loading: state._expenseType.loading,
      partialList: state._expenseType.partialList,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        referenceName: 'expenseType',
        listName: 'doctorScheduleList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(DoctorScheduleSearch);
  };
  getDoctorScheduleCreateForm = () => {
    const { DoctorScheduleCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'doctorSchedule',
      data: state._expenseType.doctorScheduleList,
      metaInfo: state._expenseType.doctorScheduleListMetaInfo,
      count: state._expenseType.doctorScheduleCount,
      currentPage: state._expenseType.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._expenseType.doctorScheduleSearchFormParameters,
      loading: state._expenseType.loading,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        referenceName: 'expenseType',
        listName: 'doctorScheduleList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(DoctorScheduleCreateForm);
  };

  getDoctorScheduleUpdateForm = () => {
    const userContext = null;
    const { DoctorScheduleUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._expenseType.selectedRows,
      role: 'doctorSchedule',
      currentUpdateIndex: state._expenseType.currentUpdateIndex,
      owner: {
        type: '_expenseType',
        id: state._expenseType.id,
        listName: 'doctorScheduleList',
        ref: state._expenseType,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(DoctorScheduleUpdateForm);
  };

  buildRouters = () => {
    const { ExpenseTypeDashboard } = GlobalComponents;
    const { ExpenseTypePreference } = GlobalComponents;

    const routers = [
      { path: '/expenseType/:id/dashboard', component: ExpenseTypeDashboard },
      { path: '/expenseType/:id/preference', component: ExpenseTypePreference },

      { path: '/expenseType/:id/list/expenseItemList', component: this.getExpenseItemSearch() },
      {
        path: '/expenseType/:id/list/expenseItemCreateForm',
        component: this.getExpenseItemCreateForm(),
      },
      {
        path: '/expenseType/:id/list/expenseItemUpdateForm',
        component: this.getExpenseItemUpdateForm(),
      },

      {
        path: '/expenseType/:id/list/doctorScheduleList',
        component: this.getDoctorScheduleSearch(),
      },
      {
        path: '/expenseType/:id/list/doctorScheduleCreateForm',
        component: this.getDoctorScheduleCreateForm(),
      },
      {
        path: '/expenseType/:id/list/doctorScheduleUpdateForm',
        component: this.getDoctorScheduleUpdateForm(),
      },
    ];

    const { extraRoutesFunc } = this.props;
    const extraRoutes = extraRoutesFunc ? extraRoutesFunc() : [];
    const finalRoutes = routers.concat(extraRoutes);

    return (
      <Switch>
        {finalRoutes.map(item => (
          <Route key={item.path} path={item.path} component={item.component} />
        ))}
      </Switch>
    );
  };

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '医生排班系统';
    return title;
  };

  handleOpenChange = openKeys => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1);
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    });
  };
  toggle = () => {
    const { collapsed } = this.props;
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: !collapsed,
    });
  };
  logout = () => {
    console.log('log out called');
    this.props.dispatch({ type: 'launcher/signOut' });
  };
  render() {
    // const { collapsed, fetchingNotices,loading } = this.props
    const { collapsed } = this.props;
    const { breadcrumb } = this.props;

    const targetApp = sessionObject('targetApp');
    const currentBreadcrumb = sessionObject(targetApp.id);
    const userContext = null;
    const renderBreadcrumbText = value => {
      if (value == null) {
        return '...';
      }
      if (value.length < 10) {
        return value;
      }

      return value.substring(0, 10) + '...';
    };
    const menuProps = collapsed
      ? {}
      : {
          openKeys: this.state.openKeys,
        };
    const layout = (
      <Layout>
        <Header>
          <div className={styles.left}>
            <img src="./favicon.png" alt="logo" onClick={this.toggle} className={styles.logo} />
            <Link key={'__home'} to={'/home'} className={styles.breadcrumbLink}>
              <Icon type="home" />&nbsp;{appLocaleName(userContext, 'Home')}
            </Link>
            {currentBreadcrumb.map(item => {
              return (
                <Link key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}>
                  <Icon type="caret-right" />
                  {renderBreadcrumbText(item.name)}
                </Link>
              );
            })}
          </div>
          <div className={styles.right}>
            <Button type="primary" icon="logout" onClick={() => this.logout()}>
              {appLocaleName(userContext, 'Exit')}
            </Button>
          </div>
        </Header>
        <Layout>
          <Sider
            trigger={null}
            collapsible
            collapsed={collapsed}
            breakpoint="md"
            onCollapse={() => this.onCollapse(collapsed)}
            collapsedWidth={56}
            className={styles.sider}
          >
            {this.getNavMenuItems(this.props.expenseType)}
          </Sider>
          <Layout>
            <Content style={{ margin: '24px 24px 0', height: '100%' }}>
              {this.buildRouters()}
            </Content>
          </Layout>
        </Layout>
      </Layout>
    );
    return (
      <DocumentTitle title={this.getPageTitle()}>
        <ContainerQuery query={query}>
          {params => <div className={classNames(params)}>{layout}</div>}
        </ContainerQuery>
      </DocumentTitle>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  expenseType: state._expenseType,
  ...state,
}))(ExpenseTypeBizApp);
