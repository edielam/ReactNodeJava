import React from 'react'

const Task = ({idx}) => {
  return (
    <div className='task'>
        <h3>{idx.text}</h3>
        <p>{idx.day}</p>
    </div>
  )
}

export default Task