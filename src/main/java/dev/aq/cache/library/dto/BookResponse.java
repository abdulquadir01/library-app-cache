package dev.aq.cache.library.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private long id;
    private String name;
    private String category;
    private String author;
    private String publisher;
    private String edition;
}
