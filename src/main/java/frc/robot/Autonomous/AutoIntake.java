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
public class AutoIntake extends CommandBase {

    private boolean completed;
    private double starttime;

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
    }
    public void execute() {

        


        if(Timer.getFPGATimestamp() - starttime <= 1.0){

           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0.5);
            Robot.shooter.spin(0.75);

            //Robot.drive.rightFollower.set(ControlMode.PercentOutput,-0.5);
        }else {

            Robot.shooter.spin(0);
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