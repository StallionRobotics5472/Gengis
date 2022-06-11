package frc.robot.Autonomous;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
/**
 * Very Sad Auto :(
 * please never run me
 */
public class AutoClimb extends CommandBase {

    private boolean completed;
    private double starttime;
    private double kP = 0.045;
    private double kI = 0;
    private double kD = 0;
    PIDController pid = new PIDController(kP, kI, kD);

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
    }
    
    public void execute() {

        double sensorHood = Robot.shooter.hood.getEncoder().getPosition();

        
        if(Timer.getFPGATimestamp() - starttime <= 0.5){
            Robot.shooter.hood.set(pid.calculate(sensorHood, -28));
            
             Robot.lift.grab(0.4);  
            // Robot.lift.extend(0.08);
           // Robot.drive.leftFollower.set(ControlMode.PercentOutput, 0.5);
            //Robot.drive.rightFollower.set(ControlMode.PercentOutput,-0.5);
        }else {
            Robot.lift.grab(0);
          //  Robot.lift.extend(0);
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