package wyyu.multi.update.player;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

/**
 * Created by wyyu on 2019-10-08.
 **/

public class CellPlayer {

    private static final class PlayerHolder {
        private static CellPlayer cellPlayer = new CellPlayer();
    }

    private static final int DEFAULT_DELAY = 100;
    private static final int DEFAULT_INDEX = -1;
    private static final int DEFAULT_DATA = 0;
    private static final int DEFAULT_MSG = 0;

    public static CellPlayer getPlayer() {
        return PlayerHolder.cellPlayer;
    }

    private PlayerListener playerListener;
    private Handler handler;

    private int presentData;
    private int index;

    @SuppressLint("HandlerLeak") private CellPlayer() {
        presentData = DEFAULT_DATA;
        index = DEFAULT_INDEX;

        handler = new Handler() {
            @Override public void handleMessage(Message msg) {
                presentData++;
                if (playerListener != null) {
                    playerListener.onPlay(presentData);
                }
                handler.sendEmptyMessageDelayed(DEFAULT_MSG, DEFAULT_DELAY);
            }
        };
    }

    public void play(int index, @NonNull PlayerListener playerListener) {
        if (this.index == index) {
            return;
        }

        this.index = index;
        this.presentData = DEFAULT_DATA;

        if (this.playerListener != null) {
            this.playerListener.onPlay(DEFAULT_DATA);
        }
        this.playerListener = playerListener;

        this.handler.sendEmptyMessageDelayed(DEFAULT_MSG, DEFAULT_DELAY);
        this.playerListener.onPlay(presentData);
    }

    public void cancel() {
        if (handler != null) {
            handler.removeMessages(DEFAULT_MSG);
        }
        if (playerListener != null) {
            playerListener.onPlay(DEFAULT_DATA);
        }
        this.playerListener = null;

        this.presentData = DEFAULT_DATA;
        this.index = DEFAULT_INDEX;
    }
}
