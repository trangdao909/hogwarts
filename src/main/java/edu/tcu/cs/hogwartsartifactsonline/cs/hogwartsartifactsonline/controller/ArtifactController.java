package edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.controller;

import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.domain.StatusCode;
import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.service.ArtifactService;
import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.domain.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artifacts") // Save time, no need "/arfifacts/..."
 public class ArtifactController {
    private ArtifactService artifactService;
    // must have constructor for Spring to inject instance to this class
    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAll(){
        List<Artifact> all = artifactService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS,"Find All Success", all );
        return result; // Spring Boot automatic serialize result to Json
    }

    @GetMapping("/{artifactId}")
    // @PathVariable String -> save id to the variable as String
    public Result findById(@PathVariable String artifactId){
        return new Result(true, StatusCode.SUCCESS,"Find One success", artifactService.findById(artifactId));
    }

    @PostMapping
    public Result save(@RequestBody Artifact newArtifact){
        // built in data binder: @RequestBody
        artifactService.save(newArtifact);
        return new Result(true, StatusCode.SUCCESS, "Save Success");

    }

    @PutMapping("/{artifactId}")
    public Result update(@PathVariable String artifactId, @RequestBody Artifact updatedArtifact){
        artifactService.update(artifactId, updatedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Update Success");

    }

    @DeleteMapping("/{artifactId}")
    public Result delete(@PathVariable String artifactId){
        artifactService.delete(artifactId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");

    }

}
