package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.entity.DeviceAddress
import top.lu1kaifeng.playground.entity.TemperatureDevice
import top.lu1kaifeng.playground.repo.DeviceAddressRepo
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo
import top.lu1kaifeng.playground.service.PostService

@RestController
class TemperatureDeviceController @Autowired constructor(
    val temperatureDeviceRepo: TemperatureDeviceRepo
) : BaseSecuredController() {
    @GetMapping("/temp/page")
    fun getEntries(@RequestParam length: Int,@RequestParam page: Int):Page<TemperatureDevice>{
        return temperatureDeviceRepo.findAllByOrderByDateCreatedDesc(Pageable.ofSize(length).withPage(page))
    }
    @GetMapping("/temp/page/byCaption")
    fun getEntriesByCaption(@RequestParam length: Int,@RequestParam page: Int,@RequestParam caption: String):Page<TemperatureDevice>{
        return temperatureDeviceRepo.findAllByCaptionOrderByDateCreatedDesc(caption,Pageable.ofSize(length).withPage(page))
    }
}

@RestController
class DeviceAddressController @Autowired constructor(
    val deviceAddressRepo: DeviceAddressRepo
) : BaseSecuredController() {
    @PostMapping("/device")
    fun postEntries(@RequestBody deviceAddress: DeviceAddress){
        deviceAddressRepo.save(deviceAddress)
    }
    @DeleteMapping("/device")
    fun delEntries(@RequestParam id:Long): ResponseEntity<Void>{
        val result = deviceAddressRepo.findByIdOrNull(id)
        return if(result == null){
            ResponseEntity.notFound().build()
        }else{
            deviceAddressRepo.delete(result)
            ResponseEntity.ok().build()
        }
    }
    @GetMapping("/device")
    fun getDevice(@RequestParam nodeId:Int,@RequestParam dataId: Int):DeviceAddress{
        return deviceAddressRepo.findAllByNodeIdAndDataId(nodeId, dataId)
    }
    @GetMapping("/device/all")
    fun getAllDevices():List<DeviceAddress>{
        return deviceAddressRepo.findAll()
    }
}