package com.example.demo.repository;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.dto.DashboardStatusServicosDTO;
import com.example.demo.entity.dto.EstadoIndisponibilidadeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface
StatusServicosRepository extends CrudRepository<StatusServicosNFE, Long> {

    @Query("select distinct autorizador from StatusServicosNFE")
    List<String> findAllStadosDisponiveis();

    @Query(nativeQuery = true, value = "select * from STATUSSERVICO s" +
            " where s.")
    List<StatusServicosNFE> findAllByData(LocalDateTime data);

    List<StatusServicosNFE> findAllByAutorizadorEquals(String estados);

    @Query(nativeQuery = true, value = "select count(*) as countstatusvermelho, " +
            " autorizador as estado" +
            " from STATUSSERVICO " +
            " where status = 'VERMELHA'")
    EstadoIndisponibilidadeDTO findStatusComIndisponibildadeMaior();

    @Query(nativeQuery = true, value = "select distinct s.autorizador as estados," +
            " sum(case when status = 'VERMELHA' then 1 else 0 end) as statusvermelho " +
            " sum(case when status = 'VERDE' then 1 else 0 end) as statusVerde " +
            " sum(case when status = 'AMARELA' then 1 else 0 end) as statusAmarelo " +
            " from STATUSSERVICO s")
    List<DashboardStatusServicosDTO> getAllStatusServicos();
}
