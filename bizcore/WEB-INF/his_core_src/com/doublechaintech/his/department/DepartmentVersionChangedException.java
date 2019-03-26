
package com.doublechaintech.his.department;
import com.doublechaintech.his.EntityNotFoundException;

public class DepartmentVersionChangedException extends DepartmentManagerException {
	private static final long serialVersionUID = 1L;
	public DepartmentVersionChangedException(String string) {
		super(string);
	}


}


