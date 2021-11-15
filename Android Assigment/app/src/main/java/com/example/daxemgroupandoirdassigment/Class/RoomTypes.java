package com.example.daxemgroupandoirdassigment.Class;

//Class loại phòng nghỉ
public class RoomTypes {
    private String RoomTypeId;
    private String RoomTypeName;

    public RoomTypes() {
    }

    public RoomTypes(String roomTypeId, String roomTypeName) {
        RoomTypeId = roomTypeId;
        RoomTypeName = roomTypeName;
    }

    public String getRoomTypeId() {
        return RoomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        RoomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        RoomTypeName = roomTypeName;
    }
}
