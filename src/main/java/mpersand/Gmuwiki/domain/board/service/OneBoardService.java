package mpersand.Gmuwiki.domain.board.service;

import lombok.RequiredArgsConstructor;
import mpersand.Gmuwiki.domain.board.entity.Board;
import mpersand.Gmuwiki.domain.board.exception.BoardNotFoundException;
import mpersand.Gmuwiki.domain.board.presentation.dto.response.DetailBoardResponse;
import mpersand.Gmuwiki.domain.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OneBoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public DetailBoardResponse execute(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException());

        DetailBoardResponse detailBoardResponse = DetailBoardResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .editedDate(board.getEditedDate())
                .build();

        return detailBoardResponse;
    }
}