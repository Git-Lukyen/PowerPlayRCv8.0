package org.firstinspires.ftc.teamcode.raskyV2.CommandSystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Subsystem {

    public abstract void initAuto(HardwareMap hardwareMap);

    public abstract void initTeleOp(HardwareMap hardwareMap);

    public abstract void update();

    public abstract void stop();
}
