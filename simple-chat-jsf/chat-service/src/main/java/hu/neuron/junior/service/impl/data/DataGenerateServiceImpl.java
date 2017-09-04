package hu.neuron.junior.service.impl.data;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import hu.neuron.junior.client.api.service.data.DataGenerateService;
import hu.neuron.junior.core.dao.RoleDao;
import hu.neuron.junior.core.dao.UserDao;
import hu.neuron.junior.core.entity.Role;
import hu.neuron.junior.core.entity.User;
@Component("dataGenerateService")
public class DataGenerateServiceImpl implements DataGenerateService {

	private static final Logger logger = Logger.getLogger(DataGenerateService.class);

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;
   @Override
	public void generate() {
		try {

			Role role = roleDao.findByName("ROLE_USER");
			if (role == null) {
				role = new Role();
				role.setName("ROLE_USER");
				role = roleDao.save(role);
			}
			ArrayList<User> users = new ArrayList<>();

			JsonReader jsonReader = new JsonReader();
			JSONObject json = jsonReader.readJsonFromUrl("https://randomuser.me/api/0.8/?results=20");

			JSONArray array = json.getJSONArray("results");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				RandomUser randomUser = new RandomUser(jsonObject.getJSONObject("user"));

				User user = new User();
				user.setUsername(randomUser.getUsername());
				user.setFirstName(randomUser.getPersonFirstName());
				user.setLastName(randomUser.getPersonLastName());
				user.setEmail(randomUser.getEmail());
				user.setImageUrl(randomUser.getPictureThumbnail());
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				String encPassword = bCryptPasswordEncoder.encode("password");

				user.setPassword(encPassword);

				ArrayList<Role> roles = new ArrayList<>();
				roles.add(role);
				user.setRoles(roles);

				users.add(user);

			}

			userDao.save(users);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
		}
	}

}
