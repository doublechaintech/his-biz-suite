package com.doublechaintech.his;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class HisNamingServiceDAO extends CommonJDBCTemplateDAO {

	private static Map<String, String[]>namingTableMap;
	static {
		namingTableMap = new HashMap<String, String[]>();
		namingTableMap.put("Hospital", new String[]{"hospital_data","name"});
		namingTableMap.put("ExpenseType", new String[]{"expense_type_data","name"});
		namingTableMap.put("Period", new String[]{"period_data","name"});
		namingTableMap.put("ExpenseItem", new String[]{"expense_item_data","name"});
		namingTableMap.put("Doctor", new String[]{"doctor_data","name"});
		namingTableMap.put("Department", new String[]{"department_data","name"});
		namingTableMap.put("DoctorAssignment", new String[]{"doctor_assignment_data","name"});
		namingTableMap.put("DoctorSchedule", new String[]{"doctor_schedule_data","name"});
		namingTableMap.put("UserDomain", new String[]{"user_domain_data","name"});
		namingTableMap.put("UserWhiteList", new String[]{"user_white_list_data","user_identity"});
		namingTableMap.put("SecUser", new String[]{"sec_user_data","login"});
		namingTableMap.put("SecUserBlocking", new String[]{"sec_user_blocking_data","who"});
		namingTableMap.put("UserApp", new String[]{"user_app_data","title"});
		namingTableMap.put("ListAccess", new String[]{"list_access_data","name"});
		namingTableMap.put("ObjectAccess", new String[]{"object_access_data","name"});
		namingTableMap.put("LoginHistory", new String[]{"login_history_data","from_ip"});
		namingTableMap.put("GenericForm", new String[]{"generic_form_data","title"});
		namingTableMap.put("FormMessage", new String[]{"form_message_data","title"});
		namingTableMap.put("FormFieldMessage", new String[]{"form_field_message_data","title"});
		namingTableMap.put("FormField", new String[]{"form_field_data","label"});
		namingTableMap.put("FormAction", new String[]{"form_action_data","label"});
		

		
		
	}

	@Override
	protected String[] getNormalColumnNames() {
		// TODO Auto-generated method stub
		return new String[]{"id"};
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "naming";
	}

	@Override
	protected String getBeanName() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public void alias(List<BaseEntity> entityList){
		//this.getClass().getSimpleName()
		//these objects are most likely the same, or most are the same
		if(entityList == null){
			//noting to be enhanced
			return;
		}
		
		if(entityList.isEmpty()){
			//noting to be enhanced
			return;
		}
		List<BaseEntity> entityListToSort = new ArrayList<BaseEntity>();
		entityListToSort.addAll(entityList);
		Collections.sort(entityListToSort, new Comparator<BaseEntity>(){

			@Override
			public int compare(BaseEntity o1, BaseEntity o2) {
				if(o1==o2){
					return 0;
				}
				if(o1==null){
					return 1;
				}
				int round1 = internalTypeOf(o1).compareTo(internalTypeOf(o2));
				
				if(round1!=0){
					return round1;
				}
				if(o1.getId()==null){
					return 1;//should check in pojo, but prevent the bad thing happing
				}
				if(o2.getId()==null){
					return -1;//should check in pojo, but prevent the bad thing happing
				}
				int round2 = o1.getId().compareTo(o2.getId());
				
				return round2;
			}
			
		});
		List<BaseEntity> sortedEntityList = entityListToSort;//just for better reading
		//with a sorted list, the find out the sql and parameters
		Map<String, List<String>> sqlMap = sqlMapOf(sortedEntityList);
		String unionedSQL = unionSQLOf(sqlMap);
		Object [] parameters = parametersOf(sqlMap);
		Map<String,String> resultMap = getResultMap(unionedSQL, parameters);
		fillResult(entityList, resultMap);

		//List<BaseEntity> resultList = this.queryForList(unionedSQL, parameters, getMapper());
		
	}

	protected  void fillResult(List<BaseEntity> entityList,Map<String, String> resultMap) {
		
		for(BaseEntity baseEntity: entityList){
			String displayName = findDisplayNameInMap(baseEntity, resultMap);
			if(displayName==null){
				baseEntity.setDisplayName("<null>");
				continue;
			}
			baseEntity.setDisplayName(displayName);
		}
		
		
	}

	protected String findDisplayNameInMap(BaseEntity baseEntity, Map<String, String> resultMap) {
		String key = this.join(internalTypeOf(baseEntity),":",baseEntity.getId());
		return resultMap.get(key);
	}

	protected String trimString(String valueToTrim) {
		if(valueToTrim==null) {
			return null;
		}
		if(valueToTrim.isEmpty()) {
			return "";
		}
		return valueToTrim.trim();
		
	}
	protected Map<String, String> getResultMap(String unionedSQL,
			Object[] parameters) {
		
		this.logSQLAndParameters("getDisplayName", unionedSQL, parameters,"---");
		
		
		return getJdbcTemplateObject().query(unionedSQL, parameters,new ResultSetExtractor<Map<String,String>>(){

			@Override
			public Map<String,String > extractData(ResultSet resultSet) throws SQLException,
					DataAccessException {
				
				
				Map<String,String> internalMap = new HashMap<String,String>();
				while(resultSet.next()){ 
					String key = trimString(resultSet.getString(1))+":"+trimString(resultSet.getString(2));
					// Fixed the issue for Informix and Gbase 8t/s data base, it appends values for the class column
					String value = resultSet.getString(3);
					
					// System.out.printf("%s = %s\r\n",key, value);
					
					internalMap.put(key, value);
					
				} 
				return internalMap;
			}
			
		});
	}
	


	protected Object[] parametersOf(Map<String, List<String>> sqlMap) {
		// TODO Auto-generated method stub
		List<Object> resultParameters = new ArrayList<Object>();
		for(Map.Entry<String, List<String>> entry: sqlMap.entrySet()){
			List<String> parameters = entry.getValue();
			resultParameters.addAll(parameters);
		}
		return resultParameters.toArray();
	}
	
	private String unionSQLOf(Map<String, List<String>> sqlMap) {
		
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0 ;
		for(Map.Entry<String, List<String>> entry: sqlMap.entrySet()){
			
			if(index>0){
				
				stringBuilder.append("\r\n");
				stringBuilder.append(" union ");
				
			}
			String sqlPrefix = entry.getKey();
			List<String> parameters = entry.getValue();
			String sqlToUnion = this.getNamingQuerySQL(sqlPrefix, parameters);
			stringBuilder.append(sqlToUnion);
			index++;
			
		}
		
		return stringBuilder.toString();
	}

	Map<String, List<String>> sqlMapOf(List<BaseEntity> sortedEntityList){
		String lastClassName = null;
		List<String> idList = null;
		Map<String, List<String>> sqlMap = new HashMap<String, List<String>>();
		for(BaseEntity baseEntity: sortedEntityList){
			
			String currentClassName = this.internalTypeOf(baseEntity);
			
			if(currentClassName.equals(lastClassName)){
				if(idList.contains(baseEntity.getId())){
					continue;
				}
				idList.add(baseEntity.getId());
				continue;
			}
			idList = new ArrayList<String>();
			idList.add(baseEntity.getId());
			String sql = sqlOf(currentClassName);
			
			sqlMap.put(sql, idList);
			
			lastClassName = currentClassName;
			
			
		}
		return sqlMap;
	}
	protected String sqlOf(String currentClassName) {
		String[] sqlInfo=namingTableMap.get(currentClassName);
		if(sqlInfo==null){
			throw new IllegalArgumentException("sqlOf(String currentClassName): Not able to find sql info for class: "+currentClassName);
		}
		if(sqlInfo.length<2){
			throw new IllegalArgumentException("sqlOf(String currentClassName): sqlInfo.length should equals 2 for class: "+currentClassName);
			
		}
		String tableName = sqlInfo[0];
		String displayExpr = sqlInfo[1];
		
		
		String sql = this.join("select '",currentClassName,"' as class_name, id, ",displayExpr," as display_name from ",tableName," where id in ");
		
		return sql;
	}

	protected String internalTypeOf(BaseEntity baseEntity){
		if(baseEntity==null){
			return "null";
		}
		return baseEntity.getInternalType();
	}
	protected Set <BaseEntity>  uniqize(List<BaseEntity> entityList){
		Set <BaseEntity> baseEntitySet = new HashSet<BaseEntity>();
		for(BaseEntity baseEntity: entityList){
			if(baseEntity == null){
				continue;
			}
			if(baseEntity.getId() == null){
				continue;
			}
			baseEntitySet.add(baseEntity);
		}
		return baseEntitySet;
		
	}
	
	protected String getNamingQuerySQL(String sqlPrefix, List<String> entityList){
		
		String SQL = this.join(sqlPrefix, "(",repeatExpr("?",",",entityList.size()),")");// "select * from "+this.getTableName()+" where id in ;
		
		return SQL;
	}
	
	/*
	static {
		namingTableMap = new HashMap<String, String[]>();


		namingTableMap.put("CarInspectionPlatform", new String[]{"car_inspection_platform_data","name"});
		namingTableMap.put("IdentityCard", new String[]{"identity_card_data","holder_name"});
	
		
		
	}*/
	
    
}

















