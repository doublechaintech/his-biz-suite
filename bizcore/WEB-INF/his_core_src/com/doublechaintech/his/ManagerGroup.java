package com.doublechaintech.his;


import com.doublechaintech.his.hospital.HospitalManager;

import com.doublechaintech.his.expensetype.ExpenseTypeManager;

import com.doublechaintech.his.period.PeriodManager;

import com.doublechaintech.his.expenseitem.ExpenseItemManager;

import com.doublechaintech.his.doctor.DoctorManager;

import com.doublechaintech.his.department.DepartmentManager;

import com.doublechaintech.his.doctorassignment.DoctorAssignmentManager;

import com.doublechaintech.his.doctorschedule.DoctorScheduleManager;

import com.doublechaintech.his.mobileapp.MobileAppManager;

import com.doublechaintech.his.page.PageManager;

import com.doublechaintech.his.pagetype.PageTypeManager;

import com.doublechaintech.his.slide.SlideManager;

import com.doublechaintech.his.uiaction.UiActionManager;

import com.doublechaintech.his.section.SectionManager;

import com.doublechaintech.his.userdomain.UserDomainManager;

import com.doublechaintech.his.userwhitelist.UserWhiteListManager;

import com.doublechaintech.his.secuser.SecUserManager;

import com.doublechaintech.his.userapp.UserAppManager;

import com.doublechaintech.his.quicklink.QuickLinkManager;

import com.doublechaintech.his.listaccess.ListAccessManager;

import com.doublechaintech.his.objectaccess.ObjectAccessManager;

import com.doublechaintech.his.loginhistory.LoginHistoryManager;

import com.doublechaintech.his.genericform.GenericFormManager;

import com.doublechaintech.his.formmessage.FormMessageManager;

import com.doublechaintech.his.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.his.formfield.FormFieldManager;

import com.doublechaintech.his.formaction.FormActionManager;

import com.doublechaintech.his.candidatecontainer.CandidateContainerManager;

import com.doublechaintech.his.candidateelement.CandidateElementManager;

import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentifyManager;

import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentifyManager;

import com.doublechaintech.his.treenode.TreeNodeManager;


public class ManagerGroup {

	protected HospitalManager hospitalManager;

	protected ExpenseTypeManager expenseTypeManager;

	protected PeriodManager periodManager;

	protected ExpenseItemManager expenseItemManager;

	protected DoctorManager doctorManager;

	protected DepartmentManager departmentManager;

	protected DoctorAssignmentManager doctorAssignmentManager;

	protected DoctorScheduleManager doctorScheduleManager;

	protected MobileAppManager mobileAppManager;

	protected PageManager pageManager;

	protected PageTypeManager pageTypeManager;

	protected SlideManager slideManager;

	protected UiActionManager uiActionManager;

	protected SectionManager sectionManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected UserAppManager userAppManager;

	protected QuickLinkManager quickLinkManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	protected CandidateContainerManager candidateContainerManager;

	protected CandidateElementManager candidateElementManager;

	protected WechatWorkappIdentifyManager wechatWorkappIdentifyManager;

	protected WechatMiniappIdentifyManager wechatMiniappIdentifyManager;

	protected TreeNodeManager treeNodeManager;



	public HospitalManager getHospitalManager(){
		return this.hospitalManager;
	}
	public void setHospitalManager(HospitalManager manager){
		this.hospitalManager = manager;
	}


	public ExpenseTypeManager getExpenseTypeManager(){
		return this.expenseTypeManager;
	}
	public void setExpenseTypeManager(ExpenseTypeManager manager){
		this.expenseTypeManager = manager;
	}


	public PeriodManager getPeriodManager(){
		return this.periodManager;
	}
	public void setPeriodManager(PeriodManager manager){
		this.periodManager = manager;
	}


	public ExpenseItemManager getExpenseItemManager(){
		return this.expenseItemManager;
	}
	public void setExpenseItemManager(ExpenseItemManager manager){
		this.expenseItemManager = manager;
	}


	public DoctorManager getDoctorManager(){
		return this.doctorManager;
	}
	public void setDoctorManager(DoctorManager manager){
		this.doctorManager = manager;
	}


	public DepartmentManager getDepartmentManager(){
		return this.departmentManager;
	}
	public void setDepartmentManager(DepartmentManager manager){
		this.departmentManager = manager;
	}


	public DoctorAssignmentManager getDoctorAssignmentManager(){
		return this.doctorAssignmentManager;
	}
	public void setDoctorAssignmentManager(DoctorAssignmentManager manager){
		this.doctorAssignmentManager = manager;
	}


	public DoctorScheduleManager getDoctorScheduleManager(){
		return this.doctorScheduleManager;
	}
	public void setDoctorScheduleManager(DoctorScheduleManager manager){
		this.doctorScheduleManager = manager;
	}


	public MobileAppManager getMobileAppManager(){
		return this.mobileAppManager;
	}
	public void setMobileAppManager(MobileAppManager manager){
		this.mobileAppManager = manager;
	}


	public PageManager getPageManager(){
		return this.pageManager;
	}
	public void setPageManager(PageManager manager){
		this.pageManager = manager;
	}


	public PageTypeManager getPageTypeManager(){
		return this.pageTypeManager;
	}
	public void setPageTypeManager(PageTypeManager manager){
		this.pageTypeManager = manager;
	}


	public SlideManager getSlideManager(){
		return this.slideManager;
	}
	public void setSlideManager(SlideManager manager){
		this.slideManager = manager;
	}


	public UiActionManager getUiActionManager(){
		return this.uiActionManager;
	}
	public void setUiActionManager(UiActionManager manager){
		this.uiActionManager = manager;
	}


	public SectionManager getSectionManager(){
		return this.sectionManager;
	}
	public void setSectionManager(SectionManager manager){
		this.sectionManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public QuickLinkManager getQuickLinkManager(){
		return this.quickLinkManager;
	}
	public void setQuickLinkManager(QuickLinkManager manager){
		this.quickLinkManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


	public CandidateContainerManager getCandidateContainerManager(){
		return this.candidateContainerManager;
	}
	public void setCandidateContainerManager(CandidateContainerManager manager){
		this.candidateContainerManager = manager;
	}


	public CandidateElementManager getCandidateElementManager(){
		return this.candidateElementManager;
	}
	public void setCandidateElementManager(CandidateElementManager manager){
		this.candidateElementManager = manager;
	}


	public WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(){
		return this.wechatWorkappIdentifyManager;
	}
	public void setWechatWorkappIdentifyManager(WechatWorkappIdentifyManager manager){
		this.wechatWorkappIdentifyManager = manager;
	}


	public WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(){
		return this.wechatMiniappIdentifyManager;
	}
	public void setWechatMiniappIdentifyManager(WechatMiniappIdentifyManager manager){
		this.wechatMiniappIdentifyManager = manager;
	}


	public TreeNodeManager getTreeNodeManager(){
		return this.treeNodeManager;
	}
	public void setTreeNodeManager(TreeNodeManager manager){
		this.treeNodeManager = manager;
	}


}
















