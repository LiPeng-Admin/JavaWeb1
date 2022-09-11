<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--    静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
</head>
<script type="text/javascript">
    $(function () {
        $("a.deleteItem").click(function () {
            return confirm("确认要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？")
        })

        $("#clearCart").click(function () {
            return confirm("确认要清空购物车吗？")
        })
        //失去内容发生变更的事件：onchange
        $(".updateCount").change(function () {
            //获取商品名称
            const name = $(this).parent().parent().find("td:first").text();
            const id = $(this).attr("bookId");
            //获取商品数量
            const count = this.value;

            if (confirm("确认修改商品【" + name + "】数量为" + count + "吗？")) {
                //发起请求，给服务器保存修改
                location.href = "http://localhost:8080/bookproject/cartServlet?action=updateCount&count="+count+"&id="+id;
            } else {
                //取消时，商品数量恢复为原数量
                this.value = this.defaultValue;
            }

        })
    })
</script>
<body>


<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%--        如果购物车为空--%>
        <c:if test="${empty sessionScope.cart.items}">
            <td colspan="5"><a href="index.jsp">亲，当前购物车为空!</a></td>

        </c:if>
        <%--        如果购物车不为空--%>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" style="width: 80px;"
                               bookId="${entry.value.id}"
                               type="text" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>

            </c:forEach>
        </c:if>


    </table>
    <%--    如果购物车非空--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>

    </c:if>


</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>