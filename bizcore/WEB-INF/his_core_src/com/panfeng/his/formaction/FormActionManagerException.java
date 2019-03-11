
package com.panfeng.his.formaction;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
import java.util.List;

public class FormActionManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public FormActionManagerException(String string) {
		super(string);
	}
	public FormActionManagerException(Message message) {
		super(message);
	}
	public FormActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}












