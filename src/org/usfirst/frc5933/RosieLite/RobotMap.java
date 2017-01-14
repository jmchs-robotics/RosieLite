// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.RosieLite;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainFrontLeft;
    public static CANTalon driveTrainRearLeft;
    public static CANTalon driveTrainFrontRight;
    public static CANTalon driveTrainRearRight;
    public static RobotDrive driveTrainRobotDrive;
    public static PowerDistributionPanel electricalPowerDistributionPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFrontLeft = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "FrontLeft", driveTrainFrontLeft);
        
        driveTrainRearLeft = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "RearLeft", driveTrainRearLeft);
        
        driveTrainFrontRight = new CANTalon(10);
        LiveWindow.addActuator("DriveTrain", "FrontRight", driveTrainFrontRight);
        
        driveTrainRearRight = new CANTalon(13);
        LiveWindow.addActuator("DriveTrain", "RearRight", driveTrainRearRight);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFrontLeft, driveTrainRearLeft,
              driveTrainFrontRight, driveTrainRearRight);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        electricalPowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Electrical", "PowerDistributionPanel", electricalPowerDistributionPanel);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	public static void disabledInit() {

    }
}
