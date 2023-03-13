package org.LaunchCode.codingeventsreview.data;

import org.LaunchCode.codingeventsreview.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// The CrudRepository class is parameterized and requires what type of object
// it will be storing and what type the primary key is (autoboxed)

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    // An interface doesn't have a constructor
    // Spring creates the class necessary to implement this interface
    // This is why we can have an object called eventRepository in the controller
    // Watch Chris Bay's video in chapter 17.3.2 for more details

}
