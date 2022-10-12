package org.firstinspires.ftc.teamcode.rasky.utilities;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 * A class that handles all of the 4 driving motors.
 * <p>
 * It initializes all of the motors given a set of parameters and then they are ready to use
 * through the object.
 *
 * @author Lucian
 * @version 1.3
 */
public class DrivingMotors {
    public DcMotorEx leftRear, rightRear, leftFront, rightFront;
    HardwareMap hardwareMap;

    public DrivingMotors(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    /**
     * This method initializes each driving motor to be easily accessed from the
     * object when testing.
     *
     * @param encoders Boolean value that checks if motor encoders should be used or not
     * @param brakes   Boolean value that checks if the motors should brake or stop on their own
     */
    public void Init(Boolean encoders, Boolean brakes) {
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        ArrayList<DcMotorEx> motors = new ArrayList<DcMotorEx>(Arrays.asList(leftRear, rightRear, leftFront, rightFront));

        //This initializes the motors with the given settings
        for (DcMotorEx motor : motors) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            if (brakes)
                motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            else
                motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

            if (encoders)
                motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            else
                motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        //Reverse any motors if needed here:
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
