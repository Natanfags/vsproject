package com.example.demo.repository;

import com.example.demo.entity.StatusServicosNFE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface
StatusServicosRepository extends CrudRepository<StatusServicosNFE, Long> {

    List<StatusServicosNFE> findAllByData(LocalDateTime data);

    List<StatusServicosNFE> findAllByAutorizadorEquals(String estados);

    @Query("select * from StatusServicosNFE s " +
            "where s.status")
    StatusServicosNFE findStatusComIndisponibildadeMaior();
}
