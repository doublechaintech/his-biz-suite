package com.doublechaintech.his.iamservice;

import com.doublechaintech.his.HisUserContext;

public interface BusinessHandler {

	void onAuthenticationFailed(HisUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateNewUserLogged(HisUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateUserLogged(HisUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

}
















