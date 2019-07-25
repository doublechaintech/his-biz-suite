
/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/his_custom_src/META-INF/his_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/

package com.doublechaintech.his.secuser;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.userapp.UserApp;
import com.skynet.infrastructure.AliyunOSSService;

public class SecUserCustomManagerImpl extends CustomSecUserManagerImpl {

	public Map<String, Object> testoss(HisUserContext userContext) throws SecUserManagerException {

		AliyunOSSService service = new AliyunOSSService();

		String key = this.getCurrentAppKey(userContext);
		UserApp userApp = (UserApp) userContext.getCachedObject(key, UserApp.class);

		if (userApp == null) {
			throwExceptionWithMessage("请先登录");
		}
		String folderName = String.format("upload/%s/%s", userApp.getObjectType(), userApp.getObjectId());
		Map<String, Object> ossToken = service.genToken(folderName);
		System.out.println("ossToken=" + ossToken);
		return ossToken;

	}
}
