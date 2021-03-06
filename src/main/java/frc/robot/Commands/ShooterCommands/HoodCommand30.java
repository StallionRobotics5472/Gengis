// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;

public class HoodCommand30 extends CommandBase {
  /** Creates a new HoodCommand. */
  ShooterSubsystem shooter;
  public HoodCommand30() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    shooter = Robot.shooter;
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   // shooter.rotate25(0.15);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
