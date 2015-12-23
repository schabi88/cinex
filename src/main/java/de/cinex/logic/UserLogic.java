package de.cinex.logic;

import de.cinex.database.dao.UserDao;
import de.cinex.domain.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class UserLogic {

    @Inject
    UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(UserLogic.class);

    public void addUser(String username, String password, String firstname, String lastname, String email, String location, String gender, String phonenumber) {

        UserData newUserData = new UserData();

        try {
            newUserData.setUsername(username);
            newUserData.setPassword(password);
            newUserData.setFirstname(firstname);
            newUserData.setLastname(lastname);
            newUserData.setEmail(email);
            newUserData.setLocation(location);
            newUserData.setGender(gender);
            newUserData.setPhonenumber(phonenumber);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getLocalizedMessage());
        }

        try {
            userDao.persist(newUserData);
        } catch (Exception e) {
            log.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }

    }
}

