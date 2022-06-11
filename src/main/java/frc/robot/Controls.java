package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.ShooterCommands.BackBeltCommand;
import frc.robot.Commands.ShooterCommands.DumpCommand;
import frc.robot.Commands.ShooterCommands.HoodCommand25;
import frc.robot.Commands.ShooterCommands.HoodCommand30;
import frc.robot.Commands.ShooterCommands.HoodCommand35;
import frc.robot.Commands.ShooterCommands.IntakeCommand;
import frc.robot.Commands.ShooterCommands.MaxCommand;
import frc.robot.Commands.ShooterCommands.ReverseIntake;
import frc.robot.Commands.LiftCommands.BackLiftExtendCommand;
import frc.robot.Commands.LiftCommands.BackLiftFlipCommand;
import frc.robot.Commands.LiftCommands.BackLiftGrabCommand;
import frc.robot.Commands.LiftCommands.EnconderHoodDeal;
import frc.robot.Commands.LiftCommands.LiftExtendCommand;
import frc.robot.Commands.LiftCommands.LiftFlipCommand;
import frc.robot.Commands.LiftCommands.LiftGrabCommand;
import frc.robot.Commands.LiftCommands.PIDLiftExtendCommand;
import frc.robot.Commands.LiftCommands.PIDLiftFlipCommand;
import frc.robot.Commands.LiftCommands.PIDLiftFlipCommand1;
import frc.robot.Commands.LiftCommands.StopEncoderHoodCommand;
import frc.robot.Commands.LiftCommands.StopLiftExtendCommand;
import frc.robot.Commands.LiftCommands.StopLiftFlipCommand;
import frc.robot.Commands.LiftCommands.StopLiftGrabCommand;
import frc.robot.Commands.ShooterCommands.ShootCommand;
import frc.robot.Commands.ShooterCommands.StopBackBeltCommand;
import frc.robot.Commands.ShooterCommands.StopHoodCommand;
import frc.robot.Commands.ShooterCommands.StopIntakeCommand;
import frc.robot.Commands.ShooterCommands.StopShootCommand;
import frc.robot.Commands.DriveCommands.StopTurretAimCommand;
import frc.robot.Commands.ShooterCommands.TarmacCommand;
import frc.robot.Commands.DriveCommands.TurretAimCommand;


/**
 * Add your docs here.
 */
public class Controls {
    // Axis
    private static final int AXIS_LEFT_X = 0;
    private static final int AXIS_LEFT_Y = 1;
    public Joystick playerOne;
    public Joystick playerTwo;
    public JoystickButton turretAim;
    public JoystickButton shoot;
    public JoystickButton intake;
    public JoystickButton dump;
    public JoystickButton tarmac;
    public JoystickButton hood;
    public JoystickButton hood1;
    public JoystickButton hood2;
    public JoystickButton lift1;
    public JoystickButton lift2;
    public JoystickButton lift3;
    public JoystickButton lift4;
    public JoystickButton lift5;
    public JoystickButton backbelt;
    public JoystickButton lift6;
    public JoystickButton lift7;
    public JoystickButton max;
    public JoystickButton reverse;
    public JoystickButton hoodEncoder;
    public JoystickButton joe;




    //creates Joystick Object
    public Controls() {
        //super(ControlsPort);
        playerOne = new Joystick(Constants.PLAYER_ONE_PORT);
        playerTwo = new Joystick(Constants.PLAYER_TWO_PORT);
        turretAim = new JoystickButton(playerTwo, Constants.START_BUTTON);
        shoot = new JoystickButton(playerTwo, Constants.BACK_RIGHT_BUTTON);
        //dump = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        tarmac = new JoystickButton(playerTwo, Constants.BUTTON_A);
        //max = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        intake = new JoystickButton(playerOne, Constants.BUTTON_X);
        backbelt = new JoystickButton(playerTwo, Constants.BUTTON_Y);
        lift1 = new JoystickButton(playerOne, Constants.BUTTON_A);
        lift2 = new JoystickButton(playerOne, Constants.BUTTON_Y);
        lift3 = new JoystickButton(playerOne, Constants.BACK_LEFT_BUTTON);
        lift4 = new JoystickButton(playerOne, Constants.BUTTON_B);
        lift5 = new JoystickButton(playerOne, Constants.START_BUTTON);
        lift6 = new JoystickButton(playerOne, Constants.BACK_BUTTON);
       
        // dump = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        //tarmac = new JoystickButton(playerTwo, Constants.BACK_RIGHT_BUTTON);
        hood1 = new JoystickButton(playerTwo, Constants.BUTTON_B);
        hood2 = new JoystickButton(playerTwo, Constants.BUTTON_X);
        lift7 = new JoystickButton(playerOne, Constants.BACK_RIGHT_BUTTON);
        max = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        reverse = new JoystickButton(playerTwo, Constants.BUTTON_A);
        //joe = new JoystickButton(playerTwo, Constants.BACK_RIGHT_BUTTON);
        //hood = new JoystickButton(playerTwo, Constants.BUTTON_B);
        configureButtonBindings();
        }

    private void configureButtonBindings() {
        turretAim.whileHeld(new TurretAimCommand());
        turretAim.whenReleased(new StopTurretAimCommand());
        shoot.whileHeld(new ShootCommand());
        shoot.whenReleased(new StopShootCommand());
        intake.whileHeld(new IntakeCommand());
        intake.whenReleased(new StopIntakeCommand());
        backbelt.whileHeld(new BackBeltCommand());
        backbelt.whenReleased(new StopBackBeltCommand());
        lift1.whileHeld(new PIDLiftExtendCommand());
        lift1.whenReleased(new StopLiftExtendCommand());
        lift2.whileHeld(new PIDLiftFlipCommand());
        lift2.whenReleased(new StopLiftFlipCommand());
        lift3.whileHeld(new BackLiftExtendCommand());
        lift3.whenReleased(new StopLiftExtendCommand());
        lift4.whileHeld(new BackLiftFlipCommand());
        lift4.whenReleased(new StopLiftFlipCommand());
        lift5.whileHeld(new LiftGrabCommand());
        lift5.whenReleased(new StopLiftGrabCommand());
        lift6.whenReleased(new StopLiftGrabCommand());
        lift6.whileHeld(new BackLiftGrabCommand());
        reverse.whileHeld(new ReverseIntake());
        reverse.whenReleased(new StopIntakeCommand());

        // hoodEncoder.whileHeld(new EnconderHoodDeal(25));
        // //joe.whileHeld(new EnconderHoodDeal(10));
        // hoodEncoder.whenReleased(new StopEncoderHoodCommand());
        //joe.whenReleased(new StopEncoderHoodCommand());

        
         tarmac.whileHeld(new TarmacCommand());
         tarmac.whenReleased(new StopShootCommand());
         max.whileHeld(new MaxCommand());
        max.whenReleased(new StopShootCommand());
         //hood.whenPressed(new HoodCommand35());
         //hood.whenReleased(new StopHoodCommand());
        hood2.whileHeld(new HoodCommand35());
        hood1.whileHeld(new HoodCommand25());
        // hood.whenReleased(new StopHoodCommand());
        hood1.whenReleased(new StopHoodCommand());
        hood2.whenReleased(new StopHoodCommand());
        lift7.whileHeld(new PIDLiftFlipCommand1());
        lift7.whenReleased(new StopLiftFlipCommand());

        
    }   

    //Returns X pos of the left stick
    public double getX() {
        return playerOne.getRawAxis(AXIS_LEFT_X);
    }
    //Returns X of the Right Stick
    
    //Returns Y pos of the left stick
    public double getY() {
        return playerOne.getRawAxis(AXIS_LEFT_Y);
    }
   

    
	

}