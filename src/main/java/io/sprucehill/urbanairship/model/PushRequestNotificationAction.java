package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An abstract parent class for notification actions.
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class PushRequestNotificationAction extends Base {

    @JsonIgnore
    public abstract String key();
}
