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
    Robot.m_oi.readPosition();
    Robot.m_oi.readElevation();
    // if(Robot.m_oi.position == Robot.m_oi.POSITION_FRONT && Robot.m_oi.elevation == Robot.m_oi.ELEVATION_LOW){
    //   Robot.arm.frontLow();
    // }else if(Robot.m_oi.position == Robot.m_oi.POSITION_FRONT && Robot.m_oi.elevation == Robot.m_oi.ELEVATION_MID){
    //   Robot.arm.frontMid();
    // }else if(Robot.m_oi.position == Robot.m_oi.POSITION_FRONT && Robot.m_oi.elevation == Robot.m_oi.ELEVATION_HIGH){
    //   Robot.arm.frontHigh();
    // }else if(Robot.m_oi.position == Robot.m_oi.POSITION_BACK && Robot.m_oi.elevation == Robot.m_oi.ELEVATION_LOW){
    //   Robot.arm.backLow();
    // }else if(Robot.m_oi.position == Robot.m_oi.POSITION_BACK && Robot.m_oi.elevation == Robot.m_oi.ELEVATION_MID){
    //   Robot.arm.backMid();
    // }else{
    //   Robot.arm.backHigh();
    // }

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
