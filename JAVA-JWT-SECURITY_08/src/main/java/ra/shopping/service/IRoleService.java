package ra.shopping.service;

import ra.shopping.model.Roles;
import ra.shopping.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Roles> findByName(RoleName name);
}
