package com.cmepps.listatareas.driven_ports;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmepps.listatareas.Entity.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository < Todo, Long > {
List < Todo > findByUserName(String user);
}
