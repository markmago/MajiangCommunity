package life.majiang.community.dto;

import lombok.Data;

/*
@author mark
@time 2019/9/18
*/
@Data
public class GithubUser {
    private  String login;
    private  Integer id;
    private  String bio;
    private  String avatar_url;
}
