package io.sprucehill.urbanairship.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Base class; ensures basic Jackson class level annotations
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public abstract class Base {
}
