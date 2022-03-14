package frc.robot.Commands.DriveCommands;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controls;
import frc.robot.Robot;

public class DriveCommand extends CommandBase {
  
  Controls controls = Robot.controls;
  public DriveCommand() {
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    //DRIVER.drive.tank(OI.getX, OI.getY);

    double y = controls.getY();
    double x = controls.getX();

    if(Math.abs(x)<0.1)
      x=0;
    if(Math.abs(y)<0.1)
      y=0;

    // Robot.drive.leftMaster.set(y*.45 - x*.2);
    // Robot.drive.rightMaster.set(y*.45 + x*.2);
    Robot.drive.leftMaster.set(y*0.7 - x*0.3);
    Robot.drive.rightMaster.set(y*0.7 + x*0.3);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
public boolean isFinished() {
    return false;
  }

}