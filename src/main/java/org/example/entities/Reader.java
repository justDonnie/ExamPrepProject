package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.repositories.repositoryImpl.PublisherRepositoryImpl;

@Entity
@Table(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reader {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reader_gen"
    )
    @SequenceGenerator(
            name = "reader_gen",
            sequenceName = "reader_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private int age;
    private String email;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Book book;

}
