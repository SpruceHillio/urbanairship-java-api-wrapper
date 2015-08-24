package io.sprucehill.urbanairship.service;

import io.sprucehill.urbanairship.model.Response;
import io.sprucehill.urbanairship.model.NamedUsersAssociateDisassociateRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

/**
 * Implementation of the named users service interface
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class NamedUsersService extends AbstractService implements INamedUsersService {

    @Override
    public boolean associate(NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest) {
        return associateOrDisassociate(namedUsersAssociateDisassociateRequest,"/api/named_users/associate");
    }

    @Override
    public boolean disassociate(NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest) {
        return associateOrDisassociate(namedUsersAssociateDisassociateRequest,"/api/named_users/disassociate");
    }

    boolean associateOrDisassociate(NamedUsersAssociateDisassociateRequest namedUsersAssociateDisassociateRequest, String path) {
        try {
            HttpPost request = postRequest(path);
            request.setEntity(new StringEntity(objectMapper.writeValueAsString(namedUsersAssociateDisassociateRequest), ContentType.APPLICATION_JSON));
            HttpResponse response = sendRequest(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                return objectMapper.readValue(response.getEntity().getContent(),Response.class).isOk();
            }
            else {
                logger.info("Got unexpected response code {} for associating named user", response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            logger.warn(e.getMessage(), e);
        }
        return false;
    }
}
