/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Claw;
import frc.robot.OI;

public class ClawController extends Command {
  boolean isIntaking = false;
  
  public ClawController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis); 
    requires(Robot.claw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() { 
    Robot.claw.neutral();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
    if(Robot.m_oi.openClaw()) { 
      Robot.claw.openClaw(); 
    } 
    else if(Robot.m_oi.closeClaw()){ 
      Robot.claw.closeClaw();
    } 

    if(Robot.m_oi.intakeGamePiece()){ 
      Robot.claw.intakeGamePiece(); 
      
    } else if(Robot.m_oi.stopGamePieceIntake()) { 
      Robot.claw.stopIntakes();
    }

     
      if(Robot.m_oi.deployGamePiece()){ 
        Robot.claw.deployGamePiece(); 
    } else if(Robot.m_oi.stopGamePieceRelease()){ 
      Robot.claw.stopIntakes();
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
