package com.example.zhaozhu.second_as_practise.review_android;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaozhu on 17/4/25.
 */

public class ReviewSParcelable {

    public static class User implements Parcelable {

        public String name;
        public int age;

        public User target;

        public User() {
        }

        public User(String name, int age, User target) {
            this.name = name;
            this.age = age;
            this.target = target;
        }

        protected User(Parcel in) {
            name = in.readString();
            age = in.readInt();
            target = in.readParcelable(User.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeInt(age);
            dest.writeParcelable(target, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };
    }

}
