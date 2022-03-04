// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous.JacksCoolCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.DriveSubsystem;

public class Forward extends CommandBase {

  private double distance;
	private double angle;
	private boolean givenAngle;
	
	private DriveSubsystem drive;
	private PIDController controller;
  
  /** Creates a new Forward. */
  public Forward(double distance) {
		this.givenAngle = false;
		this.distance = distance;
	}

  public Forward(double distance, double angle) {
		this.givenAngle = true;
		this.distance = distance;
		this.angle = angle;
	}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    drive = Robot.drive;
    drive.leftMaster.getEncoder().setPosition(0);
    drive.rightMaster.getEncoder().setPosition(0);




  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double error = angle - drive.getHeading();
		double output = (drive.getLeftPercent() + drive.getRightPercent()) / 2.0;
		drive.drive(output - 0.1 * error, output + 0.1 * error);
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
