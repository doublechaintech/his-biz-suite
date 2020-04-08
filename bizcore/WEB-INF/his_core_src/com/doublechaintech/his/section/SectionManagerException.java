
package com.doublechaintech.his.section;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class SectionManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public SectionManagerException(String string) {
		super(string);
	}
	public SectionManagerException(Message message) {
		super(message);
	}
	public SectionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


