package com.example.demo.repository;

import com.example.demo.entity.StatusServicosNFE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Sql(statements = {
        "insert into STATUSSERVICO(id, data, status, autorizador) values (1, '2012-09-17 18:47:52.069', 'VERDE', 'SP')"
})
public class StatusServicosRepositoryTest {

    @Autowired
    private StatusServicosRepository repository;

    @Test
    public void teste() {

        Optional<StatusServicosNFE> byId = repository.findById(1L);
        assertNotNull(byId);
    }
    //TODO implementar mais testes

}