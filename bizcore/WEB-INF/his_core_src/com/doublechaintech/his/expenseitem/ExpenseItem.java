
package com.doublechaintech.his.expenseitem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;

@JsonSerialize(using = ExpenseItemSerializer.class)
public class ExpenseItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String EXPENSE_TYPE_PROPERTY          = "expenseType"       ;
	public static final String HOSPITAL_PROPERTY              = "hospital"          ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ExpenseItem";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		BigDecimal          	mPrice              ;
	protected		ExpenseType         	mExpenseType        ;
	protected		Hospital            	mHospital           ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ExpenseItem(){
		// lazy load for all the properties
	}
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setExpenseType( null );
		setHospital( null );

		this.changed = true;
	}
	
	public 	ExpenseItem(String name, BigDecimal price, ExpenseType expenseType, Hospital hospital, DateTime updateTime)
	{
		setName(name);
		setPrice(price);
		setExpenseType(expenseType);
		setHospital(hospital);
		setUpdateTime(updateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			changeUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePriceProperty(String newValueExpr){
		BigDecimal oldValue = getPrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePrice(newValue);
		this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUpdateTime(newValue);
		this.onChangeProperty(UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ExpenseItem updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public ExpenseItem updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public ExpenseItem updatePrice(BigDecimal price){
		this.mPrice = price;;
		this.changed = true;
		return this;
	}
	public void mergePrice(BigDecimal price){
		setPrice(price);
	}
	
	
	public void setExpenseType(ExpenseType expenseType){
		this.mExpenseType = expenseType;;
	}
	public ExpenseType getExpenseType(){
		return this.mExpenseType;
	}
	public ExpenseItem updateExpenseType(ExpenseType expenseType){
		this.mExpenseType = expenseType;;
		this.changed = true;
		return this;
	}
	public void mergeExpenseType(ExpenseType expenseType){
		if(expenseType != null) { setExpenseType(expenseType);}
	}
	
	
	public void clearExpenseType(){
		setExpenseType ( null );
		this.changed = true;
	}
	
	public void setHospital(Hospital hospital){
		this.mHospital = hospital;;
	}
	public Hospital getHospital(){
		return this.mHospital;
	}
	public ExpenseItem updateHospital(Hospital hospital){
		this.mHospital = hospital;;
		this.changed = true;
		return this;
	}
	public void mergeHospital(Hospital hospital){
		if(hospital != null) { setHospital(hospital);}
	}
	
	
	public void clearHospital(){
		setHospital ( null );
		this.changed = true;
	}
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public ExpenseItem updateUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
		this.changed = true;
		return this;
	}
	public void mergeUpdateTime(DateTime updateTime){
		setUpdateTime(updateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ExpenseItem updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getExpenseType(), internalType);
		addToEntityList(this, entityList, getHospital(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, EXPENSE_TYPE_PROPERTY, getExpenseType());
		appendKeyValuePair(result, HOSPITAL_PROPERTY, getHospital());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExpenseItem){
		
		
			ExpenseItem dest =(ExpenseItem)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPrice(getPrice());
			dest.setExpenseType(getExpenseType());
			dest.setHospital(getHospital());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExpenseItem){
		
			
			ExpenseItem dest =(ExpenseItem)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePrice(getPrice());
			dest.mergeExpenseType(getExpenseType());
			dest.mergeHospital(getHospital());
			dest.mergeUpdateTime(getUpdateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ExpenseItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		if(getExpenseType() != null ){
 			stringBuilder.append("\texpenseType='ExpenseType("+getExpenseType().getId()+")';");
 		}
		if(getHospital() != null ){
 			stringBuilder.append("\thospital='Hospital("+getHospital().getId()+")';");
 		}
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

