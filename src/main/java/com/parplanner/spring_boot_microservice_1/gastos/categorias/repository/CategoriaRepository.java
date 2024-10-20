package com.parplanner.spring_boot_microservice_1.gastos.categorias.repository;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
