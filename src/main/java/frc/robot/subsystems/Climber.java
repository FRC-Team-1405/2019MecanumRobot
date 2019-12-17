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
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.lib.Range;


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
  private static WPI_TalonSRX frontLeftClimbTalon = new WPI_TalonSRX(RobotMap.frontLeftClimbTalon);  
  private static WPI_TalonSRX frontRightClimbTalon = new WPI_TalonSRX(RobotMap.frontRightClimbTalon); 
  private static WPI_TalonSRX backLeftClimbTalon = new WPI_TalonSRX(RobotMap.backLeftClimbTalon); 
  private static WPI_TalonSRX backRightClimbTalon = new WPI_TalonSRX(RobotMap.backRightClimbTalon); 

  private Range frontLeftRange;
  private Range frontRightRange;
  private Range backLeftRange;
  private Range backRightRange;
  
  void setFrontLeftPosition(double percentExtended){ 
      frontLeftClimbTalon.setSelectedSensorPosition(10);  
  } 

  void setFrontRightPosition(double percentExtended){ 
    
  } 

  void setBackLeftPosition(double percentExtended){ 
    
  } 
  void setBackRightPosition(double percentExtended){
  
  }  

  public double getFrontLeftPosition(){
    return frontLeftClimbTalon.getSelectedSensorPosition(0);
   }

   public double getFrontRightPosition(){
    return frontRightClimbTalon.getSelectedSensorPosition(0);
   }
  
  
  public Climber() { 
    TalonSRXConfiguration allConfigs = new TalonSRXConfiguration();

    configureTalon(frontLeftClimbTalon);
    frontLeftClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10); 
    frontLeftClimbTalon.configNeutralDeadband(0.001, 10);
    frontLeftClimbTalon.set(ControlMode.PercentOutput, 0);
    frontLeftClimbTalon.setName("Front Left Leg");
    this.addChild(frontLeftClimbTalon); 
    LiveWindow.add(frontLeftClimbTalon); 

    frontLeftClimbTalon.getAllConfigs(allConfigs, 0);
    frontLeftRange = new Range(allConfigs.reverseSoftLimitThreshold, allConfigs.forwardSoftLimitThreshold);
  
    configureTalon(frontRightClimbTalon);
    frontRightClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    frontRightClimbTalon.configNeutralDeadband(0.001, 10);
    frontRightClimbTalon.set(ControlMode.PercentOutput, 0);
    frontRightClimbTalon.setName("Front Right Leg");
    this.addChild(frontRightClimbTalon); 
    LiveWindow.add(frontRightClimbTalon);  
    
    frontRightClimbTalon.getAllConfigs(allConfigs, 0);
    frontRightRange = new Range(allConfigs.reverseSoftLimitThreshold, allConfigs.forwardSoftLimitThreshold);

    configureTalon(backLeftClimbTalon);
    backLeftClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    backLeftClimbTalon.configNeutralDeadband(0.001, 10);
    backLeftClimbTalon.set(ControlMode.PercentOutput, 0);
    backLeftClimbTalon.setName("Back Left Leg");
    this.addChild(backLeftClimbTalon); 
    LiveWindow.add(backLeftClimbTalon);  

    backLeftClimbTalon.getAllConfigs(allConfigs, 0);
    backLeftRange = new Range(allConfigs.reverseSoftLimitThreshold, allConfigs.forwardSoftLimitThreshold);

    configureTalon(backRightClimbTalon);
    backRightClimbTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
    backRightClimbTalon.configNeutralDeadband(0.001, 10);
    backRightClimbTalon.set(ControlMode.PercentOutput, 0);
    backRightClimbTalon.setName("Back Right Leg");
    this.addChild(backRightClimbTalon); 
    LiveWindow.add(backRightClimbTalon);  

    backRightClimbTalon.getAllConfigs(allConfigs, 0);
    backRightRange = new Range(allConfigs.reverseSoftLimitThreshold, allConfigs.forwardSoftLimitThreshold);
  }   
  

  @Override
  public void initDefaultCommand() {              
    // Set the default command for a subsystem here.  
    // setDefaultCommand(new MySpecialCommand());   
    setDefaultCommand(new ClimbController());   
  }  

  public void extendFrontLegsLevelTwo(){ 
    setFrontLeftPosition(10);
  } 

  public void extendFrontLegsLevelThree() {  
    
  }

  public void retractFrontLegs(){ 
  
  } 

  public void extendBackLegsLevelTwo(){ 
     
  } 
  
  public void extendBackLegsLevelThree(){ 
       
  } 
  
  public void retractBackLegs(){ 
    
  }  

  public void extendLeftLegsLevelTwo(){ 
    
  } 

  public void extendLeftLegsLevelThree(){ 
    
  } 

  public void extendRightLegsLevelTwo(){ 
    
  } 

  public void extendRightLegsLevelThree(){ 
     
  }

  public void setLegExtension(double percent) {
    System.out.printf(  "%3d %3d %3d %3d",
                        frontLeftRange.toPosition(percent),
                        backLeftRange.toPosition(percent),
                        frontRightRange.toPosition(percent),
                        backRightRange.toPosition(percent));
/*
    frontLeftClimbTalon.set(ControlMode.MotionMagic, frontLeftRange.toPosition(percent));
    backLeftClimbTalon.set(ControlMode.MotionMagic, backLeftRange.toPosition(percent));
    frontRightClimbTalon.set(ControlMode.MotionMagic, frontRightRange.toPosition(percent));
    backRightClimbTalon.set(ControlMode.MotionMagic, backRightRange.toPosition(percent));
*/
  }

  

  public void configureTalon(TalonSRX talonSRX){   
    ExtendedTalon.configCurrentLimit(talonSRX);    
    talonSRX.configNeutralDeadband(0.001, 10);   
    talonSRX.setSensorPhase(true);  
  } 

  
}
