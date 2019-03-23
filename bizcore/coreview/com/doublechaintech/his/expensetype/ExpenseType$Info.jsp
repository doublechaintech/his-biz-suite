
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty expenseType}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ExpenseType">${userContext.localeMap['expense_type']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./expenseTypeManager/view/${expenseType.id}/"> ${expenseType.id}</a></li>
<li><span>${userContext.localeMap['expense_type.name']}</span> ${expenseType.name}</li>
<li><span>${userContext.localeMap['expense_type.helper_chars']}</span> ${expenseType.helperChars}</li>
<li><span>${userContext.localeMap['expense_type.status']}</span> ${expenseType.status}</li>
<li><span>${userContext.localeMap['expense_type.description']}</span> ${expenseType.description}</li>
<li><span>${userContext.localeMap['expense_type.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${expenseType.updateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




