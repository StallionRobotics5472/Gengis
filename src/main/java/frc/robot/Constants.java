package frc.robot;

import edu.wpi.first.wpilibj.Counter.Mode;

/**
 * Add your docs here.
 */
public class Constants {

  public static final int PLAYER_ONE_PORT = 0;
    public static final int PLAYER_TWO_PORT = 1;
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int BACK_LEFT_BUTTON = 5;
    public static final int BACK_RIGHT_BUTTON = 6;
    public static final int START_BUTTON = 8;
    public static final int BACK_BUTTON = 7;
    public static final int X_AXIS_BUTTON = 9;
    public static final int Y_AXIS_BUTTON = 10;
    public static final int JOYSTICK_X_AXIS = 0;
    public static final int JOYSTICK_Y_AXIS = 1;
    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;
    public static final int ALTERNATE_JOYSTICK_X_AXIS = 4;
    public static final int ALTERNATE_JOYSTICK_Y_AXIS = 5;
        
    
    public static final double rightMotorOffset = 1;
    public static final double leftMotorOffset = 1;

    public static final double kTurnP = 0.018;
    public static final double kTurnI = 0;
    public static final double kTurnD = 0;

    public static final double kMaxTurnRateDegPerS = 100;
    public static final double kMaxTurnAccelerationDegPerSSquared = 300;

    public static final double kTurnToleranceDeg = 10;
    public static final double kTurnRateToleranceDegPerS = 10; // degrees per second
       
       
       
       
      //Motor ID's 

        public static int rightMotor = 5;
        public static int leftMotor = 2;
        public static int rightFollow = 4;
        public static int rightFollow2 = 6;
        public static int leftFollow = 1;
        public static int leftFollow2 = 3;
        public static int FLY_WHEEL_1 = 7;
        public static int FLY_WHEEL_2 = 8;
        public static int HOOD = 9;
        public static int INTAKE = 11;
        public static int TRANSPORT_1 = 10;
        public static int TRANSPORT_2 = 12;
        public static int BACK_BELT = 13;
        public static int LIFT_1 = 14;
        public static int LIFT_2 = 15;
        public static int LIFT_3 = 16;
        public static int LIFT_4 = 17;

        public static int LIDAR_PORT = 0;
      
        
		    
        public static final double MAX_DISTANCE = 200;
        public static final double MIN_DISTANCE = 100;
        public static final double HOOD_ENCODER = -3;
        public static final double LIDAR_OFFSET = 15;
        






}