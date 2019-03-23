
package com.doublechaintech.his.genericform;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class GenericFormManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public GenericFormManagerException(String string) {
		super(string);
	}
	public GenericFormManagerException(Message message) {
		super(message);
	}
	public GenericFormManagerException(List<Message> messageList) {
		super(messageList);
	}

}


