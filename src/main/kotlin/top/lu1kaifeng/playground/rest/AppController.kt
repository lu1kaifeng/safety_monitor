package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.entity.TemperatureDevice
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo

@RestController
class TemperatureDeviceController @Autowired constructor(
    val temperatureDeviceRepo: TemperatureDeviceRepo
) : BaseSecuredController() {
    @GetMapping("/temp/page")
    fun getEntries(@RequestParam length: Int): Page<TemperatureDevice> {
        return temperatureDeviceRepo.findAllByOrderByDateCreatedDesc(Pageable.ofSize(length).withPage(0))
    }
}