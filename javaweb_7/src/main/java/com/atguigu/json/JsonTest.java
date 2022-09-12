package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.atguigu.pojo.PersonListType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/12 12:17
 */
public class JsonTest {
    //javaBean 和 json 的互
    @Test
    public void test() {
        Person person = new Person(1, "zhangsan");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以将java对象转为json 字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);//{"id":1,"name":"zhangsan"}
        //fromJson把json字符串转为java 对象

        Person personObj = gson.fromJson(personJsonString, Person.class);
        System.out.println(personObj);

    }

//    List 和 json 的互转

    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "王振国"));
        personList.add(new Person(2, "康师傅"));

        //创建Gson对象实例
        Gson gson = new Gson();
        //把list集合转换为json 字符串
        String perspnListJsonString = gson.toJson(personList);
        System.out.println(perspnListJsonString);
        //fromJson把json字符串转为java 对象
        List<Person> list = gson.fromJson(perspnListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }

    //map 和 json 的互转
    @Test
    public void test3() {
        //创建一个map
        Map<Integer, Person> personMap = new HashMap<Integer, Person>();
        personMap.put(1, new Person(1, "John"));
        personMap.put(2, new Person(2, "Jack"));

        //创建Gson 对象实例
        Gson gson = new Gson();
        //把map集合转换为json 字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);
        //fromJson把json字符串转为java 对象
        Map<Integer, Person> personMapJson = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMapJson);
        Person person = personMapJson.get(1);
        System.out.println(person);

    }
}
