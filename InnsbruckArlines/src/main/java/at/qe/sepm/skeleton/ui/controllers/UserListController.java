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

    private String userrole = "";
    private String username = "";

    /**
     * Returns a list of users filtered by user role/username or
     * all users if no filter is given
     *
     * @return
     */
    public Collection<User> getUsers(){
        if(!username.equals("")){
            return userService.getAllUsersByUsername(username);
        }
        return userService.getAllUsersByRole(userrole);
    }

    /**
     * Returns a list of users filtered by user role/username or
     * all users if no filter is given
     *
     * @return
     */
    public Collection<User> getStaff(){
        if(!username.equals("")){
            return userService.getAllStaffByUsername(username);
        }
        return userService.getAllStaff();
    }

    public Collection<User> getPilots(){
        if(!username.equals("")){
            return userService.getAllUsersByUsername(username);
        }
        return userService.getAllPilots();
    }

    public Collection<User> getCrew() {
        if (!username.equals("")) {
            return userService.getAllUsersByUsername(username);
        }
        return userService.getAllCrewMembers();
    }

    public void resetFilter(){
        this.username = "";
        this.userrole = "";
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
