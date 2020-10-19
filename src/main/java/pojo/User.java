package pojo;


import java.io.Serializable;

/**
 * 根据tb_user表的字段封装到这类的属性
 * 建议以后编写实体类的时候，要实现一个序列化接口
 * 这是一种开发的标准  可以生成这个序列化的版本号
 */
public class User{
    private Integer ID;
    private String USER_NAME;
    private String USER_PASSWORD;
    private Integer USER_TYPE;
    private Integer USER_STATE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public Integer getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(Integer USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public Integer getUSER_STATE() {
        return USER_STATE;
    }

    public void setUSER_STATE(Integer USER_STATE) {
        this.USER_STATE = USER_STATE;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PASSWORD='" + USER_PASSWORD + '\'' +
                ", USER_TYPE=" + USER_TYPE +
                ", USER_STATE=" + USER_STATE +
                '}';
    }
}
