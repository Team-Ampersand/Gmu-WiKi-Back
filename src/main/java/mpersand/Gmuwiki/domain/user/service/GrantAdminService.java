package mpersand.Gmuwiki.domain.user.service;

import lombok.RequiredArgsConstructor;
import mpersand.Gmuwiki.domain.user.entity.User;
import mpersand.Gmuwiki.domain.user.enums.Role;
import mpersand.Gmuwiki.domain.user.exception.UserNotFoundException;
import mpersand.Gmuwiki.domain.user.presentation.dto.request.GrantAdminRequest;
import mpersand.Gmuwiki.domain.user.repository.UserRepository;
import mpersand.Gmuwiki.global.annotation.RollbackService;

@RollbackService
@RequiredArgsConstructor
public class GrantAdminService {

    private final UserRepository userRepository;

    public void execute(GrantAdminRequest grantAdminRequest) {

        String email = grantAdminRequest.getEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException());

        user.setRole(Role.ROLE_ADMIN);
    }
}