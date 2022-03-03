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
  double m;

  public LidarSubsystem() {
    DistanceMaker = new Counter(2);
    // DistanceMaker = Robot.DistanceSensor;
    DistanceMaker.setMaxPeriod(1.0);
    DistanceMaker.setSemiPeriodMode(true);
    DistanceMaker.reset();
    m = 0;

  }

  public double getDistance(){
    if (DistanceMaker.get() < 1) {
      return 0;
    }
    /* getPeriod returns time in seconds. The hardware resolution is microseconds.
     * The LIDAR-Lite unit sends a high signal for 10 microseconds per cm of distance.
     */
    m = (DistanceMaker.getPeriod() * 1000000.0 / 10.0);// + Constants.LIDAR_OFFSET;
    //SmartDashboard.putNumber("Distance Inches", cm / 2.54);
    return m;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}