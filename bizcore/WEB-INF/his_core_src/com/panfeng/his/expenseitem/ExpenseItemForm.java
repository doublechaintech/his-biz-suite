package com.panfeng.his.expenseitem;
import com.panfeng.his.BaseForm;
import com.panfeng.his.genericform.GenericForm;
import com.panfeng.his.formfield.FormField;
import com.panfeng.his.formaction.FormAction;
import com.panfeng.his.formmessage.FormMessage;
import com.panfeng.his.formfieldmessage.FormFieldMessage;



public class ExpenseItemForm extends BaseForm {
	
	
	public ExpenseItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ExpenseItemForm expenseItemIdField(String parameterName, String initValue){
		FormField field = idFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseItemForm expenseItemIdField(String initValue){
		return expenseItemIdField("expenseItemId",initValue);
	}
	public ExpenseItemForm expenseItemIdField(){
		return expenseItemIdField("expenseItemId","");
	}


	public ExpenseItemForm nameField(String parameterName, String initValue){
		FormField field = nameFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseItemForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ExpenseItemForm nameField(){
		return nameField("name","");
	}


	public ExpenseItemForm priceField(String parameterName, String initValue){
		FormField field = priceFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseItemForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public ExpenseItemForm priceField(){
		return priceField("price","");
	}


	public ExpenseItemForm expenseTypeIdField(String parameterName, String initValue){
		FormField field = expenseTypeIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseItemForm expenseTypeIdField(String initValue){
		return expenseTypeIdField("expenseTypeId",initValue);
	}
	public ExpenseItemForm expenseTypeIdField(){
		return expenseTypeIdField("expenseTypeId","");
	}


	public ExpenseItemForm hospitalIdField(String parameterName, String initValue){
		FormField field = hospitalIdFromExpenseItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExpenseItemForm hospitalIdField(String initValue){
		return hospitalIdField("hospitalId",initValue);
	}
	public ExpenseItemForm hospitalIdField(){
		return hospitalIdField("hospitalId","");
	}

	
	


	public ExpenseItemForm expenseTypeIdFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  idFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm expenseTypeIdFieldOfExpenseType(String initValue){
		return expenseTypeIdFieldOfExpenseType("expenseTypeId",initValue);
	}
	public ExpenseItemForm expenseTypeIdFieldOfExpenseType(){
		return expenseTypeIdFieldOfExpenseType("expenseTypeId","");
	}


	public ExpenseItemForm nameFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  nameFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm nameFieldOfExpenseType(String initValue){
		return nameFieldOfExpenseType("name",initValue);
	}
	public ExpenseItemForm nameFieldOfExpenseType(){
		return nameFieldOfExpenseType("name","");
	}


	public ExpenseItemForm helperCharsFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  helperCharsFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm helperCharsFieldOfExpenseType(String initValue){
		return helperCharsFieldOfExpenseType("helperChars",initValue);
	}
	public ExpenseItemForm helperCharsFieldOfExpenseType(){
		return helperCharsFieldOfExpenseType("helperChars","");
	}


	public ExpenseItemForm statusFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  statusFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm statusFieldOfExpenseType(String initValue){
		return statusFieldOfExpenseType("status",initValue);
	}
	public ExpenseItemForm statusFieldOfExpenseType(){
		return statusFieldOfExpenseType("status","");
	}


	public ExpenseItemForm hospitalIdFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  hospitalIdFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm hospitalIdFieldOfExpenseType(String initValue){
		return hospitalIdFieldOfExpenseType("hospitalId",initValue);
	}
	public ExpenseItemForm hospitalIdFieldOfExpenseType(){
		return hospitalIdFieldOfExpenseType("hospitalId","");
	}


	public ExpenseItemForm descriptionFieldOfExpenseType(String parameterName, String initValue){
		FormField field =  descriptionFromExpenseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm descriptionFieldOfExpenseType(String initValue){
		return descriptionFieldOfExpenseType("description",initValue);
	}
	public ExpenseItemForm descriptionFieldOfExpenseType(){
		return descriptionFieldOfExpenseType("description","");
	}


	public ExpenseItemForm hospitalIdFieldOfHospital(String parameterName, String initValue){
		FormField field =  idFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm hospitalIdFieldOfHospital(String initValue){
		return hospitalIdFieldOfHospital("hospitalId",initValue);
	}
	public ExpenseItemForm hospitalIdFieldOfHospital(){
		return hospitalIdFieldOfHospital("hospitalId","");
	}


	public ExpenseItemForm nameFieldOfHospital(String parameterName, String initValue){
		FormField field =  nameFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm nameFieldOfHospital(String initValue){
		return nameFieldOfHospital("name",initValue);
	}
	public ExpenseItemForm nameFieldOfHospital(){
		return nameFieldOfHospital("name","");
	}


	public ExpenseItemForm addressFieldOfHospital(String parameterName, String initValue){
		FormField field =  addressFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm addressFieldOfHospital(String initValue){
		return addressFieldOfHospital("address",initValue);
	}
	public ExpenseItemForm addressFieldOfHospital(){
		return addressFieldOfHospital("address","");
	}


	public ExpenseItemForm telephoneFieldOfHospital(String parameterName, String initValue){
		FormField field =  telephoneFromHospital(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExpenseItemForm telephoneFieldOfHospital(String initValue){
		return telephoneFieldOfHospital("telephone",initValue);
	}
	public ExpenseItemForm telephoneFieldOfHospital(){
		return telephoneFieldOfHospital("telephone","");
	}

	


	

	
 	public ExpenseItemForm transferToAnotherExpenseTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherExpenseType/expenseItemId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ExpenseItemForm transferToAnotherHospitalAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherHospital/expenseItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public ExpenseItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


