/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public final static int driveFrontLeft  = 1;
  public final static int driveFrontRight = 2;
  public final static int driveBackLeft   = 3;
  public final static int driveBackRight  = 4; 
  public final static int frontLeftClimbTalon = 5; 
  public final static int frontRightClimbTalon = 6;
  public final static int backLeftClimbTalon = 7; 
  public final static int backRightClimbTalon = 8; 
  public final static int armTalon = 9; 
  public final static int intakeWheelLeft = 14; 
  public final static int intakeWheelRight = 15; 
  public final static int pilot = 0; 
  public final static int operator = 1;

}
