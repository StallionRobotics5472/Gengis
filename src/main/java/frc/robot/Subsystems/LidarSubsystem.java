package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class LidarSubsystem extends SubsystemBase {
  /**
   * Creates a new LidarSubsystem.
   */
  private Counter DistanceMaker;
  double cm;
  private double kP;
  ShooterSubsystem shooter;

  public LidarSubsystem() {
    DistanceMaker = new Counter(Constants.LIDAR_PORT);
    // DistanceMaker = Robot.DistanceSensor;
    DistanceMaker.setMaxPeriod(1.0);
    DistanceMaker.setSemiPeriodMode(true);
    DistanceMaker.reset();
    cm = 0;
    kP = 0.02;
    shooter = Robot.shooter;

  }

  public double getDistance(){
    SmartDashboard.putNumber("DISTANCE MAKER GET", DistanceMaker.get());
    if (DistanceMaker.get() < 1) {
      return 0;
    }
    /* getPeriod returns time in seconds. The hardware resolution is microseconds.
     * The LIDAR-Lite unit sends a high signal for 10 microseconds per cm of distance.
     */
    cm = (DistanceMaker.getPeriod() * 1000000.0 / 10.0);// + Constants.LIDAR_OFFSET;
    //SmartDashboard.putNumber("Distance Inches", cm / 2.54);
    return cm;
  }

  public double calcHoodAngle() {
  //  return (getDistance()-Constants.MIN_DISTANCE)/(Constants.MAX_DISTANCE - Constants.MIN_DISTANCE) * 10;
  if (getDistance() > 50) {
    return 2;
  }
  else if (getDistance() > 100) {
    return 4;
  }
  else if (getDistance() > 150) {
    return 6;
  }
  else if (getDistance() > 200) {
    return 8;
  }
  else if (getDistance() > 215) {
    return 10;
  }
  else {
    return 0;
  }

  }

  public boolean returnsTrue(){
    return true;
  }

  public void setHoodAngle()  {
    double setPoint = (calcHoodAngle()*Constants.HOOD_ENCODER);
    //set point = feet
            double sensorPosition = (Robot.shooter.hoodEncoder.getPosition())*-1;
    
            double error = setPoint - sensorPosition;

            double outputSpeed = kP * error;
            
    
            shooter.hood.set(outputSpeed);

    }

    

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
