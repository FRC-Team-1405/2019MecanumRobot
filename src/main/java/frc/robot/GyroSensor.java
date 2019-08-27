/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;

/**
 * Add your docs here.
 */
public class GyroSensor {
    private static GyroSensor single_instance = null;
    private GyroSensor(){
    }
    public static GyroSensor getInstance(){
        if(single_instance == null){
            single_instance = new GyroSensor();
        }
        return single_instance;
    }

    private AHRS gyro = new AHRS(I2C.Port.kMXP);

    public double getGyroAngle(){
        return Math.IEEEremainder(gyro.getAngle(), 360.0);
    }
    
    public void resetGyro(){
        gyro.reset();
    }
    
    public boolean isReady(){
        return !gyro.isCalibrating();
    }
}
