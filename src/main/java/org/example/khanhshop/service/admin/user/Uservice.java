package org.example.khanhshop.service.admin.user;
import org.example.khanhshop.entity.Role;
import org.example.khanhshop.entity.User;
import org.example.khanhshop.enums.ERole;
import org.example.khanhshop.repository.admin.RoleRepository;
import org.example.khanhshop.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Uservice {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
public User createMK(User user){
    User user1=new User();
    Set<Role> roles=roleRepository.findByName(ERole.ROLE_ADMIN);
    //mã hóa mật khẩu
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    user1.setUserName(user.getUserName());
    user1.setEmail(user.getEmail());
    user1.setPassword(passwordEncoder.encode(user.getPassword()));
    user1.setPhoneNumber(user.getPhoneNumber());
    user1.setRoles(roles);
    return userRepository.save(user1);
}
}
