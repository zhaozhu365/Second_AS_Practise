// ICarManager.aidl
package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl;

// Declare any non-default types here with import statements
import com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl.Car;
interface ICarManager {

    List<Car> getCarList();
    void addCar(in Car car);

}
