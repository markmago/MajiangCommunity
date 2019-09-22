package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/*
@author mark
@time 2019/9/22
*/
@Mapper
public interface UserMapper {
   @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified)" +
           " values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
   void insert(User user);
}
