package me.pengtao.rule;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author CPPAlien
 */
public class StudentInfo implements Parcelable {
    public static final Creator<StudentInfo> CREATOR = new Creator<StudentInfo>() {
        @Override
        public StudentInfo createFromParcel(Parcel in) {
            return new StudentInfo(in);
        }

        @Override
        public StudentInfo[] newArray(int size) {
            return new StudentInfo[size];
        }
    };
    private String mPackageId;
    private String mAppName;
    private String mSex;

    public StudentInfo() {

    }

    private StudentInfo(Parcel in) {
        readFromParcel(in);
    }

    public String getPackageId() {
        return mPackageId;
    }

    public StudentInfo setPackageId(final String packageId) {
        mPackageId = packageId;
        return this;
    }

    public String getSex() {
        return mSex;
    }

    public StudentInfo setSex(final String sex) {
        mSex = sex;
        return this;
    }

    public String getAppName() {
        return mAppName;
    }

    public StudentInfo setAppName(final String appName) {
        mAppName = appName;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mSex);
        dest.writeString(mAppName);
        dest.writeString(mPackageId);
    }

    public void readFromParcel(final Parcel in) {
        mSex = in.readString();
        mAppName = in.readString();
        mPackageId = in.readString();
    }
}
