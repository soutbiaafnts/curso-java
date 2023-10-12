package br.com.coutbiaafnts.todolist.user;

import lombok.Data;

@Data // coloca getter e setter para todos os atributos
public class UserModel {
   
   private String username;
   private String name;
   private String password;

}
