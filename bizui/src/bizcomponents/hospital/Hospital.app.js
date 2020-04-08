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
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Hospital.app.less'
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

const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


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




class HospitalBizApp extends React.PureComponent {
constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
      showSearch: false,
      searchKeyword:''
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
      return ['/hospital/']
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
  
 getNavMenuItems = (targetObject, style, customTheme) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light" 
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/hospital/${this.props.hospital.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getExpenseTypeSearch = () => {
    const {ExpenseTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('expense_type','hospital.expense_type_list',false),
      role: "expenseType",
      data: state._hospital.expenseTypeList,
      metaInfo: state._hospital.expenseTypeListMetaInfo,
      count: state._hospital.expenseTypeCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.expenseTypeCurrentPageNumber,
      searchFormParameters: state._hospital.expenseTypeSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'expenseTypeList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExpenseTypeSearch)
  }
  
  getExpenseTypeCreateForm = () => {
   	const {ExpenseTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "expenseType",
      data: state._hospital.expenseTypeList,
      metaInfo: state._hospital.expenseTypeListMetaInfo,
      count: state._hospital.expenseTypeCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.expenseTypeCurrentPageNumber,
      searchFormParameters: state._hospital.expenseTypeSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'expenseTypeList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ExpenseTypeCreateForm)
  }
  
  getExpenseTypeUpdateForm = () => {
    const userContext = null
  	const {ExpenseTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "expenseType",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'expenseTypeList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExpenseTypeUpdateForm)
  }

  getPeriodSearch = () => {
    const {PeriodSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('period','hospital.period_list',false),
      role: "period",
      data: state._hospital.periodList,
      metaInfo: state._hospital.periodListMetaInfo,
      count: state._hospital.periodCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.periodCurrentPageNumber,
      searchFormParameters: state._hospital.periodSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'periodList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PeriodSearch)
  }
  
  getPeriodCreateForm = () => {
   	const {PeriodCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "period",
      data: state._hospital.periodList,
      metaInfo: state._hospital.periodListMetaInfo,
      count: state._hospital.periodCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.periodCurrentPageNumber,
      searchFormParameters: state._hospital.periodSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'periodList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PeriodCreateForm)
  }
  
  getPeriodUpdateForm = () => {
    const userContext = null
  	const {PeriodUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "period",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'periodList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PeriodUpdateForm)
  }

  getExpenseItemSearch = () => {
    const {ExpenseItemSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('expense_item','hospital.expense_item_list',false),
      role: "expenseItem",
      data: state._hospital.expenseItemList,
      metaInfo: state._hospital.expenseItemListMetaInfo,
      count: state._hospital.expenseItemCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.expenseItemCurrentPageNumber,
      searchFormParameters: state._hospital.expenseItemSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'expenseItemList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExpenseItemSearch)
  }
  
  getExpenseItemCreateForm = () => {
   	const {ExpenseItemCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "expenseItem",
      data: state._hospital.expenseItemList,
      metaInfo: state._hospital.expenseItemListMetaInfo,
      count: state._hospital.expenseItemCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.expenseItemCurrentPageNumber,
      searchFormParameters: state._hospital.expenseItemSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'expenseItemList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ExpenseItemCreateForm)
  }
  
  getExpenseItemUpdateForm = () => {
    const userContext = null
  	const {ExpenseItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "expenseItem",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'expenseItemList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExpenseItemUpdateForm)
  }

  getDoctorSearch = () => {
    const {DoctorSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('doctor','hospital.doctor_list',false),
      role: "doctor",
      data: state._hospital.doctorList,
      metaInfo: state._hospital.doctorListMetaInfo,
      count: state._hospital.doctorCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.doctorCurrentPageNumber,
      searchFormParameters: state._hospital.doctorSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'doctorList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorSearch)
  }
  
  getDoctorCreateForm = () => {
   	const {DoctorCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "doctor",
      data: state._hospital.doctorList,
      metaInfo: state._hospital.doctorListMetaInfo,
      count: state._hospital.doctorCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.doctorCurrentPageNumber,
      searchFormParameters: state._hospital.doctorSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'doctorList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(DoctorCreateForm)
  }
  
  getDoctorUpdateForm = () => {
    const userContext = null
  	const {DoctorUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "doctor",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'doctorList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorUpdateForm)
  }

  getDepartmentSearch = () => {
    const {DepartmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('department','hospital.department_list',false),
      role: "department",
      data: state._hospital.departmentList,
      metaInfo: state._hospital.departmentListMetaInfo,
      count: state._hospital.departmentCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.departmentCurrentPageNumber,
      searchFormParameters: state._hospital.departmentSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'departmentList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DepartmentSearch)
  }
  
  getDepartmentCreateForm = () => {
   	const {DepartmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "department",
      data: state._hospital.departmentList,
      metaInfo: state._hospital.departmentListMetaInfo,
      count: state._hospital.departmentCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.departmentCurrentPageNumber,
      searchFormParameters: state._hospital.departmentSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'departmentList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(DepartmentCreateForm)
  }
  
  getDepartmentUpdateForm = () => {
    const userContext = null
  	const {DepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "department",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'departmentList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DepartmentUpdateForm)
  }

  getDoctorScheduleSearch = () => {
    const {DoctorScheduleSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('doctor_schedule','hospital.doctor_schedule_list',false),
      role: "doctorSchedule",
      data: state._hospital.doctorScheduleList,
      metaInfo: state._hospital.doctorScheduleListMetaInfo,
      count: state._hospital.doctorScheduleCount,
      returnURL: `/hospital/${state._hospital.id}/dashboard`,
      currentPage: state._hospital.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._hospital.doctorScheduleSearchFormParameters,
      searchParameters: {...state._hospital.searchParameters},
      expandForm: state._hospital.expandForm,
      loading: state._hospital.loading,
      partialList: state._hospital.partialList,
      owner: { type: '_hospital', id: state._hospital.id, 
      referenceName: 'hospital', 
      listName: 'doctorScheduleList', ref:state._hospital, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorScheduleSearch)
  }
  
  getDoctorScheduleCreateForm = () => {
   	const {DoctorScheduleCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "doctorSchedule",
      data: state._hospital.doctorScheduleList,
      metaInfo: state._hospital.doctorScheduleListMetaInfo,
      count: state._hospital.doctorScheduleCount,
      returnURL: `/hospital/${state._hospital.id}/list`,
      currentPage: state._hospital.doctorScheduleCurrentPageNumber,
      searchFormParameters: state._hospital.doctorScheduleSearchFormParameters,
      loading: state._hospital.loading,
      owner: { type: '_hospital', id: state._hospital.id, referenceName: 'hospital', listName: 'doctorScheduleList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(DoctorScheduleCreateForm)
  }
  
  getDoctorScheduleUpdateForm = () => {
    const userContext = null
  	const {DoctorScheduleUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hospital.selectedRows,
      role: "doctorSchedule",
      currentUpdateIndex: state._hospital.currentUpdateIndex,
      owner: { type: '_hospital', id: state._hospital.id, listName: 'doctorScheduleList', ref:state._hospital, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(DoctorScheduleUpdateForm)
  }


  

 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '医生排班系统'
    return title
  }
 
  buildRouters = () =>{
  	const {HospitalDashboard} = GlobalComponents
  	const {HospitalPermission} = GlobalComponents
  	const {HospitalProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/hospital/:id/dashboard", component: HospitalDashboard},
  	{path:"/hospital/:id/profile", component: HospitalProfile},
  	{path:"/hospital/:id/permission", component: HospitalPermission},
  	
  	
  	
  	{path:"/hospital/:id/list/expenseTypeList", component: this.getExpenseTypeSearch()},
  	{path:"/hospital/:id/list/expenseTypeCreateForm", component: this.getExpenseTypeCreateForm()},
  	{path:"/hospital/:id/list/expenseTypeUpdateForm", component: this.getExpenseTypeUpdateForm()},
   	
  	{path:"/hospital/:id/list/periodList", component: this.getPeriodSearch()},
  	{path:"/hospital/:id/list/periodCreateForm", component: this.getPeriodCreateForm()},
  	{path:"/hospital/:id/list/periodUpdateForm", component: this.getPeriodUpdateForm()},
   	
  	{path:"/hospital/:id/list/expenseItemList", component: this.getExpenseItemSearch()},
  	{path:"/hospital/:id/list/expenseItemCreateForm", component: this.getExpenseItemCreateForm()},
  	{path:"/hospital/:id/list/expenseItemUpdateForm", component: this.getExpenseItemUpdateForm()},
   	
  	{path:"/hospital/:id/list/doctorList", component: this.getDoctorSearch()},
  	{path:"/hospital/:id/list/doctorCreateForm", component: this.getDoctorCreateForm()},
  	{path:"/hospital/:id/list/doctorUpdateForm", component: this.getDoctorUpdateForm()},
   	
  	{path:"/hospital/:id/list/departmentList", component: this.getDepartmentSearch()},
  	{path:"/hospital/:id/list/departmentCreateForm", component: this.getDepartmentCreateForm()},
  	{path:"/hospital/:id/list/departmentUpdateForm", component: this.getDepartmentUpdateForm()},
   	
  	{path:"/hospital/:id/list/doctorScheduleList", component: this.getDoctorScheduleSearch()},
  	{path:"/hospital/:id/list/doctorScheduleCreateForm", component: this.getDoctorScheduleCreateForm()},
  	{path:"/hospital/:id/list/doctorScheduleUpdateForm", component: this.getDoctorScheduleUpdateForm()},
     	
 	 
  	]
  	
  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
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
   
   toggleSwitchText=()=>{
    const { collapsed } = this.props
    if(collapsed){
      return "打开菜单"
    }
    return "关闭菜单"

   }
   
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
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
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const breadcrumbBar=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <div mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbBarItem(item))}
      </div>)
  

     }


	const jumpToBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {name,link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/jumpToLink', payload: {name, link }} )
	
     }  

	 const removeBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/removeLink', payload: { link }} )
	
     }

     const renderBreadcrumbBarItem=(breadcrumbMenuItem)=>{

      return (
     <Tag 
      	key={breadcrumbMenuItem.link} color={breadcrumbMenuItem.selected?"#108ee9":"grey"} 
      	style={{marginRight:"1px",marginBottom:"1px"}} closable onClose={()=>removeBreadcrumbLink(breadcrumbMenuItem)} >
        <span onClick={()=>jumpToBreadcrumbLink(breadcrumbMenuItem)}>
        	{renderBreadcrumbText(breadcrumbMenuItem.name)}
        </span>
      </Tag>)

     }
     
     
     
     const { Search } = Input;
     const showSearchResult=()=>{

        this.setState({showSearch:true})

     }
     const searchChange=(evt)=>{

      this.setState({searchKeyword :evt.target.value})

    }
    const hideSearchResult=()=>{

      this.setState({showSearch:false})

    }

    const {searchLocalData}=GlobalComponents.HospitalBase
	
    
     
     
     const layout = (
     <Layout>
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
             <a  className={styles.menuLink} onClick={()=>this.toggle()}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 
                {this.toggleSwitchText()}
              </a>          
            
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处" 
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
           	
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />  
            
            
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>
        
       
       <Layout>
      
      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.hospital,this.state.searchKeyword)}</div>

      )}
       </Layout>
        
         
         <Layout>
       <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          breakpoint="md"
          onCollapse={() => this.onCollapse(collapsed)}
          collapsedWidth={40}
          className={styles.sider}
        >
         
         {this.getNavMenuItems(this.props.hospital,"inline","dark")}
       
        </Sider>
        
         <Layout>
         <Layout><Row type="flex" justify="start" align="bottom">{breadcrumbBar()} </Row></Layout>
        
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
           </Content>
          </Layout>
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
  hospital: state._hospital,
  ...state,
}))(HospitalBizApp)



