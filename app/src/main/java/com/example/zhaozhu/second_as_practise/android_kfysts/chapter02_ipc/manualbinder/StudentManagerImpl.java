package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.manualbinder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.List;

/**
 * Created by zhaozhu on 17/4/26.
 */

public class StudentManagerImpl extends Binder implements IStudentManager {

    public StudentManagerImpl() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IStudentManager asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (iin != null && iin instanceof IStudentManager) {
            return (IStudentManager) iin;
        }
        return new StudentManagerImpl.Proxy(obj);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case TRANSACTION_getBookList: {
                data.enforceInterface(DESCRIPTOR);
                List<Student> result = this.getStudentList();
                reply.writeNoException();
                reply.writeTypedList(result);
                return true;
            }
            case TRANSACTION_addBook: {
                data.enforceInterface(DESCRIPTOR);
                Student arg0;
                if (0 != data.readInt()) {
                    arg0 = Student.CREATOR.createFromParcel(data);
                } else {
                    arg0 = null;
                }
                this.addStudent(arg0);
                reply.writeNoException();
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }

    @Override
    public List<Student> getStudentList() throws RemoteException {
        //TODO 待实现
        return null;
    }

    @Override
    public void addStudent(Student student) throws RemoteException {
        //TODO 待实现
    }

    private static class Proxy implements IStudentManager {

        private IBinder mRemote;

        public Proxy(IBinder remote) {
            this.mRemote = remote;
        }

        @Override
        public IBinder asBinder() {
            return this.mRemote;
        }

        public String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }

        @Override
        public List<Student> getStudentList() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            List<Student> result;

            try {
                data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_getBookList, data, reply, 0);
                reply.readException();
                result = reply.createTypedArrayList(Student.CREATOR);
            } finally {
                reply.recycle();
                data.recycle();
            }
            return result;
        }

        @Override
        public void addStudent(Student student) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();

            try {
                data.writeInterfaceToken(DESCRIPTOR);
                if (student != null) {
                    data.writeInt(1);
                    student.writeToParcel(data, 0);
                } else {
                    data.writeInt(0);
                }
                mRemote.transact(TRANSACTION_addBook, data, reply, 0);
                reply.readException();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }
    }

}
