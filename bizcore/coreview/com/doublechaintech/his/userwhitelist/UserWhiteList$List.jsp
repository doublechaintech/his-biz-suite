<%@ page import='java.util.*,com.doublechaintech.his.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty userWhiteListList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user_white_list']}! 
		 <a href="./${ownerBeanName}Manager/addUserWhiteList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty userWhiteListList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("userWhiteListList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['user_white_list']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUserWhiteList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'userWhiteListList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${userWhiteListListName};${userWhiteListListName}CurrentPage=${page.pageNumber};${userWhiteListListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userWhiteListListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user_white_list.id']}</th>
</c:if>
<c:if test="${param.referName ne 'userIdentity'}">
	<th>${userContext.localeMap['user_white_list.user_identity']}</th>
</c:if>
<c:if test="${param.referName ne 'userSpecialFunctions'}">
	<th>${userContext.localeMap['user_white_list.user_special_functions']}</th>
</c:if>
<c:if test="${param.referName ne 'domain'}">
	<th>${userContext.localeMap['user_white_list.domain']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${userWhiteListList}">
				<tr currentVersion='${item.version}' id="userWhiteList-${item.id}" ><td><a class="link-action-removed" href="./userWhiteListManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'userIdentity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userIdentity' storedCellValue='${item.userIdentity}' prefix='${ownerBeanName}Manager/updateUserWhiteList/${result.id}/${item.id}/'>${item.userIdentity}</td>
</c:if><c:if test="${param.referName ne 'userSpecialFunctions'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userSpecialFunctions' storedCellValue='${item.userSpecialFunctions}' prefix='${ownerBeanName}Manager/updateUserWhiteList/${result.id}/${item.id}/'>${item.userSpecialFunctions}</td>
</c:if><c:if test="${param.referName ne 'domain'}">
	<td class="select_candidate_td"
			data-candidate-method="./userWhiteListManager/requestCandidateDomain/${ownerBeanName}/${item.id}/"
			data-switch-method="./userWhiteListManager/transferToAnotherDomain/${item.id}/"
			data-link-template="./userDomainManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.domain}">
			<a href='./userDomainManager/view/${item.domain.id}/'>${item.domain.displayName}</a>
			</c:if>
			<c:if test="${empty  item.domain}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeUserWhiteList/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserWhiteListFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


