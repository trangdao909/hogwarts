package edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional // make every method defined in this file to be transactional
public class ArtifactService {
    private ArtifactDao artifactDao;
    private IdWorker idWorker;
    // Inject beans
    // Spring will automatically inject instance of ArtifactDao and IdWorker to this class
    public ArtifactService(ArtifactDao artifactDao, IdWorker idWorker) {
        this.artifactDao = artifactDao;
        this.idWorker = idWorker;
    }

    public List<Artifact> findAll(){
        return artifactDao.findAll();
    }
    public Artifact findById (String artifactId){
        // get will return right type
        return artifactDao.findById(artifactId).get();
    }

    public void save(Artifact newArtifact) {
        newArtifact.setId(idWorker.nextId() + "");
        artifactDao.save(newArtifact);
    }


    public void update(String artifactId, Artifact updatedArtifact) {
        updatedArtifact.setId(artifactId);
        // hibernate will know artifact data saved is new or existing one
        artifactDao.save(updatedArtifact);

    }

    public void delete(String artifactId) {
        artifactDao.deleteById(artifactId);
    }
}
