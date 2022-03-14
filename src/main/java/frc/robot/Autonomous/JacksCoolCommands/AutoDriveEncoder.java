package frc.robot.Autonomous.JacksCoolCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveEncoder extends CommandBase {

    private boolean completed;
    private double starttime;

    private double kP = 0.018;
    private double kI = 0;
    private double kD = 0;

    PIDController pid = new PIDController(kP, kI, kD);
    

    public void initialize() {
        starttime = Timer.getFPGATimestamp();
        
        
    }

    double setPoint = 0;

    public AutoDriveEncoder(double Encoder) {
        setPoint = Encoder;

    }

    
    public void execute() {
        // increased by 42.5 inch
  
        // set point = feet
        // double sensorPosition = Robot.drive.rightMaster.getEncoder().getPosition();
        double sensorRight = Robot.drive.rightMaster.getEncoder().getPosition() * 0.98;
        double sensorLeft = Robot.drive.leftMaster.getEncoder().getPosition() * 1;

        // // double error = setPoint - sensorPosition;
        // double errorRight = setPoint - sensorRight;
        // double errorLeft = setPoint - sensorLeft;
        // // double outputSpeed = kP * error;
        // double outputSpeedRight = kP * errorRight;
        // double outputSpeedLeft = kP * errorLeft;
        // // Robot.shooter.spin(0.7);
        // Robot.drive.rightMaster.set(-outputSpeedRight * 0.5);
        // Robot.drive.leftMaster.set(-outputSpeedLeft * 0.5);
        

        Robot.drive.rightMaster.set(pid.calculate( sensorRight, setPoint ));
        Robot.drive.leftMaster.set(pid.calculate( sensorLeft  , setPoint));

        pid.setTolerance(1);

        SmartDashboard.putNumber("rightMaster_Encoder ProcessVariable", Robot.drive.rightMaster_Encoder.getPosition());

        SmartDashboard.putBoolean("Is finished", false);
        if(pid.atSetpoint() ){
            completed = true;
            SmartDashboard.putBoolean("Is finished", true);
        }

  
    }

    @Override
    public boolean isFinished() {
        return completed;
    }

}