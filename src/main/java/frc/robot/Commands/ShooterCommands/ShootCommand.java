package frc.robot.Commands.ShooterCommands;

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
  
 /*  if((shooter.flyWheel1.getEncoder().getVelocity()*-1) < 1950) {

    shooter.shoot(-.6);
   }
   else if (((shooter.flyWheel1.getEncoder().getVelocity()*-1) > 1950.001) && (shooter.flyWheel1.getEncoder().getVelocity()*-1) < 2050){
     shooter.shoot(power);
   }
 else {

 }*/
 
 if ((limelight.getHorizontalAngle() > -20) && (limelight.getHorizontalAngle() < -15)) {
   power = -0.365;
 }
 else if ((limelight.getHorizontalAngle() > -15) && (limelight.getHorizontalAngle() < -10)){
   power = -0.38;
 }
 else{
   power = 0;
 }
 shooter.shoot(power);
   // shooter.shoot(-.38);;
    

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