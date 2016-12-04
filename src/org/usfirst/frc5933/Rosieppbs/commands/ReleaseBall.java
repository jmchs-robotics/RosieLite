// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Rosieppbs.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.Rosieppbs.Robot;
import org.usfirst.frc5933.Rosieppbs.RobotMap;

/**
 *
 */
public class ReleaseBall extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public ReleaseBall() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.ballHopper);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
	private double startTime;
	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.ballHopperBallReleasePlunger.set(0.5);
		Robot.ballHopper.initializeCounter();
		startTime = System.currentTimeMillis(); 		//start your engines!!!
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		RobotMap.ballHopperBallReleasePlunger.set(0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double now = System.currentTimeMillis(); 		//Has a lap finished yet?
		if(now - startTime >= 700){ 					//We done, boys!
			return Robot.ballHopper.isSwitchSet(); 		//Seriously. Go home.
		} else {
			Robot.ballHopper.initializeCounter();
		}
		return false; 									//or not...
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.ballHopperBallReleasePlunger.set(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		RobotMap.ballHopperBallReleasePlunger.set(0);
	}
}
