package com.example.patientsmvc.repositories;

import com.example.patientsmvc.entites.Medecin;
import com.example.patientsmvc.entites.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Page<Medecin> findByNomContains(String kw, Pageable pageable);
}
