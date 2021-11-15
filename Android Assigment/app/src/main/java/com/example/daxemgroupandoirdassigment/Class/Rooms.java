package com.example.daxemgroupandoirdassigment.Class;

//Class Phòng nghỉ
public class Rooms {

    private String RoomId;
    private String RoomName;
    private String Price;
    private String Province; //Tỉnh
    private String Address;
    private String ImageUrl;


    public Rooms() {
    }

    public Rooms(String roomId, String roomName, String price, String province, String address, String imageUrl) {
        RoomId = roomId;
        RoomName = roomName;
        Price = price;
        Province = province;
        Address = address;
        ImageUrl = imageUrl;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String roomId) {
        RoomId = roomId;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
