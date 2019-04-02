import React from 'react'
import PropTypes from 'prop-types'
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
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Department.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem



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
}




class DepartmentBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/department/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/department/${this.props.department.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg`} title={<span><Icon type="folder" /><span>{``}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		<SubMenu key="sub4" title={<span><Icon type="setting" /><span>{appLocaleName(userContext,"Setting")}</span></span>} >
       			<Menu.Item key="profile">
               		<Link to={`/department/${this.props.department.id}/permission`}><Icon type="safety" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/department/${this.props.department.id}/profile`}><Icon type="profile" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getDoctorAssignmentSearch = () => {
    const {DoctorAssignmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "医生的任务",
      role: "doctorAssignment",
      data: state._department.doctorAssignmentList,
      metaInfo: state._department.doctorAssignmentListMetaInfo,
      count: state._department.doctorAssignmentCount,
      currentPage: state._department.doctorAssignmentCurrentPageNumber,
      searchFormParameters: state._department.doctorAssignmentSearchFormParameters,
      searchParameters: {...state._department.searchParameters},
      expandForm: state._department.expandForm,
      loading: state._department.loading,
      partialList: state._department.partialList,
      owner: { type: '_department', id: state._department.id, 
      referenceName: 'department', 
      listName: 'doctorAssignmentList', ref:state._department, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorAssignmentSearch)
  }
  getDoctorAssignmentCreateForm = () => {
   	const {DoctorAssignmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "doctorAssignment",
      data: state._department.doctorAssignmentList,
      metaInfo: state._department.doctorAssignmentListMetaInfo,
      count: state._department.doctorAssignmentCount,
      currentPage: state._department.doctorAssignmentCurrentPageNumber,
      searchFormParameters: state._department.doctorAssignmentSearchFormParameters,
      loading: state._department.loading,
      owner: { type: '_department', id: state._department.id, referenceName: 'department', listName: 'doctorAssignmentList', ref:state._department, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(DoctorAssignmentCreateForm)
  }
  
  getDoctorAssignmentUpdateForm = () => {
    const userContext = null
  	const {DoctorAssignmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._department.selectedRows,
      role: "doctorAssignment",
      currentUpdateIndex: state._department.currentUpdateIndex,
      owner: { type: '_department', id: state._department.id, listName: 'doctorAssignmentList', ref:state._department, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorAssignmentUpdateForm)
  }

  getDoctorScheduleSearch = () => {
    const {DoctorScheduleSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "医生安排",
      role: "doctorSchedule",
      data: state._department.doctorScheduleList,
      metaInfo: state._department.doctorScheduleListMetaInfo,
      count: state._department.doctorScheduleCount,
      currentPage: state._department.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._department.doctorScheduleSearchFormParameters,
      searchParameters: {...state._department.searchParameters},
      expandForm: state._department.expandForm,
      loading: state._department.loading,
      partialList: state._department.partialList,
      owner: { type: '_department', id: state._department.id, 
      referenceName: 'department', 
      listName: 'doctorScheduleList', ref:state._department, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorScheduleSearch)
  }
  getDoctorScheduleCreateForm = () => {
   	const {DoctorScheduleCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "doctorSchedule",
      data: state._department.doctorScheduleList,
      metaInfo: state._department.doctorScheduleListMetaInfo,
      count: state._department.doctorScheduleCount,
      currentPage: state._department.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._department.doctorScheduleSearchFormParameters,
      loading: state._department.loading,
      owner: { type: '_department', id: state._department.id, referenceName: 'department', listName: 'doctorScheduleList', ref:state._department, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(DoctorScheduleCreateForm)
  }
  
  getDoctorScheduleUpdateForm = () => {
    const userContext = null
  	const {DoctorScheduleUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._department.selectedRows,
      role: "doctorSchedule",
      currentUpdateIndex: state._department.currentUpdateIndex,
      owner: { type: '_department', id: state._department.id, listName: 'doctorScheduleList', ref:state._department, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorScheduleUpdateForm)
  }


  
  buildRouters = () =>{
  	const {DepartmentDashboard} = GlobalComponents
  	const {DepartmentPermission} = GlobalComponents
  	const {DepartmentProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/department/:id/dashboard", component: DepartmentDashboard},
  	{path:"/department/:id/profile", component: DepartmentProfile},
  	{path:"/department/:id/permission", component: DepartmentPermission},
  	
  	
  	
  	{path:"/department/:id/list/doctorAssignmentList", component: this.getDoctorAssignmentSearch()},
  	{path:"/department/:id/list/doctorAssignmentCreateForm", component: this.getDoctorAssignmentCreateForm()},
  	{path:"/department/:id/list/doctorAssignmentUpdateForm", component: this.getDoctorAssignmentUpdateForm()},
   	
  	{path:"/department/:id/list/doctorScheduleList", component: this.getDoctorScheduleSearch()},
  	{path:"/department/:id/list/doctorScheduleCreateForm", component: this.getDoctorScheduleCreateForm()},
  	{path:"/department/:id/list/doctorScheduleUpdateForm", component: this.getDoctorScheduleUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '医生排班系统'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          /><Link key={"__home"} to={"/home"} className={styles.breadcrumbLink}><Icon type="home" />&nbsp;{appLocaleName(userContext,"Home")}</Link>
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}><Icon type="caret-right" />{renderBreadcrumbText(item.name)}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.department)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  department: state._department,
  ...state,
}))(DepartmentBizApp)



