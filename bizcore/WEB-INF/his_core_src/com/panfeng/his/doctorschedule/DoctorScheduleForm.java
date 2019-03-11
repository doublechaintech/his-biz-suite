package com.panfeng.his.doctorschedule;
import com.panfeng.his.BaseForm;
import com.panfeng.his.genericform.GenericForm;
import com.panfeng.his.formfield.FormField;
import com.panfeng.his.formaction.FormAction;
import com.panfeng.his.formmessage.FormMessage;
import com.panfeng.his.formfieldmessage.FormFieldMessage;



public class DoctorScheduleForm extends BaseForm {
	
	
	public DoctorScheduleForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DoctorScheduleForm doctorScheduleIdField(String parameterName, String initValue){
		FormField field = idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm doctorScheduleIdField(String initValue){
		return doctorScheduleIdField("doctorScheduleId",initValue);
	}
	public DoctorScheduleForm doctorScheduleIdField(){
		return doctorScheduleIdField("doctorScheduleId","");
	}


	public DoctorScheduleForm nameField(String parameterName, String initValue){
		FormField field = nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public DoctorScheduleForm nameField(){
		return nameField("name","");
	}


	public DoctorScheduleForm scheduleDateField(String parameterName, String initValue){
		FormField field = scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm scheduleDateField(String initValue){
		return scheduleDateField("scheduleDate",initValue);
	}
	public DoctorScheduleForm scheduleDateField(){
		return scheduleDateField("scheduleDate","");
	}


	public DoctorScheduleForm periodField(String parameterName, String initValue){
		FormField field = periodFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm periodField(String initValue){
		return periodField("period",initValue);
	}
	public DoctorScheduleForm periodField(){
		return periodField("period","");
	}


	public DoctorScheduleForm doctorIdField(String parameterName, String initValue){
		FormField field = doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm doctorIdField(String initValue){
		return doctorIdField("doctorId",initValue);
	}
	public DoctorScheduleForm doctorIdField(){
		return doctorIdField("doctorId","");
	}


	public DoctorScheduleForm availableField(String parameterName, String initValue){
		FormField field = availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm availableField(String initValue){
		return availableField("available",initValue);
	}
	public DoctorScheduleForm availableField(){
		return availableField("available","");
	}


	public DoctorScheduleForm priceField(String parameterName, String initValue){
		FormField field = priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public DoctorScheduleForm priceField(){
		return priceField("price","");
	}


	public DoctorScheduleForm expenseTypeIdField(String parameterName, String initValue){
		FormField field = expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm expenseTypeIdField(String initValue){
		return expenseTypeIdField("expenseTypeId",initValue);
	}
	public DoctorScheduleForm expenseTypeIdField(){
		return expenseTypeIdField("expenseTypeId","");
	}


	public DoctorScheduleForm departmentIdField(String parameterName, String initValue){
		FormField field = departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm departmentIdField(String initValue){
		return departmentIdField("departmentId",initValue);
	}
	public DoctorScheduleForm departmentIdField(){
		return departmentIdField("departmentId","");
	}

	
	


	public DoctorScheduleForm doctorIdFieldOfDoctor(String parameterName, String initValue){
		FormField field =  idFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm doctorIdFieldOfDoctor(String initValue){
		return doctorIdFieldOfDoctor("doctorId",initValue);
	}
	public DoctorScheduleForm doctorIdFieldOfDoctor(){
		return doctorIdFieldOfDoctor("doctorId","");
	}


	public DoctorScheduleForm nameFieldOfDoctor(String parameterName, String initValue){
		FormField field =  nameFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm nameFieldOfDoctor(String initValue){
		return nameFieldOfDoctor("name",initValue);
	}
	public DoctorScheduleForm nameFieldOfDoctor(){
		return nameFieldOfDoctor("name","");
	}


	public DoctorScheduleForm hospitalIdFieldOfDoctor(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm hospitalIdFieldOfDoctor(String initValue){
		return hospitalIdFieldOfDoctor("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdFieldOfDoctor(){
		return hospitalIdFieldOfDoctor("hospitalId","");
	}


	public DoctorScheduleForm expenseTypeIdFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  idFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm expenseTypeIdFieldOfExpenseType(String initValue){
		return expenseTypeIdFieldOfExpenseType("expenseTypeId",initValue);
	}
	public DoctorScheduleForm expenseTypeIdFieldOfExpenseType(){
		return expenseTypeIdFieldOfExpenseType("expenseTypeId","");
	}


	public DoctorScheduleForm nameFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  nameFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm nameFieldOfExpenseType(String initValue){
		return nameFieldOfExpenseType("name",initValue);
	}
	public DoctorScheduleForm nameFieldOfExpenseType(){
		return nameFieldOfExpenseType("name","");
	}


	public DoctorScheduleForm helperCharsFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  helperCharsFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm helperCharsFieldOfExpenseType(String initValue){
		return helperCharsFieldOfExpenseType("helperChars",initValue);
	}
	public DoctorScheduleForm helperCharsFieldOfExpenseType(){
		return helperCharsFieldOfExpenseType("helperChars","");
	}


	public DoctorScheduleForm statusFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  statusFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm statusFieldOfExpenseType(String initValue){
		return statusFieldOfExpenseType("status",initValue);
	}
	public DoctorScheduleForm statusFieldOfExpenseType(){
		return statusFieldOfExpenseType("status","");
	}


	public DoctorScheduleForm hospitalIdFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  hospitalIdFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm hospitalIdFieldOfExpenseType(String initValue){
		return hospitalIdFieldOfExpenseType("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdFieldOfExpenseType(){
		return hospitalIdFieldOfExpenseType("hospitalId","");
	}


	public DoctorScheduleForm descriptionFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  descriptionFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm descriptionFieldOfExpenseType(String initValue){
		return descriptionFieldOfExpenseType("description",initValue);
	}
	public DoctorScheduleForm descriptionFieldOfExpenseType(){
		return descriptionFieldOfExpenseType("description","");
	}


	public DoctorScheduleForm departmentIdFieldOfDepartment(String parameterName, String initValue){
		FormField field =  idFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm departmentIdFieldOfDepartment(String initValue){
		return departmentIdFieldOfDepartment("departmentId",initValue);
	}
	public DoctorScheduleForm departmentIdFieldOfDepartment(){
		return departmentIdFieldOfDepartment("departmentId","");
	}


	public DoctorScheduleForm nameFieldOfDepartment(String parameterName, String initValue){
		FormField field =  nameFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm nameFieldOfDepartment(String initValue){
		return nameFieldOfDepartment("name",initValue);
	}
	public DoctorScheduleForm nameFieldOfDepartment(){
		return nameFieldOfDepartment("name","");
	}


	public DoctorScheduleForm hospitalIdFieldOfDepartment(String parameterName, String initValue){
		FormField field =  hospitalIdFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm hospitalIdFieldOfDepartment(String initValue){
		return hospitalIdFieldOfDepartment("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdFieldOfDepartment(){
		return hospitalIdFieldOfDepartment("hospitalId","");
	}

	


	

	
 	public DoctorScheduleForm transferToAnotherDoctorAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDoctor/doctorScheduleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public DoctorScheduleForm transferToAnotherExpenseTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherExpenseType/doctorScheduleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public DoctorScheduleForm transferToAnotherDepartmentAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDepartment/doctorScheduleId/");
		this.addFormAction(action);
		return this;
	}

 

	public DoctorScheduleForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


