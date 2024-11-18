package resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import services.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    // Exemplo de um endpoint para buscar todos os usuários
    @GetMapping
    public String getAllUsers() {
        return "Lista de usuários aqui...";
    }
   
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping // Rota para buscar todos os usuários
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}") // Rota para buscar um usuário pelo ID
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping // Rota para inserir um novo usuário
    public User insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @DeleteMapping("/{id}") // Rota para excluir um usuário pelo ID
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}") // Rota para atualizar os dados de um usuário
    public User update(@PathVariable Long id, @RequestBody User user) {
        // Implemente a lógica para atualizar os dados do usuário com o ID fornecido
        // Exemplo: userService.update(id, user);
    	userService.update(user);
    }
}