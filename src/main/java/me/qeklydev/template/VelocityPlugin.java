/*
 * Copyright (C) 2024 velocity-template Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package me.qeklydev.template;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.PluginManager;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
	  id = "velocity-plugin-template",
	  name = "VelocityPluginTemplate",
	  description = "A Velocity Plugin Template",
	  version = Constants.VERSION,
	  authors = { "Qekly" }
)
public final class VelocityPlugin {
	@Inject
	private Logger logger;
	@Inject
	@DataDirectory
	private Path pluginFolder;
	@Inject
	private Injector injector;
	
	@Subscribe
	void onProxyInitialization(final ProxyInitializeEvent event) {
		logger.info("Stating Velocity plugin template");
	}
}
