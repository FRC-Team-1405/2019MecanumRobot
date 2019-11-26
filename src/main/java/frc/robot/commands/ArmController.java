/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.Robot;                        

public class ArmController extends Command {
  public ArmController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis); 
    requires(Robot.arm);   
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Pivot Positon", Robot.arm.getArmPivotPostion()); 
    if(Robot.m_oi.getArmFrontLow()){
      Robot.arm.frontLow();
    } else if(Robot.m_oi.getArmFrontMid()){
      Robot.arm.frontMid();
    } else if(Robot.m_oi.getArmFrontHigh()){
      Robot.arm.frontHigh();
    } else if(Robot.m_oi.getArmBackLow()){
      Robot.arm.backLow();
    } else if(Robot.m_oi.getArmBackMid()){
      Robot.arm.backMid();
    } else if(Robot.m_oi.getArmBackHigh()){
      Robot.arm.backHigh();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;   
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
