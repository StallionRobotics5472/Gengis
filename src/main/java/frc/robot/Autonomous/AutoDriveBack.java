package frc.robot.Autonomous;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
/**
 * Very Sad Auto :(
 * please never run me
 */
public class AutoDriveBack extends CommandBase {

    private boolean completed;
    private double starttime;

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
    }
    public void execute() {

        


        if(Timer.getFPGATimestamp() - starttime <= 2.25){
          // 1.1 s for two ball
          
            Robot.drive.leftMaster.set(0.19);
           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0.5);
           // Robot.shooter.spin(0.75);
            Robot.drive.rightMaster.set(0.17);
            //Robot.drive.rightFollower.set(ControlMode.PercentOutput,-0.5);
        }else {
            Robot.drive.leftMaster.set(0);
            Robot.drive.rightMaster.set(0);
           // Robot.shooter.spin(0);
           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0);
           // Robot.drive.rightFollower.set(ControlMode.PercentOutput, 0);
            completed = true;
        }
    }
    
    @Override
    public boolean isFinished() {
        return completed;
    }

}