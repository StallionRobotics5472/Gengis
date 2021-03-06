// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.LiftSubsystem;

public class StopLiftFlipCommand extends CommandBase {
  /** Creates a new StopLiftFlipCommand. */
  private LiftSubsystem lift;
  public StopLiftFlipCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lift = Robot.lift;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lift.flip(0.02);
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
