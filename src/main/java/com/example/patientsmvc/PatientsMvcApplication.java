package com.example.patientsmvc;

import com.example.patientsmvc.entites.Medecin;
import com.example.patientsmvc.entites.Patient;
import com.example.patientsmvc.repositories.MedecinRepository;
import com.example.patientsmvc.repositories.PatientRepository;
import com.example.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args
        );
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner commandLineRunner(MedecinRepository medecinRepository){
        return args -> {
            medecinRepository.save(new Medecin(null,"John",new Date(),"Neurochirurgien"));
            medecinRepository.save(new Medecin(null,"Sirin",new Date(),"Radiologist"));
            medecinRepository.save(new Medecin(null,"Boch3ayb",new Date(),"Pediatrician"));
            medecinRepository.findAll().forEach(m -> {
                System.out.println(m.getNom());
            });

        };
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,123));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),true,321));
            patientRepository.save(new Patient(null,"Hanae",new Date(),true,165));
            patientRepository.save(new Patient(null,"Yasmine",new Date(),false,132));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });

        };
    }



    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("yasmine","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");
            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("yasmine","USER");
            securityService.addRoleToUser("hassan","USER");

        };
    }

}
