



import HospitalBase from './hospital/Hospital.base';
import HospitalBizApp from './hospital/Hospital.app';
import HospitalModel from './hospital/Hospital.model';
import HospitalDashboard from './hospital/Hospital.dashboard';
import HospitalPreference from './hospital/Hospital.preference';
import HospitalModalTable from './hospital/Hospital.modaltable';
import HospitalSearch from './hospital/Hospital.search';
import HospitalSearchForm from './hospital/Hospital.searchform';
import HospitalCreateForm from './hospital/Hospital.createform';
import HospitalAssociateForm from './hospital/Hospital.associateform';
import HospitalTable from './hospital/Hospital.table';
import HospitalService from './hospital/Hospital.service';
import HospitalUpdateForm from './hospital/Hospital.updateform';
import ExpenseTypeBase from './expensetype/ExpenseType.base';
import ExpenseTypeBizApp from './expensetype/ExpenseType.app';
import ExpenseTypeModel from './expensetype/ExpenseType.model';
import ExpenseTypeDashboard from './expensetype/ExpenseType.dashboard';
import ExpenseTypePreference from './expensetype/ExpenseType.preference';
import ExpenseTypeModalTable from './expensetype/ExpenseType.modaltable';
import ExpenseTypeSearch from './expensetype/ExpenseType.search';
import ExpenseTypeSearchForm from './expensetype/ExpenseType.searchform';
import ExpenseTypeCreateForm from './expensetype/ExpenseType.createform';
import ExpenseTypeAssociateForm from './expensetype/ExpenseType.associateform';
import ExpenseTypeTable from './expensetype/ExpenseType.table';
import ExpenseTypeService from './expensetype/ExpenseType.service';
import ExpenseTypeUpdateForm from './expensetype/ExpenseType.updateform';
import PeriodBase from './period/Period.base';
import PeriodBizApp from './period/Period.app';
import PeriodModel from './period/Period.model';
import PeriodDashboard from './period/Period.dashboard';
import PeriodPreference from './period/Period.preference';
import PeriodModalTable from './period/Period.modaltable';
import PeriodSearch from './period/Period.search';
import PeriodSearchForm from './period/Period.searchform';
import PeriodCreateForm from './period/Period.createform';
import PeriodAssociateForm from './period/Period.associateform';
import PeriodTable from './period/Period.table';
import PeriodService from './period/Period.service';
import PeriodUpdateForm from './period/Period.updateform';
import ExpenseItemBase from './expenseitem/ExpenseItem.base';
import ExpenseItemBizApp from './expenseitem/ExpenseItem.app';
import ExpenseItemModel from './expenseitem/ExpenseItem.model';
import ExpenseItemDashboard from './expenseitem/ExpenseItem.dashboard';
import ExpenseItemPreference from './expenseitem/ExpenseItem.preference';
import ExpenseItemModalTable from './expenseitem/ExpenseItem.modaltable';
import ExpenseItemSearch from './expenseitem/ExpenseItem.search';
import ExpenseItemSearchForm from './expenseitem/ExpenseItem.searchform';
import ExpenseItemCreateForm from './expenseitem/ExpenseItem.createform';
import ExpenseItemAssociateForm from './expenseitem/ExpenseItem.associateform';
import ExpenseItemTable from './expenseitem/ExpenseItem.table';
import ExpenseItemService from './expenseitem/ExpenseItem.service';
import ExpenseItemUpdateForm from './expenseitem/ExpenseItem.updateform';
import DoctorBase from './doctor/Doctor.base';
import DoctorBizApp from './doctor/Doctor.app';
import DoctorModel from './doctor/Doctor.model';
import DoctorDashboard from './doctor/Doctor.dashboard';
import DoctorPreference from './doctor/Doctor.preference';
import DoctorModalTable from './doctor/Doctor.modaltable';
import DoctorSearch from './doctor/Doctor.search';
import DoctorSearchForm from './doctor/Doctor.searchform';
import DoctorCreateForm from './doctor/Doctor.createform';
import DoctorAssociateForm from './doctor/Doctor.associateform';
import DoctorTable from './doctor/Doctor.table';
import DoctorService from './doctor/Doctor.service';
import DoctorUpdateForm from './doctor/Doctor.updateform';
import DepartmentBase from './department/Department.base';
import DepartmentBizApp from './department/Department.app';
import DepartmentModel from './department/Department.model';
import DepartmentDashboard from './department/Department.dashboard';
import DepartmentPreference from './department/Department.preference';
import DepartmentModalTable from './department/Department.modaltable';
import DepartmentSearch from './department/Department.search';
import DepartmentSearchForm from './department/Department.searchform';
import DepartmentCreateForm from './department/Department.createform';
import DepartmentAssociateForm from './department/Department.associateform';
import DepartmentTable from './department/Department.table';
import DepartmentService from './department/Department.service';
import DepartmentUpdateForm from './department/Department.updateform';
import DoctorAssignmentBase from './doctorassignment/DoctorAssignment.base';
import DoctorAssignmentBizApp from './doctorassignment/DoctorAssignment.app';
import DoctorAssignmentModel from './doctorassignment/DoctorAssignment.model';
import DoctorAssignmentDashboard from './doctorassignment/DoctorAssignment.dashboard';
import DoctorAssignmentPreference from './doctorassignment/DoctorAssignment.preference';
import DoctorAssignmentModalTable from './doctorassignment/DoctorAssignment.modaltable';
import DoctorAssignmentSearch from './doctorassignment/DoctorAssignment.search';
import DoctorAssignmentSearchForm from './doctorassignment/DoctorAssignment.searchform';
import DoctorAssignmentCreateForm from './doctorassignment/DoctorAssignment.createform';
import DoctorAssignmentAssociateForm from './doctorassignment/DoctorAssignment.associateform';
import DoctorAssignmentTable from './doctorassignment/DoctorAssignment.table';
import DoctorAssignmentService from './doctorassignment/DoctorAssignment.service';
import DoctorAssignmentUpdateForm from './doctorassignment/DoctorAssignment.updateform';
import DoctorScheduleBase from './doctorschedule/DoctorSchedule.base';
import DoctorScheduleBizApp from './doctorschedule/DoctorSchedule.app';
import DoctorScheduleModel from './doctorschedule/DoctorSchedule.model';
import DoctorScheduleDashboard from './doctorschedule/DoctorSchedule.dashboard';
import DoctorSchedulePreference from './doctorschedule/DoctorSchedule.preference';
import DoctorScheduleModalTable from './doctorschedule/DoctorSchedule.modaltable';
import DoctorScheduleSearch from './doctorschedule/DoctorSchedule.search';
import DoctorScheduleSearchForm from './doctorschedule/DoctorSchedule.searchform';
import DoctorScheduleCreateForm from './doctorschedule/DoctorSchedule.createform';
import DoctorScheduleAssociateForm from './doctorschedule/DoctorSchedule.associateform';
import DoctorScheduleTable from './doctorschedule/DoctorSchedule.table';
import DoctorScheduleService from './doctorschedule/DoctorSchedule.service';
import DoctorScheduleUpdateForm from './doctorschedule/DoctorSchedule.updateform';
import UserDomainBase from './userdomain/UserDomain.base';
import UserDomainBizApp from './userdomain/UserDomain.app';
import UserDomainModel from './userdomain/UserDomain.model';
import UserDomainDashboard from './userdomain/UserDomain.dashboard';
import UserDomainPreference from './userdomain/UserDomain.preference';
import UserDomainModalTable from './userdomain/UserDomain.modaltable';
import UserDomainSearch from './userdomain/UserDomain.search';
import UserDomainSearchForm from './userdomain/UserDomain.searchform';
import UserDomainCreateForm from './userdomain/UserDomain.createform';
import UserDomainAssociateForm from './userdomain/UserDomain.associateform';
import UserDomainTable from './userdomain/UserDomain.table';
import UserDomainService from './userdomain/UserDomain.service';
import UserDomainUpdateForm from './userdomain/UserDomain.updateform';
import UserWhiteListBase from './userwhitelist/UserWhiteList.base';
import UserWhiteListBizApp from './userwhitelist/UserWhiteList.app';
import UserWhiteListModel from './userwhitelist/UserWhiteList.model';
import UserWhiteListDashboard from './userwhitelist/UserWhiteList.dashboard';
import UserWhiteListPreference from './userwhitelist/UserWhiteList.preference';
import UserWhiteListModalTable from './userwhitelist/UserWhiteList.modaltable';
import UserWhiteListSearch from './userwhitelist/UserWhiteList.search';
import UserWhiteListSearchForm from './userwhitelist/UserWhiteList.searchform';
import UserWhiteListCreateForm from './userwhitelist/UserWhiteList.createform';
import UserWhiteListAssociateForm from './userwhitelist/UserWhiteList.associateform';
import UserWhiteListTable from './userwhitelist/UserWhiteList.table';
import UserWhiteListService from './userwhitelist/UserWhiteList.service';
import UserWhiteListUpdateForm from './userwhitelist/UserWhiteList.updateform';
import SecUserBase from './secuser/SecUser.base';
import SecUserBizApp from './secuser/SecUser.app';
import SecUserModel from './secuser/SecUser.model';
import SecUserDashboard from './secuser/SecUser.dashboard';
import SecUserPreference from './secuser/SecUser.preference';
import SecUserModalTable from './secuser/SecUser.modaltable';
import SecUserSearch from './secuser/SecUser.search';
import SecUserSearchForm from './secuser/SecUser.searchform';
import SecUserCreateForm from './secuser/SecUser.createform';
import SecUserAssociateForm from './secuser/SecUser.associateform';
import SecUserTable from './secuser/SecUser.table';
import SecUserService from './secuser/SecUser.service';
import SecUserUpdateForm from './secuser/SecUser.updateform';
import SecUserBlockingBase from './secuserblocking/SecUserBlocking.base';
import SecUserBlockingBizApp from './secuserblocking/SecUserBlocking.app';
import SecUserBlockingModel from './secuserblocking/SecUserBlocking.model';
import SecUserBlockingDashboard from './secuserblocking/SecUserBlocking.dashboard';
import SecUserBlockingPreference from './secuserblocking/SecUserBlocking.preference';
import SecUserBlockingModalTable from './secuserblocking/SecUserBlocking.modaltable';
import SecUserBlockingSearch from './secuserblocking/SecUserBlocking.search';
import SecUserBlockingSearchForm from './secuserblocking/SecUserBlocking.searchform';
import SecUserBlockingCreateForm from './secuserblocking/SecUserBlocking.createform';
import SecUserBlockingAssociateForm from './secuserblocking/SecUserBlocking.associateform';
import SecUserBlockingTable from './secuserblocking/SecUserBlocking.table';
import SecUserBlockingService from './secuserblocking/SecUserBlocking.service';
import SecUserBlockingUpdateForm from './secuserblocking/SecUserBlocking.updateform';
import UserAppBase from './userapp/UserApp.base';
import UserAppBizApp from './userapp/UserApp.app';
import UserAppModel from './userapp/UserApp.model';
import UserAppDashboard from './userapp/UserApp.dashboard';
import UserAppPreference from './userapp/UserApp.preference';
import UserAppModalTable from './userapp/UserApp.modaltable';
import UserAppSearch from './userapp/UserApp.search';
import UserAppSearchForm from './userapp/UserApp.searchform';
import UserAppCreateForm from './userapp/UserApp.createform';
import UserAppAssociateForm from './userapp/UserApp.associateform';
import UserAppTable from './userapp/UserApp.table';
import UserAppService from './userapp/UserApp.service';
import UserAppUpdateForm from './userapp/UserApp.updateform';
import ListAccessBase from './listaccess/ListAccess.base';
import ListAccessBizApp from './listaccess/ListAccess.app';
import ListAccessModel from './listaccess/ListAccess.model';
import ListAccessDashboard from './listaccess/ListAccess.dashboard';
import ListAccessPreference from './listaccess/ListAccess.preference';
import ListAccessModalTable from './listaccess/ListAccess.modaltable';
import ListAccessSearch from './listaccess/ListAccess.search';
import ListAccessSearchForm from './listaccess/ListAccess.searchform';
import ListAccessCreateForm from './listaccess/ListAccess.createform';
import ListAccessAssociateForm from './listaccess/ListAccess.associateform';
import ListAccessTable from './listaccess/ListAccess.table';
import ListAccessService from './listaccess/ListAccess.service';
import ListAccessUpdateForm from './listaccess/ListAccess.updateform';
import ObjectAccessBase from './objectaccess/ObjectAccess.base';
import ObjectAccessBizApp from './objectaccess/ObjectAccess.app';
import ObjectAccessModel from './objectaccess/ObjectAccess.model';
import ObjectAccessDashboard from './objectaccess/ObjectAccess.dashboard';
import ObjectAccessPreference from './objectaccess/ObjectAccess.preference';
import ObjectAccessModalTable from './objectaccess/ObjectAccess.modaltable';
import ObjectAccessSearch from './objectaccess/ObjectAccess.search';
import ObjectAccessSearchForm from './objectaccess/ObjectAccess.searchform';
import ObjectAccessCreateForm from './objectaccess/ObjectAccess.createform';
import ObjectAccessAssociateForm from './objectaccess/ObjectAccess.associateform';
import ObjectAccessTable from './objectaccess/ObjectAccess.table';
import ObjectAccessService from './objectaccess/ObjectAccess.service';
import ObjectAccessUpdateForm from './objectaccess/ObjectAccess.updateform';
import LoginHistoryBase from './loginhistory/LoginHistory.base';
import LoginHistoryBizApp from './loginhistory/LoginHistory.app';
import LoginHistoryModel from './loginhistory/LoginHistory.model';
import LoginHistoryDashboard from './loginhistory/LoginHistory.dashboard';
import LoginHistoryPreference from './loginhistory/LoginHistory.preference';
import LoginHistoryModalTable from './loginhistory/LoginHistory.modaltable';
import LoginHistorySearch from './loginhistory/LoginHistory.search';
import LoginHistorySearchForm from './loginhistory/LoginHistory.searchform';
import LoginHistoryCreateForm from './loginhistory/LoginHistory.createform';
import LoginHistoryAssociateForm from './loginhistory/LoginHistory.associateform';
import LoginHistoryTable from './loginhistory/LoginHistory.table';
import LoginHistoryService from './loginhistory/LoginHistory.service';
import LoginHistoryUpdateForm from './loginhistory/LoginHistory.updateform';


const BizModels = [
	HospitalModel,
	ExpenseTypeModel,
	PeriodModel,
	ExpenseItemModel,
	DoctorModel,
	DepartmentModel,
	DoctorAssignmentModel,
	DoctorScheduleModel,
	UserDomainModel,
	UserWhiteListModel,
	SecUserModel,
	SecUserBlockingModel,
	UserAppModel,
	ListAccessModel,
	ObjectAccessModel,
	LoginHistoryModel,

]


const bindBizModels = (app) =>{

	BizModels.map((model)=>app.model(model))

}
const unbindBizModels = (app) =>{

	BizModels.map((model)=>app.unmodel(model))

}

const menuLibrary = []

menuLibrary['hospital'] = HospitalBase.menuData
menuLibrary['expenseType'] = ExpenseTypeBase.menuData
menuLibrary['period'] = PeriodBase.menuData
menuLibrary['expenseItem'] = ExpenseItemBase.menuData
menuLibrary['doctor'] = DoctorBase.menuData
menuLibrary['department'] = DepartmentBase.menuData
menuLibrary['doctorAssignment'] = DoctorAssignmentBase.menuData
menuLibrary['doctorSchedule'] = DoctorScheduleBase.menuData
menuLibrary['userDomain'] = UserDomainBase.menuData
menuLibrary['userWhiteList'] = UserWhiteListBase.menuData
menuLibrary['secUser'] = SecUserBase.menuData
menuLibrary['secUserBlocking'] = SecUserBlockingBase.menuData
menuLibrary['userApp'] = UserAppBase.menuData
menuLibrary['listAccess'] = ListAccessBase.menuData
menuLibrary['objectAccess'] = ObjectAccessBase.menuData
menuLibrary['loginHistory'] = LoginHistoryBase.menuData


const menuDataOf=(type)=>{
	
	const menu = menuLibrary[type]
	
	if(menu){
		return menu;
	}
	console.error(`Not able to find corresponding menu for ${type}`);

	return null;

}



const ViewMapping = {


  'com.doublechaintech.his.hospital.Hospital': {name:'hospital'},
  'com.doublechaintech.his.expensetype.ExpenseType': {name:'expenseType'},
  'com.doublechaintech.his.period.Period': {name:'period'},
  'com.doublechaintech.his.expenseitem.ExpenseItem': {name:'expenseItem'},
  'com.doublechaintech.his.doctor.Doctor': {name:'doctor'},
  'com.doublechaintech.his.department.Department': {name:'department'},
  'com.doublechaintech.his.doctorassignment.DoctorAssignment': {name:'doctorAssignment'},
  'com.doublechaintech.his.doctorschedule.DoctorSchedule': {name:'doctorSchedule'},
  'com.doublechaintech.his.userdomain.UserDomain': {name:'userDomain'},
  'com.doublechaintech.his.userwhitelist.UserWhiteList': {name:'userWhiteList'},
  'com.doublechaintech.his.secuser.SecUser': {name:'secUser'},
  'com.doublechaintech.his.secuserblocking.SecUserBlocking': {name:'secUserBlocking'},
  'com.doublechaintech.his.userapp.UserApp': {name:'userApp'},
  'com.doublechaintech.his.listaccess.ListAccess': {name:'listAccess'},
  'com.doublechaintech.his.objectaccess.ObjectAccess': {name:'objectAccess'},
  'com.doublechaintech.his.loginhistory.LoginHistory': {name:'loginHistory'},

}



// eslint-disable-next-line no-unused-vars
const presentApp = (clazz, data) => {
  // console.log(data)
}


const calcLocationPath = (clazz,id,subLocation) => {

  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
  	return 'home'
  }
  const {name} = location;
  if(!name){
  	return '/home'
  }
  if (name) {
    return `${name}/${id}/${subLocation}`
  }
  return '/home'
}


const calcMenuData=(clazz) => {
  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
    return {};
  }
  const {name} = location;
  //const { menuDataOf } = GlobalComponents
  return menuDataOf(name)
}

// console.log("element", )



const OOTBComponents={
    HospitalBase,
    HospitalBizApp,
    HospitalModel,
    HospitalDashboard,
    HospitalPreference,
    HospitalModalTable,
    HospitalSearch,
    HospitalSearchForm,
    HospitalCreateForm,
    HospitalAssociateForm,
    HospitalTable,
    HospitalService,
    HospitalUpdateForm,
    ExpenseTypeBase,
    ExpenseTypeBizApp,
    ExpenseTypeModel,
    ExpenseTypeDashboard,
    ExpenseTypePreference,
    ExpenseTypeModalTable,
    ExpenseTypeSearch,
    ExpenseTypeSearchForm,
    ExpenseTypeCreateForm,
    ExpenseTypeAssociateForm,
    ExpenseTypeTable,
    ExpenseTypeService,
    ExpenseTypeUpdateForm,
    PeriodBase,
    PeriodBizApp,
    PeriodModel,
    PeriodDashboard,
    PeriodPreference,
    PeriodModalTable,
    PeriodSearch,
    PeriodSearchForm,
    PeriodCreateForm,
    PeriodAssociateForm,
    PeriodTable,
    PeriodService,
    PeriodUpdateForm,
    ExpenseItemBase,
    ExpenseItemBizApp,
    ExpenseItemModel,
    ExpenseItemDashboard,
    ExpenseItemPreference,
    ExpenseItemModalTable,
    ExpenseItemSearch,
    ExpenseItemSearchForm,
    ExpenseItemCreateForm,
    ExpenseItemAssociateForm,
    ExpenseItemTable,
    ExpenseItemService,
    ExpenseItemUpdateForm,
    DoctorBase,
    DoctorBizApp,
    DoctorModel,
    DoctorDashboard,
    DoctorPreference,
    DoctorModalTable,
    DoctorSearch,
    DoctorSearchForm,
    DoctorCreateForm,
    DoctorAssociateForm,
    DoctorTable,
    DoctorService,
    DoctorUpdateForm,
    DepartmentBase,
    DepartmentBizApp,
    DepartmentModel,
    DepartmentDashboard,
    DepartmentPreference,
    DepartmentModalTable,
    DepartmentSearch,
    DepartmentSearchForm,
    DepartmentCreateForm,
    DepartmentAssociateForm,
    DepartmentTable,
    DepartmentService,
    DepartmentUpdateForm,
    DoctorAssignmentBase,
    DoctorAssignmentBizApp,
    DoctorAssignmentModel,
    DoctorAssignmentDashboard,
    DoctorAssignmentPreference,
    DoctorAssignmentModalTable,
    DoctorAssignmentSearch,
    DoctorAssignmentSearchForm,
    DoctorAssignmentCreateForm,
    DoctorAssignmentAssociateForm,
    DoctorAssignmentTable,
    DoctorAssignmentService,
    DoctorAssignmentUpdateForm,
    DoctorScheduleBase,
    DoctorScheduleBizApp,
    DoctorScheduleModel,
    DoctorScheduleDashboard,
    DoctorSchedulePreference,
    DoctorScheduleModalTable,
    DoctorScheduleSearch,
    DoctorScheduleSearchForm,
    DoctorScheduleCreateForm,
    DoctorScheduleAssociateForm,
    DoctorScheduleTable,
    DoctorScheduleService,
    DoctorScheduleUpdateForm,
    UserDomainBase,
    UserDomainBizApp,
    UserDomainModel,
    UserDomainDashboard,
    UserDomainPreference,
    UserDomainModalTable,
    UserDomainSearch,
    UserDomainSearchForm,
    UserDomainCreateForm,
    UserDomainAssociateForm,
    UserDomainTable,
    UserDomainService,
    UserDomainUpdateForm,
    UserWhiteListBase,
    UserWhiteListBizApp,
    UserWhiteListModel,
    UserWhiteListDashboard,
    UserWhiteListPreference,
    UserWhiteListModalTable,
    UserWhiteListSearch,
    UserWhiteListSearchForm,
    UserWhiteListCreateForm,
    UserWhiteListAssociateForm,
    UserWhiteListTable,
    UserWhiteListService,
    UserWhiteListUpdateForm,
    SecUserBase,
    SecUserBizApp,
    SecUserModel,
    SecUserDashboard,
    SecUserPreference,
    SecUserModalTable,
    SecUserSearch,
    SecUserSearchForm,
    SecUserCreateForm,
    SecUserAssociateForm,
    SecUserTable,
    SecUserService,
    SecUserUpdateForm,
    SecUserBlockingBase,
    SecUserBlockingBizApp,
    SecUserBlockingModel,
    SecUserBlockingDashboard,
    SecUserBlockingPreference,
    SecUserBlockingModalTable,
    SecUserBlockingSearch,
    SecUserBlockingSearchForm,
    SecUserBlockingCreateForm,
    SecUserBlockingAssociateForm,
    SecUserBlockingTable,
    SecUserBlockingService,
    SecUserBlockingUpdateForm,
    UserAppBase,
    UserAppBizApp,
    UserAppModel,
    UserAppDashboard,
    UserAppPreference,
    UserAppModalTable,
    UserAppSearch,
    UserAppSearchForm,
    UserAppCreateForm,
    UserAppAssociateForm,
    UserAppTable,
    UserAppService,
    UserAppUpdateForm,
    ListAccessBase,
    ListAccessBizApp,
    ListAccessModel,
    ListAccessDashboard,
    ListAccessPreference,
    ListAccessModalTable,
    ListAccessSearch,
    ListAccessSearchForm,
    ListAccessCreateForm,
    ListAccessAssociateForm,
    ListAccessTable,
    ListAccessService,
    ListAccessUpdateForm,
    ObjectAccessBase,
    ObjectAccessBizApp,
    ObjectAccessModel,
    ObjectAccessDashboard,
    ObjectAccessPreference,
    ObjectAccessModalTable,
    ObjectAccessSearch,
    ObjectAccessSearchForm,
    ObjectAccessCreateForm,
    ObjectAccessAssociateForm,
    ObjectAccessTable,
    ObjectAccessService,
    ObjectAccessUpdateForm,
    LoginHistoryBase,
    LoginHistoryBizApp,
    LoginHistoryModel,
    LoginHistoryDashboard,
    LoginHistoryPreference,
    LoginHistoryModalTable,
    LoginHistorySearch,
    LoginHistorySearchForm,
    LoginHistoryCreateForm,
    LoginHistoryAssociateForm,
    LoginHistoryTable,
    LoginHistoryService,
    LoginHistoryUpdateForm,
    menuDataOf,bindBizModels,unbindBizModels,calcLocationPath,calcMenuData
};
       


export default OOTBComponents;







