package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A DTO model object for an OPEN action
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushRequestNotificationOpenAction extends PushRequestNotificationAction {

    /**
     * The possible type for the OPEN action
     */
    public enum Type {
        DEEP_LINK
    }

    Type type;

    @JsonProperty
    String content;

    @JsonProperty
    public String getType() {
        return type.name().toLowerCase();
    }

    @Override
    public String key() {
        return "open";
    }

    /**
     * Get a Builder instance for the OPEN action model DTO object
     *
     * @return The Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A Builder object for the OPEN action DTO model class
     *
     */
    public static class Builder {
        PushRequestNotificationOpenAction action = new PushRequestNotificationOpenAction();

        /**
         * Set the type of this OPEN action
         *
         * @param type    The type of this OPEN action
         * @return        The Builder instance
         */
        public Builder withType(Type type) {
            action.type = type;
            return this;
        }

        /**
         * Set the content of this OPEN action
         *
         * @param content    The content of this OPEN action
         * @return           The Builder instance
         */
        public Builder withContent(String content) {
            action.content = content;
            return this;
        }

        /**
         * Builder the OPEN action instance
         *
         * @return The OPEN action DTO model instance
         */
        public PushRequestNotificationAction build() {
            return action;
        }
    }
}
