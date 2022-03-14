// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.LiftSubsystem;

public class PIDLiftExtendCommand extends CommandBase {
  /** Creates a new LiftExtendCommand. */
  private LiftSubsystem lift;
  private double kP;

  public PIDLiftExtendCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lift = Robot.lift;
    kP = 0.09;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double setPoint = 23.6;

    double sensorPosition = (Robot.lift.lift1.getEncoder().getPosition()) * -1;

    double error = setPoint - sensorPosition;

    double outputSpeed = kP * error;

    Robot.lift.extend(-outputSpeed);

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
