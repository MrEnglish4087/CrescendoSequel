// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import au.grapplerobotics.LaserCan;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase {
  /** Creates a new Launcher. */
  public TalonFX ArmAngleMotor = new TalonFX(Constants.ArmAngle);
  public TalonFX LauncherFeedMotor = new TalonFX(Constants.LaunchFeed);
  public LaserCan LaunchSensor = new LaserCan(Constants.LaunchSensor);
  public TalonFX LaunchRtFlywheel = new TalonFX(Constants.LaunchRtFlywheel);
  public TalonFX LaunchLtFlywheel = new TalonFX(Constants.LaunchLtFlywheel);
  public CANcoder ArmAngleSensor = new CANcoder(Constants.ArmSensor);

  public Slot0Configs slot0Configs = new Slot0Configs();

  public final PositionVoltage m_request = new PositionVoltage(0).withSlot(0);
  
  public Launcher() {
  // This constructor sets the PID constants for the arm angle motor controller
    slot0Configs.kP = 2.4; // An error of 1 rotation results in 2.4 V output
    slot0Configs.kI = 0; // no output for integrated error
    slot0Configs.kD = 0.1; // A velocity of 1 rps results in 0.1 V output

    ArmAngleMotor.getConfigurator().apply(slot0Configs);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
