package ra.shopping.service.impl;

import ra.shopping.model.Roles;
import ra.shopping.model.RoleName;
import ra.shopping.repository.IRoleRepository;
import ra.shopping.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Roles> findByName(RoleName name) {
        return roleRepository.findByRoleName(name);
    }
}
