package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for managing {@link User} entities.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
public interface UserRepository extends AbstractRepository<User, String> {

    User findFirstByUsername(String username);

    List<User> findByUsernameContaining(String username);

    @Query("SELECT u FROM User u WHERE CONCAT(u.firstName, ' ', u.lastName) = :wholeName")
    List<User> findByWholeNameConcat(@Param("wholeName") String wholeName);

    @Query("SELECT u FROM User u WHERE :role MEMBER OF u.roles")
    List<User> findByRole(@Param("role") UserRole role);

    @Query("SELECT u FROM User u WHERE :role1 MEMBER OF u.roles OR :role2 MEMBER OF u.roles")
    List<User> findByTwoRoles(@Param("role1") UserRole role1, @Param("role2") UserRole role2);

    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT(:usernamePrefix, '%')")
    List<User> findByUsernamePrefix(@Param("usernamePrefix") String usernamePrefix);

    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT(:usernamePrefix, '%') AND (:role1 MEMBER OF u.roles OR :role2 MEMBER OF u.roles)")
    List<User> findStaffByUsernamePrefix(@Param("usernamePrefix") String usernamePrefix, @Param("role1") UserRole role1, @Param("role2") UserRole role2);

    @Query("SELECT u FROM User u WHERE :role MEMBER OF u.roles ORDER BY function('RAND')")
    List<User> findAvailableStaff(@Param("role") UserRole role);

}
