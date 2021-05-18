package com.example.home_page;

public class DynamicRvModel {

    private int room_pic;
    private String room, devices;
    int pos;

    public DynamicRvModel(int room_pic, int pos, String room, String devices) {
        this.room_pic = room_pic;
        this.room = room;
        this.devices = devices;
        this.pos = pos;
    }

    public int getRoom_pic() {
        return room_pic;
    }

    public String getRoom() {
        return room;
    }

    public String getDevices() {
        return devices;
    }

    public int getPos(){ return pos;}
}
