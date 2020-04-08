
package com.doublechaintech.his.section;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.his.HisBaseDAOImpl;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.SmartList;
import com.doublechaintech.his.AccessKey;
import com.doublechaintech.his.DateKey;
import com.doublechaintech.his.StatsInfo;
import com.doublechaintech.his.StatsItem;

import com.doublechaintech.his.MultipleAccessKey;
import com.doublechaintech.his.HisUserContext;






import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SectionJDBCTemplateDAO extends HisBaseDAOImpl implements SectionDAO{


			
		

	
	/*
	protected Section load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSection(accessKey, options);
	}
	*/
	
	public SmartList<Section> loadAll() {
	    return this.loadAll(getSectionMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Section load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSection(SectionTable.withId(id), options);
	}
	
	
	
	public Section save(Section section,Map<String,Object> options){
		
		String methodName="save(Section section,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(section, methodName, "section");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSection(section,options);
	}
	public Section clone(String sectionId, Map<String,Object> options) throws Exception{
	
		return clone(SectionTable.withId(sectionId),options);
	}
	
	protected Section clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String sectionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Section newSection = loadInternalSection(accessKey, options);
		newSection.setVersion(0);
		
		

		
		saveInternalSection(newSection,options);
		
		return newSection;
	}
	
	
	
	

	protected void throwIfHasException(String sectionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SectionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SectionNotFoundException(
					"The " + this.getTableName() + "(" + sectionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String sectionId, int version) throws Exception{
	
		String methodName="delete(String sectionId, int version)";
		assertMethodArgumentNotNull(sectionId, methodName, "sectionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{sectionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(sectionId,version);
		}
		
	
	}
	
	
	
	
	

	public Section disconnectFromAll(String sectionId, int version) throws Exception{
	
		
		Section section = loadInternalSection(SectionTable.withId(sectionId), emptyOptions());
		section.clearFromAll();
		this.saveSection(section);
		return section;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SectionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "section";
	}
	@Override
	protected String getBeanName() {
		
		return "section";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SectionTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected SectionMapper getSectionMapper(){
		return new SectionMapper();
	}

	
	
	protected Section extractSection(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Section section = loadSingleObject(accessKey, getSectionMapper());
			return section;
		}catch(EmptyResultDataAccessException e){
			throw new SectionNotFoundException("Section("+accessKey+") is not found!");
		}

	}

	
	

	protected Section loadInternalSection(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Section section = extractSection(accessKey, loadOptions);

		
		return section;
		
	}

	
		
		
 	
		
		
		

	

	protected Section saveSection(Section  section){
		
		if(!section.isChanged()){
			return section;
		}
		
		
		String SQL=this.getSaveSectionSQL(section);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSectionParameters(section);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		section.incVersion();
		return section;
	
	}
	public SmartList<Section> saveSectionList(SmartList<Section> sectionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSectionList(sectionList);
		
		batchSectionCreate((List<Section>)lists[CREATE_LIST_INDEX]);
		
		batchSectionUpdate((List<Section>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Section section:sectionList){
			if(section.isChanged()){
				section.incVersion();
			}
			
		
		}
		
		
		return sectionList;
	}

	public SmartList<Section> removeSectionList(SmartList<Section> sectionList,Map<String,Object> options){
		
		
		super.removeList(sectionList, options);
		
		return sectionList;
		
		
	}
	
	protected List<Object[]> prepareSectionBatchCreateArgs(List<Section> sectionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Section section:sectionList ){
			Object [] parameters = prepareSectionCreateParameters(section);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSectionBatchUpdateArgs(List<Section> sectionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Section section:sectionList ){
			if(!section.isChanged()){
				continue;
			}
			Object [] parameters = prepareSectionUpdateParameters(section);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSectionCreate(List<Section> sectionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSectionBatchCreateArgs(sectionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSectionUpdate(List<Section> sectionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSectionBatchUpdateArgs(sectionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSectionList(List<Section> sectionList){
		
		List<Section> sectionCreateList=new ArrayList<Section>();
		List<Section> sectionUpdateList=new ArrayList<Section>();
		
		for(Section section: sectionList){
			if(isUpdateRequest(section)){
				sectionUpdateList.add( section);
				continue;
			}
			sectionCreateList.add(section);
		}
		
		return new Object[]{sectionCreateList,sectionUpdateList};
	}
	
	protected boolean isUpdateRequest(Section section){
 		return section.getVersion() > 0;
 	}
 	protected String getSaveSectionSQL(Section section){
 		if(isUpdateRequest(section)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSectionParameters(Section section){
 		if(isUpdateRequest(section) ){
 			return prepareSectionUpdateParameters(section);
 		}
 		return prepareSectionCreateParameters(section);
 	}
 	protected Object[] prepareSectionUpdateParameters(Section section){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = section.getTitle();
 		
 		
 		parameters[1] = section.getBrief();
 		
 		
 		parameters[2] = section.getIcon();
 		
 		
 		parameters[3] = section.getViewGroup();
 		
 		
 		parameters[4] = section.getLinkToUrl();
 		
 		
 		parameters[5] = section.getPage();
 				
 		parameters[6] = section.nextVersion();
 		parameters[7] = section.getId();
 		parameters[8] = section.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSectionCreateParameters(Section section){
		Object[] parameters = new Object[7];
		String newSectionId=getNextId();
		section.setId(newSectionId);
		parameters[0] =  section.getId();
 
 		
 		parameters[1] = section.getTitle();
 		
 		
 		parameters[2] = section.getBrief();
 		
 		
 		parameters[3] = section.getIcon();
 		
 		
 		parameters[4] = section.getViewGroup();
 		
 		
 		parameters[5] = section.getLinkToUrl();
 		
 		
 		parameters[6] = section.getPage();
 				
 				
 		return parameters;
 	}
 	
	protected Section saveInternalSection(Section section, Map<String,Object> options){
		
		saveSection(section);

		
		return section;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public Section present(Section section,Map<String, Object> options){
	

		return section;
	
	}
		

	

	protected String getTableName(){
		return SectionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Section> sectionList) {		
		this.enhanceListInternal(sectionList, this.getSectionMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Section> sectionList = ownerEntity.collectRefsWithType(Section.INTERNAL_TYPE);
		this.enhanceList(sectionList);
		
	}
	
	@Override
	public SmartList<Section> findSectionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSectionMapper());

	}
	@Override
	public int countSectionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSectionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Section> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSectionMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSection executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSection result = new CandidateSection();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


