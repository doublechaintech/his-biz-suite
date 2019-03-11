
package com.panfeng.his.userdomain;
import com.panfeng.his.EntityNotFoundException;

public class UserDomainVersionChangedException extends UserDomainManagerException {
	private static final long serialVersionUID = 1L;
	public UserDomainVersionChangedException(String string) {
		super(string);
	}


}


