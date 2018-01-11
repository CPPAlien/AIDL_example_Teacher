package me.pengtao.teacher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import org.greenrobot.eventbus.EventBus;

import me.pengtao.rule.ITeacher;
import me.pengtao.rule.StudentInfo;

public class TeacherService extends Service {
    private String mName;
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    IBinder mBinder = new ITeacher.Stub() {
        @Override
        public void registerInfo(final StudentInfo info) throws RemoteException {
            EventBus.getDefault().post(info);
            mName = info.getAppName();
        }

        @Override
        public void registerId(final String id) throws RemoteException {
            // rent it
        }

        @Override
        public String getAlias() throws RemoteException {
            return mName + "Alias";
        }
    };
}
