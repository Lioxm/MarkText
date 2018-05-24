package com.bignerdranch.android.geoquiz;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * 获取TextView某一个字符的坐标
     *
     * parms tv
     * parms index 字符下标
     * return 返回的是相对坐标
     */
    private int getTextViewSelectionBottomY(TextView tv, int index) {
        Layout layout = tv.getLayout();
        Rect bound = new Rect();
        int line = layout.getLineForOffset(index);
        layout.getLineBounds(line, bound);
        int yAxisBottom = bound.bottom;//字符底部y坐标
//        int yAxisTop = bound.top;//字符顶部y坐标
//        float xAxisLeft = layout.getPrimaryHorizontal(index);//字符左边x坐标
//        float xAxisRight = layout.getSecondaryHorizontal(index);//字符右边x坐标
//注意获取到的这个坐标是TextView的相对坐标。
//        我们可以通过TextView.getScrollY()获取textview展示的内容最上面一行的坐标，这样的话我们就可以算出当前字符串的在屏幕上的坐标位置。
        return yAxisBottom;

    }

}
