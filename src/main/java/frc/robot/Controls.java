package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.StopTurretAimCommand;
import frc.robot.Commands.TurretAimCommand;

/**
 * Add your docs here.
 */
public class Controls {
    // Axis
    private static final int AXIS_LEFT_X = 0;
    private static final int AXIS_LEFT_Y = 1;
    public Joystick playerOne;
    public JoystickButton turretAim;


    //creates Joystick Object
    public Controls() {
        //super(ControlsPort);
        playerOne = new Joystick(Constants.PLAYER_ONE_PORT);
        turretAim = new JoystickButton(playerOne, Constants.BUTTON_B);
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        turretAim.whileHeld(new TurretAimCommand());
        turretAim.whenReleased(new StopTurretAimCommand());
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