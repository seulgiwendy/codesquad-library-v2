package com.codesquad.library.domain.repositories;

import com.codesquad.library.domain.authentication.Member;
import com.google.common.base.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByLoginEmail(String loginEmail);
}
