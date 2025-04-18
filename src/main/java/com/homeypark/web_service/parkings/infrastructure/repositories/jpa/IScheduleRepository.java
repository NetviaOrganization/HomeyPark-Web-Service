package com.homeypark.web_service.parkings.infrastructure.repositories.jpa;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}
