package dev.milzipmoza.tecobrary.core.event.book;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.BookStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookStatusEvent {

    private final Long libraryBookId;
    private final String libraryBookTitle;
    private final String libraryBookPublisher;
    private final String memberNumber;
    private final String bookSerial;
    private final BookStatus bookStatus;
    private final LocalDateTime rentDatetime;

    @Builder
    public BookStatusEvent(Long libraryBookId, String libraryBookTitle, String libraryBookPublisher, String memberNumber, String bookSerial, BookStatus bookStatus, LocalDateTime rentDatetime) {
        this.libraryBookId = libraryBookId;
        this.libraryBookTitle = libraryBookTitle;
        this.libraryBookPublisher = libraryBookPublisher;
        this.memberNumber = memberNumber;
        this.bookSerial = bookSerial;
        this.bookStatus = bookStatus;
        this.rentDatetime = rentDatetime;
    }

    public boolean isRentEvent() {
        return this.bookStatus == BookStatus.RENT;
    }

    public boolean isReturnEvent() {
        return this.bookStatus == BookStatus.IN_LIBRARY;
    }
}
