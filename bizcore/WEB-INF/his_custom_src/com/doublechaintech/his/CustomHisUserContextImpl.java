package com.doublechaintech.his;

public class CustomHisUserContextImpl extends HisBizUserContextImpl{
	protected BaseEntity currentUserInfo;

	public BaseEntity getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(BaseEntity currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}

