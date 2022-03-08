// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;

public class LidarCommand extends CommandBase {
  /** Creates a new LidarCommand. */
  private ShooterSubsystem shooter;

  public LidarCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.lidarSubsystem.getDistance()<= 0)
      shooter.getHoodEncoder();//add or subtract to whatever hood encoder is
    else if(Robot.lidarSubsystem.getDistance()<=0)
      shooter.getHoodEncoder();//add or subtract to whatever hood encoder is
    else if(Robot.lidarSubsystem.getDistance() <= 0)
      shooter.getHoodEncoder();//add or subtract to whatever hood encoder is
    else if(Robot.lidarSubsystem.getDistance() <= 0)
      shooter.getHoodEncoder();//add or subtract to whatever hood encoder is
    else {
    }
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
