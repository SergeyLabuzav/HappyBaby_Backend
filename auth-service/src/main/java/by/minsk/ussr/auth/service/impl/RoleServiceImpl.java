package by.minsk.ussr.auth.service.impl;

import by.minsk.ussr.auth.model.Role;
import by.minsk.ussr.auth.repository.RoleRepository;
import by.minsk.ussr.auth.service.RoleService;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        log.debug("find role by name: {}", name);
        return roleRepository.findOneByName(name).orElseThrow(IllegalArgumentException::new);
    }
}
