
package com.panfeng.his.doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.panfeng.his.BaseEntity;
import com.panfeng.his.SmartList;
import com.panfeng.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panfeng.his.doctorassignment.DoctorAssignment;
import com.panfeng.his.hospital.Hospital;
import com.panfeng.his.doctorschedule.DoctorSchedule;

@JsonSerialize(using = DoctorSerializer.class)
public class Doctor extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String HOSPITAL_PROPERTY              = "hospital"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String DOCTOR_ASSIGNMENT_LIST                   = "doctorAssignmentList";
	public static final String DOCTOR_SCHEDULE_LIST                     = "doctorScheduleList";

	public static final String INTERNAL_TYPE="Doctor";
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
	protected		Hospital            	mHospital           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<DoctorAssignment>	mDoctorAssignmentList;
	protected		SmartList<DoctorSchedule>	mDoctorScheduleList ;
	
		
	public 	Doctor(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setHospital( null );

		this.changed = true;
	}
	
	public 	Doctor(String name, Hospital hospital)
	{
		setName(name);
		setHospital(hospital);

		this.mDoctorAssignmentList = new SmartList<DoctorAssignment>();
		this.mDoctorScheduleList = new SmartList<DoctorSchedule>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Doctor updateId(String id){
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
	public Doctor updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setHospital(Hospital hospital){
		this.mHospital = hospital;;
	}
	public Hospital getHospital(){
		return this.mHospital;
	}
	public Doctor updateHospital(Hospital hospital){
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
	public Doctor updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<DoctorAssignment> getDoctorAssignmentList(){
		if(this.mDoctorAssignmentList == null){
			this.mDoctorAssignmentList = new SmartList<DoctorAssignment>();
			this.mDoctorAssignmentList.setListInternalName (DOCTOR_ASSIGNMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mDoctorAssignmentList;	
	}
	public  void setDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList){
		for( DoctorAssignment doctorAssignment:doctorAssignmentList){
			doctorAssignment.setDoctor(this);
		}

		this.mDoctorAssignmentList = doctorAssignmentList;
		this.mDoctorAssignmentList.setListInternalName (DOCTOR_ASSIGNMENT_LIST );
		
	}
	
	public  void addDoctorAssignment(DoctorAssignment doctorAssignment){
		doctorAssignment.setDoctor(this);
		getDoctorAssignmentList().add(doctorAssignment);
	}
	public  void addDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList){
		for( DoctorAssignment doctorAssignment:doctorAssignmentList){
			doctorAssignment.setDoctor(this);
		}
		getDoctorAssignmentList().addAll(doctorAssignmentList);
	}
	public  void mergeDoctorAssignmentList(SmartList<DoctorAssignment> doctorAssignmentList){
		if(doctorAssignmentList==null){
			return;
		}
		if(doctorAssignmentList.isEmpty()){
			return;
		}
		addDoctorAssignmentList( doctorAssignmentList );
		
	}
	public  DoctorAssignment removeDoctorAssignment(DoctorAssignment doctorAssignmentIndex){
		
		int index = getDoctorAssignmentList().indexOf(doctorAssignmentIndex);
        if(index < 0){
        	String message = "DoctorAssignment("+doctorAssignmentIndex.getId()+") with version='"+doctorAssignmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        DoctorAssignment doctorAssignment = getDoctorAssignmentList().get(index);        
        // doctorAssignment.clearDoctor(); //disconnect with Doctor
        doctorAssignment.clearFromAll(); //disconnect with Doctor
		
		boolean result = getDoctorAssignmentList().planToRemove(doctorAssignment);
        if(!result){
        	String message = "DoctorAssignment("+doctorAssignmentIndex.getId()+") with version='"+doctorAssignmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return doctorAssignment;
        
	
	}
	//断舍离
	public  void breakWithDoctorAssignment(DoctorAssignment doctorAssignment){
		
		if(doctorAssignment == null){
			return;
		}
		doctorAssignment.setDoctor(null);
		//getDoctorAssignmentList().remove();
	
	}
	
	public  boolean hasDoctorAssignment(DoctorAssignment doctorAssignment){
	
		return getDoctorAssignmentList().contains(doctorAssignment);
  
	}
	
	public void copyDoctorAssignmentFrom(DoctorAssignment doctorAssignment) {

		DoctorAssignment doctorAssignmentInList = findTheDoctorAssignment(doctorAssignment);
		DoctorAssignment newDoctorAssignment = new DoctorAssignment();
		doctorAssignmentInList.copyTo(newDoctorAssignment);
		newDoctorAssignment.setVersion(0);//will trigger copy
		getDoctorAssignmentList().add(newDoctorAssignment);
		addItemToFlexiableObject(COPIED_CHILD, newDoctorAssignment);
	}
	
	public  DoctorAssignment findTheDoctorAssignment(DoctorAssignment doctorAssignment){
		
		int index =  getDoctorAssignmentList().indexOf(doctorAssignment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "DoctorAssignment("+doctorAssignment.getId()+") with version='"+doctorAssignment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getDoctorAssignmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDoctorAssignmentList(){
		getDoctorAssignmentList().clear();
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
			doctorSchedule.setDoctor(this);
		}

		this.mDoctorScheduleList = doctorScheduleList;
		this.mDoctorScheduleList.setListInternalName (DOCTOR_SCHEDULE_LIST );
		
	}
	
	public  void addDoctorSchedule(DoctorSchedule doctorSchedule){
		doctorSchedule.setDoctor(this);
		getDoctorScheduleList().add(doctorSchedule);
	}
	public  void addDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		for( DoctorSchedule doctorSchedule:doctorScheduleList){
			doctorSchedule.setDoctor(this);
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
        // doctorSchedule.clearDoctor(); //disconnect with Doctor
        doctorSchedule.clearFromAll(); //disconnect with Doctor
		
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
		doctorSchedule.setDoctor(null);
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
		collectFromList(this, entityList, getDoctorAssignmentList(), internalType);
		collectFromList(this, entityList, getDoctorScheduleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getDoctorAssignmentList());
		listOfList.add( getDoctorScheduleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, HOSPITAL_PROPERTY, getHospital());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, DOCTOR_ASSIGNMENT_LIST, getDoctorAssignmentList());
		if(!getDoctorAssignmentList().isEmpty()){
			appendKeyValuePair(result, "doctorAssignmentCount", getDoctorAssignmentList().getTotalCount());
			appendKeyValuePair(result, "doctorAssignmentCurrentPageNumber", getDoctorAssignmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DOCTOR_SCHEDULE_LIST, getDoctorScheduleList());
		if(!getDoctorScheduleList().isEmpty()){
			appendKeyValuePair(result, "doctorScheduleCount", getDoctorScheduleList().getTotalCount());
			appendKeyValuePair(result, "doctorScheduleCurrentPageNumber", getDoctorScheduleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Doctor){
		
		
			Doctor dest =(Doctor)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setHospital(getHospital());
			dest.setVersion(getVersion());
			dest.setDoctorAssignmentList(getDoctorAssignmentList());
			dest.setDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Doctor){
		
			
			Doctor dest =(Doctor)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeHospital(getHospital());
			dest.mergeVersion(getVersion());
			dest.mergeDoctorAssignmentList(getDoctorAssignmentList());
			dest.mergeDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Doctor{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getHospital() != null ){
 			stringBuilder.append("\thospital='Hospital("+getHospital().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

