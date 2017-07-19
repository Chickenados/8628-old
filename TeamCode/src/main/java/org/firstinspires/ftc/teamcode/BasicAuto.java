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

        robot.destroy(500);

        //stop();

    }


}

