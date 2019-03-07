
package com.doublechaintech.his.registration;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class RegistrationManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public RegistrationManagerException(String string) {
		super(string);
	}
	public RegistrationManagerException(Message message) {
		super(message);
	}
	public RegistrationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


