package com.company.viettridao.controllers;

import com.company.viettridao.enums.Role;
import com.company.viettridao.models.User;
import com.company.viettridao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * login api
     * @param userName username of user
     * @param password password of user
     * @return result find in database user have username and password is correct
     */
    @GetMapping("/login")
    public boolean loginAccount(@RequestParam String userName, @RequestParam String password){
        User result = userRepository.findByUserNameAndPassword(userName, password);
        return result != null;
    }

    /**
     * get user by id
     * @param id id user
     * @return user has id is correct
     */
    @GetMapping("/getById/{id}")
    public User getUserById(@PathVariable long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    /**
     * get user by username
     * @param userName username of user
     * @return user has username is correct
     */
    @GetMapping("/getByUseName")
    public User getUserByUserName(@RequestParam String userName){
        return userRepository.findByUserName(userName);
    }

    /**
     * get user by email
     * @param email email of user
     * @return user has email is correct
     */
    @GetMapping("/getByEmail")
    public User getUserByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    /**
     * register account
     * @param user user with information
     * @return result register
     */
    @PostMapping("/register")
    public String registerAccount(@RequestBody User user){
        try{
            if(getUserByUserName(user.getUserName()) != null)
                return "Account with username is exists!";
            if(getUserByEmail(user.getEmail()) != null)
                return "Account with email is exists!";
            userRepository.save(user);
            return "Success!";
        } catch (Exception e){
            System.out.println("Register fail!!!");
            return "Register fail!!!";
        }
    }

    /**
     * Change role user become seller
     * @param id id of user
     * @return result change
     */
    @PutMapping("/registerSeller/{id}")
    public String registerSeller(@PathVariable long id, boolean accept){
        try{
            User u = getUserById(id);
            if(u.getRole() != Role.ADMIN) {
                if (accept)
                    u.setRole(Role.SELLER);
                else
                    u.setRole(Role.BUYERWANTTOBECOMESELLER);
            }
            else throw new Exception("Account has role ADMIN!");
            userRepository.save(u);
            return "Success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Admin accept user change role become SELLER
     * @param id id user
     * @return result change
     */
    @PutMapping("/acceptRoleSeller/{id}")
    public String acceptRoleSeller(@PathVariable long id){
        try {
            return registerSeller(id, true);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
