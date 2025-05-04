package com.transportation.service;

import com.transportation.model.AdminModel;
import com.transportation.model.CreateUserAccountModel;
import com.transportation.model.entity.Admin;
import com.transportation.model.entity.UserAccount;
import com.transportation.model.request.CreateAdminRequest;
import com.transportation.repository.AdminRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  private final UserAccountService userAccountService;
  private final AdminRepository adminRepository;

  public AdminService(UserAccountService userAccountService, AdminRepository adminRepository) {
    this.userAccountService = userAccountService;
    this.adminRepository = adminRepository;
  }

  public String create(CreateAdminRequest request) {
    CreateUserAccountModel createUserAccountModel = new CreateUserAccountModel(request.getName(), request.getPhone(),
        request.getRole(), request.getPassword(), request.getEmail());
    try {
      UserAccount userAccount = userAccountService.create(createUserAccountModel);
      Admin admin = new Admin();
      admin.setUserAccount(userAccount);
      admin.setCompanyId(request.getCompanyId());
      adminRepository.save(admin);
    } catch (Exception e) {
      return e.getMessage();
    }

    return "ok";
  }

  public AdminModel findByEmail(String email) {
    return Optional.ofNullable(adminRepository.findByEmail(email))
        .map(admin -> new AdminModel(
                admin.getId(),
                admin.getUserAccountId(),
                admin.getCompanyId()
            )
        )
        .orElse(null);
  }
}
