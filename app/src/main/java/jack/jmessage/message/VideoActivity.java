package jack.jmessage.message;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import jack.jmessage.R;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage.message
 * author: PayneJay
 * date: 2018/7/20.
 */

public class VideoActivity extends AppCompatActivity {
    public static final String VIDEO_PATH = "VIDEO_PATH";

    private VideoView mVideoView;

    private int mSavedCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String videoPath = getIntent().getStringExtra(VIDEO_PATH);

        mVideoView = (VideoView) findViewById(R.id.videoview_video);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView);

        mVideoView.setMediaController(mediaController);
        mVideoView.setVideoPath(videoPath);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.requestLayout();
                if (mSavedCurrentPosition != 0) {
                    mVideoView.seekTo(mSavedCurrentPosition);
                    mSavedCurrentPosition = 0;
                } else {
                    play();
                }
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.setKeepScreenOn(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSavedCurrentPosition = mVideoView.getCurrentPosition();
        mVideoView.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        pause();
    }

    private void play() {
        mVideoView.start();
        mVideoView.setKeepScreenOn(true);
    }

    private void pause() {
        mVideoView.pause();
        mVideoView.setKeepScreenOn(false);
    }
}
