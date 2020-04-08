
package com.doublechaintech.his.page;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class PageManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public PageManagerException(String string) {
		super(string);
	}
	public PageManagerException(Message message) {
		super(message);
	}
	public PageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


