package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllScheduleQuery;

import java.util.List;

public interface IScheduleQueryService {
    List<Schedule> handle(GetAllScheduleQuery query);
}
