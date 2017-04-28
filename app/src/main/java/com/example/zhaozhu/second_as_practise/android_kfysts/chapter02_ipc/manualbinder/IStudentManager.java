package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.manualbinder;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import java.util.List;

/**
 * Created by zhaozhu on 17/4/26.
 */

public interface IStudentManager extends IInterface {

    static final String DESCRIPTOR = "com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.manualbinder.IStudentManager";

    static final int TRANSACTION_getBookList = IBinder.FIRST_CALL_TRANSACTION + 0;
    static final int TRANSACTION_addBook = IBinder.FIRST_CALL_TRANSACTION + 1;

    public List<Student> getStudentList() throws RemoteException;

    public void addStudent(Student student) throws RemoteException;
}
