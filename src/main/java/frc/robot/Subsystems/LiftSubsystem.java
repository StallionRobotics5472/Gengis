// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
  /** Creates a new LiftSubsystem. */
  public CANSparkMax lift1 = new CANSparkMax(Constants.LIFT_1, MotorType.kBrushless);
  public CANSparkMax lift2 = new CANSparkMax(Constants.LIFT_2, MotorType.kBrushless);
  public CANSparkMax lift3 = new CANSparkMax(Constants.LIFT_3, MotorType.kBrushless);
  public CANSparkMax lift4 = new CANSparkMax(Constants.LIFT_4, MotorType.kBrushless);
  public LiftSubsystem() {

    
  }
  public void extend(double speed){
    lift1.set(speed);
    lift2.set(speed);
  }
  public void flip(double speed){
    lift3.set(speed);
  }
  public void grab(double speed){
    lift4.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
