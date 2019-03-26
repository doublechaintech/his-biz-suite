<%@ page import='java.util.*,com.panfeng.his.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty expenseTypeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['expense_type']}! 
		 <a href="./${ownerBeanName}Manager/addExpenseType/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty expenseTypeList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("expenseTypeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['expense_type']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addExpenseType/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'expenseTypeList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${expenseTypeListName};${expenseTypeListName}CurrentPage=${page.pageNumber};${expenseTypeListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='expenseTypeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['expense_type.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['expense_type.name']}</th>
</c:if>
<c:if test="${param.referName ne 'helperChars'}">
	<th>${userContext.localeMap['expense_type.helper_chars']}</th>
</c:if>
<c:if test="${param.referName ne 'status'}">
	<th>${userContext.localeMap['expense_type.status']}</th>
</c:if>
<c:if test="${param.referName ne 'hospital'}">
	<th>${userContext.localeMap['expense_type.hospital']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['expense_type.description']}</th>
</c:if>
<c:if test="${param.referName ne 'updateTime'}">
	<th>${userContext.localeMap['expense_type.update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${expenseTypeList}">
				<tr currentVersion='${item.version}' id="expenseType-${item.id}" ><td><a class="link-action-removed" href="./expenseTypeManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateExpenseType/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'helperChars'}">	<td contenteditable='true' class='edit-value'  propertyToChange='helperChars' storedCellValue='${item.helperChars}' prefix='${ownerBeanName}Manager/updateExpenseType/${result.id}/${item.id}/'>${item.helperChars}</td>
</c:if><c:if test="${param.referName ne 'status'}">	<td contenteditable='true' class='edit-value'  propertyToChange='status' storedCellValue='${item.status}' prefix='${ownerBeanName}Manager/updateExpenseType/${result.id}/${item.id}/'>${item.status}</td>
</c:if><c:if test="${param.referName ne 'hospital'}">
	<td class="select_candidate_td"
			data-candidate-method="./expenseTypeManager/requestCandidateHospital/${ownerBeanName}/${item.id}/"
			data-switch-method="./expenseTypeManager/transferToAnotherHospital/${item.id}/"
			data-link-template="./hospitalManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.hospital}">
			<a href='./hospitalManager/view/${item.hospital.id}/'>${item.hospital.displayName}</a>
			</c:if>
			<c:if test="${empty  item.hospital}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateExpenseType/${result.id}/${item.id}/'><a title='${item.description}'>${fn:substring(item.description,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'updateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='updateTime' storedCellValue='${item.updateTime}' prefix='${ownerBeanName}Manager/updateExpenseType/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.updateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeExpenseType/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyExpenseTypeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


