
package com.doublechaintech.his.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.his.profile.Profile;
import com.doublechaintech.his.registration.Registration;
import com.doublechaintech.his.doctor.Doctor;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String CURRENT_VERSION_PROPERTY       = "currentVersion"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String DOCTOR_LIST                              = "doctorList"        ;
	public static final String PROFILE_LIST                             = "profileList"       ;
	public static final String REGISTRATION_LIST                        = "registrationList"  ;

	public static final String INTERNAL_TYPE="Platform";
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
	protected		String              	mIntroduction       ;
	protected		String              	mCurrentVersion     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Doctor>   	mDoctorList         ;
	protected		SmartList<Profile>  	mProfileList        ;
	protected		SmartList<Registration>	mRegistrationList   ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String introduction, String currentVersion)
	{
		setName(name);
		setIntroduction(introduction);
		setCurrentVersion(currentVersion);

		this.mDoctorList = new SmartList<Doctor>();
		this.mProfileList = new SmartList<Profile>();
		this.mRegistrationList = new SmartList<Registration>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(CURRENT_VERSION_PROPERTY.equals(property)){
			changeCurrentVersionProperty(newValueExpr);
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
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCurrentVersionProperty(String newValueExpr){
		String oldValue = getCurrentVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCurrentVersion(newValue);
		this.onChangeProperty(CURRENT_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
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
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Platform updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	public void mergeIntroduction(String introduction){
		if(introduction != null) { setIntroduction(introduction);}
	}
	
	
	public void setCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
	}
	public String getCurrentVersion(){
		return this.mCurrentVersion;
	}
	public Platform updateCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
		this.changed = true;
		return this;
	}
	public void mergeCurrentVersion(String currentVersion){
		if(currentVersion != null) { setCurrentVersion(currentVersion);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Doctor> getDoctorList(){
		if(this.mDoctorList == null){
			this.mDoctorList = new SmartList<Doctor>();
			this.mDoctorList.setListInternalName (DOCTOR_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mDoctorList;	
	}
	public  void setDoctorList(SmartList<Doctor> doctorList){
		for( Doctor doctor:doctorList){
			doctor.setPlatform(this);
		}

		this.mDoctorList = doctorList;
		this.mDoctorList.setListInternalName (DOCTOR_LIST );
		
	}
	
	public  void addDoctor(Doctor doctor){
		doctor.setPlatform(this);
		getDoctorList().add(doctor);
	}
	public  void addDoctorList(SmartList<Doctor> doctorList){
		for( Doctor doctor:doctorList){
			doctor.setPlatform(this);
		}
		getDoctorList().addAll(doctorList);
	}
	public  void mergeDoctorList(SmartList<Doctor> doctorList){
		if(doctorList==null){
			return;
		}
		if(doctorList.isEmpty()){
			return;
		}
		addDoctorList( doctorList );
		
	}
	public  Doctor removeDoctor(Doctor doctorIndex){
		
		int index = getDoctorList().indexOf(doctorIndex);
        if(index < 0){
        	String message = "Doctor("+doctorIndex.getId()+") with version='"+doctorIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Doctor doctor = getDoctorList().get(index);        
        // doctor.clearPlatform(); //disconnect with Platform
        doctor.clearFromAll(); //disconnect with Platform
		
		boolean result = getDoctorList().planToRemove(doctor);
        if(!result){
        	String message = "Doctor("+doctorIndex.getId()+") with version='"+doctorIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return doctor;
        
	
	}
	//断舍离
	public  void breakWithDoctor(Doctor doctor){
		
		if(doctor == null){
			return;
		}
		doctor.setPlatform(null);
		//getDoctorList().remove();
	
	}
	
	public  boolean hasDoctor(Doctor doctor){
	
		return getDoctorList().contains(doctor);
  
	}
	
	public void copyDoctorFrom(Doctor doctor) {

		Doctor doctorInList = findTheDoctor(doctor);
		Doctor newDoctor = new Doctor();
		doctorInList.copyTo(newDoctor);
		newDoctor.setVersion(0);//will trigger copy
		getDoctorList().add(newDoctor);
		addItemToFlexiableObject(COPIED_CHILD, newDoctor);
	}
	
	public  Doctor findTheDoctor(Doctor doctor){
		
		int index =  getDoctorList().indexOf(doctor);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Doctor("+doctor.getId()+") with version='"+doctor.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getDoctorList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDoctorList(){
		getDoctorList().clear();
	}
	
	
	


	public  SmartList<Profile> getProfileList(){
		if(this.mProfileList == null){
			this.mProfileList = new SmartList<Profile>();
			this.mProfileList.setListInternalName (PROFILE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProfileList;	
	}
	public  void setProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}

		this.mProfileList = profileList;
		this.mProfileList.setListInternalName (PROFILE_LIST );
		
	}
	
	public  void addProfile(Profile profile){
		profile.setPlatform(this);
		getProfileList().add(profile);
	}
	public  void addProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}
		getProfileList().addAll(profileList);
	}
	public  void mergeProfileList(SmartList<Profile> profileList){
		if(profileList==null){
			return;
		}
		if(profileList.isEmpty()){
			return;
		}
		addProfileList( profileList );
		
	}
	public  Profile removeProfile(Profile profileIndex){
		
		int index = getProfileList().indexOf(profileIndex);
        if(index < 0){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Profile profile = getProfileList().get(index);        
        // profile.clearPlatform(); //disconnect with Platform
        profile.clearFromAll(); //disconnect with Platform
		
		boolean result = getProfileList().planToRemove(profile);
        if(!result){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return profile;
        
	
	}
	//断舍离
	public  void breakWithProfile(Profile profile){
		
		if(profile == null){
			return;
		}
		profile.setPlatform(null);
		//getProfileList().remove();
	
	}
	
	public  boolean hasProfile(Profile profile){
	
		return getProfileList().contains(profile);
  
	}
	
	public void copyProfileFrom(Profile profile) {

		Profile profileInList = findTheProfile(profile);
		Profile newProfile = new Profile();
		profileInList.copyTo(newProfile);
		newProfile.setVersion(0);//will trigger copy
		getProfileList().add(newProfile);
		addItemToFlexiableObject(COPIED_CHILD, newProfile);
	}
	
	public  Profile findTheProfile(Profile profile){
		
		int index =  getProfileList().indexOf(profile);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Profile("+profile.getId()+") with version='"+profile.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProfileList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProfileList(){
		getProfileList().clear();
	}
	
	
	


	public  SmartList<Registration> getRegistrationList(){
		if(this.mRegistrationList == null){
			this.mRegistrationList = new SmartList<Registration>();
			this.mRegistrationList.setListInternalName (REGISTRATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRegistrationList;	
	}
	public  void setRegistrationList(SmartList<Registration> registrationList){
		for( Registration registration:registrationList){
			registration.setPlatform(this);
		}

		this.mRegistrationList = registrationList;
		this.mRegistrationList.setListInternalName (REGISTRATION_LIST );
		
	}
	
	public  void addRegistration(Registration registration){
		registration.setPlatform(this);
		getRegistrationList().add(registration);
	}
	public  void addRegistrationList(SmartList<Registration> registrationList){
		for( Registration registration:registrationList){
			registration.setPlatform(this);
		}
		getRegistrationList().addAll(registrationList);
	}
	public  void mergeRegistrationList(SmartList<Registration> registrationList){
		if(registrationList==null){
			return;
		}
		if(registrationList.isEmpty()){
			return;
		}
		addRegistrationList( registrationList );
		
	}
	public  Registration removeRegistration(Registration registrationIndex){
		
		int index = getRegistrationList().indexOf(registrationIndex);
        if(index < 0){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Registration registration = getRegistrationList().get(index);        
        // registration.clearPlatform(); //disconnect with Platform
        registration.clearFromAll(); //disconnect with Platform
		
		boolean result = getRegistrationList().planToRemove(registration);
        if(!result){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return registration;
        
	
	}
	//断舍离
	public  void breakWithRegistration(Registration registration){
		
		if(registration == null){
			return;
		}
		registration.setPlatform(null);
		//getRegistrationList().remove();
	
	}
	
	public  boolean hasRegistration(Registration registration){
	
		return getRegistrationList().contains(registration);
  
	}
	
	public void copyRegistrationFrom(Registration registration) {

		Registration registrationInList = findTheRegistration(registration);
		Registration newRegistration = new Registration();
		registrationInList.copyTo(newRegistration);
		newRegistration.setVersion(0);//will trigger copy
		getRegistrationList().add(newRegistration);
		addItemToFlexiableObject(COPIED_CHILD, newRegistration);
	}
	
	public  Registration findTheRegistration(Registration registration){
		
		int index =  getRegistrationList().indexOf(registration);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Registration("+registration.getId()+") with version='"+registration.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRegistrationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRegistrationList(){
		getRegistrationList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getDoctorList(), internalType);
		collectFromList(this, entityList, getProfileList(), internalType);
		collectFromList(this, entityList, getRegistrationList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getDoctorList());
		listOfList.add( getProfileList());
		listOfList.add( getRegistrationList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, CURRENT_VERSION_PROPERTY, getCurrentVersion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, DOCTOR_LIST, getDoctorList());
		if(!getDoctorList().isEmpty()){
			appendKeyValuePair(result, "doctorCount", getDoctorList().getTotalCount());
			appendKeyValuePair(result, "doctorCurrentPageNumber", getDoctorList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROFILE_LIST, getProfileList());
		if(!getProfileList().isEmpty()){
			appendKeyValuePair(result, "profileCount", getProfileList().getTotalCount());
			appendKeyValuePair(result, "profileCurrentPageNumber", getProfileList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, REGISTRATION_LIST, getRegistrationList());
		if(!getRegistrationList().isEmpty()){
			appendKeyValuePair(result, "registrationCount", getRegistrationList().getTotalCount());
			appendKeyValuePair(result, "registrationCurrentPageNumber", getRegistrationList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIntroduction(getIntroduction());
			dest.setCurrentVersion(getCurrentVersion());
			dest.setVersion(getVersion());
			dest.setDoctorList(getDoctorList());
			dest.setProfileList(getProfileList());
			dest.setRegistrationList(getRegistrationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeIntroduction(getIntroduction());
			dest.mergeCurrentVersion(getCurrentVersion());
			dest.mergeVersion(getVersion());
			dest.mergeDoctorList(getDoctorList());
			dest.mergeProfileList(getProfileList());
			dest.mergeRegistrationList(getRegistrationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tcurrentVersion='"+getCurrentVersion()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

