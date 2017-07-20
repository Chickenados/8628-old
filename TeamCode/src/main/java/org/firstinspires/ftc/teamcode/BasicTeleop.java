package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.HardwareBasic;


/**
 * Created by James on 7/19/17.
 */

@TeleOp(name = "Basic Teleop", group = "Basic")

public class BasicTeleop extends LinearOpMode {

    HardwareBasic robot;

    double leftspeed;
    double rightspeed;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new HardwareBasic();
        robot.init(hardwareMap);

        waitForStart();

        leftspeed = gamepad1.left_stick_y;
        rightspeed = gamepad1.right_stick_y;

        leftspeed = Range.clip(leftspeed, -1, 1);
        rightspeed = Range.clip(rightspeed, -1, 1);

        robot.FrontRight.setPower(rightspeed);
        robot.BackRight.setPower(rightspeed);
        robot.FrontLeft.setPower(leftspeed);
        robot.BackLeft.setPower(leftspeed);

    }
}
