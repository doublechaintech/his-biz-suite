

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { ConfigProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {HospitalBizApp} = GlobalComponents
	const {ExpenseTypeBizApp} = GlobalComponents
	const {PeriodBizApp} = GlobalComponents
	const {ExpenseItemBizApp} = GlobalComponents
	const {DoctorBizApp} = GlobalComponents
	const {DepartmentBizApp} = GlobalComponents
	const {DoctorAssignmentBizApp} = GlobalComponents
	const {DoctorScheduleBizApp} = GlobalComponents
	const {MobileAppBizApp} = GlobalComponents
	const {PageBizApp} = GlobalComponents
	const {PageTypeBizApp} = GlobalComponents
	const {SlideBizApp} = GlobalComponents
	const {UiActionBizApp} = GlobalComponents
	const {SectionBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {QuickLinkBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents
	const {GenericFormBizApp} = GlobalComponents
	const {FormMessageBizApp} = GlobalComponents
	const {FormFieldMessageBizApp} = GlobalComponents
	const {FormFieldBizApp} = GlobalComponents
	const {FormActionBizApp} = GlobalComponents
	const {CandidateContainerBizApp} = GlobalComponents
	const {CandidateElementBizApp} = GlobalComponents
	const {WechatWorkappIdentifyBizApp} = GlobalComponents
	const {WechatMiniappIdentifyBizApp} = GlobalComponents
	const {TreeNodeBizApp} = GlobalComponents



  return (
    <ConfigProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
          <Route path="/home" component={Launcher} />
          <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/hospital/" component={HospitalBizApp} />
          <Route path="/expenseType/" component={ExpenseTypeBizApp} />
          <Route path="/period/" component={PeriodBizApp} />
          <Route path="/expenseItem/" component={ExpenseItemBizApp} />
          <Route path="/doctor/" component={DoctorBizApp} />
          <Route path="/department/" component={DepartmentBizApp} />
          <Route path="/doctorAssignment/" component={DoctorAssignmentBizApp} />
          <Route path="/doctorSchedule/" component={DoctorScheduleBizApp} />
          <Route path="/mobileApp/" component={MobileAppBizApp} />
          <Route path="/page/" component={PageBizApp} />
          <Route path="/pageType/" component={PageTypeBizApp} />
          <Route path="/slide/" component={SlideBizApp} />
          <Route path="/uiAction/" component={UiActionBizApp} />
          <Route path="/section/" component={SectionBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/quickLink/" component={QuickLinkBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
          <Route path="/genericForm/" component={GenericFormBizApp} />
          <Route path="/formMessage/" component={FormMessageBizApp} />
          <Route path="/formFieldMessage/" component={FormFieldMessageBizApp} />
          <Route path="/formField/" component={FormFieldBizApp} />
          <Route path="/formAction/" component={FormActionBizApp} />
          <Route path="/candidateContainer/" component={CandidateContainerBizApp} />
          <Route path="/candidateElement/" component={CandidateElementBizApp} />
          <Route path="/wechatWorkappIdentify/" component={WechatWorkappIdentifyBizApp} />
          <Route path="/wechatMiniappIdentify/" component={WechatMiniappIdentifyBizApp} />
          <Route path="/treeNode/" component={TreeNodeBizApp} />
          <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </ConfigProvider>
  )
}

export default RouterConfig










