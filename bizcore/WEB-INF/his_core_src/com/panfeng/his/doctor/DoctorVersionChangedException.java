
package com.panfeng.his.doctor;
import com.panfeng.his.EntityNotFoundException;

public class DoctorVersionChangedException extends DoctorManagerException {
	private static final long serialVersionUID = 1L;
	public DoctorVersionChangedException(String string) {
		super(string);
	}


}


