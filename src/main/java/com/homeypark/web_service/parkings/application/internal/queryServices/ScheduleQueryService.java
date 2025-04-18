package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllScheduleQuery;
import com.homeypark.web_service.parkings.domain.services.IScheduleQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleQueryService implements IScheduleQueryService {

    private final IScheduleRepository scheduleRepository;

    public ScheduleQueryService(IScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> handle(GetAllScheduleQuery query) {
        return scheduleRepository.findAll();
    }
}
