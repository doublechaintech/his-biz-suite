
package com.doublechaintech.his.candidateelement;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class CandidateElementManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public CandidateElementManagerException(String string) {
		super(string);
	}
	public CandidateElementManagerException(Message message) {
		super(message);
	}
	public CandidateElementManagerException(List<Message> messageList) {
		super(messageList);
	}

}


