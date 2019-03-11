
package com.panfeng.his.doctorschedule;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
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


