
package com.doublechaintech.his.treenode;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class TreeNodeManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public TreeNodeManagerException(String string) {
		super(string);
	}
	public TreeNodeManagerException(Message message) {
		super(message);
	}
	public TreeNodeManagerException(List<Message> messageList) {
		super(messageList);
	}

}



















