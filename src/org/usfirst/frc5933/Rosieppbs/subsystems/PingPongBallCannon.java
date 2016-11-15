// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Rosieppbs.subsystems;

import org.usfirst.frc5933.Rosieppbs.RobotMap;
import org.usfirst.frc5933.Rosieppbs.commands.*;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class PingPongBallCannon extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController flyWheel = RobotMap.pingPongBallCannonFlyWheel;
    private final SpeedController ballReleasePiston = RobotMap.pingPongBallCannonBallReleasePiston;
    private final PowerDistributionPanel powerDistributionPanel = RobotMap.pingPongBallCannonPowerDistributionPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		//pdp.clearStickyFaults();
		//System.out.println("Voltage is before reset " + pdp.getCurrent(15));
		//pdp.resetTotalEnergy();
		//System.out.println("Voltage is " + pdp.getCurrent(15));
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	public void wheelSpeed(double v) {
		flyWheel.set(v);
	}

	public void pistonStart() {
	    final double current = RobotMap.pingPongBallCannonPowerDistributionPanel.getVoltage();
		ballReleasePiston.set(-.5 * 12.6 / current); //in theory this should standardize the speed over all voltages ...
	}

	public void pistonStop() {
		ballReleasePiston.set(0);
	}
}

