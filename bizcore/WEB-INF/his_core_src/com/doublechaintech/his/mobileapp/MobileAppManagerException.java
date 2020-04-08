
package com.doublechaintech.his.mobileapp;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class MobileAppManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public MobileAppManagerException(String string) {
		super(string);
	}
	public MobileAppManagerException(Message message) {
		super(message);
	}
	public MobileAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


