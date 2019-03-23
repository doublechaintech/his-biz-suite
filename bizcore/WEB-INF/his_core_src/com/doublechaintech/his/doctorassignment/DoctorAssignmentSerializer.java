package com.doublechaintech.his.doctorassignment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class DoctorAssignmentSerializer extends HisObjectPlainCustomSerializer<DoctorAssignment>{

	@Override
	public void serialize(DoctorAssignment doctorAssignment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, doctorAssignment, provider);
		
	}
}


