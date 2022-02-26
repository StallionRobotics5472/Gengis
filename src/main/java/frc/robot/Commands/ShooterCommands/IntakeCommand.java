/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;


public class IntakeCommand extends CommandBase {
  /**
   * Creates a new BallChamberIntakeCommand.
   */
  private boolean isFinished;
  private ShooterSubsystem shooter;
  public IntakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(Robot.ballChamber);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isFinished = false;
    // Robot.ballChamber.spinAll(Constants.BallChamberSpeed);
    shooter = Robot.shooter;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.spin(.75);
   
}
    
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}