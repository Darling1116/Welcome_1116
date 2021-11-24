package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class MusicActivity extends AppCompatActivity{
    private ImageView iv_disk;  //
    private static SeekBar musicProgressBar;  //
    private static TextView currentTv;  //
    private static TextView totalTv; //
    private Button btn_exit;  //

    private ObjectAnimator animator;
    private MusicPlayerServices.MusicControl control;


    private TextView songName, singerName;
    private ImageButton btn_prev, btn_next, btn_play_pause;

    private MediaPlayer player;
    private int currentPlaying = 0; //用做ArratList的下标，表示当前播放的歌曲
    private ArrayList<Integer> resourceId = new ArrayList<>();

    private boolean isPausing = false, isPlaying = false;

/*
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            control = (MusicPlayerServices.MusicControl) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        init();
        preparePlaylist();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(isPlaying){
                    updateTimer();
                }
            }
        };
        new Timer().scheduleAtFixedRate(timerTask, 0, 500);

    }

    public void init(){
        iv_disk = findViewById(R.id.iv_music);
        musicProgressBar = findViewById(R.id.sb);
        currentTv = findViewById(R.id.tv_progress);
        totalTv = findViewById(R.id.tv_total);
        btn_exit = findViewById(R.id.btn_exit);

        songName = findViewById(R.id.tv_song_name);
        singerName = findViewById(R.id.tv_song_singer);
        btn_prev = findViewById(R.id.btn_prev);
        btn_play_pause = findViewById(R.id.btn_play_pause);
        btn_next = findViewById(R.id.btn_next);


        onClick onClick = new onClick();
        btn_exit.setOnClickListener(onClick);
        btn_prev.setOnClickListener(onClick);
        btn_play_pause.setOnClickListener(onClick);
        btn_next.setOnClickListener(onClick);

        OnSeekBarChangeControl onSbChange = new OnSeekBarChangeControl();
        musicProgressBar.setOnSeekBarChangeListener(onSbChange);

        animator = ObjectAnimator.ofFloat(iv_disk, "rotation", 0, 360.0F);
        //对象是iv_disk，动作是rotation旋转，角度是从0到360度，这里用浮点数，所以要加一个F
        animator.setDuration(10000);
        //设置动画时长，每10秒转一圈
        animator.setInterpolator(new LinearInterpolator());
        //旋转时间函数为线性，意味着匀速旋转
        animator.setRepeatCount(-1);
        //设置旋转动画，-1为一直转送
    }



    private void preparePlaylist(){
        Field[] fields = R.raw.class.getFields();
        for(int count = 0; count < fields.length; count++){
            Log.i("Raw Asset", fields[count].getName());
            try {
                int resId = fields[count].getInt(fields[count]);
                resourceId.add(resId);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void prepareMedia(){
        if(isPlaying){
            player.stop();
            player.reset();
        }
        player = MediaPlayer.create(getApplicationContext(), resourceId.get(currentPlaying));
        int musicDuration = player.getDuration();
        musicProgressBar.setMax(musicDuration);
        String musicTime = msToMinSec(musicDuration);
        /*
        int sec = musicDuration/1000;
        int min = sec/60;
        sec -= min*60;
        String musicTime = String.format("%02d:%02d", min, sec);
        */
        totalTv.setText(musicTime);
        player.start();
    }


    private void updateTimer(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int currentMs = player.getCurrentPosition();
                int sec = currentMs / 1000;
                int min = sec / 60;
                sec -= min * 60;
                String time = String.format("%02d:%02d", min, sec);
                musicProgressBar.setProgress(currentMs);
                currentTv.setText(time);
            }
        });

    }


    class onClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_exit:
                    player.pause();
                    animator.pause();
                    finish(); //退出应用
                    break;
                case R.id.btn_prev:
                    //重播、上切
                    Log.i("INFO", "onClick:上切按钮被点击");
                    animator.start();
                    //if(!player.isPlaying()) {
                        currentPlaying = (--currentPlaying) % resourceId.size();
                    //}
                    prepareMedia();
                    isPausing = false;
                    isPlaying = true;
                    break;
                case R.id.btn_play_pause:
                    Log.i("INFO", "onClick:开始暂停按钮被点击");
                    if(!isPausing && !isPlaying){ //暂停状态，且从未被播放过
                        btn_play_pause.setImageResource(R.mipmap.icon_pause); // 切换成暂停键
                        animator.start();
                        prepareMedia();
                        isPlaying = true;
                    }
                    else if(isPlaying && isPausing){ //暂停状态，且被播放过一次
                        btn_play_pause.setImageResource(R.mipmap.icon_pause); //切换成暂停键
                        animator.resume();
                        player.start();
                    }
                    else { //播放状态
                        //暂停播放
                        btn_play_pause.setImageResource(R.mipmap.icon_play); //切换成播放键
                        animator.pause();
                        player.pause();
                    }
                    isPausing = !isPausing;
                    break;
                case R.id.btn_next:
                    //切歌
                    Log.i("INFO", "onClick:切歌按钮被点击");
                    currentPlaying = (++currentPlaying) % resourceId.size();
                    prepareMedia();
                    animator.start();
                    isPausing = false;
                    isPlaying = true;
                    break;
                default:
                    //有bug了
                    Log.i("INFO", "onClick:按钮被点击，但是有bug!");
            }
        }
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


    private class OnSeekBarChangeControl implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser){
                player.seekTo(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            player.pause();
            animator.pause();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            player.start();
            if(seekBar.getProgress() < 10){
                animator.start();
            }
            else{
                animator.resume();
            }
        }
    }

}



