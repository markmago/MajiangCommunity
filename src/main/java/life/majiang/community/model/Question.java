package life.majiang.community.model;

import lombok.Data;

/*
@author mark
@time 2019/10/7
*/
@Data
public class Question {
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


}
