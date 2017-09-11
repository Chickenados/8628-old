package org.firstinspires.ftc.teamcode;

/**
 * Created by Nate on 9/10/17.
 */

public class Stopwatch {
    long mLastTime = 0;
    int mWaitTime = 0;

    public Stopwatch(int waitTime){
        mWaitTime = waitTime;
    }

    public void setTime(int waitTime){
        mWaitTime = waitTime;
    }

    public boolean isExpired(){
        if((System.currentTimeMillis() - mLastTime) > mWaitTime){
            return true;
        }
        return false;
    }

    public void reset(){
        mLastTime = System.currentTimeMillis();
    }
}
