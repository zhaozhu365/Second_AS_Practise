package com.example.zhaozhu.second_as_practise.android_kfysts.chapter02_ipc.manualbinder;

import android.os.IBinder;

/**
 * Created by zhaozhu on 17/4/26.
 */

public class BinderDeath {

    IStudentManager mStudentManager = new StudentManagerImpl();

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (mStudentManager == null) {
                return;
            }
            mStudentManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            mStudentManager = null;
            //TODO： 这里重新绑定远程Service
        }
    };

    //在客户端绑定远程服务成功后，给binder设置死亡代理
    //TODO ?
}
