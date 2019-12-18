package com.doublechaintech.his.hospital;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class HospitalForm extends BaseForm {
	
	
	public HospitalForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public HospitalForm hospitalIdField(String parameterName, String initValue){
		FormField field = idFromHospital(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public HospitalForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}


	public HospitalForm nameField(String parameterName, String initValue){
		FormField field = nameFromHospital(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public HospitalForm nameField(){
		return nameField("name","");
	}


	public HospitalForm addressField(String parameterName, String initValue){
		FormField field = addressFromHospital(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public HospitalForm addressField(){
		return addressField("address","");
	}


	public HospitalForm telephoneField(String parameterName, String initValue){
		FormField field = telephoneFromHospital(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm telephoneField(String initValue){
		return telephoneField("telephone",initValue);
	}
	public HospitalForm telephoneField(){
		return telephoneField("telephone","");
	}

	
	

	



	public HospitalForm expenseTypeIdFieldForExpenseType(String parameterName, String initValue){
		FormField field =  idFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm expenseTypeIdFieldForExpenseType(String initValue){
		return expenseTypeIdFieldForExpenseType("expenseTypeId",initValue);
	}
	public HospitalForm expenseTypeIdFieldForExpenseType(){
		return expenseTypeIdFieldForExpenseType("expenseTypeId","");
	}


	public HospitalForm nameFieldForExpenseType(String parameterName, String initValue){
		FormField field =  nameFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForExpenseType(String initValue){
		return nameFieldForExpenseType("name",initValue);
	}
	public HospitalForm nameFieldForExpenseType(){
		return nameFieldForExpenseType("name","");
	}


	public HospitalForm helperCharsFieldForExpenseType(String parameterName, String initValue){
		FormField field =  helperCharsFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm helperCharsFieldForExpenseType(String initValue){
		return helperCharsFieldForExpenseType("helperChars",initValue);
	}
	public HospitalForm helperCharsFieldForExpenseType(){
		return helperCharsFieldForExpenseType("helperChars","");
	}


	public HospitalForm statusFieldForExpenseType(String parameterName, String initValue){
		FormField field =  statusFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm statusFieldForExpenseType(String initValue){
		return statusFieldForExpenseType("status",initValue);
	}
	public HospitalForm statusFieldForExpenseType(){
		return statusFieldForExpenseType("status","");
	}


	public HospitalForm hospitalIdFieldForExpenseType(String parameterName, String initValue){
		FormField field =  hospitalIdFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForExpenseType(String initValue){
		return hospitalIdFieldForExpenseType("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForExpenseType(){
		return hospitalIdFieldForExpenseType("hospitalId","");
	}


	public HospitalForm descriptionFieldForExpenseType(String parameterName, String initValue){
		FormField field =  descriptionFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm descriptionFieldForExpenseType(String initValue){
		return descriptionFieldForExpenseType("description",initValue);
	}
	public HospitalForm descriptionFieldForExpenseType(){
		return descriptionFieldForExpenseType("description","");
	}


	public HospitalForm updateTimeFieldForExpenseType(String parameterName, String initValue){
		FormField field =  updateTimeFromExpenseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm updateTimeFieldForExpenseType(String initValue){
		return updateTimeFieldForExpenseType("updateTime",initValue);
	}
	public HospitalForm updateTimeFieldForExpenseType(){
		return updateTimeFieldForExpenseType("updateTime","");
	}


	public HospitalForm periodIdFieldForPeriod(String parameterName, String initValue){
		FormField field =  idFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm periodIdFieldForPeriod(String initValue){
		return periodIdFieldForPeriod("periodId",initValue);
	}
	public HospitalForm periodIdFieldForPeriod(){
		return periodIdFieldForPeriod("periodId","");
	}


	public HospitalForm nameFieldForPeriod(String parameterName, String initValue){
		FormField field =  nameFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForPeriod(String initValue){
		return nameFieldForPeriod("name",initValue);
	}
	public HospitalForm nameFieldForPeriod(){
		return nameFieldForPeriod("name","");
	}


	public HospitalForm codeFieldForPeriod(String parameterName, String initValue){
		FormField field =  codeFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm codeFieldForPeriod(String initValue){
		return codeFieldForPeriod("code",initValue);
	}
	public HospitalForm codeFieldForPeriod(){
		return codeFieldForPeriod("code","");
	}


	public HospitalForm hospitalIdFieldForPeriod(String parameterName, String initValue){
		FormField field =  hospitalIdFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForPeriod(String initValue){
		return hospitalIdFieldForPeriod("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForPeriod(){
		return hospitalIdFieldForPeriod("hospitalId","");
	}


	public HospitalForm expenseItemIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  idFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm expenseItemIdFieldForExpenseItem(String initValue){
		return expenseItemIdFieldForExpenseItem("expenseItemId",initValue);
	}
	public HospitalForm expenseItemIdFieldForExpenseItem(){
		return expenseItemIdFieldForExpenseItem("expenseItemId","");
	}


	public HospitalForm nameFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  nameFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForExpenseItem(String initValue){
		return nameFieldForExpenseItem("name",initValue);
	}
	public HospitalForm nameFieldForExpenseItem(){
		return nameFieldForExpenseItem("name","");
	}


	public HospitalForm priceFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  priceFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm priceFieldForExpenseItem(String initValue){
		return priceFieldForExpenseItem("price",initValue);
	}
	public HospitalForm priceFieldForExpenseItem(){
		return priceFieldForExpenseItem("price","");
	}


	public HospitalForm expenseTypeIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm expenseTypeIdFieldForExpenseItem(String initValue){
		return expenseTypeIdFieldForExpenseItem("expenseTypeId",initValue);
	}
	public HospitalForm expenseTypeIdFieldForExpenseItem(){
		return expenseTypeIdFieldForExpenseItem("expenseTypeId","");
	}


	public HospitalForm hospitalIdFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  hospitalIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForExpenseItem(String initValue){
		return hospitalIdFieldForExpenseItem("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForExpenseItem(){
		return hospitalIdFieldForExpenseItem("hospitalId","");
	}


	public HospitalForm updateTimeFieldForExpenseItem(String parameterName, String initValue){
		FormField field =  updateTimeFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm updateTimeFieldForExpenseItem(String initValue){
		return updateTimeFieldForExpenseItem("updateTime",initValue);
	}
	public HospitalForm updateTimeFieldForExpenseItem(){
		return updateTimeFieldForExpenseItem("updateTime","");
	}


	public HospitalForm doctorIdFieldForDoctor(String parameterName, String initValue){
		FormField field =  idFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm doctorIdFieldForDoctor(String initValue){
		return doctorIdFieldForDoctor("doctorId",initValue);
	}
	public HospitalForm doctorIdFieldForDoctor(){
		return doctorIdFieldForDoctor("doctorId","");
	}


	public HospitalForm nameFieldForDoctor(String parameterName, String initValue){
		FormField field =  nameFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForDoctor(String initValue){
		return nameFieldForDoctor("name",initValue);
	}
	public HospitalForm nameFieldForDoctor(){
		return nameFieldForDoctor("name","");
	}


	public HospitalForm shotImageFieldForDoctor(String parameterName, String initValue){
		FormField field =  shotImageFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm shotImageFieldForDoctor(String initValue){
		return shotImageFieldForDoctor("shotImage",initValue);
	}
	public HospitalForm shotImageFieldForDoctor(){
		return shotImageFieldForDoctor("shotImage","");
	}


	public HospitalForm hospitalIdFieldForDoctor(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForDoctor(String initValue){
		return hospitalIdFieldForDoctor("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForDoctor(){
		return hospitalIdFieldForDoctor("hospitalId","");
	}


	public HospitalForm updateTimeFieldForDoctor(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm updateTimeFieldForDoctor(String initValue){
		return updateTimeFieldForDoctor("updateTime",initValue);
	}
	public HospitalForm updateTimeFieldForDoctor(){
		return updateTimeFieldForDoctor("updateTime","");
	}


	public HospitalForm departmentIdFieldForDepartment(String parameterName, String initValue){
		FormField field =  idFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm departmentIdFieldForDepartment(String initValue){
		return departmentIdFieldForDepartment("departmentId",initValue);
	}
	public HospitalForm departmentIdFieldForDepartment(){
		return departmentIdFieldForDepartment("departmentId","");
	}


	public HospitalForm nameFieldForDepartment(String parameterName, String initValue){
		FormField field =  nameFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForDepartment(String initValue){
		return nameFieldForDepartment("name",initValue);
	}
	public HospitalForm nameFieldForDepartment(){
		return nameFieldForDepartment("name","");
	}


	public HospitalForm hospitalIdFieldForDepartment(String parameterName, String initValue){
		FormField field =  hospitalIdFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForDepartment(String initValue){
		return hospitalIdFieldForDepartment("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForDepartment(){
		return hospitalIdFieldForDepartment("hospitalId","");
	}


	public HospitalForm updateTimeFieldForDepartment(String parameterName, String initValue){
		FormField field =  updateTimeFromDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm updateTimeFieldForDepartment(String initValue){
		return updateTimeFieldForDepartment("updateTime",initValue);
	}
	public HospitalForm updateTimeFieldForDepartment(){
		return updateTimeFieldForDepartment("updateTime","");
	}


	public HospitalForm doctorScheduleIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm doctorScheduleIdFieldForDoctorSchedule(String initValue){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId",initValue);
	}
	public HospitalForm doctorScheduleIdFieldForDoctorSchedule(){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId","");
	}


	public HospitalForm nameFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm nameFieldForDoctorSchedule(String initValue){
		return nameFieldForDoctorSchedule("name",initValue);
	}
	public HospitalForm nameFieldForDoctorSchedule(){
		return nameFieldForDoctorSchedule("name","");
	}


	public HospitalForm doctorIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm doctorIdFieldForDoctorSchedule(String initValue){
		return doctorIdFieldForDoctorSchedule("doctorId",initValue);
	}
	public HospitalForm doctorIdFieldForDoctorSchedule(){
		return doctorIdFieldForDoctorSchedule("doctorId","");
	}


	public HospitalForm scheduleDateFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm scheduleDateFieldForDoctorSchedule(String initValue){
		return scheduleDateFieldForDoctorSchedule("scheduleDate",initValue);
	}
	public HospitalForm scheduleDateFieldForDoctorSchedule(){
		return scheduleDateFieldForDoctorSchedule("scheduleDate","");
	}


	public HospitalForm periodIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  periodIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm periodIdFieldForDoctorSchedule(String initValue){
		return periodIdFieldForDoctorSchedule("periodId",initValue);
	}
	public HospitalForm periodIdFieldForDoctorSchedule(){
		return periodIdFieldForDoctorSchedule("periodId","");
	}


	public HospitalForm departmentIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm departmentIdFieldForDoctorSchedule(String initValue){
		return departmentIdFieldForDoctorSchedule("departmentId",initValue);
	}
	public HospitalForm departmentIdFieldForDoctorSchedule(){
		return departmentIdFieldForDoctorSchedule("departmentId","");
	}


	public HospitalForm availableFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm availableFieldForDoctorSchedule(String initValue){
		return availableFieldForDoctorSchedule("available",initValue);
	}
	public HospitalForm availableFieldForDoctorSchedule(){
		return availableFieldForDoctorSchedule("available","");
	}


	public HospitalForm priceFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm priceFieldForDoctorSchedule(String initValue){
		return priceFieldForDoctorSchedule("price",initValue);
	}
	public HospitalForm priceFieldForDoctorSchedule(){
		return priceFieldForDoctorSchedule("price","");
	}


	public HospitalForm expenseTypeIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm expenseTypeIdFieldForDoctorSchedule(String initValue){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId",initValue);
	}
	public HospitalForm expenseTypeIdFieldForDoctorSchedule(){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId","");
	}


	public HospitalForm createTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  createTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm createTimeFieldForDoctorSchedule(String initValue){
		return createTimeFieldForDoctorSchedule("createTime",initValue);
	}
	public HospitalForm createTimeFieldForDoctorSchedule(){
		return createTimeFieldForDoctorSchedule("createTime","");
	}


	public HospitalForm updateTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm updateTimeFieldForDoctorSchedule(String initValue){
		return updateTimeFieldForDoctorSchedule("updateTime",initValue);
	}
	public HospitalForm updateTimeFieldForDoctorSchedule(){
		return updateTimeFieldForDoctorSchedule("updateTime","");
	}


	public HospitalForm hospitalIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HospitalForm hospitalIdFieldForDoctorSchedule(String initValue){
		return hospitalIdFieldForDoctorSchedule("hospitalId",initValue);
	}
	public HospitalForm hospitalIdFieldForDoctorSchedule(){
		return hospitalIdFieldForDoctorSchedule("hospitalId","");
	}

	



	public HospitalForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


