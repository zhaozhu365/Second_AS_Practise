package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaozhu on 17/4/25.
 */

public class Car implements Parcelable {

    public String name;
    public String place;

    public Car friend;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(place);
        dest.writeParcelable(friend, flags);
    }

    protected Car(Parcel in) {
        name = in.readString();
        place = in.readString();
        friend = in.readParcelable(Car.class.getClassLoader());
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

}
