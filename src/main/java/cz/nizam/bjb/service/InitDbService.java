package cz.nizam.bjb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cz.nizam.bjb.entity.Blog;
import cz.nizam.bjb.entity.Item;
import cz.nizam.bjb.entity.Role;
import cz.nizam.bjb.entity.User;
import cz.nizam.bjb.repository.BlogRepository;
import cz.nizam.bjb.repository.ItemRepository;
import cz.nizam.bjb.repository.RoleRepository;
import cz.nizam.bjb.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@PostConstruct
	public void init()
	{
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("nizam"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogBestjava = new Blog();
		blogBestjava.setName("BestJava");
		blogBestjava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogBestjava.setUser(userAdmin);
		blogRepository.save(blogBestjava);
		
		/*
		Item item1 = new Item();
		item1.setBlog(blogBestjava);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogBestjava);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);*/
		
	}
	
}
