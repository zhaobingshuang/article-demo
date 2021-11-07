package org.example.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public UserServiceImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(`name`, age, sex) VALUES(?, ?, ?)", user.getName(), user.getAge(), user.getSex());
//        throw new RuntimeException("ex");
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = new User();
        user.setAge(10);
        user.setName("tom");
        user.setSex("male");
        UserService userService = (UserService) act.getBean("userService");
        userService.save(user);
    }
}
