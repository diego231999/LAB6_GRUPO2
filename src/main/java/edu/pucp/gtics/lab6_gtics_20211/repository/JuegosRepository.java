package edu.pucp.gtics.lab6_gtics_20211.repository;

import edu.pucp.gtics.lab6_gtics_20211.entity.Juegos;
import edu.pucp.gtics.lab6_gtics_20211.entity.JuegosUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface JuegosRepository extends JpaRepository<Juegos,Integer> {
    @Query(value = "select j.nombre as nombre, j.descripcion as descripcion, j.image as imageurl, j.idgenero as genero  from juegos j, usuarios u, juegosxusuario ju where j.idjuego=ju.idjuego and u.idusuario=ju.idusuario and u.idusuario=?1",nativeQuery = true)
    List<JuegosUserDto> obtenerJuegosPorUser(int idusuario);
}
