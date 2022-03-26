package com.mattstansky.opticaltextrecognitionsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OTRApi {

    private OTRService otrService;
    private GraphicRepo graphicRepo;

    @Autowired
    public OTRApi (OTRService otrService, GraphicRepo graphicRepo) {
        this.otrService = otrService;
        this.graphicRepo = graphicRepo;
    }

    @PostMapping("/api/otr")
    public String doOTR(@RequestBody Graphic graphic) {
        String otr = otrService.doOTR(graphic.getUrl());
        graphic.setContent(otr);
        graphicRepo.save(graphic);
        return otr;
    }

    @GetMapping("/api/otr")
    public Iterable<Graphic> getGraphic() {
        return graphicRepo.findAll();
    }
}
