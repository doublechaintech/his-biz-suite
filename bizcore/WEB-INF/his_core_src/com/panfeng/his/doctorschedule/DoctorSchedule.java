
package com.panfeng.his.doctorschedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panfeng.his.doctor.Doctor;
import com.panfeng.his.department.Department;
import com.panfeng.his.expensetype.ExpenseType;

@JsonSerialize(using = DoctorScheduleSerializer.class)
public class DoctorSchedule extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SCHEDULE_DATE_PROPERTY         = "scheduleDate"      ;
	public static final String PERIOD_PROPERTY                = "period"            ;
	public static final String DOCTOR_PROPERTY                = "doctor"            ;
	public static final String AVAILABLE_PROPERTY             = "available"         ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String EXPENSE_TYPE_PROPERTY          = "expenseType"       ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="DoctorSchedule";
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
	protected		Date                	mScheduleDate       ;
	protected		String              	mPeriod             ;
	protected		Doctor              	mDoctor             ;
	protected		int                 	mAvailable          ;
	protected		BigDecimal          	mPrice              ;
	protected		ExpenseType         	mExpenseType        ;
	protected		Department          	mDepartment         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	DoctorSchedule(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDoctor( null );
		setExpenseType( null );
		setDepartment( null );

		this.changed = true;
	}
	
	public 	DoctorSchedule(String name, Date scheduleDate, String period, Doctor doctor, int available, BigDecimal price, ExpenseType expenseType, Department department)
	{
		setName(name);
		setScheduleDate(scheduleDate);
		setPeriod(period);
		setDoctor(doctor);
		setAvailable(available);
		setPrice(price);
		setExpenseType(expenseType);
		setDepartment(department);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SCHEDULE_DATE_PROPERTY.equals(property)){
			changeScheduleDateProperty(newValueExpr);
		}
		if(PERIOD_PROPERTY.equals(property)){
			changePeriodProperty(newValueExpr);
		}
		if(AVAILABLE_PROPERTY.equals(property)){
			changeAvailableProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
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
			
			
			
	protected void changeScheduleDateProperty(String newValueExpr){
		Date oldValue = getScheduleDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateScheduleDate(newValue);
		this.onChangeProperty(SCHEDULE_DATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePeriodProperty(String newValueExpr){
		String oldValue = getPeriod();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePeriod(newValue);
		this.onChangeProperty(PERIOD_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAvailableProperty(String newValueExpr){
		int oldValue = getAvailable();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAvailable(newValue);
		this.onChangeProperty(AVAILABLE_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public DoctorSchedule updateId(String id){
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
	public DoctorSchedule updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setScheduleDate(Date scheduleDate){
		this.mScheduleDate = scheduleDate;;
	}
	public Date getScheduleDate(){
		return this.mScheduleDate;
	}
	public DoctorSchedule updateScheduleDate(Date scheduleDate){
		this.mScheduleDate = scheduleDate;;
		this.changed = true;
		return this;
	}
	public void mergeScheduleDate(Date scheduleDate){
		setScheduleDate(scheduleDate);
	}
	
	
	public void setPeriod(String period){
		this.mPeriod = trimString(period);;
	}
	public String getPeriod(){
		return this.mPeriod;
	}
	public DoctorSchedule updatePeriod(String period){
		this.mPeriod = trimString(period);;
		this.changed = true;
		return this;
	}
	public void mergePeriod(String period){
		if(period != null) { setPeriod(period);}
	}
	
	
	public void setDoctor(Doctor doctor){
		this.mDoctor = doctor;;
	}
	public Doctor getDoctor(){
		return this.mDoctor;
	}
	public DoctorSchedule updateDoctor(Doctor doctor){
		this.mDoctor = doctor;;
		this.changed = true;
		return this;
	}
	public void mergeDoctor(Doctor doctor){
		if(doctor != null) { setDoctor(doctor);}
	}
	
	
	public void clearDoctor(){
		setDoctor ( null );
		this.changed = true;
	}
	
	public void setAvailable(int available){
		this.mAvailable = available;;
	}
	public int getAvailable(){
		return this.mAvailable;
	}
	public DoctorSchedule updateAvailable(int available){
		this.mAvailable = available;;
		this.changed = true;
		return this;
	}
	public void mergeAvailable(int available){
		setAvailable(available);
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public DoctorSchedule updatePrice(BigDecimal price){
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
	public DoctorSchedule updateExpenseType(ExpenseType expenseType){
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
	
	public void setDepartment(Department department){
		this.mDepartment = department;;
	}
	public Department getDepartment(){
		return this.mDepartment;
	}
	public DoctorSchedule updateDepartment(Department department){
		this.mDepartment = department;;
		this.changed = true;
		return this;
	}
	public void mergeDepartment(Department department){
		if(department != null) { setDepartment(department);}
	}
	
	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public DoctorSchedule updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDoctor(), internalType);
		addToEntityList(this, entityList, getExpenseType(), internalType);
		addToEntityList(this, entityList, getDepartment(), internalType);

		
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
		appendKeyValuePair(result, SCHEDULE_DATE_PROPERTY, getScheduleDate());
		appendKeyValuePair(result, PERIOD_PROPERTY, getPeriod());
		appendKeyValuePair(result, DOCTOR_PROPERTY, getDoctor());
		appendKeyValuePair(result, AVAILABLE_PROPERTY, getAvailable());
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, EXPENSE_TYPE_PROPERTY, getExpenseType());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof DoctorSchedule){
		
		
			DoctorSchedule dest =(DoctorSchedule)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setScheduleDate(getScheduleDate());
			dest.setPeriod(getPeriod());
			dest.setDoctor(getDoctor());
			dest.setAvailable(getAvailable());
			dest.setPrice(getPrice());
			dest.setExpenseType(getExpenseType());
			dest.setDepartment(getDepartment());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof DoctorSchedule){
		
			
			DoctorSchedule dest =(DoctorSchedule)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeScheduleDate(getScheduleDate());
			dest.mergePeriod(getPeriod());
			dest.mergeDoctor(getDoctor());
			dest.mergeAvailable(getAvailable());
			dest.mergePrice(getPrice());
			dest.mergeExpenseType(getExpenseType());
			dest.mergeDepartment(getDepartment());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("DoctorSchedule{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tscheduleDate='"+getScheduleDate()+"';");
		stringBuilder.append("\tperiod='"+getPeriod()+"';");
		if(getDoctor() != null ){
 			stringBuilder.append("\tdoctor='Doctor("+getDoctor().getId()+")';");
 		}
		stringBuilder.append("\tavailable='"+getAvailable()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		if(getExpenseType() != null ){
 			stringBuilder.append("\texpenseType='ExpenseType("+getExpenseType().getId()+")';");
 		}
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='Department("+getDepartment().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAvailable(int incAvailable){
		updateAvailable(this.mAvailable +  incAvailable);
	}
	public void decreaseAvailable(int decAvailable){
		updateAvailable(this.mAvailable - decAvailable);
	}
	

}

