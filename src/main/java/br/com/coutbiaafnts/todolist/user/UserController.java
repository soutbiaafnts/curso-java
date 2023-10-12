package br.com.coutbiaafnts.todolist.user;

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
   
   /**
    * String (texto)
    * Integer (número inteiro)
    * Double (0.00000)
    * Float
    * char
    * Date
    * void
    */

    /**
     * Body
     */

   @PostMapping("/")
   public void create(@RequestBody UserModel userModel) {
      System.out.println(userModel.getName());
   }
}
