package com.igueyetraining.helloworldrestapis.web.rest;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igueyetraining.helloworldrestapis.domain.User;
import com.igueyetraining.helloworldrestapis.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserApi{

	//Test comment #6
	@Autowired
	private UserService userService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		log.info("createUser requested.... ");
		return userService.saveOrUpdate(user.getUsername(), user);
	}
	
    @GetMapping
    public Collection<User> getAllUsers(){
		log.info("getAllUsers requested.... ");
        return userService.findAll();
    }
	
	@GetMapping("/{loginName}")
	public ResponseEntity<User> getUserByLoginName(@PathVariable String loginName){
		log.info("getUserByLoginName for loginName : " + loginName);

		return Optional
            .ofNullable( userService.find(loginName) )
            .map( user -> ResponseEntity.ok().body(user) )          //200 OK
            .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
	}
	
/* 	@PutMapping
	public Mono<ResponseEntity<UserForRedisPoc>> updateUserForRedisPoc(@RequestBody UserForRedisPoc userForRedis) {
		log.info("updateUserForRedisPoc requested.... ");
		return userService.saveOrUpdate(userForRedis.getUsername(),  userForRedis)
				 .map(ResponseEntity::ok)
	                .defaultIfEmpty(ResponseEntity.badRequest().build());
	} */

	@DeleteMapping("/{loginName}")
	public ResponseEntity<Void> deleteUserByLoginName(@PathVariable String loginName){
		log.info("deleteUserByLoginName for loginName : " + loginName);
		userService.delete(loginName);
		return ResponseEntity.noContent().build();
/* 		return Optional
            .ofNullable( userService.delete(loginName) )
            .map( user -> ResponseEntity.noContent().build() )          //200 OK
            .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found */
	}
	
}
