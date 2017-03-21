// IBookManager.aidl
package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl;

// Declare any non-default types here with import statements

import com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl.Book;
interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}

//
//interface IBookManager {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
//
//
//}



