package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response wrapper object for channel lookup
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class ChannelLookupResponse extends Response {

    @JsonProperty
    Channel channel;

    /**
     * Get the channel object
     *
     * @return  The Channel object if successful response, null otherwise
     */
    public Channel getChannel() {
        return channel;
    }
}
