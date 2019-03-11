
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty doctorSchedule}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A DoctorSchedule" style="color: green">${userContext.localeMap['doctor_schedule']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['doctor_schedule.id']}</span> ${doctorSchedule.id}</li>
<li><span>${userContext.localeMap['doctor_schedule.name']}</span> ${doctorSchedule.name}</li>
<li><span>${userContext.localeMap['doctor_schedule.schedule_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${doctorSchedule.scheduleDate}" /></li>
<li><span>${userContext.localeMap['doctor_schedule.period']}</span> ${doctorSchedule.period}</li>
<li><span>${userContext.localeMap['doctor_schedule.available']}</span> ${doctorSchedule.available}</li>
<li><span>${userContext.localeMap['doctor_schedule.price']}</span> <fmt:formatNumber type="currency"  value="${doctorSchedule.price}" /></li>

	
	</ul>
</div>



</c:if>


