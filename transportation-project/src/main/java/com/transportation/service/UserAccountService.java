package com.transportation.service;

import com.transportation.mapper.UserAccountMapper;
import com.transportation.model.CreateUserAccountModel;
import com.transportation.model.UserAccountModel;
import com.transportation.model.entity.Role;
import com.transportation.model.entity.UserAccount;
import com.transportation.repository.RoleRepository;
import com.transportation.repository.UserAccountRepository;
import java.util.Collections;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAccountService implements UserDetailsService {

  private final UserAccountRepository userAccountRepository;
  private final RoleRepository roleRepository;
  private final UserAccountValidationService userAccountValidationService;
  private final PasswordEncoder passwordEncoder;
  private final UserAccountMapper userAccountMapper;

  public UserAccountService(UserAccountRepository repository,
      RoleRepository roleRepository, UserAccountValidationService userAccountValidationService,
      PasswordEncoder passwordEncoder, UserAccountMapper userAccountMapper) {
    this.userAccountRepository = repository;
    this.roleRepository = roleRepository;
    this.userAccountValidationService = userAccountValidationService;
    this.passwordEncoder = passwordEncoder;
    this.userAccountMapper = userAccountMapper;
  }

  public UserAccount create(CreateUserAccountModel model) {
    Role role = roleRepository.findFirstByName(model.getRole());

    UserAccount userAccount = new UserAccount();
    userAccount.setName(model.getName());
    userAccount.setPhone(model.getPhone());
    userAccount.setRole(role);
    userAccount.setPassword(passwordEncoder.encode(model.getPassword()));
    userAccount.setEmail(model.getEmail());
    userAccount.setRoleId(role.getId());

    String validateErrorMessage = userAccountValidationService.validate(userAccount);
    if (validateErrorMessage != null) {
      throw new IllegalArgumentException(validateErrorMessage);
    }

    return userAccountRepository.save(userAccount);
  }

  public UserAccountModel getById(Long id) {
    return userAccountRepository.findById(id)
        .map(userAccountMapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("User not found with id=" + id));
  }

  public UserAccountModel getByEmail(String email) {
    return Optional.ofNullable(userAccountRepository.findByEmail(email))
        .map(userAccountMapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("User not found with email=" + email));
  }

  public void deleteById(Long id) {
    userAccountRepository.deleteById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return Optional.ofNullable(userAccountRepository.findByEmail(email))
        .map(userAccount -> new User(userAccount.getEmail(), userAccount.getPassword(),
            Collections.singletonList(userAccount.getRole().getName())))
        .orElseThrow(() -> new IllegalArgumentException("user not found"));
  }
}
