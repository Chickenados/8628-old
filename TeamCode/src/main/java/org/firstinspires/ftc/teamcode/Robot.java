package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
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

<<<<<<< HEAD
    public int[] SenseColor(){
        int[] rgb = new int[3];

        rgb[0] = Data.Sensor.color.red();
        rgb[1] = Data.Sensor.color.blue();
        rgb[2] = Data.Sensor.color.green();
        rgb[3] = Data.Sensor.color.alpha();

        return rgb;
    }


    public void Straight(float Rotations, float[] movement, int Timeout, Telemetry tm){

=======
    public void Straight(float Rotations, int Timeout, Telemetry tm){
>>>>>>> 31c2bac3d585c6189661bceb4ef154f2e96224dc



    }


    private void CalculatePID(float requestedGyro, Telemetry tm){

        Data.PID.error = requestedGyro;
        Data.PID.acumError = Data.PID.error;
        Data.PID.deriv = Data.PID.lastError;
        Data.PID.lastError = Data.PID.error;
        Data.PID.gyroPower = (Data.PID.error * Data.PID.Kp) + (Data.PID.deriv * Data.PID.Kd) + (Data.PID.acumError * Data.PID.Ki);
    }


}

class RobotData {
    PID PID;
    RobotTime Time;
    Drive Drive;
    Sensor Sensor;
    RobotData(){
        PID = new PID();
        Time = new RobotTime();
        Drive = new Drive();
        Sensor = new Sensor();
    }
}

class PID {
    float Target;
    float error;
    float deriv;
    float acumError;
    float Kp = 0.5f, Ki = 0.001f, Kd = 0.3f;
    float lastError;
    float gyroPower;
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

class Sensor {
    ColorSensor color;


}
