package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class IDriveBase extends Subsystem {
    public abstract void drive(double ySpeed, double xSpeed, double zRotation, double gyroAngle) ;
    protected abstract void initDefaultCommand();
};