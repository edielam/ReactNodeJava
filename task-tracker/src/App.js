import './App.css';
import Header from './components/Header';
import Tasks from './components/Tasks';
import {useState, useEffect} from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AddTask from './components/AddTask';
import Footer from './components/Footer';
import About from './components/About';

function App() {
  const [showAddTask, setShowAddTask] = useState(false)
  const [tasks, setTasks] =useState([])

  useEffect(() => {
    const getTasks = async () => {
      const tasksFromServer = await fetchTasks()
      setTasks(tasksFromServer)
    }
    getTasks()
  }, [])

  const fetchTasks = async () => {
    const res = await fetch('http://localhost:5000/tasks')
    const data = await res.json()

    return data
  }

  const fetchTask = async (id) => {
    const res = await fetch(`http://localhost:5000/tasks/${id}`)
    const data = await res.json()

    return data
  }
// for passing functions to props
const deleteTask = async (id) => {
  await fetch(`http://localhost:5000/tasks/${id}`,{
    method: 'DELETE'
  })
  setTasks(tasks.filter((idx) => idx.id !== id))
}

const toggleReminder = async (id) => {
  const taskToToggle = await fetchTask(id)
  const upDatedTask = {...taskToToggle, 
  reminder: !taskToToggle.reminder}

  const res = await fetch(`http://localhost:5000/tasks/${id}`, {
    method: 'PUT',
    headers: {
      'Content-type': 'application/json'
    },
    body: JSON.stringify(upDatedTask),
  })
  const data = await res.json()

  setTasks(tasks.map((task) => task.id === id 
  ? {...task, reminder: data.reminder} : task))
}

// Add task
const addTask = async (task) => {
  const res = await fetch('http://localhost:5000/tasks', {
    method: 'POST',
    headers: {
      'Content-type': 'application/json'
    },
    body: JSON.stringify(task)
  })
  const data = await res.json()
  setTasks([...tasks, data])
  // const id = Math.floor(Math.random() * 100000) + 1
  // const newTask = {id, ...task}
  // setTasks([...tasks, newTask])
}
  return (
      <div className="container">
        <Header onAdd={() => setShowAddTask(!showAddTask)} showAdd={showAddTask}/>
        {showAddTask && <AddTask onAdd ={addTask}/>}
        {tasks.length>0 ?(<Tasks tasks={tasks} 
        onDelete={deleteTask} onToggle={toggleReminder}/>):('No tasks to show')}
        <Footer/>
      </div>
  );
}

export default App;
