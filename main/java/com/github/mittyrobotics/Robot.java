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
        //Declaring a spark

        Spark sparkLeft;
        Spark sparkRight;
        //talon initializing and declaring
        private TalonFx[] rightTalon = new TalonFx();
        private TalonFx[] leftTalon = new TalonFx();

    
        //declare encoders

        Encoder leftEncoder;
        Encoder rightEncoder;
        Encoder encoder;

        //declar button

        DigitalInput a_button, b_button, c_button;

        //declare gyro
        RomiGyro gyro;




    @Override
    public void robotInit() {
        
   //initialize sparks     
    sparkLeft = new Spark (0);
    sparkRight = new Spark (1);
    
    // initialize encoders

    leftEncoder = new Encoder (CONSTANTS.LEFT_ENCODER_IDS[0], CONSTANTS.LEFT_ENCODER_IDS[1]);
    leftEncoder.reset();
    leftEncoder.setDistancePerPulse(1./10);
    leftEncoder.setMinRate(10.);
    leftEncoder.setReverseDirection()

    rightEncoder = new Encoder (CONSTANTS.RIGHT_ENCODER_IDS[0], CONSTANTS.RIGHT_ENCODER_IDS[1]);
    rightEncoder.setDistancePerPulse(1./CONSTANTS.TICKS_PER_INCH);

    //set values of encoders to 0

    leftEncoder.reset();
    rightEncoder.reset();

    encoder = new Encoder(constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
    ENCODER.setDistancePerPulse(1./Constants.TICKS_PER_INCH);
    encoder.reset();

    //sets value to 0

   


    }

   









    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        


        double distance = leftEncoder.getDistatnce();
        double rate =leftEncoder.getRate();

        double angleZ = gyro.getAngleZ();

        if(encoder.getDistance <= 101.5){

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);


         } 
        //90 degree turn
         if (angleZ < 90){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);


         }
            //72 inches
         if(encoder.getDistance <= 72.){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } 

         //71 degree turn

         if (angleZ < 71){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }
            
            
            //44 inches
             if(encoder.getDistance <= 44.159321){

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }

            //109 degree turn
             if (angleZ < 109){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }

            // 55 inches

             if(encoder.getDistance <= 55.1257398231){

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
        //autonomous init

     //go backwards and put ball in goal (we still need to know how to deposit it)

            if(encoder.getDistance <= a){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);
         }

    //go fowards and get x ball
    if(encoder.getDistance <= a){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0)
         }
        //turn
            if (angleZ < a){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }
        //go foward
            if(encoder.getDistance <= a){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0)
         }

            //grab ball




            //if there is time go back to goal
        //go backwards
             if(encoder.getDistance <= a){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);

        //turn
         } if (angleZ < a){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }

            //go backwards again

              if(encoder.getDistance <= a){
            sparkLeft.set(-0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
         }

            







            











    





    




















    }

    //Runs periodically during teleoperated mode
    /*
     *  WRITE YOUR DRIVE CODE HERE
     */
    @Override
    public void teleopPeriodic() {
        


        double distance = leftEncoder.getDistatnce();
        double rate =leftEncoder.getRate();

        double angleZ = gyro.getAngleZ();

        if(encoder.getDistance <= 101.5){

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);


         } 
        //90 degree turn
         if (angleZ < 90){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);


         }
            //72 inches
         if(encoder.getDistance <= 72.){
            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } 

         //71 degree turn

         if (angleZ < 71){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
            
            
            //44 inches
             if(encoder.getDistance <= 44.159321){

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);

            //109 degree turn
             if (angleZ < 109){
            sparkLeft.set(0.5);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(-0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);

            // 55 inches

             if(encoder.getDistance <= 55.1257398231){

            sparkLeft.set(0.5);
            sparkRight.set(0.5);

         } else {
            sparkLeft.set(0);
            sparkRight.set(0);
    }

    //Runs periodically during test mode
    @Override
    public void testPeriodic() {

    }
}