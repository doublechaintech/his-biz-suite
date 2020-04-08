
package com.doublechaintech.his;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("ExpenseType"                           , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("Period"                                , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("ExpenseItem"                           , BaseRelation.TRUST_CHAIN_ALL, "expenseType");
		//replaceGenericRelation("ExpenseItem"                           , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("Doctor"                                , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("Department"                            , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("DoctorAssignment"                      , BaseRelation.TRUST_CHAIN_ALL, "doctor");
		//replaceGenericRelation("DoctorAssignment"                      , BaseRelation.TRUST_CHAIN_ALL, "department");
		//replaceGenericRelation("DoctorSchedule"                        , BaseRelation.TRUST_CHAIN_ALL, "doctor");
		//replaceGenericRelation("DoctorSchedule"                        , BaseRelation.TRUST_CHAIN_ALL, "period");
		//replaceGenericRelation("DoctorSchedule"                        , BaseRelation.TRUST_CHAIN_ALL, "department");
		//replaceGenericRelation("DoctorSchedule"                        , BaseRelation.TRUST_CHAIN_ALL, "expenseType");
		//replaceGenericRelation("DoctorSchedule"                        , BaseRelation.TRUST_CHAIN_ALL, "hospital");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "pageType");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("PageType"                              , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("Slide"                                 , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UiAction"                              , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");
		//replaceGenericRelation("WechatWorkappIdentify"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("WechatMiniappIdentify"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] expenseTypeRelatedObjectNames = {"hospital:Hospital"};
		//replaceRelationIndex("ExpenseType",expenseTypeRelatedObjectNames);

		//String [] periodRelatedObjectNames = {"hospital:Hospital"};
		//replaceRelationIndex("Period",periodRelatedObjectNames);

		//String [] expenseItemRelatedObjectNames = {"expense_type:ExpenseType","hospital:Hospital"};
		//replaceRelationIndex("ExpenseItem",expenseItemRelatedObjectNames);

		//String [] doctorRelatedObjectNames = {"hospital:Hospital"};
		//replaceRelationIndex("Doctor",doctorRelatedObjectNames);

		//String [] departmentRelatedObjectNames = {"hospital:Hospital"};
		//replaceRelationIndex("Department",departmentRelatedObjectNames);

		//String [] doctorAssignmentRelatedObjectNames = {"doctor:Doctor","department:Department"};
		//replaceRelationIndex("DoctorAssignment",doctorAssignmentRelatedObjectNames);

		//String [] doctorScheduleRelatedObjectNames = {"doctor:Doctor","period:Period","department:Department","expense_type:ExpenseType","hospital:Hospital"};
		//replaceRelationIndex("DoctorSchedule",doctorScheduleRelatedObjectNames);

		//String [] pageRelatedObjectNames = {"page_type:PageType","mobile_app:MobileApp"};
		//replaceRelationIndex("Page",pageRelatedObjectNames);

		//String [] pageTypeRelatedObjectNames = {"mobile_app:MobileApp"};
		//replaceRelationIndex("PageType",pageTypeRelatedObjectNames);

		//String [] slideRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Slide",slideRelatedObjectNames);

		//String [] uiActionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("UiAction",uiActionRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		//String [] wechatWorkappIdentifyRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatWorkappIdentify",wechatWorkappIdentifyRelatedObjectNames);

		//String [] wechatMiniappIdentifyRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatMiniappIdentify",wechatMiniappIdentifyRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}




















