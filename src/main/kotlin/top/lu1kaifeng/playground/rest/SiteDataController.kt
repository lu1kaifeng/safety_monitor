package top.lu1kaifeng.playground.rest

import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.entity.Post
import top.lu1kaifeng.playground.pojo.SiteData
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo
import top.lu1kaifeng.playground.service.AESDecryptService
import top.lu1kaifeng.playground.service.PostService
import javax.crypto.spec.SecretKeySpec
import javax.servlet.http.HttpServletRequest

@RestController
class SiteDataController @Autowired constructor(
    val temperatureDeviceRepo: TemperatureDeviceRepo,
    val aesDecryptService: AESDecryptService
) : BaseSecuredController(){
    @PostMapping("/sendfromdevice")
    fun sendFromDevice(request: HttpServletRequest){
        temperatureDeviceRepo.saveAll(aesDecryptService.decrypt(        request.inputStream.readAllBytes()).toEntities())
    }
}