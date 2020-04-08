
package com.doublechaintech.his.pagetype;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class PageTypeManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public PageTypeManagerException(String string) {
		super(string);
	}
	public PageTypeManagerException(Message message) {
		super(message);
	}
	public PageTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


