package dev.aq.cache.library.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String category;
    private String author;
    private String publisher;
    private String edition;
}
