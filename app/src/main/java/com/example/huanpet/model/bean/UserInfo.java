package com.example.huanpet.model.bean;

/**
 * Created by Administrator on 2018/3/2.
 */

public class UserInfo {


    /**
     * status : 1
     * info : 登陆成功
     * msg : {"id":"3","username":"17801190741","password":"25f9e794323b453885f5181f1b624d0b","gender":"男","iconurl":"http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png","name":"卢","balance":"0.00","foregift":"0.00","create_time":"1518159448"}
     */

    private String status;
    private String info;
    private MsgBean msg;

    @Override
    public String toString() {
        return "UserInfo{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", msg=" + msg +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        @Override
        public String toString() {
            return "MsgBean{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", gender='" + gender + '\'' +
                    ", iconurl='" + iconurl + '\'' +
                    ", name='" + name + '\'' +
                    ", balance='" + balance + '\'' +
                    ", foregift='" + foregift + '\'' +
                    ", create_time='" + create_time + '\'' +
                    '}';
        }

        /**
         * id : 3
         * username : 17801190741
         * password : 25f9e794323b453885f5181f1b624d0b
         * gender : 男
         * iconurl : http://baobaoapi.ldlchat.com/Uploads/20180208/5a7c1f8dbd6f5.png
         * name : 卢
         * balance : 0.00
         * foregift : 0.00
         * create_time : 1518159448
         */

        private String id;
        private String username;
        private String password;
        private String gender;
        private String iconurl;
        private String name;
        private String balance;
        private String foregift;
        private String create_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getForegift() {
            return foregift;
        }

        public void setForegift(String foregift) {
            this.foregift = foregift;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
