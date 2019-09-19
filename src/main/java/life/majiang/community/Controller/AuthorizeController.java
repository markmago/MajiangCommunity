package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
@author mark
@time 2019/9/18
*/
@Controller
public class AuthorizeController {
    @Autowired
    public GithubProvider githubProvider;
    @Value("${github.client.id}") //定义在application.properties文件内
    private  String clientId;
    @Value("${github.client.secret}")
    private  String clientSecret;
    @Value("${github.redirect.uri}")
    private  String redirectUri;


    @GetMapping("/callback")
    public  String callBack(@RequestParam(name = "code") String code,
                             @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        System.out.println(githubUser);
        return "index";
    }
}
