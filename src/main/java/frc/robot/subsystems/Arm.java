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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbController;   
import frc.robot.lib.ExtendedTalon;
import frc.robot.commands.ArmController;
/**
 * Add your docs here.
 */
public class Arm extends Subsystem {

  private class ArmPosition {
    ArmPosition(String shuffleboardKey, double elevation, double pivot, double wrist){
      this.shuffleboardKey = shuffleboardKey;
      this.elevation = elevation;
      this.pivot = pivot;
      this.wrist = wrist;
    }
    public String shuffleboardKey;
    public double elevation;
    public double pivot;
    public double wrist;

  public void save(){
    SmartDashboard.putNumber(shuffleboardKey+"Elevation", elevation);
    SmartDashboard.putNumber(shuffleboardKey+"Pivot", pivot);
    SmartDashboard.putNumber(shuffleboardKey+"Wrist", wrist);
  }
  public void load(){
    elevation = SmartDashboard.getNumber(shuffleboardKey+"Elevation", elevation);
    elevation = SmartDashboard.getNumber(shuffleboardKey+"Pivot", pivot);
    elevation = SmartDashboard.getNumber(shuffleboardKey+"Wrist", wrist);
  }
}

  // Put methods for controlling this subsystem
  // here. Call these from Commands. 
private WPI_TalonSRX armElevationTalon = new WPI_TalonSRX(RobotMap.armElevationTalon); 
private WPI_TalonSRX armPivotTalon = new WPI_TalonSRX(RobotMap.armPivotTalon); 
private WPI_TalonSRX armWristTalon = new WPI_TalonSRX(RobotMap.armWristTalon); 

private ArmPosition[] positions = new ArmPosition[] {
                                    new ArmPosition("FrontLow", 0, 0, 0),
                                    new ArmPosition("FrontMid", 0, 0, 0),
                                    new ArmPosition("FrontHigh", 0, 0, 0),
                                    new ArmPosition("BackLow", 0, 0, 0),
                                    new ArmPosition("BackMid", 0, 0, 0),
                                    new ArmPosition("BackHigh", 0, 0, 0),
                                  };

public Arm() { 
  
  configureTalon(armElevationTalon);
  armElevationTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10);
  armElevationTalon.configNeutralDeadband(0.001, 10); 
  armElevationTalon.set(ControlMode.PercentOutput, 0);
  armElevationTalon.setName("Arm Elevation Talon");
  this.addChild(armElevationTalon); 
  LiveWindow.add(armElevationTalon); 

  for(ArmPosition position : positions) {
    position.save();
  }

  configureTalon(armPivotTalon); 
  //armPivotTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); 
  int pos = armPivotTalon.getSensorCollection().getPulseWidthPosition(); 
  armPivotTalon.getSensorCollection().setQuadraturePosition(pos, 0); 
  //armPivotTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative); 
  System.out.println(pos); 
  armPivotTalon.setSensorPhase(true); 

  configureTalon(armWristTalon); 
  armWristTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 10); 
  armWristTalon.configNeutralDeadband(0.001, 10); 
  armWristTalon.set(ControlMode.PercentOutput, 0); 
  armWristTalon.setName("Arm Wrist Talon"); 
  this.addChild(armWristTalon); 
  LiveWindow.add(armWristTalon); 
}

public int getArmPivotPostion(){
  return armPivotTalon.getSelectedSensorPosition();
}
 
private void configureTalon(TalonSRX talonSRX) { 
  ExtendedTalon.configCurrentLimit(talonSRX);    
  talonSRX.configNeutralDeadband(0.001, 10);   
} 

private void setArmPosition(int index){
  armElevationTalon.set(ControlMode.Position, positions[index].elevation);
  armPivotTalon.set(ControlMode.Position, positions[index].pivot);
  armWristTalon.set(ControlMode.Position, positions[index].wrist;
};

public void frontLow(){
  setArmPosition(0);
};
public void frontMid(){
  setArmPosition(1);
};
public void frontHigh(){
  setArmPosition(2);
};
public void backLow(){
  setArmPosition(3);
};
public void backMid(){
  setArmPosition(4);
};
public void backHigh(){
  setArmPosition(5);
};


@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()); 
  
   setDefaultCommand(new ArmController());
    
    } 


    
    
  
}
