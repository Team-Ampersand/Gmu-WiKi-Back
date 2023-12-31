package mpersand.Gmuwiki.domain.board.service;

import lombok.RequiredArgsConstructor;
import mpersand.Gmuwiki.domain.board.entity.Board;
import mpersand.Gmuwiki.domain.board.exception.BoardAuthorMismatchException;
import mpersand.Gmuwiki.domain.board.repository.BoardRecordRepository;
import mpersand.Gmuwiki.domain.board.repository.BoardRepository;
import mpersand.Gmuwiki.domain.user.entity.User;
import mpersand.Gmuwiki.domain.user.enums.Role;
import mpersand.Gmuwiki.global.annotation.RollbackService;
import mpersand.Gmuwiki.global.util.BoardUtil;
import mpersand.Gmuwiki.global.util.UserUtil;

@RequiredArgsConstructor
@RollbackService
public class DeleteBoardService {

    private final BoardRepository boardRepository;

    private final BoardRecordRepository boardRecordRepository;

    private final UserUtil userUtil;

    private final BoardUtil boardUtil;

    public void execute(Long id) {

        Board board = boardUtil.findBoardById(id);

        User user = userUtil.currentUser();

        if(!(board.getUser() == user) && user.getRole().equals(Role.ROLE_STUDENT)) {

            throw new BoardAuthorMismatchException();
        }

        boardRecordRepository.deleteAllByBoard(board);

        boardRepository.delete(board);
    }
}