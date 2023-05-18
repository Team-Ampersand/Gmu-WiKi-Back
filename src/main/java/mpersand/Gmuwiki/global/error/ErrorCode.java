package mpersand.Gmuwiki.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다.", 409),
    NOT_SAME_PASSWORD("두 비밀번호가 일치하지 않습니다.", 400),
    MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    NOT_VERIFY_EMAIL("검증되지 않은 이메일입니다." , 401),
    MANY_REQUEST_EMAIL_AUTH("15분에 최대 3번의 이메일 요청만 가능합니다." , 429),
    EXPIRE_EMAIL_CODE("이메일 인증번호 시간이 만료되었습니다.", 401),
    MISMATCH_AUTH_CODE("인증번호가 일치하지 않습니다." , 400),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다", 404),
    TOKEN_IS_EXPIRED("토큰이 만료 되었습니다.", 401),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404),
    BLACKLIST_ALREADY_EXIST("블랙리스트에 이미 등록되었습니다.",400),
    EMAIL_SEND_FAIL("메일 발송에 실패했습니다", 500),
    UNKNOWN_ERROR("알 수 없는 에러입니다.", 500),
    NOTICE_NOT_FOUND("공지글을 찾을 수 없습니다", 404),
    ALREADY_EXIST_TITLE("이미 존재하는 제목입니다.", 409),
    BOARD_NOT_FOUND("게시글을 찾을 수 없습니다.", 404),
    MISMATCH_BOARD_AUTHOR("내가 작성한 글이 아닙니다.", 403),
    BOARD_RECORD_NOT_FOUND("게시글의 기록을 찾을 수 없습니다.", 404),
    FILE_UPLOAD_FAIL("파일 업로드에 실패했습니다.", 500),
    NOT_ALLOWED_FILE("허용되지 않은 파일 형식입니다.", 400),
    INVALID_FORMAT_FILE("잘못된 형식의 파일입니다.", 400),
    INQUIRY_NOT_FOUND("문의 사항을 찾을 수 없습니다.", 404);

    private final String message;
    private final int status;
}
