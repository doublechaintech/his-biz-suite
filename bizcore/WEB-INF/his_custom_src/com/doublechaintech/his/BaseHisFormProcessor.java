package com.doublechaintech.his;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseHisFormProcessor extends BaseFormProcessor{
	protected HisUserContext userContext;
	
	public HisUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(HisUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(HisException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(HisUserContext userContext) {
		return null; 
	}
}















