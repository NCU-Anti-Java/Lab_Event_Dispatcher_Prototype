package io.github.ncu_anti_java.event_dispatcher;

import io.github.ncu_anti_java.event_dispatcher.core.Window;
import io.github.ncu_anti_java.event_dispatcher.core.iface.IWindow;

/**
 * Created by Davy on 2015/11/3.
 */
public class Entry {
    final static double fps = 60.0;
    final static double cycle = 1.0 / fps;

    final static Thread mainLoop = new Thread() {
        @Override
        public void run() {
            IWindow window = new Window("EventDispatcher");
            window.start();
            long timestamp = System.currentTimeMillis();
            while (true) {
                window.update();

                long cur_t = System.currentTimeMillis();
                if ((cur_t - timestamp) < (cycle * 1000)) {
                    try {
                        sleep(timestamp - cur_t + (long) (cycle * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                timestamp = System.currentTimeMillis();
            }
        }
    };

    public static void main(String[] args) {
        mainLoop.start();
    }
}
