package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.PushRequest;
import io.sprucehill.urbanairship.model.PushResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;

/**
 * Implementation of the push service interface
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushService extends AbstractService implements IPushService {

    @Override
    public boolean sendSimple(PushRequest pushRequest) {
        PushResponse pushResponse = send(pushRequest);
        return null != pushResponse && pushResponse.isOk();
    }

    @Override
    public PushResponse send(PushRequest pushRequest) {
        HttpPost request = postRequest("/api/push");
        try {
            HttpResponse response = sendRequest(request);
            if (202 == response.getStatusLine().getStatusCode()) {
                return objectMapper.readValue(response.getEntity().getContent(), PushResponse.class);
            }
            else {
                logger.info("Got unexpected response code {} for sending push", response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            logger.warn(e.getMessage(),e);
        }
        // TODO Correct error handling
        return null;
    }
}
