// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LidarSubsystem extends SubsystemBase {
  /** Creates a new LidarSubsystem. */
  private Counter DistanceMaker;
  double m;
  public LidarSubsystem() {
  DistanceMaker = new Counter(Constants.LIDAR_PORT);
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
  m = (DistanceMaker.getPeriod() * 1000000.0 / 1000.0);// + Constants.LIDAR_OFFSET;
  //SmartDashboard.putNumber("Distance Inches", cm / 2.54);
  return m;
}

@Override
public void periodic() {
  // This method will be called once per scheduler run
}
}