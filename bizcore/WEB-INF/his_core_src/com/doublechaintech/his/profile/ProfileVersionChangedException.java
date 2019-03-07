
package com.doublechaintech.his.profile;
import com.doublechaintech.his.EntityNotFoundException;

public class ProfileVersionChangedException extends ProfileManagerException {
	private static final long serialVersionUID = 1L;
	public ProfileVersionChangedException(String string) {
		super(string);
	}


}


