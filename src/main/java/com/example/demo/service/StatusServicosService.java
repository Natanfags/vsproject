package com.example.demo.service;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.enums.Status;
import com.example.demo.repository.StatusServicosRepository;
import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StatusServicosService {

    private final StatusServicosRepository statusServicosRepository;

    private final CreateConectionService createConectionService;

    public List<StatusServicosNFE> findStatusAtualServicos() {
        return this.createServicosFromUrl();
    }

    public List<StatusServicosNFE> createServicosFromUrl() {
        Document doc = createConectionService.getDoc();
        List<StatusServicosNFE> statusServicosNFES = new ArrayList<>();

        Elements select = doc.select("#ctl00_ContentPlaceHolder1_gdvDisponibilidade2 > tbody");
        Elements tbody = select.get(0).getElementsByTag("tbody");
        Element firstTbody = tbody.stream().findFirst().orElse(null);

        int i = 1;
        while (i <= 15) {
            StatusServicosNFE statusServicosNFE = new StatusServicosNFE();

            Element elEstadosAndStatus = Objects.requireNonNull(firstTbody).child(i);
            String estadoFromElement = elEstadosAndStatus.getElementsByTag("td").get(0).text();

            setStatus(statusServicosNFE, elEstadosAndStatus);
            statusServicosNFE.setData(LocalDateTime.now());
            statusServicosNFE.setAutorizador(extrairAutorizadorFromElement(estadoFromElement));
            statusServicosNFES.add(statusServicosNFE);
            i++;
        }

        return statusServicosNFES;
    }

    public void saveAll(List<StatusServicosNFE> statusServicosNFES) {
        this.statusServicosRepository.saveAll(statusServicosNFES);
    }

    public List<StatusServicosNFE> findStatusServicoByEstados(String estado) {
        return this.statusServicosRepository.findAllByAutorizadorEquals(estado);
    }

    public List<StatusServicosNFE> findStatusByData(LocalDateTime data) {
        return statusServicosRepository.findAllByData(data);
    }

    public StatusServicosNFE getStatusComMarioIndisponibilidade() {
        return statusServicosRepository.findStatusComIndisponibildadeMaior();
    }

    private void setStatus(StatusServicosNFE statusServicosNFE, Element elEstadosAndStatus) {
        int indiceStatusServicoFromUrl = 5;
        Element el = elEstadosAndStatus.getElementsByTag("td").get(indiceStatusServicoFromUrl).child(0);
        String src = el.attr("src");

        if (src.contains(Status.VERDE.getDescricao())) {
            statusServicosNFE.setStatus(Status.VERDE);
        } else if (src.contains(Status.AMARELA.getDescricao())) {
            statusServicosNFE.setStatus(Status.AMARELA);
        } else {
            statusServicosNFE.setStatus(Status.VERMELHA);
        }
    }

    private String extrairAutorizadorFromElement(String autorizador) {
        return autorizador.replaceAll("<td>|</td>", "");
    }
}
