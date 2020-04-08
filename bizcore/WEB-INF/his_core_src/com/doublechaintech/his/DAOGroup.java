package com.doublechaintech.his;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.hospital.HospitalDAO;
import com.doublechaintech.his.hospital.HospitalTokens;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.expensetype.ExpenseTypeDAO;
import com.doublechaintech.his.expensetype.ExpenseTypeTokens;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.period.PeriodDAO;
import com.doublechaintech.his.period.PeriodTokens;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.expenseitem.ExpenseItemDAO;
import com.doublechaintech.his.expenseitem.ExpenseItemTokens;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.doctor.DoctorDAO;
import com.doublechaintech.his.doctor.DoctorTokens;
import com.doublechaintech.his.department.Department;
import com.doublechaintech.his.department.DepartmentDAO;
import com.doublechaintech.his.department.DepartmentTokens;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;
import com.doublechaintech.his.doctorassignment.DoctorAssignmentDAO;
import com.doublechaintech.his.doctorassignment.DoctorAssignmentTokens;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.doctorschedule.DoctorScheduleDAO;
import com.doublechaintech.his.doctorschedule.DoctorScheduleTokens;
import com.doublechaintech.his.mobileapp.MobileApp;
import com.doublechaintech.his.mobileapp.MobileAppDAO;
import com.doublechaintech.his.mobileapp.MobileAppTokens;
import com.doublechaintech.his.page.Page;
import com.doublechaintech.his.page.PageDAO;
import com.doublechaintech.his.page.PageTokens;
import com.doublechaintech.his.pagetype.PageType;
import com.doublechaintech.his.pagetype.PageTypeDAO;
import com.doublechaintech.his.pagetype.PageTypeTokens;
import com.doublechaintech.his.slide.Slide;
import com.doublechaintech.his.slide.SlideDAO;
import com.doublechaintech.his.slide.SlideTokens;
import com.doublechaintech.his.uiaction.UiAction;
import com.doublechaintech.his.uiaction.UiActionDAO;
import com.doublechaintech.his.uiaction.UiActionTokens;
import com.doublechaintech.his.section.Section;
import com.doublechaintech.his.section.SectionDAO;
import com.doublechaintech.his.section.SectionTokens;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.userdomain.UserDomainDAO;
import com.doublechaintech.his.userdomain.UserDomainTokens;
import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.his.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.secuser.SecUserDAO;
import com.doublechaintech.his.secuser.SecUserTokens;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.userapp.UserAppDAO;
import com.doublechaintech.his.userapp.UserAppTokens;
import com.doublechaintech.his.quicklink.QuickLink;
import com.doublechaintech.his.quicklink.QuickLinkDAO;
import com.doublechaintech.his.quicklink.QuickLinkTokens;
import com.doublechaintech.his.listaccess.ListAccess;
import com.doublechaintech.his.listaccess.ListAccessDAO;
import com.doublechaintech.his.listaccess.ListAccessTokens;
import com.doublechaintech.his.objectaccess.ObjectAccess;
import com.doublechaintech.his.objectaccess.ObjectAccessDAO;
import com.doublechaintech.his.objectaccess.ObjectAccessTokens;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.loginhistory.LoginHistoryDAO;
import com.doublechaintech.his.loginhistory.LoginHistoryTokens;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.genericform.GenericFormDAO;
import com.doublechaintech.his.genericform.GenericFormTokens;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formmessage.FormMessageDAO;
import com.doublechaintech.his.formmessage.FormMessageTokens;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.his.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formfield.FormFieldDAO;
import com.doublechaintech.his.formfield.FormFieldTokens;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formaction.FormActionDAO;
import com.doublechaintech.his.formaction.FormActionTokens;
import com.doublechaintech.his.candidatecontainer.CandidateContainer;
import com.doublechaintech.his.candidatecontainer.CandidateContainerDAO;
import com.doublechaintech.his.candidatecontainer.CandidateContainerTokens;
import com.doublechaintech.his.candidateelement.CandidateElement;
import com.doublechaintech.his.candidateelement.CandidateElementDAO;
import com.doublechaintech.his.candidateelement.CandidateElementTokens;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyTokens;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyTokens;
import com.doublechaintech.his.treenode.TreeNode;
import com.doublechaintech.his.treenode.TreeNodeDAO;
import com.doublechaintech.his.treenode.TreeNodeTokens;

public class DAOGroup {

	protected HospitalDAO hospitalDAO;

	protected ExpenseTypeDAO expenseTypeDAO;

	protected PeriodDAO periodDAO;

	protected ExpenseItemDAO expenseItemDAO;

	protected DoctorDAO doctorDAO;

	protected DepartmentDAO departmentDAO;

	protected DoctorAssignmentDAO doctorAssignmentDAO;

	protected DoctorScheduleDAO doctorScheduleDAO;

	protected MobileAppDAO mobileAppDAO;

	protected PageDAO pageDAO;

	protected PageTypeDAO pageTypeDAO;

	protected SlideDAO slideDAO;

	protected UiActionDAO uiActionDAO;

	protected SectionDAO sectionDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	protected WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO;

	protected WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO;

	protected TreeNodeDAO treeNodeDAO;



	public HospitalDAO getHospitalDAO(){
		return this.hospitalDAO;
	}
	public void setHospitalDAO(HospitalDAO dao){
		this.hospitalDAO = dao;
	}


	public ExpenseTypeDAO getExpenseTypeDAO(){
		return this.expenseTypeDAO;
	}
	public void setExpenseTypeDAO(ExpenseTypeDAO dao){
		this.expenseTypeDAO = dao;
	}


	public PeriodDAO getPeriodDAO(){
		return this.periodDAO;
	}
	public void setPeriodDAO(PeriodDAO dao){
		this.periodDAO = dao;
	}


	public ExpenseItemDAO getExpenseItemDAO(){
		return this.expenseItemDAO;
	}
	public void setExpenseItemDAO(ExpenseItemDAO dao){
		this.expenseItemDAO = dao;
	}


	public DoctorDAO getDoctorDAO(){
		return this.doctorDAO;
	}
	public void setDoctorDAO(DoctorDAO dao){
		this.doctorDAO = dao;
	}


	public DepartmentDAO getDepartmentDAO(){
		return this.departmentDAO;
	}
	public void setDepartmentDAO(DepartmentDAO dao){
		this.departmentDAO = dao;
	}


	public DoctorAssignmentDAO getDoctorAssignmentDAO(){
		return this.doctorAssignmentDAO;
	}
	public void setDoctorAssignmentDAO(DoctorAssignmentDAO dao){
		this.doctorAssignmentDAO = dao;
	}


	public DoctorScheduleDAO getDoctorScheduleDAO(){
		return this.doctorScheduleDAO;
	}
	public void setDoctorScheduleDAO(DoctorScheduleDAO dao){
		this.doctorScheduleDAO = dao;
	}


	public MobileAppDAO getMobileAppDAO(){
		return this.mobileAppDAO;
	}
	public void setMobileAppDAO(MobileAppDAO dao){
		this.mobileAppDAO = dao;
	}


	public PageDAO getPageDAO(){
		return this.pageDAO;
	}
	public void setPageDAO(PageDAO dao){
		this.pageDAO = dao;
	}


	public PageTypeDAO getPageTypeDAO(){
		return this.pageTypeDAO;
	}
	public void setPageTypeDAO(PageTypeDAO dao){
		this.pageTypeDAO = dao;
	}


	public SlideDAO getSlideDAO(){
		return this.slideDAO;
	}
	public void setSlideDAO(SlideDAO dao){
		this.slideDAO = dao;
	}


	public UiActionDAO getUiActionDAO(){
		return this.uiActionDAO;
	}
	public void setUiActionDAO(UiActionDAO dao){
		this.uiActionDAO = dao;
	}


	public SectionDAO getSectionDAO(){
		return this.sectionDAO;
	}
	public void setSectionDAO(SectionDAO dao){
		this.sectionDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO(){
		return this.wechatWorkappIdentifyDAO;
	}
	public void setWechatWorkappIdentifyDAO(WechatWorkappIdentifyDAO dao){
		this.wechatWorkappIdentifyDAO = dao;
	}


	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO(){
		return this.wechatMiniappIdentifyDAO;
	}
	public void setWechatMiniappIdentifyDAO(WechatMiniappIdentifyDAO dao){
		this.wechatMiniappIdentifyDAO = dao;
	}


	public TreeNodeDAO getTreeNodeDAO(){
		return this.treeNodeDAO;
	}
	public void setTreeNodeDAO(TreeNodeDAO dao){
		this.treeNodeDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> list) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	    SmartList<? extends BaseEntity> queryList(DAOGroup daoGoup, String sql, Object... parmeters) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Hospital", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getHospitalDAO().load(id, HospitalTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getHospitalDAO().enhanceList((List<Hospital>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHospitalDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHospitalDAO().present((Hospital)data, tokens);
			}
			@Override
			public SmartList<Hospital> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getHospitalDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Hospital.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ExpenseType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getExpenseTypeDAO().load(id, ExpenseTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getExpenseTypeDAO().enhanceList((List<ExpenseType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getExpenseTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getExpenseTypeDAO().present((ExpenseType)data, tokens);
			}
			@Override
			public SmartList<ExpenseType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getExpenseTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ExpenseType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Period", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPeriodDAO().load(id, PeriodTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPeriodDAO().enhanceList((List<Period>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPeriodDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPeriodDAO().present((Period)data, tokens);
			}
			@Override
			public SmartList<Period> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPeriodDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Period.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ExpenseItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getExpenseItemDAO().load(id, ExpenseItemTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getExpenseItemDAO().enhanceList((List<ExpenseItem>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getExpenseItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getExpenseItemDAO().present((ExpenseItem)data, tokens);
			}
			@Override
			public SmartList<ExpenseItem> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getExpenseItemDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ExpenseItem.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Doctor", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDoctorDAO().load(id, DoctorTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDoctorDAO().enhanceList((List<Doctor>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorDAO().present((Doctor)data, tokens);
			}
			@Override
			public SmartList<Doctor> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getDoctorDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Doctor.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Department", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDepartmentDAO().load(id, DepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDepartmentDAO().enhanceList((List<Department>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDepartmentDAO().present((Department)data, tokens);
			}
			@Override
			public SmartList<Department> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Department.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("DoctorAssignment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDoctorAssignmentDAO().load(id, DoctorAssignmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDoctorAssignmentDAO().enhanceList((List<DoctorAssignment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorAssignmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorAssignmentDAO().present((DoctorAssignment)data, tokens);
			}
			@Override
			public SmartList<DoctorAssignment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getDoctorAssignmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)DoctorAssignment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("DoctorSchedule", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDoctorScheduleDAO().load(id, DoctorScheduleTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDoctorScheduleDAO().enhanceList((List<DoctorSchedule>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorScheduleDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDoctorScheduleDAO().present((DoctorSchedule)data, tokens);
			}
			@Override
			public SmartList<DoctorSchedule> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getDoctorScheduleDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)DoctorSchedule.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MobileApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, MobileAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMobileAppDAO().enhanceList((List<MobileApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().present((MobileApp)data, tokens);
			}
			@Override
			public SmartList<MobileApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMobileAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MobileApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Page", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageDAO().load(id, PageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageDAO().enhanceList((List<Page>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().present((Page)data, tokens);
			}
			@Override
			public SmartList<Page> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Page.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PageType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, PageTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageTypeDAO().enhanceList((List<PageType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().present((PageType)data, tokens);
			}
			@Override
			public SmartList<PageType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PageType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Slide", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSlideDAO().load(id, SlideTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSlideDAO().enhanceList((List<Slide>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().present((Slide)data, tokens);
			}
			@Override
			public SmartList<Slide> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSlideDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Slide.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UiAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUiActionDAO().load(id, UiActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUiActionDAO().enhanceList((List<UiAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().present((UiAction)data, tokens);
			}
			@Override
			public SmartList<UiAction> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUiActionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UiAction.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Section", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSectionDAO().load(id, SectionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSectionDAO().enhanceList((List<Section>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().present((Section)data, tokens);
			}
			@Override
			public SmartList<Section> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSectionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Section.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
			@Override
			public SmartList<UserDomain> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserDomainDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserDomain.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserWhiteListDAO().enhanceList((List<UserWhiteList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
			@Override
			public SmartList<UserWhiteList> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserWhiteListDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserWhiteList.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
			@Override
			public SmartList<SecUser> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSecUserDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SecUser.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
			@Override
			public SmartList<UserApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
			@Override
			public SmartList<QuickLink> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getQuickLinkDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)QuickLink.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
			@Override
			public SmartList<ListAccess> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getListAccessDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ListAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getObjectAccessDAO().enhanceList((List<ObjectAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
			@Override
			public SmartList<ObjectAccess> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getObjectAccessDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ObjectAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
			@Override
			public SmartList<LoginHistory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLoginHistoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LoginHistory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGenericFormDAO().enhanceList((List<GenericForm>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
			@Override
			public SmartList<GenericForm> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGenericFormDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GenericForm.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormMessageDAO().enhanceList((List<FormMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
			@Override
			public SmartList<FormMessage> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFormMessageDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FormMessage.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldMessageDAO().enhanceList((List<FormFieldMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
			@Override
			public SmartList<FormFieldMessage> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFormFieldMessageDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FormFieldMessage.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldDAO().enhanceList((List<FormField>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
			@Override
			public SmartList<FormField> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFormFieldDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FormField.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormActionDAO().enhanceList((List<FormAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
			@Override
			public SmartList<FormAction> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getFormActionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)FormAction.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
			@Override
			public SmartList<CandidateContainer> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateContainerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateContainer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
			@Override
			public SmartList<CandidateElement> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateElementDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateElement.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatWorkappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, WechatWorkappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatWorkappIdentifyDAO().enhanceList((List<WechatWorkappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().present((WechatWorkappIdentify)data, tokens);
			}
			@Override
			public SmartList<WechatWorkappIdentify> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatWorkappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatMiniappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, WechatMiniappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatMiniappIdentifyDAO().enhanceList((List<WechatMiniappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().present((WechatMiniappIdentify)data, tokens);
			}
			@Override
			public SmartList<WechatMiniappIdentify> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatMiniappIdentify.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TreeNode", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, TreeNodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTreeNodeDAO().enhanceList((List<TreeNode>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().present((TreeNode)data, tokens);
			}
			@Override
			public SmartList<TreeNode> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTreeNodeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TreeNode.withId(id)).collect(Collectors.toList());
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}

	public List<BaseEntity> wrapperList(String type, List<String> ids){
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return null;
  	    }
  	    try{
  	    	return loader.wrapperList(this, ids);
  	    }catch(Exception e) {
  	    	e.printStackTrace();
  	    	return null;
  	    }
  	}

	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}

	public void enhanceList(List list, String type) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return ;
  	    }

  	    loader.enhanceList(this, list);
  	}
  	
  	public SmartList<? extends BaseEntity> queryList(String type, String sql, Object ... parameters) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return new SmartList();
  	    }

  	    return loader.queryList(this, sql, parameters);
  	}
}

