package frc.robot.Subsystems;

import java.util.HashMap;

import frc.robot.Constants;
import frc.robot.Robot;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXSimCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

	public CANSparkMax flyWheel1;
	// public CANSparkMax wheel;
	// public CANSparkMax wheel_slave;
	public CANSparkMax flyWheel2;
	public CANSparkMax hood;
	public VictorSPX intake;
	public CANSparkMax transport1;
	public CANSparkMax transport2;
	public CANSparkMax back_belt;
	public RelativeEncoder hoodEncoder;
	public RelativeEncoder wheelEncoder;
	private double kP = 0.045;
	private double kI = 0;
	private double kD = 0;
	public MotorControllerGroup flywheel;
	public LidarSubsystem lidar;
	public double power;


	public SparkMaxPIDController m_pidController;
	public SparkMaxPIDController m_pidController2; 
	PIDController pid = new PIDController(kP, kI, kD);
	double sensorHood;

	public ShooterSubsystem() {


		
		// public Talon motor = new Talon(1);
		flyWheel1 = new CANSparkMax(Constants.FLY_WHEEL_1, MotorType.kBrushless);
		flyWheel1.setInverted(true);

		flyWheel2 = new CANSparkMax(Constants.FLY_WHEEL_2, MotorType.kBrushless);
		flyWheel2.setInverted(false);
	
		flywheel = new MotorControllerGroup(flyWheel1,flyWheel2);
		hood = new CANSparkMax(Constants.HOOD, MotorType.kBrushless);
		hood.setIdleMode(IdleMode.kBrake);
		intake = new VictorSPX(Constants.INTAKE);
		transport1 = new CANSparkMax(Constants.TRANSPORT_1, MotorType.kBrushless);
		transport2 = new CANSparkMax(Constants.TRANSPORT_2, MotorType.kBrushless);
		hoodEncoder = hood.getEncoder();
		// spin2 = new TalonSRX(22);
		transport1.setInverted(true);
		transport2.setInverted(false);
		lidar = Robot.lidarSubsystem;
		
		
		// spin2.follow(spin);

		
		
		

		flyWheel1.setIdleMode(IdleMode.kCoast);
		flyWheel2.setIdleMode(IdleMode.kCoast);

	
		m_pidController =  flyWheel1.getPIDController();
		m_pidController2 = flyWheel2.getPIDController();

		back_belt = new CANSparkMax(Constants.BACK_BELT, MotorType.kBrushless);

	}

	public void spin(double speed) {
		intake.set(ControlMode.PercentOutput, speed);
	}

	public void mover(double speed) {
		transport1.set(speed);
		transport2.set(speed);
	}

	public void setVelocity(double velocity){
		m_pidController.setReference(velocity, ControlType.kVelocity);
		m_pidController2.setReference(velocity, ControlType.kVelocity);
	}

	public void shoot(double speed) {
		flyWheel1.set(speed);
		flyWheel2.set(speed);
	}

	public void spinback(double speed) {
		back_belt.set(speed);
	}
	public void rampUp(double speed, double TargetVelocity) {
		if((flyWheel1.getEncoder().getVelocity()*-1) < TargetVelocity) {

			shoot(-.5);
		   }
		   else if (((flyWheel1.getEncoder().getVelocity()*-1) > (TargetVelocity + 0.1))){
			shoot(speed);
		   }
		 else {
		
		 }
	}
public void arc (double joe) {
	sensorHood = hood.getEncoder().getPosition();
	hood.set(pid.calculate(sensorHood, -joe));
}
	public double getHoodEncoder() {
		return hood.getEncoder().getPosition();
	}

	public void resetHoodEncoder() {
		hood.getEncoder().setPosition(0);
	}
	public double getShooterVelocity1(){
		return flyWheel1.getEncoder().getVelocity();
	}
	public double getShooterVelocity2(){
		return flyWheel2.getEncoder().getVelocity();
	}
	public void setWheelSpeed() {


	}
	
}
