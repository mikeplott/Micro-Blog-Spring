package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 10/22/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
