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
	public CANSparkMax transport1;
	public CANSparkMax transport2;
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
		transport1 = new CANSparkMax(Constants.TRANSPORT_1, MotorType.kBrushless);
		transport2 = new CANSparkMax(Constants.TRANSPORT_2, MotorType.kBrushless);
		// spin2 = new TalonSRX(22);
		 transport2.setInverted(true);
		// spin2.follow(spin);

	    flyWheel1.setIdleMode(IdleMode.kCoast);
        flyWheel2.setIdleMode(IdleMode.kCoast);
        
		
	}

	public void spin(double speed){
		intake.set(ControlMode.PercentOutput, speed);
	}
	public void mover(double speed){
		transport1.set(speed);
		transport2.set(speed);
	}

	public void shoot(double speed){
		flyWheel1.set(speed);
		flyWheel2.set(speed);	
	}
public void rotate(double speed){

	hood.set(speed);
}
}

	



	

	
