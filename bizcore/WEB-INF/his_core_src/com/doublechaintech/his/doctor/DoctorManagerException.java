
package com.doublechaintech.his.doctor;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class DoctorManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public DoctorManagerException(String string) {
		super(string);
	}
	public DoctorManagerException(Message message) {
		super(message);
	}
	public DoctorManagerException(List<Message> messageList) {
		super(messageList);
	}

}


