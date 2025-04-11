package com.transportation.validator;

import com.transportation.model.entity.UserAccount;
import com.transportation.repository.UserAccountRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExistUserAccountValidator implements Validator<Long> {

  private final UserAccountRepository userAccountRepository;

  public ExistUserAccountValidator(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public String validate(Long userAccountId) {
    if (userAccountId == null) {
      return "ExistUserAccountValidator userAccountId is null";
    }
    Optional<UserAccount> user = userAccountRepository.findById(userAccountId);
    if (!user.isPresent()) {
      return "User with id=" + userAccountId + " isn't exist";
    }
    return null;
  }
}
