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

  public LidarSubsystem() {
    DistanceMaker = new Counter(2);
    // DistanceMaker = Robot.DistanceSensor;
    DistanceMaker.setMaxPeriod(1.0);
    DistanceMaker.setSemiPeriodMode(true);
    DistanceMaker.reset();
    cm = 0;
    kP = 0.09;
    
    

  }

  public double getDistance(){
    if (DistanceMaker.get() < 1) {
      return 0;
    }
    /* getPeriod returns time in seconds. The hardware resolution is microseconds.
     * The LIDAR-Lite unit sends a high signal for 10 microseconds per cm of distance.
     */
    cm = (DistanceMaker.getPeriod() * 100000000.0 / 10.0);// + Constants.LIDAR_OFFSET;
    //SmartDashboard.putNumber("Distance Inches", cm / 2.54);
    return cm;
  }

  public double calcHoodAngle() {
    return (getDistance()-Constants.MIN_DISTANCE)/(Constants.MAX_DISTANCE - Constants.MIN_DISTANCE) * 10;

  }

  public void setHoodAngle()  {
    double setPoint = (calcHoodAngle()*Constants.HOOD_ENCODER);
    //set point = feet
            double sensorPosition = (Robot.shooter.hoodEncoder.getPosition())*-1;
    
            double error = setPoint - sensorPosition;

            double outputSpeed = kP * error;
            
    
            Robot.shooter.hood.set(outputSpeed);

    }

    

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
