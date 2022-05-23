import { Link } from "react-router-dom"

const About = () => {   
  return (
    <div className="container">
        <center>
        <div className="header">
            <h1>Task Tracker</h1>
        </div>
        <h4>Version 1.0.4</h4>
        <Link to="/">Go back</Link>
        </center>
  </div>
  )
}

export default About