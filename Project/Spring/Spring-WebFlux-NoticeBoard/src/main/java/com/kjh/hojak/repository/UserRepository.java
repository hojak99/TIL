package com.kjh.hojak.repository;

import com.kjh.hojak.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    /**
     * writerId 로 User 찾는 메소드. (언더바는 인식 못하는 것 같다.)
     *
     * @param writerId
     * @return
     */
    Mono<User> findByWriterId(Mono<String> writerId);


    /**
     * writerId 로 User 찾는 메소드. (언더바는 인식 못하는 것 같다.)
     *
     * @param writerId
     * @return
     */
    Mono<User> findByWriterId(String writerId);
}
