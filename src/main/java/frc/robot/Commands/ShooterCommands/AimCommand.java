// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.Commands.DriveCommands.DriveCommand;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class AimCommand extends CommandBase {
  /** Creates a new AimCommand. */
  ShooterSubsystem shooter = new ShooterSubsystem();
  HoodCommand25 hood25 = new HoodCommand25();
  HoodCommand30 hood30 = new HoodCommand30();
  HoodCommand35 hood35 = new HoodCommand35();
  DriveCommand drivecmd = new DriveCommand();
  DriveSubsystem drive = new DriveSubsystem();
  ShootCommand shootcmd = new ShootCommand();
  boolean isFinished = false;
  Limelight limelight = new Limelight();
  double turn = limelight.getVerticalAngle()*-0.01;
  boolean isLinedUp;

  public AimCommand() {
    // Use addRequirements() here to declare subsystem dependencies
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(){
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    if(limelight.getVerticalAngle() < 1e-4){
      isFinished = true;
    }
    else{

      if (Math.abs(limelight.getVerticalAngle()) < 5)
        turn*=3;
      else   if(Math.abs(limelight.getVerticalAngle()) < 4)
        turn*=4;
      else   if(Math.abs(limelight.getVerticalAngle()) < 2.5)
        turn*=5;
      else   if(Math.abs(limelight.getVerticalAngle()) < 1)
        turn*=6;
      else{
        turn*=2;
      }
    }

    drive.rotate(turn);
    isFinished = false;

    //call hood angle method here; create hood angle obj first tho
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(interrupted == true){
      isFinished = true;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
