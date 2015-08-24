package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Setting tags on either channel IDs or namedUser IDs
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TagsRequest extends Base {

    @JsonProperty(value = "audience")
    Audience audience;

    @JsonProperty(value = "add")
    Map<String,Set<String>> add;

    @JsonProperty(value = "remove")
    Map<String,Set<String>> remove;

    @JsonProperty(value = "set")
    Map<String,Set<String>> set;

    protected TagsRequest() {}

    /**
     * Get the audience selector
     *
     * @return The Audience.
     */
    public Audience getAudience() {
        return audience;
    }

    /**
     * Get a Builder for this object
     *
     * @return The Builder object
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A Builder for the tags request DTO model object
     *
     */
    public static class Builder {

        TagsRequest tagsRequest;

        protected Builder () {
            tagsRequest = new TagsRequest();
        }

        /**
         * Set the Audience for the request
         *
         * @param audience    The Audience
         * @return            The Builder instance
         */
        public Builder withAudience(Audience audience) {
            tagsRequest.audience = audience;
            return this;
        }

        /**
         * Add a tag to that tag group.
         *
         * Adding a tag will unset any maybe set set tags tag groups.
         *
         * @param tag         The tag to add
         * @param tagGroup    The tag group to add the tag to
         * @return            The builder instance
         */
        public Builder addTagToTagGroup(String tag, String tagGroup) {
            if (!tagsRequest.add.containsKey(tagGroup)) {
                tagsRequest.add.put(tagGroup,new HashSet<>());
            }
            tagsRequest.add.get(tagGroup).add(tag);
            tagsRequest.set.clear();
            return this;
        }

        /**
         * Adds multiple tags to that tag group
         *
         * Adding tags will unset any maybe set set tags tag groups.
         *
         * @param tags        The tags to add
         * @param tagGroup    The tag group to add the tags to
         * @return            The builder instance
         */
        public Builder addTagsToTagGroup(Set<String> tags, String tagGroup) {
            if (!tagsRequest.add.containsKey(tagGroup)) {
                tagsRequest.add.put(tagGroup,new HashSet<>());
            }
            tagsRequest.add.get(tagGroup).addAll(tags);
            tagsRequest.set.clear();
            return this;
        }

        /**
         * Remove a tag from that tag group
         *
         * Removing a tag will unset any maybe set set tags tag groups.
         *
         * @param tag         The tag to remove
         * @param tagGroup    The tag group to remove the tag from
         * @return            The builder instance
         */
        public Builder removeTagToTagGroup(String tag, String tagGroup) {
            if (!tagsRequest.remove.containsKey(tagGroup)) {
                tagsRequest.remove.put(tagGroup,new HashSet<>());
            }
            tagsRequest.remove.get(tagGroup).add(tag);
            tagsRequest.set.clear();
            return this;
        }

        /**
         * Remove tags from that tag group
         *
         * Removing tags will unset any maybe set set tags tag groups.
         *
         * @param tags        The tags to remove
         * @param tagGroup    The tag group to remove the tags from
         * @return            The builder instance
         */
        public Builder removeTagsToTagGroup(Set<String> tags, String tagGroup) {
            if (!tagsRequest.remove.containsKey(tagGroup)) {
                tagsRequest.remove.put(tagGroup,new HashSet<>());
            }
            tagsRequest.remove.get(tagGroup).addAll(tags);
            tagsRequest.set.clear();
            return this;
        }

        /**
         * Set the tags for that tag group to the submitted tag
         *
         * Setting a tag to a tag group will unset and maybe set add and remove tag group
         *
         * @param tag         The tag to that the tag group to
         * @param tagGroup    The tag group to operate on
         * @return            The builder instance
         */
        public Builder setTagToTagGroup(String tag, String tagGroup) {
            if (!tagsRequest.set.containsKey(tagGroup)) {
                tagsRequest.set.put(tagGroup,new HashSet<>());
            }
            tagsRequest.set.get(tagGroup).add(tag);
            tagsRequest.add.clear();
            tagsRequest.remove.clear();
            return this;
        }

        /**
         * Se the tags for that tag group to the submitted tags
         *
         * Setting tags to a tag group will unset and maybe set add and remove tag group
         *
         * @param tags        The tags to set the tag group to
         * @param tagGroup    The tag group to operate on
         * @return            The builder instance
         */
        public Builder setTagsToTagGroup(Set<String> tags, String tagGroup) {
            if (!tagsRequest.set.containsKey(tagGroup)) {
                tagsRequest.set.put(tagGroup,new HashSet<>());
            }
            tagsRequest.set.get(tagGroup).addAll(tags);
            tagsRequest.add.clear();
            tagsRequest.remove.clear();
            return this;
        }

        /**
         * Get the tags request DTO model object
         *
         * @return The tags request DTO model object
         */
        public TagsRequest build() {
            return tagsRequest;
        }
    }
}
