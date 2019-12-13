/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* tshe project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
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
    double posX = pilot.getY(Hand.kLeft) ;
    return (Math.abs(posX) < 0.2) ? 0 : posX;
  }

  public double driveY(){
    double posY = pilot.getX(Hand.kLeft) ;
    return (Math.abs(posY) < 0.2) ? 0 : posY;
  }

  public double driveRotation(){
    double rot = 0-pilot.getRawAxis(5);
    SmartDashboard.putNumber("Drive Rotate", rot);
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

  public final static int POSITION_FRONT    = 0;
  public final static int POSITION_BACK     = 1;
  public final static int POSITION_MAX      = 2;
  public int position = POSITION_FRONT;
  public void readPosition(){
    if (operator.getAButtonPressed()){
      position = (position++ % POSITION_MAX);
      SmartDashboard.putNumber("Arm_Position", position); 
    }
  } 

  public final static int ELEVATION_LOW = 0;
  public final static int ELEVATION_MID = 1;
  public final static int ELEVATION_HIGH = 2;
  public final static int ELEVATION_MAX = 3;
  public int elevation = ELEVATION_LOW;
  public void readElevation(){
    if (operator.getBButtonPressed()){
      elevation = (elevation++ % ELEVATION_MAX);
      SmartDashboard.putNumber("Arm Elevation", elevation);
    }
  }

  public double getElevationPosition(){ 
    return operator.getRawAxis(6);
  }
  
  public final static int PIVOT_LOW = 0;
  public final static int PIVOT_MID = 1;
  public final static int PIVOT_HIGH = 2;
  public final static int PIVOT_MAX = 3;
  public int pivot = PIVOT_LOW;
  public void readPivot(){
    if (operator.getXButtonPressed()){
      elevation = (elevation++ % ELEVATION_MAX);
      SmartDashboard.putNumber("Pivot", elevation);
    }
  }

  public double getWristPosition() { 
    return operator.getX(Hand.kLeft);
  }

  public boolean resetGyro(){
    return pilot.getYButtonPressed();
  } 

  public boolean openClaw(){ 
    //return operator.getAButton(); 
    return pilot.getRawButton(9);
  } 

  public boolean closeClaw(){ 
    //return operator.getBButton(); 
    return pilot.getRawButton(10);  
  } 

  public boolean intakeGamePiece(){ 
    //return pilot.getBumperPressed(Hand.kRight); 
    return pilot.getRawButtonPressed(12); 
  }  

  public boolean deployGamePiece(){ 
    //return pilot.getBumperPressed(Hand.kLeft);  
    return pilot.getRawButtonPressed(11);
  } 
  
  public boolean stopGamePieceIntake(){ 
    //return pilot.getBumperReleased(Hand.kRight); 
    return pilot.getRawButtonReleased(12);
  }

  public boolean stopGamePieceRelease(){ 
    //return pilot.getBumperReleased(Hand.kLeft);
    return pilot.getRawButtonReleased(11); 
  }
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

