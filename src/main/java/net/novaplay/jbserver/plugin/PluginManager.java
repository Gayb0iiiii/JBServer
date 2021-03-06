package net.novaplay.jbserver.plugin;

import java.io.File;
import java.util.*;

import net.novaplay.jbserver.event.*;
import net.novaplay.jbserver.event.EventListener;

public interface PluginManager {
	
	Plugin getPlugin(String name);
	boolean registerInterface(Class<? extends PluginLoader> clazz);
	Map<String, Plugin> getPlugins();
	Plugin loadPlugin(String path);
	Plugin loadPlugin(File file);
	Plugin loadPlugin(String path, Map<String, PluginLoader> loaders);
	Plugin loadPlugin(File file, Map<String, PluginLoader> loaders);
	Map<String, Plugin> loadPlugins(String path);
	Map<String, Plugin> loadPlugins(File file);
	Map<String, Plugin> loadPlugins(String path, List<String> newLoaders);
	Map<String, Plugin> loadPlugins(File file, List<String> newLoaders);
	Map<String, Plugin> loadPlugins(File file, List<String> newLoaders, boolean include);
	boolean isPluginLoaded(Plugin plugin);
	void enablePlugin(Plugin plugin);
	void disablePlugin(Plugin plugin);
	void disablePlugins();
	void clearPlugins();
	void callEvent(Event event);
	void registerEvents(EventListener listener, Plugin plugin);
	void registerEvent(Class<? extends Event> event, EventListener listener, EventPriority priority, EventExecutor executor, Plugin plugin) throws PluginException;
	void registerEvent(Class<? extends Event> event, EventListener listener, EventPriority priority, EventExecutor executor, Plugin plugin, boolean ignoreCancelled) throws PluginException;
	HandlerList getEventListeners(Class<? extends Event> type) throws IllegalAccessException;
	Class<? extends Event> getRegistrationClass(Class<? extends Event> clazz) throws IllegalAccessException;
	boolean useTimings();
	void setUseTimings(boolean value);
}
