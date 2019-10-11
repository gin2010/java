package demo01;

import java.sql.SQLException;

public interface UserDao {
  
  /**
   * Insert an user in the database.
   * 
   * @param user user to be inserted
   * @return if id the inserted user
   */
  long addUser( User user ) throws SQLException;

  User getUserById( long id ) throws SQLException;

}
