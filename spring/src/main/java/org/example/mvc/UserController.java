package org.example.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> list = new ArrayList<>();
        User usera = new User("tom", 10);
        User userb = new User("jerry", 20);
        list.add(userb);
        list.add(usera);
//        int a = 1 /0;
        return new ModelAndView("userlist", "users", list);
    }
}
