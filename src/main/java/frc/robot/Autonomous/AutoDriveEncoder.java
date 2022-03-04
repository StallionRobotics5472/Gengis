package frc.robot.Autonomous;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveEncoder extends CommandBase {

    private boolean completed;

    double kP = 0;

    public void initialize() {

    }

    public void execute() {

        double setPoint = 10;
        double sensorPosition = Robot.drive.rightMaster.getEncoder().getPosition();

        double error = setPoint - sensorPosition;
        double outputSpeed = kP * error;

        Robot.drive.rightMaster.set(outputSpeed);
        Robot.drive.leftMaster.set(-outputSpeed);

    }

    @Override
    public boolean isFinished() {
        return completed;
    }

}