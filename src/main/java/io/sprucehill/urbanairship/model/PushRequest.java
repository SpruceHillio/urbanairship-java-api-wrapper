package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * Request object for sending pushes
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushRequest extends Base {

    @JsonProperty
    Audience audience;

    @JsonProperty(value = "device_types")
    Set<String> deviceTypes = new HashSet<>();

    @JsonProperty
    PushRequestNotification notification;

    /**
     * Retrieve a builder for this class
     *
     * @return A Builder to create an instance of this class
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        PushRequest pushRequest = new PushRequest();

        /**
         * Set the audience
         *
         * @param audience    The audience
         * @return            The Builder object
         */
        public Builder withAudience(Audience audience) {
            pushRequest.audience = audience;
            return this;
        }

        /**
         * Set the device type
         *
         * @param deviceType    The device type
         * @return              The Builder object
         */
        public Builder withDeviceType(String deviceType) {
            pushRequest.deviceTypes.add(deviceType);
            return this;
        }

        /**
         * Set the notification
         *
         * @param notification  The notification
         * @return              The Builder object
         */
        public Builder withNotification(PushRequestNotification notification) {
            pushRequest.notification = notification;
            return this;
        }

        /**
         * Build the object
         *
         * @return  The final request object
         */
        public PushRequest build() {
            return pushRequest;
        }
    }
}
