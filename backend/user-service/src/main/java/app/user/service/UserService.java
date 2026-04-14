package app.user.service;

import app.user.domain.User;
import app.user.domain.UserStatus;
import core.framework.crypto.Hash;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.BadRequestException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;

public class UserService {
    @Inject
    Repository<User> userRepository;

    public User register(String username, String password, Long companyId) {
        var existingUser = userRepository.selectOne("username = ?", username);
        if (existingUser.isPresent()) {
            throw new BadRequestException("username already exists", "USERNAME_EXISTS");
        }

        User user = new User();
        user.username = username;
        user.password = Hash.md5Hex(password); // Simple hash for demo, normally bcrypt/argon2
        user.companyId = companyId;
        user.status = UserStatus.INACTIVE; // Initially inactive
        user.createdTime = LocalDateTime.now();
        
        user.id = userRepository.insert(user).orElseThrow();
        return user;
    }

    public User login(String username, String password) {
        User user = userRepository.selectOne("username = ?", username)
            .orElseThrow(() -> new NotFoundException("user not found", "USER_NOT_FOUND"));
            
        if (!Hash.md5Hex(password).equals(user.password)) {
            throw new BadRequestException("invalid password", "INVALID_PASSWORD");
        }
        
        if (user.status != UserStatus.ACTIVE) {
            throw new BadRequestException("user is inactive", "USER_INACTIVE");
        }
        
        return user;
    }
}