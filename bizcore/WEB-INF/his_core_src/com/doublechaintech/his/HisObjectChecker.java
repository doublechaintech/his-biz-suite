package com.doublechaintech.his;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;

public class HisObjectChecker extends HisChecker{
	public HisChecker checkHospitalAsObject(BaseEntity hospitalAsBaseEntity){

		checkIdOfHospital((String)hospitalAsBaseEntity.propertyOf("id"));
		checkNameOfHospital((String)hospitalAsBaseEntity.propertyOf("name"));
		checkAddressOfHospital((String)hospitalAsBaseEntity.propertyOf("address"));
		checkTelephoneOfHospital((String)hospitalAsBaseEntity.propertyOf("telephone"));
		checkVersionOfHospital((int)hospitalAsBaseEntity.propertyOf("version"));
		checkExpenseTypeListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("expenseTypeList"));
		checkPeriodListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("periodList"));
		checkExpenseItemListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("expenseItemList"));
		checkDoctorListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("doctorList"));
		checkDepartmentListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("departmentList"));
		checkDoctorScheduleListOfHospital((List<BaseEntity>)hospitalAsBaseEntity.propertyOf("doctorScheduleList"));
		return this;

	}

	public HisChecker checkExpenseTypeAsObject(BaseEntity expenseTypeAsBaseEntity){

		checkIdOfExpenseType((String)expenseTypeAsBaseEntity.propertyOf("id"));
		checkNameOfExpenseType((String)expenseTypeAsBaseEntity.propertyOf("name"));
		checkHelperCharsOfExpenseType((String)expenseTypeAsBaseEntity.propertyOf("helperChars"));
		checkStatusOfExpenseType((String)expenseTypeAsBaseEntity.propertyOf("status"));
		checkHospitalOfExpenseType((BaseEntity)expenseTypeAsBaseEntity.propertyOf("hospital"));
		checkDescriptionOfExpenseType((String)expenseTypeAsBaseEntity.propertyOf("description"));
		checkVersionOfExpenseType((int)expenseTypeAsBaseEntity.propertyOf("version"));
		checkExpenseItemListOfExpenseType((List<BaseEntity>)expenseTypeAsBaseEntity.propertyOf("expenseItemList"));
		checkDoctorScheduleListOfExpenseType((List<BaseEntity>)expenseTypeAsBaseEntity.propertyOf("doctorScheduleList"));
		return this;

	}

	public HisChecker checkPeriodAsObject(BaseEntity periodAsBaseEntity){

		checkIdOfPeriod((String)periodAsBaseEntity.propertyOf("id"));
		checkNameOfPeriod((String)periodAsBaseEntity.propertyOf("name"));
		checkHospitalOfPeriod((BaseEntity)periodAsBaseEntity.propertyOf("hospital"));
		checkVersionOfPeriod((int)periodAsBaseEntity.propertyOf("version"));
		checkDoctorScheduleListOfPeriod((List<BaseEntity>)periodAsBaseEntity.propertyOf("doctorScheduleList"));
		return this;

	}

	public HisChecker checkExpenseItemAsObject(BaseEntity expenseItemAsBaseEntity){

		checkIdOfExpenseItem((String)expenseItemAsBaseEntity.propertyOf("id"));
		checkNameOfExpenseItem((String)expenseItemAsBaseEntity.propertyOf("name"));
		checkPriceOfExpenseItem((BigDecimal)expenseItemAsBaseEntity.propertyOf("price"));
		checkExpenseTypeOfExpenseItem((BaseEntity)expenseItemAsBaseEntity.propertyOf("expenseType"));
		checkHospitalOfExpenseItem((BaseEntity)expenseItemAsBaseEntity.propertyOf("hospital"));
		checkVersionOfExpenseItem((int)expenseItemAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkDoctorAsObject(BaseEntity doctorAsBaseEntity){

		checkIdOfDoctor((String)doctorAsBaseEntity.propertyOf("id"));
		checkNameOfDoctor((String)doctorAsBaseEntity.propertyOf("name"));
		checkShotImageOfDoctor((String)doctorAsBaseEntity.propertyOf("shotImage"));
		checkHospitalOfDoctor((BaseEntity)doctorAsBaseEntity.propertyOf("hospital"));
		checkVersionOfDoctor((int)doctorAsBaseEntity.propertyOf("version"));
		checkDoctorAssignmentListOfDoctor((List<BaseEntity>)doctorAsBaseEntity.propertyOf("doctorAssignmentList"));
		checkDoctorScheduleListOfDoctor((List<BaseEntity>)doctorAsBaseEntity.propertyOf("doctorScheduleList"));
		return this;

	}

	public HisChecker checkDepartmentAsObject(BaseEntity departmentAsBaseEntity){

		checkIdOfDepartment((String)departmentAsBaseEntity.propertyOf("id"));
		checkNameOfDepartment((String)departmentAsBaseEntity.propertyOf("name"));
		checkHospitalOfDepartment((BaseEntity)departmentAsBaseEntity.propertyOf("hospital"));
		checkVersionOfDepartment((int)departmentAsBaseEntity.propertyOf("version"));
		checkDoctorAssignmentListOfDepartment((List<BaseEntity>)departmentAsBaseEntity.propertyOf("doctorAssignmentList"));
		checkDoctorScheduleListOfDepartment((List<BaseEntity>)departmentAsBaseEntity.propertyOf("doctorScheduleList"));
		return this;

	}

	public HisChecker checkDoctorAssignmentAsObject(BaseEntity doctorAssignmentAsBaseEntity){

		checkIdOfDoctorAssignment((String)doctorAssignmentAsBaseEntity.propertyOf("id"));
		checkNameOfDoctorAssignment((String)doctorAssignmentAsBaseEntity.propertyOf("name"));
		checkDoctorOfDoctorAssignment((BaseEntity)doctorAssignmentAsBaseEntity.propertyOf("doctor"));
		checkDepartmentOfDoctorAssignment((BaseEntity)doctorAssignmentAsBaseEntity.propertyOf("department"));
		checkVersionOfDoctorAssignment((int)doctorAssignmentAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkDoctorScheduleAsObject(BaseEntity doctorScheduleAsBaseEntity){

		checkIdOfDoctorSchedule((String)doctorScheduleAsBaseEntity.propertyOf("id"));
		checkNameOfDoctorSchedule((String)doctorScheduleAsBaseEntity.propertyOf("name"));
		checkDoctorOfDoctorSchedule((BaseEntity)doctorScheduleAsBaseEntity.propertyOf("doctor"));
		checkScheduleDateOfDoctorSchedule((Date)doctorScheduleAsBaseEntity.propertyOf("scheduleDate"));
		checkPeriodOfDoctorSchedule((BaseEntity)doctorScheduleAsBaseEntity.propertyOf("period"));
		checkDepartmentOfDoctorSchedule((BaseEntity)doctorScheduleAsBaseEntity.propertyOf("department"));
		checkAvailableOfDoctorSchedule((int)doctorScheduleAsBaseEntity.propertyOf("available"));
		checkPriceOfDoctorSchedule((BigDecimal)doctorScheduleAsBaseEntity.propertyOf("price"));
		checkExpenseTypeOfDoctorSchedule((BaseEntity)doctorScheduleAsBaseEntity.propertyOf("expenseType"));
		checkHospitalOfDoctorSchedule((BaseEntity)doctorScheduleAsBaseEntity.propertyOf("hospital"));
		checkVersionOfDoctorSchedule((int)doctorScheduleAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkUserDomainAsObject(BaseEntity userDomainAsBaseEntity){

		checkIdOfUserDomain((String)userDomainAsBaseEntity.propertyOf("id"));
		checkNameOfUserDomain((String)userDomainAsBaseEntity.propertyOf("name"));
		checkVersionOfUserDomain((int)userDomainAsBaseEntity.propertyOf("version"));
		checkUserWhiteListListOfUserDomain((List<BaseEntity>)userDomainAsBaseEntity.propertyOf("userWhiteListList"));
		checkSecUserListOfUserDomain((List<BaseEntity>)userDomainAsBaseEntity.propertyOf("secUserList"));
		return this;

	}

	public HisChecker checkUserWhiteListAsObject(BaseEntity userWhiteListAsBaseEntity){

		checkIdOfUserWhiteList((String)userWhiteListAsBaseEntity.propertyOf("id"));
		checkUserIdentityOfUserWhiteList((String)userWhiteListAsBaseEntity.propertyOf("userIdentity"));
		checkUserSpecialFunctionsOfUserWhiteList((String)userWhiteListAsBaseEntity.propertyOf("userSpecialFunctions"));
		checkDomainOfUserWhiteList((BaseEntity)userWhiteListAsBaseEntity.propertyOf("domain"));
		checkVersionOfUserWhiteList((int)userWhiteListAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkSecUserAsObject(BaseEntity secUserAsBaseEntity){

		checkIdOfSecUser((String)secUserAsBaseEntity.propertyOf("id"));
		checkLoginOfSecUser((String)secUserAsBaseEntity.propertyOf("login"));
		checkMobileOfSecUser((String)secUserAsBaseEntity.propertyOf("mobile"));
		checkEmailOfSecUser((String)secUserAsBaseEntity.propertyOf("email"));
		checkPwdOfSecUser((String)secUserAsBaseEntity.propertyOf("pwd"));
		checkWeixinOpenidOfSecUser((String)secUserAsBaseEntity.propertyOf("weixinOpenid"));
		checkWeixinAppidOfSecUser((String)secUserAsBaseEntity.propertyOf("weixinAppid"));
		checkAccessTokenOfSecUser((String)secUserAsBaseEntity.propertyOf("accessToken"));
		checkVerificationCodeOfSecUser((int)secUserAsBaseEntity.propertyOf("verificationCode"));
		checkVerificationCodeExpireOfSecUser((DateTime)secUserAsBaseEntity.propertyOf("verificationCodeExpire"));
		checkLastLoginTimeOfSecUser((DateTime)secUserAsBaseEntity.propertyOf("lastLoginTime"));
		checkDomainOfSecUser((BaseEntity)secUserAsBaseEntity.propertyOf("domain"));
		checkVersionOfSecUser((int)secUserAsBaseEntity.propertyOf("version"));
		checkUserAppListOfSecUser((List<BaseEntity>)secUserAsBaseEntity.propertyOf("userAppList"));
		checkLoginHistoryListOfSecUser((List<BaseEntity>)secUserAsBaseEntity.propertyOf("loginHistoryList"));
		return this;

	}

	public HisChecker checkSecUserBlockingAsObject(BaseEntity secUserBlockingAsBaseEntity){

		checkIdOfSecUserBlocking((String)secUserBlockingAsBaseEntity.propertyOf("id"));
		checkWhoOfSecUserBlocking((String)secUserBlockingAsBaseEntity.propertyOf("who"));
		checkCommentsOfSecUserBlocking((String)secUserBlockingAsBaseEntity.propertyOf("comments"));
		checkVersionOfSecUserBlocking((int)secUserBlockingAsBaseEntity.propertyOf("version"));
		checkSecUserListOfSecUserBlocking((List<BaseEntity>)secUserBlockingAsBaseEntity.propertyOf("secUserList"));
		return this;

	}

	public HisChecker checkUserAppAsObject(BaseEntity userAppAsBaseEntity){

		checkIdOfUserApp((String)userAppAsBaseEntity.propertyOf("id"));
		checkTitleOfUserApp((String)userAppAsBaseEntity.propertyOf("title"));
		checkSecUserOfUserApp((BaseEntity)userAppAsBaseEntity.propertyOf("secUser"));
		checkAppIconOfUserApp((String)userAppAsBaseEntity.propertyOf("appIcon"));
		checkFullAccessOfUserApp((boolean)userAppAsBaseEntity.propertyOf("fullAccess"));
		checkPermissionOfUserApp((String)userAppAsBaseEntity.propertyOf("permission"));
		checkObjectTypeOfUserApp((String)userAppAsBaseEntity.propertyOf("objectType"));
		checkObjectIdOfUserApp((String)userAppAsBaseEntity.propertyOf("objectId"));
		checkLocationOfUserApp((String)userAppAsBaseEntity.propertyOf("location"));
		checkVersionOfUserApp((int)userAppAsBaseEntity.propertyOf("version"));
		checkListAccessListOfUserApp((List<BaseEntity>)userAppAsBaseEntity.propertyOf("listAccessList"));
		checkObjectAccessListOfUserApp((List<BaseEntity>)userAppAsBaseEntity.propertyOf("objectAccessList"));
		return this;

	}

	public HisChecker checkListAccessAsObject(BaseEntity listAccessAsBaseEntity){

		checkIdOfListAccess((String)listAccessAsBaseEntity.propertyOf("id"));
		checkNameOfListAccess((String)listAccessAsBaseEntity.propertyOf("name"));
		checkInternalNameOfListAccess((String)listAccessAsBaseEntity.propertyOf("internalName"));
		checkReadPermissionOfListAccess((boolean)listAccessAsBaseEntity.propertyOf("readPermission"));
		checkCreatePermissionOfListAccess((boolean)listAccessAsBaseEntity.propertyOf("createPermission"));
		checkDeletePermissionOfListAccess((boolean)listAccessAsBaseEntity.propertyOf("deletePermission"));
		checkUpdatePermissionOfListAccess((boolean)listAccessAsBaseEntity.propertyOf("updatePermission"));
		checkExecutionPermissionOfListAccess((boolean)listAccessAsBaseEntity.propertyOf("executionPermission"));
		checkAppOfListAccess((BaseEntity)listAccessAsBaseEntity.propertyOf("app"));
		checkVersionOfListAccess((int)listAccessAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkObjectAccessAsObject(BaseEntity objectAccessAsBaseEntity){

		checkIdOfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("id"));
		checkNameOfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("name"));
		checkObjectTypeOfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("objectType"));
		checkList1OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list1"));
		checkList2OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list2"));
		checkList3OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list3"));
		checkList4OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list4"));
		checkList5OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list5"));
		checkList6OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list6"));
		checkList7OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list7"));
		checkList8OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list8"));
		checkList9OfObjectAccess((String)objectAccessAsBaseEntity.propertyOf("list9"));
		checkAppOfObjectAccess((BaseEntity)objectAccessAsBaseEntity.propertyOf("app"));
		checkVersionOfObjectAccess((int)objectAccessAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkLoginHistoryAsObject(BaseEntity loginHistoryAsBaseEntity){

		checkIdOfLoginHistory((String)loginHistoryAsBaseEntity.propertyOf("id"));
		checkFromIpOfLoginHistory((String)loginHistoryAsBaseEntity.propertyOf("fromIp"));
		checkDescriptionOfLoginHistory((String)loginHistoryAsBaseEntity.propertyOf("description"));
		checkSecUserOfLoginHistory((BaseEntity)loginHistoryAsBaseEntity.propertyOf("secUser"));
		checkVersionOfLoginHistory((int)loginHistoryAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkGenericFormAsObject(BaseEntity genericFormAsBaseEntity){

		checkIdOfGenericForm((String)genericFormAsBaseEntity.propertyOf("id"));
		checkTitleOfGenericForm((String)genericFormAsBaseEntity.propertyOf("title"));
		checkDescriptionOfGenericForm((String)genericFormAsBaseEntity.propertyOf("description"));
		checkVersionOfGenericForm((int)genericFormAsBaseEntity.propertyOf("version"));
		checkFormMessageListOfGenericForm((List<BaseEntity>)genericFormAsBaseEntity.propertyOf("formMessageList"));
		checkFormFieldMessageListOfGenericForm((List<BaseEntity>)genericFormAsBaseEntity.propertyOf("formFieldMessageList"));
		checkFormFieldListOfGenericForm((List<BaseEntity>)genericFormAsBaseEntity.propertyOf("formFieldList"));
		checkFormActionListOfGenericForm((List<BaseEntity>)genericFormAsBaseEntity.propertyOf("formActionList"));
		return this;

	}

	public HisChecker checkFormMessageAsObject(BaseEntity formMessageAsBaseEntity){

		checkIdOfFormMessage((String)formMessageAsBaseEntity.propertyOf("id"));
		checkTitleOfFormMessage((String)formMessageAsBaseEntity.propertyOf("title"));
		checkFormOfFormMessage((BaseEntity)formMessageAsBaseEntity.propertyOf("form"));
		checkLevelOfFormMessage((String)formMessageAsBaseEntity.propertyOf("level"));
		checkVersionOfFormMessage((int)formMessageAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkFormFieldMessageAsObject(BaseEntity formFieldMessageAsBaseEntity){

		checkIdOfFormFieldMessage((String)formFieldMessageAsBaseEntity.propertyOf("id"));
		checkTitleOfFormFieldMessage((String)formFieldMessageAsBaseEntity.propertyOf("title"));
		checkParameterNameOfFormFieldMessage((String)formFieldMessageAsBaseEntity.propertyOf("parameterName"));
		checkFormOfFormFieldMessage((BaseEntity)formFieldMessageAsBaseEntity.propertyOf("form"));
		checkLevelOfFormFieldMessage((String)formFieldMessageAsBaseEntity.propertyOf("level"));
		checkVersionOfFormFieldMessage((int)formFieldMessageAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkFormFieldAsObject(BaseEntity formFieldAsBaseEntity){

		checkIdOfFormField((String)formFieldAsBaseEntity.propertyOf("id"));
		checkLabelOfFormField((String)formFieldAsBaseEntity.propertyOf("label"));
		checkLocaleKeyOfFormField((String)formFieldAsBaseEntity.propertyOf("localeKey"));
		checkParameterNameOfFormField((String)formFieldAsBaseEntity.propertyOf("parameterName"));
		checkTypeOfFormField((String)formFieldAsBaseEntity.propertyOf("type"));
		checkFormOfFormField((BaseEntity)formFieldAsBaseEntity.propertyOf("form"));
		checkPlaceholderOfFormField((String)formFieldAsBaseEntity.propertyOf("placeholder"));
		checkDefaultValueOfFormField((String)formFieldAsBaseEntity.propertyOf("defaultValue"));
		checkDescriptionOfFormField((String)formFieldAsBaseEntity.propertyOf("description"));
		checkFieldGroupOfFormField((String)formFieldAsBaseEntity.propertyOf("fieldGroup"));
		checkMinimumValueOfFormField((String)formFieldAsBaseEntity.propertyOf("minimumValue"));
		checkMaximumValueOfFormField((String)formFieldAsBaseEntity.propertyOf("maximumValue"));
		checkRequiredOfFormField((boolean)formFieldAsBaseEntity.propertyOf("required"));
		checkDisabledOfFormField((boolean)formFieldAsBaseEntity.propertyOf("disabled"));
		checkCustomRenderingOfFormField((boolean)formFieldAsBaseEntity.propertyOf("customRendering"));
		checkCandidateValuesOfFormField((String)formFieldAsBaseEntity.propertyOf("candidateValues"));
		checkSuggestValuesOfFormField((String)formFieldAsBaseEntity.propertyOf("suggestValues"));
		checkVersionOfFormField((int)formFieldAsBaseEntity.propertyOf("version"));
		return this;

	}

	public HisChecker checkFormActionAsObject(BaseEntity formActionAsBaseEntity){

		checkIdOfFormAction((String)formActionAsBaseEntity.propertyOf("id"));
		checkLabelOfFormAction((String)formActionAsBaseEntity.propertyOf("label"));
		checkLocaleKeyOfFormAction((String)formActionAsBaseEntity.propertyOf("localeKey"));
		checkActionKeyOfFormAction((String)formActionAsBaseEntity.propertyOf("actionKey"));
		checkLevelOfFormAction((String)formActionAsBaseEntity.propertyOf("level"));
		checkUrlOfFormAction((String)formActionAsBaseEntity.propertyOf("url"));
		checkFormOfFormAction((BaseEntity)formActionAsBaseEntity.propertyOf("form"));
		checkVersionOfFormAction((int)formActionAsBaseEntity.propertyOf("version"));
		return this;

	}


	public HisChecker checkExpenseTypeListOfHospital(List<BaseEntity> expenseTypeList){
		expenseTypeList.stream().map(expenseType->this.checkExpenseTypeAsObject(expenseType));
		return this;
	}

	public HisChecker checkPeriodListOfHospital(List<BaseEntity> periodList){
		periodList.stream().map(period->this.checkPeriodAsObject(period));
		return this;
	}

	public HisChecker checkExpenseItemListOfHospital(List<BaseEntity> expenseItemList){
		expenseItemList.stream().map(expenseItem->this.checkExpenseItemAsObject(expenseItem));
		return this;
	}

	public HisChecker checkDoctorListOfHospital(List<BaseEntity> doctorList){
		doctorList.stream().map(doctor->this.checkDoctorAsObject(doctor));
		return this;
	}

	public HisChecker checkDepartmentListOfHospital(List<BaseEntity> departmentList){
		departmentList.stream().map(department->this.checkDepartmentAsObject(department));
		return this;
	}

	public HisChecker checkDoctorScheduleListOfHospital(List<BaseEntity> doctorScheduleList){
		doctorScheduleList.stream().map(doctorSchedule->this.checkDoctorScheduleAsObject(doctorSchedule));
		return this;
	}

	public HisChecker checkExpenseItemListOfExpenseType(List<BaseEntity> expenseItemList){
		expenseItemList.stream().map(expenseItem->this.checkExpenseItemAsObject(expenseItem));
		return this;
	}

	public HisChecker checkDoctorScheduleListOfExpenseType(List<BaseEntity> doctorScheduleList){
		doctorScheduleList.stream().map(doctorSchedule->this.checkDoctorScheduleAsObject(doctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_EXPENSE_TYPE = "expense_type.hospital";


	public HisChecker checkHospitalOfExpenseType(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_EXPENSE_TYPE);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public HisChecker checkDoctorScheduleListOfPeriod(List<BaseEntity> doctorScheduleList){
		doctorScheduleList.stream().map(doctorSchedule->this.checkDoctorScheduleAsObject(doctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_PERIOD = "period.hospital";


	public HisChecker checkHospitalOfPeriod(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_PERIOD);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public static final String EXPENSE_TYPE_OF_EXPENSE_ITEM = "expense_item.expense_type";


	public HisChecker checkExpenseTypeOfExpenseItem(BaseEntity expenseTypeAsBaseEntity){

		if(expenseTypeAsBaseEntity == null){
			checkBaseEntityReference(expenseTypeAsBaseEntity,true,EXPENSE_TYPE_OF_EXPENSE_ITEM);
			return this;
		}
		checkExpenseTypeAsObject(expenseTypeAsBaseEntity);
		return this;
	}


	public static final String HOSPITAL_OF_EXPENSE_ITEM = "expense_item.hospital";


	public HisChecker checkHospitalOfExpenseItem(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_EXPENSE_ITEM);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public HisChecker checkDoctorAssignmentListOfDoctor(List<BaseEntity> doctorAssignmentList){
		doctorAssignmentList.stream().map(doctorAssignment->this.checkDoctorAssignmentAsObject(doctorAssignment));
		return this;
	}

	public HisChecker checkDoctorScheduleListOfDoctor(List<BaseEntity> doctorScheduleList){
		doctorScheduleList.stream().map(doctorSchedule->this.checkDoctorScheduleAsObject(doctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_DOCTOR = "doctor.hospital";


	public HisChecker checkHospitalOfDoctor(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DOCTOR);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public HisChecker checkDoctorAssignmentListOfDepartment(List<BaseEntity> doctorAssignmentList){
		doctorAssignmentList.stream().map(doctorAssignment->this.checkDoctorAssignmentAsObject(doctorAssignment));
		return this;
	}

	public HisChecker checkDoctorScheduleListOfDepartment(List<BaseEntity> doctorScheduleList){
		doctorScheduleList.stream().map(doctorSchedule->this.checkDoctorScheduleAsObject(doctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_DEPARTMENT = "department.hospital";


	public HisChecker checkHospitalOfDepartment(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DEPARTMENT);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public static final String DOCTOR_OF_DOCTOR_ASSIGNMENT = "doctor_assignment.doctor";


	public HisChecker checkDoctorOfDoctorAssignment(BaseEntity doctorAsBaseEntity){

		if(doctorAsBaseEntity == null){
			checkBaseEntityReference(doctorAsBaseEntity,true,DOCTOR_OF_DOCTOR_ASSIGNMENT);
			return this;
		}
		checkDoctorAsObject(doctorAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_DOCTOR_ASSIGNMENT = "doctor_assignment.department";


	public HisChecker checkDepartmentOfDoctorAssignment(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_DOCTOR_ASSIGNMENT);
			return this;
		}
		checkDepartmentAsObject(departmentAsBaseEntity);
		return this;
	}


	public static final String DOCTOR_OF_DOCTOR_SCHEDULE = "doctor_schedule.doctor";


	public HisChecker checkDoctorOfDoctorSchedule(BaseEntity doctorAsBaseEntity){

		if(doctorAsBaseEntity == null){
			checkBaseEntityReference(doctorAsBaseEntity,true,DOCTOR_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkDoctorAsObject(doctorAsBaseEntity);
		return this;
	}


	public static final String PERIOD_OF_DOCTOR_SCHEDULE = "doctor_schedule.period";


	public HisChecker checkPeriodOfDoctorSchedule(BaseEntity periodAsBaseEntity){

		if(periodAsBaseEntity == null){
			checkBaseEntityReference(periodAsBaseEntity,true,PERIOD_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkPeriodAsObject(periodAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_DOCTOR_SCHEDULE = "doctor_schedule.department";


	public HisChecker checkDepartmentOfDoctorSchedule(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkDepartmentAsObject(departmentAsBaseEntity);
		return this;
	}


	public static final String EXPENSE_TYPE_OF_DOCTOR_SCHEDULE = "doctor_schedule.expense_type";


	public HisChecker checkExpenseTypeOfDoctorSchedule(BaseEntity expenseTypeAsBaseEntity){

		if(expenseTypeAsBaseEntity == null){
			checkBaseEntityReference(expenseTypeAsBaseEntity,true,EXPENSE_TYPE_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkExpenseTypeAsObject(expenseTypeAsBaseEntity);
		return this;
	}


	public static final String HOSPITAL_OF_DOCTOR_SCHEDULE = "doctor_schedule.hospital";


	public HisChecker checkHospitalOfDoctorSchedule(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkHospitalAsObject(hospitalAsBaseEntity);
		return this;
	}


	public HisChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		userWhiteListList.stream().map(userWhiteList->this.checkUserWhiteListAsObject(userWhiteList));
		return this;
	}

	public HisChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		secUserList.stream().map(secUser->this.checkSecUserAsObject(secUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public HisChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkUserDomainAsObject(domainAsBaseEntity);
		return this;
	}


	public HisChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		userAppList.stream().map(userApp->this.checkUserAppAsObject(userApp));
		return this;
	}

	public HisChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		loginHistoryList.stream().map(loginHistory->this.checkLoginHistoryAsObject(loginHistory));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public HisChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkUserDomainAsObject(domainAsBaseEntity);
		return this;
	}


	public static final String BLOCKING_OF_SEC_USER = "sec_user.blocking";


	public HisChecker checkBlockingOfSecUser(BaseEntity blockingAsBaseEntity){

		if(blockingAsBaseEntity == null){
			checkBaseEntityReference(blockingAsBaseEntity,true,BLOCKING_OF_SEC_USER);
			return this;
		}
		checkSecUserBlockingAsObject(blockingAsBaseEntity);
		return this;
	}


	public HisChecker checkSecUserListOfSecUserBlocking(List<BaseEntity> secUserList){
		secUserList.stream().map(secUser->this.checkSecUserAsObject(secUser));
		return this;
	}

	public HisChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		listAccessList.stream().map(listAccess->this.checkListAccessAsObject(listAccess));
		return this;
	}

	public HisChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		objectAccessList.stream().map(objectAccess->this.checkObjectAccessAsObject(objectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public HisChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkSecUserAsObject(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public HisChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkUserAppAsObject(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public HisChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkUserAppAsObject(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public HisChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkSecUserAsObject(secUserAsBaseEntity);
		return this;
	}


	public HisChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		formMessageList.stream().map(formMessage->this.checkFormMessageAsObject(formMessage));
		return this;
	}

	public HisChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		formFieldMessageList.stream().map(formFieldMessage->this.checkFormFieldMessageAsObject(formFieldMessage));
		return this;
	}

	public HisChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		formFieldList.stream().map(formField->this.checkFormFieldAsObject(formField));
		return this;
	}

	public HisChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		formActionList.stream().map(formAction->this.checkFormActionAsObject(formAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public HisChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkGenericFormAsObject(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public HisChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkGenericFormAsObject(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public HisChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkGenericFormAsObject(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public HisChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkGenericFormAsObject(formAsBaseEntity);
		return this;
	}


}

