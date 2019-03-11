package com.panfeng.his.doctor;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.panfeng.his.HisObjectPlainCustomSerializer;
public class DoctorSerializer extends HisObjectPlainCustomSerializer<Doctor>{

	@Override
	public void serialize(Doctor doctor, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, doctor, provider);
		
	}
}


