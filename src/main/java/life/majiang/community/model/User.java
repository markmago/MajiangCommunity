package life.majiang.community.model;

import lombok.Data;

/*
@author mark
@time 2019/9/22
*/
@Data
public class User {
    private long id;
    private  String accountId;
    private String login;
    private  String token;
    private long gmtCreate;
    private long gmtModified;
    private  String avatarUrl;
}
