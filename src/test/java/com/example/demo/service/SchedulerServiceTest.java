package com.example.demo.service;

import com.example.demo.entity.StatusServicosNFE;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SchedulerServiceTest {

    private SchedulerService schedulerService;

    @Mock
    private StatusServicosService statusServicosServiceMock;

    @Before
    public void setup() {
        schedulerService = new SchedulerService(statusServicosServiceMock);
        schedulerService.setStatusServicosService(statusServicosServiceMock);
    }

    @Test
    public void deveVericarRotinaScheduler() {

        when(statusServicosServiceMock.createServicosFromUrl()).thenReturn(Arrays.asList(StatusServicosNFE.builder().build()));
        schedulerService.salvarStatusACadaCincoMinutos();
        verify(statusServicosServiceMock, times(1)).createServicosFromUrl();
    }
}