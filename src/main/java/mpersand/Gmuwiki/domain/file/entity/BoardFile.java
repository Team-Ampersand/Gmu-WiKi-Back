package mpersand.Gmuwiki.domain.file.entity;

import lombok.*;
import mpersand.Gmuwiki.domain.board.entity.Board;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_file_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "board_file_url")
    private String url;
}