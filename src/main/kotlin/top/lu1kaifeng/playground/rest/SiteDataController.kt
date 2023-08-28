package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo
import top.lu1kaifeng.playground.service.AESDecryptService
import javax.servlet.http.HttpServletRequest

@RestController
class SiteDataController @Autowired constructor(
    val temperatureDeviceRepo: TemperatureDeviceRepo,
    val aesDecryptService: AESDecryptService
) : BaseSecuredController() {
    @PostMapping("/sendfromdevice")
    fun sendFromDevice(request: HttpServletRequest) {
        temperatureDeviceRepo.saveAll(aesDecryptService.decrypt(request.inputStream.readAllBytes()).toEntities())
    }
}