package com.panfeng.his.hospital;
import com.panfeng.his.BaseForm;
import com.panfeng.his.genericform.GenericForm;
import com.panfeng.his.formfield.FormField;
import com.panfeng.his.formaction.FormAction;
import com.panfeng.his.formmessage.FormMessage;
import com.panfeng.his.formfieldmessage.FormFieldMessage;



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

	



	public HospitalForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


