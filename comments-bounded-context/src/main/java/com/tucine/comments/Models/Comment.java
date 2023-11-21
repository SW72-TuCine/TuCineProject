package com.tucine.comments.Models;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Comment {
    @Id
    private String id;

    private Date date;

    private String author;

    private Long userId;

    private String content;

    private int calification;

}
