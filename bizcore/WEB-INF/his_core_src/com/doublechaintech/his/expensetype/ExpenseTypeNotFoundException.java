
package com.doublechaintech.his.expensetype;
import com.doublechaintech.his.EntityNotFoundException;
public class ExpenseTypeNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ExpenseTypeNotFoundException(String string) {
		super(string);
	}

}

