// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import java.io.Console;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;

public class EnconderHoodDeal extends CommandBase {
  /** Creates a new EnconderLiftDeal. */

  private ShooterSubsystem shooter;

  

  private double setPoint;
  public EnconderHoodDeal(double Encoder) {
    // Use addRequirements() here to declare subsystem dependencies.

    setPoint = Encoder;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter = Robot.shooter;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double kP = 0.1031;
    // double setPoint = 25;
     //Robot.cringe;
    // set point = feet

    


   double sensorPosition = (shooter.getHoodEncoder()) * -1;

   double error = setPoint-sensorPosition;

   double outputSpeed = kP * error;

   shooter.hood.set(-outputSpeed);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
