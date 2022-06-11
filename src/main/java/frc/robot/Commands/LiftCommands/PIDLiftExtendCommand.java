// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LiftCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.LiftSubsystem;

public class PIDLiftExtendCommand extends CommandBase {
  /** Creates a new LiftExtendCommand. */
  private LiftSubsystem lift;
  private double kP = 0.09;
  private double kI = 0.00;
  private double kD = 0.00;
  private PIDController pid = new PIDController(kP, kI, kD);
  private boolean joeseyes;

  public PIDLiftExtendCommand() {
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
  /*  if(lift.getLiftSensor()){
      lift.extend(0);
    }
    else {
      double setPoint = -21;
*/
  double setPoint = -21;
    double sensorPosition = (Robot.lift.lift2.getEncoder().getPosition());

    Robot.lift.lift2.set(pid.calculate( sensorPosition, setPoint ));
    
    
  
   /* double setPoint = -21;

    double sensorPosition = (Robot.lift.lift1.getEncoder().getPosition());

    Robot.lift.lift1.set(pid.calculate( sensorPosition, setPoint ));
    */
   
   
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
