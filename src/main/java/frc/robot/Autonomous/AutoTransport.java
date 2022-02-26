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
public class AutoTransport extends CommandBase {

    private boolean completed;
    private double starttime;

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
    }
    public void execute() {

        


        if(Timer.getFPGATimestamp() - starttime <= 5){
            Robot.shooter.shoot(-0.55);
            Robot.shooter.spinback(1);
            Robot.shooter.mover(1);
            Robot.shooter.spin(1);

        }else {
          Robot.shooter.shoot(0);
          Robot.shooter.spinback(0);
          Robot.shooter.mover(0);
          Robot.shooter.spin(0);
            completed = true;
        }
    }
    
    @Override
    public boolean isFinished() {
        return completed;
    }

}