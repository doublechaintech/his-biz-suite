
package com.doublechaintech.his.doctorassignment;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
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


