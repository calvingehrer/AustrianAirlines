package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.services.UserService;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Controller for the user list view.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("view")
public class UserListController {

    @Autowired
    private UserService userService;

    private String roleFilter = "";
    private String username = "";

    /**
     * Returns a list of users filtered by user role/username or
     * all users if no filter is given
     *
     * @return
     */
    public Collection<User> getFilteredUsers(){
        if(!username.equals("")){
            return userService.getAllUsersByUsername(username);
        }
        return userService.getAllUsersByRole(roleFilter);
    }

    /**
     * Returns a list of the staff filtered by user role/username
     * or the entire staff if no filter is given
     *
     * @return
     */
    public Collection<User> getFilteredStaff(){
        if(!username.equals("")){
            return userService.getAllStaffByUsername(username);
        }

        return userService.getAllStaffByRole(roleFilter);
    }

    public String getRoleFilter() {
        return roleFilter;
    }

    public void setRoleFilter(String roleFilter) {
        this.roleFilter = roleFilter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
