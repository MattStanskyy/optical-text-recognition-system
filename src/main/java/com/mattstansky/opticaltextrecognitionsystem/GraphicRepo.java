package com.mattstansky.opticaltextrecognitionsystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicRepo extends CrudRepository<Graphic, Long> {

}
