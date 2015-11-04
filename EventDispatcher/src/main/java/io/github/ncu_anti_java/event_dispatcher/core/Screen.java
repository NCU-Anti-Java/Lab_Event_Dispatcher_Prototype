package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IEvent;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Davy on 2015/11/4.
 */
public class Screen extends JPanel implements IScreen {
    final String mName;

    public Screen(final String name) {
        super(new GridLayout(1, 1));

        mName = name;
    }

    @Override
    public boolean dispatchEvent(IEvent e) {
        System.out.println(String.format("%s: %s", mName, e.toString()));
        return true;
    }
}
