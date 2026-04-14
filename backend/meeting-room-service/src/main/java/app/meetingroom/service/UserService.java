package app.meetingroom.service;

import app.meetingroom.api.dto.UserView;
import app.meetingroom.domain.User;
import app.meetingroom.domain.UserStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    @Inject
    Repository<User> userRepository;

    public List<UserView> search(Long companyId) {
        Query<User> query = userRepository.select();
        if (companyId != null) {
            query.where("company_id = ?", companyId);
        }
        return query.fetch().stream().map(this::view).collect(Collectors.toList());
    }

    public UserView get(Long id) {
        User user = userRepository.get(id).orElseThrow(() -> new NotFoundException("user not found, id=" + id));
        return view(user);
    }

    public UserView create(String username, String password, Long companyId) {
        User user = new User();
        user.username = username;
        user.password = password;
        user.companyId = companyId;
        user.status = UserStatus.ACTIVE;
        user.id = userRepository.insert(user).orElseThrow();
        return view(user);
    }

    public void deactivate(Long id) {
        User user = userRepository.get(id).orElseThrow(() -> new NotFoundException("user not found, id=" + id));
        user.status = UserStatus.INACTIVE;
        userRepository.update(user);
    }

    private UserView view(User user) {
        UserView view = new UserView();
        view.id = user.id;
        view.username = user.username;
        view.companyId = user.companyId;
        view.status = user.status != null ? user.status.name() : null;
        return view;
    }
}
