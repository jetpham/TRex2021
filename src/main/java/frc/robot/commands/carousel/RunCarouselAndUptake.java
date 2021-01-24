/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.carousel;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carousel;
import frc.robot.subsystems.Uptake;

/**
 * An example command that uses an example subsystem.
 */
public class RunCarouselAndUptake extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Uptake m_uptake;
    private final Carousel m_carousel;

    private double startTime;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */

    public RunCarouselAndUptake(Uptake uptake, Carousel carousel) {
        m_uptake = uptake;
        m_carousel = carousel;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(uptake);
        addRequirements(carousel);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_uptake.setPercentOutput(0.5);
        m_carousel.setPercentOutput(0.5);
        startTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_uptake.setPercentOutput(0.0);
        m_carousel.setPercentOutput(0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return startTime - Timer.getFPGATimestamp() < 2;
    }
}
