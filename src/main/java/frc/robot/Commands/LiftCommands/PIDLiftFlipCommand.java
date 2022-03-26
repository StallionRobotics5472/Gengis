// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.LiftSubsystem;

public class PIDLiftFlipCommand extends CommandBase {
  /** Creates a new LiftFlipCommand. */
  private LiftSubsystem lift;
  private double kP = 0.08;
  private double kI = 0.00;
  private double kD = 0.00;
  private PIDController pid = new PIDController(kP, kI, kD);
  public PIDLiftFlipCommand() {
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
   // lift.flip(-0.09);
   double setPoint = -10;

    double sensorPosition = (Robot.lift.lift3.getEncoder().getPosition());

    Robot.lift.lift3.set(pid.calculate( sensorPosition, setPoint ));
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
