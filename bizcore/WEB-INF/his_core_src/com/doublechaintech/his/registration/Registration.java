
package com.doublechaintech.his.registration;

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
import com.doublechaintech.his.platform.Platform;

@JsonSerialize(using = RegistrationSerializer.class)
public class Registration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String PATIENT_PROPERTY               = "patient"           ;
	public static final String REGISTER_PROPERTY              = "register"          ;
	public static final String CONTENT_PROPERTY               = "content"           ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Registration";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		Profile             	mPatient            ;
	protected		Profile             	mRegister           ;
	protected		String              	mContent            ;
	protected		DateTime            	mUpdateTime         ;
	protected		String              	mStatus             ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Registration(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPatient( null );
		setRegister( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Registration(String title, Profile patient, Profile register, String content, DateTime updateTime, String status, Platform platform)
	{
		setTitle(title);
		setPatient(patient);
		setRegister(register);
		setContent(content);
		setUpdateTime(updateTime);
		setStatus(status);
		setPlatform(platform);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(CONTENT_PROPERTY.equals(property)){
			changeContentProperty(newValueExpr);
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			changeUpdateTimeProperty(newValueExpr);
		}
		if(STATUS_PROPERTY.equals(property)){
			changeStatusProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeContentProperty(String newValueExpr){
		String oldValue = getContent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContent(newValue);
		this.onChangeProperty(CONTENT_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Registration updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Registration updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setPatient(Profile patient){
		this.mPatient = patient;;
	}
	public Profile getPatient(){
		return this.mPatient;
	}
	public Registration updatePatient(Profile patient){
		this.mPatient = patient;;
		this.changed = true;
		return this;
	}
	public void mergePatient(Profile patient){
		if(patient != null) { setPatient(patient);}
	}
	
	
	public void clearPatient(){
		setPatient ( null );
		this.changed = true;
	}
	
	public void setRegister(Profile register){
		this.mRegister = register;;
	}
	public Profile getRegister(){
		return this.mRegister;
	}
	public Registration updateRegister(Profile register){
		this.mRegister = register;;
		this.changed = true;
		return this;
	}
	public void mergeRegister(Profile register){
		if(register != null) { setRegister(register);}
	}
	
	
	public void clearRegister(){
		setRegister ( null );
		this.changed = true;
	}
	
	public void setContent(String content){
		this.mContent = content;;
	}
	public String getContent(){
		return this.mContent;
	}
	public Registration updateContent(String content){
		this.mContent = content;;
		this.changed = true;
		return this;
	}
	public void mergeContent(String content){
		if(content != null) { setContent(content);}
	}
	
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public Registration updateUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
		this.changed = true;
		return this;
	}
	public void mergeUpdateTime(DateTime updateTime){
		setUpdateTime(updateTime);
	}
	
	
	public void setStatus(String status){
		this.mStatus = trimString(status);;
	}
	public String getStatus(){
		return this.mStatus;
	}
	public Registration updateStatus(String status){
		this.mStatus = trimString(status);;
		this.changed = true;
		return this;
	}
	public void mergeStatus(String status){
		if(status != null) { setStatus(status);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Registration updatePlatform(Platform platform){
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
	public Registration updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPatient(), internalType);
		addToEntityList(this, entityList, getRegister(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
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
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, PATIENT_PROPERTY, getPatient());
		appendKeyValuePair(result, REGISTER_PROPERTY, getRegister());
		appendKeyValuePair(result, CONTENT_PROPERTY, getContent());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registration){
		
		
			Registration dest =(Registration)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setPatient(getPatient());
			dest.setRegister(getRegister());
			dest.setContent(getContent());
			dest.setUpdateTime(getUpdateTime());
			dest.setStatus(getStatus());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registration){
		
			
			Registration dest =(Registration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergePatient(getPatient());
			dest.mergeRegister(getRegister());
			dest.mergeContent(getContent());
			dest.mergeUpdateTime(getUpdateTime());
			dest.mergeStatus(getStatus());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Registration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getPatient() != null ){
 			stringBuilder.append("\tpatient='Profile("+getPatient().getId()+")';");
 		}
		if(getRegister() != null ){
 			stringBuilder.append("\tregister='Profile("+getRegister().getId()+")';");
 		}
		stringBuilder.append("\tcontent='"+getContent()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tstatus='"+getStatus()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

