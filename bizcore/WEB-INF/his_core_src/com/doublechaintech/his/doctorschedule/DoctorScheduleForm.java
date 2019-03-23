package com.doublechaintech.his.doctorschedule;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



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


	public DoctorScheduleForm periodIdField(String parameterName, String initValue){
		FormField field = periodIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm periodIdField(String initValue){
		return periodIdField("periodId",initValue);
	}
	public DoctorScheduleForm periodIdField(){
		return periodIdField("periodId","");
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


	public DoctorScheduleForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public DoctorScheduleForm createTimeField(){
		return createTimeField("createTime","");
	}


	public DoctorScheduleForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public DoctorScheduleForm updateTimeField(){
		return updateTimeField("updateTime","");
	}


	public DoctorScheduleForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorScheduleForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
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


	public DoctorScheduleForm shotImageFieldOfDoctor(String parameterName, String initValue){
		FormField field =  shotImageFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm shotImageFieldOfDoctor(String initValue){
		return shotImageFieldOfDoctor("shotImage",initValue);
	}
	public DoctorScheduleForm shotImageFieldOfDoctor(){
		return shotImageFieldOfDoctor("shotImage","");
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


	public DoctorScheduleForm updateTimeFieldOfDoctor(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm updateTimeFieldOfDoctor(String initValue){
		return updateTimeFieldOfDoctor("updateTime",initValue);
	}
	public DoctorScheduleForm updateTimeFieldOfDoctor(){
		return updateTimeFieldOfDoctor("updateTime","");
	}


	public DoctorScheduleForm periodIdFieldOfPeriod(String parameterName, String initValue){
		FormField field =  idFromPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm periodIdFieldOfPeriod(String initValue){
		return periodIdFieldOfPeriod("periodId",initValue);
	}
	public DoctorScheduleForm periodIdFieldOfPeriod(){
		return periodIdFieldOfPeriod("periodId","");
	}


	public DoctorScheduleForm nameFieldOfPeriod(String parameterName, String initValue){
		FormField field =  nameFromPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm nameFieldOfPeriod(String initValue){
		return nameFieldOfPeriod("name",initValue);
	}
	public DoctorScheduleForm nameFieldOfPeriod(){
		return nameFieldOfPeriod("name","");
	}


	public DoctorScheduleForm hospitalIdFieldOfPeriod(String parameterName, String initValue){
		FormField field =  hospitalIdFromPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm hospitalIdFieldOfPeriod(String initValue){
		return hospitalIdFieldOfPeriod("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdFieldOfPeriod(){
		return hospitalIdFieldOfPeriod("hospitalId","");
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


	public DoctorScheduleForm updateTimeFieldOfDepartment(String parameterName, String initValue){
		FormField field =  updateTimeFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm updateTimeFieldOfDepartment(String initValue){
		return updateTimeFieldOfDepartment("updateTime",initValue);
	}
	public DoctorScheduleForm updateTimeFieldOfDepartment(){
		return updateTimeFieldOfDepartment("updateTime","");
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


	public DoctorScheduleForm updateTimeFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  updateTimeFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm updateTimeFieldOfExpenseType(String initValue){
		return updateTimeFieldOfExpenseType("updateTime",initValue);
	}
	public DoctorScheduleForm updateTimeFieldOfExpenseType(){
		return updateTimeFieldOfExpenseType("updateTime","");
	}


	public DoctorScheduleForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public DoctorScheduleForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public DoctorScheduleForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public DoctorScheduleForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public DoctorScheduleForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public DoctorScheduleForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public DoctorScheduleForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorScheduleForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public DoctorScheduleForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	


	

	
 	public DoctorScheduleForm transferToAnotherDoctorAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDoctor/doctorScheduleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public DoctorScheduleForm transferToAnotherPeriodAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPeriod/doctorScheduleId/");
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

 	
 	public DoctorScheduleForm transferToAnotherExpenseTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherExpenseType/doctorScheduleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public DoctorScheduleForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/doctorScheduleId/");
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


