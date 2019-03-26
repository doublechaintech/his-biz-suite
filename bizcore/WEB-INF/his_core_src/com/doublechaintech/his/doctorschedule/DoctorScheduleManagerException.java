
package com.doublechaintech.his.doctorschedule;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class DoctorScheduleManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public DoctorScheduleManagerException(String string) {
		super(string);
	}
	public DoctorScheduleManagerException(Message message) {
		super(message);
	}
	public DoctorScheduleManagerException(List<Message> messageList) {
		super(messageList);
	}

}


