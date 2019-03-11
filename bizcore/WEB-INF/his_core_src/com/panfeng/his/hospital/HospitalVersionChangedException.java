
package com.panfeng.his.hospital;
import com.panfeng.his.EntityNotFoundException;

public class HospitalVersionChangedException extends HospitalManagerException {
	private static final long serialVersionUID = 1L;
	public HospitalVersionChangedException(String string) {
		super(string);
	}


}


