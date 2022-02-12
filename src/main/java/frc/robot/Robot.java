package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.DumpCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.ShootCommand;
import frc.robot.Commands.StopShootCommand;
import frc.robot.Commands.StopTurretAimCommand;
import frc.robot.Commands.TarmacCommand;
import frc.robot.Commands.TurretAimCommand;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.LidarSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;


public class Robot extends TimedRobot {

  public static Controls controls = new Controls();
  public static DriveSubsystem drive = new DriveSubsystem();
  public static Limelight limelight = new Limelight();
  public static ShooterSubsystem shooter = new ShooterSubsystem();
  public static LidarSubsystem lidarSubsystem = new LidarSubsystem();
  //public static Cameras cameras = new Cameras();

  //public static Drivetrain drive;

  @Override
  public void robotInit() {

    //controls = new Controls();
    ///drivetrain = new Drivetrain();

  }


  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().disable();
  }

  @Override
  public void disabledPeriodic() {
 
  }

 
  @Override
  public void autonomousInit() {
  

  }


  @Override
  public void autonomousPeriodic() {

  }

  @Override
public void teleopInit() {
//  DriveCommand drive1 = new DriveCommand();
//  drive1.schedule();
//  TurretAimCommand drive2 = new TurretAimCommand();
//  drive2.schedule();
//  StopTurretAimCommand drive3 = new StopTurretAimCommand();
//  drive3.execute();
//  IntakeCommand intake = new IntakeCommand();
//  intake.schedule();
//DumpCommand dump = new DumpCommand();
//  dump.schedule();
//TarmacCommand tarmac = new TarmacCommand();
//  tarmac.schedule();
//ShootCommand shoot = new ShootCommand();
    //shoot.schedule();



  }

  
  @Override
  public void teleopPeriodic() {  
    DriveCommand drive1 = new DriveCommand();
    drive1.execute();
    /* TurretAimCommand drive2 = new TurretAimCommand();
      drive2.execute();
      StopTurretAimCommand drive3 = new StopTurretAimCommand();
        drive3.execute();
        
      IntakeCommand intake = new IntakeCommand();
      intake.execute();
      DumpCommand dump = new DumpCommand();
      dump.execute();
      TarmacCommand tarmac = new TarmacCommand();
      tarmac.execute();
        ShootCommand shoot = new ShootCommand();
        shoot.execute();
        StopShootCommand noShoot = new StopShootCommand();
       noShoot.execute();
       */
  }

 
  
  @Override
  public void testPeriodic() {
  }
}