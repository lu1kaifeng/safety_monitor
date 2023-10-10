package top.lu1kaifeng.playground.service

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import jdk.jfr.DataAmount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import top.lu1kaifeng.playground.pojo.SiteData
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Service
class AESDecryptService(private val mySecretKey: SecretKey, private val initializationVector: ByteArray) {
    var objectMapper: ObjectMapper = ObjectMapper()
    @Autowired constructor(@Value("\${mcu.secret}") MCUsecret: String, @Value("\${mcu.iv}") MCUiv: String) : this(SecretKeySpec(MCUsecret.encodeToByteArray(), "AES"),MCUiv.encodeToByteArray())
    private fun decryptToStr(dataToDecrypt: ByteArray): String {
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")
        val ivSpec = IvParameterSpec(initializationVector)
        cipher.init(Cipher.DECRYPT_MODE, mySecretKey, ivSpec)
        val cipherText = cipher.doFinal(dataToDecrypt)
        val hex = dataToDecrypt.joinToString(separator = "")  {eachByte -> "%02x".format(eachByte)  }
        return cipherText.decodeToString()
    }

    fun decrypt(dataAmount: ByteArray): SiteData{
        return objectMapper.readValue(decryptToStr(dataAmount),SiteData::class.java)
    }
}