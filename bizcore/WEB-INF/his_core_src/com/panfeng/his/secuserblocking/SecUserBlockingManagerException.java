
package com.panfeng.his.secuserblocking;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
import java.util.List;

public class SecUserBlockingManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public SecUserBlockingManagerException(String string) {
		super(string);
	}
	public SecUserBlockingManagerException(Message message) {
		super(message);
	}
	public SecUserBlockingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


