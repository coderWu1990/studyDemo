/**
 *
 */
package com.wd.demo.eventbus;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-16 下午4:57:52 <br/>
 *
 */
public class LoginSeccessEvent {
    String msg;
    String username;
    String password;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

}
