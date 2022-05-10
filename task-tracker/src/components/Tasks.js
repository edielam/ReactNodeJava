import React from 'react'

const Tasks = ({tasks}) => {
   return (
     <>
     {tasks.map((idx)=> (<h2 key={idx.id}>{idx.text}</h2>))}
     </>
   )
 }
 
 export default Tasks