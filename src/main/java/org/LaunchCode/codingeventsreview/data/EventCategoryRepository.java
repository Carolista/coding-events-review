package org.LaunchCode.codingeventsreview.data;

import org.LaunchCode.codingeventsreview.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {
}
