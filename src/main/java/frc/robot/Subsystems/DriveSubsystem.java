// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class DriveSubsystem extends SubsystemBase {


  //  public WPI_VictorSPX rightMaster = new WPI_VictorSPX(Constants.rightMotor);
  //  public WPI_VictorSPX leftMaster = new WPI_VictorSPX(Constants.leftMotor);
  //  public PWMVictorSPX leftMaster = new PWMVictorSPX(0);
  //  public PWMVictorSPX rightMaster = new PWMVictorSPX(1);
      public CANSparkMax rightMaster = new CANSparkMax(Constants.rightMotor, MotorType.kBrushless);
      public CANSparkMax rightFollower = new CANSparkMax(Constants.rightFollow, MotorType.kBrushless);
      public CANSparkMax rightFollower2 = new CANSparkMax(Constants.rightFollow2, MotorType.kBrushless);

  //Left Motors
      public CANSparkMax leftMaster = new CANSparkMax(Constants.leftMotor, MotorType.kBrushless);
      public CANSparkMax leftFollower = new CANSparkMax(Constants.leftFollow, MotorType.kBrushless);
      public CANSparkMax leftFollower2 = new CANSparkMax(Constants.leftFollow2, MotorType.kBrushless);



    public DriveSubsystem(){

        // rightFollower.follow(rightMaster);
        // leftFollower.follow(leftMaster);
        //drive = new DifferentialDrive(leftMaster, rightMaster);
        leftMaster.setInverted(true);
    leftFollower.setInverted(true);
    leftFollower2.setInverted(true);
     rightFollower.follow(rightMaster);
     leftFollower.follow(leftMaster);
     rightFollower2.follow(rightMaster);
     leftFollower2.follow(leftMaster);
      }
      public void rotate(double speed){
        leftMaster.set(-speed*0.25);
        rightMaster.set(speed*.25);

      }


      public void arcade(double move, double turn){
        //drive.arcadeDrive(move, turn);
      }
    
      public void tank(double left, double right)
      {
        //drive.tankDrive(left, right);
      }
}
