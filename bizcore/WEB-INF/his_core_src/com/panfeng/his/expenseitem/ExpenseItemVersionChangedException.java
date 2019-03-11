
package com.panfeng.his.expenseitem;
import com.panfeng.his.EntityNotFoundException;

public class ExpenseItemVersionChangedException extends ExpenseItemManagerException {
	private static final long serialVersionUID = 1L;
	public ExpenseItemVersionChangedException(String string) {
		super(string);
	}


}


