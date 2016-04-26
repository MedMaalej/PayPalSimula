package model;

/**
 * Created by root on 6/16/15.
 */
public class User {
    int idUser;
    String userName;
    String userMail;

    //Contructor 1
    public User(){};

    //Constrcutor 2
    public User(String userName, String userMail) {
        this.userName = userName;
        this.userMail = userMail;
    }

    //Constructor 3
    public User(int idUser, String userName, String userMail) {
        this.idUser = idUser;
        this.userName = userName;
        this.userMail = userMail;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userMail='" + userMail + '\'' +
                '}';
    }
}
