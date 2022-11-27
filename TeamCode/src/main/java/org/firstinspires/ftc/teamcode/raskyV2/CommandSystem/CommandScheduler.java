package org.firstinspires.ftc.teamcode.raskyV2.CommandSystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.Collections;

public class CommandScheduler {

    HardwareMap hardwareMap;
    ArrayList<Subsystem> activeSubsystems = new ArrayList<>();
    ArrayList<Command> activeCommands = new ArrayList<>();

    public CommandScheduler(HardwareMap hardwareMap, Subsystem... subsystems) {
        this.hardwareMap = hardwareMap;
        Collections.addAll(activeSubsystems, subsystems);
    }

    public void initAuto() {
        for (Subsystem subsystem : activeSubsystems)
            subsystem.initAuto(hardwareMap);
    }

    public void initTeleOp() {
        for (Subsystem subsystem : activeSubsystems)
            subsystem.initTeleOp(hardwareMap);
    }

    public void update() {
        for (Subsystem subsystem : activeSubsystems)
            subsystem.update();


    }

    //TODO left off 27/11
    public void forceInsert(Command command) {

    }


}
