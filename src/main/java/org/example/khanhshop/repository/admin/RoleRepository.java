package org.example.khanhshop.repository.admin;


import org.example.khanhshop.entity.Role;
import org.example.khanhshop.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Set<Role> findByName(ERole name);

}
