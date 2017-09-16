package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by philpettis on 9/16/17.
 */

@TeleOp(name = "Servo Arm")
public class ServoArmTest extends OpMode {

    Servo arm;

    public void init(){

        arm = hardwareMap.servo.get("arm");

    }

    public void loop(){



        if(gamepad1.a){
            arm.setPosition(10);
        } else if(gamepad1.b){
            arm.setPosition(90);
        }


    }

}

