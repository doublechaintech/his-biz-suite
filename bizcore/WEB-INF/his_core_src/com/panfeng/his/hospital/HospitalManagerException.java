
package com.panfeng.his.hospital;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
import java.util.List;

public class HospitalManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public HospitalManagerException(String string) {
		super(string);
	}
	public HospitalManagerException(Message message) {
		super(message);
	}
	public HospitalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


