package com.example.daxemgroupandoirdassigment.Class;

//Class địa điểm du lịch
public class TouristDestinations {
    private String TouristID;
    private String TouristName;
    private String Province; //Tỉnh
    private String Describe; // Mô tả, thông tin
    private String StarVote; //Đánh giá sao
    private String Comment; //Bình Luận
    private String ImageURL;

    public TouristDestinations() {
    }

    public TouristDestinations(String touristID, String touristName, String province, String describe, String starVote, String comment, String imageURL) {
        TouristID = touristID;
        TouristName = touristName;
        Province = province;
        Describe = describe;
        StarVote = starVote;
        Comment = comment;
        ImageURL = imageURL;
    }

    public String getTouristID() {
        return TouristID;
    }

    public void setTouristID(String touristID) {
        TouristID = touristID;
    }

    public String getTouristName() {
        return TouristName;
    }

    public void setTouristName(String touristName) {
        TouristName = touristName;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    public String getStarVote() {
        return StarVote;
    }

    public void setStarVote(String starVote) {
        StarVote = starVote;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
