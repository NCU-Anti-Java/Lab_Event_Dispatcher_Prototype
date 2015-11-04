package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IInputManager;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IWindow;

import javax.swing.*;

/**
 * Created by Davy on 2015/11/3.
 */
public class Window extends JFrame implements IWindow {
    final IInputManager mInputManager;
    final Scene mScene;

    public Window(final String title) {
        super(title, null);
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mInputManager = new InputManager();
        this.addKeyListener(mInputManager.getKeyListener());
        this.addMouseListener(mInputManager.getMouseListener());
        this.addMouseMotionListener(mInputManager.getMouseMotionListener());

        mScene = new Scene(this);
        add(mScene);
    }

    @Override
    public void start() {
        setVisible(true);
    }

    @Override
    public void update() {
        mScene.update();
    }

    @Override
    public IInputManager getInputManager() {
        return mInputManager;
    }
}
