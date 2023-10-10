package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import top.lu1kaifeng.playground.entity.DeviceAddress
import top.lu1kaifeng.playground.entity.TemperatureDevice
import top.lu1kaifeng.playground.entity.VehicleRecord
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo
import top.lu1kaifeng.playground.repo.VehicleRecordRepo
import top.lu1kaifeng.playground.service.AESDecryptService

@RestController
class VehicleRecordController @Autowired constructor(
    val vehicleRecordRepo: VehicleRecordRepo
) : BaseSecuredController() {
    @PostMapping("/vehicle")
    fun postVehicleRecords(@RequestBody vehicleRecord: VehicleRecord){
        vehicleRecordRepo.save(vehicleRecord)
    }
    @DeleteMapping("/vehicle")
    fun delVehicleRecords(@RequestParam id:Long): ResponseEntity<Void> {
        val result = vehicleRecordRepo.findByIdOrNull(id)
        return if(result == null){
            ResponseEntity.notFound().build()
        }else{
            vehicleRecordRepo.delete(result)
            ResponseEntity.ok().build()
        }
    }
    @GetMapping("/vehicle/license")
    fun getFirstByLicense(@RequestParam license:String): ResponseEntity<VehicleRecord> {
        val result = vehicleRecordRepo.findFirstByLicenseOrderByDateCreated(license)
        return if(result == null){
            ResponseEntity.notFound().build()
        }else{
            ResponseEntity.ok(result)
        }
    }
    @GetMapping("/vehicle/license/page")
    fun getVehicleRecordPageByLicense(@RequestParam license:String, @RequestParam length: Int,@RequestParam page: Int): Page<VehicleRecord> {
        return vehicleRecordRepo.findByLicenseOrderByDateCreated(license,Pageable.ofSize(length).withPage(page))
    }
    @GetMapping("/vehicle/page")
    fun getVehicleRecordPage(@RequestParam length: Int,@RequestParam page: Int): Page<VehicleRecord> {
        return vehicleRecordRepo.findAll(Pageable.ofSize(length).withPage(page))
    }
}