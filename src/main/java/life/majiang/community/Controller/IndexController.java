package life.majiang.community.Controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDto;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
@author mark
@time 2019/9/9
*/
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String Index(HttpServletRequest httpServletRequest, Model model,
                        @RequestParam(name="page", defaultValue="1") Integer page,
                        @RequestParam(name = "size" ,defaultValue = "5") Integer size) {
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

        PaginationDTO pagination= questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
