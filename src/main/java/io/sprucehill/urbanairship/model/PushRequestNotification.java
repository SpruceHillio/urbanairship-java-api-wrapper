package io.sprucehill.urbanairship.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model DTP object for defining the push to send.
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushRequestNotification extends HashMap<String,Object> {

    /**
     * Get a Builder for this class.
     *
     * @return The Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A Builder object for the notification DTO model object
     *
     */
    public static class Builder {
        PushRequestNotification notification;

        protected Builder() {
            notification = new PushRequestNotification();
            notification.put("actions",new HashMap<>());
        }

        /**
         * Set the iOS specific notification definition.
         *
         * @param deviceNotification    The iOS specific notification instance
         * @return                      The Builder instance
         */
        public Builder withIOS(PushRequestIOSDeviceNotification deviceNotification) {
            notification.put("ios",deviceNotification);
            return this;
        }

        /**
         * Add an action to this notification.
         *
         * @param action    The action to add.
         * @return          The Builder instance
         */
        public Builder withAction(PushRequestNotificationAction action) {
            ((Map<String,Object>)notification.get("actions")).put(action.key(),action);
            return this;
        }

        /**
         * Builder the notification object.
         *
         * @return The notification DTO model object.
         */
        public PushRequestNotification build() {
            return notification;
        }
    }
}
