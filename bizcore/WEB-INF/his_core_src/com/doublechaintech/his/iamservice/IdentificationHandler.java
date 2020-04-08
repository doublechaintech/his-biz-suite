package com.doublechaintech.his.iamservice;

import com.doublechaintech.his.HisUserContext;

public interface IdentificationHandler {

	/** 完成认证 */
	LoginResult authenticate(HisUserContext userContext, LoginContext loginContext);
	/** 绑定用户 */
	void bindWithSecUser(HisUserContext userContext, LoginContext loginContext) throws Exception;
}
















