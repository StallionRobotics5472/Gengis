package frc.robot.Autonomous;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.DriveSubsystem;
/**
 * Very Sad Auto :(
 * please never run me
 */
public class Auto180 extends CommandBase {

    private boolean completed;
    private double starttime;

    private DriveSubsystem drive;

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
    }
    public void execute() {

    
    

        if(Timer.getFPGATimestamp() - starttime <= 2.2){
            Robot.drive.leftMaster.set(-0.17);
           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0.5);

            Robot.drive.rightMaster.set(0.17);
            //Robot.drive.rightFollower.set(ControlMode.PercentOutput,-0.5);
        }else {
            Robot.drive.leftMaster.set(0);
            Robot.drive.rightMaster.set(0);
           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0);
           // Robot.drive.rightFollower.set(ControlMode.PercentOutput, 0);
            completed = true;
        }

        // drive = Robot.drive;
        // drive.leftMaster.getEncoder().setPosition(0);
        // drive.rightMaster.getEncoder().setPosition(0);

        // double angle = 90;
        // double error = angle - drive.getHeading();

        // double kP = 0.1;

		// double output = (drive.getLeftPercent() + drive.getRightPercent()) / 2.0;
		// drive.drive(output -kP * error, output + kP * error);

    }
    
    @Override
    public boolean isFinished() {
        return completed;
    }

}