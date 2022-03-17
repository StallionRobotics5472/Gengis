package frc.robot.Commands.DriveCommands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.Robot;
import frc.robot.Commands.ShooterCommands.EncoderShootCommand;
import frc.robot.Subsystems.DriveSubsystem;
// import frc.robot.Subsystems.LidarSubsystem;
// import frc.robot.Subsystems.TurretSubsystem;
import frc.robot.Subsystems.LidarSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;


public class TurretAimCommand extends CommandBase {

  /*
   * Approaches a target given the target is within the camera's fov
   */

  private boolean finished;
  private Limelight limelight;
  private boolean isLinedUp;
  //private TurretSubsystem turret;
 // private LidarSubsystem lidar;
 private DriveSubsystem drive;
 private EncoderShootCommand PIDshoot;
 private LidarSubsystem lidar;
 private ShooterSubsystem shooter;
 private boolean isHoodSet;

  public TurretAimCommand() {
       //addRequirements(Robot.turret);
    }
   

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("LimelightAim", false);
        finished = false;
       // turret = Robot.turret
        lidar = Robot.lidarSubsystem;
       drive = Robot.drive;
       shooter = Robot.shooter;
        limelight = Robot.limelight;
        limelight.setWallTargetPipeline();
        //turret.turret.setIdleMode(IdleMode.kCoast);
    }

    @Override
    public void execute() {

       // SmartDashboard.putNumber("LIDAR", lidar.getDistance());
     
        double turn;

    
            double verticalError = limelight.getVerticalAngle();
            SmartDashboard.putNumber("ty", limelight.getVerticalAngle());
            turn = verticalError * -0.05;
        
        SmartDashboard.putNumber("Turret Rotation", turn);
        if (limelight.getTargetArea() <= 1e-4) {
            // || limelight.isFrozen()) {
            turn = 0;
        }
        
        else  {
            if(Math.abs(limelight.getVerticalAngle()) < 0.5){
                SmartDashboard.putBoolean("LimelightAim", true);
                
            }
            else   if (Math.abs(limelight.getVerticalAngle()) < 5)
                turn*=3;
            else   if(Math.abs(limelight.getVerticalAngle()) < 4)
                turn*=4;
            else   if(Math.abs(limelight.getVerticalAngle()) < 2.5)
                turn*=5;
            else   if(Math.abs(limelight.getVerticalAngle()) < 1)
                turn*=6;
            else{
                turn*=2;
            }
        }
        drive.rotate(turn);

      /*  if(isLinedUp = true) {
            
            lidar.setHoodAngle();
            //shooter.setWheelSpeed();
        }
        SmartDashboard.putBoolean("LinedUp", isLinedUp);

        */

        // if(turret.getTurretEncoder()>0.5*Constants.TURRET_RATIO && turn > 0 || turret.getTurretEncoder() < -0.5*Constants.TURRET_RATIO && turn < 0)
        //     turret.rotate(0);
        // else
        //     turret.rotate(turn);
        
        

        

    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
        limelight.disableWallTargetPipeline();
        //turret.turret.setIdleMode(IdleMode.kBrake);
    }
}