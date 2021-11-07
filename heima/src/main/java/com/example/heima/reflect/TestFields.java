package com.example.heima.reflect;

import java.lang.reflect.Field;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/3/31
 */
public class TestFields {
    public static void main(String[] args) throws Exception {

        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();

        for (Field field : fields) {
            System.out.println(field);

        }

        System.out.println("----------------");


        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("----------------");

        Person person = personClass.newInstance();
        person.name = "Sam";
        System.out.println(person);

        Field name = personClass.getDeclaredField("name");
        name.set(person, "Jone");
        System.out.println(person);

        Field gender = personClass.getDeclaredField("gender");
        gender.set(person, "男");
        System.out.println(person);

        Field address = personClass.getDeclaredField("address");
        address.setAccessible(true);
        address.set(person, "东风路47号");
        System.out.println(person);


        System.out.println(Person.type);
        Field type = personClass.getDeclaredField("type");
        type.set(type, "人类");
        System.out.println(Person.type);


        Field subType = personClass.getDeclaredField("subType");
        subType.setAccessible(true);
        System.out.println(subType.get(person));
        subType.set(type, "黄种人");
        System.out.println(subType.get(person));

        System.out.println(subType.get(Person.class));
        subType.set(type, "黄种人");
        System.out.println(subType.get(Person.class));





    }

}
