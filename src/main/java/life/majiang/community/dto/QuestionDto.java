package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/*
@author mark
@time 2019/10/9
*/
@Data
public class QuestionDto {
    private  long id;
    private String title;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String description;
    private User user;
}
