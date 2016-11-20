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

import edu.wpi.first.wpilibj.can.CANJNI;
import edu.wpi.first.wpilibj.command.Command;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 *
 */
public class LIDAR extends Command {

    private enum CommandState {
        READY, REQUEST_DISTANCE, WAIT_FOR_DISTANCE, DONE
    }

    private CommandState state;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LIDAR() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        state = CommandState.READY;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    /* Check the datasheets for your device for the arbitration IDs of the
    messages you want to send.  By convention, this is a bitstring
    containing the model number, manufacturer number, and api number. */
    private static final int REQUEST_RANGE_ARB_ID = 0x1;
    private static final int RESPOND_RANGE_ARB_ID = 0x2;

    /*  Device ID, from 0 to 63. */
    private static final int LIDAR_ID = 60;

    private IntBuffer messageId = ByteBuffer.allocateDirect(4).asIntBuffer();
    private ByteBuffer data = ByteBuffer.allocateDirect(8);
    private ByteBuffer timestamp = ByteBuffer.allocate(4);
    private int range = 0;

    private int makeUnsignedByte(byte b) {
        return (int) b & 0xFF;
    }

    private void requestRange() {
        /* Again, see the datasheet for the device you're using.  It should
        specify what data to put here. */
        data.clear();
        data.putInt(1);

	    /* Alternatively, instead of CAN_SEND_PERIOD_NO_REPEAT, you can specify
	        a period in milliseconds to automatically send the message over
	        and over again. */
        CANJNI.FRCNetworkCommunicationCANSessionMuxSendMessage(
                REQUEST_RANGE_ARB_ID | LIDAR_ID,
                data,
                CANJNI.CAN_SEND_PERIOD_NO_REPEAT
        );
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (state == CommandState.READY) {
            // Calling in ready state means command was just scheduled, so get the range
            requestRange();
            state = CommandState.WAIT_FOR_DISTANCE;
        }
        else if (state == CommandState.WAIT_FOR_DISTANCE) {
            /* To receive a message, put the message ID you're looking for in this
            buffer.  CANJNI...ReceiveMessage  will not block waiting for it,
            but just return null if it hasn't been received yet. */
            messageId.clear();
            messageId.put(0, RESPOND_RANGE_ARB_ID | LIDAR_ID);

            ByteBuffer data = CANJNI.FRCNetworkCommunicationCANSessionMuxReceiveMessage(
                    messageId,
                    CANJNI.CAN_MSGID_FULL_M,
                    timestamp
            );

            if (data != null) {
                System.out.println("Received a message: " + Arrays.toString(data.array()));
                range = (makeUnsignedByte(data.array()[0])<<8) + makeUnsignedByte(data.array()[1]);
                System.out.println("Range is: " + range);
                state = CommandState.DONE;
            }

        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (state == CommandState.DONE) {
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        state = CommandState.READY;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    public int getRange() {
        return range;
    }
}
