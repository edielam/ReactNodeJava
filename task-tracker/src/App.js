import './App.css';
import Header from './components/Header';
import Tasks from './components/Tasks';
import {useState, useEffect} from 'react'
import AddTask from './components/AddTask';

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
// for passing functions to props
const deleteTask = async (id) => {
  await fetch(`http://localhost:5000/tasks/${id}`,{
    method: 'DELETE'
  })
  setTasks(tasks.filter((idx) => idx.id !== id))
}

const toggleReminder =(id) => {
  setTasks(tasks.map((task) => task.id === id 
  ? {...task, reminder: !task.reminder} : task))
}

// Add task
const addTask = (task) => {
  const id = Math.floor(Math.random() * 100000) + 1
  const newTask = {id, ...task}
  setTasks([...tasks, newTask])
}
  return (
    <div className="container">
      <Header onAdd={() => setShowAddTask(!showAddTask)} showAdd={showAddTask}/>
      {showAddTask && <AddTask onAdd ={addTask}/>}
      {tasks.length>0 ?(<Tasks tasks={tasks} 
      onDelete={deleteTask} onToggle={toggleReminder}/>):('No tasks to show')}
    
    </div>
  );
}

export default App;
