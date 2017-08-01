package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by James on 7/20/17.
 */


@Autonomous(name = "Mecanum Test", group = "Tests")
public class MecanumCircumferenceTest extends LinearOpMode {

    HardwareBasic robot;
    int COUNTS_PER_REV = 280;
    int targetPosition;
    double speed = 0.6;

    @Override
    public void runOpMode() throws InterruptedException {



        robot = new HardwareBasic();
        robot.init(hardwareMap);

        robot.FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        targetPosition = COUNTS_PER_REV / 2;

        robot.FrontLeft.setTargetPosition(targetPosition);
        robot.FrontRight.setTargetPosition(targetPosition);
        robot.BackLeft.setTargetPosition(targetPosition);
        robot.BackRight.setTargetPosition(targetPosition);

        robot.FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.FrontRight.setPower(speed);
        robot.FrontLeft.setPower(speed);
        robot.BackRight.setPower(speed);
        robot.BackLeft.setPower(speed);

        sleep(5000);

        robot.FrontRight.setPower(0);
        robot.FrontLeft.setPower(0);
        robot.BackRight.setPower(0);
        robot.BackLeft.setPower(0);
    }
}
