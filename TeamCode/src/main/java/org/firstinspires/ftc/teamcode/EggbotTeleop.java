package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Nate on 7/14/17.
 */

@TeleOp(name = "Eggbot Teleop")
public class EggbotTeleop extends OpMode {

    DcMotor[] motors = new DcMotor[4];

    HoloDirection direction;


    ModernRoboticsI2cColorSensor colorSensor;
    ModernRoboticsI2cGyro gyro;

    BNO055IMU imu;

    public void init(){

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);




        motors[0] = hardwareMap.dcMotor.get("FrontLeft");
        motors[1] = hardwareMap.dcMotor.get("FrontRight");
        motors[2] = hardwareMap.dcMotor.get("BackRight");
        motors[3] = hardwareMap.dcMotor.get("BackLeft");

        motors[0].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[3].setDirection(DcMotorSimple.Direction.REVERSE);

        direction = new HoloDirection(0, 0, 0);


    }

    public void loop(){

        telemetry.addData("", imu.getAngularOrientation());
        telemetry.update();
        move(gamepad1);

    }

    public void move(Gamepad pad){
        direction.setValues(pad.right_stick_x, pad.right_stick_y, pad.left_stick_x);

        motors[0].setPower(direction.frontLeftSpeed());
        motors[1].setPower(direction.frontRightSpeed());
        motors[2].setPower(direction.backRightSpeed());
        motors[3].setPower(direction.backLeftSpeed());

    }

}
