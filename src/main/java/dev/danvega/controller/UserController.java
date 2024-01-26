package dev.danvega.controller;

import dev.danvega.domain.Material;
import dev.danvega.domain.User;
import dev.danvega.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<Material> list() {
        return userService.list();
    }
    @GetMapping("/buscar")
    public List<Material> buscarMateriales(
            @RequestParam(name = "iddepartamento", required = false) String iddepartamento,
            @RequestParam(name = "idsubdepartamento", required = false) String idsubdepartamento,
            @RequestParam(name = "idclase", required = false) String idclase,
            @RequestParam(name = "idsubclase", required = false) String idsubclase
    ) {
        return userService.getByParams(iddepartamento, idsubdepartamento, idclase, idsubclase);
    }
}
