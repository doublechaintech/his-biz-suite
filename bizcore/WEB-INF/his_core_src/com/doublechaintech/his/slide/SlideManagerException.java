
package com.doublechaintech.his.slide;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class SlideManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public SlideManagerException(String string) {
		super(string);
	}
	public SlideManagerException(Message message) {
		super(message);
	}
	public SlideManagerException(List<Message> messageList) {
		super(messageList);
	}

}


