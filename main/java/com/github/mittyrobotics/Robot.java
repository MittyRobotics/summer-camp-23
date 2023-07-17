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

    private TalonFX[] leftTalon = new TalonFX(2);

    private TalonFX[] rightTalon = new TalonFX(6)



    @Override
    public void robotInit() {

        //initialize spark
        sparkLeft = new Spark(0);
        sparkRight = new Spark(1);

        //intialize encoders
        leftEncoder = new Encoder(Constants.LEFT_ENCODER[0], Constants.LEFT_ENCODER_IDS[1]);
        leftEncoder.reset();
        leftEncoder.setDistancePerPulse(1./10.);
        leftEncoder.setMinRate(10.);
        leftEncoder.setReverseDirection(true);

        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_IDS[0], Constants.RIGHT_ENCODER_IDS[1]);
        rightEncoder.setDistancePerPulse(1./Constance.TICKS_PER_INCH);
        
        leftEncoder.reset();
        rightEncoder.reset();

        encoder = newEncoder(Constance.ENCODER_IDS[0], Constance.ENCODER_IDS[1]);
        encoder.setDistancePerPulse(1./Constance.TICKS_PER_INCH);
        encoder.reset();
        //sets value to 0


        //initalize the gyro
        gyro = new RomiGyro();
        gyro.reset();





    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
    
    @Override
    public void teleopPeriodic() {

        //can do any encoder
        double distance = leftEncoder.getDistance();
        //can only do l/r
        double rate = leftEncoder.getRate();

        double angleZ = gyro.getAngleZ();

        //drive 101.5 inches(1)
        if (encoder.getDistance <= 101.5){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }

        encoder.reset
        //90 Degree Turn
        if (angleZ < 90){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);

        }

        gyro.reset

        //drive 72 inches(2)
        if (encoder.getDistance <= 72){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);        
        
        }

        encoder.reset

        //60 Degree Turn
        if (angleZ < 300){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);

        }
        gyro.reset

        //drive 44 inches(3)
        if (encoder.getDistance <= 44){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);        
        
        }

        encoder.reset

        //120 Degree Turn
        if (angleZ < 60){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);

        }
        gyro.reset

        //drive 55 inches(3)
        if (encoder.getDistance <= 55){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);        
        
        }

        encoder.reset


    }
*/
    //Runs when antonomous mode (robot runs on its own) first activated via the desktop application
    @Override
    public void autonomousInit() {
        //backwards to score

        if (encoder.getDistance <= 90){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        encoder.reset
        
        //option 1 -> get left ball -> get middle ball -> go
        //angled to the left ball
        if (angleZ < 161.565){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);

        }
        gyro.reset
        
        if (encoder.getDistance <= 189.73){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        encoder.reset

        //grab DA BALL!!!

       if (angleZ < 180){
            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        gyro.reset

        if (encoder.getDistance <= 189.73){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        encoder.reset

        //drop the BALL!!!

        if (angleZ < 323.13){
            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        gyro.reset

        if (encoder.getDistance <= 189.73){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        encoder.reset

        //get da BALLZ!

         if (angleZ < 180){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        gyro.reset

        if (encoder.getDistance <= 189.73){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);
        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        
        encoder.reset

        if (angleZ < 18.435){
            sparkLeft.set(-0.5);
            sparkRight.set(0.5);

        } else{
            sparkLeft.set(0);
            sparkRight.set(0);
        }
        gyro.reset



        //drop da ball

        



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