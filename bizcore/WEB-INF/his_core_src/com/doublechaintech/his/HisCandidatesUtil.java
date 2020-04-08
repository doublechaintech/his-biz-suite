package com.doublechaintech.his;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.doublechaintech.his.tree.Node;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.BaseCandidatesUtil;

public class HisCandidatesUtil extends BaseCandidatesUtil{
	static {
		_for("ui_action").referTo("page").withRole("page");
		_for("ui_action").isTree("false");
		_for("ui_action").hasFields(";id;code;icon;title;brief;image_url;link_to_url;extra_data;version;");
		_for("ui_action").targetType("ui_action");
		_for("ui_action").anchorColumn("page");
		_for("doctor_schedule").referTo("doctor").withRole("doctor");
		_for("doctor_schedule").referTo("period").withRole("period");
		_for("doctor_schedule").referTo("expense_type").withRole("expense_type");
		_for("doctor_schedule").referTo("department").withRole("department");
		_for("doctor_schedule").referTo("hospital").withRole("hospital");
		_for("doctor_schedule").isTree("false");
		_for("doctor_schedule").hasFields(";id;name;schedule_date;available;price;create_time;update_time;version;");
		_for("doctor_schedule").targetType("doctor_schedule");
		_for("doctor_schedule").anchorColumn("doctor");
		_for("expense_item").referTo("expense_type").withRole("expense_type");
		_for("expense_item").referTo("hospital").withRole("hospital");
		_for("expense_item").isTree("false");
		_for("expense_item").hasFields(";id;name;price;update_time;version;");
		_for("expense_item").targetType("expense_item");
		_for("expense_item").anchorColumn("expense_type");
		_for("doctor_assignment").referTo("doctor").withRole("doctor");
		_for("doctor_assignment").referTo("department").withRole("department");
		_for("doctor_assignment").isTree("false");
		_for("doctor_assignment").hasFields(";id;name;update_time;version;");
		_for("doctor_assignment").targetType("doctor_assignment");
		_for("doctor_assignment").anchorColumn("doctor");
		_for("page_type").referTo("mobile_app").withRole("mobile_app");
		_for("page_type").usedIn("page").withRole("page_type");
		_for("page_type").isTree("false");
		_for("page_type").hasFields(";id;name;code;footer_tab;version;");
		_for("page_type").targetType("page_type");
		_for("page_type").anchorColumn("mobile_app");
		_for("section").isTree("false");
		_for("section").hasFields(";id;title;brief;icon;view_group;link_to_url;page;version;");
		_for("section").targetType("section");
		_for("user_app").referTo("sec_user").withRole("sec_user");
		_for("user_app").usedIn("quick_link").withRole("app");
		_for("user_app").usedIn("object_access").withRole("app");
		_for("user_app").usedIn("list_access").withRole("app");
		_for("user_app").isTree("false");
		_for("user_app").hasFields(";id;title;app_icon;full_access;permission;object_type;object_id;location;version;");
		_for("user_app").targetType("user_app");
		_for("user_app").anchorColumn("sec_user");
		_for("form_message").referTo("generic_form").withRole("form");
		_for("form_message").isTree("false");
		_for("form_message").hasFields(";id;title;level;version;");
		_for("form_message").targetType("form_message");
		_for("form_message").anchorColumn("form");
		_for("user_white_list").referTo("user_domain").withRole("domain");
		_for("user_white_list").isTree("false");
		_for("user_white_list").hasFields(";id;user_identity;user_special_functions;version;");
		_for("user_white_list").targetType("user_white_list");
		_for("user_white_list").anchorColumn("domain");
		_for("user_domain").usedIn("user_white_list").withRole("domain");
		_for("user_domain").usedIn("sec_user").withRole("domain");
		_for("user_domain").isTree("false");
		_for("user_domain").hasFields(";id;name;version;");
		_for("user_domain").targetType("user_domain");
		_for("quick_link").referTo("user_app").withRole("app");
		_for("quick_link").isTree("false");
		_for("quick_link").hasFields(";id;name;icon;image_path;link_target;create_time;version;");
		_for("quick_link").targetType("quick_link");
		_for("quick_link").anchorColumn("app");
		_for("login_history").referTo("sec_user").withRole("sec_user");
		_for("login_history").isTree("false");
		_for("login_history").hasFields(";id;login_time;from_ip;description;version;");
		_for("login_history").targetType("login_history");
		_for("login_history").anchorColumn("sec_user");
		_for("form_field").referTo("generic_form").withRole("form");
		_for("form_field").isTree("false");
		_for("form_field").hasFields(";id;label;locale_key;parameter_name;type;placeholder;default_value;description;field_group;minimum_value;maximum_value;required;disabled;custom_rendering;candidate_values;suggest_values;version;");
		_for("form_field").targetType("form_field");
		_for("form_field").anchorColumn("form");
		_for("wechat_workapp_identify").referTo("sec_user").withRole("sec_user");
		_for("wechat_workapp_identify").isTree("false");
		_for("wechat_workapp_identify").hasFields(";id;corp_id;user_id;create_time;last_login_time;version;");
		_for("wechat_workapp_identify").targetType("wechat_workapp_identify");
		_for("wechat_workapp_identify").anchorColumn("sec_user");
		_for("hospital").usedIn("doctor").withRole("hospital");
		_for("hospital").usedIn("expense_type").withRole("hospital");
		_for("hospital").usedIn("period").withRole("hospital");
		_for("hospital").usedIn("doctor_schedule").withRole("hospital");
		_for("hospital").usedIn("expense_item").withRole("hospital");
		_for("hospital").usedIn("department").withRole("hospital");
		_for("hospital").isTree("false");
		_for("hospital").hasFields(";id;name;address;telephone;version;");
		_for("hospital").targetType("hospital");
		_for("department").referTo("hospital").withRole("hospital");
		_for("department").usedIn("doctor_schedule").withRole("department");
		_for("department").usedIn("doctor_assignment").withRole("department");
		_for("department").isTree("false");
		_for("department").hasFields(";id;name;update_time;version;");
		_for("department").targetType("department");
		_for("department").anchorColumn("hospital");
		_for("list_access").referTo("user_app").withRole("app");
		_for("list_access").isTree("false");
		_for("list_access").hasFields(";id;name;internal_name;read_permission;create_permission;delete_permission;update_permission;execution_permission;version;");
		_for("list_access").targetType("list_access");
		_for("list_access").anchorColumn("app");
		_for("mobile_app").usedIn("page_type").withRole("mobile_app");
		_for("mobile_app").usedIn("page").withRole("mobile_app");
		_for("mobile_app").isTree("false");
		_for("mobile_app").hasFields(";id;name;version;");
		_for("mobile_app").targetType("mobile_app");
		_for("candidate_container").usedIn("candidate_element").withRole("container");
		_for("candidate_container").isTree("false");
		_for("candidate_container").hasFields(";id;name;version;");
		_for("candidate_container").targetType("candidate_container");
		_for("form_action").referTo("generic_form").withRole("form");
		_for("form_action").isTree("false");
		_for("form_action").hasFields(";id;label;locale_key;action_key;level;url;version;");
		_for("form_action").targetType("form_action");
		_for("form_action").anchorColumn("form");
		_for("wechat_miniapp_identify").referTo("sec_user").withRole("sec_user");
		_for("wechat_miniapp_identify").isTree("false");
		_for("wechat_miniapp_identify").hasFields(";id;open_id;app_id;create_time;last_login_time;version;");
		_for("wechat_miniapp_identify").targetType("wechat_miniapp_identify");
		_for("wechat_miniapp_identify").anchorColumn("sec_user");
		_for("expense_type").referTo("hospital").withRole("hospital");
		_for("expense_type").usedIn("doctor_schedule").withRole("expense_type");
		_for("expense_type").usedIn("expense_item").withRole("expense_type");
		_for("expense_type").isTree("false");
		_for("expense_type").hasFields(";id;name;helper_chars;status;description;update_time;version;");
		_for("expense_type").targetType("expense_type");
		_for("expense_type").anchorColumn("hospital");
		_for("period").referTo("hospital").withRole("hospital");
		_for("period").usedIn("doctor_schedule").withRole("period");
		_for("period").isTree("false");
		_for("period").hasFields(";id;name;code;version;");
		_for("period").targetType("period");
		_for("period").anchorColumn("hospital");
		_for("sec_user").referTo("user_domain").withRole("domain");
		_for("sec_user").usedIn("wechat_miniapp_identify").withRole("sec_user");
		_for("sec_user").usedIn("login_history").withRole("sec_user");
		_for("sec_user").usedIn("wechat_workapp_identify").withRole("sec_user");
		_for("sec_user").usedIn("user_app").withRole("sec_user");
		_for("sec_user").isTree("false");
		_for("sec_user").hasFields(";id;login;mobile;email;pwd;weixin_openid;weixin_appid;access_token;verification_code;verification_code_expire;last_login_time;version;");
		_for("sec_user").targetType("sec_user");
		_for("sec_user").anchorColumn("domain");
		_for("candidate_element").referTo("candidate_container").withRole("container");
		_for("candidate_element").isTree("false");
		_for("candidate_element").hasFields(";id;name;type;image;version;");
		_for("candidate_element").targetType("candidate_element");
		_for("candidate_element").anchorColumn("container");
		_for("tree_node").isTree("false");
		_for("tree_node").hasFields(";id;node_id;node_type;left_value;right_value;version;");
		_for("tree_node").targetType("tree_node");
		_for("doctor").referTo("hospital").withRole("hospital");
		_for("doctor").usedIn("doctor_schedule").withRole("doctor");
		_for("doctor").usedIn("doctor_assignment").withRole("doctor");
		_for("doctor").isTree("false");
		_for("doctor").hasFields(";id;name;shot_image;update_time;version;");
		_for("doctor").targetType("doctor");
		_for("doctor").anchorColumn("hospital");
		_for("form_field_message").referTo("generic_form").withRole("form");
		_for("form_field_message").isTree("false");
		_for("form_field_message").hasFields(";id;title;parameter_name;level;version;");
		_for("form_field_message").targetType("form_field_message");
		_for("form_field_message").anchorColumn("form");
		_for("slide").referTo("page").withRole("page");
		_for("slide").isTree("false");
		_for("slide").hasFields(";id;display_order;name;image_url;video_url;link_to_url;version;");
		_for("slide").targetType("slide");
		_for("slide").anchorColumn("page");
		_for("object_access").referTo("user_app").withRole("app");
		_for("object_access").isTree("false");
		_for("object_access").hasFields(";id;name;object_type;list1;list2;list3;list4;list5;list6;list7;list8;list9;version;");
		_for("object_access").targetType("object_access");
		_for("object_access").anchorColumn("app");
		_for("page").referTo("page_type").withRole("page_type");
		_for("page").referTo("mobile_app").withRole("mobile_app");
		_for("page").usedIn("ui_action").withRole("page");
		_for("page").usedIn("slide").withRole("page");
		_for("page").isTree("false");
		_for("page").hasFields(";id;page_title;link_to_url;version;");
		_for("page").targetType("page");
		_for("page").anchorColumn("page_type");
		_for("generic_form").usedIn("form_action").withRole("form");
		_for("generic_form").usedIn("form_field_message").withRole("form");
		_for("generic_form").usedIn("form_field").withRole("form");
		_for("generic_form").usedIn("form_message").withRole("form");
		_for("generic_form").isTree("false");
		_for("generic_form").hasFields(";id;title;description;version;");
		_for("generic_form").targetType("generic_form");

	}
	
	protected HisBaseDAOImpl currentDAO = null;
	
	public Object queryCandidates(HisUserContext userContext, CandidateQuery query) throws Exception {
		if (CandidateQuery.FOR_SEARCH.equals(query.getScenceCode())) {
			return queryCandidatesForSearch(userContext, query);
		}
		return queryCandidatesForAssign(userContext, query);
	}
	
	public Object queryCandidatesForAssign(HisUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_ASSIGN);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForAssign(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}

	public Object queryCandidatesForSearch(HisUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_SEARCH);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForSearch(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}
	
	protected Object wrapperCandidates(HisUserContext userContext, BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		SmartList<BaseEntity> cs = (SmartList<BaseEntity>) candidates.getCandidates();
		
		List<Object> rList = new ArrayList<>();
		cs.forEach(v->{
			Map<String, Object> data = new HashMap<>();
			data.put("id",v.getId());
			data.put("name",v.getDisplayName());
			data.put("valuesOfGroupBy",v.valueByKey("valuesOfGroupBy"));
			rList.add(data);
		});
		return rList;
	}
	
	protected String normalizeModelName(String name) throws Exception {
		if (name == null) {
			return null;
		}
		if (!isValidFieldName(name)) {
			throw new Exception(name+"不是一个合法的字段名");
		}
		return new HisNamingServiceDAO().mapToInternalColumn(name);
	}
	
	protected String getDisplayNameColumn(String typeName) {
		String displayNameColumn = HisNamingServiceDAO.getDisplayNameColumnName(getJavaClassName(typeName));
		return displayNameColumn;
	}

	protected BaseCandidateEntity<? extends BaseEntity> executeQuery(HisUserContext userContext, CandidateQuery query, String sql,
			List<Object> params) throws Exception{
		switch (query.getTargetType()) {
		case "hospital":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getHospitalDAO();
			return userContext.getDAOGroup().getHospitalDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "expense_type":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getExpenseTypeDAO();
			return userContext.getDAOGroup().getExpenseTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "period":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getPeriodDAO();
			return userContext.getDAOGroup().getPeriodDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "expense_item":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getExpenseItemDAO();
			return userContext.getDAOGroup().getExpenseItemDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "doctor":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getDoctorDAO();
			return userContext.getDAOGroup().getDoctorDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "department":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getDepartmentDAO();
			return userContext.getDAOGroup().getDepartmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "doctor_assignment":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getDoctorAssignmentDAO();
			return userContext.getDAOGroup().getDoctorAssignmentDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "doctor_schedule":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getDoctorScheduleDAO();
			return userContext.getDAOGroup().getDoctorScheduleDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "mobile_app":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getMobileAppDAO();
			return userContext.getDAOGroup().getMobileAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getPageDAO();
			return userContext.getDAOGroup().getPageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page_type":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getPageTypeDAO();
			return userContext.getDAOGroup().getPageTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "slide":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getSlideDAO();
			return userContext.getDAOGroup().getSlideDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "ui_action":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getUiActionDAO();
			return userContext.getDAOGroup().getUiActionDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "section":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getSectionDAO();
			return userContext.getDAOGroup().getSectionDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_domain":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getUserDomainDAO();
			return userContext.getDAOGroup().getUserDomainDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_white_list":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getUserWhiteListDAO();
			return userContext.getDAOGroup().getUserWhiteListDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "sec_user":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getSecUserDAO();
			return userContext.getDAOGroup().getSecUserDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_app":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getUserAppDAO();
			return userContext.getDAOGroup().getUserAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "quick_link":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getQuickLinkDAO();
			return userContext.getDAOGroup().getQuickLinkDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "list_access":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getListAccessDAO();
			return userContext.getDAOGroup().getListAccessDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "object_access":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getObjectAccessDAO();
			return userContext.getDAOGroup().getObjectAccessDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "login_history":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getLoginHistoryDAO();
			return userContext.getDAOGroup().getLoginHistoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "generic_form":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getGenericFormDAO();
			return userContext.getDAOGroup().getGenericFormDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "form_message":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getFormMessageDAO();
			return userContext.getDAOGroup().getFormMessageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "form_field_message":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getFormFieldMessageDAO();
			return userContext.getDAOGroup().getFormFieldMessageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "form_field":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getFormFieldDAO();
			return userContext.getDAOGroup().getFormFieldDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "form_action":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getFormActionDAO();
			return userContext.getDAOGroup().getFormActionDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_container":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getCandidateContainerDAO();
			return userContext.getDAOGroup().getCandidateContainerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_element":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getCandidateElementDAO();
			return userContext.getDAOGroup().getCandidateElementDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "wechat_workapp_identify":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
			return userContext.getDAOGroup().getWechatWorkappIdentifyDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "wechat_miniapp_identify":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
			return userContext.getDAOGroup().getWechatMiniappIdentifyDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "tree_node":
			currentDAO = (HisBaseDAOImpl)userContext.getDAOGroup().getTreeNodeDAO();
			return userContext.getDAOGroup().getTreeNodeDAO().executeCandidatesQuery(query, sql, params.toArray());

		default:
			throw new Exception("OOTB不支持"+query.getTargetType()+"的候选值查询");
		}
	}
	
	protected void enhanceGroupByValues(HisUserContext userContext, CandidateQuery query,
			BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		if (query.getGroupBy() == null) {
			return; // 没有group by就直接返回
		}
		if (!isGroupByObject(query)) {
			// 用字段 group by
			for(BaseEntity cv : candidates.getCandidates()) {
				appendGroupByInfo(cv, String.valueOf(cv.propertyOf(this.getJavaMemberName(query.getGroupBy()))));
			}
			// 收集了数据就OK了
			return; 
		}
		
		List<BaseEntity> list = new ArrayList<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				list.add((BaseEntity) x);
			}
		}
		
		currentDAO.alias(list);
		if (!isGroupByTree(query)) {
			for(BaseEntity cv : candidates.getCandidates()) {
				Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
				if (x instanceof BaseEntity) {
					appendGroupByInfo(cv, ((BaseEntity) x).getDisplayName());
				}
			}
			return;
		}
		
		String gbTypeName = this.getGroupByTypeName(query);
		Map<String, String[]> groupByNames = new HashMap<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				if (groupByNames.containsKey(((BaseEntity) x).getId())) {
					appendGroupByInfo(cv, groupByNames.get(((BaseEntity) x).getId()));
					continue;
				}
				Node<BaseEntity> rootNode = userContext.getTreeService().loadAncestors(userContext, (BaseEntity) x);
				List<String> names = new ArrayList<>();
				rootNode.visit((node)->{
					BaseEntity value = node.value();
					if (value == null) {
						return;
					}
					names.add(String.valueOf(value.getDisplayName()));
				});
				names.add(String.valueOf(((BaseEntity) x).getDisplayName()));
				appendGroupByInfo(cv, names.toArray(new String[] {}));
				groupByNames.put(((BaseEntity) x).getId(),names.toArray(new String[] {}));
			}
		}
	}
	
	protected void appendGroupByInfo(BaseEntity cv, String ... groupBy) {
		cv.addItemToValueMap("valuesOfGroupBy", groupBy);
	}
}




















