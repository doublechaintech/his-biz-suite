
package com.doublechaintech.his.expensetype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.expenseitem.ExpenseItem;

@JsonSerialize(using = ExpenseTypeSerializer.class)
public class ExpenseType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String HELPER_CHARS_PROPERTY          = "helperChars"       ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String HOSPITAL_PROPERTY              = "hospital"          ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EXPENSE_ITEM_LIST                        = "expenseItemList"   ;
	public static final String DOCTOR_SCHEDULE_LIST                     = "doctorScheduleList";

	public static final String INTERNAL_TYPE="ExpenseType";
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
	protected		String              	mHelperChars        ;
	protected		String              	mStatus             ;
	protected		Hospital            	mHospital           ;
	protected		String              	mDescription        ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ExpenseItem>	mExpenseItemList    ;
	protected		SmartList<DoctorSchedule>	mDoctorScheduleList ;
	
		
	public 	ExpenseType(){
		// lazy load for all the properties
	}
	public 	static ExpenseType withId(String id){
		ExpenseType expenseType = new ExpenseType();
		expenseType.setId(id);
		// expenseType.setVersion(Integer.MAX_VALUE);
		return expenseType;
	}
	public 	static ExpenseType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setHospital( null );

		this.changed = true;
	}
	
	public 	ExpenseType(String name, String helperChars, String status, Hospital hospital, String description, DateTime updateTime)
	{
		setName(name);
		setHelperChars(helperChars);
		setStatus(status);
		setHospital(hospital);
		setDescription(description);
		setUpdateTime(updateTime);

		this.mExpenseItemList = new SmartList<ExpenseItem>();
		this.mDoctorScheduleList = new SmartList<DoctorSchedule>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(HELPER_CHARS_PROPERTY.equals(property)){
			changeHelperCharsProperty(newValueExpr);
		}
		if(STATUS_PROPERTY.equals(property)){
			changeStatusProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeHelperCharsProperty(String newValueExpr){
		String oldValue = getHelperChars();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateHelperChars(newValue);
		this.onChangeProperty(HELPER_CHARS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeStatusProperty(String newValueExpr){
		String oldValue = getStatus();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStatus(newValue);
		this.onChangeProperty(STATUS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(HELPER_CHARS_PROPERTY.equals(property)){
			return getHelperChars();
		}
		if(STATUS_PROPERTY.equals(property)){
			return getStatus();
		}
		if(HOSPITAL_PROPERTY.equals(property)){
			return getHospital();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			return getUpdateTime();
		}
		if(EXPENSE_ITEM_LIST.equals(property)){
			List<BaseEntity> list = getExpenseItemList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(DOCTOR_SCHEDULE_LIST.equals(property)){
			List<BaseEntity> list = getDoctorScheduleList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ExpenseType updateId(String id){
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
	public ExpenseType updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setHelperChars(String helperChars){
		this.mHelperChars = trimString(helperChars);;
	}
	public String getHelperChars(){
		return this.mHelperChars;
	}
	public ExpenseType updateHelperChars(String helperChars){
		this.mHelperChars = trimString(helperChars);;
		this.changed = true;
		return this;
	}
	public void mergeHelperChars(String helperChars){
		if(helperChars != null) { setHelperChars(helperChars);}
	}
	
	
	public void setStatus(String status){
		this.mStatus = trimString(status);;
	}
	public String getStatus(){
		return this.mStatus;
	}
	public ExpenseType updateStatus(String status){
		this.mStatus = trimString(status);;
		this.changed = true;
		return this;
	}
	public void mergeStatus(String status){
		if(status != null) { setStatus(status);}
	}
	
	
	public void setHospital(Hospital hospital){
		this.mHospital = hospital;;
	}
	public Hospital getHospital(){
		return this.mHospital;
	}
	public ExpenseType updateHospital(Hospital hospital){
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
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public ExpenseType updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public ExpenseType updateUpdateTime(DateTime updateTime){
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
	public ExpenseType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ExpenseItem> getExpenseItemList(){
		if(this.mExpenseItemList == null){
			this.mExpenseItemList = new SmartList<ExpenseItem>();
			this.mExpenseItemList.setListInternalName (EXPENSE_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mExpenseItemList;	
	}
	public  void setExpenseItemList(SmartList<ExpenseItem> expenseItemList){
		for( ExpenseItem expenseItem:expenseItemList){
			expenseItem.setExpenseType(this);
		}

		this.mExpenseItemList = expenseItemList;
		this.mExpenseItemList.setListInternalName (EXPENSE_ITEM_LIST );
		
	}
	
	public  void addExpenseItem(ExpenseItem expenseItem){
		expenseItem.setExpenseType(this);
		getExpenseItemList().add(expenseItem);
	}
	public  void addExpenseItemList(SmartList<ExpenseItem> expenseItemList){
		for( ExpenseItem expenseItem:expenseItemList){
			expenseItem.setExpenseType(this);
		}
		getExpenseItemList().addAll(expenseItemList);
	}
	public  void mergeExpenseItemList(SmartList<ExpenseItem> expenseItemList){
		if(expenseItemList==null){
			return;
		}
		if(expenseItemList.isEmpty()){
			return;
		}
		addExpenseItemList( expenseItemList );
		
	}
	public  ExpenseItem removeExpenseItem(ExpenseItem expenseItemIndex){
		
		int index = getExpenseItemList().indexOf(expenseItemIndex);
        if(index < 0){
        	String message = "ExpenseItem("+expenseItemIndex.getId()+") with version='"+expenseItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ExpenseItem expenseItem = getExpenseItemList().get(index);        
        // expenseItem.clearExpenseType(); //disconnect with ExpenseType
        expenseItem.clearFromAll(); //disconnect with ExpenseType
		
		boolean result = getExpenseItemList().planToRemove(expenseItem);
        if(!result){
        	String message = "ExpenseItem("+expenseItemIndex.getId()+") with version='"+expenseItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return expenseItem;
        
	
	}
	//断舍离
	public  void breakWithExpenseItem(ExpenseItem expenseItem){
		
		if(expenseItem == null){
			return;
		}
		expenseItem.setExpenseType(null);
		//getExpenseItemList().remove();
	
	}
	
	public  boolean hasExpenseItem(ExpenseItem expenseItem){
	
		return getExpenseItemList().contains(expenseItem);
  
	}
	
	public void copyExpenseItemFrom(ExpenseItem expenseItem) {

		ExpenseItem expenseItemInList = findTheExpenseItem(expenseItem);
		ExpenseItem newExpenseItem = new ExpenseItem();
		expenseItemInList.copyTo(newExpenseItem);
		newExpenseItem.setVersion(0);//will trigger copy
		getExpenseItemList().add(newExpenseItem);
		addItemToFlexiableObject(COPIED_CHILD, newExpenseItem);
	}
	
	public  ExpenseItem findTheExpenseItem(ExpenseItem expenseItem){
		
		int index =  getExpenseItemList().indexOf(expenseItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ExpenseItem("+expenseItem.getId()+") with version='"+expenseItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getExpenseItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpExpenseItemList(){
		getExpenseItemList().clear();
	}
	
	
	


	public  SmartList<DoctorSchedule> getDoctorScheduleList(){
		if(this.mDoctorScheduleList == null){
			this.mDoctorScheduleList = new SmartList<DoctorSchedule>();
			this.mDoctorScheduleList.setListInternalName (DOCTOR_SCHEDULE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mDoctorScheduleList;	
	}
	public  void setDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		for( DoctorSchedule doctorSchedule:doctorScheduleList){
			doctorSchedule.setExpenseType(this);
		}

		this.mDoctorScheduleList = doctorScheduleList;
		this.mDoctorScheduleList.setListInternalName (DOCTOR_SCHEDULE_LIST );
		
	}
	
	public  void addDoctorSchedule(DoctorSchedule doctorSchedule){
		doctorSchedule.setExpenseType(this);
		getDoctorScheduleList().add(doctorSchedule);
	}
	public  void addDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		for( DoctorSchedule doctorSchedule:doctorScheduleList){
			doctorSchedule.setExpenseType(this);
		}
		getDoctorScheduleList().addAll(doctorScheduleList);
	}
	public  void mergeDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		if(doctorScheduleList==null){
			return;
		}
		if(doctorScheduleList.isEmpty()){
			return;
		}
		addDoctorScheduleList( doctorScheduleList );
		
	}
	public  DoctorSchedule removeDoctorSchedule(DoctorSchedule doctorScheduleIndex){
		
		int index = getDoctorScheduleList().indexOf(doctorScheduleIndex);
        if(index < 0){
        	String message = "DoctorSchedule("+doctorScheduleIndex.getId()+") with version='"+doctorScheduleIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        DoctorSchedule doctorSchedule = getDoctorScheduleList().get(index);        
        // doctorSchedule.clearExpenseType(); //disconnect with ExpenseType
        doctorSchedule.clearFromAll(); //disconnect with ExpenseType
		
		boolean result = getDoctorScheduleList().planToRemove(doctorSchedule);
        if(!result){
        	String message = "DoctorSchedule("+doctorScheduleIndex.getId()+") with version='"+doctorScheduleIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return doctorSchedule;
        
	
	}
	//断舍离
	public  void breakWithDoctorSchedule(DoctorSchedule doctorSchedule){
		
		if(doctorSchedule == null){
			return;
		}
		doctorSchedule.setExpenseType(null);
		//getDoctorScheduleList().remove();
	
	}
	
	public  boolean hasDoctorSchedule(DoctorSchedule doctorSchedule){
	
		return getDoctorScheduleList().contains(doctorSchedule);
  
	}
	
	public void copyDoctorScheduleFrom(DoctorSchedule doctorSchedule) {

		DoctorSchedule doctorScheduleInList = findTheDoctorSchedule(doctorSchedule);
		DoctorSchedule newDoctorSchedule = new DoctorSchedule();
		doctorScheduleInList.copyTo(newDoctorSchedule);
		newDoctorSchedule.setVersion(0);//will trigger copy
		getDoctorScheduleList().add(newDoctorSchedule);
		addItemToFlexiableObject(COPIED_CHILD, newDoctorSchedule);
	}
	
	public  DoctorSchedule findTheDoctorSchedule(DoctorSchedule doctorSchedule){
		
		int index =  getDoctorScheduleList().indexOf(doctorSchedule);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "DoctorSchedule("+doctorSchedule.getId()+") with version='"+doctorSchedule.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getDoctorScheduleList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDoctorScheduleList(){
		getDoctorScheduleList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getHospital(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getExpenseItemList(), internalType);
		collectFromList(this, entityList, getDoctorScheduleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getExpenseItemList());
		listOfList.add( getDoctorScheduleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, HELPER_CHARS_PROPERTY, getHelperChars());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, HOSPITAL_PROPERTY, getHospital());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EXPENSE_ITEM_LIST, getExpenseItemList());
		if(!getExpenseItemList().isEmpty()){
			appendKeyValuePair(result, "expenseItemCount", getExpenseItemList().getTotalCount());
			appendKeyValuePair(result, "expenseItemCurrentPageNumber", getExpenseItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DOCTOR_SCHEDULE_LIST, getDoctorScheduleList());
		if(!getDoctorScheduleList().isEmpty()){
			appendKeyValuePair(result, "doctorScheduleCount", getDoctorScheduleList().getTotalCount());
			appendKeyValuePair(result, "doctorScheduleCurrentPageNumber", getDoctorScheduleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExpenseType){
		
		
			ExpenseType dest =(ExpenseType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setHelperChars(getHelperChars());
			dest.setStatus(getStatus());
			dest.setHospital(getHospital());
			dest.setDescription(getDescription());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setExpenseItemList(getExpenseItemList());
			dest.setDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExpenseType){
		
			
			ExpenseType dest =(ExpenseType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeHelperChars(getHelperChars());
			dest.mergeStatus(getStatus());
			dest.mergeHospital(getHospital());
			dest.mergeDescription(getDescription());
			dest.mergeUpdateTime(getUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeExpenseItemList(getExpenseItemList());
			dest.mergeDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExpenseType){
		
			
			ExpenseType dest =(ExpenseType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeHelperChars(getHelperChars());
			dest.mergeStatus(getStatus());
			dest.mergeDescription(getDescription());
			dest.mergeUpdateTime(getUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ExpenseType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\thelperChars='"+getHelperChars()+"';");
		stringBuilder.append("\tstatus='"+getStatus()+"';");
		if(getHospital() != null ){
 			stringBuilder.append("\thospital='Hospital("+getHospital().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

