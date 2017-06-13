package cz.nizam.bjb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.nizam.bjb.entity.Blog;
import cz.nizam.bjb.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
	
}
