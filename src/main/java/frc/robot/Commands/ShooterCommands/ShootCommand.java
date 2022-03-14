package frc.robot.Commands.ShooterCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.LidarSubsystem;
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
  private double power;
  private LidarSubsystem lidar;
  private double kP;

  private ShooterSubsystem shooter;

  public ShootCommand() {

    // addRequirements(Robot.turret);
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // turret.shoot(Constants.TURRET_SPEED);
    shooter = Robot.shooter;
    lidar = Robot.lidarSubsystem;
    kP = 0.032;

    // turret.turret.setIdleMode(IdleMode.kCoast);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // we have to change all of these values
    /*
     * if(Robot.lidarSubsystem.getDistance()<= 300)
     * variable = 15;
     * else if(Robot.lidarSubsystem.getDistance()<=440)
     * variable = 0.004*(Robot.lidarSubsystem.getDistance()-315) +42;
     * else if(Robot.lidarSubsystem.getDistance() <= 600)
     * variable = 42.5 - 0.003125* (Robot.lidarSubsystem.getDistance()-440);
     * else if(Robot.lidarSubsystem.getDistance() <= 710)
     * variable = 43.5 - 0.003125* (Robot.lidarSubsystem.getDistance()-600);
     * else
     * variable = (1.5/220)*(-600+Robot.lidarSubsystem.getDistance()) + 42;
     */
    // distance = (0.72124+(Robot.lidarSubsystem.getDistance()));
    /*
     * numerator = -4.9*(Math.pow(distance, 2));
     * thirtyfivedegrees = ((11*(Math.PI))/36);
     * //thirtydegrees = ((Math.PI)/6);
     * //twentyfivedegrees = ((13*(Math.PI))/36);
     * denominator = 1.7653 - distance*(Math.tan(thirtyfivedegrees));
     * firstTerm = Math.sqrt(numerator/denominator);
     * inverseSecondTerm = Math.cos(thirtyfivedegrees);
     * variable = firstTerm*(1/inverseSecondTerm);
     */
    // variable = ((Math.sqrt(-4.9*(Math.pow(distance, 2)))/1.7653 -
    // distance*(Math.tan(thirtyfivedegrees)))*(1/Math.cos(thirtyfivedegrees)));
    // variable = (Math.sqrt(-4.9*(Math.pow(distance, 2)))/1.7653 -
    // distance*Math.tan((11*(Math.PI))/36)*(1/Math.cos(((11*(Math.PI))/36))));
    // variable =1;

    // Lidar Value
    //double lidarValue = lidar.getDistance();


    // if (lidarValue < 55) {

    //   power = -0.34;
    //   double setPoint = 0;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else if ((lidarValue < 80) && (lidarValue > 55.1)) {
    //   power = -0.36;
    //   double setPoint = 0;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else if ((lidarValue < 105) && (lidarValue > 80.1)) {
    //   power = -0.37;
    //   double setPoint = 0;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else if ((lidarValue < 130) && (lidarValue > 105.1)) {
    //   power = -0.385;
    //   double setPoint = 7.83;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else if ((lidarValue < 145) && (lidarValue > 130.1)) {
    //   power = -0.4;
    //   double setPoint = 9.7;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double kP2 = 0.03456;
    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP2 * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else if ((lidarValue < 165) && (lidarValue > 145.1)) {
    //   power = -0.4;
    //   double setPoint = 11;
    //   // set point = feet
    //   double sensorPosition = (Robot.shooter.hoodEncoder.getPosition() * -1);

    //   double kP2 = 0.03456;
    //   double error = setPoint - sensorPosition;

    //   double outputSpeed = kP2 * error;

    //   Robot.shooter.hood.set(-outputSpeed);
    // } else {
    //   power = -0.42;
    // }

    // shooter.mover(0.36);
    shooter.shoot(-.362);
    // shooter.shoot(power);
    // missing hood command
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