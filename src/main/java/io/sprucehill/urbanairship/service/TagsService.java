package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.Audience;
import io.sprucehill.urbanairship.model.Response;
import io.sprucehill.urbanairship.model.TagsRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Implementation of the tags service interface
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TagsService extends AbstractService implements ITagsService {

    @Override
    public boolean updateTags(TagsRequest tagsRequest) {
        String path;
        if (null != tagsRequest.getAudience().getNamedUserId() && 0 < tagsRequest.getAudience().getNamedUserId().size()) {
            path = "/api/named_users/tags";
        }
        else {
            path = "/api/channels/tags";
        }
        try {
            HttpPost request = postRequest(path);
            request.setEntity(new StringEntity(objectMapper.writeValueAsString(tagsRequest), ContentType.APPLICATION_JSON));
            HttpResponse response = sendRequest(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                return objectMapper.readValue(response.getEntity().getContent(), Response.class).isOk();
            }
            else {
                logger.info("Got unexpected response code {} for sending push", response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            logger.warn(e.getMessage(),e);
        }
        // TODO Correct error handling
        return false;
    }
}
