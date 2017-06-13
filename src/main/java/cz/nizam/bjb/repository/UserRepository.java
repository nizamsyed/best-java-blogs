package cz.nizam.bjb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.nizam.bjb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
