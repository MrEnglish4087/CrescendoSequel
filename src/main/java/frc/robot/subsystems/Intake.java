// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import au.grapplerobotics.LaserCan;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public TalonFX IntakeFeedMotor = new TalonFX(Constants.IntakeFeed);
  public TalonFX IntakeCenterMotor = new TalonFX(Constants.IntakeCenter);
  public LaserCan IntakeSensor = new LaserCan(Constants.IntakeSensor);
  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
