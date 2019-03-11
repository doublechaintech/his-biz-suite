
package com.panfeng.his.department;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
import java.util.List;

public class DepartmentManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public DepartmentManagerException(String string) {
		super(string);
	}
	public DepartmentManagerException(Message message) {
		super(message);
	}
	public DepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


