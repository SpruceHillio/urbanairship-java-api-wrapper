package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Model DTO class for a channel
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class Channel extends Base {

    @JsonProperty(value = "channel_id")
    String id;

    @JsonProperty(value = "device_type")
    DeviceType deviceType;

    @JsonProperty(value = "installed")
    Boolean installed;

    @JsonProperty(value = "background")
    Boolean background;

    @JsonProperty(value = "opt_in")
    Boolean optIn;

    @JsonProperty(value = "push_address")
    String pushAddress;

    @JsonProperty(value = "created")
    Date created;

    @JsonProperty(value = "last_registration")
    Date lastRegistration;

    @JsonProperty(value = "alias")
    String alias;

    @JsonProperty(value = "tags")
    Set<String> tags;

    @JsonProperty(value = "tag_groups")
    Map<String,Set<String>> tagGroups;

    /**
     * Get the channel ID
     *
     * @return  A String
     */
    public String getId() {
        return id;
    }

    /**
     * Get the device type
     *
     * @return  A DeviceType enum constant
     */
    public DeviceType getDeviceType() {
        return deviceType;
    }

    /**
     * Specifies whether the channel is installed or not.
     *
     * @return  A Boolean
     */
    public Boolean getInstalled() {
        return installed;
    }

    /**
     * Specifies whether the device associated with this channel has background app refresh enabled. If this is true, then the device can receive background push. This field only appears for iOS devices on the 5.0+ SDK.
     *
     * @return  A Boolean
     */
    public Boolean getBackground() {
        return background;
    }

    /**
     * Specifies whether this channel is opted-in to push. For devices on SDK 4.0 or under, we assume this is true except in the following two scenerios: the app has been uninstalled, or the user explicitly disabled push from within the app.
     *
     * @return  A Boolean
     */
    public Boolean getOptIn() {
        return optIn;
    }

    /**
     * The underlying device identifier (e.g. a device token, APID, or BlackBerry PIN) that maps to this channel.
     *
     * @return  A String
     */
    public String getPushAddress() {
        return pushAddress;
    }

    /**
     * The creation date of this channel identifier.
     *
     * @return  A Date
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Displays the last registration date of this channel, if it is known.
     *
     * @return  A Date if known, null otherwise
     */
    public Date getLastRegistration() {
        return lastRegistration;
    }

    /**
     * Displays the alias associated with this channel, if one exists.
     *
     * @return  A String if set, null otherwise
     */
    public String getAlias() {
        return alias;
    }

    /**
     * A Set of tags associated with this channel
     *
     * @return  A Set of Strings
     */
    public Set<String> getTags() {
        return tags;
    }

    /**
     * A Map of Set of tags associated with this channel
     *
     * @return  A Map of Set of Strings
     */
    public Map<String, Set<String>> getTagGroups() {
        return tagGroups;
    }
}
