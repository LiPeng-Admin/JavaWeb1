<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: LP
  Date: 2022/8/14
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("zhangsan");
    person.setPhone(new String[]{"18654119611", "18654119622", "18654119631"});
    ArrayList<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");
    cities.add("杭州");


    person.setCities(cities);
    HashMap<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    person.setMap(map);
    pageContext.setAttribute("person", person);


%>
输出person 对象：${person}<br/>
输出person 对象的name 属性：${person.name}<br/>
输出person 对象的phone属性值：${person.phone[1]}<br/>
输出person 对象的cities 集合中元素值：${person.cities}<br/>
输出person 对象 的map 集合：${person.map}<br/>
输出person 对象 的map 集合中的某一个：${person.map.key1}


</body>
</html>
