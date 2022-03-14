package frc.robot.Autonomous.JacksCoolCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveEncoderStart extends CommandBase {

    private boolean completed;

    double kP = 0.018;

    public void initialize() {

    }

    public void execute() {
//increased by 42.5 inch 
        double setPoint = 23;
//set point = feet
        //double sensorPosition = Robot.drive.rightMaster.getEncoder().getPosition();
        double sensorRight = Robot.drive.rightMaster.getEncoder().getPosition()*-0.98;
        double sensorLeft = Robot.drive.leftMaster.getEncoder().getPosition()*-1;

        //double error = setPoint - sensorPosition;
        double errorRight = setPoint - sensorRight;
        double errorLeft = setPoint - sensorLeft;
        //double outputSpeed = kP * error;
        double outputSpeedRight = kP * errorRight;
        double outputSpeedLeft = kP * errorLeft;
        Robot.shooter.spin(0.7);
        Robot.drive.rightMaster.set(-outputSpeedRight);
        Robot.drive.leftMaster.set(-outputSpeedLeft);

    }

    @Override
    public boolean isFinished() {
        return completed;
    }

}