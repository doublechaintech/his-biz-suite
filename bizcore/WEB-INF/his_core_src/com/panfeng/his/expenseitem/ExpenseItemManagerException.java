
package com.panfeng.his.expenseitem;
//import com.panfeng.his.EntityNotFoundException;
import com.panfeng.his.HisException;
import com.panfeng.his.Message;
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


