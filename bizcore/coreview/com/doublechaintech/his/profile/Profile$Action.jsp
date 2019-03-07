
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty profile}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Profile" style="color: green">${userContext.localeMap['profile']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['profile.id']}</span> ${profile.id}</li>
<li><span>${userContext.localeMap['profile.name']}</span> ${profile.name}</li>
<li><span>${userContext.localeMap['profile.gender']}</span> ${profile.gender}</li>
<li><span>${userContext.localeMap['profile.age']}</span> ${profile.age}</li>
<li><span>${userContext.localeMap['profile.identification_number']}</span> ${profile.identificationNumber}</li>
<li><span>${userContext.localeMap['profile.mobile']}</span> ${profile.maskedMobile}</li>

	
	</ul>
</div>



</c:if>


