/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveBaseController;

/**
 * Add your docs here.
 */
public class DriveBaseSparkMax extends IDriveBase  {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax driveFrontLeft = new CANSparkMax(RobotMap.driveFrontLeft, MotorType.kBrushless);
  CANSparkMax driveFrontRight = new CANSparkMax(RobotMap.driveFrontRight, MotorType.kBrushless);
  CANSparkMax driveBackLeft = new CANSparkMax(RobotMap.driveBackLeft, MotorType.kBrushless);
  CANSparkMax driveBackRight = new CANSparkMax(RobotMap.driveBackRight, MotorType.kBrushless);
  MecanumDrive driveBase = new MecanumDrive(driveFrontLeft, driveBackLeft, driveFrontRight, driveBackRight);

  public DriveBaseSparkMax(){
    driveBase.setName("Drive_Base_SparkMax");
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
