package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;

/*
@author mark
@time 2019/9/22
*/
@Mapper
public interface UserMapper {
   @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url)" +
           " values (#{accountId},#{login},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
   void insert(User user);

  @Select("select id, account_id ,name login,token, gmt_create  ,gmt_modified ,avatar_url from user where token=#{token}")
   User findUserbyToken(@Param("token") String token);

    @Select("select id, account_id ,name login,token, gmt_create  gmtCreate ,gmt_modified   ,avatar_url  from user where id=#{id}")
    User findUserById(@Param("id")  Long id);

    @Select("select * from user where account_id=#{accountId}")
    User findUserByAccountId(@Param("accountId") String accountId);
    @Update("update user set name=#{login} , gmt_modified=#{gmtModified},avatar_url=#{avatarUrl},token=#{token} where account_id=#{accountId}")
    void update(User user);
}
