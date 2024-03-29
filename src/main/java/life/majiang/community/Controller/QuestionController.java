package life.majiang.community.Controller;

import life.majiang.community.dto.QuestionDto;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
@author mark
@time 2019/10/21
*/
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model) {
        QuestionDto questionDto = questionService.getById(id);
        model.addAttribute("question", questionDto);
        return "question";
    }


}
