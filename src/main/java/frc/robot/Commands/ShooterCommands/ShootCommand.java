package frc.robot.Commands.ShooterCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {
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

  private ShooterSubsystem shooter;
  public ShootCommand() {

    
    //addRequirements(Robot.turret);
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //turret.shoot(Constants.TURRET_SPEED);
    shooter = Robot.shooter;
   
    //turret.turret.setIdleMode(IdleMode.kCoast);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //we have to change all of these values
 /*   if(Robot.lidarSubsystem.getDistance()<= 300)
      variable = 15;
    else if(Robot.lidarSubsystem.getDistance()<=440)
      variable = 0.004*(Robot.lidarSubsystem.getDistance()-315) +42;
    else if(Robot.lidarSubsystem.getDistance() <= 600)
      variable = 42.5 - 0.003125* (Robot.lidarSubsystem.getDistance()-440);
    else if(Robot.lidarSubsystem.getDistance() <= 710)
      variable = 43.5 - 0.003125* (Robot.lidarSubsystem.getDistance()-600);
    else
      variable = (1.5/220)*(-600+Robot.lidarSubsystem.getDistance()) + 42;
*/
 //distance = (0.72124+(Robot.lidarSubsystem.getDistance()));
 /*numerator = -4.9*(Math.pow(distance, 2));
 thirtyfivedegrees = ((11*(Math.PI))/36);
 //thirtydegrees = ((Math.PI)/6);
 //twentyfivedegrees = ((13*(Math.PI))/36);
 denominator = 1.7653 - distance*(Math.tan(thirtyfivedegrees));
 firstTerm = Math.sqrt(numerator/denominator);
 inverseSecondTerm = Math.cos(thirtyfivedegrees);
 variable = firstTerm*(1/inverseSecondTerm);  
 */ 
//variable = ((Math.sqrt(-4.9*(Math.pow(distance, 2)))/1.7653 - distance*(Math.tan(thirtyfivedegrees)))*(1/Math.cos(thirtyfivedegrees)));
//variable = (Math.sqrt(-4.9*(Math.pow(distance, 2)))/1.7653 - distance*Math.tan((11*(Math.PI))/36)*(1/Math.cos(((11*(Math.PI))/36))));
//variable =1;    


    

    //shooter.mover(0.35);
    shooter.shoot(-.40);
    //missing hood command
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //turret.turret.setIdleMode(IdleMode.kBrake);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}