package com.doublechaintech.his.wechatworkappidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class WechatWorkappIdentifySerializer extends HisObjectPlainCustomSerializer<WechatWorkappIdentify>{

	@Override
	public void serialize(WechatWorkappIdentify wechatWorkappIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatWorkappIdentify, provider);
		
	}
}


