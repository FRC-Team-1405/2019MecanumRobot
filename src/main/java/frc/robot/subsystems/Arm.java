/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands. 
private WPI_TalonSRX armTalon = new WPI_TalonSRX(RobotMap.armTalon); 

public Arm() { 
  configureTalon(armTalon);
  armTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
  armTalon.configNeutralDeadband(0.001, 10);
  armTalon.set(ControlMode.PercentOutput, 0);
  armTalon.setName("Arm Talon");
  this.addChild(armTalon); 
  LiveWindow.add(armTalon);

}

 
private void configureTalon(TalonSRX talonSRX) { 
  ExtendedTalon.configCurrentLimit(talonSRX);    
  talonSRX.configNeutralDeadband(0.001, 10);   
  talonSRX.setSensorPhase(true); } 

@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()); 
    
   
    
    }
  

    
    
  
}
