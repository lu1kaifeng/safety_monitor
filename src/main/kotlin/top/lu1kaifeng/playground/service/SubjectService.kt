package top.lu1kaifeng.playground.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import top.lu1kaifeng.playground.entity.Subject
import top.lu1kaifeng.playground.except.InvalidTokenException
import top.lu1kaifeng.playground.repo.SubjectRepo
import xyz.luchengeng.info.except.NotAuthorizedException
import java.util.regex.Pattern

@Service
class SubjectService @Autowired constructor(
    private val subjectRepo: SubjectRepo, @Value("\${HMAC256.secret}")
    private val secret: String
) {
    private val tokenPattern = Pattern.compile("Bearer\\s(.*)")
    fun authenticationFunction(tokenHeader: String?): DecodedJWT? {
        if (tokenHeader == null) {
            return null;
        }
        try {
            val token = tokenPattern.matcher(tokenHeader).apply { find() }.group(1)
            return tokenVerify(token)
        } catch (_: RuntimeException) {
            throw InvalidTokenException()
        }
    }

    fun tokenCreate(subject: Subject): String {
        val algorithm = Algorithm.HMAC256(secret)
        return JWT.create()
            .withSubject(subject.id.toString())
            .withClaim("name", subject.userName)
            .sign(algorithm)
    }

    fun tokenCreate(userName: String, password: String): String {
        return tokenCreate(
            subjectRepo.findByUserNameAndPassword(userName, password) ?: throw NotAuthorizedException("User Not Found")
        )
    }

    fun tokenVerify(token: String?): DecodedJWT? {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            val verifier = JWT.require(algorithm)
                .build()
            verifier.verify(token)

        } catch (exception: JWTVerificationException) {
            return null
        }
    }

    fun findByIdOrNull(id: Long) = subjectRepo.findByIdOrNull(id)
}