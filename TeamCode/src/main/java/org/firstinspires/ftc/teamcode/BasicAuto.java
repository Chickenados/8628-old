package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.ftcrobotcontroller.R;

/**
 * Created by James on 7/18/17.
 */


@Autonomous(name = "BasicAuto", group = "Autonomous")

public class BasicAuto extends LinearOpMode {


    DcMotor FrontRight;
    DcMotor FrontLeft;
    DcMotor BackRight;
    DcMotor BackLeft;



    @Override
    public void runOpMode() throws InterruptedException {

       HardwareBasic robot = new HardwareBasic();

        robot.init(hardwareMap);

        waitForStart();

        //loop();

        double speed = 1;

        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);

        sleep(1000);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);

        //stop();

    }


}

