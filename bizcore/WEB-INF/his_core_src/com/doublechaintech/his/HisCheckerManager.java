package com.doublechaintech.his;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class HisCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(HisUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(HisUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	
	public Object queryCandidates(HisUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidates(userContext, query);
	}
	
	public Object queryCandidatesForAssign(HisUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForSearch(HisUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForSearch(userContext, query);
	}
	
	protected HisObjectChecker checkerOf(HisUserContext ctx) {
		return ctx.getChecker();
	}
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
	
	public com.doublechaintech.his.hospital.HospitalManager hospitalManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getHospitalManager();
	}
	public com.doublechaintech.his.hospital.HospitalDAO hospitalDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getHospitalDAO();
	}
	public com.doublechaintech.his.expensetype.ExpenseTypeManager expenseTypeManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getExpenseTypeManager();
	}
	public com.doublechaintech.his.expensetype.ExpenseTypeDAO expenseTypeDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getExpenseTypeDAO();
	}
	public com.doublechaintech.his.period.PeriodManager periodManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getPeriodManager();
	}
	public com.doublechaintech.his.period.PeriodDAO periodDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getPeriodDAO();
	}
	public com.doublechaintech.his.expenseitem.ExpenseItemManager expenseItemManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getExpenseItemManager();
	}
	public com.doublechaintech.his.expenseitem.ExpenseItemDAO expenseItemDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getExpenseItemDAO();
	}
	public com.doublechaintech.his.doctor.DoctorManager doctorManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getDoctorManager();
	}
	public com.doublechaintech.his.doctor.DoctorDAO doctorDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getDoctorDAO();
	}
	public com.doublechaintech.his.department.DepartmentManager departmentManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getDepartmentManager();
	}
	public com.doublechaintech.his.department.DepartmentDAO departmentDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getDepartmentDAO();
	}
	public com.doublechaintech.his.doctorassignment.DoctorAssignmentManager doctorAssignmentManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getDoctorAssignmentManager();
	}
	public com.doublechaintech.his.doctorassignment.DoctorAssignmentDAO doctorAssignmentDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getDoctorAssignmentDAO();
	}
	public com.doublechaintech.his.doctorschedule.DoctorScheduleManager doctorScheduleManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getDoctorScheduleManager();
	}
	public com.doublechaintech.his.doctorschedule.DoctorScheduleDAO doctorScheduleDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getDoctorScheduleDAO();
	}
	public com.doublechaintech.his.mobileapp.MobileAppManager mobileAppManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getMobileAppManager();
	}
	public com.doublechaintech.his.mobileapp.MobileAppDAO mobileAppDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getMobileAppDAO();
	}
	public com.doublechaintech.his.page.PageManager pageManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getPageManager();
	}
	public com.doublechaintech.his.page.PageDAO pageDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getPageDAO();
	}
	public com.doublechaintech.his.pagetype.PageTypeManager pageTypeManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getPageTypeManager();
	}
	public com.doublechaintech.his.pagetype.PageTypeDAO pageTypeDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getPageTypeDAO();
	}
	public com.doublechaintech.his.slide.SlideManager slideManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getSlideManager();
	}
	public com.doublechaintech.his.slide.SlideDAO slideDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getSlideDAO();
	}
	public com.doublechaintech.his.uiaction.UiActionManager uiActionManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getUiActionManager();
	}
	public com.doublechaintech.his.uiaction.UiActionDAO uiActionDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getUiActionDAO();
	}
	public com.doublechaintech.his.section.SectionManager sectionManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getSectionManager();
	}
	public com.doublechaintech.his.section.SectionDAO sectionDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getSectionDAO();
	}
	public com.doublechaintech.his.userdomain.UserDomainManager userDomainManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechaintech.his.userdomain.UserDomainDAO userDomainDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechaintech.his.userwhitelist.UserWhiteListManager userWhiteListManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.doublechaintech.his.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.doublechaintech.his.secuser.SecUserManager secUserManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechaintech.his.secuser.SecUserDAO secUserDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechaintech.his.userapp.UserAppManager userAppManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechaintech.his.userapp.UserAppDAO userAppDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechaintech.his.quicklink.QuickLinkManager quickLinkManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechaintech.his.quicklink.QuickLinkDAO quickLinkDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechaintech.his.listaccess.ListAccessManager listAccessManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechaintech.his.listaccess.ListAccessDAO listAccessDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechaintech.his.objectaccess.ObjectAccessManager objectAccessManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getObjectAccessManager();
	}
	public com.doublechaintech.his.objectaccess.ObjectAccessDAO objectAccessDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getObjectAccessDAO();
	}
	public com.doublechaintech.his.loginhistory.LoginHistoryManager loginHistoryManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechaintech.his.loginhistory.LoginHistoryDAO loginHistoryDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechaintech.his.genericform.GenericFormManager genericFormManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getGenericFormManager();
	}
	public com.doublechaintech.his.genericform.GenericFormDAO genericFormDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getGenericFormDAO();
	}
	public com.doublechaintech.his.formmessage.FormMessageManager formMessageManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getFormMessageManager();
	}
	public com.doublechaintech.his.formmessage.FormMessageDAO formMessageDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getFormMessageDAO();
	}
	public com.doublechaintech.his.formfieldmessage.FormFieldMessageManager formFieldMessageManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getFormFieldMessageManager();
	}
	public com.doublechaintech.his.formfieldmessage.FormFieldMessageDAO formFieldMessageDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getFormFieldMessageDAO();
	}
	public com.doublechaintech.his.formfield.FormFieldManager formFieldManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getFormFieldManager();
	}
	public com.doublechaintech.his.formfield.FormFieldDAO formFieldDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getFormFieldDAO();
	}
	public com.doublechaintech.his.formaction.FormActionManager formActionManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getFormActionManager();
	}
	public com.doublechaintech.his.formaction.FormActionDAO formActionDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getFormActionDAO();
	}
	public com.doublechaintech.his.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechaintech.his.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechaintech.his.candidateelement.CandidateElementManager candidateElementManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechaintech.his.candidateelement.CandidateElementDAO candidateElementDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyManager wechatWorkappIdentifyManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentifyManager();
	}
	public com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyDAO wechatWorkappIdentifyDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
	}
	public com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyManager wechatMiniappIdentifyManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentifyManager();
	}
	public com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyDAO wechatMiniappIdentifyDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
	}
	public com.doublechaintech.his.treenode.TreeNodeManager treeNodeManagerOf(HisUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.doublechaintech.his.treenode.TreeNodeDAO treeNodeDaoOf(HisUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}
	
	
	
	

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


















