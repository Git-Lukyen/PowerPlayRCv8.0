package org.firstinspires.ftc.teamcode.rasky.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.rasky.utilities.Button;
import org.firstinspires.ftc.teamcode.rasky.utilities.Constants;

//Author: Lucian
@TeleOp(name = "Button Example Test", group = Constants.testGroup)
public class ButtonExampleTest extends LinearOpMode {

    Button normalPress = new Button();
    Button timeBasedPress = new Button();
    Button toggleBasedPress = new Button();

    Gamepad gamepad;

    @Override
    public void runOpMode() throws InterruptedException {
        gamepad = gamepad1;

        //This while loop will run after initialization until the program starts or until stop
        //is pressed
        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addLine("Initialization Ready");
            telemetry.addLine("Instructions:");
            telemetry.addLine("X/Square is normal press, " +
                    "Y/Triangle is a toggle, " +
                    "B/Circle is short press and long press");
            telemetry.update();
        }

        //This catches the stop button before the program starts
        if (isStopRequested()) return;


        //Main while loop that runs during the match
        while (opModeIsActive() && !isStopRequested()) {
            normalPress.updateButton(gamepad.x);
            toggleBasedPress.updateButton(gamepad.y);
            timeBasedPress.updateButton(gamepad.b);

            telemetry.addData("Normal Press Status: ", normalPress.press());
            telemetry.addData("Toggle Press Status: ", toggleBasedPress.toggle());
            telemetry.addData("Toggled Status: ", toggleBasedPress.getToggleStatus());
            telemetry.addData("Short Press Status: ", timeBasedPress.shortPress());
            telemetry.addData("Short Press Toggle Status: ", timeBasedPress.getShortToggle());
            telemetry.addData("Long Press Status: ", timeBasedPress.longPress());
            telemetry.addData("Long Press Toggle Status: ", timeBasedPress.getLongToggle());
            telemetry.update();
        }

    }
}
