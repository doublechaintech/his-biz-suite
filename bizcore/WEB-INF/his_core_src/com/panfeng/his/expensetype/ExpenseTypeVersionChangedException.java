
package com.panfeng.his.expensetype;
import com.panfeng.his.EntityNotFoundException;

public class ExpenseTypeVersionChangedException extends ExpenseTypeManagerException {
	private static final long serialVersionUID = 1L;
	public ExpenseTypeVersionChangedException(String string) {
		super(string);
	}


}


