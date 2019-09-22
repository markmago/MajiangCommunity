package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
@author mark
@time 2019/9/22
*/
@Mapper
public interface UserMapper {
   @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified)" +
           " values (#{accountId},#{login},#{token},#{gmtCreate},#{gmtModified})")
   void insert(User user);

  @Select("select id, account_id accountId,name login,token, gmt_create  gmtCreate ,gmt_modified gmtModified from user where token=#{token}")
   User findUserbyToken(@Param("token") String token);
}
