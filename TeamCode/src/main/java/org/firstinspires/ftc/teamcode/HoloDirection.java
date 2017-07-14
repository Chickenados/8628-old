package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.Range;

/**
 * Created by Nate on 7/14/17.
 */

public class HoloDirection {
    public float xSpeed;
    public float ySpeed;
    public float zAngle;

    public HoloDirection(float x, float y, float z){
        xSpeed = x;
        ySpeed = y;
        zAngle = z;
    }

    public void setValues(float x, float y, float z){
        xSpeed = x;
        ySpeed = y;
        zAngle = z;
    }

    public float frontLeftSpeed(){
        float speed = 0;

        speed += ySpeed;
        speed -= xSpeed;
        speed += zAngle;

        return (float) Range.clip(speed, -1, 1);

    }

    public float frontRightSpeed(){
        float speed = 0;

        speed += ySpeed;
        speed += xSpeed;
        speed -= zAngle;

        return (float) Range.clip(speed, -1, 1);

    }

    public float backRightSpeed(){
        float speed = 0;

        speed += ySpeed;
        speed -= xSpeed;
        speed -= zAngle;

        return (float) Range.clip(speed, -1, 1);

    }

    public float backLeftSpeed(){
        float speed = 0;

        speed += ySpeed;
        speed += xSpeed;
        speed += zAngle;

        return (float) Range.clip(speed, -1, 1);

    }

}
