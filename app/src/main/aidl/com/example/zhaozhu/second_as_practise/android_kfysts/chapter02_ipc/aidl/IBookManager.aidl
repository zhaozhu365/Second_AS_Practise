// IBookManager.aidl
//第二类AIDL文件
//作用是定义方法接口
package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl;

// Declare any non-default types here with import statements
//导入所需要使用的非默认支持数据类型的包
import com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.aidl.Book;
interface IBookManager {
    List<Book> getBookList();

    //传参时除了Java基本类型以及String，CharSequence之外的类型
    //都需要在前面加上定向tag，具体加什么量需而定
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



