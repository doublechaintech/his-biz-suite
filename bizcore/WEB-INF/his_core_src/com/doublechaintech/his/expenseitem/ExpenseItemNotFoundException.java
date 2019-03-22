
package com.doublechaintech.his.expenseitem;
import com.doublechaintech.his.EntityNotFoundException;
public class ExpenseItemNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ExpenseItemNotFoundException(String string) {
		super(string);
	}

}

