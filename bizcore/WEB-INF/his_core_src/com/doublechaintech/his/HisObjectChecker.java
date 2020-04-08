package com.doublechaintech.his;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class HisObjectChecker extends HisChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		HisChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		HisObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> HisObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> HisObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  HisChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public HisObjectChecker checkAndFixHospital(BaseEntity hospitalAsBaseEntity){

		if( isChecked(hospitalAsBaseEntity) ){
			return this;
		}
		markAsChecked(hospitalAsBaseEntity);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"id",this::checkIdOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"name",this::checkNameOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"address",this::checkAddressOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"telephone",this::checkTelephoneOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"version",this::checkVersionOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"expenseTypeList",this::checkExpenseTypeListOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"periodList",this::checkPeriodListOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"expenseItemList",this::checkExpenseItemListOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"doctorList",this::checkDoctorListOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"departmentList",this::checkDepartmentListOfHospital);
		commonObjectPropertyCheck(hospitalAsBaseEntity,"doctorScheduleList",this::checkDoctorScheduleListOfHospital);
		return this;

	}

	public HisObjectChecker checkAndFixExpenseType(BaseEntity expenseTypeAsBaseEntity){

		if( isChecked(expenseTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(expenseTypeAsBaseEntity);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"id",this::checkIdOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"name",this::checkNameOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"helperChars",this::checkHelperCharsOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"status",this::checkStatusOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"hospital",this::checkHospitalOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"description",this::checkDescriptionOfExpenseType);
		commonObjectPropertyAssign(expenseTypeAsBaseEntity,"updateTime",this::assignUpdateTimeOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"version",this::checkVersionOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"expenseItemList",this::checkExpenseItemListOfExpenseType);
		commonObjectPropertyCheck(expenseTypeAsBaseEntity,"doctorScheduleList",this::checkDoctorScheduleListOfExpenseType);
		return this;

	}

	public HisObjectChecker checkAndFixPeriod(BaseEntity periodAsBaseEntity){

		if( isChecked(periodAsBaseEntity) ){
			return this;
		}
		markAsChecked(periodAsBaseEntity);
		commonObjectPropertyCheck(periodAsBaseEntity,"id",this::checkIdOfPeriod);
		commonObjectPropertyCheck(periodAsBaseEntity,"name",this::checkNameOfPeriod);
		commonObjectPropertyCheck(periodAsBaseEntity,"code",this::checkCodeOfPeriod);
		commonObjectPropertyCheck(periodAsBaseEntity,"hospital",this::checkHospitalOfPeriod);
		commonObjectPropertyCheck(periodAsBaseEntity,"version",this::checkVersionOfPeriod);
		commonObjectPropertyCheck(periodAsBaseEntity,"doctorScheduleList",this::checkDoctorScheduleListOfPeriod);
		return this;

	}

	public HisObjectChecker checkAndFixExpenseItem(BaseEntity expenseItemAsBaseEntity){

		if( isChecked(expenseItemAsBaseEntity) ){
			return this;
		}
		markAsChecked(expenseItemAsBaseEntity);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"id",this::checkIdOfExpenseItem);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"name",this::checkNameOfExpenseItem);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"price",this::checkPriceOfExpenseItem);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"expenseType",this::checkExpenseTypeOfExpenseItem);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"hospital",this::checkHospitalOfExpenseItem);
		commonObjectPropertyAssign(expenseItemAsBaseEntity,"updateTime",this::assignUpdateTimeOfExpenseItem);
		commonObjectPropertyCheck(expenseItemAsBaseEntity,"version",this::checkVersionOfExpenseItem);
		return this;

	}

	public HisObjectChecker checkAndFixDoctor(BaseEntity doctorAsBaseEntity){

		if( isChecked(doctorAsBaseEntity) ){
			return this;
		}
		markAsChecked(doctorAsBaseEntity);
		commonObjectPropertyCheck(doctorAsBaseEntity,"id",this::checkIdOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"name",this::checkNameOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"shotImage",this::checkShotImageOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"hospital",this::checkHospitalOfDoctor);
		commonObjectPropertyAssign(doctorAsBaseEntity,"updateTime",this::assignUpdateTimeOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"version",this::checkVersionOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"doctorAssignmentList",this::checkDoctorAssignmentListOfDoctor);
		commonObjectPropertyCheck(doctorAsBaseEntity,"doctorScheduleList",this::checkDoctorScheduleListOfDoctor);
		return this;

	}

	public HisObjectChecker checkAndFixDepartment(BaseEntity departmentAsBaseEntity){

		if( isChecked(departmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(departmentAsBaseEntity);
		commonObjectPropertyCheck(departmentAsBaseEntity,"id",this::checkIdOfDepartment);
		commonObjectPropertyCheck(departmentAsBaseEntity,"name",this::checkNameOfDepartment);
		commonObjectPropertyCheck(departmentAsBaseEntity,"hospital",this::checkHospitalOfDepartment);
		commonObjectPropertyAssign(departmentAsBaseEntity,"updateTime",this::assignUpdateTimeOfDepartment);
		commonObjectPropertyCheck(departmentAsBaseEntity,"version",this::checkVersionOfDepartment);
		commonObjectPropertyCheck(departmentAsBaseEntity,"doctorAssignmentList",this::checkDoctorAssignmentListOfDepartment);
		commonObjectPropertyCheck(departmentAsBaseEntity,"doctorScheduleList",this::checkDoctorScheduleListOfDepartment);
		return this;

	}

	public HisObjectChecker checkAndFixDoctorAssignment(BaseEntity doctorAssignmentAsBaseEntity){

		if( isChecked(doctorAssignmentAsBaseEntity) ){
			return this;
		}
		markAsChecked(doctorAssignmentAsBaseEntity);
		commonObjectPropertyCheck(doctorAssignmentAsBaseEntity,"id",this::checkIdOfDoctorAssignment);
		commonObjectPropertyCheck(doctorAssignmentAsBaseEntity,"name",this::checkNameOfDoctorAssignment);
		commonObjectPropertyCheck(doctorAssignmentAsBaseEntity,"doctor",this::checkDoctorOfDoctorAssignment);
		commonObjectPropertyCheck(doctorAssignmentAsBaseEntity,"department",this::checkDepartmentOfDoctorAssignment);
		commonObjectPropertyAssign(doctorAssignmentAsBaseEntity,"updateTime",this::assignUpdateTimeOfDoctorAssignment);
		commonObjectPropertyCheck(doctorAssignmentAsBaseEntity,"version",this::checkVersionOfDoctorAssignment);
		return this;

	}

	public HisObjectChecker checkAndFixDoctorSchedule(BaseEntity doctorScheduleAsBaseEntity){

		if( isChecked(doctorScheduleAsBaseEntity) ){
			return this;
		}
		markAsChecked(doctorScheduleAsBaseEntity);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"id",this::checkIdOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"name",this::checkNameOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"doctor",this::checkDoctorOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"scheduleDate",this::checkScheduleDateOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"period",this::checkPeriodOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"department",this::checkDepartmentOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"available",this::checkAvailableOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"price",this::checkPriceOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"expenseType",this::checkExpenseTypeOfDoctorSchedule);
		commonObjectPropertyAssign(doctorScheduleAsBaseEntity,"createTime",this::assignCreateTimeOfDoctorSchedule);
		commonObjectPropertyAssign(doctorScheduleAsBaseEntity,"updateTime",this::assignUpdateTimeOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"hospital",this::checkHospitalOfDoctorSchedule);
		commonObjectPropertyCheck(doctorScheduleAsBaseEntity,"version",this::checkVersionOfDoctorSchedule);
		return this;

	}

	public HisObjectChecker checkAndFixMobileApp(BaseEntity mobileAppAsBaseEntity){

		if( isChecked(mobileAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(mobileAppAsBaseEntity);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"id",this::checkIdOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"name",this::checkNameOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"version",this::checkVersionOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageList",this::checkPageListOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageTypeList",this::checkPageTypeListOfMobileApp);
		return this;

	}

	public HisObjectChecker checkAndFixPage(BaseEntity pageAsBaseEntity){

		if( isChecked(pageAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageAsBaseEntity);
		commonObjectPropertyCheck(pageAsBaseEntity,"id",this::checkIdOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageTitle",this::checkPageTitleOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageType",this::checkPageTypeOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"mobileApp",this::checkMobileAppOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"version",this::checkVersionOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"slideList",this::checkSlideListOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"uiActionList",this::checkUiActionListOfPage);
		return this;

	}

	public HisObjectChecker checkAndFixPageType(BaseEntity pageTypeAsBaseEntity){

		if( isChecked(pageTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageTypeAsBaseEntity);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"id",this::checkIdOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"name",this::checkNameOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"code",this::checkCodeOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"mobileApp",this::checkMobileAppOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"footerTab",this::checkFooterTabOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"version",this::checkVersionOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"pageList",this::checkPageListOfPageType);
		return this;

	}

	public HisObjectChecker checkAndFixSlide(BaseEntity slideAsBaseEntity){

		if( isChecked(slideAsBaseEntity) ){
			return this;
		}
		markAsChecked(slideAsBaseEntity);
		commonObjectPropertyCheck(slideAsBaseEntity,"id",this::checkIdOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"displayOrder",this::checkDisplayOrderOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"name",this::checkNameOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"imageUrl",this::checkImageUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"videoUrl",this::checkVideoUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"page",this::checkPageOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"version",this::checkVersionOfSlide);
		return this;

	}

	public HisObjectChecker checkAndFixUiAction(BaseEntity uiActionAsBaseEntity){

		if( isChecked(uiActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(uiActionAsBaseEntity);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"id",this::checkIdOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"code",this::checkCodeOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"icon",this::checkIconOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"title",this::checkTitleOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"brief",this::checkBriefOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"imageUrl",this::checkImageUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"extraData",this::checkExtraDataOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"page",this::checkPageOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"version",this::checkVersionOfUiAction);
		return this;

	}

	public HisObjectChecker checkAndFixSection(BaseEntity sectionAsBaseEntity){

		if( isChecked(sectionAsBaseEntity) ){
			return this;
		}
		markAsChecked(sectionAsBaseEntity);
		commonObjectPropertyCheck(sectionAsBaseEntity,"id",this::checkIdOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"title",this::checkTitleOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"brief",this::checkBriefOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"icon",this::checkIconOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"viewGroup",this::checkViewGroupOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"page",this::checkPageOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"version",this::checkVersionOfSection);
		return this;

	}

	public HisObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public HisObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public HisObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatWorkappIdentifyList",this::checkWechatWorkappIdentifyListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatMiniappIdentifyList",this::checkWechatMiniappIdentifyListOfSecUser);
		return this;

	}

	public HisObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public HisObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public HisObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public HisObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public HisObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public HisObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public HisObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public HisObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public HisObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public HisObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public HisObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public HisObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}

	public HisObjectChecker checkAndFixWechatWorkappIdentify(BaseEntity wechatWorkappIdentifyAsBaseEntity){

		if( isChecked(wechatWorkappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatWorkappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"id",this::checkIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"corpId",this::checkCorpIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"userId",this::checkUserIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatWorkappIdentify);
		commonObjectPropertyAssign(wechatWorkappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatWorkappIdentify);
		return this;

	}

	public HisObjectChecker checkAndFixWechatMiniappIdentify(BaseEntity wechatMiniappIdentifyAsBaseEntity){

		if( isChecked(wechatMiniappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatMiniappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"id",this::checkIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"openId",this::checkOpenIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"appId",this::checkAppIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatMiniappIdentify);
		commonObjectPropertyAssign(wechatMiniappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatMiniappIdentify);
		return this;

	}

	public HisObjectChecker checkAndFixTreeNode(BaseEntity treeNodeAsBaseEntity){

		if( isChecked(treeNodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(treeNodeAsBaseEntity);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"id",this::checkIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeId",this::checkNodeIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeType",this::checkNodeTypeOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"leftValue",this::checkLeftValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"rightValue",this::checkRightValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"version",this::checkVersionOfTreeNode);
		return this;

	}


	public HisObjectChecker checkExpenseTypeListOfHospital(List<BaseEntity> expenseTypeList){
		AtomicInteger index = new AtomicInteger();
		expenseTypeList.stream().forEach(expenseType->
			commonObjectElementCheck(expenseType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExpenseType));
		return this;
	}

	public HisObjectChecker checkPeriodListOfHospital(List<BaseEntity> periodList){
		AtomicInteger index = new AtomicInteger();
		periodList.stream().forEach(period->
			commonObjectElementCheck(period,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPeriod));
		return this;
	}

	public HisObjectChecker checkExpenseItemListOfHospital(List<BaseEntity> expenseItemList){
		AtomicInteger index = new AtomicInteger();
		expenseItemList.stream().forEach(expenseItem->
			commonObjectElementCheck(expenseItem,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExpenseItem));
		return this;
	}

	public HisObjectChecker checkDoctorListOfHospital(List<BaseEntity> doctorList){
		AtomicInteger index = new AtomicInteger();
		doctorList.stream().forEach(doctor->
			commonObjectElementCheck(doctor,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctor));
		return this;
	}

	public HisObjectChecker checkDepartmentListOfHospital(List<BaseEntity> departmentList){
		AtomicInteger index = new AtomicInteger();
		departmentList.stream().forEach(department->
			commonObjectElementCheck(department,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDepartment));
		return this;
	}

	public HisObjectChecker checkDoctorScheduleListOfHospital(List<BaseEntity> doctorScheduleList){
		AtomicInteger index = new AtomicInteger();
		doctorScheduleList.stream().forEach(doctorSchedule->
			commonObjectElementCheck(doctorSchedule,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorSchedule));
		return this;
	}

	public HisObjectChecker checkExpenseItemListOfExpenseType(List<BaseEntity> expenseItemList){
		AtomicInteger index = new AtomicInteger();
		expenseItemList.stream().forEach(expenseItem->
			commonObjectElementCheck(expenseItem,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExpenseItem));
		return this;
	}

	public HisObjectChecker checkDoctorScheduleListOfExpenseType(List<BaseEntity> doctorScheduleList){
		AtomicInteger index = new AtomicInteger();
		doctorScheduleList.stream().forEach(doctorSchedule->
			commonObjectElementCheck(doctorSchedule,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_EXPENSE_TYPE = "expense_type.hospital";


	public HisObjectChecker checkHospitalOfExpenseType(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_EXPENSE_TYPE);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkDoctorScheduleListOfPeriod(List<BaseEntity> doctorScheduleList){
		AtomicInteger index = new AtomicInteger();
		doctorScheduleList.stream().forEach(doctorSchedule->
			commonObjectElementCheck(doctorSchedule,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_PERIOD = "period.hospital";


	public HisObjectChecker checkHospitalOfPeriod(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_PERIOD);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public static final String EXPENSE_TYPE_OF_EXPENSE_ITEM = "expense_item.expense_type";


	public HisObjectChecker checkExpenseTypeOfExpenseItem(BaseEntity expenseTypeAsBaseEntity){

		if(expenseTypeAsBaseEntity == null){
			checkBaseEntityReference(expenseTypeAsBaseEntity,true,EXPENSE_TYPE_OF_EXPENSE_ITEM);
			return this;
		}
		checkAndFixExpenseType(expenseTypeAsBaseEntity);
		return this;
	}


	public static final String HOSPITAL_OF_EXPENSE_ITEM = "expense_item.hospital";


	public HisObjectChecker checkHospitalOfExpenseItem(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_EXPENSE_ITEM);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkDoctorAssignmentListOfDoctor(List<BaseEntity> doctorAssignmentList){
		AtomicInteger index = new AtomicInteger();
		doctorAssignmentList.stream().forEach(doctorAssignment->
			commonObjectElementCheck(doctorAssignment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorAssignment));
		return this;
	}

	public HisObjectChecker checkDoctorScheduleListOfDoctor(List<BaseEntity> doctorScheduleList){
		AtomicInteger index = new AtomicInteger();
		doctorScheduleList.stream().forEach(doctorSchedule->
			commonObjectElementCheck(doctorSchedule,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_DOCTOR = "doctor.hospital";


	public HisObjectChecker checkHospitalOfDoctor(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DOCTOR);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkDoctorAssignmentListOfDepartment(List<BaseEntity> doctorAssignmentList){
		AtomicInteger index = new AtomicInteger();
		doctorAssignmentList.stream().forEach(doctorAssignment->
			commonObjectElementCheck(doctorAssignment,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorAssignment));
		return this;
	}

	public HisObjectChecker checkDoctorScheduleListOfDepartment(List<BaseEntity> doctorScheduleList){
		AtomicInteger index = new AtomicInteger();
		doctorScheduleList.stream().forEach(doctorSchedule->
			commonObjectElementCheck(doctorSchedule,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDoctorSchedule));
		return this;
	}

	public static final String HOSPITAL_OF_DEPARTMENT = "department.hospital";


	public HisObjectChecker checkHospitalOfDepartment(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DEPARTMENT);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public static final String DOCTOR_OF_DOCTOR_ASSIGNMENT = "doctor_assignment.doctor";


	public HisObjectChecker checkDoctorOfDoctorAssignment(BaseEntity doctorAsBaseEntity){

		if(doctorAsBaseEntity == null){
			checkBaseEntityReference(doctorAsBaseEntity,true,DOCTOR_OF_DOCTOR_ASSIGNMENT);
			return this;
		}
		checkAndFixDoctor(doctorAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_DOCTOR_ASSIGNMENT = "doctor_assignment.department";


	public HisObjectChecker checkDepartmentOfDoctorAssignment(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_DOCTOR_ASSIGNMENT);
			return this;
		}
		checkAndFixDepartment(departmentAsBaseEntity);
		return this;
	}


	public static final String DOCTOR_OF_DOCTOR_SCHEDULE = "doctor_schedule.doctor";


	public HisObjectChecker checkDoctorOfDoctorSchedule(BaseEntity doctorAsBaseEntity){

		if(doctorAsBaseEntity == null){
			checkBaseEntityReference(doctorAsBaseEntity,true,DOCTOR_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkAndFixDoctor(doctorAsBaseEntity);
		return this;
	}


	public static final String PERIOD_OF_DOCTOR_SCHEDULE = "doctor_schedule.period";


	public HisObjectChecker checkPeriodOfDoctorSchedule(BaseEntity periodAsBaseEntity){

		if(periodAsBaseEntity == null){
			checkBaseEntityReference(periodAsBaseEntity,true,PERIOD_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkAndFixPeriod(periodAsBaseEntity);
		return this;
	}


	public static final String DEPARTMENT_OF_DOCTOR_SCHEDULE = "doctor_schedule.department";


	public HisObjectChecker checkDepartmentOfDoctorSchedule(BaseEntity departmentAsBaseEntity){

		if(departmentAsBaseEntity == null){
			checkBaseEntityReference(departmentAsBaseEntity,true,DEPARTMENT_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkAndFixDepartment(departmentAsBaseEntity);
		return this;
	}


	public static final String EXPENSE_TYPE_OF_DOCTOR_SCHEDULE = "doctor_schedule.expense_type";


	public HisObjectChecker checkExpenseTypeOfDoctorSchedule(BaseEntity expenseTypeAsBaseEntity){

		if(expenseTypeAsBaseEntity == null){
			checkBaseEntityReference(expenseTypeAsBaseEntity,true,EXPENSE_TYPE_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkAndFixExpenseType(expenseTypeAsBaseEntity);
		return this;
	}


	public static final String HOSPITAL_OF_DOCTOR_SCHEDULE = "doctor_schedule.hospital";


	public HisObjectChecker checkHospitalOfDoctorSchedule(BaseEntity hospitalAsBaseEntity){

		if(hospitalAsBaseEntity == null){
			checkBaseEntityReference(hospitalAsBaseEntity,true,HOSPITAL_OF_DOCTOR_SCHEDULE);
			return this;
		}
		checkAndFixHospital(hospitalAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkPageListOfMobileApp(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public HisObjectChecker checkPageTypeListOfMobileApp(List<BaseEntity> pageTypeList){
		AtomicInteger index = new AtomicInteger();
		pageTypeList.stream().forEach(pageType->
			commonObjectElementCheck(pageType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPageType));
		return this;
	}

	public HisObjectChecker checkSlideListOfPage(List<BaseEntity> slideList){
		AtomicInteger index = new AtomicInteger();
		slideList.stream().forEach(slide->
			commonObjectElementCheck(slide,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSlide));
		return this;
	}

	public HisObjectChecker checkUiActionListOfPage(List<BaseEntity> uiActionList){
		AtomicInteger index = new AtomicInteger();
		uiActionList.stream().forEach(uiAction->
			commonObjectElementCheck(uiAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUiAction));
		return this;
	}

	public static final String PAGE_TYPE_OF_PAGE = "page.page_type";


	public HisObjectChecker checkPageTypeOfPage(BaseEntity pageTypeAsBaseEntity){

		if(pageTypeAsBaseEntity == null){
			checkBaseEntityReference(pageTypeAsBaseEntity,true,PAGE_TYPE_OF_PAGE);
			return this;
		}
		checkAndFixPageType(pageTypeAsBaseEntity);
		return this;
	}


	public static final String MOBILE_APP_OF_PAGE = "page.mobile_app";


	public HisObjectChecker checkMobileAppOfPage(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkPageListOfPageType(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public static final String MOBILE_APP_OF_PAGE_TYPE = "page_type.mobile_app";


	public HisObjectChecker checkMobileAppOfPageType(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE_TYPE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SLIDE = "slide.page";


	public HisObjectChecker checkPageOfSlide(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SLIDE);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_UI_ACTION = "ui_action.page";


	public HisObjectChecker checkPageOfUiAction(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_UI_ACTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public HisObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public HisObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public HisObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public HisObjectChecker checkWechatWorkappIdentifyListOfSecUser(List<BaseEntity> wechatWorkappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentifyList.stream().forEach(wechatWorkappIdentify->
			commonObjectElementCheck(wechatWorkappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentify));
		return this;
	}

	public HisObjectChecker checkWechatMiniappIdentifyListOfSecUser(List<BaseEntity> wechatMiniappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentifyList.stream().forEach(wechatMiniappIdentify->
			commonObjectElementCheck(wechatMiniappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentify));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public HisObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public HisObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public HisObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public HisObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public HisObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public HisObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public HisObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public HisObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public HisObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public HisObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public HisObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public HisObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public HisObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public HisObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public HisObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public HisObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public HisObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY = "wechat_workapp_identify.sec_user";


	public HisObjectChecker checkSecUserOfWechatWorkappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY = "wechat_miniapp_identify.sec_user";


	public HisObjectChecker checkSecUserOfWechatMiniappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}

	public HisObjectChecker assignUpdateTimeOfExpenseType(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignUpdateTimeOfExpenseItem(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignUpdateTimeOfDoctor(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignUpdateTimeOfDepartment(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignUpdateTimeOfDoctorAssignment(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignCreateTimeOfDoctorSchedule(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignUpdateTimeOfDoctorSchedule(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"updateTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignCreateTimeOfWechatWorkappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HisObjectChecker assignCreateTimeOfWechatMiniappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}

}

