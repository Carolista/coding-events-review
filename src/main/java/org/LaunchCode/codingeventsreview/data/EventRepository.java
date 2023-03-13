package org.LaunchCode.codingeventsreview.data;

import org.LaunchCode.codingeventsreview.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// The CrudRepository class is parameterized and requires what type of object
// it will be storing and what type the primary key is (uses wrapper class, autoboxing)

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
