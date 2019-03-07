



import PlatformBase from './platform/Platform.base';
import PlatformBizApp from './platform/Platform.app';
import PlatformModel from './platform/Platform.model';
import PlatformDashboard from './platform/Platform.dashboard';
import PlatformPreference from './platform/Platform.preference';
import PlatformModalTable from './platform/Platform.modaltable';
import PlatformSearch from './platform/Platform.search';
import PlatformSearchForm from './platform/Platform.searchform';
import PlatformCreateForm from './platform/Platform.createform';
import PlatformAssociateForm from './platform/Platform.associateform';
import PlatformTable from './platform/Platform.table';
import PlatformService from './platform/Platform.service';
import PlatformUpdateForm from './platform/Platform.updateform';
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
import ProfileBase from './profile/Profile.base';
import ProfileBizApp from './profile/Profile.app';
import ProfileModel from './profile/Profile.model';
import ProfileDashboard from './profile/Profile.dashboard';
import ProfilePreference from './profile/Profile.preference';
import ProfileModalTable from './profile/Profile.modaltable';
import ProfileSearch from './profile/Profile.search';
import ProfileSearchForm from './profile/Profile.searchform';
import ProfileCreateForm from './profile/Profile.createform';
import ProfileAssociateForm from './profile/Profile.associateform';
import ProfileTable from './profile/Profile.table';
import ProfileService from './profile/Profile.service';
import ProfileUpdateForm from './profile/Profile.updateform';
import RegistrationBase from './registration/Registration.base';
import RegistrationBizApp from './registration/Registration.app';
import RegistrationModel from './registration/Registration.model';
import RegistrationDashboard from './registration/Registration.dashboard';
import RegistrationPreference from './registration/Registration.preference';
import RegistrationModalTable from './registration/Registration.modaltable';
import RegistrationSearch from './registration/Registration.search';
import RegistrationSearchForm from './registration/Registration.searchform';
import RegistrationCreateForm from './registration/Registration.createform';
import RegistrationAssociateForm from './registration/Registration.associateform';
import RegistrationTable from './registration/Registration.table';
import RegistrationService from './registration/Registration.service';
import RegistrationUpdateForm from './registration/Registration.updateform';
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
	PlatformModel,
	DoctorModel,
	ProfileModel,
	RegistrationModel,
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

menuLibrary['platform'] = PlatformBase.menuData
menuLibrary['doctor'] = DoctorBase.menuData
menuLibrary['profile'] = ProfileBase.menuData
menuLibrary['registration'] = RegistrationBase.menuData
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


  'com.doublechaintech.his.platform.Platform': {name:'platform'},
  'com.doublechaintech.his.doctor.Doctor': {name:'doctor'},
  'com.doublechaintech.his.profile.Profile': {name:'profile'},
  'com.doublechaintech.his.registration.Registration': {name:'registration'},
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
    PlatformBase,
    PlatformBizApp,
    PlatformModel,
    PlatformDashboard,
    PlatformPreference,
    PlatformModalTable,
    PlatformSearch,
    PlatformSearchForm,
    PlatformCreateForm,
    PlatformAssociateForm,
    PlatformTable,
    PlatformService,
    PlatformUpdateForm,
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
    ProfileBase,
    ProfileBizApp,
    ProfileModel,
    ProfileDashboard,
    ProfilePreference,
    ProfileModalTable,
    ProfileSearch,
    ProfileSearchForm,
    ProfileCreateForm,
    ProfileAssociateForm,
    ProfileTable,
    ProfileService,
    ProfileUpdateForm,
    RegistrationBase,
    RegistrationBizApp,
    RegistrationModel,
    RegistrationDashboard,
    RegistrationPreference,
    RegistrationModalTable,
    RegistrationSearch,
    RegistrationSearchForm,
    RegistrationCreateForm,
    RegistrationAssociateForm,
    RegistrationTable,
    RegistrationService,
    RegistrationUpdateForm,
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







