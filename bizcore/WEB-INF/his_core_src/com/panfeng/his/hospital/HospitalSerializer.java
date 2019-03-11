package com.panfeng.his.hospital;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.panfeng.his.HisObjectPlainCustomSerializer;
public class HospitalSerializer extends HisObjectPlainCustomSerializer<Hospital>{

	@Override
	public void serialize(Hospital hospital, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, hospital, provider);
		
	}
}


