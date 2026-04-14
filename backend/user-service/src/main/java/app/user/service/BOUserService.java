package app.user.service;

import app.user.domain.User;
import app.user.domain.UserStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.BadRequestException;
import core.framework.web.exception.NotFoundException;

public class BOUserService {
    @Inject
    Repository<User> userRepository;

    public void updateStatus(Long userId, String status) {
        User user = userRepository.get(userId)
            .orElseThrow(() -> new NotFoundException("user not found", "USER_NOT_FOUND"));
            
        try {
            user.status = UserStatus.valueOf(status.toUpperCase(java.util.Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("invalid status", "INVALID_STATUS", e);
        }
        
        userRepository.update(user);
    }
}