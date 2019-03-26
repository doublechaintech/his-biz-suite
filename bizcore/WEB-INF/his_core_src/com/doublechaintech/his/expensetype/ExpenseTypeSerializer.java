package com.doublechaintech.his.expensetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.his.HisObjectPlainCustomSerializer;
public class ExpenseTypeSerializer extends HisObjectPlainCustomSerializer<ExpenseType>{

	@Override
	public void serialize(ExpenseType expenseType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, expenseType, provider);
		
	}
}


