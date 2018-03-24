package com.example.huanpet.model.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 本丶小丝 on 2018/3/23.
 */
@Entity
public class UserDao {
    @Id(autoincrement = true)
    private Long id;
    private String username;
    private String phone;
    private String usernumber;
    @Generated(hash = 945400735)
    public UserDao(Long id, String username, String phone, String usernumber) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.usernumber = usernumber;
    }
    @Generated(hash = 917059161)
    public UserDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsernumber() {
        return this.usernumber;
    }
    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

   
}
