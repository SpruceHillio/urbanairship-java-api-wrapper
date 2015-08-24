package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.TagsRequest;

/**
 * Service interface interacting with tags on both channels as well as named users
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public interface ITagsService {

    /**
     * Update tags on either channel IDs or namedUser IDs
     *
     * @param tagsRequest    The request to send
     * @return True if the tags have been successfully updated, false otherwise
     */
    boolean updateTags(TagsRequest tagsRequest);
}
