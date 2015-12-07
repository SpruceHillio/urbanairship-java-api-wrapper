package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Model DTO class that defines an Audience selector.
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class Audience extends Base {

    @JsonProperty(value = "ios_channel")
    Set<String> iOSChannel;

    @JsonProperty(value = "android_channel")
    Set<String> androidChannel;

    @JsonProperty(value = "amazon_channel")
    Set<String> amazonChannel;

    @JsonProperty(value = "named_user_id")
    Set<String> namedUserId;

    /**
     * Get the set iOS channel IDs.
     *
     * This will be an immutable set.
     *
     * @return A set of iOS channel IDs; will never be null.
     */
    public Set<String> getiOSChannel() {
        return null == iOSChannel ? null : Collections.unmodifiableSet(iOSChannel);
    }

    /**
     * Get the set Android channel IDs
     *
     * This will be an immutable set.
     *
     * @return A set of Android channel IDs; will never be null.
     */
    public Set<String> getAndroidChannel() {
        return null == androidChannel ? null : Collections.unmodifiableSet(androidChannel);
    }

    /**
     * Get the set Amazon channel IDs
     *
     * This will be an immutable set.
     *
     * @return A set of Amazon channel IDs; will never be null.
     */
    public Set<String> getAmazonChannel() {
        return null == amazonChannel ? null : Collections.unmodifiableSet(amazonChannel);
    }

    /**
     * Get the set of namedUser IDs
     *
     * This will be an immutable set.
     *
     * @return A set of namedUser IDs; will never be null.
     */
    public Set<String> getNamedUserId() {
        return null == namedUserId ? null : Collections.unmodifiableSet(namedUserId);
    }

    /**
     * Get a Builder instance for the class
     *
     * @return A Builder for the Audience DTO class.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     *
     */
    public static class Builder {
        Audience audience = new Audience();

        /**
         * Add an iOS channel ID to the audience.
         *
         * Adding an iOS channel ID will reset any maybe set namedUser IDs
         *
         * @param channelId    The iOS channel ID
         * @return             The Builder instance
         */
        public Builder withIOSChannel(String channelId) {
            if (null == audience.iOSChannel) {
                audience.iOSChannel = new HashSet<>();
            }
            audience.iOSChannel.add(channelId);
            audience.namedUserId = null;
            return this;
        }

        /**
         * Add multiple iOS channel IDs.
         *
         * Adding iOS channel IDs will reset any maybe set namedUser IDs
         *
         * @param channelIds   The iOS channel IDs
         * @return             The Builder instance
         */
        public Builder withIOSChannels(Set<String> channelIds) {
            if (null == audience.iOSChannel) {
                audience.iOSChannel = new HashSet<>();
            }
            audience.iOSChannel.addAll(channelIds);
            audience.namedUserId = null;
            return this;
        }


        /**
         * Add an Android channel ID.
         *
         * Adding an Android channel ID will reset any maybe set namedUser IDs
         *
         * @param channelId    The Android channel ID
         * @return             The Builder instance
         */
        public Builder withAndroidChannel(String channelId) {
            if (null == audience.androidChannel) {
                audience.androidChannel = new HashSet<>();
            }
            audience.androidChannel.add(channelId);
            audience.namedUserId = null;
            return this;
        }

        /**
         * Add multiple Android channel IDs.
         *
         * Adding Android channel IDs will reset any maybe set namedUser IDs
         *
         * @param channelIds   The Android channel IDs
         * @return             The Builder instance
         */
        public Builder withAndroidChannels(Set<String> channelIds) {
            if (null == audience.androidChannel) {
                audience.androidChannel = new HashSet<>();
            }
            audience.androidChannel.addAll(channelIds);
            audience.namedUserId = null;
            return this;
        }

        /**
         * Add an Amazon channel ID.
         *
         * Adding an Amazon channel ID will reset any maybe set namedUser IDs.
         *
         * @param channelId    The Amaze channel ID
         * @return             The Builder instance
         */
        public Builder withAmazonChannel(String channelId) {
            if (null == audience.amazonChannel) {
                audience.amazonChannel = new HashSet<>();
            }
            audience.amazonChannel.add(channelId);
            audience.namedUserId = null;
            return this;
        }

        /**
         * Add multiple Amazon channel IDs.
         *
         * Adding Amazon channel IDs will reset any maybe set namedUser IDs.
         *
         * @param channelIds   The Amazon channel IDs
         * @return             The Builder instance
         */
        public Builder withAmazonChannels(Set<String> channelIds) {
            if (null == audience.amazonChannel) {
                audience.amazonChannel = new HashSet<>();
            }
            audience.amazonChannel.addAll(channelIds);
            audience.namedUserId = null;
            return this;
        }

        /**
         * Add a namedUser ID.
         *
         * Adding a namedUser ID will reset any maybe set iOS channel IDs, Android channel IDs and Amazon channel IDs
         *
         * @param namedUserId  The namedUser ID
         * @return             The Builder instance
         */
        public Builder withNamedUser(String namedUserId) {
            if (null == audience.namedUserId) {
                audience.namedUserId = new HashSet<>();
            }
            audience.namedUserId.add(namedUserId);
            audience.iOSChannel = null;
            audience.androidChannel = null;
            audience.amazonChannel = null;
            return this;
        }

        /**
         * Add multiple namedUser IDs.
         *
         * Adding namedUser IDs will reset any maybe set iOS channel IDs, Android channel IDs and Amazon channel IDs
         *
         * @param namedUserIds The namedUser IDs
         * @return             The Builder instance
         */
        public Builder withNamedUsers(Set<String> namedUserIds) {
            if (null == audience.namedUserId) {
                audience.namedUserId = new HashSet<>();
            }
            audience.namedUserId.addAll(namedUserIds);
            audience.iOSChannel = null;
            audience.androidChannel = null;
            audience.amazonChannel = null;
            return this;
        }

        /**
         * Build the Audience instance
         *
         * @return  The built Audience instance
         */
        public Audience build() {
            return audience;
        }
    }
}
