package me.aruna.week6challange;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserDataRepository userDataRepository;



    @Autowired
    public UserService(UserRoleRepository userRoleRepository){
        this.userRoleRepository = userRoleRepository;

    }
    public UserData findByEmail(String email){
        return userDataRepository.findByEmail(email);
    }
    public Long countByEmail(String email){
        return userDataRepository.countByEmail(email);
    }
    public UserData findByUsername(String username){
        return userDataRepository.findByUsername(username);
    }
    public void saveUser(UserData userData){


//        userData.addRoles(UserRoleRepository.findByRole("USER"));
   // userData.setRoles((UserRoleRepository.findByRole("USER")));
        userData.setEnabled(true);
        userDataRepository.save(userData);
    }
    public void saveAdmin(UserData userData){
//    userData.setRoles(roleRepository.findByRole("ADMIN"));

        userData.addRoles(userRoleRepository.findByRole("ADMIN"));
        userData.setEnabled(true);
        userDataRepository.save(userData);
    }
}