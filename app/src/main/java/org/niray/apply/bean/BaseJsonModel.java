package org.niray.apply.bean;

/**
 * Created by Chen Zhining
 * Date : 16/10/17.
 */

public class BaseJsonModel<T> {

    private int status;
    private String messsage;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
