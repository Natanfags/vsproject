package com.example.demo.resource;

import com.example.demo.entity.dto.StatusServicosDTO;
import com.example.demo.entity.enums.Status;
import com.example.demo.service.StatusServicosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ExtractDataResource.class)
public class ExtractDataResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusServicosService service;

    @Test
    public void getStatusAtual() throws Exception {
        StatusServicosDTO statusServicosDTO = getStatusServicosDTO();

        when(service.findStatusAtualServicos()).thenReturn(Arrays.asList(statusServicosDTO));

        mockMvc.perform(get(path("/get-status-atual-servicos")))
                .andExpect(status().isOk());

        verify(service, times(1)).findStatusAtualServicos();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getStatusServiceosByEstado() throws Exception {

        StatusServicosDTO statusServicosDTO = getStatusServicosDTO();

        when(service.findStatusServicoByEstados(any())).thenReturn(Arrays.asList(statusServicosDTO));

        mockMvc.perform(get(path("/get-status-by-estado?estado=SP")))
                .andExpect(status().isOk());

        verify(service, times(1)).findStatusServicoByEstados(any());
    }

    @Test
    public void getStatusServicoByData() throws Exception {

        StatusServicosDTO statusServicosDTO = getStatusServicosDTO();


        when(service.findStatusByData(any())).thenReturn(Arrays.asList(statusServicosDTO));

        mockMvc.perform(get(path("/get-status-by-data?data=" + LocalDateTime.now())))
                .andExpect(status().isOk());

        verify(service, times(1)).findStatusByData(any());
    }

    @Test
    public void getSatusComMariorIndisponibilidade() throws Exception {

        StatusServicosDTO statusServicosDTO = getStatusServicosDTO();

//        when(service.getStatusComMarioIndisponibilidade()).thenReturn(statusServicosDTO);

        mockMvc.perform(get(path("/get-status-indisponibilidade-maior")))
                .andExpect(status().isOk());

//        verify(service, times(1)).getStatusComMarioIndisponibilidade();
    }

    private StatusServicosDTO getStatusServicosDTO() {
        StatusServicosDTO statusServicosDTO = new StatusServicosDTO();
        statusServicosDTO.setStatus(Status.VERDE);
        return statusServicosDTO;
    }

    String path(String url) {
        return "/api/status-servicos" + url;
    }
}