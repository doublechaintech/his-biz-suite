package com.doublechaintech.his;


import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.secuserblocking.SecUserBlocking;
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


public class HisBaseViewScope {

	protected static SerializeScope HospitalBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Hospital.ID_PROPERTY)
		.field(Hospital.NAME_PROPERTY)
		.field(Hospital.ADDRESS_PROPERTY)
		.field(Hospital.TELEPHONE_PROPERTY)
		;
	/** 用于Hospital的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHospitalSummaryScope() {
		return HospitalBaseSummaryScope;
	}

	protected static SerializeScope ExpenseTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseType.ID_PROPERTY)
		.field(ExpenseType.NAME_PROPERTY)
		.field(ExpenseType.HELPER_CHARS_PROPERTY)
		.field(ExpenseType.STATUS_PROPERTY)
		.field(ExpenseType.DESCRIPTION_PROPERTY)
		.field(ExpenseType.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExpenseTypeSummaryScope() {
		return ExpenseTypeBaseSummaryScope;
	}

	protected static SerializeScope PeriodBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Period.ID_PROPERTY)
		.field(Period.NAME_PROPERTY)
		.field(Period.CODE_PROPERTY)
		;
	/** 用于Period的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPeriodSummaryScope() {
		return PeriodBaseSummaryScope;
	}

	protected static SerializeScope ExpenseItemBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseItem.ID_PROPERTY)
		.field(ExpenseItem.NAME_PROPERTY)
		.field(ExpenseItem.PRICE_PROPERTY)
		.field(ExpenseItem.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseItem的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExpenseItemSummaryScope() {
		return ExpenseItemBaseSummaryScope;
	}

	protected static SerializeScope DoctorBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Doctor.ID_PROPERTY)
		.field(Doctor.NAME_PROPERTY)
		.field(Doctor.SHOT_IMAGE_PROPERTY)
		.field(Doctor.UPDATE_TIME_PROPERTY)
		;
	/** 用于Doctor的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorSummaryScope() {
		return DoctorBaseSummaryScope;
	}

	protected static SerializeScope DepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Department.ID_PROPERTY)
		.field(Department.NAME_PROPERTY)
		.field(Department.UPDATE_TIME_PROPERTY)
		;
	/** 用于Department的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDepartmentSummaryScope() {
		return DepartmentBaseSummaryScope;
	}

	protected static SerializeScope DoctorAssignmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorAssignment.ID_PROPERTY)
		.field(DoctorAssignment.NAME_PROPERTY)
		.field(DoctorAssignment.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorAssignment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorAssignmentSummaryScope() {
		return DoctorAssignmentBaseSummaryScope;
	}

	protected static SerializeScope DoctorScheduleBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorSchedule.ID_PROPERTY)
		.field(DoctorSchedule.NAME_PROPERTY)
		.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
		.field(DoctorSchedule.AVAILABLE_PROPERTY)
		.field(DoctorSchedule.PRICE_PROPERTY)
		.field(DoctorSchedule.CREATE_TIME_PROPERTY)
		.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorSchedule的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorScheduleSummaryScope() {
		return DoctorScheduleBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
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
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope SecUserBlockingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSummaryScope() {
		return SecUserBlockingBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope ObjectAccessBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于ObjectAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSummaryScope() {
		return ObjectAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope GenericFormBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSummaryScope() {
		return GenericFormBaseSummaryScope;
	}

	protected static SerializeScope FormMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSummaryScope() {
		return FormMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSummaryScope() {
		return FormFieldMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FormField的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSummaryScope() {
		return FormFieldBaseSummaryScope;
	}

	protected static SerializeScope FormActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionSummaryScope() {
		return FormActionBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope HospitalBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Hospital.ID_PROPERTY)
		.field(Hospital.NAME_PROPERTY)
		.field(Hospital.ADDRESS_PROPERTY)
		.field(Hospital.TELEPHONE_PROPERTY)
		;
	/** 用于Hospital的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHospitalSecondaryListItemScope() {
		return HospitalBaseSecondaryListItemScope;
	}

	protected static SerializeScope ExpenseTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseType.ID_PROPERTY)
		.field(ExpenseType.NAME_PROPERTY)
		.field(ExpenseType.HELPER_CHARS_PROPERTY)
		.field(ExpenseType.STATUS_PROPERTY)
		.field(ExpenseType.DESCRIPTION_PROPERTY)
		.field(ExpenseType.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExpenseTypeSecondaryListItemScope() {
		return ExpenseTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope PeriodBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Period.ID_PROPERTY)
		.field(Period.NAME_PROPERTY)
		.field(Period.CODE_PROPERTY)
		;
	/** 用于Period的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPeriodSecondaryListItemScope() {
		return PeriodBaseSecondaryListItemScope;
	}

	protected static SerializeScope ExpenseItemBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseItem.ID_PROPERTY)
		.field(ExpenseItem.NAME_PROPERTY)
		.field(ExpenseItem.PRICE_PROPERTY)
		.field(ExpenseItem.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseItem的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExpenseItemSecondaryListItemScope() {
		return ExpenseItemBaseSecondaryListItemScope;
	}

	protected static SerializeScope DoctorBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Doctor.ID_PROPERTY)
		.field(Doctor.NAME_PROPERTY)
		.field(Doctor.SHOT_IMAGE_PROPERTY)
		.field(Doctor.UPDATE_TIME_PROPERTY)
		;
	/** 用于Doctor的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorSecondaryListItemScope() {
		return DoctorBaseSecondaryListItemScope;
	}

	protected static SerializeScope DepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Department.ID_PROPERTY)
		.field(Department.NAME_PROPERTY)
		.field(Department.UPDATE_TIME_PROPERTY)
		;
	/** 用于Department的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDepartmentSecondaryListItemScope() {
		return DepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope DoctorAssignmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorAssignment.ID_PROPERTY)
		.field(DoctorAssignment.NAME_PROPERTY)
		.field(DoctorAssignment.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorAssignment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorAssignmentSecondaryListItemScope() {
		return DoctorAssignmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope DoctorScheduleBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorSchedule.ID_PROPERTY)
		.field(DoctorSchedule.NAME_PROPERTY)
		.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
		.field(DoctorSchedule.AVAILABLE_PROPERTY)
		.field(DoctorSchedule.PRICE_PROPERTY)
		.field(DoctorSchedule.CREATE_TIME_PROPERTY)
		.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorSchedule的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorScheduleSecondaryListItemScope() {
		return DoctorScheduleBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSecondaryListItemScope() {
		return SecUserBlockingBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于ObjectAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSecondaryListItemScope() {
		return ObjectAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope GenericFormBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSecondaryListItemScope() {
		return GenericFormBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSecondaryListItemScope() {
		return FormMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSecondaryListItemScope() {
		return FormFieldMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FormField的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSecondaryListItemScope() {
		return FormFieldBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionSecondaryListItemScope() {
		return FormActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope HospitalBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Hospital.ID_PROPERTY)
		.field(Hospital.NAME_PROPERTY)
		.field(Hospital.ADDRESS_PROPERTY)
		.field(Hospital.TELEPHONE_PROPERTY)
		.field(Hospital.EXPENSE_TYPE_LIST, getExpenseTypeSecondaryListItemScope())
		.field(Hospital.PERIOD_LIST, getPeriodSecondaryListItemScope())
		.field(Hospital.EXPENSE_ITEM_LIST, getExpenseItemSecondaryListItemScope())
		.field(Hospital.DOCTOR_LIST, getDoctorSecondaryListItemScope())
		.field(Hospital.DEPARTMENT_LIST, getDepartmentSecondaryListItemScope())
		.field(Hospital.DOCTOR_SCHEDULE_LIST, getDoctorScheduleSecondaryListItemScope())
		;
	/** 用于Hospital对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHospitalListItemScope() {
		return HospitalBaseListItemScope;
	}

	protected static SerializeScope ExpenseTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseType.ID_PROPERTY)
		.field(ExpenseType.NAME_PROPERTY)
		.field(ExpenseType.HELPER_CHARS_PROPERTY)
		.field(ExpenseType.STATUS_PROPERTY)
		.field(ExpenseType.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(ExpenseType.DESCRIPTION_PROPERTY)
		.field(ExpenseType.UPDATE_TIME_PROPERTY)
		.field(ExpenseType.EXPENSE_ITEM_LIST, getExpenseItemSecondaryListItemScope())
		.field(ExpenseType.DOCTOR_SCHEDULE_LIST, getDoctorScheduleSecondaryListItemScope())
		;
	/** 用于ExpenseType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExpenseTypeListItemScope() {
		return ExpenseTypeBaseListItemScope;
	}

	protected static SerializeScope PeriodBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Period.ID_PROPERTY)
		.field(Period.NAME_PROPERTY)
		.field(Period.CODE_PROPERTY)
		.field(Period.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Period.DOCTOR_SCHEDULE_LIST, getDoctorScheduleSecondaryListItemScope())
		;
	/** 用于Period对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPeriodListItemScope() {
		return PeriodBaseListItemScope;
	}

	protected static SerializeScope ExpenseItemBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseItem.ID_PROPERTY)
		.field(ExpenseItem.NAME_PROPERTY)
		.field(ExpenseItem.PRICE_PROPERTY)
		.field(ExpenseItem.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
		.field(ExpenseItem.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(ExpenseItem.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseItem对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExpenseItemListItemScope() {
		return ExpenseItemBaseListItemScope;
	}

	protected static SerializeScope DoctorBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Doctor.ID_PROPERTY)
		.field(Doctor.NAME_PROPERTY)
		.field(Doctor.SHOT_IMAGE_PROPERTY)
		.field(Doctor.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Doctor.UPDATE_TIME_PROPERTY)
		.field(Doctor.DOCTOR_ASSIGNMENT_LIST, getDoctorAssignmentSecondaryListItemScope())
		.field(Doctor.DOCTOR_SCHEDULE_LIST, getDoctorScheduleSecondaryListItemScope())
		;
	/** 用于Doctor对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorListItemScope() {
		return DoctorBaseListItemScope;
	}

	protected static SerializeScope DepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Department.ID_PROPERTY)
		.field(Department.NAME_PROPERTY)
		.field(Department.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Department.UPDATE_TIME_PROPERTY)
		.field(Department.DOCTOR_ASSIGNMENT_LIST, getDoctorAssignmentSecondaryListItemScope())
		.field(Department.DOCTOR_SCHEDULE_LIST, getDoctorScheduleSecondaryListItemScope())
		;
	/** 用于Department对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDepartmentListItemScope() {
		return DepartmentBaseListItemScope;
	}

	protected static SerializeScope DoctorAssignmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorAssignment.ID_PROPERTY)
		.field(DoctorAssignment.NAME_PROPERTY)
		.field(DoctorAssignment.DOCTOR_PROPERTY, getDoctorSummaryScope())
		.field(DoctorAssignment.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
		.field(DoctorAssignment.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorAssignment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorAssignmentListItemScope() {
		return DoctorAssignmentBaseListItemScope;
	}

	protected static SerializeScope DoctorScheduleBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorSchedule.ID_PROPERTY)
		.field(DoctorSchedule.NAME_PROPERTY)
		.field(DoctorSchedule.DOCTOR_PROPERTY, getDoctorSummaryScope())
		.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
		.field(DoctorSchedule.PERIOD_PROPERTY, getPeriodSummaryScope())
		.field(DoctorSchedule.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
		.field(DoctorSchedule.AVAILABLE_PROPERTY)
		.field(DoctorSchedule.PRICE_PROPERTY)
		.field(DoctorSchedule.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
		.field(DoctorSchedule.CREATE_TIME_PROPERTY)
		.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
		.field(DoctorSchedule.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		;
	/** 用于DoctorSchedule对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDoctorScheduleListItemScope() {
		return DoctorScheduleBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于SecUserBlocking对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingListItemScope() {
		return SecUserBlockingBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessListItemScope() {
		return ObjectAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope GenericFormBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldSecondaryListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionSecondaryListItemScope())
		;
	/** 用于GenericForm对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormListItemScope() {
		return GenericFormBaseListItemScope;
	}

	protected static SerializeScope FormMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageListItemScope() {
		return FormMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageListItemScope() {
		return FormFieldMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
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
		;
	/** 用于FormField对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldListItemScope() {
		return FormFieldBaseListItemScope;
	}

	protected static SerializeScope FormActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionListItemScope() {
		return FormActionBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope HospitalBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Hospital.ID_PROPERTY)
		.field(Hospital.NAME_PROPERTY)
		.field(Hospital.ADDRESS_PROPERTY)
		.field(Hospital.TELEPHONE_PROPERTY)
		.field(Hospital.EXPENSE_TYPE_LIST, getExpenseTypeListItemScope())
		.field(Hospital.PERIOD_LIST, getPeriodListItemScope())
		.field(Hospital.EXPENSE_ITEM_LIST, getExpenseItemListItemScope())
		.field(Hospital.DOCTOR_LIST, getDoctorListItemScope())
		.field(Hospital.DEPARTMENT_LIST, getDepartmentListItemScope())
		.field(Hospital.DOCTOR_SCHEDULE_LIST, getDoctorScheduleListItemScope())
		;
	/** 用于Hospital对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHospitalDetailScope() {
		return HospitalBaseDetailScope;
	}

	protected static SerializeScope ExpenseTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseType.ID_PROPERTY)
		.field(ExpenseType.NAME_PROPERTY)
		.field(ExpenseType.HELPER_CHARS_PROPERTY)
		.field(ExpenseType.STATUS_PROPERTY)
		.field(ExpenseType.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(ExpenseType.DESCRIPTION_PROPERTY)
		.field(ExpenseType.UPDATE_TIME_PROPERTY)
		.field(ExpenseType.EXPENSE_ITEM_LIST, getExpenseItemListItemScope())
		.field(ExpenseType.DOCTOR_SCHEDULE_LIST, getDoctorScheduleListItemScope())
		;
	/** 用于ExpenseType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExpenseTypeDetailScope() {
		return ExpenseTypeBaseDetailScope;
	}

	protected static SerializeScope PeriodBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Period.ID_PROPERTY)
		.field(Period.NAME_PROPERTY)
		.field(Period.CODE_PROPERTY)
		.field(Period.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Period.DOCTOR_SCHEDULE_LIST, getDoctorScheduleListItemScope())
		;
	/** 用于Period对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPeriodDetailScope() {
		return PeriodBaseDetailScope;
	}

	protected static SerializeScope ExpenseItemBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ExpenseItem.ID_PROPERTY)
		.field(ExpenseItem.NAME_PROPERTY)
		.field(ExpenseItem.PRICE_PROPERTY)
		.field(ExpenseItem.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
		.field(ExpenseItem.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(ExpenseItem.UPDATE_TIME_PROPERTY)
		;
	/** 用于ExpenseItem对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExpenseItemDetailScope() {
		return ExpenseItemBaseDetailScope;
	}

	protected static SerializeScope DoctorBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Doctor.ID_PROPERTY)
		.field(Doctor.NAME_PROPERTY)
		.field(Doctor.SHOT_IMAGE_PROPERTY)
		.field(Doctor.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Doctor.UPDATE_TIME_PROPERTY)
		.field(Doctor.DOCTOR_ASSIGNMENT_LIST, getDoctorAssignmentListItemScope())
		.field(Doctor.DOCTOR_SCHEDULE_LIST, getDoctorScheduleListItemScope())
		;
	/** 用于Doctor对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorDetailScope() {
		return DoctorBaseDetailScope;
	}

	protected static SerializeScope DepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(Department.ID_PROPERTY)
		.field(Department.NAME_PROPERTY)
		.field(Department.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		.field(Department.UPDATE_TIME_PROPERTY)
		.field(Department.DOCTOR_ASSIGNMENT_LIST, getDoctorAssignmentListItemScope())
		.field(Department.DOCTOR_SCHEDULE_LIST, getDoctorScheduleListItemScope())
		;
	/** 用于Department对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDepartmentDetailScope() {
		return DepartmentBaseDetailScope;
	}

	protected static SerializeScope DoctorAssignmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorAssignment.ID_PROPERTY)
		.field(DoctorAssignment.NAME_PROPERTY)
		.field(DoctorAssignment.DOCTOR_PROPERTY, getDoctorSummaryScope())
		.field(DoctorAssignment.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
		.field(DoctorAssignment.UPDATE_TIME_PROPERTY)
		;
	/** 用于DoctorAssignment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorAssignmentDetailScope() {
		return DoctorAssignmentBaseDetailScope;
	}

	protected static SerializeScope DoctorScheduleBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(DoctorSchedule.ID_PROPERTY)
		.field(DoctorSchedule.NAME_PROPERTY)
		.field(DoctorSchedule.DOCTOR_PROPERTY, getDoctorSummaryScope())
		.field(DoctorSchedule.SCHEDULE_DATE_PROPERTY)
		.field(DoctorSchedule.PERIOD_PROPERTY, getPeriodSummaryScope())
		.field(DoctorSchedule.DEPARTMENT_PROPERTY, getDepartmentSummaryScope())
		.field(DoctorSchedule.AVAILABLE_PROPERTY)
		.field(DoctorSchedule.PRICE_PROPERTY)
		.field(DoctorSchedule.EXPENSE_TYPE_PROPERTY, getExpenseTypeSummaryScope())
		.field(DoctorSchedule.CREATE_TIME_PROPERTY)
		.field(DoctorSchedule.UPDATE_TIME_PROPERTY)
		.field(DoctorSchedule.HOSPITAL_PROPERTY, getHospitalSummaryScope())
		;
	/** 用于DoctorSchedule对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDoctorScheduleDetailScope() {
		return DoctorScheduleBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope SecUserBlockingBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于SecUserBlocking对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingDetailScope() {
		return SecUserBlockingBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope ObjectAccessBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessDetailScope() {
		return ObjectAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope GenericFormBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionListItemScope())
		;
	/** 用于GenericForm对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormDetailScope() {
		return GenericFormBaseDetailScope;
	}

	protected static SerializeScope FormMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageDetailScope() {
		return FormMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageDetailScope() {
		return FormFieldMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
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
		;
	/** 用于FormField对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldDetailScope() {
		return FormFieldBaseDetailScope;
	}

	protected static SerializeScope FormActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionDetailScope() {
		return FormActionBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(HisBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	

}






