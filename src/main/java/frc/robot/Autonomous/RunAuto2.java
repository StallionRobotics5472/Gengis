/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.Autonomous.JacksCoolCommands.AutoDriveEncoder;
import frc.robot.Autonomous.JacksCoolCommands.AutoDriveEncoderIntake;
import frc.robot.Autonomous.JacksCoolCommands.AutoDriveEncoderReset;
import frc.robot.Autonomous.JacksCoolCommands.Forward;
import frc.robot.Commands.TurnToAngleProfiled;
import frc.robot.Commands.DriveCommands.TurretAimCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class RunAuto2 extends SequentialCommandGroup {
  /**
   * Creates a new RunTrenchAuto.
   */
  public RunAuto2() {
    // Add your commands in the super() call, e.g.

    // super(new AutoClimb(), new AutoDrive(), new AutoIntake(), new WaitCommand(1),
    // new Auto180(), new WaitCommand(1), new AutoShoot2(), new AutoTransport2() );
    // super(new ClimbAuto(), new ClimbAuto2(), new ClimbAuto3());

    // super (new AutoClimb(), new AutoShoot(), new AutoTransport(),new
    // WaitCommand(2), new AutoDriveBack());

    // super(new Auto180());

    // super(new TurnToAngleProfiled(90 + 2.7, Robot.drive));

    // super(new AutoDriveEncoder(-35), new TurnToAngleProfiled(-(20),
    // Robot.drive));
    // super(new AutoDriveEncoder(-35), new TurnToAngleProfiled(-(25), Robot.drive),
    // new AutoDriveEncoderIntake(-55));

   // super(new AutoClimb(), new TurnToAngleProfiled(20, Robot.drive), new AutoDriveEncoderIntake(-30), new AutoDriveEncoder(0), new TurnToAngleProfiled(195, Robot.drive), new AutoShoot(), new AutoTransport(), new AutoDriveEncoderReset(0), new TurnToAngleProfiled(108, Robot.drive), new AutoDriveEncoderReset(0), new AutoDriveEncoderIntake(-42), new TurnToAngleProfiled(-120, Robot.drive), new AutoDriveEncoderReset(0), new AutoDriveEncoder(-25), new AutoShoot2(), new AutoTransport());
    //super(new AutoClimb(), new TurnToAngleProfiled(20, Robot.drive), new AutoDriveEncoderIntake(-25), new TurnToAngleProfiled(195, Robot.drive), new AutoShoot(), new AutoTransport(), new AutoDriveEncoderReset(0), new TurnToAngleProfiled(132, Robot.drive), new AutoDriveEncoderReset(0), new AutoDriveEncoderIntake(-48), new TurnToAngleProfiled(230, Robot.drive), new AutoShoot2(), new AutoTransport());
   //super(new AutoClimb(), new TurnToAngleProfiled(20, Robot.drive), new AutoDriveEncoderIntake(-25), new TurnToAngleProfiled(182, Robot.drive), new AutoShoot(), new AutoTransport());
   super(new AutoDriveEncoder(25), new AutoClimb(), new AutoShoot(), new AutoTransport(), new WaitCommand(2), new AutoDriveEncoder(40));
   //super(new AutoClimb());
    // super(new TurnToAngleProfiled(20, Robot.drive));
    // super(new AutoClimb(), new AutoDriveEncoderStart());
    // super(new PIDLiftExtendCommand());
  }
}