import logo from './logo.svg';
import './App.css';
import Header from './components/Header';

function App() {
  const name = " Ed"
  return (
    <div className="App">
      <h1>Hello from React</h1>
      <h2>Hello {1+1 + name}</h2>
      <Header/>
    </div>
  );
}

export default App;
