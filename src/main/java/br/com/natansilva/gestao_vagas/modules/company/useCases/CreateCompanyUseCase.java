package br.com.natansilva.gestao_vagas.modules.company.useCases;

<<<<<<< HEAD
<<<<<<< HEAD
import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

=======
=======
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> origin/main
import br.com.natansilva.gestao_vagas.exceptions.UserFoundException;
import br.com.natansilva.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.natansilva.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    
<<<<<<< HEAD
<<<<<<< HEAD
    @Value("${security.token.secret}")
    private String secretKey;

=======
>>>>>>> origin/main
=======
>>>>>>> origin/main
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        // Lógica para criar uma nova empresa
<<<<<<< HEAD
<<<<<<< HEAD
        this.companyRepository
            .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
=======
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
>>>>>>> origin/main
=======
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
>>>>>>> origin/main
            .ifPresent(user -> {
                throw new UserFoundException();
            });

<<<<<<< HEAD
<<<<<<< HEAD
        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        var createdCompany = this.companyRepository.save(companyEntity);

        // Após salvar a company, gera e exibe o token no terminal para facilitar o uso na autenticação das vagas.
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
            .withIssuer("javagas")
            .withExpiresAt(Instant.now().plus(Duration.ofHours(4)))
            .withSubject(createdCompany.getId().toString())
            .sign(algorithm);

        System.out.println("Token gerado para a company: " + token);

        return createdCompany;
=======
=======
>>>>>>> origin/main
            var password = passwordEncoder.encode(companyEntity.getPassword());
            companyEntity.setPassword(password);
            
        return this.companyRepository.save(companyEntity);
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> origin/main

    }
}
