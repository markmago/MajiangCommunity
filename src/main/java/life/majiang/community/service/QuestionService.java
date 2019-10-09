package life.majiang.community.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import life.majiang.community.dto.QuestionDto;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
@author mark
@time 2019/10/9
*/
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    public List<QuestionDto>  list(){
        List<Question> questionList= questionMapper.list();
        List<QuestionDto> questionDtoList=new ArrayList<>();
        for (Question question :questionList){
           User user= userMapper.findUserById(question.getCreator());
           QuestionDto questionDto=new QuestionDto();
           BeanUtils.copyProperties(question,questionDto);
           questionDto.setUser(user);
           questionDtoList.add(questionDto);
        }
        return questionDtoList;
    }

}
