package top.lu1kaifeng.playground.repo

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import top.lu1kaifeng.playground.entity.*



@Repository
interface TemperatureDeviceRepo : JpaRepository<TemperatureDevice, Long>{
    fun findAllByOrderByDateCreatedDesc(pageable: Pageable) : Page<TemperatureDevice>
    fun findAllByCaptionOrderByDateCreatedDesc(caption: String, pageable: Pageable) : Page<TemperatureDevice>
}

@Repository
interface WeightMeasurementDeviceRepo : JpaRepository<WeightMeasurementDevice, Long>

@Repository
interface SafetyInformationRepo : JpaRepository<SafetyInformation, Long>

@Repository
interface DeviceAddressRepo : JpaRepository<DeviceAddress, Long>{
    fun findByNodeIdAndDataId(nodeId:Int, dataId:Int): DeviceAddress?
}

@Repository
interface ManufacturerInfoRepo : JpaRepository<ManufacturerInfo, Long>