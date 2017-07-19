package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by faithpettis on 7/18/17.
 */

public class HardwareBasic {

    public DcMotor FrontRight;
    public DcMotor FrontLeft;
    public DcMotor BackRight;
    public DcMotor BackLeft;

    HardwareMap hwMap  =  null;

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        FrontRight = hwMap.dcMotor.get("FrontRight");
        FrontLeft = hwMap.dcMotor.get("FrontLeft");
        BackRight = hwMap.dcMotor.get("BackRight");
        BackLeft = hwMap.dcMotor.get("BackLeft");

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        BackRight.setDirection(DcMotorSimple.Direction.FORWARD);

    }

}
