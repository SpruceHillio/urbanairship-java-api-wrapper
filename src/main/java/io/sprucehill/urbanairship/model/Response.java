package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A generic response object.
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class Response extends Base {

    @JsonProperty(value = "ok")
    boolean ok;

    /**
     * Get the OK status of the response
     *
     * @return True of the request was success, False otherwise.
     */
    public boolean isOk() {
        return ok;
    }
}
