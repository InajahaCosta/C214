/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { ToDoList } from './TodoList'
import { Task, UpdateTask } from '../models/Task'
import { TodoListRepository } from '../repository/TodoListRepository'

const anyTask: Task = {
  id: 1,
  title: 'any_title',
  description: 'any_description',
  targetDate: '01/01/2025',
  type: 'any_type',
  priority: '1',
  subTasks: []
}

const makeRepositoryStub = (): TodoListRepository => {
  class TodoListStub implements TodoListRepository {
    create (task: Task) {
      return {
        success: true,
        error: null
      }
    }

    getAll () {
      return {
        success: [anyTask],
        error: null
      }
    }

    update (task: UpdateTask) {
      return {
        success: true,
        error: null
      }
    }

    delete (id: number) {
      return {
        success: true,
        error: null
      }
    }
  }
  return new TodoListStub()
}

describe('ToDoList', () => {
  describe('Testing add', () => {
    test('should add a new task to the list', () => {
      const repositoryStub = makeRepositoryStub()
      const todoInstance = new ToDoList(repositoryStub)
      todoInstance.add(anyTask)
      const tasks = todoInstance.getTasks()
      expect(tasks).toEqual([anyTask])
    })

    test('should add a valid tasks', () => {
      const repositoryStub = makeRepositoryStub()
      const todoInstance = new ToDoList(repositoryStub)
      const invalidValue: any = {
        invalidField: 'invalidValue'
      }
      const response = todoInstance.add(invalidValue)
      expect(response).toEqual('Missing properties in task object')
    })
  })

  describe('getTasks', () => {
    test('should initialize tasks with an empty array', () => {
      const repositoryStub = makeRepositoryStub()
      jest.spyOn(repositoryStub, 'getAll').mockReturnValueOnce({
        success: [],
        error: null
      })
      const todoInstance = new ToDoList(repositoryStub)
      const response = todoInstance.getTasks()
      expect(response).toEqual([])
    })
  })
})
