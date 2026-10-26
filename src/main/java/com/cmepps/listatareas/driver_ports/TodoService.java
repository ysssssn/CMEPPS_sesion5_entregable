package com.cmepps.listatareas.driver_ports;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cmepps.listatareas.Entity.Todo;
import com.cmepps.listatareas.driven_ports.TodoRepository;

@Service
public class TodoService implements ITodoService {

	private final TodoRepository todoRepository;

	TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List < Todo > getTodosByUser(String user) {
		return todoRepository.findByUserName(user);
	}

	@Override
	public Optional < Todo > getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoRepository.save(new Todo(name, desc, targetDate, isDone));
	}

	@Override
	public void deleteTodo(long id) {
		Optional < Todo > todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}

	@Override
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}
}
