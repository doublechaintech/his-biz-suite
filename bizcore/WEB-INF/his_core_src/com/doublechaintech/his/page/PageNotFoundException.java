
package com.doublechaintech.his.page;
import com.doublechaintech.his.EntityNotFoundException;
public class PageNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public PageNotFoundException(String string) {
		super(string);
	}

}

