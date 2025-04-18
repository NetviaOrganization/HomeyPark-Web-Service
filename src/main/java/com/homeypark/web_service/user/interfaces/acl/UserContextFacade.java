package com.homeypark.web_service.user.interfaces.acl;

import com.homeypark.web_service.user.application.internal.commandServices.UserCommandService;
import com.homeypark.web_service.user.application.internal.queryServices.UserQueryService;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import org.springframework.stereotype.Service;

@Service
public class UserContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public boolean checkUserExistById(Long userId){
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty())
            return false;
        return true;
    }

}
