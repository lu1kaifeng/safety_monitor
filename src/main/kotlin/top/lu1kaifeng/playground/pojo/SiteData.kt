package top.lu1kaifeng.playground.pojo


import com.fasterxml.jackson.annotation.JsonProperty
import top.lu1kaifeng.playground.entity.TemperatureDevice
import java.time.Instant
import java.util.*


data class SiteData(
    @JsonProperty("nodeid") var nodeid: Int,
    @JsonProperty("data") var data: MutableList<SiteDataEntry>


){
    fun toEntities() =  data.map { TemperatureDevice(nodeid, dataId = it.id, caption = it.caption, dataValue = it.value, description = it.description,dateCreated = Date.from(
            Instant.now())) }

}

class SiteDataEntry(
    @JsonProperty("id")var id:Int,
    @JsonProperty("caption")var caption: String,
    @JsonProperty("value")var value: Double,
    @JsonProperty("description")var description: String
)