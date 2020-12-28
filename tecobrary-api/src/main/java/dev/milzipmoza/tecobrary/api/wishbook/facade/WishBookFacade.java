package dev.milzipmoza.tecobrary.api.wishbook.facade;

import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookQueryService;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.service.WishBookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WishBookFacade {

    private final LibraryBookQueryService libraryBookQueryService;
    private final WishBookCommandService wishBookCommandService;

    public WishBookEnrollResponse enroll(String memberNumber, WishBookEnrollRequest body) {
        boolean isExistLibraryBook = libraryBookQueryService.isExistLibraryBook(body.getIsbn());
        if (isExistLibraryBook) {
            throw new IllegalArgumentException("이미 도서관에 비치되어 있는 도서입니다.");
        }
        WishBookEnrollDto enrollDto = WishBookEnrollDto.builder()
                .title(body.getTitle())
                .author(body.getAuthor())
                .isbn(body.getIsbn())
                .image(body.getImage())
                .publisher(body.getPublisher())
                .description(body.getDescription())
                .build();
        WishBookDto wishBookDto = wishBookCommandService.enroll(memberNumber, enrollDto);
        return WishBookEnrollResponse.builder()
                .id(wishBookDto.getId())
                .bookInfo(wishBookDto.getBookInfo())
                .wishBookStatus(wishBookDto.getWishBookStatus())
                .build();
    }
}
