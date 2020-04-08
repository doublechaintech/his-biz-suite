package com.doublechaintech.his;

public class HisListOfViewScope extends BaseHisListOfViewScope {

	protected static HisListOfViewScope instance = new HisListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static HisListOfViewScope getInstance() {
		return instance;
	}
}















