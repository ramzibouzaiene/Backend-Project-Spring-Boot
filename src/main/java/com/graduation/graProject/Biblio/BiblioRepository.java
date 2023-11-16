package com.graduation.graProject.Biblio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiblioRepository extends JpaRepository<BiblioEntity, Long> {
}
