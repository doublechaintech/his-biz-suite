
package  com.doublechaintech.his;

import com.terapico.caf.baseelement.CandidateQuery;

public interface BaseManager{
	<D> D daoOf(HisUserContext userContext);
	
	Object queryCandidates(HisUserContext userContext, CandidateQuery query) throws Exception;
	
	Object queryCandidatesForAssign(HisUserContext userContext, CandidateQuery query) throws Exception;

	Object queryCandidatesForSearch(HisUserContext userContext, CandidateQuery query) throws Exception;
}
















