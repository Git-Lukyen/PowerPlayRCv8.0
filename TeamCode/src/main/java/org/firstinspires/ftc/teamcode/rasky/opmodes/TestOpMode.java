package org.firstinspires.ftc.teamcode.rasky.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.rasky.components.AntiTipDrive;
import org.firstinspires.ftc.teamcode.rasky.components.FieldCentricDrive;
import org.firstinspires.ftc.teamcode.rasky.components.LiftClaw;
import org.firstinspires.ftc.teamcode.rasky.components.LiftSystem;
import org.firstinspires.ftc.teamcode.rasky.utilities.Button;
import org.firstinspires.ftc.teamcode.rasky.utilities.Constants;
import org.firstinspires.ftc.teamcode.rasky.utilities.DrivingMotors;
import org.firstinspires.ftc.teamcode.rasky.utilities.Gyroscope;

/**
 * The test TeleOP program for testing new features.
 *
 * @author Lucian
 * @version 1.0
 */
@TeleOp(name = "Test OpMode", group = Constants.testGroup)
public class TestOpMode extends LinearOpMode {

    DrivingMotors motors;
    Gyroscope gyroscope;

    AntiTipDrive antiTipDrive;
    FieldCentricDrive fieldCentricDrive;
    LiftSystem liftSystem;
    LiftClaw liftClaw;

    Gamepad drivingGamepad;
    Gamepad utilityGamepad;

    @Override
    public void runOpMode() throws InterruptedException {

        //Set the gamepads to the desired gamepad
        drivingGamepad = gamepad1;
        utilityGamepad = gamepad2;

        motors = new DrivingMotors(hardwareMap);
        motors.Init();

        liftSystem = new LiftSystem(hardwareMap, utilityGamepad);
        liftSystem.Init();

        liftClaw = new LiftClaw(hardwareMap, utilityGamepad);
        liftClaw.Init();

        gyroscope = new Gyroscope(hardwareMap);
        gyroscope.Init();

        antiTipDrive = new AntiTipDrive(motors, drivingGamepad, gyroscope);
        fieldCentricDrive = new FieldCentricDrive(motors, drivingGamepad, gyroscope);

        //This while loop will run after initialization until the program starts or until stop
        //is pressed
        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addLine("Initialization Ready");
            telemetry.update();
        }

        //This catches the stop button before the program starts
        if (isStopRequested()) return;

        Button driveModeButton = new Button();

        //Main while loop that runs during the match
        while (opModeIsActive() && !isStopRequested()) {
            driveModeButton.updateButton(drivingGamepad.x);
            driveModeButton.shortPress();
            driveModeButton.longPress();

            antiTipDrive.setReverse(driveModeButton.getShortToggle());

            if (!driveModeButton.getLongToggle()) {
                antiTipDrive.run();
                //antiTipDrive.showInfo(telemetry);
            } else {
                fieldCentricDrive.run();
                //fieldCentricDrive.showInfo(telemetry);
            }

            liftSystem.run();
            //liftSystem.showInfo(telemetry);

            liftClaw.run();
            liftClaw.showInfo(telemetry);

            telemetry.update();
        }
    }
}
