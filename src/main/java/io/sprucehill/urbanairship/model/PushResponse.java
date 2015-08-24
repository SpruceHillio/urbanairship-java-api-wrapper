package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Set;

/**
 * DTO model class for the push request response
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class PushResponse extends Response {

    @JsonProperty(value = "operation_id")
    String operationId;

    @JsonProperty(value = "push_ids")
    Set<String> pushIds;

    @JsonProperty(value = "message_ids")
    Set<String> messageIds;

    @JsonProperty(value = "content_urls")
    Set<String> contentUrls;

    /**
     * The operation ID
     *
     * @return The operation ID String
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * The specific push IDs
     *
     * @return A set of push IDs
     */
    public Set<String> getPushIds() {
        return Collections.unmodifiableSet(pushIds);
    }

    /**
     * The specific message IDs.
     *
     * @return A set of message IDs
     */
    public Set<String> getMessageIds() {
        return Collections.unmodifiableSet(messageIds);
    }

    /**
     * The content URLs
     *
     * @return A set of content URLs
     */
    public Set<String> getContentUrls() {
        return Collections.unmodifiableSet(contentUrls);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PushResponse{");
        sb.append("ok=").append(ok);
        sb.append(", operationId='").append(operationId).append('\'');
        sb.append(", pushIds=").append(pushIds);
        sb.append(", messageIds=").append(messageIds);
        sb.append(", contentUrls=").append(contentUrls);
        sb.append('}');
        return sb.toString();
    }
}
