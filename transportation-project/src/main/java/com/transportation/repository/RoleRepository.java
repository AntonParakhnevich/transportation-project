package com.transportation.repository;

import com.transportation.model.RoleName;
import com.transportation.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findFirstByName(RoleName name);
}
