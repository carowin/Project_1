import React, { Component } from 'react'
import './App.css'
import axios from 'axios'


class App extends Component {
	//text=""
  constructor () {
    super()
    this.state = {
    	username: 'te'
  	}
  	this.handleClick = this.handleClick.bind(this)

  }

  /*handleClick () {
  console.log('Success!')
}*/

handleClick () {
  axios.delete('http://localhost:8080/TestServlet/Hello')
  	.then(response => {
        console.log(response.data);
        this.setState({username: response.data})
      })
}

  render () {
    return (

      <div className='button__container'>
        <button className='button' onClick={this.handleClick}>
          Click Me
        </button>
        <p>{this.state.username}</p>
      </div>
    )
  }
}



export default App;


/*import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}

export default App;*/
