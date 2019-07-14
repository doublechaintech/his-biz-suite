
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty doctorSchedule}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A DoctorSchedule">${userContext.localeMap['doctor_schedule']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./doctorScheduleManager/view/${doctorSchedule.id}/"> ${doctorSchedule.id}</a></li>
<li><span>${userContext.localeMap['doctor_schedule.name']}</span> ${doctorSchedule.name}</li>
<li><span>${userContext.localeMap['doctor_schedule.schedule_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${doctorSchedule.scheduleDate}" /></li>
<li><span>${userContext.localeMap['doctor_schedule.available']}</span> ${doctorSchedule.available}</li>
<li><span>${userContext.localeMap['doctor_schedule.price']}</span> <fmt:formatNumber type="currency"  value="${doctorSchedule.price}" /></li>
<li><span>${userContext.localeMap['doctor_schedule.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${doctorSchedule.createTime}" /></li>
<li><span>${userContext.localeMap['doctor_schedule.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${doctorSchedule.updateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




