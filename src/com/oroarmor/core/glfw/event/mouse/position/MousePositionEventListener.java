package com.oroarmor.core.glfw.event.mouse.position;

import java.util.ArrayList;

import com.oroarmor.core.glfw.event.ActiveListener;

public interface MousePositionEventListener extends ActiveListener {
	public void processMousePositionEvent(MousePositionEvent event);

	public static ArrayList<MousePositionEventListener> mousePositionListener = new ArrayList<MousePositionEventListener>();

	public static void addMousePositionListener(MousePositionEventListener listener) {
		mousePositionListener.add(listener);
	}

	public static void processAllMousePositionEvent(MousePositionEvent event) {
		for (MousePositionEventListener listener : mousePositionListener) {
			listener.processMousePositionEvent(event);
		}
	}

	public default void addToPositionListeners() {
		addMousePositionListener(this);
	}

}
