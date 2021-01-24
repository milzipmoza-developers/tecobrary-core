package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {

    private final String number;
    private final String name;
    private final String profileImageUrl;
    private final MemberAuthority authority;

    @Builder
    public MemberDto(String number, String name, String profileImageUrl, MemberAuthority authority) {
        this.number = number;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .number(member.getNumber())
                .name(member.getName())
                .profileImageUrl(member.getProfileImageUrl())
                .authority(member.getAuthority())
                .build();
    }
}
