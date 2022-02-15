package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.DumpCommand;
import frc.robot.Commands.HoodCommand25;
import frc.robot.Commands.HoodCommand30;
import frc.robot.Commands.HoodCommand35;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.ShootCommand;
import frc.robot.Commands.StopHoodCommand;
import frc.robot.Commands.StopIntakeCommand;
import frc.robot.Commands.StopShootCommand;
import frc.robot.Commands.StopTurretAimCommand;
import frc.robot.Commands.TarmacCommand;
import frc.robot.Commands.TurretAimCommand;

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


    //creates Joystick Object
    public Controls() {
        //super(ControlsPort);
        playerOne = new Joystick(Constants.PLAYER_ONE_PORT);
        playerTwo = new Joystick(Constants.PLAYER_TWO_PORT);
        turretAim = new JoystickButton(playerTwo, Constants.BUTTON_B);
        shoot = new JoystickButton(playerTwo, Constants.BUTTON_A);
        intake = new JoystickButton(playerTwo, Constants.BUTTON_X);
        // dump = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        // tarmac = new JoystickButton(playerTwo, Constants.BACK_RIGHT_BUTTON);
        // hood2 = new JoystickButton(playerTwo, Constants.BACK_LEFT_BUTTON);
        // hood1 = new JoystickButton(playerTwo, Constants.BACK_RIGHT_BUTTON);
        // hood = new JoystickButton(playerTwo, Constants.BUTTON_Y);
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        turretAim.whileHeld(new TurretAimCommand());
        turretAim.whenReleased(new StopTurretAimCommand());
        shoot.whileHeld(new ShootCommand());
        shoot.whenReleased(new StopShootCommand());
        intake.whileHeld(new IntakeCommand());
        intake.whenReleased(new StopIntakeCommand());
        // dump.whileHeld(new DumpCommand());
        // dump.whenReleased(new StopShootCommand());
        // tarmac.whileHeld(new TarmacCommand());
        // tarmac.whenReleased(new StopShootCommand());
        // hood.whenPressed(new HoodCommand35());
        // hood2.whenPressed(new HoodCommand30());
        // hood1.whenPressed(new HoodCommand25());
        // hood.whenReleased(new StopHoodCommand());
        // hood1.whenReleased(new StopHoodCommand());
        // hood2.whenReleased(new StopHoodCommand());

        
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