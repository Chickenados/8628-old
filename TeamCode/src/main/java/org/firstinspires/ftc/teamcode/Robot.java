package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Nate on 7/3/17.
 */

public class Robot {

    RobotData Data = new RobotData();

    LinearOpMode opMode;

    public Robot(LinearOpMode op, DcMotor m0, DcMotor m1, DcMotor m2, DcMotor m3, Telemetry tm){

        opMode = op;

        Data.Drive.m0 = m0;
        Data.Drive.m1 = m1;
        Data.Drive.m2 = m2;
        Data.Drive.m3 = m3;

        Data.Drive.EncoderCount = 28;

    }

    public void Straight(float Rotations, float[] movement, int Timeout, Telemetry tm){

        Data.Time = new RobotTime();

        float StartTime = Data.Time.CurrentTime();
        float startPosition = Data.Drive.m0.getCurrentPosition();

        float LoopTime = Data.Time.CurrentTime();
        float SystemTime = System.currentTimeMillis();

        while(Math.abs(startPosition - Data.Drive.m0.getCurrentPosition()) < Math.abs(Rotations) * Data.Drive.EncoderCount && opMode.opModeIsActive()){

            if(StartTime + Timeout < Data.Time.CurrentTime()){
                break;
            }

            SystemTime = System.currentTimeMillis() - SystemTime;

            CalculatePID(LoopTime, tm);
        }


    }


    private void CalculatePID(float loopTime, Telemetry tm){

        // 'I' will be the previous error divided by the loop time in seconds.

        Data.PID.I = Data.PID.P/(loopTime/1000);

        // Set our P, I, and D values.
        // `P` will be the ComputedTarget - Target

        Data.PID.P = Data.PID.Headings[1] - Data.PID.Target;

        // `D` will be the difference of the ComputedTarget and the Derivative average divided by
        // the time since the last loop in seconds multiplied by one plus half of the size of
        // the Derivative data set size.

        Data.PID.D = (Data.PID.LastError - Data.PID.P)/(loopTime/1000);

        //Set the last error to be what the error was in this loop.
        Data.PID.LastError = Data.PID.P;

    }

}

class RobotData {
    PID PID;
    RobotTime Time;
    Drive Drive;
    RobotData(){
        PID = new PID();
        Time = new RobotTime();
        Drive = new Drive();
    }
}

class PID {
    float TARGET_MODIFIER = 0f;
    public float turnPrecision = 1f;
    float ComputedTarget;
    float Target;
    float P, I, D;
    float[] Headings = new float[2];
    float LastError;
}
class RobotTime {
    private ElapsedTime ProgramTime;

    public RobotTime(){
        ProgramTime = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
    }

    public float CurrentTime(){
        return (float) ProgramTime.seconds();
    }

    public float TimeFrom(float PreviousTime){
        return (float) (ProgramTime.seconds() - PreviousTime);
    }
}
class Drive {
    /*
   Front
   ________
   |0    1|
   |      |
   |3    2|
   --------
   Rear
   */
    DcMotor m0;
    DcMotor m1;
    DcMotor m2;
    DcMotor m3;

    int EncoderCount;
}
