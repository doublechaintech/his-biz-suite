
package com.doublechaintech.his.hospital;
import com.doublechaintech.his.EntityNotFoundException;

public class HospitalVersionChangedException extends HospitalManagerException {
	private static final long serialVersionUID = 1L;
	public HospitalVersionChangedException(String string) {
		super(string);
	}


}


