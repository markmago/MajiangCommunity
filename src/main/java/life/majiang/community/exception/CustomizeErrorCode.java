package life.majiang.community.exception;


/*
@author mark
@time 2019/11/30
*/
public enum CustomizeErrorCode  implements  ICustomizeErrorCode{
   QUESTION_NOT_FOUND("你找的问题不存在,要不换个试试??") ;
    private String message;

    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
