package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * DTO model class for iOS specific notification properties on a push request.
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushRequestIOSDeviceNotification extends PushRequestDeviceNotification {

    Map<String,Object> alertObject = new HashMap<>();

    String alertString;

    @JsonProperty
    public Object getAlert() {
        if (null == alertString) {
            return alertObject;
        }
        else {
            return alertString;
        }
    }

    /**
     * Get a Builder instance for this class.
     *
     * @return A Builder for this class.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A Builder instance for the iOS specific notification properties DTO model
     *
     */
    public static class Builder {
        PushRequestIOSDeviceNotification deviceNotification = new PushRequestIOSDeviceNotification();

        /**
         * Add a specific field for the Alert; this maybe e.g. LOCALIZATION_KEY
         *
         * @param key      A String for the key
         * @param value    A String for the value
         * @return         The Builder instance
         */
        public Builder withAlertField(String key, Object value) {
            deviceNotification.alertObject.put(key,value);
            return this;
        }

        /**
         *
         * @param alertString   The alert string; set to null if you want to unset it and use the AlertFields instead.
         * @return              The Builder instance
         */
        public Builder withAlertString(String alertString) {
            deviceNotification.alertString = alertString;
            return this;
        }

        /**
         * Build the iOS specific notification DTO model object
         *
         * @return The iOS specific notification DTO model object
         */
        public PushRequestIOSDeviceNotification build() {
            return deviceNotification;
        }
    }
}
