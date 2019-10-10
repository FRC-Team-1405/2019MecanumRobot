/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class GyroSensor {
    private static GyroSensor single_instance = null;
    private GyroSensor(){
        getGyroAngle();
    }
    public static GyroSensor getInstance(){
        if(single_instance == null){
            single_instance = new GyroSensor();
        }
        return single_instance;
    }

    private AHRS gyro = new AHRS(I2C.Port.kMXP);

    public double getGyroAngle(){
        double angle = Math.IEEEremainder(gyro.getAngle(), 360.0);
        if (angle < 0)
            angle += 360;
        SmartDashboard.putNumber("gyroAngle", angle);
        return 360.0 - angle;

    }
    
    public void resetGyro(){
        gyro.reset();
    }
    
    public boolean isReady(){
        return !gyro.isCalibrating();
    }
}
