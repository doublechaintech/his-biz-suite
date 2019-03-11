package com.panfeng.his.expenseitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.panfeng.his.HisObjectPlainCustomSerializer;
public class ExpenseItemSerializer extends HisObjectPlainCustomSerializer<ExpenseItem>{

	@Override
	public void serialize(ExpenseItem expenseItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, expenseItem, provider);
		
	}
}


