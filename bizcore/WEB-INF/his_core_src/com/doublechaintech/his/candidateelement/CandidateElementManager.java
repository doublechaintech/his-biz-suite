
package com.doublechaintech.his.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;

public interface CandidateElementManager{

		

	public CandidateElement createCandidateElement(HisUserContext userContext, String name, String type, String image, String containerId) throws Exception;	
	public CandidateElement updateCandidateElement(HisUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(HisUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(HisUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(HisUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;
	
	public CandidateElement transferToAnotherContainer(HisUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(HisUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}











