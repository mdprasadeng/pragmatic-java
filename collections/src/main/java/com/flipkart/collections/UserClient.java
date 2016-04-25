package com.flipkart.collections;

import com.flipkart.collections.models.User;

import java.util.List;
import java.util.Set;

public interface UserClient {

  //Mark given userIds as Inactive
  void markUsersInactive(Set<String> userIds);

  //Fetch all users in orderOf orderedBy
  List<User> fetchUsers(String orderedBy);

  //Fetch user with only requested details
  User fetchUserDetails(String userId, List<String> details);

  //Given ids returns corresponding users
  List<User> fetchUsersById(List<String> userIds);

}
