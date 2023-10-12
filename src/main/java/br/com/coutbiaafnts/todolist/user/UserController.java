package br.com.coutbiaafnts.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores:
 * public
 * private
 * protected
 */

@RestController
@RequestMapping("/users")
public class UserController {
   
   @Autowired
   private IUserRepository userRepository;

   @PostMapping("/")
   public ResponseEntity create(@RequestBody UserModel userModel) {
      var user = this.userRepository.findByUsername(userModel.getUsername());

      if(user != null) {
         System.out.println("Usuário já existe!");
         // mensagem de erro
         // status code -> status dentro da requisição (200 sucesso || 400)
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
      }

      var userCreated = this.userRepository.save(userModel);
      return ResponseEntity.status(HttpStatus.OK).body(userCreated);
   }
}
