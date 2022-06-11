package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Autonomous.RunAuto;
import frc.robot.Autonomous.RunAuto2;
import frc.robot.Autonomous.JacksCoolCommands.TwoBallAuto;
import frc.robot.Commands.DriveCommands.DriveCommand;
import frc.robot.Commands.ShooterCommands.ShootCommand;
import frc.robot.Commands.DriveCommands.StopTurretAimCommand;
import frc.robot.Commands.DriveCommands.TurretAimCommand;
import frc.robot.Commands.LiftCommands.EnconderHoodDeal;
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
  public static double cringe;
  public static EnconderHoodDeal encoderHood;
  public static ShootCommand shoot;

  // public static Cameras cameras = new Cameras();

  // public static Drivetrain drive;

  @Override
  public void robotInit() {

    controls = new Controls();
    drive = new DriveSubsystem();
    limelight = new Limelight();
    shooter = new ShooterSubsystem();
    lift = new LiftSubsystem();
    lidarSubsystem = new LidarSubsystem();
    // encoderHood = new EnconderHoodDeal();
    autoChooser = new SendableChooser<CommandGroupBase>();
    
    shooter.hood.getEncoder().setPosition(0);
    drive.rightMaster.getEncoder().setPosition(0);
    drive.leftMaster.getEncoder().setPosition(0);
    lift.lift1.getEncoder().setPosition(0);
    lift.lift2.getEncoder().setPosition(0);
    lift.lift3.getEncoder().setPosition(0);
    lift.lift4.getEncoder().setPosition(0);
    shoot = new ShootCommand();
    CameraServer.startAutomaticCapture();

  

    drive.navx.reset();
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
    drive.rightMaster.getEncoder().setPosition(0);
    drive.leftMaster.getEncoder().setPosition(0);
    shooter.hood.getEncoder().setPosition(0);
    drive.resetEncoder();
    drive.navx.reset();
    

    CommandGroupBase BallAuto = new RunAuto2();
    BallAuto.schedule();
   /* autoChooser.setDefaultOption("Three Ball Auto", Three_Ball_Auto);
    autoChooser.addOption("Two Ball Auto", Two_Ball_Auto);
    SmartDashboard.putData(autoChooser);
    */
    }
    
  
    

  

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    DriveCommand drive1 = new DriveCommand();
    drive1.schedule();

    // EnconderHoodDeal encoderHood = new EnconderHoodDeal();

      // shooter.rotate0();

      // shooter.rotate(0.5);
      // TurretAimCommand drive2 = new TurretAimCommand();
      // drive2.schedule();
      // StopTurretAimCommand drive3 = new StopTurretAimCommand();
      // drive3.schedule();

      // IntakeCommand intake = new IntakeCommand();
      // intake.schedule();

      // DumpCommand dump = new DumpCommand();
      // dump.schedule();
      // TarmacCommand tarmac = new TarmacCommand();
      // tarmac.schedule();
      // ShootCommand shoot = new ShootCommand();
      // shoot.schedule();

  }

  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("hoodEncoder", shooter.getHoodEncoder());
    SmartDashboard.putNumber("Turret Encoder Value", Robot.shooter.hood.getEncoder().getPosition());
    SmartDashboard.putNumber("LIDAR - in robot class ", Robot.lidarSubsystem.getDistance());

    SmartDashboard.putString("Gyro Heading", Robot.drive.navx.getRotation2d().toString());
    SmartDashboard.putNumber("Motor Velocity", Robot.shooter.flyWheel1.getBusVoltage());
    SmartDashboard.putNumber("Motor Velocity 2", Robot.shooter.flyWheel2.getBusVoltage());
    SmartDashboard.putNumber("lift1_Encoder ProcessVariable", lift.lift1_Encoder.getPosition());
    SmartDashboard.putNumber("lift2_Encoder ProcessVariable", lift.lift2_Encoder.getPosition());
    SmartDashboard.putNumber("lift3_Encoder ProcessVariable", lift.lift3_Encoder.getPosition());
    SmartDashboard.putNumber("lift4_Encoder ProcessVariable", lift.lift4_Encoder.getPosition());
    SmartDashboard.putNumber("Hood Position", shooter.hoodEncoder.getPosition());
    SmartDashboard.putNumber("ShooterVelocity1", shooter.getShooterVelocity1());
    SmartDashboard.putNumber("ShooterVelocity2", shooter.getShooterVelocity2());
    SmartDashboard.putNumber("rightMaster_Encoder ProcessVariable", drive.rightMaster_Encoder.getPosition());
    SmartDashboard.putNumber("leftMaster_Encoder ProcessVariable", drive.leftMaster_Encoder.getPosition());
    SmartDashboard.putNumber("POWER", shooter.flyWheel1.getAppliedOutput());

    SmartDashboard.putNumber("Shooter Hood Position", shooter.hoodEncoder.getPosition());
    SmartDashboard.putNumber("tx", limelight.getHorizontalAngle());
    SmartDashboard.putNumber("ty", limelight.getVerticalAngle());
    


    

    // cringe = SmartDashboard.getNumber("hood position set", 0);

  }

  @Override
  public void testPeriodic() {
  }
}