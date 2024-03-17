/* eslint-disable @typescript-eslint/no-explicit-any */
import { ToDoList } from './TodoList'

const anyTask = {
  title: 'any_title',
  description: 'any_description',
  targetDate: '01/01/2025',
  type: 'any_type',
  priority: '1',
  subTasks: []
}

describe('ToDoList', () => {
  describe('Testing add', () => {
    test('should add a new task to the list', () => {
      const todoInstance = new ToDoList()
      todoInstance.add(anyTask)
      const tasks = todoInstance.getTasks()
      expect(tasks).toEqual([anyTask])
    })

    test('should add a valid tasks', () => {
      const todoInstance = new ToDoList()
      const invalidValue: any = {
        invalidField: 'invalidValue'
      }
      todoInstance.add(invalidValue)
      const tasks = todoInstance.getTasks()
      expect(tasks).toEqual([])
    })
  })
})

describe('Update Task', () => {
  test('Should update a task', () => {
    const todoInstance = new ToDoList()
    todoInstance.add(anyTask)

    const newAnyTask = {
      title: 'Updated Any Task',
      description: 'any',
      targetDate: '01/12/25'
    }

    todoInstance.updateTask(0, newAnyTask)

    const tasks = todoInstance.getTasks()
    expect(tasks.length).toBe(1)
    expect(tasks[0].title).toBe(newAnyTask.title)
    expect(tasks[0].description).toBe(newAnyTask.description)
    expect(tasks[0].targetDate).toBe(newAnyTask.targetDate)
    expect(tasks[0].priority).toBe(anyTask.priority)
    expect(tasks[0].subTasks).toEqual(anyTask.subTasks)
  })
})

describe('Remove Task', () => {
  test('Should remove a task', () => {
    const todoInstance = new ToDoList()
    todoInstance.add(anyTask)

    todoInstance.removeTask(0)

    const tasks = todoInstance.getTasks()
    expect(tasks.length).toBe(0)
  })
})
