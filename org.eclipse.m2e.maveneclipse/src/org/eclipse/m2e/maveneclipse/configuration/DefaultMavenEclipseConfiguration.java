package org.eclipse.m2e.maveneclipse.configuration;

import org.apache.maven.model.Plugin;
import org.codehaus.plexus.util.xml.Xpp3Dom;

/**
 * Default implementation of {@link MavenEclipseConfiguration}.
 * 
 * @author Alex Clarke
 * @author Phillip Webb
 */
public class DefaultMavenEclipseConfiguration implements MavenEclipseConfiguration {

	private Xpp3Dom dom;

	/**
	 * Create a new {@link DefaultMavenEclipseConfiguration} instance.
	 * @param plugin the source plugin
	 */
	public DefaultMavenEclipseConfiguration(Plugin plugin) {
		if (plugin == null) {
			throw new IllegalArgumentException("Plugin must not be null");
		}
		this.dom = (Xpp3Dom) plugin.getConfiguration();
	}

	public ConfigurationParameter getParamter(String name) {
		Xpp3Dom[] children = dom.getChildren(name);
		if (children.length > 1) {
			throw new IllegalStateException("Unexpected number of child parameters defined for '" + name + "'");
		}
		if (children.length == 0) {
			return null;
		}
		return new Xpp3DomConfigurationParamter(children[0]);
	}

	public boolean containsParamter(String name) {
		return getParamter(name) != null;
	}
}