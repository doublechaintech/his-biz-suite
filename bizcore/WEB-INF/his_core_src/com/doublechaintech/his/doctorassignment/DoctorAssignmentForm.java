package com.doublechaintech.his.doctorassignment;
import com.doublechaintech.his.BaseForm;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;



public class DoctorAssignmentForm extends BaseForm {
	
	
	public DoctorAssignmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DoctorAssignmentForm doctorAssignmentIdField(String parameterName, String initValue){
		FormField field = idFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorAssignmentForm doctorAssignmentIdField(String initValue){
		return doctorAssignmentIdField("doctorAssignmentId",initValue);
	}
	public DoctorAssignmentForm doctorAssignmentIdField(){
		return doctorAssignmentIdField("doctorAssignmentId","");
	}


	public DoctorAssignmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorAssignmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public DoctorAssignmentForm nameField(){
		return nameField("name","");
	}


	public DoctorAssignmentForm doctorIdField(String parameterName, String initValue){
		FormField field = doctorIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorAssignmentForm doctorIdField(String initValue){
		return doctorIdField("doctorId",initValue);
	}
	public DoctorAssignmentForm doctorIdField(){
		return doctorIdField("doctorId","");
	}


	public DoctorAssignmentForm departmentIdField(String parameterName, String initValue){
		FormField field = departmentIdFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorAssignmentForm departmentIdField(String initValue){
		return departmentIdField("departmentId",initValue);
	}
	public DoctorAssignmentForm departmentIdField(){
		return departmentIdField("departmentId","");
	}


	public DoctorAssignmentForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromDoctorAssignment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DoctorAssignmentForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public DoctorAssignmentForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public DoctorAssignmentForm doctorIdFieldOfDoctor(String parameterName, String initValue){
		FormField field =  idFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm doctorIdFieldOfDoctor(String initValue){
		return doctorIdFieldOfDoctor("doctorId",initValue);
	}
	public DoctorAssignmentForm doctorIdFieldOfDoctor(){
		return doctorIdFieldOfDoctor("doctorId","");
	}


	public DoctorAssignmentForm nameFieldOfDoctor(String parameterName, String initValue){
		FormField field =  nameFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm nameFieldOfDoctor(String initValue){
		return nameFieldOfDoctor("name",initValue);
	}
	public DoctorAssignmentForm nameFieldOfDoctor(){
		return nameFieldOfDoctor("name","");
	}


	public DoctorAssignmentForm shotImageFieldOfDoctor(String parameterName, String initValue){
		FormField field =  shotImageFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm shotImageFieldOfDoctor(String initValue){
		return shotImageFieldOfDoctor("shotImage",initValue);
	}
	public DoctorAssignmentForm shotImageFieldOfDoctor(){
		return shotImageFieldOfDoctor("shotImage","");
	}


	public DoctorAssignmentForm hospitalIdFieldOfDoctor(String parameterName, String initValue){
		FormField field =  hospitalIdFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm hospitalIdFieldOfDoctor(String initValue){
		return hospitalIdFieldOfDoctor("hospitalId",initValue);
	}
	public DoctorAssignmentForm hospitalIdFieldOfDoctor(){
		return hospitalIdFieldOfDoctor("hospitalId","");
	}


	public DoctorAssignmentForm updateTimeFieldOfDoctor(String parameterName, String initValue){
		FormField field =  updateTimeFromDoctor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm updateTimeFieldOfDoctor(String initValue){
		return updateTimeFieldOfDoctor("updateTime",initValue);
	}
	public DoctorAssignmentForm updateTimeFieldOfDoctor(){
		return updateTimeFieldOfDoctor("updateTime","");
	}


	public DoctorAssignmentForm departmentIdFieldOfDepartment(String parameterName, String initValue){
		FormField field =  idFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm departmentIdFieldOfDepartment(String initValue){
		return departmentIdFieldOfDepartment("departmentId",initValue);
	}
	public DoctorAssignmentForm departmentIdFieldOfDepartment(){
		return departmentIdFieldOfDepartment("departmentId","");
	}


	public DoctorAssignmentForm nameFieldOfDepartment(String parameterName, String initValue){
		FormField field =  nameFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm nameFieldOfDepartment(String initValue){
		return nameFieldOfDepartment("name",initValue);
	}
	public DoctorAssignmentForm nameFieldOfDepartment(){
		return nameFieldOfDepartment("name","");
	}


	public DoctorAssignmentForm hospitalIdFieldOfDepartment(String parameterName, String initValue){
		FormField field =  hospitalIdFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm hospitalIdFieldOfDepartment(String initValue){
		return hospitalIdFieldOfDepartment("hospitalId",initValue);
	}
	public DoctorAssignmentForm hospitalIdFieldOfDepartment(){
		return hospitalIdFieldOfDepartment("hospitalId","");
	}


	public DoctorAssignmentForm updateTimeFieldOfDepartment(String parameterName, String initValue){
		FormField field =  updateTimeFromDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DoctorAssignmentForm updateTimeFieldOfDepartment(String initValue){
		return updateTimeFieldOfDepartment("updateTime",initValue);
	}
	public DoctorAssignmentForm updateTimeFieldOfDepartment(){
		return updateTimeFieldOfDepartment("updateTime","");
	}

	


	

	
 	public DoctorAssignmentForm transferToAnotherDoctorAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDoctor/doctorAssignmentId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public DoctorAssignmentForm transferToAnotherDepartmentAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDepartment/doctorAssignmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public DoctorAssignmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


