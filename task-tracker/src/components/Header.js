import React from 'react'
import Button from './Button'

const Header = () => {
  return (
    <div className='header'>
        <h1>Task Tracker</h1>
        <Button color={'green'} text={'Hello'}/>
    </div>
  )
}

export default Header