// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher;

public class LauncherFeeder extends Command {
  /** Creates a new LauncherFeeder. */
  
    public final Launcher m_Launcher;
    public LauncherFeeder(Launcher launcher) {
    m_Launcher = launcher;
        addRequirements(launcher);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Launcher.LauncherFeedMotor.set(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Launcher.LauncherFeedMotor.set(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean checkSensor = new Double(m_Launcher.LaunchSensor.getMeasurement().toString())< 200.0;
    return checkSensor;
  }
}
