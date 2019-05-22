package br.edu.utfpr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractDAO<T> extends JpaRepository<T, Integer> {

    T update(T t);

}
