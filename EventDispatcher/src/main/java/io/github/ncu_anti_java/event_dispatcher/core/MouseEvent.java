package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IEvent;

import java.awt.*;

/**
 * Created by Davy on 2015/11/4.
 */
public class MouseEvent implements IEvent {
    java.awt.event.MouseEvent mEvent;

    public MouseEvent(java.awt.event.MouseEvent e) {
        mEvent = e;
    }

    @Override
    public Point getPosition() {
        return mEvent.getPoint();
    }

    @Override
    public String toString() {
        switch (mEvent.getID()) {
            case java.awt.event.MouseEvent.MOUSE_CLICKED:
                return "mouse click";

            case java.awt.event.MouseEvent.MOUSE_PRESSED:
                return "mouse down";

            case java.awt.event.MouseEvent.MOUSE_RELEASED:
                return "mouse up";

            case java.awt.event.MouseEvent.MOUSE_DRAGGED:
                return "mouse drag";

            default:
                return null;
        }
    }
}
