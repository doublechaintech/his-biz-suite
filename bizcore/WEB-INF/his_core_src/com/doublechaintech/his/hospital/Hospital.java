
package com.doublechaintech.his.hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;

@JsonSerialize(using = HospitalSerializer.class)
public class Hospital extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String TELEPHONE_PROPERTY             = "telephone"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EXPENSE_TYPE_LIST                        = "expenseTypeList"   ;
	public static final String PERIOD_LIST                              = "periodList"        ;
	public static final String EXPENSE_ITEM_LIST                        = "expenseItemList"   ;
	public static final String DOCTOR_LIST                              = "doctorList"        ;
	public static final String DEPARTMENT_LIST                          = "departmentList"    ;
	public static final String DOCTOR_SCHEDULE_LIST                     = "doctorScheduleList";

	public static final String INTERNAL_TYPE="Hospital";
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
	protected		String              	mAddress            ;
	protected		String              	mTelephone          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ExpenseType>	mExpenseTypeList    ;
	protected		SmartList<Period>   	mPeriodList         ;
	protected		SmartList<ExpenseItem>	mExpenseItemList    ;
	protected		SmartList<Doctor>   	mDoctorList         ;
	protected		SmartList<Department>	mDepartmentList     ;
	protected		SmartList<DoctorSchedule>	mDoctorScheduleList ;
	
		
	public 	Hospital(){
		// lazy load for all the properties
	}
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Hospital(String name, String address, String telephone)
	{
		setName(name);
		setAddress(address);
		setTelephone(telephone);

		this.mExpenseTypeList = new SmartList<ExpenseType>();
		this.mPeriodList = new SmartList<Period>();
		this.mExpenseItemList = new SmartList<ExpenseItem>();
		this.mDoctorList = new SmartList<Doctor>();
		this.mDepartmentList = new SmartList<Department>();
		this.mDoctorScheduleList = new SmartList<DoctorSchedule>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(TELEPHONE_PROPERTY.equals(property)){
			changeTelephoneProperty(newValueExpr);
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
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTelephoneProperty(String newValueExpr){
		String oldValue = getTelephone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTelephone(newValue);
		this.onChangeProperty(TELEPHONE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Hospital updateId(String id){
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
	public Hospital updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public Hospital updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}
	
	
	public void setTelephone(String telephone){
		this.mTelephone = trimString(telephone);;
	}
	public String getTelephone(){
		return this.mTelephone;
	}
	public Hospital updateTelephone(String telephone){
		this.mTelephone = trimString(telephone);;
		this.changed = true;
		return this;
	}
	public void mergeTelephone(String telephone){
		if(telephone != null) { setTelephone(telephone);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Hospital updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ExpenseType> getExpenseTypeList(){
		if(this.mExpenseTypeList == null){
			this.mExpenseTypeList = new SmartList<ExpenseType>();
			this.mExpenseTypeList.setListInternalName (EXPENSE_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mExpenseTypeList;	
	}
	public  void setExpenseTypeList(SmartList<ExpenseType> expenseTypeList){
		for( ExpenseType expenseType:expenseTypeList){
			expenseType.setHospital(this);
		}

		this.mExpenseTypeList = expenseTypeList;
		this.mExpenseTypeList.setListInternalName (EXPENSE_TYPE_LIST );
		
	}
	
	public  void addExpenseType(ExpenseType expenseType){
		expenseType.setHospital(this);
		getExpenseTypeList().add(expenseType);
	}
	public  void addExpenseTypeList(SmartList<ExpenseType> expenseTypeList){
		for( ExpenseType expenseType:expenseTypeList){
			expenseType.setHospital(this);
		}
		getExpenseTypeList().addAll(expenseTypeList);
	}
	public  void mergeExpenseTypeList(SmartList<ExpenseType> expenseTypeList){
		if(expenseTypeList==null){
			return;
		}
		if(expenseTypeList.isEmpty()){
			return;
		}
		addExpenseTypeList( expenseTypeList );
		
	}
	public  ExpenseType removeExpenseType(ExpenseType expenseTypeIndex){
		
		int index = getExpenseTypeList().indexOf(expenseTypeIndex);
        if(index < 0){
        	String message = "ExpenseType("+expenseTypeIndex.getId()+") with version='"+expenseTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ExpenseType expenseType = getExpenseTypeList().get(index);        
        // expenseType.clearHospital(); //disconnect with Hospital
        expenseType.clearFromAll(); //disconnect with Hospital
		
		boolean result = getExpenseTypeList().planToRemove(expenseType);
        if(!result){
        	String message = "ExpenseType("+expenseTypeIndex.getId()+") with version='"+expenseTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return expenseType;
        
	
	}
	//断舍离
	public  void breakWithExpenseType(ExpenseType expenseType){
		
		if(expenseType == null){
			return;
		}
		expenseType.setHospital(null);
		//getExpenseTypeList().remove();
	
	}
	
	public  boolean hasExpenseType(ExpenseType expenseType){
	
		return getExpenseTypeList().contains(expenseType);
  
	}
	
	public void copyExpenseTypeFrom(ExpenseType expenseType) {

		ExpenseType expenseTypeInList = findTheExpenseType(expenseType);
		ExpenseType newExpenseType = new ExpenseType();
		expenseTypeInList.copyTo(newExpenseType);
		newExpenseType.setVersion(0);//will trigger copy
		getExpenseTypeList().add(newExpenseType);
		addItemToFlexiableObject(COPIED_CHILD, newExpenseType);
	}
	
	public  ExpenseType findTheExpenseType(ExpenseType expenseType){
		
		int index =  getExpenseTypeList().indexOf(expenseType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ExpenseType("+expenseType.getId()+") with version='"+expenseType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getExpenseTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpExpenseTypeList(){
		getExpenseTypeList().clear();
	}
	
	
	


	public  SmartList<Period> getPeriodList(){
		if(this.mPeriodList == null){
			this.mPeriodList = new SmartList<Period>();
			this.mPeriodList.setListInternalName (PERIOD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPeriodList;	
	}
	public  void setPeriodList(SmartList<Period> periodList){
		for( Period period:periodList){
			period.setHospital(this);
		}

		this.mPeriodList = periodList;
		this.mPeriodList.setListInternalName (PERIOD_LIST );
		
	}
	
	public  void addPeriod(Period period){
		period.setHospital(this);
		getPeriodList().add(period);
	}
	public  void addPeriodList(SmartList<Period> periodList){
		for( Period period:periodList){
			period.setHospital(this);
		}
		getPeriodList().addAll(periodList);
	}
	public  void mergePeriodList(SmartList<Period> periodList){
		if(periodList==null){
			return;
		}
		if(periodList.isEmpty()){
			return;
		}
		addPeriodList( periodList );
		
	}
	public  Period removePeriod(Period periodIndex){
		
		int index = getPeriodList().indexOf(periodIndex);
        if(index < 0){
        	String message = "Period("+periodIndex.getId()+") with version='"+periodIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Period period = getPeriodList().get(index);        
        // period.clearHospital(); //disconnect with Hospital
        period.clearFromAll(); //disconnect with Hospital
		
		boolean result = getPeriodList().planToRemove(period);
        if(!result){
        	String message = "Period("+periodIndex.getId()+") with version='"+periodIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return period;
        
	
	}
	//断舍离
	public  void breakWithPeriod(Period period){
		
		if(period == null){
			return;
		}
		period.setHospital(null);
		//getPeriodList().remove();
	
	}
	
	public  boolean hasPeriod(Period period){
	
		return getPeriodList().contains(period);
  
	}
	
	public void copyPeriodFrom(Period period) {

		Period periodInList = findThePeriod(period);
		Period newPeriod = new Period();
		periodInList.copyTo(newPeriod);
		newPeriod.setVersion(0);//will trigger copy
		getPeriodList().add(newPeriod);
		addItemToFlexiableObject(COPIED_CHILD, newPeriod);
	}
	
	public  Period findThePeriod(Period period){
		
		int index =  getPeriodList().indexOf(period);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Period("+period.getId()+") with version='"+period.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPeriodList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPeriodList(){
		getPeriodList().clear();
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
			expenseItem.setHospital(this);
		}

		this.mExpenseItemList = expenseItemList;
		this.mExpenseItemList.setListInternalName (EXPENSE_ITEM_LIST );
		
	}
	
	public  void addExpenseItem(ExpenseItem expenseItem){
		expenseItem.setHospital(this);
		getExpenseItemList().add(expenseItem);
	}
	public  void addExpenseItemList(SmartList<ExpenseItem> expenseItemList){
		for( ExpenseItem expenseItem:expenseItemList){
			expenseItem.setHospital(this);
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
        // expenseItem.clearHospital(); //disconnect with Hospital
        expenseItem.clearFromAll(); //disconnect with Hospital
		
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
		expenseItem.setHospital(null);
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
			doctor.setHospital(this);
		}

		this.mDoctorList = doctorList;
		this.mDoctorList.setListInternalName (DOCTOR_LIST );
		
	}
	
	public  void addDoctor(Doctor doctor){
		doctor.setHospital(this);
		getDoctorList().add(doctor);
	}
	public  void addDoctorList(SmartList<Doctor> doctorList){
		for( Doctor doctor:doctorList){
			doctor.setHospital(this);
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
        // doctor.clearHospital(); //disconnect with Hospital
        doctor.clearFromAll(); //disconnect with Hospital
		
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
		doctor.setHospital(null);
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
	
	
	


	public  SmartList<Department> getDepartmentList(){
		if(this.mDepartmentList == null){
			this.mDepartmentList = new SmartList<Department>();
			this.mDepartmentList.setListInternalName (DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mDepartmentList;	
	}
	public  void setDepartmentList(SmartList<Department> departmentList){
		for( Department department:departmentList){
			department.setHospital(this);
		}

		this.mDepartmentList = departmentList;
		this.mDepartmentList.setListInternalName (DEPARTMENT_LIST );
		
	}
	
	public  void addDepartment(Department department){
		department.setHospital(this);
		getDepartmentList().add(department);
	}
	public  void addDepartmentList(SmartList<Department> departmentList){
		for( Department department:departmentList){
			department.setHospital(this);
		}
		getDepartmentList().addAll(departmentList);
	}
	public  void mergeDepartmentList(SmartList<Department> departmentList){
		if(departmentList==null){
			return;
		}
		if(departmentList.isEmpty()){
			return;
		}
		addDepartmentList( departmentList );
		
	}
	public  Department removeDepartment(Department departmentIndex){
		
		int index = getDepartmentList().indexOf(departmentIndex);
        if(index < 0){
        	String message = "Department("+departmentIndex.getId()+") with version='"+departmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Department department = getDepartmentList().get(index);        
        // department.clearHospital(); //disconnect with Hospital
        department.clearFromAll(); //disconnect with Hospital
		
		boolean result = getDepartmentList().planToRemove(department);
        if(!result){
        	String message = "Department("+departmentIndex.getId()+") with version='"+departmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return department;
        
	
	}
	//断舍离
	public  void breakWithDepartment(Department department){
		
		if(department == null){
			return;
		}
		department.setHospital(null);
		//getDepartmentList().remove();
	
	}
	
	public  boolean hasDepartment(Department department){
	
		return getDepartmentList().contains(department);
  
	}
	
	public void copyDepartmentFrom(Department department) {

		Department departmentInList = findTheDepartment(department);
		Department newDepartment = new Department();
		departmentInList.copyTo(newDepartment);
		newDepartment.setVersion(0);//will trigger copy
		getDepartmentList().add(newDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newDepartment);
	}
	
	public  Department findTheDepartment(Department department){
		
		int index =  getDepartmentList().indexOf(department);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Department("+department.getId()+") with version='"+department.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDepartmentList(){
		getDepartmentList().clear();
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
			doctorSchedule.setHospital(this);
		}

		this.mDoctorScheduleList = doctorScheduleList;
		this.mDoctorScheduleList.setListInternalName (DOCTOR_SCHEDULE_LIST );
		
	}
	
	public  void addDoctorSchedule(DoctorSchedule doctorSchedule){
		doctorSchedule.setHospital(this);
		getDoctorScheduleList().add(doctorSchedule);
	}
	public  void addDoctorScheduleList(SmartList<DoctorSchedule> doctorScheduleList){
		for( DoctorSchedule doctorSchedule:doctorScheduleList){
			doctorSchedule.setHospital(this);
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
        // doctorSchedule.clearHospital(); //disconnect with Hospital
        doctorSchedule.clearFromAll(); //disconnect with Hospital
		
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
		doctorSchedule.setHospital(null);
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


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getExpenseTypeList(), internalType);
		collectFromList(this, entityList, getPeriodList(), internalType);
		collectFromList(this, entityList, getExpenseItemList(), internalType);
		collectFromList(this, entityList, getDoctorList(), internalType);
		collectFromList(this, entityList, getDepartmentList(), internalType);
		collectFromList(this, entityList, getDoctorScheduleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getExpenseTypeList());
		listOfList.add( getPeriodList());
		listOfList.add( getExpenseItemList());
		listOfList.add( getDoctorList());
		listOfList.add( getDepartmentList());
		listOfList.add( getDoctorScheduleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, TELEPHONE_PROPERTY, getTelephone());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EXPENSE_TYPE_LIST, getExpenseTypeList());
		if(!getExpenseTypeList().isEmpty()){
			appendKeyValuePair(result, "expenseTypeCount", getExpenseTypeList().getTotalCount());
			appendKeyValuePair(result, "expenseTypeCurrentPageNumber", getExpenseTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PERIOD_LIST, getPeriodList());
		if(!getPeriodList().isEmpty()){
			appendKeyValuePair(result, "periodCount", getPeriodList().getTotalCount());
			appendKeyValuePair(result, "periodCurrentPageNumber", getPeriodList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EXPENSE_ITEM_LIST, getExpenseItemList());
		if(!getExpenseItemList().isEmpty()){
			appendKeyValuePair(result, "expenseItemCount", getExpenseItemList().getTotalCount());
			appendKeyValuePair(result, "expenseItemCurrentPageNumber", getExpenseItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DOCTOR_LIST, getDoctorList());
		if(!getDoctorList().isEmpty()){
			appendKeyValuePair(result, "doctorCount", getDoctorList().getTotalCount());
			appendKeyValuePair(result, "doctorCurrentPageNumber", getDoctorList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DEPARTMENT_LIST, getDepartmentList());
		if(!getDepartmentList().isEmpty()){
			appendKeyValuePair(result, "departmentCount", getDepartmentList().getTotalCount());
			appendKeyValuePair(result, "departmentCurrentPageNumber", getDepartmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DOCTOR_SCHEDULE_LIST, getDoctorScheduleList());
		if(!getDoctorScheduleList().isEmpty()){
			appendKeyValuePair(result, "doctorScheduleCount", getDoctorScheduleList().getTotalCount());
			appendKeyValuePair(result, "doctorScheduleCurrentPageNumber", getDoctorScheduleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Hospital){
		
		
			Hospital dest =(Hospital)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAddress(getAddress());
			dest.setTelephone(getTelephone());
			dest.setVersion(getVersion());
			dest.setExpenseTypeList(getExpenseTypeList());
			dest.setPeriodList(getPeriodList());
			dest.setExpenseItemList(getExpenseItemList());
			dest.setDoctorList(getDoctorList());
			dest.setDepartmentList(getDepartmentList());
			dest.setDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Hospital){
		
			
			Hospital dest =(Hospital)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAddress(getAddress());
			dest.mergeTelephone(getTelephone());
			dest.mergeVersion(getVersion());
			dest.mergeExpenseTypeList(getExpenseTypeList());
			dest.mergePeriodList(getPeriodList());
			dest.mergeExpenseItemList(getExpenseItemList());
			dest.mergeDoctorList(getDoctorList());
			dest.mergeDepartmentList(getDepartmentList());
			dest.mergeDoctorScheduleList(getDoctorScheduleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Hospital){
		
			
			Hospital dest =(Hospital)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAddress(getAddress());
			dest.mergeTelephone(getTelephone());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Hospital{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\ttelephone='"+getTelephone()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

