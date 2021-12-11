package com.myemployee;


import com.myemployee.user.User;
import com.myemployee.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
// set details
    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("kalpana@gmail.com");
        user.setPassword("456kalpana");
        user.setFirstName("Kalpana");
        user.setLastName("Dissanayake");

        User saveUser = repo.save(user);

        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);






    }
}

