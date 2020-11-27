package com.example.demo.repository;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.dto.DashboardStatusServicosDTO;
import com.example.demo.entity.dto.EstadoIndisponibilidadeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatusServicosRepository extends CrudRepository<StatusServicosNFE, Long> {

    @Query("select distinct autorizador from StatusServicosNFE")
    List<String> findAllStadosDisponiveis();

    @Query(nativeQuery = true, value = "select * from STATUSSERVICO s" +
            " where s.")
    List<StatusServicosNFE> findAllByData(LocalDateTime data);

    List<StatusServicosNFE> findAllByAutorizadorEquals(String estados);

    @Query("select new com.example.demo.entity.dto.EstadoIndisponibilidadeDTO(count(s) as countstatusvermelho, " +
            " s.autorizador as estado )" +
            " from StatusServicosNFE s " +
            " where s.status = 'VERMELHA'")
    EstadoIndisponibilidadeDTO findStatusComIndisponibildadeMaior();


    @Query("select distinct new com.example.demo.entity.dto.DashboardStatusServicosDTO(s.autorizador as estados," +
            " sum(case when s.status = 'VERDE' then 1 else 0 end) as statusVerde, " +
            " sum(case when s.status = 'VERMELHA' then 1 else 0 end) as statusvermelho, " +
            " sum(case when s.status = 'AMARELA' then 1 else 0 end) as statusAmarelo )" +
            " from StatusServicosNFE s group by s.autorizador")
    List<DashboardStatusServicosDTO> getAllStatusServicos();
}
