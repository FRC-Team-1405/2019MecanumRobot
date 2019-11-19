/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public OI() {
    SmartDashboard.putBoolean("useFieldBased", useFieldBased);
   
  }
  public XboxController pilot = new XboxController(RobotMap.pilot);
  public XboxController operator = new XboxController(RobotMap.operator);

  public double driveX(){
    double posX = pilot.getX(Hand.kLeft) ;
    return (Math.abs(posX) < 0.2) ? 0 : posX;
  }

  public double driveY(){
    double posY = pilot.getY(Hand.kLeft) ;
    return (Math.abs(posY) < 0.2) ? 0 : posY;
  }

  public double driveRotation(){
    double rot = 0-pilot.getX(Hand.kRight) ;
    return (Math.abs(rot) < 0.2) ? 0 : rot;
  }

  private boolean useFieldBased = true;
  public boolean useFieldBased(){
    if (pilot.getAButtonPressed()) {
      useFieldBased = !useFieldBased;
      SmartDashboard.putBoolean("useFieldBased", useFieldBased);
    }
    return useFieldBased;
  }

  public boolean resetGyro(){
    return pilot.getYButtonPressed();
  } 

  public boolean openClaw(){ 
    return pilot.getAButtonPressed(); 
  } 

  public boolean closeClaw(){ 
    return pilot.getBButton(); 
  } 

  public boolean intakeGamePiece(){ 
    return pilot.getBumper(Hand.kRight); 
  } 

  public boolean deployGamePiece(){ 
    return pilot.getBumper(Hand.kLeft); 
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
