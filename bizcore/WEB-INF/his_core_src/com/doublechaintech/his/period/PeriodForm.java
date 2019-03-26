package com.doublechaintech.his.period;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class PeriodForm extends BaseForm {
	
	
	public PeriodForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PeriodForm periodIdField(String parameterName, String initValue){
		FormField field = idFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm periodIdField(String initValue){
		return periodIdField("periodId",initValue);
	}
	public PeriodForm periodIdField(){
		return periodIdField("periodId","");
	}


	public PeriodForm nameField(String parameterName, String initValue){
		FormField field = nameFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PeriodForm nameField(){
		return nameField("name","");
	}


	public PeriodForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public PeriodForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}

	
	


	public PeriodForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PeriodForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public PeriodForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public PeriodForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PeriodForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public PeriodForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public PeriodForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PeriodForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public PeriodForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public PeriodForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PeriodForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public PeriodForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	



	public PeriodForm doctorScheduleIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm doctorScheduleIdFieldForDoctorSchedule(String initValue){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId",initValue);
	}
	public PeriodForm doctorScheduleIdFieldForDoctorSchedule(){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId","");
	}


	public PeriodForm nameFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm nameFieldForDoctorSchedule(String initValue){
		return nameFieldForDoctorSchedule("name",initValue);
	}
	public PeriodForm nameFieldForDoctorSchedule(){
		return nameFieldForDoctorSchedule("name","");
	}


	public PeriodForm doctorIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm doctorIdFieldForDoctorSchedule(String initValue){
		return doctorIdFieldForDoctorSchedule("doctorId",initValue);
	}
	public PeriodForm doctorIdFieldForDoctorSchedule(){
		return doctorIdFieldForDoctorSchedule("doctorId","");
	}


	public PeriodForm scheduleDateFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm scheduleDateFieldForDoctorSchedule(String initValue){
		return scheduleDateFieldForDoctorSchedule("scheduleDate",initValue);
	}
	public PeriodForm scheduleDateFieldForDoctorSchedule(){
		return scheduleDateFieldForDoctorSchedule("scheduleDate","");
	}


	public PeriodForm periodIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  periodIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm periodIdFieldForDoctorSchedule(String initValue){
		return periodIdFieldForDoctorSchedule("periodId",initValue);
	}
	public PeriodForm periodIdFieldForDoctorSchedule(){
		return periodIdFieldForDoctorSchedule("periodId","");
	}


	public PeriodForm departmentIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm departmentIdFieldForDoctorSchedule(String initValue){
		return departmentIdFieldForDoctorSchedule("departmentId",initValue);
	}
	public PeriodForm departmentIdFieldForDoctorSchedule(){
		return departmentIdFieldForDoctorSchedule("departmentId","");
	}


	public PeriodForm availableFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm availableFieldForDoctorSchedule(String initValue){
		return availableFieldForDoctorSchedule("available",initValue);
	}
	public PeriodForm availableFieldForDoctorSchedule(){
		return availableFieldForDoctorSchedule("available","");
	}


	public PeriodForm priceFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm priceFieldForDoctorSchedule(String initValue){
		return priceFieldForDoctorSchedule("price",initValue);
	}
	public PeriodForm priceFieldForDoctorSchedule(){
		return priceFieldForDoctorSchedule("price","");
	}


	public PeriodForm expenseTypeIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm expenseTypeIdFieldForDoctorSchedule(String initValue){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId",initValue);
	}
	public PeriodForm expenseTypeIdFieldForDoctorSchedule(){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId","");
	}


	public PeriodForm createTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  createTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm createTimeFieldForDoctorSchedule(String initValue){
		return createTimeFieldForDoctorSchedule("createTime",initValue);
	}
	public PeriodForm createTimeFieldForDoctorSchedule(){
		return createTimeFieldForDoctorSchedule("createTime","");
	}


	public PeriodForm updateTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm updateTimeFieldForDoctorSchedule(String initValue){
		return updateTimeFieldForDoctorSchedule("updateTime",initValue);
	}
	public PeriodForm updateTimeFieldForDoctorSchedule(){
		return updateTimeFieldForDoctorSchedule("updateTime","");
	}


	public PeriodForm hospitalIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeriodForm hospitalIdFieldForDoctorSchedule(String initValue){
		return hospitalIdFieldForDoctorSchedule("hospitalId",initValue);
	}
	public PeriodForm hospitalIdFieldForDoctorSchedule(){
		return hospitalIdFieldForDoctorSchedule("hospitalId","");
	}

	

	
 	public PeriodForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/periodId/");
		this.addFormAction(action);
		return this;
	}

 

	public PeriodForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


