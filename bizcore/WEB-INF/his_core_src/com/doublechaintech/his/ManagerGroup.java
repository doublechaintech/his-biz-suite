package com.doublechaintech.his;


import com.doublechaintech.his.platform.PlatformManager;

import com.doublechaintech.his.doctor.DoctorManager;

import com.doublechaintech.his.profile.ProfileManager;

import com.doublechaintech.his.registration.RegistrationManager;

import com.doublechaintech.his.userdomain.UserDomainManager;

import com.doublechaintech.his.userwhitelist.UserWhiteListManager;

import com.doublechaintech.his.secuser.SecUserManager;

import com.doublechaintech.his.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.his.userapp.UserAppManager;

import com.doublechaintech.his.listaccess.ListAccessManager;

import com.doublechaintech.his.objectaccess.ObjectAccessManager;

import com.doublechaintech.his.loginhistory.LoginHistoryManager;

import com.doublechaintech.his.genericform.GenericFormManager;

import com.doublechaintech.his.formmessage.FormMessageManager;

import com.doublechaintech.his.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.his.formfield.FormFieldManager;

import com.doublechaintech.his.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected DoctorManager doctorManager;

	protected ProfileManager profileManager;

	protected RegistrationManager registrationManager;

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

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public DoctorManager getDoctorManager(){
		return this.doctorManager;
	}
	public void setDoctorManager(DoctorManager manager){
		this.doctorManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public RegistrationManager getRegistrationManager(){
		return this.registrationManager;
	}
	public void setRegistrationManager(RegistrationManager manager){
		this.registrationManager = manager;
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









