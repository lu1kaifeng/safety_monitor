package top.lu1kaifeng.playground.entity
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TemperatureDevice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val nodeId: Int?,
    val dataId: Int,
    val caption: String,
    val dataValue: Double,
    val description: String,
    val dateCreated: Date
)

@Entity
data class WeightMeasurementDevice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val nodeId: Int?,
    val dataId: Int,
    val caption: String,
    val dataValue: Double,
    val truckId: String,
    val picPath: String,
    val dateCreated: Date
)

@Entity
data class SafetyInformation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val nodeId: Int?,
    val eventName: String,
    val picPath: String,
    val eventTime: String,
    val description: String,
    val dateCreated: Date
)

@Entity
data class DeviceAddress(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val nodeId: Int,
    val dataId: Int,
    val address: String,
    val caption: String,
    val description: String,
    val name: String,
    val manufacturerId: Int
)

@Entity
data class ManufacturerInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val manufacturerId: Int?,
    val manufacturerName: String,
    val caption: String
)