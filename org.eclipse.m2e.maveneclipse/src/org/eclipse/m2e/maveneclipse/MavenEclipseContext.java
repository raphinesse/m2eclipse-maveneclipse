package org.eclipse.m2e.maveneclipse;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.maveneclipse.configuration.MavenEclipseConfiguration;
import org.eclipse.m2e.maveneclipse.handler.ConfigurationHandlers;

/**
 * Context for made available from the {@link MavenEclipseProjectConfigurator} to expose relevant objects for
 * {@link ConfigurationHandlers handlers} to use.
 * 
 * @author Alex Clarke
 * @author Phillip Webb
 */
public interface MavenEclipseContext {

	/**
	 * Access to the <tt>maven-eclipse-plugin</tt> configuration.
	 * 
	 * @return the configuration
	 */
	MavenEclipseConfiguration getConfiguration();

	/**
	 * Provides access to the {@link IProject}.
	 * 
	 * @return the {@link IProject}
	 */
	IProject getProject();

	/**
	 * Provides access to the {@link IProgressMonitor}.
	 * 
	 * @return the {@link IProgressMonitor}
	 */
	IProgressMonitor getProgressMonitor();

	/**
	 * Provides access to the {@link MavenProject}.
	 * 
	 * @return the {@link MavenProject}
	 */
	MavenProject getMavenProject();
}
