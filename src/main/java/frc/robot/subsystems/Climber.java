/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbController;   
import frc.robot.lib.ExtendedTalon;





/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands. 
  private WPI_TalonSRX frontLeftClimbTalon = new WPI_TalonSRX(RobotMap.frontLeftClimbTalon);  
  private WPI_TalonSRX frontRightClimbTalon = new WPI_TalonSRX(RobotMap.frontRightClimbTalon); 
  private WPI_TalonSRX backLeftClimbTalon = new WPI_TalonSRX(RobotMap.backLeftClimbTalon); 
  private WPI_TalonSRX backRightClimbTalon = new WPI_TalonSRX(RobotMap.backRightClimbTalon); 
  
  
  
  public Climber() { 
    configureTalon(frontLeftClimbTalon);
    frontLeftClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10); 
    frontLeftClimbTalon.configNeutralDeadband(0.001, 10);
    frontLeftClimbTalon.set(ControlMode.PercentOutput, 0);
    frontLeftClimbTalon.setName("Front Left Leg");
    this.addChild(frontLeftClimbTalon); 
    LiveWindow.add(frontLeftClimbTalon); 

    configureTalon(frontRightClimbTalon);
    frontRightClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    frontRightClimbTalon.configNeutralDeadband(0.001, 10);
    frontRightClimbTalon.set(ControlMode.PercentOutput, 0);
    frontRightClimbTalon.setName("Front Right Leg");
    this.addChild(frontRightClimbTalon); 
    LiveWindow.add(frontRightClimbTalon);  
    
    configureTalon(backLeftClimbTalon);
    backLeftClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    backLeftClimbTalon.configNeutralDeadband(0.001, 10);
    backLeftClimbTalon.set(ControlMode.PercentOutput, 0);
    backLeftClimbTalon.setName("Back Left Leg");
    this.addChild(backLeftClimbTalon); 
    LiveWindow.add(backLeftClimbTalon);  

    configureTalon(backRightClimbTalon);
    backRightClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    backRightClimbTalon.configNeutralDeadband(0.001, 10);
    backRightClimbTalon.set(ControlMode.PercentOutput, 0);
    backRightClimbTalon.setName("Back Right Leg");
    this.addChild(backRightClimbTalon); 
    LiveWindow.add(backRightClimbTalon);  
  }   
  

  @Override
  public void initDefaultCommand() {              
    // Set the default command for a subsystem here.  
    // setDefaultCommand(new MySpecialCommand());   
    setDefaultCommand(new ClimbController());   
  }  

  public void extendFrontLegs(){ 
    
  } 

  public void retractFrontLegs(){ 
  
  }

  public void configureTalon(TalonSRX talonSRX){   
    ExtendedTalon.configCurrentLimit(talonSRX);    
    talonSRX.configNeutralDeadband(0.001, 10);   
    talonSRX.setSensorPhase(true);  
  } 

  
}
