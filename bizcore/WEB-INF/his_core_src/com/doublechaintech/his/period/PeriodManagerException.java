
package com.doublechaintech.his.period;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class PeriodManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public PeriodManagerException(String string) {
		super(string);
	}
	public PeriodManagerException(Message message) {
		super(message);
	}
	public PeriodManagerException(List<Message> messageList) {
		super(messageList);
	}

}


