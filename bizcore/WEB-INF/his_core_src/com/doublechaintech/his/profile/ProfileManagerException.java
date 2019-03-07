
package com.doublechaintech.his.profile;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class ProfileManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public ProfileManagerException(String string) {
		super(string);
	}
	public ProfileManagerException(Message message) {
		super(message);
	}
	public ProfileManagerException(List<Message> messageList) {
		super(messageList);
	}

}


