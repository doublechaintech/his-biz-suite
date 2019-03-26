package com.doublechaintech.his.expensetype;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class ExpenseTypeForm extends BaseForm {
	
	
	public ExpenseTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ExpenseTypeForm expenseTypeIdField(String parameterName, String initValue){
		FormField field = idFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm expenseTypeIdField(String initValue){
		return expenseTypeIdField("expenseTypeId",initValue);
	}
	public ExpenseTypeForm expenseTypeIdField(){
		return expenseTypeIdField("expenseTypeId","");
	}


	public ExpenseTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ExpenseTypeForm nameField(){
		return nameField("name","");
	}


	public ExpenseTypeForm helperCharsField(String parameterName, String initValue){
		FormField field = helperCharsFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm helperCharsField(String initValue){
		return helperCharsField("helperChars",initValue);
	}
	public ExpenseTypeForm helperCharsField(){
		return helperCharsField("helperChars","");
	}


	public ExpenseTypeForm statusField(String parameterName, String initValue){
		FormField field = statusFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm statusField(String initValue){
		return statusField("status",initValue);
	}
	public ExpenseTypeForm statusField(){
		return statusField("status","");
	}


	public ExpenseTypeForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public ExpenseTypeForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}


	public ExpenseTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public ExpenseTypeForm descriptionField(){
		return descriptionField("description","");
	}


	public ExpenseTypeForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public ExpenseTypeForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public ExpenseTypeForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseTypeForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public ExpenseTypeForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public ExpenseTypeForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseTypeForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public ExpenseTypeForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public ExpenseTypeForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseTypeForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public ExpenseTypeForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public ExpenseTypeForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseTypeForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public ExpenseTypeForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	



	public ExpenseTypeForm expenseItemIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  idFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm expenseItemIdFieldForExpenseItem(String initValue){
		return expenseItemIdFieldForExpenseItem("expenseItemId",initValue);
	}
	public ExpenseTypeForm expenseItemIdFieldForExpenseItem(){
		return expenseItemIdFieldForExpenseItem("expenseItemId","");
	}


	public ExpenseTypeForm nameFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  nameFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm nameFieldForExpenseItem(String initValue){
		return nameFieldForExpenseItem("name",initValue);
	}
	public ExpenseTypeForm nameFieldForExpenseItem(){
		return nameFieldForExpenseItem("name","");
	}


	public ExpenseTypeForm priceFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  priceFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm priceFieldForExpenseItem(String initValue){
		return priceFieldForExpenseItem("price",initValue);
	}
	public ExpenseTypeForm priceFieldForExpenseItem(){
		return priceFieldForExpenseItem("price","");
	}


	public ExpenseTypeForm expenseTypeIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm expenseTypeIdFieldForExpenseItem(String initValue){
		return expenseTypeIdFieldForExpenseItem("expenseTypeId",initValue);
	}
	public ExpenseTypeForm expenseTypeIdFieldForExpenseItem(){
		return expenseTypeIdFieldForExpenseItem("expenseTypeId","");
	}


	public ExpenseTypeForm hospitalIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  hospitalIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm hospitalIdFieldForExpenseItem(String initValue){
		return hospitalIdFieldForExpenseItem("hospitalId",initValue);
	}
	public ExpenseTypeForm hospitalIdFieldForExpenseItem(){
		return hospitalIdFieldForExpenseItem("hospitalId","");
	}


	public ExpenseTypeForm updateTimeFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  updateTimeFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm updateTimeFieldForExpenseItem(String initValue){
		return updateTimeFieldForExpenseItem("updateTime",initValue);
	}
	public ExpenseTypeForm updateTimeFieldForExpenseItem(){
		return updateTimeFieldForExpenseItem("updateTime","");
	}


	public ExpenseTypeForm doctorScheduleIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm doctorScheduleIdFieldForDoctorSchedule(String initValue){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId",initValue);
	}
	public ExpenseTypeForm doctorScheduleIdFieldForDoctorSchedule(){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId","");
	}


	public ExpenseTypeForm nameFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm nameFieldForDoctorSchedule(String initValue){
		return nameFieldForDoctorSchedule("name",initValue);
	}
	public ExpenseTypeForm nameFieldForDoctorSchedule(){
		return nameFieldForDoctorSchedule("name","");
	}


	public ExpenseTypeForm doctorIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm doctorIdFieldForDoctorSchedule(String initValue){
		return doctorIdFieldForDoctorSchedule("doctorId",initValue);
	}
	public ExpenseTypeForm doctorIdFieldForDoctorSchedule(){
		return doctorIdFieldForDoctorSchedule("doctorId","");
	}


	public ExpenseTypeForm scheduleDateFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm scheduleDateFieldForDoctorSchedule(String initValue){
		return scheduleDateFieldForDoctorSchedule("scheduleDate",initValue);
	}
	public ExpenseTypeForm scheduleDateFieldForDoctorSchedule(){
		return scheduleDateFieldForDoctorSchedule("scheduleDate","");
	}


	public ExpenseTypeForm periodIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  periodIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm periodIdFieldForDoctorSchedule(String initValue){
		return periodIdFieldForDoctorSchedule("periodId",initValue);
	}
	public ExpenseTypeForm periodIdFieldForDoctorSchedule(){
		return periodIdFieldForDoctorSchedule("periodId","");
	}


	public ExpenseTypeForm departmentIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm departmentIdFieldForDoctorSchedule(String initValue){
		return departmentIdFieldForDoctorSchedule("departmentId",initValue);
	}
	public ExpenseTypeForm departmentIdFieldForDoctorSchedule(){
		return departmentIdFieldForDoctorSchedule("departmentId","");
	}


	public ExpenseTypeForm availableFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm availableFieldForDoctorSchedule(String initValue){
		return availableFieldForDoctorSchedule("available",initValue);
	}
	public ExpenseTypeForm availableFieldForDoctorSchedule(){
		return availableFieldForDoctorSchedule("available","");
	}


	public ExpenseTypeForm priceFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm priceFieldForDoctorSchedule(String initValue){
		return priceFieldForDoctorSchedule("price",initValue);
	}
	public ExpenseTypeForm priceFieldForDoctorSchedule(){
		return priceFieldForDoctorSchedule("price","");
	}


	public ExpenseTypeForm expenseTypeIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm expenseTypeIdFieldForDoctorSchedule(String initValue){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId",initValue);
	}
	public ExpenseTypeForm expenseTypeIdFieldForDoctorSchedule(){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId","");
	}


	public ExpenseTypeForm createTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  createTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm createTimeFieldForDoctorSchedule(String initValue){
		return createTimeFieldForDoctorSchedule("createTime",initValue);
	}
	public ExpenseTypeForm createTimeFieldForDoctorSchedule(){
		return createTimeFieldForDoctorSchedule("createTime","");
	}


	public ExpenseTypeForm updateTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm updateTimeFieldForDoctorSchedule(String initValue){
		return updateTimeFieldForDoctorSchedule("updateTime",initValue);
	}
	public ExpenseTypeForm updateTimeFieldForDoctorSchedule(){
		return updateTimeFieldForDoctorSchedule("updateTime","");
	}


	public ExpenseTypeForm hospitalIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseTypeForm hospitalIdFieldForDoctorSchedule(String initValue){
		return hospitalIdFieldForDoctorSchedule("hospitalId",initValue);
	}
	public ExpenseTypeForm hospitalIdFieldForDoctorSchedule(){
		return hospitalIdFieldForDoctorSchedule("hospitalId","");
	}

	

	
 	public ExpenseTypeForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/expenseTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public ExpenseTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


