package dev.milzipmoza.tecobrary.core.domain.member.service;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberUpsertDto;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthDetail;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public MemberDto upsert(MemberUpsertDto memberDto) {
        MemberAuthProvider provider = MemberAuthProvider.of(memberDto.getProvider());
        Member member = memberRepository.findByAuthDetailProviderAndAuthDetailKey(provider, memberDto.getProviderKey())
                .orElse(Member.builder()
                        .name(memberDto.getName())
                        .profileImageUrl(memberDto.getProfileImageUrl())
                        .authDetail(new MemberAuthDetail(memberDto.getProviderKey(), provider))
                        .number("NONE")
                        .build()
                );
        return MemberDto.of(memberRepository.save(member));
    }
}
