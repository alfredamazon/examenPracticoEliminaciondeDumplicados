package dev.danvega.service;

import dev.danvega.domain.Material;
import dev.danvega.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Material> list() {
        return userRepository.findAll();
    }

    public Material save(Material user) {
        return userRepository.save(user);
    }



    public void save(List<Material> users) {
        userRepository.saveAll(users);
    }
    private List<Material> filterDuplicateMaterials(List<Material> materials) {
        // Filtrar duplicados basándonos en el id
        return materials.stream()
                .filter(material -> !userRepository.existsById(material.getMaterial()))
                .toList();
    }
    public List<Material> getByParams(String iddepartamento, String idsubdepartamento, String idclase, String idsubclase) {
        return userRepository.findByIddepartamentoAndIdsubdepartamentoAndIdclaseAndIdsubclase(
                iddepartamento, idsubdepartamento, idclase, idsubclase
        );
    }
}
