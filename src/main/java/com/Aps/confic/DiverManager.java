package com.Aps.confic;

import org.openqa.selenium.WebDriver;

public class DiverManager {
	private static DiverManager DRIVER_MANAGER;
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	private DiverManager() {

	}

	public static DiverManager getInstance() {
		if (DRIVER_MANAGER == null) {
			synchronized (DiverManager.class) {
				if (DRIVER_MANAGER == null) {
					DRIVER_MANAGER = new DiverManager();
				}
			}
		}
		return DRIVER_MANAGER;
	}

	public synchronized void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}

	public synchronized WebDriver getDriver() {
		WebDriver driver = tDriver.get();
		if (driver == null) {
			throw new IllegalStateException("Driver should not be null!!");
		}
		return driver;
	}
}
