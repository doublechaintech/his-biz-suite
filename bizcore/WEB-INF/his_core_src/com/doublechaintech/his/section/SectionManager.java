
package com.doublechaintech.his.section;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface SectionManager extends BaseManager{

		

	public Section createSection(HisUserContext userContext, String title,String brief,String icon,String viewGroup,String linkToUrl,String page) throws Exception;
	public Section updateSection(HisUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Section loadSection(HisUserContext userContext, String sectionId, String [] tokensExpr) throws Exception;
	public Section internalSaveSection(HisUserContext userContext, Section section) throws Exception;
	public Section internalSaveSection(HisUserContext userContext, Section section,Map<String,Object>option) throws Exception;



	public void delete(HisUserContext userContext, String sectionId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Section newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


