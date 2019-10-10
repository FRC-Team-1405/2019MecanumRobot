/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveBaseController;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX driveFrontLeft = new WPI_TalonSRX(RobotMap.driveFrontLeft);
  WPI_TalonSRX driveFrontRight = new WPI_TalonSRX(RobotMap.driveFrontRight);
  WPI_TalonSRX driveBackLeft = new WPI_TalonSRX(RobotMap.driveBackLeft);
  WPI_TalonSRX driveBackRight = new WPI_TalonSRX(RobotMap.driveBackRight);
  MecanumDrive driveBase = new MecanumDrive(driveFrontLeft, driveBackLeft, driveFrontRight, driveBackRight);

  public DriveBase(){
    driveFrontLeft.configNeutralDeadband(0.04, 10);
    driveFrontRight.configNeutralDeadband(0.04, 10);
    driveBackLeft.configNeutralDeadband(0.04, 10);
    driveBackRight.configNeutralDeadband(0.04, 10);

    driveFrontLeft.set(ControlMode.PercentOutput, 0);
    driveFrontRight.set(ControlMode.PercentOutput, 0);
    driveBackLeft.set(ControlMode.PercentOutput, 0);
    driveBackRight.set(ControlMode.PercentOutput, 0);

    driveFrontLeft.setName("Front Left");
    driveFrontRight.setName("Front Right");
    driveBackLeft.setName("Back Left");
    driveBackRight.setName("Back Right");

//    driveBase.setDeadband(0.0);
    this.addChild(driveBase);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveBaseController());
  }

  public void drive(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
    driveBase.driveCartesian(ySpeed, xSpeed, zRotation, gyroAngle);
  }
}
