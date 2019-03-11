<%@ page import='java.util.*,com.panfeng.his.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty doctorScheduleList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['doctor_schedule']}! 
		 <a href="./${ownerBeanName}Manager/addDoctorSchedule/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty doctorScheduleList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("doctorScheduleList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['doctor_schedule']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addDoctorSchedule/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'doctorScheduleList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${doctorScheduleListName};${doctorScheduleListName}CurrentPage=${page.pageNumber};${doctorScheduleListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='doctorScheduleListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['doctor_schedule.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['doctor_schedule.name']}</th>
</c:if>
<c:if test="${param.referName ne 'scheduleDate'}">
	<th>${userContext.localeMap['doctor_schedule.schedule_date']}</th>
</c:if>
<c:if test="${param.referName ne 'period'}">
	<th>${userContext.localeMap['doctor_schedule.period']}</th>
</c:if>
<c:if test="${param.referName ne 'doctor'}">
	<th>${userContext.localeMap['doctor_schedule.doctor']}</th>
</c:if>
<c:if test="${param.referName ne 'available'}">
	<th>${userContext.localeMap['doctor_schedule.available']}</th>
</c:if>
<c:if test="${param.referName ne 'price'}">
	<th>${userContext.localeMap['doctor_schedule.price']}</th>
</c:if>
<c:if test="${param.referName ne 'expenseType'}">
	<th>${userContext.localeMap['doctor_schedule.expense_type']}</th>
</c:if>
<c:if test="${param.referName ne 'department'}">
	<th>${userContext.localeMap['doctor_schedule.department']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${doctorScheduleList}">
				<tr currentVersion='${item.version}' id="doctorSchedule-${item.id}" ><td><a class="link-action-removed" href="./doctorScheduleManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateDoctorSchedule/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'scheduleDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='scheduleDate' storedCellValue='${item.scheduleDate}' prefix='${ownerBeanName}Manager/updateDoctorSchedule/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.scheduleDate}" /></td>
</c:if><c:if test="${param.referName ne 'period'}">	<td contenteditable='true' class='edit-value'  propertyToChange='period' storedCellValue='${item.period}' prefix='${ownerBeanName}Manager/updateDoctorSchedule/${result.id}/${item.id}/'>${item.period}</td>
</c:if><c:if test="${param.referName ne 'doctor'}">
	<td class="select_candidate_td"
			data-candidate-method="./doctorScheduleManager/requestCandidateDoctor/${ownerBeanName}/${item.id}/"
			data-switch-method="./doctorScheduleManager/transferToAnotherDoctor/${item.id}/"
			data-link-template="./doctorManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.doctor}">
			<a href='./doctorManager/view/${item.doctor.id}/'>${item.doctor.displayName}</a>
			</c:if>
			<c:if test="${empty  item.doctor}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'available'}">	<td contenteditable='true' class='edit-value'  propertyToChange='available' storedCellValue='${item.available}' prefix='${ownerBeanName}Manager/updateDoctorSchedule/${result.id}/${item.id}/'>${item.available}</td>
</c:if><c:if test="${param.referName ne 'price'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='price' storedCellValue='${item.price}' prefix='${ownerBeanName}Manager/updateDoctorSchedule/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.price}" /></td>
</c:if><c:if test="${param.referName ne 'expenseType'}">
	<td class="select_candidate_td"
			data-candidate-method="./doctorScheduleManager/requestCandidateExpenseType/${ownerBeanName}/${item.id}/"
			data-switch-method="./doctorScheduleManager/transferToAnotherExpenseType/${item.id}/"
			data-link-template="./expenseTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.expenseType}">
			<a href='./expenseTypeManager/view/${item.expenseType.id}/'>${item.expenseType.displayName}</a>
			</c:if>
			<c:if test="${empty  item.expenseType}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'department'}">
	<td class="select_candidate_td"
			data-candidate-method="./doctorScheduleManager/requestCandidateDepartment/${ownerBeanName}/${item.id}/"
			data-switch-method="./doctorScheduleManager/transferToAnotherDepartment/${item.id}/"
			data-link-template="./departmentManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.department}">
			<a href='./departmentManager/view/${item.department.id}/'>${item.department.displayName}</a>
			</c:if>
			<c:if test="${empty  item.department}">
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

				<a href='#${ownerBeanName}Manager/removeDoctorSchedule/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyDoctorScheduleFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


