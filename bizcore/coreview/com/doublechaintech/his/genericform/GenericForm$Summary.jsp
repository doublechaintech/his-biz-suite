
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty genericForm}">
<div class="col-xs-12 col-md-12 section">
	<b title="A GenericForm"> 
		${userContext.localeMap['generic_form']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		
		
	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'main' eq action.actionGroup}">
		
		
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		
		
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['generic_form.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['generic_form.title']}</span>
<span >${result.title}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['generic_form.description']}</span>
<span >${result.description}</span>
</div>

	</div>
	
</div>

</c:if>




