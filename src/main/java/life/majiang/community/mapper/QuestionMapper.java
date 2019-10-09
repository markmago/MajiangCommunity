package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
@author mark
@time 2019/10/7
*/
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified," +
            "creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void insert(Question question);
@Select("select * from question")
    List<Question> list();
}
