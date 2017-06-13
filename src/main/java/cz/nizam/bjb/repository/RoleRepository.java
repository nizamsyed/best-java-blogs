package cz.nizam.bjb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.nizam.bjb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
