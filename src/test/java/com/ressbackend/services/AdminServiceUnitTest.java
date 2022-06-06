<<<<<<< HEAD
package com.ressbackend.services;
import com.ressbackend.data.AdminTest;
import com.ressbackend.data.ReservationTest;
import com.ressbackend.models.Reservation;
import com.ressbackend.models.Users;
import com.ressbackend.repositories.AdminRepository;
import com.ressbackend.repositories.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class AdminServiceUnitTest {

    @MockBean
    private AdminRepository adminRepository;

    @TestConfiguration
    static class AdminServiceTestContextConfiguration {

        @Bean
        @Primary
        public AdminService adminService(AdminRepository adminRepository) {
            return new AdminService(adminRepository);
        }
    }

    @Autowired
    private AdminService adminService;

    @Test
    public void givenUsers_whenGetUsers_thenListShouldBeFound() {
        Mockito.when(adminRepository.findAll())
                .thenReturn(List.of(AdminTest.user1()));

        List<Users> returnedList = adminService.getUsers();
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoUsers_whenGetUsers_thenListShouldBeEmpty() {
        assertThat(adminService.getUsers()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenUserShouldBeFound() {
        Users users = AdminTest.user1();
        Mockito.when(adminRepository.findById(users.getId()))
                .thenReturn(Optional.of(users));
        Users resultUser = adminService.getById(users.getId());
        assertThat(resultUser.getFirstName())
                .isEqualTo(users.getFirstName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> adminService.getById(1L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Value not find with provided id");
    }

    @Test
    public void givenUser_whenCreate_thenRepositoryCalled() {
        Users user = AdminTest.user1();
        adminService.createUser(user);
        verify(adminRepository, times(1)).save(user);
    }

    @Test
    public void givenUser_whenCreate_thenIdAssigned() {
        Users inputUser = AdminTest.user1();
        inputUser.setId(0L);
        Users outputUser = AdminTest.user1();
        Mockito.when(adminRepository.save(inputUser))
                .thenReturn(outputUser);
        Users resultUser = adminService.createUser(inputUser);
        assertThat(resultUser.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenUser_whenCreate_thenUserReturned() {
        Users inputUser = AdminTest.user1();
        inputUser.setId(0L);
        Users outputUser = AdminTest.user1();

        Mockito.when(adminRepository.save(inputUser))
                .thenReturn(outputUser);

        Users resultUser = adminService.createUser(inputUser);

        assertThat(resultUser).isNotNull();
        assertThat(resultUser.getFirstName()).isEqualTo(inputUser.getFirstName());
    }

    @Test
    public void givenUser_whenDeletingUser_thenRepositoryIsCalled() {
        long id = AdminTest.user1().getId();

        adminService.deleteUser(id);

        verify(adminRepository, times(1)).deleteById(id);
    }

    @Test
    public void givenValidFirstName_whenGetByFirstName_thenUserShouldBeFound() {
        Mockito.when(adminRepository.findUsersByFirstName("Irfan"))
                .thenReturn(List.of(AdminTest.user1()));
        List<Users> returnedList = adminService.getByFirstName("Irfan");
        assertThat(returnedList).hasSize(1);
    }



    @Test
    public void givenValidLastName_whenGetByLastName_thenUserShouldBeFound() {
        Mockito.when(adminRepository.findUsersByLastName("Murselović"))
                .thenReturn(List.of(AdminTest.user1()));
        List<Users> returnedList = adminService.getByLastName("Murselović");
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenProfileWithValidId_whenUpdatingProfile_thenProfileIsReturned() {
        Users input = AdminTest.user1();
        input.setId(0L);
        long id = 2L;
        Users output = AdminTest.user1();
        output.setId(id);

        Mockito.when(adminRepository.findById(id))
                .thenReturn(Optional.of(output));
        Mockito.when(adminRepository.save(input))
                .thenReturn(output);

        Users resultItem = adminService.updateUser(id, input);

        assertThat(resultItem).isNotNull();
        assertThat(resultItem.getFirstName()).isEqualTo(input.getFirstName());
        assertThat(resultItem.getId()).isEqualTo(id);
    }

}












=======
//package com.ressbackend.services;
//import com.ressbackend.data.AdminTest;
//import com.ressbackend.models.Users;
//import com.ressbackend.repositories.AdminRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.util.List;
//import java.util.Optional;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//
//@RunWith(SpringRunner.class)
//public class AdminServiceUnitTest {
//
//    @MockBean
//    private AdminRepository adminRepository;
//
//    @TestConfiguration
//    static class AdminServiceTestContextConfiguration {
//
//        @Bean
//        @Primary
//        public AdminService adminService(AdminRepository adminRepository) {
//            return new AdminService(adminRepository, passwordEncoder);
//        }
//    }
//
//    @Autowired
//    private AdminService adminService;
//
//    @Test
//    public void givenUsers_whenGetUsers_thenListShouldBeFound() {
//        Mockito.when(adminRepository.findAll())
//                .thenReturn(List.of(AdminTest.user1()));
//
//        List<Users> returnedList = adminService.getUsers();
//        assertThat(returnedList).hasSize(1);
//    }
//
//    @Test
//    public void givenNoUsers_whenGetUsers_thenListShouldBeEmpty() {
//        assertThat(adminService.getUsers()).isEmpty();
//    }
//
//    @Test
//    public void givenValidId_whenGetById_thenUserShouldBeFound() {
//        Users users = AdminTest.user1();
//        Mockito.when(adminRepository.findById(users.getId()))
//                .thenReturn(Optional.of(users));
//        Users resultUser = adminService.getById(users.getId());
//        assertThat(resultUser.getFirstName())
//                .isEqualTo(users.getFirstName());
//    }
//
//    @Test
//    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
//        assertThatThrownBy(() -> adminService.getById(1L))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessageContaining("Value not find with provided id");
//    }
//
//    @Test
//    public void givenUser_whenCreate_thenRepositoryCalled() {
//        Users user = AdminTest.user1();
//        adminService.createUser(user);
//        verify(adminRepository, times(1)).save(user);
//    }
//
//    @Test
//    public void givenUser_whenCreate_thenIdAssigned() {
//        Users inputUser = AdminTest.user1();
//        inputUser.setId(0L);
//        Users outputUser = AdminTest.user1();
//        Mockito.when(adminRepository.save(inputUser))
//                .thenReturn(outputUser);
//        Users resultUser = adminService.createUser(inputUser);
//        assertThat(resultUser.getId()).isNotEqualTo(0L);
//    }
//
//    @Test
//    public void givenUser_whenCreate_thenUserReturned() {
//        Users inputUser = AdminTest.user1();
//        inputUser.setId(0L);
//        Users outputUser = AdminTest.user1();
//
//        Mockito.when(adminRepository.save(inputUser))
//                .thenReturn(outputUser);
//
//        Users resultUser = adminService.createUser(inputUser);
//
//        assertThat(resultUser).isNotNull();
//        assertThat(resultUser.getFirstName()).isEqualTo(inputUser.getFirstName());
//    }
//
//    @Test
//    public void givenUser_whenDeletingUser_thenRepositoryIsCalled() {
//        long id = AdminTest.user1().getId();
//
//        adminService.deleteUser(id);
//
//        verify(adminRepository, times(1)).deleteById(id);
//    }
//
//    @Test
//    public void givenValidFirstName_whenGetByFirstName_thenUserShouldBeFound() {
//        Mockito.when(adminRepository.findUsersByFirstName("Irfan"))
//                .thenReturn(List.of(AdminTest.user1()));
//        List<Users> returnedList = adminService.getByFirstName("Irfan");
//        assertThat(returnedList).hasSize(1);
//    }
//
//
//
//    @Test
//    public void givenValidLastName_whenGetByLastName_thenUserShouldBeFound() {
//        Mockito.when(adminRepository.findUsersByLastName("Murselović"))
//                .thenReturn(List.of(AdminTest.user1()));
//        List<Users> returnedList = adminService.getByLastName("Murselović");
//        assertThat(returnedList).hasSize(1);
//    }
//
//    @Test
//    public void givenProfileWithValidId_whenUpdatingProfile_thenProfileIsReturned() {
//        Users input = AdminTest.user1();
//        input.setId(0L);
//        long id = 2L;
//        Users output = AdminTest.user1();
//        output.setId(id);
//
//        Mockito.when(adminRepository.findById(id))
//                .thenReturn(Optional.of(output));
//        Mockito.when(adminRepository.save(input))
//                .thenReturn(output);
//
//        Users resultItem = adminService.updateUser(input, id);
//
//        assertThat(resultItem).isNotNull();
//        assertThat(resultItem.getFirstName()).isEqualTo(input.getFirstName());
//        assertThat(resultItem.getId()).isEqualTo(id);
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
>>>>>>> 4225222 (Added JWT token for user)
