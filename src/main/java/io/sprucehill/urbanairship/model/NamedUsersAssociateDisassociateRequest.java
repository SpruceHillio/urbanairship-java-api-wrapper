package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for associating a named user with a channel
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class NamedUsersAssociateDisassociateRequest extends Base {

    @JsonProperty(value = "channel_id")
    String channelId;

    @JsonProperty(value = "device_type")
    DeviceType deviceType;

    @JsonProperty(value = "named_user_id")
    String namedUserId;

    /**
     * Retrieve a builder for this class
     *
     * @return A Builder to create an instance of this class
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     *
     */
    public static class Builder {

        NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest;

        Builder() {
            namedUsersAssociateDisassociateRequest = new NamedUsersAssociateDisassociateRequest();
        }

        /**
         * Set the channel and its device type
         *
         * @param channelId     The channel ID
         * @param deviceType    The device type
         * @return              The Builder object
         */
        public Builder withChannel(String channelId, DeviceType deviceType) {
            namedUsersAssociateDisassociateRequest.channelId = channelId;
            namedUsersAssociateDisassociateRequest.deviceType = deviceType;
            return this;
        }

        /**
         * Set the named user
         *
         * @param namedUserId   The named user ID
         * @return              The Builder object
         */
        public Builder withNamedUser(String namedUserId) {
            namedUsersAssociateDisassociateRequest.namedUserId = namedUserId;
            return this;
        }

        /**
         * Build the object
         *
         * @return  The final request object
         */
        public NamedUsersAssociateDisassociateRequest build() {
            return namedUsersAssociateDisassociateRequest;
        }
    }
}
