package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.Channel;
import io.sprucehill.urbanairship.model.ChannelLookupResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * Implementation of the IChannelService interface
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class ChannelService extends AbstractService implements IChannelService {

    @Override
    public Channel lookup(String channelId) {
        try {
            HttpGet request = getRequest("/api/channels/" + channelId);
            HttpResponse response = sendRequest(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                ChannelLookupResponse channelLookupResponse = objectMapper.readValue(response.getEntity().getContent(),ChannelLookupResponse.class);
                if (channelLookupResponse.isOk()) {
                    return channelLookupResponse.getChannel();
                }
            }
        }
        catch (Throwable t) {
            logger.warn(t.getMessage(),t);
        }
        return null;
    }
}
