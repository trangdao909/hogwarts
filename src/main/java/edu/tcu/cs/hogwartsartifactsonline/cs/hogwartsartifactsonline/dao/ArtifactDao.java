package edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.dao;

import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.domain.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
// extends JpaRepository past Artifact and type of ID (String)
// Spring Boot reduce all Query for SQL in DAO that we did in last demo
public interface ArtifactDao extends JpaRepository<Artifact, String> {

}
