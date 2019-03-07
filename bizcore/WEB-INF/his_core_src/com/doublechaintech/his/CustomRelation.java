
package com.doublechaintech.his;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Doctor"                                , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Profile"                               , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Registration"                          , BaseRelation.TRUST_CHAIN_ALL, "patient");
		//replaceGenericRelation("Registration"                          , BaseRelation.TRUST_CHAIN_ALL, "register");
		//replaceGenericRelation("Registration"                          , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] doctorRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Doctor",doctorRelatedObjectNames);

		//String [] profileRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Profile",profileRelatedObjectNames);

		//String [] registrationRelatedObjectNames = {"patient:Profile","register:Profile","platform:Platform"};
		//replaceRelationIndex("Registration",registrationRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

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













