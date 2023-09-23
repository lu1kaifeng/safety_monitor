package top.lu1kaifeng.playground

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent

import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import top.lu1kaifeng.playground.entity.DeviceAddress
import top.lu1kaifeng.playground.entity.Post
import top.lu1kaifeng.playground.entity.Subject
import top.lu1kaifeng.playground.entity.TemperatureDevice
import top.lu1kaifeng.playground.repo.DeviceAddressRepo
import top.lu1kaifeng.playground.repo.PostRepo
import top.lu1kaifeng.playground.repo.SubjectRepo
import top.lu1kaifeng.playground.repo.TemperatureDeviceRepo
import java.time.Instant
import java.util.*


@Component
class ApplicationStartUp @Autowired constructor(val subjectRepo: SubjectRepo, val postRepo: PostRepo,val temperatureDeviceRepo: TemperatureDeviceRepo,val deviceAddressRepo: DeviceAddressRepo) :
    ApplicationListener<ApplicationReadyEvent?> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        subjectRepo.save(Subject(null, "admin", "admin"))
        postRepo.save(Post(null, "asdas"))
        temperatureDeviceRepo.save(TemperatureDevice(null,1,1,"AirPressure",33.23,"", Date.from(Instant.now())))
        temperatureDeviceRepo.save(TemperatureDevice(null,1,2,"Temperature",33.23,"", Date.from(Instant.now())))
        deviceAddressRepo.save(DeviceAddress(null,0,0,"11111","fleshlight","fleshlight","fleshlight",0))
        return
    }
}