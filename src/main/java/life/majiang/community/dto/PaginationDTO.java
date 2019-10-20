package life.majiang.community.dto;

import life.majiang.community.model.Question;
import lombok.Data;
import org.h2.store.Page;

import java.util.ArrayList;
import java.util.List;

/*
@author mark
@time 2019/10/13
*/
@Data
public class PaginationDTO {
    private List<QuestionDto> questionList;
    private Integer page;
    private List<Integer> pages=new ArrayList<>();
    private boolean showPrevious;
    private boolean showEndPage;
    private boolean showNext;
    private boolean showFirstPage;
    private  Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
       this.totalPage=totalPage;
        this.page=page;
        pages.add(page);
        for(Integer i=1;i<=3;i++)
        {
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }


        //是否展示上一页
        if(page==1){
            showPrevious=false;
        }else {
            showPrevious=true;
        }
        //是否展示下一页
        if(page==totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else{
            showFirstPage=true;
        }

        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else{
            showEndPage=true;
        }

    }
}
