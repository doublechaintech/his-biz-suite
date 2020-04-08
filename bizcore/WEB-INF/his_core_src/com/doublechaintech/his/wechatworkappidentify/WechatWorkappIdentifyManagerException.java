
package com.doublechaintech.his.wechatworkappidentify;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class WechatWorkappIdentifyManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


