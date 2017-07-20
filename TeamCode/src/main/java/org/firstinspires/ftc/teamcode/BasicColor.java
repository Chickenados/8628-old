package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by James on 7/19/17.
 */
@Autonomous(name = "Color Sensor Turn", group = "Basic")

public class BasicColor extends LinearOpMode {


    HardwareBasic robot;
    int red;
    int blue;
    int green;

    double TURN_SPEED = 0.6;

    @Override
    public void runOpMode() throws InterruptedException {

    //init
      robot = new HardwareBasic();
      robot.init(hardwareMap);
    //wait

        waitForStart();

    //run

        while (opModeIsActive()) {

            red = robot.colorSensor.red();
            blue = robot.colorSensor.blue();

            if (red > 0) {

                robot.FrontLeft.setPower(TURN_SPEED);
                robot.BackLeft.setPower(TURN_SPEED);
                robot.FrontRight.setPower(-TURN_SPEED);
                robot.BackRight.setPower(-TURN_SPEED);

                sleep(500);

                robot.FrontLeft.setPower(0);
                robot.BackLeft.setPower(0);
                robot.FrontRight.setPower(-0);
                robot.BackRight.setPower(-0);

            } else if (blue > 0) {

                robot.FrontLeft.setPower(-TURN_SPEED);
                robot.BackLeft.setPower(-TURN_SPEED);
                robot.FrontRight.setPower(TURN_SPEED);
                robot.BackRight.setPower(TURN_SPEED);

                sleep(500);

                robot.FrontLeft.setPower(0);
                robot.BackLeft.setPower(0);
                robot.FrontRight.setPower(-0);
                robot.BackRight.setPower(-0);

            }
        }

    //stop
    }
}
