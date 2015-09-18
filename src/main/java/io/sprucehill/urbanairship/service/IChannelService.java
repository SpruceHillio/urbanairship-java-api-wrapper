package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.Channel;

/**
 * Service interface to interact with channels
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public interface IChannelService {

    /**
     * Get details for a specific channel identified by the supplied channelId
     *
     * @param channelId    The channelId to lookup
     * @return             The Channel object if found, null otherwise.
     */
    Channel lookup(String channelId);
}
