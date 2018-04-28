package com.kjh.hojak.repository;

import org.springframework.stereotype.Repository;

import com.kjh.hojak.model.Tweet;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

@Repository
public class TweetRepository implements ReactiveMongoRepository<Tweet, String>{

	@Override
	public Flux<Tweet> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(Tweet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Iterable<? extends Tweet> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Publisher<? extends Tweet> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(Publisher<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(Publisher<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Tweet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Tweet> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Tweet> findAllById(Publisher<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Tweet> findById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Tweet> findById(Publisher<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Mono<S> save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> saveAll(Publisher<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Mono<Long> count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Mono<Boolean> exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Mono<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Mono<S> insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> Flux<S> insert(Publisher<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
