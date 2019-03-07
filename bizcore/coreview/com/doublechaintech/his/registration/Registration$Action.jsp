
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty registration}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Registration" style="color: green">${userContext.localeMap['registration']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['registration.id']}</span> ${registration.id}</li>
<li><span>${userContext.localeMap['registration.title']}</span> ${registration.title}</li>
<li><span>${userContext.localeMap['registration.content']}</span> ${registration.content}</li>
<li><span>${userContext.localeMap['registration.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${registration.updateTime}" /></li>
<li><span>${userContext.localeMap['registration.status']}</span> ${registration.status}</li>

	
	</ul>
</div>



</c:if>


