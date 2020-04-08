

import HospitalBase from './hospital/Hospital.base';
import HospitalBizApp from './hospital/Hospital.app';
import HospitalModel from './hospital/Hospital.model';
import HospitalDashboard from './hospital/Hospital.dashboard';
import HospitalModalTable from './hospital/Hospital.modaltable';
import HospitalSearch from './hospital/Hospital.search';
import HospitalSearchForm from './hospital/Hospital.searchform';
import HospitalCreateForm from './hospital/Hospital.createform';
import HospitalAssociateForm from './hospital/Hospital.associateform';
import HospitalTable from './hospital/Hospital.table';
import HospitalPermission from './hospital/Hospital.permission';
import HospitalProfile from './hospital/Hospital.profile';
import HospitalCreateFormBody from './hospital/Hospital.createformbody';
import HospitalService from './hospital/Hospital.service';
import HospitalUpdateForm from './hospital/Hospital.updateform';
import ExpenseTypeBase from './expensetype/ExpenseType.base';
import ExpenseTypeBizApp from './expensetype/ExpenseType.app';
import ExpenseTypeModel from './expensetype/ExpenseType.model';
import ExpenseTypeDashboard from './expensetype/ExpenseType.dashboard';
import ExpenseTypeModalTable from './expensetype/ExpenseType.modaltable';
import ExpenseTypeSearch from './expensetype/ExpenseType.search';
import ExpenseTypeSearchForm from './expensetype/ExpenseType.searchform';
import ExpenseTypeCreateForm from './expensetype/ExpenseType.createform';
import ExpenseTypeAssociateForm from './expensetype/ExpenseType.associateform';
import ExpenseTypeTable from './expensetype/ExpenseType.table';
import ExpenseTypePermission from './expensetype/ExpenseType.permission';
import ExpenseTypeProfile from './expensetype/ExpenseType.profile';
import ExpenseTypeCreateFormBody from './expensetype/ExpenseType.createformbody';
import ExpenseTypeService from './expensetype/ExpenseType.service';
import ExpenseTypeUpdateForm from './expensetype/ExpenseType.updateform';
import PeriodBase from './period/Period.base';
import PeriodBizApp from './period/Period.app';
import PeriodModel from './period/Period.model';
import PeriodDashboard from './period/Period.dashboard';
import PeriodModalTable from './period/Period.modaltable';
import PeriodSearch from './period/Period.search';
import PeriodSearchForm from './period/Period.searchform';
import PeriodCreateForm from './period/Period.createform';
import PeriodAssociateForm from './period/Period.associateform';
import PeriodTable from './period/Period.table';
import PeriodPermission from './period/Period.permission';
import PeriodProfile from './period/Period.profile';
import PeriodCreateFormBody from './period/Period.createformbody';
import PeriodService from './period/Period.service';
import PeriodUpdateForm from './period/Period.updateform';
import ExpenseItemBase from './expenseitem/ExpenseItem.base';
import ExpenseItemBizApp from './expenseitem/ExpenseItem.app';
import ExpenseItemModel from './expenseitem/ExpenseItem.model';
import ExpenseItemDashboard from './expenseitem/ExpenseItem.dashboard';
import ExpenseItemModalTable from './expenseitem/ExpenseItem.modaltable';
import ExpenseItemSearch from './expenseitem/ExpenseItem.search';
import ExpenseItemSearchForm from './expenseitem/ExpenseItem.searchform';
import ExpenseItemCreateForm from './expenseitem/ExpenseItem.createform';
import ExpenseItemAssociateForm from './expenseitem/ExpenseItem.associateform';
import ExpenseItemTable from './expenseitem/ExpenseItem.table';
import ExpenseItemPermission from './expenseitem/ExpenseItem.permission';
import ExpenseItemProfile from './expenseitem/ExpenseItem.profile';
import ExpenseItemCreateFormBody from './expenseitem/ExpenseItem.createformbody';
import ExpenseItemService from './expenseitem/ExpenseItem.service';
import ExpenseItemUpdateForm from './expenseitem/ExpenseItem.updateform';
import DoctorBase from './doctor/Doctor.base';
import DoctorBizApp from './doctor/Doctor.app';
import DoctorModel from './doctor/Doctor.model';
import DoctorDashboard from './doctor/Doctor.dashboard';
import DoctorModalTable from './doctor/Doctor.modaltable';
import DoctorSearch from './doctor/Doctor.search';
import DoctorSearchForm from './doctor/Doctor.searchform';
import DoctorCreateForm from './doctor/Doctor.createform';
import DoctorAssociateForm from './doctor/Doctor.associateform';
import DoctorTable from './doctor/Doctor.table';
import DoctorPermission from './doctor/Doctor.permission';
import DoctorProfile from './doctor/Doctor.profile';
import DoctorCreateFormBody from './doctor/Doctor.createformbody';
import DoctorService from './doctor/Doctor.service';
import DoctorUpdateForm from './doctor/Doctor.updateform';
import DepartmentBase from './department/Department.base';
import DepartmentBizApp from './department/Department.app';
import DepartmentModel from './department/Department.model';
import DepartmentDashboard from './department/Department.dashboard';
import DepartmentModalTable from './department/Department.modaltable';
import DepartmentSearch from './department/Department.search';
import DepartmentSearchForm from './department/Department.searchform';
import DepartmentCreateForm from './department/Department.createform';
import DepartmentAssociateForm from './department/Department.associateform';
import DepartmentTable from './department/Department.table';
import DepartmentPermission from './department/Department.permission';
import DepartmentProfile from './department/Department.profile';
import DepartmentCreateFormBody from './department/Department.createformbody';
import DepartmentService from './department/Department.service';
import DepartmentUpdateForm from './department/Department.updateform';
import DoctorAssignmentBase from './doctorassignment/DoctorAssignment.base';
import DoctorAssignmentBizApp from './doctorassignment/DoctorAssignment.app';
import DoctorAssignmentModel from './doctorassignment/DoctorAssignment.model';
import DoctorAssignmentDashboard from './doctorassignment/DoctorAssignment.dashboard';
import DoctorAssignmentModalTable from './doctorassignment/DoctorAssignment.modaltable';
import DoctorAssignmentSearch from './doctorassignment/DoctorAssignment.search';
import DoctorAssignmentSearchForm from './doctorassignment/DoctorAssignment.searchform';
import DoctorAssignmentCreateForm from './doctorassignment/DoctorAssignment.createform';
import DoctorAssignmentAssociateForm from './doctorassignment/DoctorAssignment.associateform';
import DoctorAssignmentTable from './doctorassignment/DoctorAssignment.table';
import DoctorAssignmentPermission from './doctorassignment/DoctorAssignment.permission';
import DoctorAssignmentProfile from './doctorassignment/DoctorAssignment.profile';
import DoctorAssignmentCreateFormBody from './doctorassignment/DoctorAssignment.createformbody';
import DoctorAssignmentService from './doctorassignment/DoctorAssignment.service';
import DoctorAssignmentUpdateForm from './doctorassignment/DoctorAssignment.updateform';
import DoctorScheduleBase from './doctorschedule/DoctorSchedule.base';
import DoctorScheduleBizApp from './doctorschedule/DoctorSchedule.app';
import DoctorScheduleModel from './doctorschedule/DoctorSchedule.model';
import DoctorScheduleDashboard from './doctorschedule/DoctorSchedule.dashboard';
import DoctorScheduleModalTable from './doctorschedule/DoctorSchedule.modaltable';
import DoctorScheduleSearch from './doctorschedule/DoctorSchedule.search';
import DoctorScheduleSearchForm from './doctorschedule/DoctorSchedule.searchform';
import DoctorScheduleCreateForm from './doctorschedule/DoctorSchedule.createform';
import DoctorScheduleAssociateForm from './doctorschedule/DoctorSchedule.associateform';
import DoctorScheduleTable from './doctorschedule/DoctorSchedule.table';
import DoctorSchedulePermission from './doctorschedule/DoctorSchedule.permission';
import DoctorScheduleProfile from './doctorschedule/DoctorSchedule.profile';
import DoctorScheduleCreateFormBody from './doctorschedule/DoctorSchedule.createformbody';
import DoctorScheduleService from './doctorschedule/DoctorSchedule.service';
import DoctorScheduleUpdateForm from './doctorschedule/DoctorSchedule.updateform';
import MobileAppBase from './mobileapp/MobileApp.base';
import MobileAppBizApp from './mobileapp/MobileApp.app';
import MobileAppModel from './mobileapp/MobileApp.model';
import MobileAppDashboard from './mobileapp/MobileApp.dashboard';
import MobileAppModalTable from './mobileapp/MobileApp.modaltable';
import MobileAppSearch from './mobileapp/MobileApp.search';
import MobileAppSearchForm from './mobileapp/MobileApp.searchform';
import MobileAppCreateForm from './mobileapp/MobileApp.createform';
import MobileAppAssociateForm from './mobileapp/MobileApp.associateform';
import MobileAppTable from './mobileapp/MobileApp.table';
import MobileAppPermission from './mobileapp/MobileApp.permission';
import MobileAppProfile from './mobileapp/MobileApp.profile';
import MobileAppCreateFormBody from './mobileapp/MobileApp.createformbody';
import MobileAppService from './mobileapp/MobileApp.service';
import MobileAppUpdateForm from './mobileapp/MobileApp.updateform';
import PageBase from './page/Page.base';
import PageBizApp from './page/Page.app';
import PageModel from './page/Page.model';
import PageDashboard from './page/Page.dashboard';
import PageModalTable from './page/Page.modaltable';
import PageSearch from './page/Page.search';
import PageSearchForm from './page/Page.searchform';
import PageCreateForm from './page/Page.createform';
import PageAssociateForm from './page/Page.associateform';
import PageTable from './page/Page.table';
import PagePermission from './page/Page.permission';
import PageProfile from './page/Page.profile';
import PageCreateFormBody from './page/Page.createformbody';
import PageService from './page/Page.service';
import PageUpdateForm from './page/Page.updateform';
import PageTypeBase from './pagetype/PageType.base';
import PageTypeBizApp from './pagetype/PageType.app';
import PageTypeModel from './pagetype/PageType.model';
import PageTypeDashboard from './pagetype/PageType.dashboard';
import PageTypeModalTable from './pagetype/PageType.modaltable';
import PageTypeSearch from './pagetype/PageType.search';
import PageTypeSearchForm from './pagetype/PageType.searchform';
import PageTypeCreateForm from './pagetype/PageType.createform';
import PageTypeAssociateForm from './pagetype/PageType.associateform';
import PageTypeTable from './pagetype/PageType.table';
import PageTypePermission from './pagetype/PageType.permission';
import PageTypeProfile from './pagetype/PageType.profile';
import PageTypeCreateFormBody from './pagetype/PageType.createformbody';
import PageTypeService from './pagetype/PageType.service';
import PageTypeUpdateForm from './pagetype/PageType.updateform';
import SlideBase from './slide/Slide.base';
import SlideBizApp from './slide/Slide.app';
import SlideModel from './slide/Slide.model';
import SlideDashboard from './slide/Slide.dashboard';
import SlideModalTable from './slide/Slide.modaltable';
import SlideSearch from './slide/Slide.search';
import SlideSearchForm from './slide/Slide.searchform';
import SlideCreateForm from './slide/Slide.createform';
import SlideAssociateForm from './slide/Slide.associateform';
import SlideTable from './slide/Slide.table';
import SlidePermission from './slide/Slide.permission';
import SlideProfile from './slide/Slide.profile';
import SlideCreateFormBody from './slide/Slide.createformbody';
import SlideService from './slide/Slide.service';
import SlideUpdateForm from './slide/Slide.updateform';
import UiActionBase from './uiaction/UiAction.base';
import UiActionBizApp from './uiaction/UiAction.app';
import UiActionModel from './uiaction/UiAction.model';
import UiActionDashboard from './uiaction/UiAction.dashboard';
import UiActionModalTable from './uiaction/UiAction.modaltable';
import UiActionSearch from './uiaction/UiAction.search';
import UiActionSearchForm from './uiaction/UiAction.searchform';
import UiActionCreateForm from './uiaction/UiAction.createform';
import UiActionAssociateForm from './uiaction/UiAction.associateform';
import UiActionTable from './uiaction/UiAction.table';
import UiActionPermission from './uiaction/UiAction.permission';
import UiActionProfile from './uiaction/UiAction.profile';
import UiActionCreateFormBody from './uiaction/UiAction.createformbody';
import UiActionService from './uiaction/UiAction.service';
import UiActionUpdateForm from './uiaction/UiAction.updateform';
import SectionBase from './section/Section.base';
import SectionBizApp from './section/Section.app';
import SectionModel from './section/Section.model';
import SectionDashboard from './section/Section.dashboard';
import SectionModalTable from './section/Section.modaltable';
import SectionSearch from './section/Section.search';
import SectionSearchForm from './section/Section.searchform';
import SectionCreateForm from './section/Section.createform';
import SectionAssociateForm from './section/Section.associateform';
import SectionTable from './section/Section.table';
import SectionPermission from './section/Section.permission';
import SectionProfile from './section/Section.profile';
import SectionCreateFormBody from './section/Section.createformbody';
import SectionService from './section/Section.service';
import SectionUpdateForm from './section/Section.updateform';
import UserDomainBase from './userdomain/UserDomain.base';
import UserDomainBizApp from './userdomain/UserDomain.app';
import UserDomainModel from './userdomain/UserDomain.model';
import UserDomainDashboard from './userdomain/UserDomain.dashboard';
import UserDomainModalTable from './userdomain/UserDomain.modaltable';
import UserDomainSearch from './userdomain/UserDomain.search';
import UserDomainSearchForm from './userdomain/UserDomain.searchform';
import UserDomainCreateForm from './userdomain/UserDomain.createform';
import UserDomainAssociateForm from './userdomain/UserDomain.associateform';
import UserDomainTable from './userdomain/UserDomain.table';
import UserDomainPermission from './userdomain/UserDomain.permission';
import UserDomainProfile from './userdomain/UserDomain.profile';
import UserDomainCreateFormBody from './userdomain/UserDomain.createformbody';
import UserDomainService from './userdomain/UserDomain.service';
import UserDomainUpdateForm from './userdomain/UserDomain.updateform';
import UserWhiteListBase from './userwhitelist/UserWhiteList.base';
import UserWhiteListBizApp from './userwhitelist/UserWhiteList.app';
import UserWhiteListModel from './userwhitelist/UserWhiteList.model';
import UserWhiteListDashboard from './userwhitelist/UserWhiteList.dashboard';
import UserWhiteListModalTable from './userwhitelist/UserWhiteList.modaltable';
import UserWhiteListSearch from './userwhitelist/UserWhiteList.search';
import UserWhiteListSearchForm from './userwhitelist/UserWhiteList.searchform';
import UserWhiteListCreateForm from './userwhitelist/UserWhiteList.createform';
import UserWhiteListAssociateForm from './userwhitelist/UserWhiteList.associateform';
import UserWhiteListTable from './userwhitelist/UserWhiteList.table';
import UserWhiteListPermission from './userwhitelist/UserWhiteList.permission';
import UserWhiteListProfile from './userwhitelist/UserWhiteList.profile';
import UserWhiteListCreateFormBody from './userwhitelist/UserWhiteList.createformbody';
import UserWhiteListService from './userwhitelist/UserWhiteList.service';
import UserWhiteListUpdateForm from './userwhitelist/UserWhiteList.updateform';
import SecUserBase from './secuser/SecUser.base';
import SecUserBizApp from './secuser/SecUser.app';
import SecUserModel from './secuser/SecUser.model';
import SecUserDashboard from './secuser/SecUser.dashboard';
import SecUserModalTable from './secuser/SecUser.modaltable';
import SecUserSearch from './secuser/SecUser.search';
import SecUserSearchForm from './secuser/SecUser.searchform';
import SecUserCreateForm from './secuser/SecUser.createform';
import SecUserAssociateForm from './secuser/SecUser.associateform';
import SecUserTable from './secuser/SecUser.table';
import SecUserPermission from './secuser/SecUser.permission';
import SecUserProfile from './secuser/SecUser.profile';
import SecUserCreateFormBody from './secuser/SecUser.createformbody';
import SecUserService from './secuser/SecUser.service';
import SecUserUpdateForm from './secuser/SecUser.updateform';
import UserAppBase from './userapp/UserApp.base';
import UserAppBizApp from './userapp/UserApp.app';
import UserAppModel from './userapp/UserApp.model';
import UserAppDashboard from './userapp/UserApp.dashboard';
import UserAppModalTable from './userapp/UserApp.modaltable';
import UserAppSearch from './userapp/UserApp.search';
import UserAppSearchForm from './userapp/UserApp.searchform';
import UserAppCreateForm from './userapp/UserApp.createform';
import UserAppAssociateForm from './userapp/UserApp.associateform';
import UserAppTable from './userapp/UserApp.table';
import UserAppPermission from './userapp/UserApp.permission';
import UserAppProfile from './userapp/UserApp.profile';
import UserAppCreateFormBody from './userapp/UserApp.createformbody';
import UserAppService from './userapp/UserApp.service';
import UserAppUpdateForm from './userapp/UserApp.updateform';
import QuickLinkBase from './quicklink/QuickLink.base';
import QuickLinkBizApp from './quicklink/QuickLink.app';
import QuickLinkModel from './quicklink/QuickLink.model';
import QuickLinkDashboard from './quicklink/QuickLink.dashboard';
import QuickLinkModalTable from './quicklink/QuickLink.modaltable';
import QuickLinkSearch from './quicklink/QuickLink.search';
import QuickLinkSearchForm from './quicklink/QuickLink.searchform';
import QuickLinkCreateForm from './quicklink/QuickLink.createform';
import QuickLinkAssociateForm from './quicklink/QuickLink.associateform';
import QuickLinkTable from './quicklink/QuickLink.table';
import QuickLinkPermission from './quicklink/QuickLink.permission';
import QuickLinkProfile from './quicklink/QuickLink.profile';
import QuickLinkCreateFormBody from './quicklink/QuickLink.createformbody';
import QuickLinkService from './quicklink/QuickLink.service';
import QuickLinkUpdateForm from './quicklink/QuickLink.updateform';
import ListAccessBase from './listaccess/ListAccess.base';
import ListAccessBizApp from './listaccess/ListAccess.app';
import ListAccessModel from './listaccess/ListAccess.model';
import ListAccessDashboard from './listaccess/ListAccess.dashboard';
import ListAccessModalTable from './listaccess/ListAccess.modaltable';
import ListAccessSearch from './listaccess/ListAccess.search';
import ListAccessSearchForm from './listaccess/ListAccess.searchform';
import ListAccessCreateForm from './listaccess/ListAccess.createform';
import ListAccessAssociateForm from './listaccess/ListAccess.associateform';
import ListAccessTable from './listaccess/ListAccess.table';
import ListAccessPermission from './listaccess/ListAccess.permission';
import ListAccessProfile from './listaccess/ListAccess.profile';
import ListAccessCreateFormBody from './listaccess/ListAccess.createformbody';
import ListAccessService from './listaccess/ListAccess.service';
import ListAccessUpdateForm from './listaccess/ListAccess.updateform';
import ObjectAccessBase from './objectaccess/ObjectAccess.base';
import ObjectAccessBizApp from './objectaccess/ObjectAccess.app';
import ObjectAccessModel from './objectaccess/ObjectAccess.model';
import ObjectAccessDashboard from './objectaccess/ObjectAccess.dashboard';
import ObjectAccessModalTable from './objectaccess/ObjectAccess.modaltable';
import ObjectAccessSearch from './objectaccess/ObjectAccess.search';
import ObjectAccessSearchForm from './objectaccess/ObjectAccess.searchform';
import ObjectAccessCreateForm from './objectaccess/ObjectAccess.createform';
import ObjectAccessAssociateForm from './objectaccess/ObjectAccess.associateform';
import ObjectAccessTable from './objectaccess/ObjectAccess.table';
import ObjectAccessPermission from './objectaccess/ObjectAccess.permission';
import ObjectAccessProfile from './objectaccess/ObjectAccess.profile';
import ObjectAccessCreateFormBody from './objectaccess/ObjectAccess.createformbody';
import ObjectAccessService from './objectaccess/ObjectAccess.service';
import ObjectAccessUpdateForm from './objectaccess/ObjectAccess.updateform';
import LoginHistoryBase from './loginhistory/LoginHistory.base';
import LoginHistoryBizApp from './loginhistory/LoginHistory.app';
import LoginHistoryModel from './loginhistory/LoginHistory.model';
import LoginHistoryDashboard from './loginhistory/LoginHistory.dashboard';
import LoginHistoryModalTable from './loginhistory/LoginHistory.modaltable';
import LoginHistorySearch from './loginhistory/LoginHistory.search';
import LoginHistorySearchForm from './loginhistory/LoginHistory.searchform';
import LoginHistoryCreateForm from './loginhistory/LoginHistory.createform';
import LoginHistoryAssociateForm from './loginhistory/LoginHistory.associateform';
import LoginHistoryTable from './loginhistory/LoginHistory.table';
import LoginHistoryPermission from './loginhistory/LoginHistory.permission';
import LoginHistoryProfile from './loginhistory/LoginHistory.profile';
import LoginHistoryCreateFormBody from './loginhistory/LoginHistory.createformbody';
import LoginHistoryService from './loginhistory/LoginHistory.service';
import LoginHistoryUpdateForm from './loginhistory/LoginHistory.updateform';
import GenericFormBase from './genericform/GenericForm.base';
import GenericFormBizApp from './genericform/GenericForm.app';
import GenericFormModel from './genericform/GenericForm.model';
import GenericFormDashboard from './genericform/GenericForm.dashboard';
import GenericFormModalTable from './genericform/GenericForm.modaltable';
import GenericFormSearch from './genericform/GenericForm.search';
import GenericFormSearchForm from './genericform/GenericForm.searchform';
import GenericFormCreateForm from './genericform/GenericForm.createform';
import GenericFormAssociateForm from './genericform/GenericForm.associateform';
import GenericFormTable from './genericform/GenericForm.table';
import GenericFormPermission from './genericform/GenericForm.permission';
import GenericFormProfile from './genericform/GenericForm.profile';
import GenericFormCreateFormBody from './genericform/GenericForm.createformbody';
import GenericFormService from './genericform/GenericForm.service';
import GenericFormUpdateForm from './genericform/GenericForm.updateform';
import FormMessageBase from './formmessage/FormMessage.base';
import FormMessageBizApp from './formmessage/FormMessage.app';
import FormMessageModel from './formmessage/FormMessage.model';
import FormMessageDashboard from './formmessage/FormMessage.dashboard';
import FormMessageModalTable from './formmessage/FormMessage.modaltable';
import FormMessageSearch from './formmessage/FormMessage.search';
import FormMessageSearchForm from './formmessage/FormMessage.searchform';
import FormMessageCreateForm from './formmessage/FormMessage.createform';
import FormMessageAssociateForm from './formmessage/FormMessage.associateform';
import FormMessageTable from './formmessage/FormMessage.table';
import FormMessagePermission from './formmessage/FormMessage.permission';
import FormMessageProfile from './formmessage/FormMessage.profile';
import FormMessageCreateFormBody from './formmessage/FormMessage.createformbody';
import FormMessageService from './formmessage/FormMessage.service';
import FormMessageUpdateForm from './formmessage/FormMessage.updateform';
import FormFieldMessageBase from './formfieldmessage/FormFieldMessage.base';
import FormFieldMessageBizApp from './formfieldmessage/FormFieldMessage.app';
import FormFieldMessageModel from './formfieldmessage/FormFieldMessage.model';
import FormFieldMessageDashboard from './formfieldmessage/FormFieldMessage.dashboard';
import FormFieldMessageModalTable from './formfieldmessage/FormFieldMessage.modaltable';
import FormFieldMessageSearch from './formfieldmessage/FormFieldMessage.search';
import FormFieldMessageSearchForm from './formfieldmessage/FormFieldMessage.searchform';
import FormFieldMessageCreateForm from './formfieldmessage/FormFieldMessage.createform';
import FormFieldMessageAssociateForm from './formfieldmessage/FormFieldMessage.associateform';
import FormFieldMessageTable from './formfieldmessage/FormFieldMessage.table';
import FormFieldMessagePermission from './formfieldmessage/FormFieldMessage.permission';
import FormFieldMessageProfile from './formfieldmessage/FormFieldMessage.profile';
import FormFieldMessageCreateFormBody from './formfieldmessage/FormFieldMessage.createformbody';
import FormFieldMessageService from './formfieldmessage/FormFieldMessage.service';
import FormFieldMessageUpdateForm from './formfieldmessage/FormFieldMessage.updateform';
import FormFieldBase from './formfield/FormField.base';
import FormFieldBizApp from './formfield/FormField.app';
import FormFieldModel from './formfield/FormField.model';
import FormFieldDashboard from './formfield/FormField.dashboard';
import FormFieldModalTable from './formfield/FormField.modaltable';
import FormFieldSearch from './formfield/FormField.search';
import FormFieldSearchForm from './formfield/FormField.searchform';
import FormFieldCreateForm from './formfield/FormField.createform';
import FormFieldAssociateForm from './formfield/FormField.associateform';
import FormFieldTable from './formfield/FormField.table';
import FormFieldPermission from './formfield/FormField.permission';
import FormFieldProfile from './formfield/FormField.profile';
import FormFieldCreateFormBody from './formfield/FormField.createformbody';
import FormFieldService from './formfield/FormField.service';
import FormFieldUpdateForm from './formfield/FormField.updateform';
import FormActionBase from './formaction/FormAction.base';
import FormActionBizApp from './formaction/FormAction.app';
import FormActionModel from './formaction/FormAction.model';
import FormActionDashboard from './formaction/FormAction.dashboard';
import FormActionModalTable from './formaction/FormAction.modaltable';
import FormActionSearch from './formaction/FormAction.search';
import FormActionSearchForm from './formaction/FormAction.searchform';
import FormActionCreateForm from './formaction/FormAction.createform';
import FormActionAssociateForm from './formaction/FormAction.associateform';
import FormActionTable from './formaction/FormAction.table';
import FormActionPermission from './formaction/FormAction.permission';
import FormActionProfile from './formaction/FormAction.profile';
import FormActionCreateFormBody from './formaction/FormAction.createformbody';
import FormActionService from './formaction/FormAction.service';
import FormActionUpdateForm from './formaction/FormAction.updateform';
import CandidateContainerBase from './candidatecontainer/CandidateContainer.base';
import CandidateContainerBizApp from './candidatecontainer/CandidateContainer.app';
import CandidateContainerModel from './candidatecontainer/CandidateContainer.model';
import CandidateContainerDashboard from './candidatecontainer/CandidateContainer.dashboard';
import CandidateContainerModalTable from './candidatecontainer/CandidateContainer.modaltable';
import CandidateContainerSearch from './candidatecontainer/CandidateContainer.search';
import CandidateContainerSearchForm from './candidatecontainer/CandidateContainer.searchform';
import CandidateContainerCreateForm from './candidatecontainer/CandidateContainer.createform';
import CandidateContainerAssociateForm from './candidatecontainer/CandidateContainer.associateform';
import CandidateContainerTable from './candidatecontainer/CandidateContainer.table';
import CandidateContainerPermission from './candidatecontainer/CandidateContainer.permission';
import CandidateContainerProfile from './candidatecontainer/CandidateContainer.profile';
import CandidateContainerCreateFormBody from './candidatecontainer/CandidateContainer.createformbody';
import CandidateContainerService from './candidatecontainer/CandidateContainer.service';
import CandidateContainerUpdateForm from './candidatecontainer/CandidateContainer.updateform';
import CandidateElementBase from './candidateelement/CandidateElement.base';
import CandidateElementBizApp from './candidateelement/CandidateElement.app';
import CandidateElementModel from './candidateelement/CandidateElement.model';
import CandidateElementDashboard from './candidateelement/CandidateElement.dashboard';
import CandidateElementModalTable from './candidateelement/CandidateElement.modaltable';
import CandidateElementSearch from './candidateelement/CandidateElement.search';
import CandidateElementSearchForm from './candidateelement/CandidateElement.searchform';
import CandidateElementCreateForm from './candidateelement/CandidateElement.createform';
import CandidateElementAssociateForm from './candidateelement/CandidateElement.associateform';
import CandidateElementTable from './candidateelement/CandidateElement.table';
import CandidateElementPermission from './candidateelement/CandidateElement.permission';
import CandidateElementProfile from './candidateelement/CandidateElement.profile';
import CandidateElementCreateFormBody from './candidateelement/CandidateElement.createformbody';
import CandidateElementService from './candidateelement/CandidateElement.service';
import CandidateElementUpdateForm from './candidateelement/CandidateElement.updateform';
import WechatWorkappIdentifyBase from './wechatworkappidentify/WechatWorkappIdentify.base';
import WechatWorkappIdentifyBizApp from './wechatworkappidentify/WechatWorkappIdentify.app';
import WechatWorkappIdentifyModel from './wechatworkappidentify/WechatWorkappIdentify.model';
import WechatWorkappIdentifyDashboard from './wechatworkappidentify/WechatWorkappIdentify.dashboard';
import WechatWorkappIdentifyModalTable from './wechatworkappidentify/WechatWorkappIdentify.modaltable';
import WechatWorkappIdentifySearch from './wechatworkappidentify/WechatWorkappIdentify.search';
import WechatWorkappIdentifySearchForm from './wechatworkappidentify/WechatWorkappIdentify.searchform';
import WechatWorkappIdentifyCreateForm from './wechatworkappidentify/WechatWorkappIdentify.createform';
import WechatWorkappIdentifyAssociateForm from './wechatworkappidentify/WechatWorkappIdentify.associateform';
import WechatWorkappIdentifyTable from './wechatworkappidentify/WechatWorkappIdentify.table';
import WechatWorkappIdentifyPermission from './wechatworkappidentify/WechatWorkappIdentify.permission';
import WechatWorkappIdentifyProfile from './wechatworkappidentify/WechatWorkappIdentify.profile';
import WechatWorkappIdentifyCreateFormBody from './wechatworkappidentify/WechatWorkappIdentify.createformbody';
import WechatWorkappIdentifyService from './wechatworkappidentify/WechatWorkappIdentify.service';
import WechatWorkappIdentifyUpdateForm from './wechatworkappidentify/WechatWorkappIdentify.updateform';
import WechatMiniappIdentifyBase from './wechatminiappidentify/WechatMiniappIdentify.base';
import WechatMiniappIdentifyBizApp from './wechatminiappidentify/WechatMiniappIdentify.app';
import WechatMiniappIdentifyModel from './wechatminiappidentify/WechatMiniappIdentify.model';
import WechatMiniappIdentifyDashboard from './wechatminiappidentify/WechatMiniappIdentify.dashboard';
import WechatMiniappIdentifyModalTable from './wechatminiappidentify/WechatMiniappIdentify.modaltable';
import WechatMiniappIdentifySearch from './wechatminiappidentify/WechatMiniappIdentify.search';
import WechatMiniappIdentifySearchForm from './wechatminiappidentify/WechatMiniappIdentify.searchform';
import WechatMiniappIdentifyCreateForm from './wechatminiappidentify/WechatMiniappIdentify.createform';
import WechatMiniappIdentifyAssociateForm from './wechatminiappidentify/WechatMiniappIdentify.associateform';
import WechatMiniappIdentifyTable from './wechatminiappidentify/WechatMiniappIdentify.table';
import WechatMiniappIdentifyPermission from './wechatminiappidentify/WechatMiniappIdentify.permission';
import WechatMiniappIdentifyProfile from './wechatminiappidentify/WechatMiniappIdentify.profile';
import WechatMiniappIdentifyCreateFormBody from './wechatminiappidentify/WechatMiniappIdentify.createformbody';
import WechatMiniappIdentifyService from './wechatminiappidentify/WechatMiniappIdentify.service';
import WechatMiniappIdentifyUpdateForm from './wechatminiappidentify/WechatMiniappIdentify.updateform';
import TreeNodeBase from './treenode/TreeNode.base';
import TreeNodeBizApp from './treenode/TreeNode.app';
import TreeNodeModel from './treenode/TreeNode.model';
import TreeNodeDashboard from './treenode/TreeNode.dashboard';
import TreeNodeModalTable from './treenode/TreeNode.modaltable';
import TreeNodeSearch from './treenode/TreeNode.search';
import TreeNodeSearchForm from './treenode/TreeNode.searchform';
import TreeNodeCreateForm from './treenode/TreeNode.createform';
import TreeNodeAssociateForm from './treenode/TreeNode.associateform';
import TreeNodeTable from './treenode/TreeNode.table';
import TreeNodePermission from './treenode/TreeNode.permission';
import TreeNodeProfile from './treenode/TreeNode.profile';
import TreeNodeCreateFormBody from './treenode/TreeNode.createformbody';
import TreeNodeService from './treenode/TreeNode.service';
import TreeNodeUpdateForm from './treenode/TreeNode.updateform';


const BizModels = [
	HospitalModel,
	ExpenseTypeModel,
	PeriodModel,
	ExpenseItemModel,
	DoctorModel,
	DepartmentModel,
	DoctorAssignmentModel,
	DoctorScheduleModel,
	MobileAppModel,
	PageModel,
	PageTypeModel,
	SlideModel,
	UiActionModel,
	SectionModel,
	UserDomainModel,
	UserWhiteListModel,
	SecUserModel,
	UserAppModel,
	QuickLinkModel,
	ListAccessModel,
	ObjectAccessModel,
	LoginHistoryModel,
	GenericFormModel,
	FormMessageModel,
	FormFieldMessageModel,
	FormFieldModel,
	FormActionModel,
	CandidateContainerModel,
	CandidateElementModel,
	WechatWorkappIdentifyModel,
	WechatMiniappIdentifyModel,
	TreeNodeModel,

]


const bindBizModels = (app) =>{

	BizModels.map((model)=>app.model(model))

}
const unbindBizModels = (app) =>{

	BizModels.map((model)=>app.unmodel(model))

}

const menuLibrary = []

menuLibrary.hospital = HospitalBase.menuData
menuLibrary.expenseType = ExpenseTypeBase.menuData
menuLibrary.period = PeriodBase.menuData
menuLibrary.expenseItem = ExpenseItemBase.menuData
menuLibrary.doctor = DoctorBase.menuData
menuLibrary.department = DepartmentBase.menuData
menuLibrary.doctorAssignment = DoctorAssignmentBase.menuData
menuLibrary.doctorSchedule = DoctorScheduleBase.menuData
menuLibrary.mobileApp = MobileAppBase.menuData
menuLibrary.page = PageBase.menuData
menuLibrary.pageType = PageTypeBase.menuData
menuLibrary.slide = SlideBase.menuData
menuLibrary.uiAction = UiActionBase.menuData
menuLibrary.section = SectionBase.menuData
menuLibrary.userDomain = UserDomainBase.menuData
menuLibrary.userWhiteList = UserWhiteListBase.menuData
menuLibrary.secUser = SecUserBase.menuData
menuLibrary.userApp = UserAppBase.menuData
menuLibrary.quickLink = QuickLinkBase.menuData
menuLibrary.listAccess = ListAccessBase.menuData
menuLibrary.objectAccess = ObjectAccessBase.menuData
menuLibrary.loginHistory = LoginHistoryBase.menuData
menuLibrary.genericForm = GenericFormBase.menuData
menuLibrary.formMessage = FormMessageBase.menuData
menuLibrary.formFieldMessage = FormFieldMessageBase.menuData
menuLibrary.formField = FormFieldBase.menuData
menuLibrary.formAction = FormActionBase.menuData
menuLibrary.candidateContainer = CandidateContainerBase.menuData
menuLibrary.candidateElement = CandidateElementBase.menuData
menuLibrary.wechatWorkappIdentify = WechatWorkappIdentifyBase.menuData
menuLibrary.wechatMiniappIdentify = WechatMiniappIdentifyBase.menuData
menuLibrary.treeNode = TreeNodeBase.menuData


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
  'com.doublechaintech.his.mobileapp.MobileApp': {name:'mobileApp'},
  'com.doublechaintech.his.page.Page': {name:'page'},
  'com.doublechaintech.his.pagetype.PageType': {name:'pageType'},
  'com.doublechaintech.his.slide.Slide': {name:'slide'},
  'com.doublechaintech.his.uiaction.UiAction': {name:'uiAction'},
  'com.doublechaintech.his.section.Section': {name:'section'},
  'com.doublechaintech.his.userdomain.UserDomain': {name:'userDomain'},
  'com.doublechaintech.his.userwhitelist.UserWhiteList': {name:'userWhiteList'},
  'com.doublechaintech.his.secuser.SecUser': {name:'secUser'},
  'com.doublechaintech.his.userapp.UserApp': {name:'userApp'},
  'com.doublechaintech.his.quicklink.QuickLink': {name:'quickLink'},
  'com.doublechaintech.his.listaccess.ListAccess': {name:'listAccess'},
  'com.doublechaintech.his.objectaccess.ObjectAccess': {name:'objectAccess'},
  'com.doublechaintech.his.loginhistory.LoginHistory': {name:'loginHistory'},
  'com.doublechaintech.his.genericform.GenericForm': {name:'genericForm'},
  'com.doublechaintech.his.formmessage.FormMessage': {name:'formMessage'},
  'com.doublechaintech.his.formfieldmessage.FormFieldMessage': {name:'formFieldMessage'},
  'com.doublechaintech.his.formfield.FormField': {name:'formField'},
  'com.doublechaintech.his.formaction.FormAction': {name:'formAction'},
  'com.doublechaintech.his.candidatecontainer.CandidateContainer': {name:'candidateContainer'},
  'com.doublechaintech.his.candidateelement.CandidateElement': {name:'candidateElement'},
  'com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentify': {name:'wechatWorkappIdentify'},
  'com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentify': {name:'wechatMiniappIdentify'},
  'com.doublechaintech.his.treenode.TreeNode': {name:'treeNode'},

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
    HospitalModalTable,
    HospitalSearch,
    HospitalSearchForm,
    HospitalCreateForm,
    HospitalAssociateForm,
    HospitalTable,
    HospitalPermission,
    HospitalProfile,
    HospitalCreateFormBody,
    HospitalService,
    HospitalUpdateForm,
    ExpenseTypeBase,
    ExpenseTypeBizApp,
    ExpenseTypeModel,
    ExpenseTypeDashboard,
    ExpenseTypeModalTable,
    ExpenseTypeSearch,
    ExpenseTypeSearchForm,
    ExpenseTypeCreateForm,
    ExpenseTypeAssociateForm,
    ExpenseTypeTable,
    ExpenseTypePermission,
    ExpenseTypeProfile,
    ExpenseTypeCreateFormBody,
    ExpenseTypeService,
    ExpenseTypeUpdateForm,
    PeriodBase,
    PeriodBizApp,
    PeriodModel,
    PeriodDashboard,
    PeriodModalTable,
    PeriodSearch,
    PeriodSearchForm,
    PeriodCreateForm,
    PeriodAssociateForm,
    PeriodTable,
    PeriodPermission,
    PeriodProfile,
    PeriodCreateFormBody,
    PeriodService,
    PeriodUpdateForm,
    ExpenseItemBase,
    ExpenseItemBizApp,
    ExpenseItemModel,
    ExpenseItemDashboard,
    ExpenseItemModalTable,
    ExpenseItemSearch,
    ExpenseItemSearchForm,
    ExpenseItemCreateForm,
    ExpenseItemAssociateForm,
    ExpenseItemTable,
    ExpenseItemPermission,
    ExpenseItemProfile,
    ExpenseItemCreateFormBody,
    ExpenseItemService,
    ExpenseItemUpdateForm,
    DoctorBase,
    DoctorBizApp,
    DoctorModel,
    DoctorDashboard,
    DoctorModalTable,
    DoctorSearch,
    DoctorSearchForm,
    DoctorCreateForm,
    DoctorAssociateForm,
    DoctorTable,
    DoctorPermission,
    DoctorProfile,
    DoctorCreateFormBody,
    DoctorService,
    DoctorUpdateForm,
    DepartmentBase,
    DepartmentBizApp,
    DepartmentModel,
    DepartmentDashboard,
    DepartmentModalTable,
    DepartmentSearch,
    DepartmentSearchForm,
    DepartmentCreateForm,
    DepartmentAssociateForm,
    DepartmentTable,
    DepartmentPermission,
    DepartmentProfile,
    DepartmentCreateFormBody,
    DepartmentService,
    DepartmentUpdateForm,
    DoctorAssignmentBase,
    DoctorAssignmentBizApp,
    DoctorAssignmentModel,
    DoctorAssignmentDashboard,
    DoctorAssignmentModalTable,
    DoctorAssignmentSearch,
    DoctorAssignmentSearchForm,
    DoctorAssignmentCreateForm,
    DoctorAssignmentAssociateForm,
    DoctorAssignmentTable,
    DoctorAssignmentPermission,
    DoctorAssignmentProfile,
    DoctorAssignmentCreateFormBody,
    DoctorAssignmentService,
    DoctorAssignmentUpdateForm,
    DoctorScheduleBase,
    DoctorScheduleBizApp,
    DoctorScheduleModel,
    DoctorScheduleDashboard,
    DoctorScheduleModalTable,
    DoctorScheduleSearch,
    DoctorScheduleSearchForm,
    DoctorScheduleCreateForm,
    DoctorScheduleAssociateForm,
    DoctorScheduleTable,
    DoctorSchedulePermission,
    DoctorScheduleProfile,
    DoctorScheduleCreateFormBody,
    DoctorScheduleService,
    DoctorScheduleUpdateForm,
    MobileAppBase,
    MobileAppBizApp,
    MobileAppModel,
    MobileAppDashboard,
    MobileAppModalTable,
    MobileAppSearch,
    MobileAppSearchForm,
    MobileAppCreateForm,
    MobileAppAssociateForm,
    MobileAppTable,
    MobileAppPermission,
    MobileAppProfile,
    MobileAppCreateFormBody,
    MobileAppService,
    MobileAppUpdateForm,
    PageBase,
    PageBizApp,
    PageModel,
    PageDashboard,
    PageModalTable,
    PageSearch,
    PageSearchForm,
    PageCreateForm,
    PageAssociateForm,
    PageTable,
    PagePermission,
    PageProfile,
    PageCreateFormBody,
    PageService,
    PageUpdateForm,
    PageTypeBase,
    PageTypeBizApp,
    PageTypeModel,
    PageTypeDashboard,
    PageTypeModalTable,
    PageTypeSearch,
    PageTypeSearchForm,
    PageTypeCreateForm,
    PageTypeAssociateForm,
    PageTypeTable,
    PageTypePermission,
    PageTypeProfile,
    PageTypeCreateFormBody,
    PageTypeService,
    PageTypeUpdateForm,
    SlideBase,
    SlideBizApp,
    SlideModel,
    SlideDashboard,
    SlideModalTable,
    SlideSearch,
    SlideSearchForm,
    SlideCreateForm,
    SlideAssociateForm,
    SlideTable,
    SlidePermission,
    SlideProfile,
    SlideCreateFormBody,
    SlideService,
    SlideUpdateForm,
    UiActionBase,
    UiActionBizApp,
    UiActionModel,
    UiActionDashboard,
    UiActionModalTable,
    UiActionSearch,
    UiActionSearchForm,
    UiActionCreateForm,
    UiActionAssociateForm,
    UiActionTable,
    UiActionPermission,
    UiActionProfile,
    UiActionCreateFormBody,
    UiActionService,
    UiActionUpdateForm,
    SectionBase,
    SectionBizApp,
    SectionModel,
    SectionDashboard,
    SectionModalTable,
    SectionSearch,
    SectionSearchForm,
    SectionCreateForm,
    SectionAssociateForm,
    SectionTable,
    SectionPermission,
    SectionProfile,
    SectionCreateFormBody,
    SectionService,
    SectionUpdateForm,
    UserDomainBase,
    UserDomainBizApp,
    UserDomainModel,
    UserDomainDashboard,
    UserDomainModalTable,
    UserDomainSearch,
    UserDomainSearchForm,
    UserDomainCreateForm,
    UserDomainAssociateForm,
    UserDomainTable,
    UserDomainPermission,
    UserDomainProfile,
    UserDomainCreateFormBody,
    UserDomainService,
    UserDomainUpdateForm,
    UserWhiteListBase,
    UserWhiteListBizApp,
    UserWhiteListModel,
    UserWhiteListDashboard,
    UserWhiteListModalTable,
    UserWhiteListSearch,
    UserWhiteListSearchForm,
    UserWhiteListCreateForm,
    UserWhiteListAssociateForm,
    UserWhiteListTable,
    UserWhiteListPermission,
    UserWhiteListProfile,
    UserWhiteListCreateFormBody,
    UserWhiteListService,
    UserWhiteListUpdateForm,
    SecUserBase,
    SecUserBizApp,
    SecUserModel,
    SecUserDashboard,
    SecUserModalTable,
    SecUserSearch,
    SecUserSearchForm,
    SecUserCreateForm,
    SecUserAssociateForm,
    SecUserTable,
    SecUserPermission,
    SecUserProfile,
    SecUserCreateFormBody,
    SecUserService,
    SecUserUpdateForm,
    UserAppBase,
    UserAppBizApp,
    UserAppModel,
    UserAppDashboard,
    UserAppModalTable,
    UserAppSearch,
    UserAppSearchForm,
    UserAppCreateForm,
    UserAppAssociateForm,
    UserAppTable,
    UserAppPermission,
    UserAppProfile,
    UserAppCreateFormBody,
    UserAppService,
    UserAppUpdateForm,
    QuickLinkBase,
    QuickLinkBizApp,
    QuickLinkModel,
    QuickLinkDashboard,
    QuickLinkModalTable,
    QuickLinkSearch,
    QuickLinkSearchForm,
    QuickLinkCreateForm,
    QuickLinkAssociateForm,
    QuickLinkTable,
    QuickLinkPermission,
    QuickLinkProfile,
    QuickLinkCreateFormBody,
    QuickLinkService,
    QuickLinkUpdateForm,
    ListAccessBase,
    ListAccessBizApp,
    ListAccessModel,
    ListAccessDashboard,
    ListAccessModalTable,
    ListAccessSearch,
    ListAccessSearchForm,
    ListAccessCreateForm,
    ListAccessAssociateForm,
    ListAccessTable,
    ListAccessPermission,
    ListAccessProfile,
    ListAccessCreateFormBody,
    ListAccessService,
    ListAccessUpdateForm,
    ObjectAccessBase,
    ObjectAccessBizApp,
    ObjectAccessModel,
    ObjectAccessDashboard,
    ObjectAccessModalTable,
    ObjectAccessSearch,
    ObjectAccessSearchForm,
    ObjectAccessCreateForm,
    ObjectAccessAssociateForm,
    ObjectAccessTable,
    ObjectAccessPermission,
    ObjectAccessProfile,
    ObjectAccessCreateFormBody,
    ObjectAccessService,
    ObjectAccessUpdateForm,
    LoginHistoryBase,
    LoginHistoryBizApp,
    LoginHistoryModel,
    LoginHistoryDashboard,
    LoginHistoryModalTable,
    LoginHistorySearch,
    LoginHistorySearchForm,
    LoginHistoryCreateForm,
    LoginHistoryAssociateForm,
    LoginHistoryTable,
    LoginHistoryPermission,
    LoginHistoryProfile,
    LoginHistoryCreateFormBody,
    LoginHistoryService,
    LoginHistoryUpdateForm,
    GenericFormBase,
    GenericFormBizApp,
    GenericFormModel,
    GenericFormDashboard,
    GenericFormModalTable,
    GenericFormSearch,
    GenericFormSearchForm,
    GenericFormCreateForm,
    GenericFormAssociateForm,
    GenericFormTable,
    GenericFormPermission,
    GenericFormProfile,
    GenericFormCreateFormBody,
    GenericFormService,
    GenericFormUpdateForm,
    FormMessageBase,
    FormMessageBizApp,
    FormMessageModel,
    FormMessageDashboard,
    FormMessageModalTable,
    FormMessageSearch,
    FormMessageSearchForm,
    FormMessageCreateForm,
    FormMessageAssociateForm,
    FormMessageTable,
    FormMessagePermission,
    FormMessageProfile,
    FormMessageCreateFormBody,
    FormMessageService,
    FormMessageUpdateForm,
    FormFieldMessageBase,
    FormFieldMessageBizApp,
    FormFieldMessageModel,
    FormFieldMessageDashboard,
    FormFieldMessageModalTable,
    FormFieldMessageSearch,
    FormFieldMessageSearchForm,
    FormFieldMessageCreateForm,
    FormFieldMessageAssociateForm,
    FormFieldMessageTable,
    FormFieldMessagePermission,
    FormFieldMessageProfile,
    FormFieldMessageCreateFormBody,
    FormFieldMessageService,
    FormFieldMessageUpdateForm,
    FormFieldBase,
    FormFieldBizApp,
    FormFieldModel,
    FormFieldDashboard,
    FormFieldModalTable,
    FormFieldSearch,
    FormFieldSearchForm,
    FormFieldCreateForm,
    FormFieldAssociateForm,
    FormFieldTable,
    FormFieldPermission,
    FormFieldProfile,
    FormFieldCreateFormBody,
    FormFieldService,
    FormFieldUpdateForm,
    FormActionBase,
    FormActionBizApp,
    FormActionModel,
    FormActionDashboard,
    FormActionModalTable,
    FormActionSearch,
    FormActionSearchForm,
    FormActionCreateForm,
    FormActionAssociateForm,
    FormActionTable,
    FormActionPermission,
    FormActionProfile,
    FormActionCreateFormBody,
    FormActionService,
    FormActionUpdateForm,
    CandidateContainerBase,
    CandidateContainerBizApp,
    CandidateContainerModel,
    CandidateContainerDashboard,
    CandidateContainerModalTable,
    CandidateContainerSearch,
    CandidateContainerSearchForm,
    CandidateContainerCreateForm,
    CandidateContainerAssociateForm,
    CandidateContainerTable,
    CandidateContainerPermission,
    CandidateContainerProfile,
    CandidateContainerCreateFormBody,
    CandidateContainerService,
    CandidateContainerUpdateForm,
    CandidateElementBase,
    CandidateElementBizApp,
    CandidateElementModel,
    CandidateElementDashboard,
    CandidateElementModalTable,
    CandidateElementSearch,
    CandidateElementSearchForm,
    CandidateElementCreateForm,
    CandidateElementAssociateForm,
    CandidateElementTable,
    CandidateElementPermission,
    CandidateElementProfile,
    CandidateElementCreateFormBody,
    CandidateElementService,
    CandidateElementUpdateForm,
    WechatWorkappIdentifyBase,
    WechatWorkappIdentifyBizApp,
    WechatWorkappIdentifyModel,
    WechatWorkappIdentifyDashboard,
    WechatWorkappIdentifyModalTable,
    WechatWorkappIdentifySearch,
    WechatWorkappIdentifySearchForm,
    WechatWorkappIdentifyCreateForm,
    WechatWorkappIdentifyAssociateForm,
    WechatWorkappIdentifyTable,
    WechatWorkappIdentifyPermission,
    WechatWorkappIdentifyProfile,
    WechatWorkappIdentifyCreateFormBody,
    WechatWorkappIdentifyService,
    WechatWorkappIdentifyUpdateForm,
    WechatMiniappIdentifyBase,
    WechatMiniappIdentifyBizApp,
    WechatMiniappIdentifyModel,
    WechatMiniappIdentifyDashboard,
    WechatMiniappIdentifyModalTable,
    WechatMiniappIdentifySearch,
    WechatMiniappIdentifySearchForm,
    WechatMiniappIdentifyCreateForm,
    WechatMiniappIdentifyAssociateForm,
    WechatMiniappIdentifyTable,
    WechatMiniappIdentifyPermission,
    WechatMiniappIdentifyProfile,
    WechatMiniappIdentifyCreateFormBody,
    WechatMiniappIdentifyService,
    WechatMiniappIdentifyUpdateForm,
    TreeNodeBase,
    TreeNodeBizApp,
    TreeNodeModel,
    TreeNodeDashboard,
    TreeNodeModalTable,
    TreeNodeSearch,
    TreeNodeSearchForm,
    TreeNodeCreateForm,
    TreeNodeAssociateForm,
    TreeNodeTable,
    TreeNodePermission,
    TreeNodeProfile,
    TreeNodeCreateFormBody,
    TreeNodeService,
    TreeNodeUpdateForm,


    menuDataOf,bindBizModels,unbindBizModels,calcLocationPath,calcMenuData,
	
};
       


export default OOTBComponents;







