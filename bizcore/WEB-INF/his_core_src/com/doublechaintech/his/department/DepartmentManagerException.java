
package com.doublechaintech.his.department;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
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


