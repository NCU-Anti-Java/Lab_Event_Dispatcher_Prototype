package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IEvent;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IInputManager;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davy on 2015/11/3.
 */
public class InputManager implements IInputManager, KeyListener, MouseListener, MouseMotionListener {
    final List<IEvent> mEvents;

    public InputManager() {
        mEvents = new ArrayList<>();
    }

    @Override
    public List<IEvent> getEvents() {
        final List<IEvent> events = new ArrayList<>(mEvents);
        mEvents.clear();
        return events;
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public MouseListener getMouseListener() {
        return this;
    }

    @Override
    public MouseMotionListener getMouseMotionListener() {
        return this;
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        mEvents.add(new KeyEvent(e));
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        mEvents.add(new KeyEvent(e));
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        mEvents.add(new KeyEvent(e));
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        mEvents.add(new MouseEvent(e));
    }
}
