package com.doublechaintech.his.doctor;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class DoctorForm extends BaseForm {
	
	
	public DoctorForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DoctorForm doctorIdField(String parameterName, String initValue){
		FormField field = idFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorIdField(String initValue){
		return doctorIdField("doctorId",initValue);
	}
	public DoctorForm doctorIdField(){
		return doctorIdField("doctorId","");
	}


	public DoctorForm nameField(String parameterName, String initValue){
		FormField field = nameFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public DoctorForm nameField(){
		return nameField("name","");
	}


	public DoctorForm shotImageField(String parameterName, String initValue){
		FormField field = shotImageFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm shotImageField(String initValue){
		return shotImageField("shotImage",initValue);
	}
	public DoctorForm shotImageField(){
		return shotImageField("shotImage","");
	}


	public DoctorForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public DoctorForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}


	public DoctorForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromDoctor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public DoctorForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public DoctorForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public DoctorForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public DoctorForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public DoctorForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public DoctorForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public DoctorForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public DoctorForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public DoctorForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	



	public DoctorForm doctorAssignmentIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  idFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorAssignmentIdFieldForDoctorAssignment(String initValue){
		return doctorAssignmentIdFieldForDoctorAssignment("doctorAssignmentId",initValue);
	}
	public DoctorForm doctorAssignmentIdFieldForDoctorAssignment(){
		return doctorAssignmentIdFieldForDoctorAssignment("doctorAssignmentId","");
	}


	public DoctorForm nameFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  nameFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm nameFieldForDoctorAssignment(String initValue){
		return nameFieldForDoctorAssignment("name",initValue);
	}
	public DoctorForm nameFieldForDoctorAssignment(){
		return nameFieldForDoctorAssignment("name","");
	}


	public DoctorForm doctorIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorIdFieldForDoctorAssignment(String initValue){
		return doctorIdFieldForDoctorAssignment("doctorId",initValue);
	}
	public DoctorForm doctorIdFieldForDoctorAssignment(){
		return doctorIdFieldForDoctorAssignment("doctorId","");
	}


	public DoctorForm departmentIdFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm departmentIdFieldForDoctorAssignment(String initValue){
		return departmentIdFieldForDoctorAssignment("departmentId",initValue);
	}
	public DoctorForm departmentIdFieldForDoctorAssignment(){
		return departmentIdFieldForDoctorAssignment("departmentId","");
	}


	public DoctorForm updateTimeFieldForDoctorAssignment(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm updateTimeFieldForDoctorAssignment(String initValue){
		return updateTimeFieldForDoctorAssignment("updateTime",initValue);
	}
	public DoctorForm updateTimeFieldForDoctorAssignment(){
		return updateTimeFieldForDoctorAssignment("updateTime","");
	}


	public DoctorForm doctorScheduleIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  idFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorScheduleIdFieldForDoctorSchedule(String initValue){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId",initValue);
	}
	public DoctorForm doctorScheduleIdFieldForDoctorSchedule(){
		return doctorScheduleIdFieldForDoctorSchedule("doctorScheduleId","");
	}


	public DoctorForm nameFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  nameFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm nameFieldForDoctorSchedule(String initValue){
		return nameFieldForDoctorSchedule("name",initValue);
	}
	public DoctorForm nameFieldForDoctorSchedule(){
		return nameFieldForDoctorSchedule("name","");
	}


	public DoctorForm doctorIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  doctorIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm doctorIdFieldForDoctorSchedule(String initValue){
		return doctorIdFieldForDoctorSchedule("doctorId",initValue);
	}
	public DoctorForm doctorIdFieldForDoctorSchedule(){
		return doctorIdFieldForDoctorSchedule("doctorId","");
	}


	public DoctorForm scheduleDateFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  scheduleDateFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm scheduleDateFieldForDoctorSchedule(String initValue){
		return scheduleDateFieldForDoctorSchedule("scheduleDate",initValue);
	}
	public DoctorForm scheduleDateFieldForDoctorSchedule(){
		return scheduleDateFieldForDoctorSchedule("scheduleDate","");
	}


	public DoctorForm periodIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  periodIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm periodIdFieldForDoctorSchedule(String initValue){
		return periodIdFieldForDoctorSchedule("periodId",initValue);
	}
	public DoctorForm periodIdFieldForDoctorSchedule(){
		return periodIdFieldForDoctorSchedule("periodId","");
	}


	public DoctorForm departmentIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  departmentIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm departmentIdFieldForDoctorSchedule(String initValue){
		return departmentIdFieldForDoctorSchedule("departmentId",initValue);
	}
	public DoctorForm departmentIdFieldForDoctorSchedule(){
		return departmentIdFieldForDoctorSchedule("departmentId","");
	}


	public DoctorForm availableFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  availableFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm availableFieldForDoctorSchedule(String initValue){
		return availableFieldForDoctorSchedule("available",initValue);
	}
	public DoctorForm availableFieldForDoctorSchedule(){
		return availableFieldForDoctorSchedule("available","");
	}


	public DoctorForm priceFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  priceFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm priceFieldForDoctorSchedule(String initValue){
		return priceFieldForDoctorSchedule("price",initValue);
	}
	public DoctorForm priceFieldForDoctorSchedule(){
		return priceFieldForDoctorSchedule("price","");
	}


	public DoctorForm expenseTypeIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  expenseTypeIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm expenseTypeIdFieldForDoctorSchedule(String initValue){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId",initValue);
	}
	public DoctorForm expenseTypeIdFieldForDoctorSchedule(){
		return expenseTypeIdFieldForDoctorSchedule("expenseTypeId","");
	}


	public DoctorForm createTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  createTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm createTimeFieldForDoctorSchedule(String initValue){
		return createTimeFieldForDoctorSchedule("createTime",initValue);
	}
	public DoctorForm createTimeFieldForDoctorSchedule(){
		return createTimeFieldForDoctorSchedule("createTime","");
	}


	public DoctorForm updateTimeFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm updateTimeFieldForDoctorSchedule(String initValue){
		return updateTimeFieldForDoctorSchedule("updateTime",initValue);
	}
	public DoctorForm updateTimeFieldForDoctorSchedule(){
		return updateTimeFieldForDoctorSchedule("updateTime","");
	}


	public DoctorForm hospitalIdFieldForDoctorSchedule(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctorSchedule(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorForm hospitalIdFieldForDoctorSchedule(String initValue){
		return hospitalIdFieldForDoctorSchedule("hospitalId",initValue);
	}
	public DoctorForm hospitalIdFieldForDoctorSchedule(){
		return hospitalIdFieldForDoctorSchedule("hospitalId","");
	}

	

	
 	public DoctorForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/doctorId/");
		this.addFormAction(action);
		return this;
	}

 

	public DoctorForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


