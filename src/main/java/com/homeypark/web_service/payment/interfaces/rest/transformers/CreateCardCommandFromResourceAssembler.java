package com.homeypark.web_service.payment.interfaces.rest.transformers;

import com.homeypark.web_service.payment.domain.model.commands.CreateCardCommand;
import com.homeypark.web_service.payment.interfaces.rest.resources.CreateCardResource;

public class CreateCardCommandFromResourceAssembler {
    public static CreateCardCommand toCommandFromResource(CreateCardResource resource) {
        return new CreateCardCommand(resource.numCard(), resource.cvv(), resource.date(), resource.holder(), resource.userId());
    }
}
