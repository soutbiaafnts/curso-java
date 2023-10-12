package br.com.coutbiaafnts.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // coloca getter e setter para todos os atributos
@Entity(name="tb_users") // nomeia a tabela
public class UserModel {

   @Id
   @GeneratedValue(generator = "UUID") // jakarta cria o ID
   private UUID id;
   
   @Column(unique = true) // coluna com uma restrição com valor único
   private String username;
   private String name;
   private String password;

   @CreationTimestamp
   private LocalDateTime createdAt;

}
