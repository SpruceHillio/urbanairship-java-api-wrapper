package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.PushRequest;
import io.sprucehill.urbanairship.model.PushResponse;

/**
 * Service interface to send pushes
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public interface IPushService {

    /**
     * Send a push; this method simply returns a boolean value indicating success or failure.
     *
     * @param pushRequest    The push request to send
     * @return True of the push has been successfully sent, false otherwise
     */
    boolean sendSimple(PushRequest pushRequest);

    /**
     * Send a push; this method returns the whole PushResponse object
     *
     * @param pushRequest    The push request to send
     * @return The PushResponse object
     */
    PushResponse send(PushRequest pushRequest);
}
