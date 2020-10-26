package pl.pjatk.skmclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.skmclient.model.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SkmReader {
    private final String trainURI = "http://localhost:4000/train";
    RestTemplate template = new RestTemplate();


    @GetMapping("/")
    public String status() {
        List<Integer> result = Arrays.asList(template.getForObject(trainURI, Integer[].class));
        StringBuilder builder = new StringBuilder("");

        result.forEach(id -> {
            builder.append("<a href='/%d'>Train id: %d</a><br>".formatted(id, id));
        });

        return builder.toString();
    }

    @GetMapping("/{id}")
    public String train(@PathVariable("id")int id){
        String result = template.getForObject(trainURI+"/"+id, String.class);
        String sections = template.getForObject(trainURI+"/"+id, String.class);
//        List<Integer> sections = Arrays.asList(template.getForObject(trainURI+"/"+id+"/section", Integer[].class));
        return result;
    }

}

