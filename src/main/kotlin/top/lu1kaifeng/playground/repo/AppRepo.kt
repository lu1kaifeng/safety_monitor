package top.lu1kaifeng.playground.repo

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import top.lu1kaifeng.playground.entity.*


@Repository
interface TemperatureDeviceRepo : JpaRepository<TemperatureDevice, Int> {
    fun findAllByOrderByDateCreatedDesc(pageable: Pageable): Page<TemperatureDevice>
}

@Repository
interface WeightMeasurementDeviceRepo : JpaRepository<WeightMeasurementDevice, Int>

@Repository
interface SafetyInformationRepo : JpaRepository<SafetyInformation, Int>

@Repository
interface DeviceAddressRepo : JpaRepository<DeviceAddress, Int>

@Repository
interface ManufacturerInfoRepo : JpaRepository<ManufacturerInfo, Int>