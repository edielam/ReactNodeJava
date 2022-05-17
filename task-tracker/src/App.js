import './App.css';
import Header from './components/Header';
import Tasks from './components/Tasks';
import {useState} from 'react'

function App() {
  const [tasks, setTasks] =useState([
    {
    "id": 1,
    "text": "Doctors Appointment",
    "day": "Feb 5th at 2:30pm",
    "reminder": true
    },
    {
    "id": 2,
    "text": "Meeting at School",
    "day": "Feb 6th at 1:30pm",
    "reminder": true
    },
    {
    "id": 3,
    "text": "Parents meeting at farm",
    "day": "Feb 7th at 1:30pm",
    "reminder": true
    }
])
// for passing functions to props
const deleteTask = (id) => {
  setTasks(tasks.filter((idx) => idx.id !== id))
}

const toggleReminder =(id) => {
  setTasks(tasks.map((task) => task.id === id 
  ? {...task, reminder: !task.reminder} : task))
}
  return (
    <div className="container">
      <Header/>
      {tasks.length>0 ?(<Tasks tasks={tasks} 
      onDelete={deleteTask} onToggle={toggleReminder}/>):('No tasks to show')}
    </div>
  );
}

export default App;
