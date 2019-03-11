package com.panfeng.his.doctorschedule;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.panfeng.his.HisObjectPlainCustomSerializer;
public class DoctorScheduleSerializer extends HisObjectPlainCustomSerializer<DoctorSchedule>{

	@Override
	public void serialize(DoctorSchedule doctorSchedule, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, doctorSchedule, provider);
		
	}
}


