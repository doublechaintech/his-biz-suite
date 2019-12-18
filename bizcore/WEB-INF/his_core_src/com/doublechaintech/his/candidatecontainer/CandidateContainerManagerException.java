
package com.doublechaintech.his.candidatecontainer;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class CandidateContainerManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public CandidateContainerManagerException(String string) {
		super(string);
	}
	public CandidateContainerManagerException(Message message) {
		super(message);
	}
	public CandidateContainerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


