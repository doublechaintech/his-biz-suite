package com.panfeng.his.department;
import com.panfeng.his.BaseForm;
import com.panfeng.his.genericform.GenericForm;
import com.panfeng.his.formfield.FormField;
import com.panfeng.his.formaction.FormAction;
import com.panfeng.his.formmessage.FormMessage;
import com.panfeng.his.formfieldmessage.FormFieldMessage;



public class DepartmentForm extends BaseForm {
	
	
	public DepartmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DepartmentForm departmentIdField(String parameterName, String initValue){
		FormField field = idFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm departmentIdField(String initValue){
		return departmentIdField("departmentId",initValue);
	}
	public DepartmentForm departmentIdField(){
		return departmentIdField("departmentId","");
	}


	public DepartmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public DepartmentForm nameField(){
		return nameField("name","");
	}


	public DepartmentForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public DepartmentForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}

	
	


	public DepartmentForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DepartmentForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public DepartmentForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public DepartmentForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DepartmentForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public DepartmentForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public DepartmentForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DepartmentForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public DepartmentForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public DepartmentForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DepartmentForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public DepartmentForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	



	public DepartmentForm doctorAssignmentIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  idFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm doctorAssignmentIdFieldForDoctorAssignment(String initValue){
		return doctorAssignmentIdFieldForDoctorAssignment("doctorAssignmentId",initValue);
	}
	public DepartmentForm doctorAssignmentIdFieldForDoctorAssignment(){
		return doctorAssignmentIdFieldForDoctorAssignment("doctorAssignmentId","");
	}


	public DepartmentForm nameFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  nameFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm nameFieldForDoctorAssignment(String initValue){
		return nameFieldForDoctorAssignment("name",initValue);
	}
	public DepartmentForm nameFieldForDoctorAssignment(){
		return nameFieldForDoctorAssignment("name","");
	}


	public DepartmentForm doctorIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm doctorIdFieldForDoctorAssignment(String initValue){
		return doctorIdFieldForDoctorAssignment("doctorId",initValue);
	}
	public DepartmentForm doctorIdFieldForDoctorAssignment(){
		return doctorIdFieldForDoctorAssignment("doctorId","");
	}


	public DepartmentForm departmentIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm departmentIdFieldForDoctorAssignment(String initValue){
		return departmentIdFieldForDoctorAssignment("departmentId",initValue);
	}
	public DepartmentForm departmentIdFieldForDoctorAssignment(){
		return departmentIdFieldForDoctorAssignment("departmentId","");
	}


	public DepartmentForm doctorScheduleIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm doctorScheduleIdFieldForDoctorSchedule(String initValue){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId",initValue);
	}
	public DepartmentForm doctorScheduleIdFieldForDoctorSchedule(){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId","");
	}


	public DepartmentForm nameFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm nameFieldForDoctorSchedule(String initValue){
		return nameFieldForDoctorSchedule("name",initValue);
	}
	public DepartmentForm nameFieldForDoctorSchedule(){
		return nameFieldForDoctorSchedule("name","");
	}


	public DepartmentForm scheduleDateFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm scheduleDateFieldForDoctorSchedule(String initValue){
		return scheduleDateFieldForDoctorSchedule("scheduleDate",initValue);
	}
	public DepartmentForm scheduleDateFieldForDoctorSchedule(){
		return scheduleDateFieldForDoctorSchedule("scheduleDate","");
	}


	public DepartmentForm periodFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  periodFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm periodFieldForDoctorSchedule(String initValue){
		return periodFieldForDoctorSchedule("period",initValue);
	}
	public DepartmentForm periodFieldForDoctorSchedule(){
		return periodFieldForDoctorSchedule("period","");
	}


	public DepartmentForm doctorIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm doctorIdFieldForDoctorSchedule(String initValue){
		return doctorIdFieldForDoctorSchedule("doctorId",initValue);
	}
	public DepartmentForm doctorIdFieldForDoctorSchedule(){
		return doctorIdFieldForDoctorSchedule("doctorId","");
	}


	public DepartmentForm availableFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm availableFieldForDoctorSchedule(String initValue){
		return availableFieldForDoctorSchedule("available",initValue);
	}
	public DepartmentForm availableFieldForDoctorSchedule(){
		return availableFieldForDoctorSchedule("available","");
	}


	public DepartmentForm priceFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm priceFieldForDoctorSchedule(String initValue){
		return priceFieldForDoctorSchedule("price",initValue);
	}
	public DepartmentForm priceFieldForDoctorSchedule(){
		return priceFieldForDoctorSchedule("price","");
	}


	public DepartmentForm expenseTypeIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm expenseTypeIdFieldForDoctorSchedule(String initValue){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId",initValue);
	}
	public DepartmentForm expenseTypeIdFieldForDoctorSchedule(){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId","");
	}


	public DepartmentForm departmentIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DepartmentForm departmentIdFieldForDoctorSchedule(String initValue){
		return departmentIdFieldForDoctorSchedule("departmentId",initValue);
	}
	public DepartmentForm departmentIdFieldForDoctorSchedule(){
		return departmentIdFieldForDoctorSchedule("departmentId","");
	}

	

	
 	public DepartmentForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/departmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public DepartmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


