
package com.doublechaintech.his.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface CandidateContainerManager extends BaseManager{

		

	public CandidateContainer createCandidateContainer(HisUserContext userContext, String name) throws Exception;
	public CandidateContainer updateCandidateContainer(HisUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(HisUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(HisUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(HisUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;



	public void delete(HisUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CandidateElementManager getCandidateElementManager(HisUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;

	public  CandidateContainer addCandidateElement(HisUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(HisUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(HisUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


