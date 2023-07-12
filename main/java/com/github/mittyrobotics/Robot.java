package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.controller.PIDController;


//Java automatically runs this class, and calls the various functions.
/*
 *  YOUR WIFI MUST BE CONNECTED TO ROMI FOR THIS TO WORK
 */
public class Robot extends TimedRobot {

    //Runs when the robot is first started up and should be used for any initialization code
    /*
     *  INITIALIZE CLASSES HERE
     */

    Spark sparkLeft;
    Spark sparkRight;

    Encoder leftEncoder;
    Encoder rightEncoder;
    Encoder encoder;

    DigitalInput a_button, b_button, c_button;

    RomiGyro gyro;

    @Override
    public void robotInit() {

        sparkLeft = new Spark(0);
        sparkRight = new Spark(1);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_IDS[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.reset();
        leftEncoder.setDistancePerPulse(1./10.);
        leftEncoder.setMinReset(10.);
        leftEncoder.setReverseDirection(true);

        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        
        leftEncoder.reset();
        rightEncoder.reset();

        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        encoder.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
        encoder.reset();

        gyro = new RomiGyro();
        gyro.reset();

    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {

        double distance = leftEncoder.getDistance();
        double rate = leftEncoder.getRate();

        double angleZ = gyro.getAngleZ();

        encoder.reset();

        if (encoder.getDistance <= 101.5) {

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        gyro.reset();

        if (angleZ < 90) {

            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else if (angleZ > 90) {

            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        encoder.reset();

        if (encoder.getDistance <= 72) {

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        gyro.reset();

        if (angleZ < 300) {

            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else if (angleZ > 300) {

            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        encoder.reset();

        if (encoder.getDistance <= 44) {

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        gyro.reset();

        if (angleZ < 55) {

            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else if (angleZ > 55) {

            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

        encoder.reset();

        if (encoder.getDistance <= 55) {

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else {

            sparkLeft.set(0);
            sparkRight.set(0);

        }

    }

    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {

    }

    //Runs when teleoperated mode (robot controlled by driver) is first activated
    @Override
    public void teleopInit() {

    }

    //Runs when test mode is activated
    @Override
    public void testInit() {

    }

    //Runs whenever the robot is on, periodically: should be used for command schedulers
    @Override
    public void robotPeriodic() {

    }

    //Runs periodically during autonomous mode
    @Override
    public void autonomousPeriodic() {

    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}