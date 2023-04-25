package com.unialfa.timefutebol.service;

import com.unialfa.timefutebol.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TimeService {

    private List<Time> times = new ArrayList<>();

    public void salvarTime(Time time) {
        if (Objects.isNull(time.getId())) {
            var novoId = Integer.valueOf(times.size() + 1);
            time.setId(novoId);
            times.add(time);
        } else {
            var oldTime = buscarPorId(time.getId());
            var index = times.indexOf(time);
            times.get(index).setNome(time.getNome());
            times.get(index).setAnoFundacao(time.getAnoFundacao());
            times.get(index).setEstado(time.getEstado());
            times.get(index).setTitulo(time.getTitulo());


        }
    }



    public List<Time> listarTodos() {
        return times;
    }

    public Time buscarPorId(Integer id) {
        var time = new Time();
        time.setId(id);

        var index = times.indexOf(time);
        if (index < 0) return null;
        return times.get(index);
    }

    public void remover(Time time){
        times.remove(time);
    }
}
