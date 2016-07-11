package com.example.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.common.design.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hit:
                new MaterialDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("仿原生AlertDialog样式的对话框,目的在于解决原生的在Android 5.0下样式丑陋问题")
                        .setPositiveButton(null)
                        .setNeutralButton("不再提示", null)
                        .setNegativeButton(null).show();
                break;
            case R.id.list:
                final String[] items = {"2016/01", "2016/02", "2016/03", "2016/04", "2016/05", "2016/06", "2016/07"};
                new MaterialDialog.Builder(this)
                        .setItems(items, new MaterialDialog.OnClickListener() {
                            @Override
                            public boolean onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }).create().show();
                break;
            case R.id.radio:
                final String[] item2 = {"2016/01", "2016/02", "2016/03", "2016/04", "2016/05", "2016/06", "2016/07"};
                new MaterialDialog.Builder(this)
                        .setTitle("单选框")
                        .setSingleChoiceItems(item2, 2, new MaterialDialog.OnClickListener() {
                            @Override
                            public boolean onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, item2[which], Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        }).setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .setNeutralButton("不在提示", null).show();
                break;
            case R.id.check:
                final String[] item1 = {"2016/01", "2016/02", "2016/03", "2016/04", "2016/05", "2016/06", "2016/07"};
                new MaterialDialog.Builder(this)
                        .setTitle("多选框")
                        .setMultiChoiceItems(item1, new boolean[]{false, true, false, true}, new MaterialDialog.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, which + "--" + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .setNeutralButton("不在提示", null).show();
                break;

        }
    }

    public void show(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}