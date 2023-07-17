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

import com.github.mittyrobotics.climb.commands.WinchDownAutomatedCommand;
import com.github.mittyrobotics.climb.commands.WinchDownCommand;
import com.github.mittyrobotics.climb.commands.WinchUpAutomatedCommand;
import com.github.mittyrobotics.climb.commands.WinchUpCommand;
import com.github.mittyrobotics.conveyor.ConveyorSubsystem;
import com.github.mittyrobotics.conveyor.commands.manual.EmergencyOuttakeCommand;
import com.github.mittyrobotics.conveyor.commands.manual.UnloadConveyorCommand;
import com.github.mittyrobotics.intake.commands.manual.IntakeBallCommand;
import com.github.mittyrobotics.intake.commands.manual.OuttakeBallCommand;
import com.github.mittyrobotics.shooter.HoodSubsystem;
import com.github.mittyrobotics.shooter.ShooterConstants;
import com.github.mittyrobotics.shooter.commands.automatic.AimingCommand;
import com.github.mittyrobotics.shooter.commands.automatic.AutomaticFlywheelRPMCommand;
import com.github.mittyrobotics.shooter.commands.automatic.AutomaticHoodPositionCommand;
import com.github.mittyrobotics.shooter.commands.manual.FlywheelRPMCommand;
import com.github.mittyrobotics.shooter.commands.manual.FlywheelSingleUpdateDown;
import com.github.mittyrobotics.shooter.commands.manual.FlywheelSingleUpdateUp;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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

    private boolean isIntaking, isEjecting, isUnloading, isOuttaking;

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    public XboxController getThrottleWheel() {
        if (throttleWheel == null) {
            throttleWheel = new XboxController(OIConstants.THROTTLE_WHEEL_ID);
        }
        return throttleWheel;
    }

    public XboxController getSteeringWheel() {
        if (steeringWheel == null) {
            steeringWheel = new XboxController(OIConstants.STEERING_WHEEL_ID);
        }
        return steeringWheel;
    }

    public XboxController getOperatorController() {
        if (operatorController == null) {
            operatorController = new XboxController(OIConstants.OPERATOR_CONTROLLER_ID);
        }

        return operatorController;
    }

    public PS4Controller getDriveController() {
        if(driveTestingController == null){
            driveTestingController = new PS4Controller(OIConstants.DRIVER_CONTROLLER);
        }

        return driveTestingController;
    }

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

    public void setupControls() {
        XboxController controller = getOperatorController();
//        Button prepFenderButton = new Button(() -> controller.getLeftTriggerAxis() > 0.4);
//        prepFenderButton.whenHeld(new ParallelCommandGroup(
//                new FlywheelRPMCommand(ShooterConstants.FENDER_RPM),
//                new HoodAngleCommand(ShooterConstants.FENDER_HOOD)));

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

    public boolean getUnload() {
        return isUnloading;
    }

    public void setUnload(boolean unload) {
        isUnloading = unload;
    }

    public void setUpTuningControls() {
        XboxController controller = getOperatorController();

        Button unloadButton = new Button(controller::getBButton);
        unloadButton.whenHeld(new UnloadConveyorCommand());

//        Button intakeButton = new Button(() -> controller.getLeftTriggerAxis() >= 0.4);
//        intakeButton.whenHeld(new StateMachineIntakeCommand());

        Button emergencyOuttakeButton = new Button(controller::getAButton);
        emergencyOuttakeButton.whenHeld(new OuttakeBallCommand());

        Button intakeButton = new Button(() -> controller.getLeftTriggerAxis() >= 0.4 );
        intakeButton.whenHeld(new IntakeBallCommand());

        Button autoFlywheel = new Button(controller::getRightBumper);
        autoFlywheel.whenHeld(new AutomaticFlywheelRPMCommand());

        Button autoHood = new Button(controller::getLeftBumper);
        autoHood.whenHeld(new AutomaticHoodPositionCommand());

        Button RPMUp = new Button(controller::getRightBumper);
        RPMUp.whenPressed(new FlywheelSingleUpdateUp());

        Button RPMDown = new Button(controller::getLeftBumper);
        RPMDown.whenPressed(new FlywheelSingleUpdateDown());

        Button HoodUp = new Button(controller::getYButton);
        HoodUp.whenPressed(new InstantCommand(() -> HoodSubsystem.getInstance().setHoodPosition(HoodSubsystem.getInstance().getHoodPosition() + 0.05)));

        Button HoodDown = new Button(controller::getXButton);
        HoodDown.whenPressed(new InstantCommand(() -> HoodSubsystem.getInstance().setHoodPosition(HoodSubsystem.getInstance().getHoodPosition() - 0.05)));

        Button resetStateMachineButton = new Button(controller::getRightStickButton);
        resetStateMachineButton.whenPressed(new InstantCommand(() -> {
            ConveyorSubsystem.getInstance().reset();
        }));
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
