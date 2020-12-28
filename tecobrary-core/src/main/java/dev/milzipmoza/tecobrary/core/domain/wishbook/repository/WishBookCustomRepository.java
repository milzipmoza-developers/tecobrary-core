package dev.milzipmoza.tecobrary.core.domain.wishbook.repository;

import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import dev.milzipmoza.tecobrary.core.domain.wishbook.repository.clause.WishBookClause;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public interface WishBookCustomRepository {

    PageImpl<WishBook> findAllByMemberNumber(String memberNumber, PageRequest of);

    PageImpl<WishBook> findAll(WishBookClause wishBookClause, PageRequest of);
}