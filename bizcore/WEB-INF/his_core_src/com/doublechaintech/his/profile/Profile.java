
package com.doublechaintech.his.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.his.platform.Platform;
import com.doublechaintech.his.registration.Registration;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String GENDER_PROPERTY                = "gender"            ;
	public static final String AGE_PROPERTY                   = "age"               ;
	public static final String IDENTIFICATION_NUMBER_PROPERTY = "identificationNumber";
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String REGISTRATION_LIST_AS_PATIENT             = "registrationListAsPatient";
	public static final String REGISTRATION_LIST_AS_REGISTER            = "registrationListAsRegister";

	public static final String INTERNAL_TYPE="Profile";
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
	protected		String              	mGender             ;
	protected		int                 	mAge                ;
	protected		String              	mIdentificationNumber;
	protected		String              	mMobile             ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Registration>	mRegistrationListAsPatient;
	protected		SmartList<Registration>	mRegistrationListAsRegister;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, String gender, int age, String identificationNumber, String mobile, Platform platform)
	{
		setName(name);
		setGender(gender);
		setAge(age);
		setIdentificationNumber(identificationNumber);
		setMobile(mobile);
		setPlatform(platform);

		this.mRegistrationListAsPatient = new SmartList<Registration>();
		this.mRegistrationListAsRegister = new SmartList<Registration>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(GENDER_PROPERTY.equals(property)){
			changeGenderProperty(newValueExpr);
		}
		if(AGE_PROPERTY.equals(property)){
			changeAgeProperty(newValueExpr);
		}
		if(IDENTIFICATION_NUMBER_PROPERTY.equals(property)){
			changeIdentificationNumberProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
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
			
			
			
	protected void changeGenderProperty(String newValueExpr){
		String oldValue = getGender();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateGender(newValue);
		this.onChangeProperty(GENDER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAgeProperty(String newValueExpr){
		int oldValue = getAge();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAge(newValue);
		this.onChangeProperty(AGE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeIdentificationNumberProperty(String newValueExpr){
		String oldValue = getIdentificationNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIdentificationNumber(newValue);
		this.onChangeProperty(IDENTIFICATION_NUMBER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeMobileProperty(String newValueExpr){
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobile(newValue);
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Profile updateId(String id){
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
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setGender(String gender){
		this.mGender = trimString(gender);;
	}
	public String getGender(){
		return this.mGender;
	}
	public Profile updateGender(String gender){
		this.mGender = trimString(gender);;
		this.changed = true;
		return this;
	}
	public void mergeGender(String gender){
		if(gender != null) { setGender(gender);}
	}
	
	
	public void setAge(int age){
		this.mAge = age;;
	}
	public int getAge(){
		return this.mAge;
	}
	public Profile updateAge(int age){
		this.mAge = age;;
		this.changed = true;
		return this;
	}
	public void mergeAge(int age){
		setAge(age);
	}
	
	
	public void setIdentificationNumber(String identificationNumber){
		this.mIdentificationNumber = trimString(identificationNumber);;
	}
	public String getIdentificationNumber(){
		return this.mIdentificationNumber;
	}
	public Profile updateIdentificationNumber(String identificationNumber){
		this.mIdentificationNumber = trimString(identificationNumber);;
		this.changed = true;
		return this;
	}
	public void mergeIdentificationNumber(String identificationNumber){
		if(identificationNumber != null) { setIdentificationNumber(identificationNumber);}
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	public Profile updateMobile(String mobile){
		this.mMobile = trimString(mobile);;
		this.changed = true;
		return this;
	}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Registration> getRegistrationListAsPatient(){
		if(this.mRegistrationListAsPatient == null){
			this.mRegistrationListAsPatient = new SmartList<Registration>();
			this.mRegistrationListAsPatient.setListInternalName (REGISTRATION_LIST_AS_PATIENT );
			//有名字，便于做权限控制
		}
		
		return this.mRegistrationListAsPatient;	
	}
	public  void setRegistrationListAsPatient(SmartList<Registration> registrationListAsPatient){
		for( Registration registration:registrationListAsPatient){
			registration.setPatient(this);
		}

		this.mRegistrationListAsPatient = registrationListAsPatient;
		this.mRegistrationListAsPatient.setListInternalName (REGISTRATION_LIST_AS_PATIENT );
		
	}
	
	public  void addRegistrationAsPatient(Registration registration){
		registration.setPatient(this);
		getRegistrationListAsPatient().add(registration);
	}
	public  void addRegistrationListAsPatient(SmartList<Registration> registrationListAsPatient){
		for( Registration registration:registrationListAsPatient){
			registration.setPatient(this);
		}
		getRegistrationListAsPatient().addAll(registrationListAsPatient);
	}
	public  void mergeRegistrationListAsPatient(SmartList<Registration> registrationListAsPatient){
		if(registrationListAsPatient==null){
			return;
		}
		if(registrationListAsPatient.isEmpty()){
			return;
		}
		addRegistrationListAsPatient( registrationListAsPatient );
		
	}
	public  Registration removeRegistrationAsPatient(Registration registrationIndex){
		
		int index = getRegistrationListAsPatient().indexOf(registrationIndex);
        if(index < 0){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Registration registration = getRegistrationListAsPatient().get(index);        
        // registration.clearPatient(); //disconnect with Patient
        registration.clearFromAll(); //disconnect with Patient
		
		boolean result = getRegistrationListAsPatient().planToRemove(registration);
        if(!result){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return registration;
        
	
	}
	//断舍离
	public  void breakWithRegistrationAsPatient(Registration registration){
		
		if(registration == null){
			return;
		}
		registration.setPatient(null);
		//getRegistrationListAsPatient().remove();
	
	}
	
	public  boolean hasRegistrationAsPatient(Registration registration){
	
		return getRegistrationListAsPatient().contains(registration);
  
	}
	
	public void copyRegistrationAsPatientFrom(Registration registration) {

		Registration registrationInList = findTheRegistrationAsPatient(registration);
		Registration newRegistration = new Registration();
		registrationInList.copyTo(newRegistration);
		newRegistration.setVersion(0);//will trigger copy
		getRegistrationListAsPatient().add(newRegistration);
		addItemToFlexiableObject(COPIED_CHILD, newRegistration);
	}
	
	public  Registration findTheRegistrationAsPatient(Registration registration){
		
		int index =  getRegistrationListAsPatient().indexOf(registration);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Registration("+registration.getId()+") with version='"+registration.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRegistrationListAsPatient().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRegistrationListAsPatient(){
		getRegistrationListAsPatient().clear();
	}
	
	
	


	public  SmartList<Registration> getRegistrationListAsRegister(){
		if(this.mRegistrationListAsRegister == null){
			this.mRegistrationListAsRegister = new SmartList<Registration>();
			this.mRegistrationListAsRegister.setListInternalName (REGISTRATION_LIST_AS_REGISTER );
			//有名字，便于做权限控制
		}
		
		return this.mRegistrationListAsRegister;	
	}
	public  void setRegistrationListAsRegister(SmartList<Registration> registrationListAsRegister){
		for( Registration registration:registrationListAsRegister){
			registration.setRegister(this);
		}

		this.mRegistrationListAsRegister = registrationListAsRegister;
		this.mRegistrationListAsRegister.setListInternalName (REGISTRATION_LIST_AS_REGISTER );
		
	}
	
	public  void addRegistrationAsRegister(Registration registration){
		registration.setRegister(this);
		getRegistrationListAsRegister().add(registration);
	}
	public  void addRegistrationListAsRegister(SmartList<Registration> registrationListAsRegister){
		for( Registration registration:registrationListAsRegister){
			registration.setRegister(this);
		}
		getRegistrationListAsRegister().addAll(registrationListAsRegister);
	}
	public  void mergeRegistrationListAsRegister(SmartList<Registration> registrationListAsRegister){
		if(registrationListAsRegister==null){
			return;
		}
		if(registrationListAsRegister.isEmpty()){
			return;
		}
		addRegistrationListAsRegister( registrationListAsRegister );
		
	}
	public  Registration removeRegistrationAsRegister(Registration registrationIndex){
		
		int index = getRegistrationListAsRegister().indexOf(registrationIndex);
        if(index < 0){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Registration registration = getRegistrationListAsRegister().get(index);        
        // registration.clearRegister(); //disconnect with Register
        registration.clearFromAll(); //disconnect with Register
		
		boolean result = getRegistrationListAsRegister().planToRemove(registration);
        if(!result){
        	String message = "Registration("+registrationIndex.getId()+") with version='"+registrationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return registration;
        
	
	}
	//断舍离
	public  void breakWithRegistrationAsRegister(Registration registration){
		
		if(registration == null){
			return;
		}
		registration.setPatient(null);
		//getRegistrationListAsRegister().remove();
	
	}
	
	public  boolean hasRegistrationAsRegister(Registration registration){
	
		return getRegistrationListAsRegister().contains(registration);
  
	}
	
	public void copyRegistrationAsRegisterFrom(Registration registration) {

		Registration registrationInList = findTheRegistrationAsRegister(registration);
		Registration newRegistration = new Registration();
		registrationInList.copyTo(newRegistration);
		newRegistration.setVersion(0);//will trigger copy
		getRegistrationListAsRegister().add(newRegistration);
		addItemToFlexiableObject(COPIED_CHILD, newRegistration);
	}
	
	public  Registration findTheRegistrationAsRegister(Registration registration){
		
		int index =  getRegistrationListAsRegister().indexOf(registration);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Registration("+registration.getId()+") with version='"+registration.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRegistrationListAsRegister().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRegistrationListAsRegister(){
		getRegistrationListAsRegister().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRegistrationListAsPatient(), internalType);
		collectFromList(this, entityList, getRegistrationListAsRegister(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRegistrationListAsPatient());
		listOfList.add( getRegistrationListAsRegister());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, GENDER_PROPERTY, getGender());
		appendKeyValuePair(result, AGE_PROPERTY, getAge());
		appendKeyValuePair(result, IDENTIFICATION_NUMBER_PROPERTY, getIdentificationNumber());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, REGISTRATION_LIST_AS_PATIENT, getRegistrationListAsPatient());
		if(!getRegistrationListAsPatient().isEmpty()){
			appendKeyValuePair(result, "registrationAsPatientCount", getRegistrationListAsPatient().getTotalCount());
			appendKeyValuePair(result, "registrationAsPatientCurrentPageNumber", getRegistrationListAsPatient().getCurrentPageNumber());
		}
		appendKeyValuePair(result, REGISTRATION_LIST_AS_REGISTER, getRegistrationListAsRegister());
		if(!getRegistrationListAsRegister().isEmpty()){
			appendKeyValuePair(result, "registrationAsRegisterCount", getRegistrationListAsRegister().getTotalCount());
			appendKeyValuePair(result, "registrationAsRegisterCurrentPageNumber", getRegistrationListAsRegister().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setGender(getGender());
			dest.setAge(getAge());
			dest.setIdentificationNumber(getIdentificationNumber());
			dest.setMobile(getMobile());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setRegistrationListAsPatient(getRegistrationListAsPatient());
			dest.setRegistrationListAsRegister(getRegistrationListAsRegister());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
			
			Profile dest =(Profile)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeGender(getGender());
			dest.mergeAge(getAge());
			dest.mergeIdentificationNumber(getIdentificationNumber());
			dest.mergeMobile(getMobile());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeRegistrationListAsPatient(getRegistrationListAsPatient());
			dest.mergeRegistrationListAsRegister(getRegistrationListAsRegister());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tgender='"+getGender()+"';");
		stringBuilder.append("\tage='"+getAge()+"';");
		stringBuilder.append("\tidentificationNumber='"+getIdentificationNumber()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAge(int incAge){
		updateAge(this.mAge +  incAge);
	}
	public void decreaseAge(int decAge){
		updateAge(this.mAge - decAge);
	}
	

}

