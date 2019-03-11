
package com.panfeng.his.doctorassignment;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
import java.util.List;

public class DoctorAssignmentManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public DoctorAssignmentManagerException(String string) {
		super(string);
	}
	public DoctorAssignmentManagerException(Message message) {
		super(message);
	}
	public DoctorAssignmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


