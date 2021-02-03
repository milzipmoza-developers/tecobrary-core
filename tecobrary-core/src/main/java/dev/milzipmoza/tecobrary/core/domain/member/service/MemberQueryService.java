package dev.milzipmoza.tecobrary.core.domain.member.service;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberDto findByProviderKey(String providerKey) {
        Member member = memberRepository.findByAuthDetailKey(providerKey)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        return MemberDto.of(member);
    }

    public MemberDto findByMemberNumber(String memberNumber) {
        Member member = memberRepository.findByNumber(memberNumber)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        return MemberDto.of(member);
    }
}