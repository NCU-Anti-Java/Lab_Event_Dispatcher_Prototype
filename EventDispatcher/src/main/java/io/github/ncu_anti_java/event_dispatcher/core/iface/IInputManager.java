package io.github.ncu_anti_java.event_dispatcher.core.iface;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by Davy on 2015/11/3.
 */
public interface IInputManager {
    KeyListener getKeyListener();
    MouseListener getMouseListener();
    MouseMotionListener getMouseMotionListener();

    List<IEvent> getEvents();
}
