package frc.robot.Autonomous.JacksCoolCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveEncoderIntake extends CommandBase {

    private boolean completed;
    private double starttime;

    private double kP = 0.018;
    private double kI = 0;
    private double kD = 0;

    PIDController pid = new PIDController(kP, kI, kD);

    public void initialize() {
        starttime = Timer.getFPGATimestamp();

    }

    double setPoint = 0;

    public AutoDriveEncoderIntake(double Encoder) {
        setPoint = Encoder;

    }

    public void execute() {
        // increased by 42.5 inch

        // set point = feet
        // double sensorPosition = Robot.drive.rightMaster.getEncoder().getPosition();
        double sensorRight = Robot.drive.rightMaster.getEncoder().getPosition() * 0.98;
        double sensorLeft = Robot.drive.leftMaster.getEncoder().getPosition() * 1;

        Robot.shooter.spin(0.75);

        Robot.drive.rightMaster.set(pid.calculate(sensorRight, setPoint));
        Robot.drive.leftMaster.set(pid.calculate(sensorLeft, setPoint));

        pid.setTolerance(1);

        SmartDashboard.putNumber("rightMaster_Encoder ProcessVariable", Robot.drive.rightMaster_Encoder.getPosition());

        SmartDashboard.putBoolean("Is finished", false);
        if (pid.atSetpoint()) {

            completed = true;
            Robot.shooter.spin(0);
            SmartDashboard.putBoolean("Is finished", true);
        }

    }

    @Override
    public boolean isFinished() {
        return completed;
    }

}