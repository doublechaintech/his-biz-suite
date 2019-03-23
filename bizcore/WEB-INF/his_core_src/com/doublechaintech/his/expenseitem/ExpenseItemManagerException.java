
package com.doublechaintech.his.expenseitem;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class ExpenseItemManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public ExpenseItemManagerException(String string) {
		super(string);
	}
	public ExpenseItemManagerException(Message message) {
		super(message);
	}
	public ExpenseItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


