
package com.doublechaintech.his.slide;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface SlideManager extends BaseManager{

		

	public Slide createSlide(HisUserContext userContext, int displayOrder,String name,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception;
	public Slide updateSlide(HisUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Slide loadSlide(HisUserContext userContext, String slideId, String [] tokensExpr) throws Exception;
	public Slide internalSaveSlide(HisUserContext userContext, Slide slide) throws Exception;
	public Slide internalSaveSlide(HisUserContext userContext, Slide slide,Map<String,Object>option) throws Exception;

	public Slide transferToAnotherPage(HisUserContext userContext, String slideId, String anotherPageId)  throws Exception;
 

	public void delete(HisUserContext userContext, String slideId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, Slide newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(HisUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(HisUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


