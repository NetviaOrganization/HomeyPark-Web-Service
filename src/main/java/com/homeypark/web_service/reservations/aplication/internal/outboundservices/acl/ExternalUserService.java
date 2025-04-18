package com.homeypark.web_service.reservations.aplication.internal.outboundservices.acl;

import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import com.homeypark.web_service.user.interfaces.acl.UserContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalUserService {
    private final UserContextFacade userContextFacade;

    public ExternalUserService(UserContextFacade userContextFacade) {
        this.userContextFacade = userContextFacade;
    }

    public boolean checkUserExistById(Long userId){
        return userContextFacade.checkUserExistById(userId);
    }

}
