package life.majiang.community.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
@author mark
@time 2019/9/9
*/
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name",defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
