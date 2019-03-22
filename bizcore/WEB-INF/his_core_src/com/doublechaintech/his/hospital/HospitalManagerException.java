
package com.doublechaintech.his.hospital;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
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


