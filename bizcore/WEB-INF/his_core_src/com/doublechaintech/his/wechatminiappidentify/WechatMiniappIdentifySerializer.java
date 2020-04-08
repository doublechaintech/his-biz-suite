package com.doublechaintech.his.wechatminiappidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class WechatMiniappIdentifySerializer extends HisObjectPlainCustomSerializer<WechatMiniappIdentify>{

	@Override
	public void serialize(WechatMiniappIdentify wechatMiniappIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatMiniappIdentify, provider);
		
	}
}


