package io.kimu.backend.dao

import io.github.oshai.kotlinlogging.KotlinLogging
import io.kimu.backend.domain.Member
import io.kimu.backend.dto.Role
import io.kimu.backend.util.genMember
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

// java Logger
// val logger = LoggerFactory.getLogger(MemberRepository::class.java)

private val logger = KotlinLogging.logger {}


@DataJpaTest
class MemberRepositoryTests @Autowired constructor(
    val repository: MemberRepository
) {
// Field에서 직접 주입하기 vs 생성자에서 정의하기
//    @Autowired
//    lateinit var repository: MemberRepository

    @Test
    fun `repository 주입 테스트`() {
        logger.info { repository }
        assertThat(repository).isNotNull
    }

    @Test
    fun `회원을 생성해서 저장하면 id와 생성날짜, 수정날짜가 자동으로 등록된다`() {
        val targetName = "member1"
        val targetEmail = "member1@email.com"
        val member = genMember(targetName, targetEmail)

        val saved: Member = repository.save(member)

        assertThat(saved.createdAt).isNotNull
        assertThat(saved.updatedAt).isNotNull

        assertThat(saved.id).isNotNull

        val now = LocalDateTime.now()
        assertThat(saved.createdAt).isBefore(now)
        assertThat(saved.updatedAt).isBefore(now)

        logger.info { saved.id }
        logger.info { saved.createdAt }
        logger.info { saved.updatedAt }
    }
}