package io.kimu.backend.util

import io.kimu.backend.domain.Member
import io.kimu.backend.dto.MemberDescription
import io.kimu.backend.dto.Role

fun genMember(
    targetName: String,
    targetEmail: String,
    targetRole: Role = Role.BRONZE
): Member {
    val member = Member(null, targetName, targetEmail, targetRole)
    return member
}

fun genMemberDesc(
    actualName: String,
    actualEmail: String,
    actualRole: Role
): MemberDescription = MemberDescription(actualName, actualEmail, actualRole)
