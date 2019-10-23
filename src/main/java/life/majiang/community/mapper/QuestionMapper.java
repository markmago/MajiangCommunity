package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from question limit #{offSet},#{size}")
    List<Question> list(@Param(value = "offSet") Integer offSet, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{userId} limit #{offSet},#{size}")
    List<Question> listById(@Param(value = "userId") long userId, @Param(value = "offSet") Integer offSet, @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countById(@Param(value = "userId") long userId);

    @Select("select * from question where id=#{id}")
    Question getById(@Param(value = "id") Integer id);
}
