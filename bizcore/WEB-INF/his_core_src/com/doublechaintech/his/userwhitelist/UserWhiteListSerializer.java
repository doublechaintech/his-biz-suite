package com.doublechaintech.his.userwhitelist;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class UserWhiteListSerializer extends HisObjectPlainCustomSerializer<UserWhiteList>{

	@Override
	public void serialize(UserWhiteList userWhiteList, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userWhiteList, provider);
		
	}
}


