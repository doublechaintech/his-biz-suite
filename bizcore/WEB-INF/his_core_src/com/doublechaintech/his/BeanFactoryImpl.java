
package com.doublechaintech.his;
import java.util.Map;

import com.doublechaintech.his.hospital.Hospital;
import com.doublechaintech.his.expensetype.ExpenseType;
import com.doublechaintech.his.period.Period;
import com.doublechaintech.his.expenseitem.ExpenseItem;
import com.doublechaintech.his.doctor.Doctor;
import com.doublechaintech.his.department.Department;
import com.doublechaintech.his.doctorassignment.DoctorAssignment;
import com.doublechaintech.his.doctorschedule.DoctorSchedule;
import com.doublechaintech.his.mobileapp.MobileApp;
import com.doublechaintech.his.page.Page;
import com.doublechaintech.his.pagetype.PageType;
import com.doublechaintech.his.slide.Slide;
import com.doublechaintech.his.uiaction.UiAction;
import com.doublechaintech.his.section.Section;
import com.doublechaintech.his.userdomain.UserDomain;
import com.doublechaintech.his.userwhitelist.UserWhiteList;
import com.doublechaintech.his.secuser.SecUser;
import com.doublechaintech.his.userapp.UserApp;
import com.doublechaintech.his.quicklink.QuickLink;
import com.doublechaintech.his.listaccess.ListAccess;
import com.doublechaintech.his.objectaccess.ObjectAccess;
import com.doublechaintech.his.loginhistory.LoginHistory;
import com.doublechaintech.his.genericform.GenericForm;
import com.doublechaintech.his.formmessage.FormMessage;
import com.doublechaintech.his.formfieldmessage.FormFieldMessage;
import com.doublechaintech.his.formfield.FormField;
import com.doublechaintech.his.formaction.FormAction;
import com.doublechaintech.his.candidatecontainer.CandidateContainer;
import com.doublechaintech.his.candidateelement.CandidateElement;
import com.doublechaintech.his.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.his.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.his.treenode.TreeNode;

public class BeanFactoryImpl{


	public Hospital createHospital(Map<String,Object> options){
		return new Hospital();
	}


	public ExpenseType createExpenseType(Map<String,Object> options){
		return new ExpenseType();
	}


	public Period createPeriod(Map<String,Object> options){
		return new Period();
	}


	public ExpenseItem createExpenseItem(Map<String,Object> options){
		return new ExpenseItem();
	}


	public Doctor createDoctor(Map<String,Object> options){
		return new Doctor();
	}


	public Department createDepartment(Map<String,Object> options){
		return new Department();
	}


	public DoctorAssignment createDoctorAssignment(Map<String,Object> options){
		return new DoctorAssignment();
	}


	public DoctorSchedule createDoctorSchedule(Map<String,Object> options){
		return new DoctorSchedule();
	}


	public MobileApp createMobileApp(Map<String,Object> options){
		return new MobileApp();
	}


	public Page createPage(Map<String,Object> options){
		return new Page();
	}


	public PageType createPageType(Map<String,Object> options){
		return new PageType();
	}


	public Slide createSlide(Map<String,Object> options){
		return new Slide();
	}


	public UiAction createUiAction(Map<String,Object> options){
		return new UiAction();
	}


	public Section createSection(Map<String,Object> options){
		return new Section();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}


	public WechatWorkappIdentify createWechatWorkappIdentify(Map<String,Object> options){
		return new WechatWorkappIdentify();
	}


	public WechatMiniappIdentify createWechatMiniappIdentify(Map<String,Object> options){
		return new WechatMiniappIdentify();
	}


	public TreeNode createTreeNode(Map<String,Object> options){
		return new TreeNode();
	}





}

















