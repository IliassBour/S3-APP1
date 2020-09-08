package menufact;

import java.util.ArrayList;

/**
 * Interface d'une notification
 */
public interface Notification<Input> {
    void Notifier(ArrayList<Input> input);
}
