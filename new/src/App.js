import logo from './logo.svg';
import './App.css';
import { Component } from 'react';


class App extends Component {
  constructor(props){
    console.log('constructor');
    super(props);
    this.state = {count:0};
  }

  handleClick(){
    this.setState({count:this.state.count+1});
  }
  componentDidMount(){
    console.log("componentDidMount");
  }

  componentDidUpdate(){
    console.log("componentDidUpdate");
  }

  shouldComponentUpdate(props,newState){
    if(newState.count%3 == 0){
      return true;
    }else{
      return false;
    }
 }

  render() {
    return (
      <div className="App">
        <button onClick = {this.handleClick.bind(this)}>Click Me</button>
        <br/>{this.state.count}
      </div>
    );
  }
  }
  

export default App;
