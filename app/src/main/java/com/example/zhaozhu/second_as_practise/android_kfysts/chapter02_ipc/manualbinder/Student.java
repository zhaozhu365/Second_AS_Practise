package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.manualbinder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaozhu on 17/4/26.
 */

public class Student implements Parcelable {

    public int id;
    public String name;

    public Student friend;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(friend, flags);
    }

    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        friend = in.readParcelable(Student.class.getClassLoader());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

}
