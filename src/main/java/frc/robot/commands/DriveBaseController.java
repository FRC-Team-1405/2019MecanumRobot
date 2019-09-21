/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.GyroSensor;
import frc.robot.Robot;

public class DriveBaseController extends Command {
  public DriveBaseController() {
    requires(Robot.driveBase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.useFieldBased()){
      Robot.driveBase.drive(Robot.m_oi.driveY(), Robot.m_oi.driveX(), Robot.m_oi.driveRotation(), GyroSensor.getInstance().getGyroAngle());
    }else{
      Robot.driveBase.drive(Robot.m_oi.driveY(), Robot.m_oi.driveX(), Robot.m_oi.driveRotation(), 0.0);
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
