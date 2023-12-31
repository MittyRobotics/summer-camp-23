package com.github.mittyrobotics.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;


public class DriveTrainSubsystem extends SubsystemBase {
    public static DriveTrainSubsystem instance;



    //private WPI_TalonSRX roller
    CANSparkMax roller;

    CANSparkMax sparkLeft, sparkRight;


    // Encoder leftEncoder, rightEncoder;
    public DriveTrainSubsystem() {
        super();
        setName("Drive Train Subsystem");
    }

    public static DriveTrainSubsystem getInstance() {
        if(instance == null) {
            instance = new DriveTrainSubsystem();
        }
        return instance;
    }

    public void initHardware() {

        sparkRight  = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkLeft  = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);

        sparkLeft.setInverted(true);  //team 2 - true
        sparkRight.setInverted(false); //team 2 - false

        // roller = new WPI_TalonSRX(4);
        roller = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);

        roller.setInverted(true);

        /*
        leftTalon = new WPI_TalonSRX(13);
        leftTalon.configFactoryDefault();
        leftTalon.setInverted(false); //check if is inverted

         */





        resetEncoders();

    }


    public void resetEncoders() {
        sparkLeft.getEncoder().setPosition(0);
        sparkRight.getEncoder().setPosition(0);
        //   leftTalon.setSelectedSensorPosition(0);



    }



    public double getPosition() {
        //   return leftTalon.getSelectedSensorPosition() / DriveConstants.TICKS_PER_INCH;
        return 0;
    }



    public void setMotors(double left, double right) {
        sparkLeft.set(left);
        //left2.set(left);
        sparkRight.set(right);
        //   right2.set(right);
    }

    public void setRoller(double speed) {
        roller.set(speed);
    }

}