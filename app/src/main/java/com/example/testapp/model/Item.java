
package com.example.testapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("badge_counts")
    @Expose
    private BadgeCounts badgeCounts;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("is_employee")
    @Expose
    private Boolean isEmployee;
    @SerializedName("last_modified_date")
    @Expose
    private Integer lastModifiedDate;
    @SerializedName("last_access_date")
    @Expose
    private Integer lastAccessDate;
    @SerializedName("reputation_change_year")
    @Expose
    private Integer reputationChangeYear;
    @SerializedName("reputation_change_quarter")
    @Expose
    private Integer reputationChangeQuarter;
    @SerializedName("reputation_change_month")
    @Expose
    private Integer reputationChangeMonth;
    @SerializedName("reputation_change_week")
    @Expose
    private Integer reputationChangeWeek;
    @SerializedName("reputation_change_day")
    @Expose
    private Integer reputationChangeDay;
    @SerializedName("reputation")
    @Expose
    private Integer reputation;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("accept_rate")
    @Expose
    private Integer acceptRate;

    protected Item(Parcel in) {
        if (in.readByte() == 0) {
            accountId = null;
        } else {
            accountId = in.readInt();
        }
        byte tmpIsEmployee = in.readByte();
        isEmployee = tmpIsEmployee == 0 ? null : tmpIsEmployee == 1;
        if (in.readByte() == 0) {
            lastModifiedDate = null;
        } else {
            lastModifiedDate = in.readInt();
        }
        if (in.readByte() == 0) {
            lastAccessDate = null;
        } else {
            lastAccessDate = in.readInt();
        }
        if (in.readByte() == 0) {
            reputationChangeYear = null;
        } else {
            reputationChangeYear = in.readInt();
        }
        if (in.readByte() == 0) {
            reputationChangeQuarter = null;
        } else {
            reputationChangeQuarter = in.readInt();
        }
        if (in.readByte() == 0) {
            reputationChangeMonth = null;
        } else {
            reputationChangeMonth = in.readInt();
        }
        if (in.readByte() == 0) {
            reputationChangeWeek = null;
        } else {
            reputationChangeWeek = in.readInt();
        }
        if (in.readByte() == 0) {
            reputationChangeDay = null;
        } else {
            reputationChangeDay = in.readInt();
        }
        if (in.readByte() == 0) {
            reputation = null;
        } else {
            reputation = in.readInt();
        }
        if (in.readByte() == 0) {
            creationDate = null;
        } else {
            creationDate = in.readInt();
        }
        userType = in.readString();
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        location = in.readString();
        websiteUrl = in.readString();
        link = in.readString();
        profileImage = in.readString();
        displayName = in.readString();
        if (in.readByte() == 0) {
            acceptRate = null;
        } else {
            acceptRate = in.readInt();
        }
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public BadgeCounts getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCounts badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Integer getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Integer lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Integer getReputationChangeYear() {
        return reputationChangeYear;
    }

    public void setReputationChangeYear(Integer reputationChangeYear) {
        this.reputationChangeYear = reputationChangeYear;
    }

    public Integer getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public void setReputationChangeQuarter(Integer reputationChangeQuarter) {
        this.reputationChangeQuarter = reputationChangeQuarter;
    }

    public Integer getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public void setReputationChangeMonth(Integer reputationChangeMonth) {
        this.reputationChangeMonth = reputationChangeMonth;
    }

    public Integer getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public void setReputationChangeWeek(Integer reputationChangeWeek) {
        this.reputationChangeWeek = reputationChangeWeek;
    }

    public Integer getReputationChangeDay() {
        return reputationChangeDay;
    }

    public void setReputationChangeDay(Integer reputationChangeDay) {
        this.reputationChangeDay = reputationChangeDay;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(Integer acceptRate) {
        this.acceptRate = acceptRate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (accountId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(accountId);
        }
        dest.writeByte((byte) (isEmployee == null ? 0 : isEmployee ? 1 : 2));
        if (lastModifiedDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lastModifiedDate);
        }
        if (lastAccessDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lastAccessDate);
        }
        if (reputationChangeYear == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputationChangeYear);
        }
        if (reputationChangeQuarter == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputationChangeQuarter);
        }
        if (reputationChangeMonth == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputationChangeMonth);
        }
        if (reputationChangeWeek == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputationChangeWeek);
        }
        if (reputationChangeDay == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputationChangeDay);
        }
        if (reputation == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(reputation);
        }
        if (creationDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(creationDate);
        }
        dest.writeString(userType);
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        dest.writeString(location);
        dest.writeString(websiteUrl);
        dest.writeString(link);
        dest.writeString(profileImage);
        dest.writeString(displayName);
        if (acceptRate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(acceptRate);
        }
    }
}
