package com.doublechaintech.his;

import java.util.HashMap;
import java.util.Map;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.mobileapp.MobileApp;
import com.doublechaintech.his.page.Page;
import com.doublechaintech.his.pagetype.PageType;
import com.doublechaintech.his.slide.Slide;
import com.doublechaintech.his.uiaction.UiAction;
import com.doublechaintech.his.section.Section;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.quicklink.QuickLink;
import com.doublechaintech.his.listaccess.ListAccess;
import com.doublechaintech.his.objectaccess.ObjectAccess;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.candidatecontainer.CandidateContainer;
import com.doublechaintech.his.candidateelement.CandidateElement;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.his.treenode.TreeNode;


public class BaseHisListOfViewScope {

	/** Hospital的简单属性序列化列表 */
	protected SerializeScope getHospitalSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Hospital.ID_PROPERTY)
			.field(Hospital.NAME_PROPERTY)
			.field(Hospital.ADDRESS_PROPERTY)
			.field(Hospital.TELEPHONE_PROPERTY)
			.field(Hospital.VERSION_PROPERTY)
		;
	}

	/** ExpenseType的简单属性序列化列表 */
	protected SerializeScope getExpenseTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ExpenseType.ID_PROPERTY)
			.field(ExpenseType.NAME_PROPERTY)
			.field(ExpenseType.HELPER_CHARS_PROPERTY)
			.field(ExpenseType.STATUS_PROPERTY)
			.field(ExpenseType.DESCRIPTION_PROPERTY)
			.field(ExpenseType.UPDATE_TIME_PROPERTY)
			.field(ExpenseType.VERSION_PROPERTY)
		;
	}

	/** Period的简单属性序列化列表 */
	protected SerializeScope getPeriodSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Period.ID_PROPERTY)
			.field(Period.NAME_PROPERTY)
			.field(Period.CODE_PROPERTY)
			.field(Period.VERSION_PROPERTY)
		;
	}

	/** ExpenseItem的简单属性序列化列表 */
	protected SerializeScope getExpenseItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ExpenseItem.ID_PROPERTY)
			.field(ExpenseItem.NAME_PROPERTY)
			.field(ExpenseItem.PRICE_PROPERTY)
			.field(ExpenseItem.UPDATE_TIME_PROPERTY)
			.field(ExpenseItem.VERSION_PROPERTY)
		;
	}

	/** Doctor的简单属性序列化列表 */
	protected SerializeScope getDoctorSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Doctor.ID_PROPERTY)
			.field(Doctor.NAME_PROPERTY)
			.field(Doctor.SHOT_IMAGE_PROPERTY)
			.field(Doctor.UPDATE_TIME_PROPERTY)
			.field(Doctor.VERSION_PROPERTY)
		;
	}

	/** Department的简单属性序列化列表 */
	protected SerializeScope getDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Department.ID_PROPERTY)
			.field(Department.NAME_PROPERTY)
			.field(Department.UPDATE_TIME_PROPERTY)
			.field(Department.VERSION_PROPERTY)
		;
	}

	/** DoctorAssignment的简单属性序列化列表 */
	protected SerializeScope getDoctorAssignmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(DoctorAssignment.ID_PROPERTY)
			.field(DoctorAssignment.NAME_PROPERTY)
			.field(DoctorAssignment.UPDATE_TIME_PROPERTY)
			.field(DoctorAssignment.VERSION_PROPERTY)
		;
	}

	/** DoctorSchedule的简单属性序列化列表 */
	protected SerializeScope getDoctorScheduleSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(DoctorSchedule.ID_PROPERTY)
			.field(DoctorSchedule.NAME_PROPERTY)
			.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
			.field(DoctorSchedule.AVAILABLE_PROPERTY)
			.field(DoctorSchedule.PRICE_PROPERTY)
			.field(DoctorSchedule.CREATE_TIME_PROPERTY)
			.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
			.field(DoctorSchedule.VERSION_PROPERTY)
		;
	}

	/** MobileApp的简单属性序列化列表 */
	protected SerializeScope getMobileAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY)
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的简单属性序列化列表 */
	protected SerializeScope getPageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY)
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的简单属性序列化列表 */
	protected SerializeScope getPageTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY)
			.field(PageType.CODE_PROPERTY)
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的简单属性序列化列表 */
	protected SerializeScope getSlideSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.DISPLAY_ORDER_PROPERTY)
			.field(Slide.NAME_PROPERTY)
			.field(Slide.IMAGE_URL_PROPERTY)
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的简单属性序列化列表 */
	protected SerializeScope getUiActionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UiAction.ID_PROPERTY)
			.field(UiAction.CODE_PROPERTY)
			.field(UiAction.ICON_PROPERTY)
			.field(UiAction.TITLE_PROPERTY)
			.field(UiAction.BRIEF_PROPERTY)
			.field(UiAction.IMAGE_URL_PROPERTY)
			.field(UiAction.LINK_TO_URL_PROPERTY)
			.field(UiAction.EXTRA_DATA_PROPERTY)
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的简单属性序列化列表 */
	protected SerializeScope getSectionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY)
			.field(Section.BRIEF_PROPERTY)
			.field(Section.ICON_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.PAGE_PROPERTY)
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的简单属性序列化列表 */
	protected SerializeScope getUserDomainSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY)
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的简单属性序列化列表 */
	protected SerializeScope getUserWhiteListSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY)
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的简单属性序列化列表 */
	protected SerializeScope getSecUserSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY)
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的简单属性序列化列表 */
	protected SerializeScope getUserAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY)
			.field(UserApp.APP_ICON_PROPERTY)
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的简单属性序列化列表 */
	protected SerializeScope getQuickLinkSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY)
			.field(QuickLink.ICON_PROPERTY)
			.field(QuickLink.IMAGE_PATH_PROPERTY)
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的简单属性序列化列表 */
	protected SerializeScope getListAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY)
			.field(ListAccess.INTERNAL_NAME_PROPERTY)
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的简单属性序列化列表 */
	protected SerializeScope getObjectAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY)
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的简单属性序列化列表 */
	protected SerializeScope getLoginHistorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY)
			.field(LoginHistory.DESCRIPTION_PROPERTY)
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的简单属性序列化列表 */
	protected SerializeScope getGenericFormSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY)
			.field(GenericForm.DESCRIPTION_PROPERTY)
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的简单属性序列化列表 */
	protected SerializeScope getFormMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY)
			.field(FormMessage.LEVEL_PROPERTY)
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的简单属性序列化列表 */
	protected SerializeScope getFormFieldMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY)
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的简单属性序列化列表 */
	protected SerializeScope getFormFieldSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY)
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY)
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的简单属性序列化列表 */
	protected SerializeScope getFormActionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY)
			.field(FormAction.LOCALE_KEY_PROPERTY)
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的简单属性序列化列表 */
	protected SerializeScope getCandidateContainerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY)
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的简单属性序列化列表 */
	protected SerializeScope getCandidateElementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY)
			.field(CandidateElement.TYPE_PROPERTY)
			.field(CandidateElement.IMAGE_PROPERTY)
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatWorkappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
			.field(WechatWorkappIdentify.USER_ID_PROPERTY)
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatMiniappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
			.field(WechatMiniappIdentify.APP_ID_PROPERTY)
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** TreeNode的简单属性序列化列表 */
	protected SerializeScope getTreeNodeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY)
			.field(TreeNode.NODE_TYPE_PROPERTY)
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	/** Hospital的ListOf时需要序列化的属性列表 */
	protected SerializeScope getHospitalListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='上和医院';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='address';
		//	type='string';
		//	value='毕升路22号';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Hospital.ID_PROPERTY)
			.field(Hospital.NAME_PROPERTY).as("title")
			.field(Hospital.ADDRESS_PROPERTY).as("brief").with_prefix("地址: ")
			.field(Hospital.TELEPHONE_PROPERTY)
			.field(Hospital.VERSION_PROPERTY)
		;
	}

	/** ExpenseType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getExpenseTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='诊疗费|治疗费|检查费';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string_longtext';
		//	value='text()';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ExpenseType.ID_PROPERTY)
			.field(ExpenseType.NAME_PROPERTY).as("title")
			.field(ExpenseType.HELPER_CHARS_PROPERTY)
			.field(ExpenseType.STATUS_PROPERTY)
			.field(ExpenseType.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(ExpenseType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(ExpenseType.UPDATE_TIME_PROPERTY)
			.field(ExpenseType.VERSION_PROPERTY)
		;
	}

	/** Period的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPeriodListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='上午|下午|夜班';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='MORNING|AFTERNOON|NIGHT';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Period.ID_PROPERTY)
			.field(Period.NAME_PROPERTY).as("title")
			.field(Period.CODE_PROPERTY).as("brief").with_prefix("代码: ")
			.field(Period.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(Period.VERSION_PROPERTY)
		;
	}

	/** ExpenseItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getExpenseItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='专家诊疗费|血常规|煎药费';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='price';
		//	type='money';
		//	value='$99999999999.00';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ExpenseItem.ID_PROPERTY)
			.field(ExpenseItem.NAME_PROPERTY).as("title")
			.field(ExpenseItem.PRICE_PROPERTY).as("brief").with_prefix("价格: ")
			.field(ExpenseItem.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
			.field(ExpenseItem.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(ExpenseItem.UPDATE_TIME_PROPERTY)
			.field(ExpenseItem.VERSION_PROPERTY)
		;
	}

	/** Doctor的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDoctorListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='魏松全';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='update_time';
		//	type='date_time_update';
		//	value='updateTime()';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='shot_image';
		//	type='string_image';
		//	value='snap.shot-400-300-red.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Doctor.ID_PROPERTY)
			.field(Doctor.NAME_PROPERTY).as("title")
			.field(Doctor.SHOT_IMAGE_PROPERTY).as("imageUrl")
			.field(Doctor.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(Doctor.UPDATE_TIME_PROPERTY).as("brief").with_prefix("更新时间: ")
			.field(Doctor.VERSION_PROPERTY)
		;
	}

	/** Department的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='放射科';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='update_time';
		//	type='date_time_update';
		//	value='updateTime()';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Department.ID_PROPERTY)
			.field(Department.NAME_PROPERTY).as("title")
			.field(Department.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(Department.UPDATE_TIME_PROPERTY).as("brief").with_prefix("更新时间: ")
			.field(Department.VERSION_PROPERTY)
		;
	}

	/** DoctorAssignment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDoctorAssignmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='魏松全在内分泌科室上';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='update_time';
		//	type='date_time_update';
		//	value='updateTime()';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(DoctorAssignment.ID_PROPERTY)
			.field(DoctorAssignment.NAME_PROPERTY).as("title")
			.field(DoctorAssignment.DOCTOR_PROPERTY, getDoctorSummaryScope())
			.field(DoctorAssignment.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
			.field(DoctorAssignment.UPDATE_TIME_PROPERTY).as("brief").with_prefix("更新时间: ")
			.field(DoctorAssignment.VERSION_PROPERTY)
		;
	}

	/** DoctorSchedule的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDoctorScheduleListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='2019年3月11日魏松全在内分泌科坐班收诊疗费,每个10';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='price';
		//	type='money';
		//	value='$123.99';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(DoctorSchedule.ID_PROPERTY)
			.field(DoctorSchedule.NAME_PROPERTY).as("title")
			.field(DoctorSchedule.DOCTOR_PROPERTY, getDoctorSummaryScope())
			.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
			.field(DoctorSchedule.PERIOD_PROPERTY, getPeriodSummaryScope())
			.field(DoctorSchedule.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
			.field(DoctorSchedule.AVAILABLE_PROPERTY)
			.field(DoctorSchedule.PRICE_PROPERTY).as("brief").with_prefix("价格: ")
			.field(DoctorSchedule.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
			.field(DoctorSchedule.CREATE_TIME_PROPERTY)
			.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
			.field(DoctorSchedule.HOSPITAL_PROPERTY, getHospitalSummaryScope())
			.field(DoctorSchedule.VERSION_PROPERTY)
		;
	}

	/** MobileApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMobileAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='移动端配置';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY).as("title")
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='page_title';
		//	type='string';
		//	value='首页';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='page_type';
		//	type='page_type';
		//	value='$(object)';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY).as("title")
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.PAGE_TYPE_PROPERTY, SerializeScope.INCLUDE()
				.field(PageType.NAME_PROPERTY).as("brief").with_prefix("页面类型: ")
					).move_up()
			.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='首页|我的|Generic Page|Listof Page|功能大厅|普通';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='home|me|generic-page|listof-page|service-center|simple';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY).as("title")
			.field(PageType.CODE_PROPERTY).as("brief").with_prefix("编码: ")
			.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSlideListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='首页Focus的内容';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='display_order';
		//	type='int';
		//	value='1|2|3';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url';
		//	type='string_image';
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.DISPLAY_ORDER_PROPERTY).as("brief").with_prefix("顺序: ")
			.field(Slide.NAME_PROPERTY).as("title")
			.field(Slide.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUiActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='提交|分享|查看|更多';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='brief';
		//	type='string';
		//	value='Submit|Share|View|View More';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url';
		//	type='string_image';
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UiAction.ID_PROPERTY)
			.field(UiAction.CODE_PROPERTY)
			.field(UiAction.ICON_PROPERTY)
			.field(UiAction.TITLE_PROPERTY).as("title")
			.field(UiAction.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(UiAction.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(UiAction.LINK_TO_URL_PROPERTY)
			.field(UiAction.EXTRA_DATA_PROPERTY)
			.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSectionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='文章|作品';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='brief';
		//	type='string';
		//	value='Article|Artwork';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY).as("title")
			.field(Section.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(Section.ICON_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.PAGE_PROPERTY)
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserDomainListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='用户区域';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY).as("title")
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserWhiteListListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='user_identity';
		//	type='string';
		//	value='clariones|13808188512';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_special_functions';
		//	type='string';
		//	value='tester;ios-spokesperson';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY).as("title")
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY).as("brief").with_prefix("用户特殊功能: ")
			.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSecUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='login';
		//	type='string';
		//	value='login';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='verification_code';
		//	type='int';
		//	value='0|9999999';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY).as("title")
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY).as("brief").with_prefix("验证码: ")
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='审车平台|账户管理|接车公司|审车公司|维修公司|顾客';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_icon';
		//	type='string';
		//	value='users|bank|wechat|bar-chart|user|users';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY).as("title")
			.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(UserApp.APP_ICON_PROPERTY).as("brief").with_prefix("应用程序图标: ")
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的ListOf时需要序列化的属性列表 */
	protected SerializeScope getQuickLinkListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='icon';
		//	type='string';
		//	value='facebook|google';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='y-200-200-red.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY).as("title")
			.field(QuickLink.ICON_PROPERTY).as("brief").with_prefix("图标: ")
			.field(QuickLink.IMAGE_PATH_PROPERTY).as("imageUrl")
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getListAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='internal_name';
		//	type='string';
		//	value='levelOneCategoryList';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY).as("title")
			.field(ListAccess.INTERNAL_NAME_PROPERTY).as("brief").with_prefix("内部名称: ")
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getObjectAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='控制访问列表1';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='object_type';
		//	type='string';
		//	value='FranchiseeStoreCountryCenter|AccountSet';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY).as("title")
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY).as("brief").with_prefix("访问对象类型: ")
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLoginHistoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='from_ip';
		//	type='string';
		//	value='192.168.1.1|192.168.1.2';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='登陆成功';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY).as("title")
			.field(LoginHistory.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGenericFormListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='登记输入单';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY).as("title")
			.field(GenericForm.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='字段组合错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='level';
		//	type='string';
		//	value='success|info|warning|danger';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY).as("title")
			.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormMessage.LEVEL_PROPERTY).as("brief").with_prefix("水平: ")
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='输入错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY).as("title")
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY).as("brief").with_prefix("参数名称: ")
			.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY).as("title")
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='label';
		//	type='string';
		//	value='功能';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='locale_key';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY).as("title")
			.field(FormAction.LOCALE_KEY_PROPERTY).as("brief").with_prefix("语言环境的关键: ")
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateContainerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='我只是一个容器';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY).as("title")
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateElementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='搜索到的匹配字段';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='类型描述';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image';
		//	type='string_image';
		//	value='1.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY).as("title")
			.field(CandidateElement.TYPE_PROPERTY).as("brief").with_prefix("类型: ")
			.field(CandidateElement.IMAGE_PROPERTY).as("imageUrl")
			.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatWorkappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='corp_id';
		//	type='string';
		//	value='corporation123';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_id';
		//	type='string';
		//	value='user123';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY).as("title")
			.field(WechatWorkappIdentify.USER_ID_PROPERTY).as("brief").with_prefix("用户Id: ")
			.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatMiniappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='open_id';
		//	type='string';
		//	value='wechat_open_id_1234567890';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_id';
		//	type='string';
		//	value='wechat_miniapp_id_1234567890';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY).as("title")
			.field(WechatMiniappIdentify.APP_ID_PROPERTY).as("brief").with_prefix("应用程序Id: ")
			.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** TreeNode的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTreeNodeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='node_id';
		//	type='string';
		//	value='node000001';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='node_type';
		//	type='string';
		//	value='nodetype';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(HisBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY).as("title")
			.field(TreeNode.NODE_TYPE_PROPERTY).as("brief").with_prefix("节点类型: ")
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	
	public SerializeScope getListOfViewScope(String listClassName, String ownerClassName) {
		return scopes.get(listClassName);
	}
	
	
	protected Map<String, SerializeScope> scopes;
	protected void initAllViewScope() {
		scopes = new HashMap<>();
		scopes.put(Hospital.class.getName(),getHospitalListOfViewScope());
		scopes.put(ExpenseType.class.getName(),getExpenseTypeListOfViewScope());
		scopes.put(Period.class.getName(),getPeriodListOfViewScope());
		scopes.put(ExpenseItem.class.getName(),getExpenseItemListOfViewScope());
		scopes.put(Doctor.class.getName(),getDoctorListOfViewScope());
		scopes.put(Department.class.getName(),getDepartmentListOfViewScope());
		scopes.put(DoctorAssignment.class.getName(),getDoctorAssignmentListOfViewScope());
		scopes.put(DoctorSchedule.class.getName(),getDoctorScheduleListOfViewScope());
		scopes.put(MobileApp.class.getName(),getMobileAppListOfViewScope());
		scopes.put(Page.class.getName(),getPageListOfViewScope());
		scopes.put(PageType.class.getName(),getPageTypeListOfViewScope());
		scopes.put(Slide.class.getName(),getSlideListOfViewScope());
		scopes.put(UiAction.class.getName(),getUiActionListOfViewScope());
		scopes.put(Section.class.getName(),getSectionListOfViewScope());
		scopes.put(UserDomain.class.getName(),getUserDomainListOfViewScope());
		scopes.put(UserWhiteList.class.getName(),getUserWhiteListListOfViewScope());
		scopes.put(SecUser.class.getName(),getSecUserListOfViewScope());
		scopes.put(UserApp.class.getName(),getUserAppListOfViewScope());
		scopes.put(QuickLink.class.getName(),getQuickLinkListOfViewScope());
		scopes.put(ListAccess.class.getName(),getListAccessListOfViewScope());
		scopes.put(ObjectAccess.class.getName(),getObjectAccessListOfViewScope());
		scopes.put(LoginHistory.class.getName(),getLoginHistoryListOfViewScope());
		scopes.put(GenericForm.class.getName(),getGenericFormListOfViewScope());
		scopes.put(FormMessage.class.getName(),getFormMessageListOfViewScope());
		scopes.put(FormFieldMessage.class.getName(),getFormFieldMessageListOfViewScope());
		scopes.put(FormField.class.getName(),getFormFieldListOfViewScope());
		scopes.put(FormAction.class.getName(),getFormActionListOfViewScope());
		scopes.put(CandidateContainer.class.getName(),getCandidateContainerListOfViewScope());
		scopes.put(CandidateElement.class.getName(),getCandidateElementListOfViewScope());
		scopes.put(WechatWorkappIdentify.class.getName(),getWechatWorkappIdentifyListOfViewScope());
		scopes.put(WechatMiniappIdentify.class.getName(),getWechatMiniappIdentifyListOfViewScope());
		scopes.put(TreeNode.class.getName(),getTreeNodeListOfViewScope());
	}

}
















