package life.majiang.community.Controller;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
@author mark
@time 2019/9/9
*/
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String Index(HttpServletRequest httpServletRequest) {
        //查询cookie,根据token查询用户.
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    //查询user表
                    String token = cookie.getValue();
                    User user = userMapper.findUserbyToken(token);
                    if (user != null) {
                        httpServletRequest.getSession().setAttribute("user", user);
                        break;
                    }
                } else {

                }
            }
        }

        return "index";
    }
}
