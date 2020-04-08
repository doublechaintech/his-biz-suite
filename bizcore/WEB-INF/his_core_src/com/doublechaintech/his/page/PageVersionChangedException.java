
package com.doublechaintech.his.page;
import com.doublechaintech.his.EntityNotFoundException;

public class PageVersionChangedException extends PageManagerException {
	private static final long serialVersionUID = 1L;
	public PageVersionChangedException(String string) {
		super(string);
	}


}


