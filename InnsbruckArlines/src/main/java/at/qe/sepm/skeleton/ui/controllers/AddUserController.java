package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import at.qe.sepm.skeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
@Scope("view")
public class AddUserController {

    @Autowired
    private UserService userService;

    private Set<UserRole> roles;
    private boolean admin = false;
    private boolean manager = false;
    private boolean pilot = false;
    private boolean cabinstaff = false;

    /**
     * The new user to be added to the system
     */
    private User user = new User();

    /**
     * Action to add the user to the system
     */
    public void add(){
        this.roles = new HashSet<>();
        if(admin){
            roles.add(UserRole.ADMIN);
        }
        if(manager){
            roles.add(UserRole.MANAGER);
        }
        if(pilot){
            roles.add(UserRole.PILOT);
        }
        if(cabinstaff){
            roles.add(UserRole.CABINSTAFF);
        }
        roles.add(UserRole.EMPLOYEE);

        user.setRoles(roles);
        userService.addNewUser(user);

        resetUser();
    }

    /**
     * Add explicit a pilot to the system
     */
    public void addPilot(){
        this.roles = new HashSet<>();
        roles.add(UserRole.PILOT);
        roles.add(UserRole.EMPLOYEE);
        user.setRoles(roles);
        userService.addNewUser(user);
        resetUser();
    }

    /**
     * Add explicit a crew member to the system
     */
    public void addCrew(){
        this.roles = new HashSet<>();
        roles.add(UserRole.CABINSTAFF);
        roles.add(UserRole.EMPLOYEE);
        user.setRoles(roles);
        userService.addNewUser(user);
        resetUser();
    }

    public void resetUser(){
        this.user = new User();
        roles.clear();
        pilot = false;
        cabinstaff = false;
        manager = false;
        admin = false;
        user.setEnabled(false);
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isPilot() {
        return pilot;
    }

    public void setPilot(boolean pilot) {
        this.pilot = pilot;
    }

    public boolean isCabinstaff() {
        return cabinstaff;
    }

    public void setCabinstaff(boolean cabinstaff) {
        this.cabinstaff = cabinstaff;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
