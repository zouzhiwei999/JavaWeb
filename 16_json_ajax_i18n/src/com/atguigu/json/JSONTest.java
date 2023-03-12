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
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/3 0:34
 */

public class JSONTest {
    @Test
    public void test01() {
        Person person = new Person(1, "尼玛");

        //javabean变为json字符串
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);

        //json字符串变为javabean
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }

    //list集合与json装换
    @Test
    public void test2(){
        List<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(1, "傻逼"));
        personArrayList.add(new Person(2, "几块"));
        System.out.println(personArrayList);

        //list -> json
        Gson gson = new Gson();
        String s = gson.toJson(personArrayList);
        System.out.println(s);

        //json -> list
        Object o = gson.fromJson(s, new PersonListType().getType());
        System.out.println(o);
    }

    //map集合与json装换
    @Test
    public void test03(){
        Map<String, Person> personHashMap = new HashMap<>();

        personHashMap.put("1", new Person(1,"阿西吧"));
        personHashMap.put("2", new Person(1,"吔屎啦"));

        System.out.println(personHashMap);

        //map -> json
        Gson gson = new Gson();
        String s = gson.toJson(personHashMap);
        System.out.println(s);

        //json -> map
        Object o = gson.fromJson(s, new TypeToken<Map<String, Person>>() {}.getType());
        System.out.println(o);
    }
}
