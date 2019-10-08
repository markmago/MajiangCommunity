package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDto;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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

    @Autowired
    public UserMapper userMapper;


    @GetMapping("/callback")
    public  String callBack(@RequestParam(name = "code") String code,
                            @RequestParam(name = "state") String state,
                            HttpServletResponse httpServletResponse){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        if (githubUser!=null){ //获取用户成功
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setLogin(githubUser.getLogin());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatar_url());
            userMapper.insert(user);
            httpServletResponse.addCookie(new Cookie("token",token));
           // httpServletRequest.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else   {
            return "redirect:/";
        }
        //System.out.println(githubUser);
        //        //  return "index";
    }
}
