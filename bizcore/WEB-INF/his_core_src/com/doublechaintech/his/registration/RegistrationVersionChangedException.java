
package com.doublechaintech.his.registration;
import com.doublechaintech.his.EntityNotFoundException;

public class RegistrationVersionChangedException extends RegistrationManagerException {
	private static final long serialVersionUID = 1L;
	public RegistrationVersionChangedException(String string) {
		super(string);
	}


}


