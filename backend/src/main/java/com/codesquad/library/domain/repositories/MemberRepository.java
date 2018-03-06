package com.codesquad.library.domain.repositories;

import com.codesquad.library.domain.authentication.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
