
package com.doublechaintech.his.expensetype;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class ExpenseTypeManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public ExpenseTypeManagerException(String string) {
		super(string);
	}
	public ExpenseTypeManagerException(Message message) {
		super(message);
	}
	public ExpenseTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


