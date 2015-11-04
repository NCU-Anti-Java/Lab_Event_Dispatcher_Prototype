package io.github.ncu_anti_java.event_dispatcher.core;

import io.github.ncu_anti_java.event_dispatcher.core.iface.IEvent;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IScene;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IWindow;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Davy on 2015/11/3.
 */
public class Scene extends JPanel implements IScene {
    final Window mWindow;
    final Screen[] mPanels;

    public Scene(final Window window) {
        mWindow = window;
        setLayout(new GridBagLayout());

        mPanels = new Screen[10];
        final Border border = BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new LineBorder(Color.BLACK, 2));

        final GridBagConstraints gbc = new GridBagConstraints();
        mPanels[1] = new Screen("screen 1");
        mPanels[1].setBorder(border);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        add(mPanels[1], gbc);

        mPanels[9] = new Screen("screen 9");
        mPanels[9].setBorder(border);

        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.25;

        add(mPanels[9], gbc);

        mPanels[8] = new Screen("screen 8");
        mPanels[8].setBorder(border);

        gbc.gridx = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 0.75;

        add(mPanels[8], gbc);

        JPanel tmp = new JPanel(new GridLayout(2, 3, 5, 5));
        for (int i = 2; i <= 7; i++) {
            mPanels[i] = new Screen("screen " + i);
            mPanels[i].setBorder(border);
            tmp.add(mPanels[i]);
        }
        gbc.gridx = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;

        add(tmp, gbc);
    }

    @Override
    public void update() {
        final List<IEvent> events = mWindow.getInputManager().getEvents();
        for (final IEvent event : events) {
            if (event.toString() == null)
                continue;
            Point point = event.getPosition();
            if (event instanceof MouseEvent)
                point = new Point(point.x + mWindow.getLocationOnScreen().x,
                                  point.y + mWindow.getLocationOnScreen().y);

            for (int x = 1; x < mPanels.length; ++x) {
                final Screen panel = mPanels[x];
                final Point panelStartLocation = panel.getLocationOnScreen();
                final Point panelEndLocation = panel.getLocationOnScreen();
                panelEndLocation.translate(panel.getWidth(), panel.getHeight());
                if (panelStartLocation.x <= point.x &&
                        panelStartLocation.y <= point.y &&
                        panelEndLocation.x > point.x &&
                        panelEndLocation.y > point.y)
                    // Dispatch now
                    if (panel.dispatchEvent(event))
                        break;
            }
        }
    }
}
