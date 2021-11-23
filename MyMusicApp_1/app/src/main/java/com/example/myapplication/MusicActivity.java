package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class MusicActivity extends AppCompatActivity{
/*
        ImageView nextIv, playIv, lastIv;
        TextView singerTv, songTv;
        RecyclerView musicRv;
        //数据源
        List<LocalMusicBean> mDatas;
        private LocalMusicAdapter adapter;
*/
    private ImageView iv_disk;  //
    private static SeekBar musicProgressBar;  //
    private static TextView currentTv;  //
    private static TextView totalTv; //
    private Button btn_play, btn_pause, btn_continue, btn_exit;  //

    private ObjectAnimator animator;

    private MusicPlayerServices.MusicControl control;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            control = (MusicPlayerServices.MusicControl) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        init();
    }

    public void init(){
        iv_disk = findViewById(R.id.iv_music);
        musicProgressBar = findViewById(R.id.sb);
        currentTv = findViewById(R.id.tv_progress);
        totalTv = findViewById(R.id.tv_total);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        btn_continue = findViewById(R.id.btn_continue);
        btn_exit = findViewById(R.id.btn_exit);

        onClick onClick = new onClick();
        btn_play.setOnClickListener(onClick);
        btn_pause.setOnClickListener(onClick);
        btn_continue.setOnClickListener(onClick);
        btn_exit.setOnClickListener(onClick);

        animator = ObjectAnimator.ofFloat(iv_disk, "rotation", 0, 360.0F);
        //对象是iv_disk，动作是rotation旋转，角度是从0到360度，这里用浮点数，所以要加一个F
        animator.setDuration(10000);
        //设置动画时长，每10秒转一圈
        animator.setInterpolator(new LinearInterpolator());
        //旋转时间函数为线性，意味着匀速旋转
        animator.setRepeatCount(-1);
        //设置旋转动画，-1为一直转送

        Intent intent = new Intent(getApplicationContext(), MusicPlayerServices.class);
        bindService(intent, conn, BIND_AUTO_CREATE);

        musicProgressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //当音乐停止后，停止光盘动画
                if(progress == seekBar.getMax()){
                    animator.pause();
                }
                if(fromUser){  //判断是不是用户拖动
                    control.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                control.pause(); //拖动进度条的时候，歌曲暂停
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                control.resume(); //停止拖动的时候，歌曲继续播放
            }
        });
        }

        class onClick implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_play:
                        //播放音乐
                        control.play();
                        //光盘开始转动
                        animator.start();
                        break;
                    case R.id.btn_pause:
                        //暂定音乐
                        control.pause();
                        //光盘停止
                        animator.pause();
                        break;
                    case R.id.btn_continue:
                        //继续播放
                        control.resume();
                        //光盘继续转动
                        animator.resume();
                        break;
                    case R.id.btn_exit:
                        //退出应用
                        finish();
                        break;
                }
            }
        }

        protected void onDestroy(){
            control.stop();
            unbindService(conn);
            super.onDestroy();
        }


        public static Handler handler = new Handler(Looper.myLooper()){

            public void handleMessage(@NonNull Message msg){
                super.handleMessage(msg);
                Bundle bundle = msg.getData(); //获取从子线程发送过来的音乐播放进度
                int duration = bundle.getInt("duration"); //歌曲的总时长
                int currentPosition = bundle.getInt("currentPosition"); //歌曲当前的进度
                musicProgressBar.setMax(duration); //设置SeekBar的最大值为歌曲总时长
                musicProgressBar.setProgress(currentPosition); //设置SeekBar当前的进度位置
                String totalTime = msToMinSec(duration); //歌曲总时长
                String currentTime = msToMinSec(currentPosition); //歌曲当前播放时长
                totalTv.setText(totalTime);
                currentTv.setText(currentTime);
            }
        };


        public static String msToMinSec(int ms){
            int sec = ms/1000;
            int min = sec/60;
            sec -= min*60;
            return String.format("%02d：%02d", min, sec);
        }


    }



