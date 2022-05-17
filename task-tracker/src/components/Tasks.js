import React from 'react'
import Task from './Task'

//for defining props
const Tasks = ({tasks, onDelete, onToggle}) => {
   return (
     <>
     {tasks.map((idx)=> (<Task key={idx.id} idx={idx}
     onDelete={onDelete} onToggle={onToggle}/>))}
     </>
   )
 }
 
 export default Tasks