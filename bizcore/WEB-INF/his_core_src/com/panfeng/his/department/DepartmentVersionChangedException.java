
package com.panfeng.his.department;
import com.panfeng.his.EntityNotFoundException;

public class DepartmentVersionChangedException extends DepartmentManagerException {
	private static final long serialVersionUID = 1L;
	public DepartmentVersionChangedException(String string) {
		super(string);
	}


}


