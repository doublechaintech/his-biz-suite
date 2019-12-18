
package com.doublechaintech.his.period;

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

@JsonSerialize(using = PeriodSerializer.class)
public class Period extends BaseEntity implements  java.io.Serializable{

	public static final String MORNING = "MORNING";	// 上午
	public static final String AFTERNOON = "AFTERNOON";	// 下午
	public static final String NIGHT = "NIGHT";	// 夜班
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(MORNING, "上午"));
		CODE_NAME_LIST.add(new KeyValuePair(AFTERNOON, "下午"));
		CODE_NAME_LIST.add(new KeyValuePair(NIGHT, "夜班"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String HOSPITAL_PROPERTY              = "hospital"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String DOCTOR_SCHEDULE_LIST                     = "doctorScheduleList";

	public static final String INTERNAL_TYPE="Period";
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
	protected		String              	mCode               ;
	protected		Hospital            	mHospital           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<DoctorSchedule>	mDoctorScheduleList ;
	
		
	public 	Period(){
		// lazy load for all the properties
	}
	public 	static Period withId(String id){
		Period period = new Period();
		period.setId(id);
		// period.setVersion(Integer.MAX_VALUE);
		return period;
	}
	public 	static Period refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setHospital( null );

		this.changed = true;
	}
	
	public 	Period(String name, String code, Hospital hospital)
	{
		setName(name);
		setCode(code);
		setHospital(hospital);

		this.mDoctorScheduleList = new SmartList<DoctorSchedule>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(HOSPITAL_PROPERTY.equals(property)){
			return getHospital();
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
	public Period updateId(String id){
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
	public Period updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public Period updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setHospital(Hospital hospital){
		this.mHospital = hospital;;
	}
	public Hospital getHospital(){
		return this.mHospital;
	}
	public Period updateHospital(Hospital hospital){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Period updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			doctorSchedule.setPeriod(this);
		}

		this.mDoctorScheduleList = doctorScheduleList;
		this.mDoctorScheduleList.setListInternalName (DOCTOR_SCHEDULE_LIST );
		
	}
	
	public  void addDoctorSchedule(DoctorSchedule doctorSchedule){
		doctorSchedule.setPeriod(this);
		getDoctorScheduleList().add(doctorSchedule);
	}
	public  void addDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		for( DoctorSchedule doctorSchedule:doctorScheduleList){
			doctorSchedule.setPeriod(this);
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
        // doctorSchedule.clearPeriod(); //disconnect with Period
        doctorSchedule.clearFromAll(); //disconnect with Period
		
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
		doctorSchedule.setPeriod(null);
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
		collectFromList(this, entityList, getDoctorScheduleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getDoctorScheduleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, HOSPITAL_PROPERTY, getHospital());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, DOCTOR_SCHEDULE_LIST, getDoctorScheduleList());
		if(!getDoctorScheduleList().isEmpty()){
			appendKeyValuePair(result, "doctorScheduleCount", getDoctorScheduleList().getTotalCount());
			appendKeyValuePair(result, "doctorScheduleCurrentPageNumber", getDoctorScheduleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Period){
		
		
			Period dest =(Period)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setHospital(getHospital());
			dest.setVersion(getVersion());
			dest.setDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Period){
		
			
			Period dest =(Period)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeHospital(getHospital());
			dest.mergeVersion(getVersion());
			dest.mergeDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Period){
		
			
			Period dest =(Period)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Period{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getHospital() != null ){
 			stringBuilder.append("\thospital='Hospital("+getHospital().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

