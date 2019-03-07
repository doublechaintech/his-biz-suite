
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty profile}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Profile">${userContext.localeMap['profile']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./profileManager/view/${profile.id}/"> ${profile.id}</a></li>
<li><span>${userContext.localeMap['profile.name']}</span> ${profile.name}</li>
<li><span>${userContext.localeMap['profile.gender']}</span> ${profile.gender}</li>
<li><span>${userContext.localeMap['profile.age']}</span> ${profile.age}</li>
<li><span>${userContext.localeMap['profile.identification_number']}</span> ${profile.identificationNumber}</li>
<li><span>${userContext.localeMap['profile.mobile']}</span> ${profile.maskedMobile}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




