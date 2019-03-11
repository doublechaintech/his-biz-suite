
package com.panfeng.his.expensetype;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
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


