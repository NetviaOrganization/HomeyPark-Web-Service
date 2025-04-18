package com.homeypark.web_service.user.application.internal.queryServices;

import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.queries.GetAllVehiclesQuery;
import com.homeypark.web_service.user.domain.model.queries.GetVehicleByIdQuery;
import com.homeypark.web_service.user.domain.services.IVehicleQueryService;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleQueryService implements IVehicleQueryService {

    private final IVehicleRepository vehicleRepository;

    public VehicleQueryService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> handle(GetVehicleByIdQuery query) {
        return vehicleRepository.findById(query.vehicleId());
    }

    @Override
    public List<Vehicle> handle(GetAllVehiclesQuery query) {
        return vehicleRepository.findAll();
    }

}