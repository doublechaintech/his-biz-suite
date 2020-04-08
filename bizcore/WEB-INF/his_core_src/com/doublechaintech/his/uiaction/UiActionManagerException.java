
package com.doublechaintech.his.uiaction;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class UiActionManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public UiActionManagerException(String string) {
		super(string);
	}
	public UiActionManagerException(Message message) {
		super(message);
	}
	public UiActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


