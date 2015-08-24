package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.NamedUsersAssociateDisassociateRequest;

/**
 * Service interface to interact with namedUsers
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public interface INamedUsersService {

    /**
     * Associate a specific channel ID with a namedUser ID
     *
     * @param namedUsersAssociateDisassociateRequest    The request DTO model object
     * @return True if the channel ID has been successfully associated with the namedUser ID, false otherwise
     */
    boolean associate(NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest);

    /**
     * Disassociate a specific channel ID from a namedUser ID
     *
     * @param namedUsersAssociateDisassociateRequest    The request DTO model object
     * @return True if the channel ID has been successfully disassociated with the namedUser ID, false otherwise
     */
    boolean disassociate(NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest);
}
