package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Autonomous.RunAuto;
import frc.robot.Commands.DriveCommands.DriveCommand;
import frc.robot.Commands.ShooterCommands.ShootCommand;
import frc.robot.Commands.DriveCommands.StopTurretAimCommand;
import frc.robot.Commands.DriveCommands.TurretAimCommand;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.LidarSubsystem;
import frc.robot.Subsystems.LiftSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;


public class Robot extends TimedRobot {

  public static Controls controls;
  public static DriveSubsystem drive;
  public static Limelight limelight;
  public static ShooterSubsystem shooter;
  public static LiftSubsystem lift;
  public static LidarSubsystem lidarSubsystem;
  public SendableChooser autoChooser;
    //public static Cameras cameras = new Cameras();

  //public static Drivetrain drive;

  @Override
  public void robotInit() {

    controls = new Controls();
    drive = new DriveSubsystem();
    limelight = new Limelight();
    shooter = new ShooterSubsystem();
    lift = new LiftSubsystem();
    lidarSubsystem = new LidarSubsystem();
    autoChooser = new SendableChooser<CommandGroupBase>();
    shooter.resetHoodEncoder();
  }

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
       
  }

  @Override
  public void disabledPeriodic() {
    
  }

 
  @Override
  public void autonomousInit() {
  
    CommandGroupBase BallAuto = new RunAuto();
    BallAuto.schedule();
   
    
    
  }


  @Override
  public void autonomousPeriodic() {

  }

  @Override
public void teleopInit() {
DriveCommand drive1 = new DriveCommand();
drive1.schedule();

shooter.rotate0();

//shooter.rotate(0.5);
//  TurretAimCommand drive2 = new TurretAimCommand();
// drive2.schedule();
// StopTurretAimCommand drive3 = new StopTurretAimCommand();
//  drive3.schedule();

 
// IntakeCommand intake = new IntakeCommand();
// intake.schedule();


// DumpCommand dump = new DumpCommand();
//  dump.schedule();
// TarmacCommand tarmac = new TarmacCommand();
//  tarmac.schedule();
// ShootCommand shoot = new ShootCommand();
//     shoot.schedule();


  }

  
  @Override
  public void teleopPeriodic() {  

    SmartDashboard.putNumber("hoodEncoder", shooter.getHoodEncoder());
    SmartDashboard.putNumber("Turret Encoder Value", Robot.shooter.hood.getEncoder().getPosition());
    SmartDashboard.putNumber("LIDAR - in robot class ", Robot.lidarSubsystem.getDistance());
      // shooter.intake();

  // DriveCommand drive1 = new DriveCommand();
  // drive1.execute();

//prob wrong




    //  TurretAimCommand drive2 = new TurretAimCommand();
    //   drive2.execute();

      // StopTurretAimCommand drive3 = new StopTurretAimCommand();
      //   drive3.execute();
    
  //  IntakeCommand intake = new IntakeCommand();
  //      intake.execute();

    
  //     DumpCommand dump = new DumpCommand();
  //     dump.execute();
  //     TarmacCommand tarmac = new TarmacCommand();
  //     tarmac.execute();
  //       ShootCommand shoot = new ShootCommand();
  //       shoot.execute();
  //       StopShootCommand noShoot = new StopShootCommand();
  //      noShoot.execute();
       
  }

 
  
  @Override
  public void testPeriodic() {
  }
}