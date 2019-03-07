
package com.doublechaintech.his;
import java.util.Map;

import com.doublechaintech.his.platform.Platform;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.registration.Registration;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.secuserblocking.SecUserBlocking;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.listaccess.ListAccess;
import com.doublechaintech.his.objectaccess.ObjectAccess;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Doctor createDoctor(Map<String,Object> options){
		return new Doctor();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public Registration createRegistration(Map<String,Object> options){
		return new Registration();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










