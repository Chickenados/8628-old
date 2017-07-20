package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.ColorSensor;


import static android.os.SystemClock.sleep;

/**
 * Created by faithpettis on 7/18/17.
 */

public class HardwareBasic {

    public DcMotor FrontRight;
    public DcMotor FrontLeft;
    public DcMotor BackRight;
    public DcMotor BackLeft;
    public ColorSensor colorSensor;

    HardwareMap hwMap  =  null;

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        FrontRight = hwMap.dcMotor.get("FrontRight");
        FrontLeft = hwMap.dcMotor.get("FrontLeft");
        BackRight = hwMap.dcMotor.get("BackRight");
        BackLeft = hwMap.dcMotor.get("BackLeft");
        colorSensor = hwMap.colorSensor.get("sensor_color");
        colorSensor.enableLed(true);

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        BackRight.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public void destroy(int time){
        double speed = 1;

        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);

        sleep(time);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

    }



}
