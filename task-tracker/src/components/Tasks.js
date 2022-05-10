import React from 'react'
import Task from './Task'

const Tasks = ({tasks}) => {
   return (
     <>
     {tasks.map((idx)=> (<Task key={idx.id} idx={idx}/>))}
     </>
   )
 }
 
 export default Tasks