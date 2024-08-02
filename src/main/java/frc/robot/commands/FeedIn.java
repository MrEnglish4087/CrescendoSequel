// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.StatusSignal;

import au.grapplerobotics.LaserCan;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;

public class FeedIn extends Command {
  /** Creates a new FeedIn. */
  public final Intake m_Intake; 
  public boolean m_SensorOverride;
  public FeedIn(Intake intake,boolean SensorOverride) {
    m_Intake = intake; 
    m_SensorOverride = SensorOverride;
       addRequirements(intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.IntakeCenterMotor.set(0.2);
    m_Intake.IntakeFeedMotor.set(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Intake.IntakeCenterMotor.set(0.0);
    m_Intake.IntakeFeedMotor.set(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean checkSensor = new Double(m_Intake.IntakeSensor.getMeasurement().toString()) < 200;
    
    //boolean checkArm = m_Launcher.ArmAngleSensor.getPosition().//equals(0.0);


    //return new Double(m_Intake.IntakeSensor.getMeasurement().toString()) < 200;
    return checkSensor && !m_SensorOverride;  
  }
}
