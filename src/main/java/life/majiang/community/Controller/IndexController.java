package life.majiang.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@author mark
@time 2019/9/9
*/
@Controller
public class IndexController {
    @GetMapping("/")
    public String Index() {
        return "index";
    }
}
