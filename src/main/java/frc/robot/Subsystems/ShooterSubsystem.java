package frc.robot.Subsystems;

import java.util.HashMap;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXSimCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

	public CANSparkMax flyWheel1;
	// public CANSparkMax wheel;
	// public CANSparkMax wheel_slave;
	public CANSparkMax flyWheel2;
	public CANSparkMax hood;
	public VictorSPX intake;
	public CANSparkMax transport;
	//public double kp;
	//public double kI;
	//public double kD;
	//public double kIz;
	//public double kFF;
	//public double kMaxOutput,kMinOutput;
	//public double kV;
	//public CANPIDController TurretPIDControl;

	public ShooterSubsystem() {

	//	kp = 0.4;
	//	kI = 1e-4;
	//	kD = 1;
	//	kIz = 0;
	//	kFF = 0;
	//	kV = 1;
	//	kMaxOutput = 0.2;
	//	kMinOutput = -0.2;
	  
		

		
	  
	  
		//public Talon motor = new Talon(1);
		flyWheel1 = new CANSparkMax(Constants.FLY_WHEEL_1, MotorType.kBrushless);
		flyWheel1.setInverted(false);

		
		
		flyWheel2 = new CANSparkMax(Constants.FLY_WHEEL_2, MotorType.kBrushless);
        flyWheel2.setInverted(true);
        hood = new CANSparkMax(Constants.HOOD, MotorType.kBrushless);
		intake = new VictorSPX(Constants.INTAKE);
		transport = new CANSparkMax(Constants.TRANSPORT, MotorType.kBrushless);
		// spin2 = new TalonSRX(22);
		// spin2.setInverted(true);
		// spin2.follow(spin);

	    flyWheel1.setIdleMode(IdleMode.kCoast);
        flyWheel2.setIdleMode(IdleMode.kCoast);
        
		// spin2.setNeutralMode(NeutralMode.Coast);

		// wheel = new CANSparkMax(Constants.SHOOTER_WHEEL_MOTOR, MotorType.kBrushless);
		// wheel.setIdleMode(IdleMode.kCoast);
		// wheel_slave = new CANSparkMax(Constants.SHOOTER_WHEEL_MOTOR2, MotorType.kBrushless);
		// wheel_slave.follow(wheel);
		// wheel_slave.setInverted(true);
		// wheel.setInverted(true);
		// // wheel_slave.setSmartCurrentLimit(30);
		// wheel.setIdleMode(IdleMode.kCoast);
		// wheel.setSmartCurrentLimit(30);
		//turret = new CANSparkMax(Constants.TURRET_MOTOR, MotorType.kBrushless);
		//turret.setIdleMode(IdleMode.kBrake);
		// turret.setSmartCurrentLimit(30);
	//	TurretPIDControl = turret.getPIDController();
		//spin.getEncoder().setPosition(0);

	//	TurretPIDControl.setP(kp);
	//	TurretPIDControl.setI(kI);
	//	TurretPIDControl.setD(kD);
	//	TurretPIDControl.setIZone(kIz);
	//	TurretPIDControl.setFF(kFF);
	//	TurretPIDControl.setOutputRange(kMinOutput, kMaxOutput);
		
	}

	// public void TurretSetPosition(double EncoderValue){
	// 	TurretPIDControl.setReference(EncoderValue, ControlType.kPosition);
	
	//   }

	public void spin(double speed){
		intake.set(ControlMode.PercentOutput, speed);
	}
	public void mover(double speed){
		transport.set(speed);
	}

	public void shoot(double speed){
		flyWheel1.set(speed);
		flyWheel2.set(speed);	
	}

	public double getShooterSpeed()
	{
		// return spin.getMotorOutputPercent();
	//	return spin.getEncoder().getVelocity();
	return 0;
	}

	public double getTurretEncoder(){
	//	return turret.getEncoder().getPosition();
	return 0;
	}

	public void resetTurretEncoder(){
	//	turret.getEncoder().setPosition(0);
	}

	public void spinFront(double turretSpeed) {
	}

	public void spinBack(double spinSpeed) {
	}

	public void spinPo(double d) {
	//	beltSpin.set(d);
	}

	public void TurretPIDControl(double EncoderValue) {
	//	TurretPIDControl.setReference(EncoderValue, ControlType.kPosition);
	}

}