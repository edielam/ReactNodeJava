import React from 'react'
import Button from './Button'
import PropTypes from 'prop-types'

const Header = ({title, onAdd, showAdd}) => {
    // const onClick = () =>{
    //     console.log("Hey!")
    // }
    return (
        <div className='header'>
            <h1>{title}</h1>
            <Button color={showAdd ? 'red' : 'green'} text={showAdd ? 'Close' : 'Add'} onClick={onAdd}/>
        </div>
  )
}
Header.defaultProps ={
    title: 'Task Tracker',
}
// using proptypes helps make code more robust
//for catching some errors
Header.propTypes ={
    title: PropTypes.string,
}

export default Header