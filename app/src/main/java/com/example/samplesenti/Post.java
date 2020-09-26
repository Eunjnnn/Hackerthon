package com.example.samplesenti;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Post {
    String minMoney;
    String maxUser;
    String moreInfo;
    String endDate;
    String meUid;

    Post(){}

    Post(String minMoney, String maxUser, String moreInfo, String endDate, String meUid) {
        this.minMoney = minMoney;
        this.maxUser = maxUser;
        this.moreInfo = moreInfo;
        this.endDate = endDate;
        this.meUid = FirebaseAuth.getInstance().getUid();
    }

    public String getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(String minMoney) {
        this.minMoney = minMoney;
    }

    public String getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(String maxUser) {
        this.maxUser = maxUser;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMeUid() {
        return meUid;
    }

    public void setMeUid(String meUid) {
        this.meUid = meUid;
    }

}
