package frc.robot.Commands.ShooterCommands;

import java.lang.annotation.Target;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;

import org.ejml.dense.row.decomposition.eig.SymmetricQRAlgorithmDecomposition_DDRM;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.Robot;
import frc.robot.Subsystems.LidarSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;


public class ShootCommand extends CommandBase {
  private static final String CANSparkMax = null;
  /**
   * Creates a new TurretShootCommand.
   */

  private boolean isFinished;
  private double shootSpeed;
  private double variable;
  private double distance;
  private double numerator;
  private double denominator;
  private double thirtyfivedegrees;
  private double twentyfivedegrees;
  private double thirtydegrees;
  private double firstTerm;
  private double inverseSecondTerm;
  private double power;
  private double TargetVelocity;
  private LidarSubsystem lidar;
  private double kP;
  

  private ShooterSubsystem shooter;
  private Limelight limelight;



  

  public ShootCommand() {

    // addRequirements(Robot.turret);
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
    // turret.shoot(Constants.TURRET_SPEED);
    shooter = Robot.shooter;
    limelight = Robot.limelight;

    // turret.turret.setIdleMode(IdleMode.kCoast);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
 /*  */
 
 if ((limelight.getHorizontalAngle() > -27) && (limelight.getHorizontalAngle() < -15)) {
  power = 0.365;
  TargetVelocity = 1950;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(0);
 }
 else if ((limelight.getHorizontalAngle() > -14.9999999999999999) && (limelight.getHorizontalAngle() < -12.5)){
  power = 0.37;
  TargetVelocity = 2050;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(0);
 }
 else if ((limelight.getHorizontalAngle() > -12.499999999999999999) && (limelight.getHorizontalAngle() < -10)){
  power = 0.38;
  TargetVelocity = 2110;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(0);
 }
 else if ((limelight.getHorizontalAngle() > -9.9999999999999) && (limelight.getHorizontalAngle() < -8.5)){
  power = 0.39;
  TargetVelocity = 2140;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(0);
}
else if ((limelight.getHorizontalAngle() > -8.499999999999999) && (limelight.getHorizontalAngle() < -3)){
  power = .39;
  TargetVelocity = 2140;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(10);
}
else if ((limelight.getHorizontalAngle() > -2.9999999999999) && (limelight.getHorizontalAngle() < -0.0000000000001)){
  power = .39;
  TargetVelocity = 2140;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(20);
}
else if ((limelight.getHorizontalAngle() > 0.000000000001) && (limelight.getHorizontalAngle() < 2)){
  power = 0.39;
  TargetVelocity = 2150;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(25);
}
else if ((limelight.getHorizontalAngle() > 2.0000000000001) && (limelight.getHorizontalAngle() < 3)){
  power = 0.39;
  TargetVelocity = 2150;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(27);
}
else if ((limelight.getHorizontalAngle() > 3.0000000000001) && (limelight.getHorizontalAngle() < 5)){
  power = 0.415;
  TargetVelocity = 2180;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(27.2);
}
else if ((limelight.getHorizontalAngle() > 5.0000000000001) && (limelight.getHorizontalAngle() < 6)){
  power = 0.435;
  TargetVelocity = 2320;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(27.5);
}
 else{
  power = 0.435;
  TargetVelocity = 2320;
  shooter.rampUp(-power, TargetVelocity);
  shooter.arc(27.5);
  //shooter.URMOM = false;
 }
 //shooter.shoot(power);
//   shooter.shoot(-.36);;
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // turret.turret.setIdleMode(IdleMode.kBrake);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}