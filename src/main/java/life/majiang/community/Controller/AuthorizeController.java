package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/callback")
    public  String callBack(@RequestParam(name = "code") String code,
                             @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("3322ef1f30c98e6a935e");
        accessTokenDto.setClient_secret("965bee4e8b2d3718871c59cc5ef1231865137d6e");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8087/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        System.out.println(githubUser);
        return "index";
    }
}
