package com.codesquad.library;

import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.repositories.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties
@ComponentScan
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
	    return args -> {
	        String password = passwordEncoder.encode("1234");

	        Member member = Member.builder()
                    .name("정휘준")
                    .loginEmail("shit@fuck.com")
                    .password(password)
                    .roles(Member.MemberRoles.USER)
                    .build();

	        memberRepository.save(member);
        };
    }
}
