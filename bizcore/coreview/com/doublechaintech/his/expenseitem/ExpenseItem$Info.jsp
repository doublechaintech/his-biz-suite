
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty expenseItem}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ExpenseItem">${userContext.localeMap['expense_item']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./expenseItemManager/view/${expenseItem.id}/"> ${expenseItem.id}</a></li>
<li><span>${userContext.localeMap['expense_item.name']}</span> ${expenseItem.name}</li>
<li><span>${userContext.localeMap['expense_item.price']}</span> <fmt:formatNumber type="currency"  value="${expenseItem.price}" /></li>
<li><span>${userContext.localeMap['expense_item.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${expenseItem.updateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




