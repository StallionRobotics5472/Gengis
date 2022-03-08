package frc.robot.Commands.LiftCommands;

import java.io.Console;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystems.ShooterSubsystem;

public class StopEncoderHoodCommand extends CommandBase {
  /** Creates a new EnconderLiftDeal. */

  private ShooterSubsystem shooter;

  

  private double setPoint;
  public StopEncoderHoodCommand() {
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

  

   shooter.hood.set(0);



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
