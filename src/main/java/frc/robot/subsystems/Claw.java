/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ClawController;
import edu.wpi.first.wpilibj.Servo;  
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem { 
  // Put methods for controlling this subsystem
  // here. Call these from Commands. 
  private static Servo rightClawServo = new Servo(0); 
  private static Servo leftClawServo = new Servo(1);  
  private static WPI_TalonSRX intakeWheelLeft = new WPI_TalonSRX(RobotMap.intakeWheelLeft); 
  private static WPI_TalonSRX intakeWheelRight = new WPI_TalonSRX(RobotMap.intakeWheelRight); 

public Claw(){ 

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()); 
    setDefaultCommand(new ClawController());
  } 
  public void openClaw(){ 
    rightClawServo.setAngle(90); 
    leftClawServo.setAngle(90); 
  } 

  public void closeClaw(){ 
    rightClawServo.setAngle(-10); 
    leftClawServo.setAngle(-10);  
  } 

  public void intakeGamePiece(){ 
    intakeWheelLeft.set(1.0); 
    intakeWheelLeft.set(1.0); 
  } 

  public void deployGamePiece(){ 
    intakeWheelLeft.set(-1.0); 
    intakeWheelRight.set(-1.0); 
  }
}
