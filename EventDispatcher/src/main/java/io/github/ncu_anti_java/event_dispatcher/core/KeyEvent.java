package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IEvent;

import java.awt.*;

/**
 * Created by Davy on 2015/11/4.
 */
public class KeyEvent implements IEvent {
    final java.awt.event.KeyEvent mEvent;
    final Point mPoint;

    public KeyEvent(java.awt.event.KeyEvent e) {
        mEvent = e;
        mPoint = MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public Point getPosition() {
        return mPoint;
    }

    @Override
    public String toString() {
        switch (mEvent.getID()) {
            case java.awt.event.KeyEvent.KEY_PRESSED:
                return "keyboard input";

            default:
                return null;
        }
    }
}
