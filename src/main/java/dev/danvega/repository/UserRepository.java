package dev.danvega.repository;

import dev.danvega.domain.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Material, Long> {
    List<Material> findByIddepartamentoAndIdsubdepartamentoAndIdclaseAndIdsubclase(
            String iddepartamento, String idsubdepartamento, String idclase, String idsubclase
    );
}
