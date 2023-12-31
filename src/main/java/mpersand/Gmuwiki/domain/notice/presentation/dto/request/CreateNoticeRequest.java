package mpersand.Gmuwiki.domain.notice.presentation.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreateNoticeRequest {

    @NotBlank(message = "제목은 필수 입력값입니다")
    private String title;

    private String content;
}
