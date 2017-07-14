package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Nate on 7/3/17.
 */

public class Eggbot {

    RobotData Data = new RobotData();

    LinearOpMode opMode;

    public Eggbot(LinearOpMode op, DcMotor m0, DcMotor m1, DcMotor m2, DcMotor m3, Telemetry tm){

        opMode = op;

        Data.Drive.m0 = m0;
        Data.Drive.m1 = m1;
        Data.Drive.m2 = m2;
        Data.Drive.m3 = m3;

    }



}

class EggbotData {
    PID PID;
    RobotTime Time;
    Drive Drive;
    EggbotData(){
        PID = new PID();
        Time = new RobotTime();
        Drive = new Drive();
    }
}

class EggbotPID {

}
class EggbotTime {
    private ElapsedTime ProgramTime;

    public EggbotTime(){
        ProgramTime = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
    }

    public float CurrentTime(){
        return (float) ProgramTime.seconds();
    }

    public float TimeFrom(float PreviousTime){
        return (float) (ProgramTime.seconds() - PreviousTime);
    }
}
class EggDrive {
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
}
