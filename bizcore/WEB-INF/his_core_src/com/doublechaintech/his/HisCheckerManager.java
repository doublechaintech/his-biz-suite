package com.doublechaintech.his;
import com.terapico.caf.DateTime;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class HisCheckerManager extends BaseManagerImpl {
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(HisUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = "verifyCode:"+mobile;
		ctx.putToCache(cacheKey, verifyCode, HisBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(HisUserContext ctx, String mobile) {
		String cacheKey = "verifyCode:"+mobile;
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(HisUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	/*
	
	
	public static final String  ID_OF_HOSPITAL ="hospital.id";
	protected void checkIdOfHospital(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_HOSPITAL, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_HOSPITAL ="hospital.name";
	protected void checkNameOfHospital(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_HOSPITAL, messageList); 		
		
	}	 			
	
	public static final String  ADDRESS_OF_HOSPITAL ="hospital.address";
	protected void checkAddressOfHospital(HisUserContext userContext, String address, List<Message> messageList)
	{
		
	 	checkStringLengthRange(address,2, 24,ADDRESS_OF_HOSPITAL, messageList); 		
		
	}	 			
	
	public static final String  TELEPHONE_OF_HOSPITAL ="hospital.telephone";
	protected void checkTelephoneOfHospital(HisUserContext userContext, String telephone, List<Message> messageList)
	{
		
	 	checkStringLengthRange(telephone,3, 44,TELEPHONE_OF_HOSPITAL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_HOSPITAL ="hospital.version";
	protected void checkVersionOfHospital(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HOSPITAL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EXPENSE_TYPE ="expense_type.id";
	protected void checkIdOfExpenseType(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_EXPENSE_TYPE ="expense_type.name";
	protected void checkNameOfExpenseType(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  HELPER_CHARS_OF_EXPENSE_TYPE ="expense_type.helper_chars";
	protected void checkHelperCharsOfExpenseType(HisUserContext userContext, String helperChars, List<Message> messageList)
	{
		
	 	checkStringLengthRange(helperChars,1, 12,HELPER_CHARS_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  STATUS_OF_EXPENSE_TYPE ="expense_type.status";
	protected void checkStatusOfExpenseType(HisUserContext userContext, String status, List<Message> messageList)
	{
		
	 	checkStringLengthRange(status,1, 8,STATUS_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_EXPENSE_TYPE ="expense_type.hospital";
	protected void checkHospitalIdOfExpenseType(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfExpenseType(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_EXPENSE_TYPE ="expense_type.description";
	protected void checkDescriptionOfExpenseType(HisUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EXPENSE_TYPE ="expense_type.version";
	protected void checkVersionOfExpenseType(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EXPENSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PERIOD ="period.id";
	protected void checkIdOfPeriod(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PERIOD ="period.name";
	protected void checkNameOfPeriod(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_PERIOD ="period.hospital";
	protected void checkHospitalIdOfPeriod(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfPeriod(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PERIOD ="period.version";
	protected void checkVersionOfPeriod(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EXPENSE_ITEM ="expense_item.id";
	protected void checkIdOfExpenseItem(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_EXPENSE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_EXPENSE_ITEM ="expense_item.name";
	protected void checkNameOfExpenseItem(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_EXPENSE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_EXPENSE_ITEM ="expense_item.price";
	protected void checkPriceOfExpenseItem(HisUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 99999999999.00,PRICE_OF_EXPENSE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  EXPENSE_TYPE_OF_EXPENSE_ITEM ="expense_item.expense_type";
	protected void checkExpenseTypeIdOfExpenseItem(HisUserContext userContext, String expenseTypeId, List<Message> messageList)
	{
		
	 	checkIdOfExpenseItem(userContext,expenseTypeId, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_EXPENSE_ITEM ="expense_item.hospital";
	protected void checkHospitalIdOfExpenseItem(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfExpenseItem(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EXPENSE_ITEM ="expense_item.version";
	protected void checkVersionOfExpenseItem(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EXPENSE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_DOCTOR ="doctor.id";
	protected void checkIdOfDoctor(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_DOCTOR, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_DOCTOR ="doctor.name";
	protected void checkNameOfDoctor(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_DOCTOR, messageList); 		
		
	}	 			
	
	public static final String  SHOT_IMAGE_OF_DOCTOR ="doctor.shot_image";
	protected void checkShotImageOfDoctor(HisUserContext userContext, String shotImage, List<Message> messageList)
	{
		
	 	checkImage(shotImage,0, 512,SHOT_IMAGE_OF_DOCTOR, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_DOCTOR ="doctor.hospital";
	protected void checkHospitalIdOfDoctor(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfDoctor(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_DOCTOR ="doctor.version";
	protected void checkVersionOfDoctor(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DOCTOR, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_DEPARTMENT ="department.id";
	protected void checkIdOfDepartment(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_DEPARTMENT ="department.name";
	protected void checkNameOfDepartment(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_DEPARTMENT ="department.hospital";
	protected void checkHospitalIdOfDepartment(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfDepartment(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_DEPARTMENT ="department.version";
	protected void checkVersionOfDepartment(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_DOCTOR_ASSIGNMENT ="doctor_assignment.id";
	protected void checkIdOfDoctorAssignment(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_DOCTOR_ASSIGNMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_DOCTOR_ASSIGNMENT ="doctor_assignment.name";
	protected void checkNameOfDoctorAssignment(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_DOCTOR_ASSIGNMENT, messageList); 		
		
	}	 			
	
	public static final String  DOCTOR_OF_DOCTOR_ASSIGNMENT ="doctor_assignment.doctor";
	protected void checkDoctorIdOfDoctorAssignment(HisUserContext userContext, String doctorId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorAssignment(userContext,doctorId, messageList); 		
		
	}	 			
	
	public static final String  DEPARTMENT_OF_DOCTOR_ASSIGNMENT ="doctor_assignment.department";
	protected void checkDepartmentIdOfDoctorAssignment(HisUserContext userContext, String departmentId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorAssignment(userContext,departmentId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_DOCTOR_ASSIGNMENT ="doctor_assignment.version";
	protected void checkVersionOfDoctorAssignment(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DOCTOR_ASSIGNMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_DOCTOR_SCHEDULE ="doctor_schedule.id";
	protected void checkIdOfDoctorSchedule(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_DOCTOR_SCHEDULE ="doctor_schedule.name";
	protected void checkNameOfDoctorSchedule(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,8, 116,NAME_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  DOCTOR_OF_DOCTOR_SCHEDULE ="doctor_schedule.doctor";
	protected void checkDoctorIdOfDoctorSchedule(HisUserContext userContext, String doctorId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorSchedule(userContext,doctorId, messageList); 		
		
	}	 			
	
	public static final String  SCHEDULE_DATE_OF_DOCTOR_SCHEDULE ="doctor_schedule.schedule_date";
	protected void checkScheduleDateOfDoctorSchedule(HisUserContext userContext, Date scheduleDate, List<Message> messageList)
	{
		
	 	checkDateRange(scheduleDate,parseDate("1900-01-01"), parseDate("2019-3-11"),SCHEDULE_DATE_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  PERIOD_OF_DOCTOR_SCHEDULE ="doctor_schedule.period";
	protected void checkPeriodIdOfDoctorSchedule(HisUserContext userContext, String periodId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorSchedule(userContext,periodId, messageList); 		
		
	}	 			
	
	public static final String  DEPARTMENT_OF_DOCTOR_SCHEDULE ="doctor_schedule.department";
	protected void checkDepartmentIdOfDoctorSchedule(HisUserContext userContext, String departmentId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorSchedule(userContext,departmentId, messageList); 		
		
	}	 			
	
	public static final String  AVAILABLE_OF_DOCTOR_SCHEDULE ="doctor_schedule.available";
	protected void checkAvailableOfDoctorSchedule(HisUserContext userContext, int available, List<Message> messageList)
	{
		
	 	checkIntegerRange(available,0, 20,AVAILABLE_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_DOCTOR_SCHEDULE ="doctor_schedule.price";
	protected void checkPriceOfDoctorSchedule(HisUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 123.99,PRICE_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  EXPENSE_TYPE_OF_DOCTOR_SCHEDULE ="doctor_schedule.expense_type";
	protected void checkExpenseTypeIdOfDoctorSchedule(HisUserContext userContext, String expenseTypeId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorSchedule(userContext,expenseTypeId, messageList); 		
		
	}	 			
	
	public static final String  HOSPITAL_OF_DOCTOR_SCHEDULE ="doctor_schedule.hospital";
	protected void checkHospitalIdOfDoctorSchedule(HisUserContext userContext, String hospitalId, List<Message> messageList)
	{
		
	 	checkIdOfDoctorSchedule(userContext,hospitalId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_DOCTOR_SCHEDULE ="doctor_schedule.version";
	protected void checkVersionOfDoctorSchedule(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DOCTOR_SCHEDULE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(HisUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(HisUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(HisUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(HisUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(HisUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(HisUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(HisUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	protected void checkWeixinOpenidOfSecUser(HisUserContext userContext, String weixinOpenid, List<Message> messageList)
	{
		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	protected void checkWeixinAppidOfSecUser(HisUserContext userContext, String weixinAppid, List<Message> messageList)
	{
		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	protected void checkAccessTokenOfSecUser(HisUserContext userContext, String accessToken, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(HisUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(HisUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(HisUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(HisUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(HisUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(HisUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(HisUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(HisUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(HisUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(HisUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(HisUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(HisUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(HisUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(HisUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(HisUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(HisUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(HisUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(HisUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(HisUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(HisUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(HisUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(HisUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(HisUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(HisUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(HisUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(HisUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(HisUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(HisUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(HisUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(HisUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(HisUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(HisUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(HisUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(HisUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(HisUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(HisUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(HisUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(HisUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(HisUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(HisUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(HisUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(HisUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(HisUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(HisUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(HisUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(HisUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(HisUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(HisUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(HisUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(HisUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(HisUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(HisUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(HisUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(HisUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(HisUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(HisUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(HisUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(HisUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(HisUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(HisUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(HisUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(HisUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(HisUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(HisUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(HisUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(HisUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(HisUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(HisUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(HisUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof HisUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		HisUserContext userContext = (HisUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(HisUserContext userContext, List<Message> messageList, Class<? extends HisException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, HisException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}








