
package com.panfeng.his.doctor;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
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


