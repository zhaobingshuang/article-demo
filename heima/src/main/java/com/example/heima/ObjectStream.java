package com.example.heima;

import java.io.*;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/10
 */
public class ObjectStream {
    public static void main(String[] args) throws Exception {
        User user1=new User("yiwangzhibujian",27);
        User user2=new User("laizhezhikezhui",24);

        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);

        oos.writeObject(user1);
        oos.writeObject(user2);
        oos.writeObject(null);

        byte[] data = bos.toByteArray();
        ByteArrayInputStream bis=new ByteArrayInputStream(data);
        ObjectInputStream ois=new ObjectInputStream(bis);

        System.out.println(ois.readObject());
        System.out.println(ois.readObject());
        System.out.println(ois.readObject());
        System.out.println(ois.readObject());
    }
}
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
}