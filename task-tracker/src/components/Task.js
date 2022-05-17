import React from 'react'
import {FaTimes} from 'react-icons/fa'

//for assigning value to props
const Task = ({idx, onDelete, onToggle}) => {
  return (
    <div 
    className= {`task ${idx.reminder ? 'reminder' : ''}`} 
    onDoubleClick={() => onToggle(idx.id)}>
        <h3>{idx.text}<FaTimes 
        style={{color:'red', cursor:'pointer'}} onClick={() => onDelete(idx.id)}/></h3>
        <p>{idx.day}</p>
    </div>
  )
}

export default Task