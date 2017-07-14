package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Armin on 7/9/17.
 */

public abstract class MasterAutonomous extends LinearOpMode{

    HardwarePushbot robot = new HardwarePushbot ();
    public ModernRoboticsI2cGyro gyro = null;


    private static final double COUNTS_PER_MOTOR_REV = 1080;
    private static final double DRIVE_GEAR_REDUCTION = 1;
    private static final double WHEEL_DIAMETER_INCHES = 3;
    private static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)/
            (WHEEL_DIAMETER_INCHES * 3.14159265);

    private static final double DRIVE_SPEED = 0.7;
    private static final double TURN_SPEED = 0.5;

    private static final double HEADING_THRESHOLD = 1;
    private static final double P_TURN_COEFF =0.1;
    private static final double P_TURN_COEFF =0.15;

    public void initAuto() throws InterruptedException {

        robot.init(hardwareMap);
        gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get ("gyro");

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftClaw.setMode(Servo.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightClaw.setMode(Servo.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData(">", "Calibrating Gyro");
        telemetry.update();

        gyro.calibrate();

        while

    }

}
