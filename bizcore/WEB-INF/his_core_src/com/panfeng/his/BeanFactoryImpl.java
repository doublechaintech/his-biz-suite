
package com.panfeng.his;
import java.util.Map;

import com.panfeng.his.hospital.Hospital;
import com.panfeng.his.expensetype.ExpenseType;
import com.panfeng.his.expenseitem.ExpenseItem;
import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.department.Department;
import com.panfeng.his.doctorassignment.DoctorAssignment;
import com.panfeng.his.doctorschedule.DoctorSchedule;
import com.panfeng.his.userdomain.UserDomain;
import com.panfeng.his.userwhitelist.UserWhiteList;
import com.panfeng.his.secuser.SecUser;
import com.panfeng.his.secuserblocking.SecUserBlocking;
import com.panfeng.his.userapp.UserApp;
import com.panfeng.his.listaccess.ListAccess;
import com.panfeng.his.objectaccess.ObjectAccess;
import com.panfeng.his.loginhistory.LoginHistory;
import com.panfeng.his.genericform.GenericForm;
import com.panfeng.his.formmessage.FormMessage;
import com.panfeng.his.formfieldmessage.FormFieldMessage;
import com.panfeng.his.formfield.FormField;
import com.panfeng.his.formaction.FormAction;

public class BeanFactoryImpl{


	public Hospital createHospital(Map<String,Object> options){
		return new Hospital();
	}


	public ExpenseType createExpenseType(Map<String,Object> options){
		return new ExpenseType();
	}


	public ExpenseItem createExpenseItem(Map<String,Object> options){
		return new ExpenseItem();
	}


	public Doctor createDoctor(Map<String,Object> options){
		return new Doctor();
	}


	public Department createDepartment(Map<String,Object> options){
		return new Department();
	}


	public DoctorAssignment createDoctorAssignment(Map<String,Object> options){
		return new DoctorAssignment();
	}


	public DoctorSchedule createDoctorSchedule(Map<String,Object> options){
		return new DoctorSchedule();
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










