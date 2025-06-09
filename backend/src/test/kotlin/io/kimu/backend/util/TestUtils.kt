package io.kimu.backend.util

import io.kimu.backend.domain.Member
import io.kimu.backend.dto.Role

fun genMember(targetName: String, targetEmail: String) : Member {
    val member = Member(null, targetName, targetEmail, Role.BRONZE)
    return member
}