package com.ccsoft.yunqudao.ui.house;

public class EvenBusSendPosition {
    private String message;
    private String tetle;
    private int position;


    public EvenBusSendPosition(String message) {
        this.message = message;

    }
    public EvenBusSendPosition(int position) {
        this.position = position;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTetle(String tetle) {
        this.tetle = tetle;
    }

    public String getTetle() {

        return tetle;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
