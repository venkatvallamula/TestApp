
package com.example.testapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeCounts implements Parcelable {

    @SerializedName("bronze")
    @Expose
    private Integer bronze;
    @SerializedName("silver")
    @Expose
    private Integer silver;
    @SerializedName("gold")
    @Expose
    private Integer gold;

    protected BadgeCounts(Parcel in) {
        if (in.readByte() == 0) {
            bronze = null;
        } else {
            bronze = in.readInt();
        }
        if (in.readByte() == 0) {
            silver = null;
        } else {
            silver = in.readInt();
        }
        if (in.readByte() == 0) {
            gold = null;
        } else {
            gold = in.readInt();
        }
    }

    public static final Creator<BadgeCounts> CREATOR = new Creator<BadgeCounts>() {
        @Override
        public BadgeCounts createFromParcel(Parcel in) {
            return new BadgeCounts(in);
        }

        @Override
        public BadgeCounts[] newArray(int size) {
            return new BadgeCounts[size];
        }
    };

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (bronze == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(bronze);
        }
        if (silver == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(silver);
        }
        if (gold == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(gold);
        }
    }
}
