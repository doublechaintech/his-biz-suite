package com.doublechaintech.his;


import com.terapico.caf.viewpage.SerializeScope;

public class HisViewScope extends HisBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static HisViewScope instance = null;
	public static HisViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (HisViewScope.class) {
			instance = new HisViewScope();
		}
		return instance;
	}
}

















