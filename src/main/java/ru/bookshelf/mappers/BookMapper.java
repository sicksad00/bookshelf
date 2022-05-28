package ru.bookshelf.mappers;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.bookshelf.enteties.Book;
import ru.bookshelf.requests.BookRequest;

import javax.annotation.Nonnull;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class BookMapper {

    @Nonnull
    public static Book toModel(@Nonnull BookRequest bookRequest) {
        return new Book(bookRequest.getTitle(), bookRequest.getCoverUrl(), bookRequest.getDescription(), bookRequest.getPageCount());
    }
}
