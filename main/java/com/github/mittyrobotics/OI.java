/*
 * MIT License
 *
 * Copyright (c) 2020 Mitty Robotics (Team 1351)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.mittyrobotics.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
/**
 * OI Class to manage all controllers and input
 */
public class OI {
    private static OI instance;

    private XboxController throttleWheel;
    private XboxController steeringWheel;
    private XboxController operatorController;
    private PS4Controller driveTestingController;

    //private boolean isIntaking, isEjecting, isUnloading, isOuttaking;

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    public XboxController getThrottleWheel() {
        if (throttleWheel == null) {
            throttleWheel = new XboxController(3);
        }
        return throttleWheel;
    }

    public XboxController getSteeringWheel() {
        if (steeringWheel == null) {
            steeringWheel = new XboxController(2);
        }
        return steeringWheel;
    }

    public XboxController getOperatorController() {
        if (operatorController == null) {
            operatorController = new XboxController(1);
        }

        return operatorController;
    }

    public PS4Controller getDriveController() {
        if(driveTestingController == null){
            driveTestingController = new PS4Controller(0);
        }

        return driveTestingController;
    }

    //rolling function


    
    //setter

    public void setRolling(boolean rolling){
        isRolling = rolling;
    }

    //getter

    public boolean getRolling(){
        return isRolling;
    }

    //not rolling function

    //setter

    //getter

/*
    public void setIntaking(boolean intaking) {
        isIntaking = intaking;
    }

    public void setEjecting(boolean ejecting) {
        isEjecting = ejecting;
    }

    public boolean getIntaking() {
        return isIntaking;
    }

    public boolean getEjecting() {
        return isEjecting;
    }

    public boolean getOuttaking() {
        return isOuttaking;
    }

    public void setOuttaking(boolean outtaking) {
        isOuttaking = outtaking;
    }

    */

    public void setupControls() {
        XboxController controller = getOperatorController();
//        Button prepFenderButton = new Button(() -> controller.getLeftTriggerAxis() > 0.4);
//        prepFenderButton.whenHeld(new ParallelCommandGroup(
//                new FlywheelRPMCommand(ShooterConstants.FENDER_RPM),
//                new HoodAngleCommand(ShooterConstants.FENDER_HOOD)));

Button startRoll = new Button(controller::getAButton);
startRoll.whenHeld(//turn roller on);

//left motor
Button leftDriveFwd - new Button(() -> controller.getLeftTriggerAxis() > 0.4);
leftDrive.whenHeld(//sparkLeftforward);

//left motor backwards
Button leftDriveBckwd = new Button(() -> controller.getLeftTriggerAxis()) < 0.4);
leftDrive.whenHeld(//sparkLeft backwards)




//right motor
Button rightDriveFwd - new Button(() -> controller.getRightTriggerAxis() > 0.4);
rightDrive.whenHeld(//sparkRightforward);

//right motor backwards
Button rightDriveBckwd = new Button(() -> controller.getRightTriggerAxis()) < 0.4);
rightDrive.whenHeld(//sparkRight backwards)


/*
        Button climbUp = new Button(() ->
                (controller.getPOV() >= 0 && controller.getPOV() <= 45) ||
                (controller.getPOV() >= 315 && controller.getPOV() <= 360));
        climbUp.whenPressed(new WinchUpAutomatedCommand());

        Button climbDown = new Button(() ->
                (controller.getPOV() >= 135 && controller.getPOV() <= 225));
        climbDown.whenPressed(new WinchDownAutomatedCommand());

        Button climbUpManual = new Button(() ->
                (controller.getPOV() >= 45 && controller.getPOV() <= 135));
        climbUpManual.whenPressed(new WinchUpCommand());

        Button climbDownManual = new Button(() ->
                (controller.getPOV() >= 225 && controller.getPOV() <= 315));
        climbDownManual.whenPressed(new WinchDownCommand());

        Button prepShotButton = new Button(() -> controller.getLeftTriggerAxis() > 0.4);
        prepShotButton.whenHeld(new ParallelCommandGroup(
                new AutomaticFlywheelRPMCommand()
        ));

        Button prepAimButton = new Button(controller::getAButton);
        prepAimButton.whenHeld(new AimingCommand());

//        prepShotButton.whenHeld(new FlywheelRPMCommand(ShooterConstants.TEST_RPM));

        Button prepFenderButton = new Button(() -> controller.getRightTriggerAxis() > 0.4);
        prepFenderButton.whenHeld(new FlywheelRPMCommand(ShooterConstants.FENDER_RPM));
//
        Button unloadButton = new Button(controller::getXButton);
        unloadButton.whenHeld(new UnloadConveyorCommand());
//

//        Button ejectButton = new Button(controller::getBButton);
//        ejectButton.whenHeld(new StateMachineEjectCommand());
//
        Button intakeButton = new Button(controller::getLeftBumper);
        intakeButton.whenHeld(new IntakeBallCommand());
//
        Button emergencyOuttake = new Button(controller::getYButton);
        emergencyOuttake.whenHeld(new EmergencyOuttakeCommand());

        Button resetStateMachineButton = new Button(controller::getRightStickButton);
        resetStateMachineButton.whenPressed(new InstantCommand(() -> {
            ConveyorSubsystem.getInstance().reset();
        }));

    }

*/
    public boolean getUnload() {
        return isUnloading;
    }

    public void setUnload(boolean unload) {
        isUnloading = unload;
    }

    public void setUpTuningControls() {
        XboxController controller = getOperatorController();

    }

    private void triggerFunctionAfterTime(Runnable runnable, long time){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        runnable.run();
                    }
                },
                time
        );
    }
}
