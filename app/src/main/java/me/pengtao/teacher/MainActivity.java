package me.pengtao.teacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import me.pengtao.rule.StudentInfo;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mStudentBoard;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        mStudentBoard = findViewById(R.id.student_board);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(StudentInfo info) {
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.student_info, info.getAppName(), info.getSex(), info
                .getPackageId()));
        mStudentBoard.addView(textView);
    }
}
