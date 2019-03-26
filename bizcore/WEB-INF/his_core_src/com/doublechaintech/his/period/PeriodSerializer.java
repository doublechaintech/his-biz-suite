package com.doublechaintech.his.period;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class PeriodSerializer extends HisObjectPlainCustomSerializer<Period>{

	@Override
	public void serialize(Period period, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, period, provider);
		
	}
}


