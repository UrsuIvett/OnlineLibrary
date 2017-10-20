package ro.sci.onlinelibrary.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    UserService userService;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserController userController;

    @Test
    public void getUsers() throws Exception {
        User user1 = new User();
        User user2 = new User();
        user1.setFirstName("George");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        ModelAndView mav = userController.getUsers();

        List<User> resultUser = (List<User>) mav.getModel().get("users");
        assertNotNull(resultUser);
        assertEquals(2,userList.size());
        assertEquals("George",userList.get(0).getFirstName());
    }
}