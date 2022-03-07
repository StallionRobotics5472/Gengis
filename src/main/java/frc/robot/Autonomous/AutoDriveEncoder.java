package frc.robot.Autonomous;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveEncoder extends CommandBase {

    private boolean completed;

    double kP = 1e-4;

    public void initialize() {

    }

    public void execute() {
//increased by 12 encoder per 2 feet
        double setPoint = 10;
//set point = feet
        double sensorPosition = Robot.drive.rightMaster.getEncoder().getPosition();
        //double sensorRight = ((Robot.drive.rightMaster.getEncoder().getPosition())/5.854840088);
        //double sensorLeft = ((Robot.drive.leftMaster.getEncoder().getPosition())/6.052478409);

        double error = setPoint - sensorPosition;
        //double errorRight = setPoint - sensorRight;
        //double errorLeft = setPoint - sensorLeft;
        double outputSpeed = kP * error;
        //double outputSpeedRight = kP * errorRight
        //double outputSpeedLeft` = kP * errorLeft

        Robot.drive.rightMaster.set(outputSpeed);
        Robot.drive.leftMaster.set(-outputSpeed);

    }

    @Override
    public boolean isFinished() {
        return completed;
    }

}