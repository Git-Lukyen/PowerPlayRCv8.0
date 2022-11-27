package org.firstinspires.ftc.teamcode.raskyV2.CommandSystem;

import java.util.ArrayList;
import java.util.Collections;

abstract class Command {


    final ArrayList<Subsystem> dependencies = new ArrayList<>();

    public Command(Subsystem... subsystems) {
        Collections.addAll(dependencies, subsystems);
    }

    public ArrayList<Subsystem> getDependencies() {
        return dependencies;
    }

    Command nextCommand = null;

    public void setNextCommand(Command command) {
        nextCommand = command;
    }

    public Command getNextCommand() {
        return nextCommand;
    }

    public void addNextCommand(Command command) {
        Command tempCommand = this;
        while (tempCommand.getNextCommand() != null)
            tempCommand = tempCommand.getNextCommand();

        nextCommand = tempCommand;
    }

    public abstract void init();

    public abstract void recurring();

    public abstract boolean completed();

    public abstract void discard();

}
