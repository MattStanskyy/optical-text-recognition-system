package com.mattstansky.opticaltextrecognitionsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OTRApi {

    private OTRService otrService;
    private List<Graphic> graphicList;

    @Autowired
    public OTRApi (OTRService otrService) {
        this.otrService = otrService;
        this.graphicList = new ArrayList<>();
    }

    @PostMapping("/api/otr")
    public String doOTR(@RequestBody Graphic graphic) {
        String otr = otrService.doOTR(graphic.getUrl());
        graphic.setContent(otr);
        graphicList.add(graphic);
        return otr;
    }

    @GetMapping("/api/otr")
    public List<Graphic> getGraphic() {
        return  graphicList;
    }
}
