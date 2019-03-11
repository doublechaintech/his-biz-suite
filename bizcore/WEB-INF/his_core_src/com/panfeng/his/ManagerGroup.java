package com.panfeng.his;


import com.panfeng.his.hospital.HospitalManager;

import com.panfeng.his.expensetype.ExpenseTypeManager;

import com.panfeng.his.expenseitem.ExpenseItemManager;

import com.panfeng.his.doctor.DoctorManager;

import com.panfeng.his.department.DepartmentManager;

import com.panfeng.his.doctorassignment.DoctorAssignmentManager;

import com.panfeng.his.doctorschedule.DoctorScheduleManager;

import com.panfeng.his.userdomain.UserDomainManager;

import com.panfeng.his.userwhitelist.UserWhiteListManager;

import com.panfeng.his.secuser.SecUserManager;

import com.panfeng.his.secuserblocking.SecUserBlockingManager;

import com.panfeng.his.userapp.UserAppManager;

import com.panfeng.his.listaccess.ListAccessManager;

import com.panfeng.his.objectaccess.ObjectAccessManager;

import com.panfeng.his.loginhistory.LoginHistoryManager;

import com.panfeng.his.genericform.GenericFormManager;

import com.panfeng.his.formmessage.FormMessageManager;

import com.panfeng.his.formfieldmessage.FormFieldMessageManager;

import com.panfeng.his.formfield.FormFieldManager;

import com.panfeng.his.formaction.FormActionManager;


public class ManagerGroup {

	protected HospitalManager hospitalManager;

	protected ExpenseTypeManager expenseTypeManager;

	protected ExpenseItemManager expenseItemManager;

	protected DoctorManager doctorManager;

	protected DepartmentManager departmentManager;

	protected DoctorAssignmentManager doctorAssignmentManager;

	protected DoctorScheduleManager doctorScheduleManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

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


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
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


}









