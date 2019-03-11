
package com.panfeng.his.doctorassignment;

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

@JsonSerialize(using = DoctorAssignmentSerializer.class)
public class DoctorAssignment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DOCTOR_PROPERTY                = "doctor"            ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="DoctorAssignment";
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
	protected		Doctor              	mDoctor             ;
	protected		Department          	mDepartment         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	DoctorAssignment(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDoctor( null );
		setDepartment( null );

		this.changed = true;
	}
	
	public 	DoctorAssignment(String name, Doctor doctor, Department department)
	{
		setName(name);
		setDoctor(doctor);
		setDepartment(department);
	
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
	public DoctorAssignment updateId(String id){
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
	public DoctorAssignment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDoctor(Doctor doctor){
		this.mDoctor = doctor;;
	}
	public Doctor getDoctor(){
		return this.mDoctor;
	}
	public DoctorAssignment updateDoctor(Doctor doctor){
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
	
	public void setDepartment(Department department){
		this.mDepartment = department;;
	}
	public Department getDepartment(){
		return this.mDepartment;
	}
	public DoctorAssignment updateDepartment(Department department){
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
	public DoctorAssignment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDoctor(), internalType);
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
		appendKeyValuePair(result, DOCTOR_PROPERTY, getDoctor());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof DoctorAssignment){
		
		
			DoctorAssignment dest =(DoctorAssignment)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDoctor(getDoctor());
			dest.setDepartment(getDepartment());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof DoctorAssignment){
		
			
			DoctorAssignment dest =(DoctorAssignment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDoctor(getDoctor());
			dest.mergeDepartment(getDepartment());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("DoctorAssignment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getDoctor() != null ){
 			stringBuilder.append("\tdoctor='Doctor("+getDoctor().getId()+")';");
 		}
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='Department("+getDepartment().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

