
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty doctorAssignment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A DoctorAssignment" style="color: green">${userContext.localeMap['doctor_assignment']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['doctor_assignment.id']}</span> ${doctorAssignment.id}</li>
<li><span>${userContext.localeMap['doctor_assignment.name']}</span> ${doctorAssignment.name}</li>
<li><span>${userContext.localeMap['doctor_assignment.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${doctorAssignment.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


