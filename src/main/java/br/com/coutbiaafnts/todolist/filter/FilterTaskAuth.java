package br.com.coutbiaafnts.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
         throws ServletException, IOException {

            // get authentication (user e password) -> separando o usuário da senha
            var authorization = request.getHeader("Authorization");
            
            // ? tira o "Basic" e deixa só o resto (calculando o tamanho da palavra e removendo os espaços)
            var authEncoded = authorization.substring("Basic".length()).trim();

            // ? cria um decode (um array de bytes)
            byte [] authDecoded = Base64.getDecoder().decode(authEncoded);
            
            // ? converter o array de bytes para string
            var authString = new String(authDecoded);

            // ? ["username", "password"]
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            System.out.println("Authentication: ");
            System.out.println(username);
            System.out.println(password);

            // valid user

            // valid password

            // go


            filterChain.doFilter(request, response);
   }
   
}
