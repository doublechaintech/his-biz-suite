
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty hospital}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Hospital">${userContext.localeMap['hospital']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./hospitalManager/view/${hospital.id}/"> ${hospital.id}</a></li>
<li><span>${userContext.localeMap['hospital.name']}</span> ${hospital.name}</li>
<li><span>${userContext.localeMap['hospital.address']}</span> ${hospital.address}</li>
<li><span>${userContext.localeMap['hospital.telephone']}</span> ${hospital.telephone}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




