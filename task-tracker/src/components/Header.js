import React from 'react'
import Button from './Button'
import PropTypes from 'prop-types'

const Header = ({title}) => {
    const onClick = () =>{
        console.log("Hey!")
    }
    return (
        <div className='header'>
            <h1>{title}</h1>
            <Button color={'green'} text={'Add'} onClick={onClick}/>
        </div>
  )
}
Header.defaultProps ={
    title: 'Task tracker',
}
// using proptypes helps make code more robust
//for catching some errors
Header.propTypes ={
    title: PropTypes.string,
}

export default Header